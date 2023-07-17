package pl.sebastiancielma.MyAeroclub.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sebastiancielma.MyAeroclub.cart.model.Cart;
import pl.sebastiancielma.MyAeroclub.cart.repository.CartItemRepository;
import pl.sebastiancielma.MyAeroclub.cart.repository.CartRepository;
import pl.sebastiancielma.MyAeroclub.common.mail.EmailClientService;
import pl.sebastiancielma.MyAeroclub.order.model.Order;
import pl.sebastiancielma.MyAeroclub.order.model.Payment;
import pl.sebastiancielma.MyAeroclub.order.model.Shipment;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderDto;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderListDto;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderSummary;
import pl.sebastiancielma.MyAeroclub.order.repository.OrderRepository;
import pl.sebastiancielma.MyAeroclub.order.repository.OrderRowRepository;
import pl.sebastiancielma.MyAeroclub.order.repository.PaymentRepository;
import pl.sebastiancielma.MyAeroclub.order.repository.ShipmentRepository;

import java.util.List;

import static pl.sebastiancielma.MyAeroclub.order.service.mapper.OrderDtoMapper.mapToOrderListDto;
import static pl.sebastiancielma.MyAeroclub.order.service.mapper.OrderEmailMessageMapper.createEmailMessage;
import static pl.sebastiancielma.MyAeroclub.order.service.mapper.OrderMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRowRepository orderRowRepository;
    private final ShipmentRepository shipmentRepository;
    private final PaymentRepository paymentRepository;
    private final EmailClientService emailClientService;

    @Transactional
    public OrderSummary placeOrder(OrderDto orderDto, Long userId) {
        Cart cart = cartRepository.findById(orderDto.getCartId()).orElseThrow();
        Shipment shipment = shipmentRepository.findById(orderDto.getShipmentId()).orElseThrow();
        Payment payment = paymentRepository.findById(orderDto.getPaymentId()).orElseThrow();
        Order newOrder = orderRepository.save(createNewOrder(orderDto, cart, shipment, payment, userId));
        saveOrderRows(cart, newOrder.getId(), shipment);
        clearOrderCart(orderDto);
        sendConfirmEmail(newOrder);
        return createOrderSummary(payment, newOrder);
    }

    private void sendConfirmEmail(Order newOrder) {
        emailClientService.getInstance()
                .send(newOrder.getEmail(),
                        "\n" +
                                "Your order has been received",
                        createEmailMessage(newOrder));
    }

    private void clearOrderCart(OrderDto orderDto) {
        cartItemRepository.deleteByCartId(orderDto.getCartId());
        cartRepository.deleteCartById(orderDto.getCartId());
    }

    private void saveOrderRows(Cart cart, Long orderId, Shipment shipment) {
        saveProductRows(cart, orderId);
        saveShipmentRow(orderId, shipment);
    }

    private void saveShipmentRow(Long orderId, Shipment shipment) {
        orderRowRepository.save(mapToOrderRow(orderId, shipment));
    }

    private void saveProductRows(Cart cart, Long orderId) {
        cart.getItems().stream()
                .map(cartItem -> mapToOrderRowWithQuantity(orderId, cartItem)
                )
                .peek(orderRowRepository::save)
                .toList();
    }

    public List<OrderListDto> getOrdersForCustomer(Long userId) {
        return mapToOrderListDto(orderRepository.findByUserId(userId));
    }

}
