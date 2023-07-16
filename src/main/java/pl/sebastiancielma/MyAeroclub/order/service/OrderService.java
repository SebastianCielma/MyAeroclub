package pl.sebastiancielma.MyAeroclub.order.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sebastiancielma.MyAeroclub.order.model.Order;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderDto;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderSummary;

@Service
public class OrderService {
    private final Cart
    @Transactional
    public OrderSummary placeOrder(OrderDto orderDto) {
        Cart cart = cartRepository.findById(orderDto.getCartId()).orElseThrow();
        Shipment shipment = shipmentRepository.findById(orderDto.getShipmentId()).orElseThrow();
        Payment payment = paymentRepository.findById(orderDto.getPaymentId()).orElseThrow();
        Order newOrder = orderRepository.save(createNewOrder(orderDto, cart, shipment, payment));
        saveOrderRows(cart, newOrder.getId(), shipment);
        clearOrderCart(orderDto);
        sendConfirmEmail(newOrder);
        return createOrderSummary(payment, newOrder);
    }
}
