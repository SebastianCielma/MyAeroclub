package pl.sebastiancielma.MyAeroclub.order.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sebastiancielma.MyAeroclub.cart.model.Cart;
import pl.sebastiancielma.MyAeroclub.cart.model.CartItem;
import pl.sebastiancielma.MyAeroclub.cart.repository.CartItemRepository;
import pl.sebastiancielma.MyAeroclub.cart.repository.CartRepository;
import pl.sebastiancielma.MyAeroclub.common.mail.EmailClientService;
import pl.sebastiancielma.MyAeroclub.common.mail.FakeEmailService;
import pl.sebastiancielma.MyAeroclub.common.model.Airplane;
import pl.sebastiancielma.MyAeroclub.common.model.OrderStatus;
import pl.sebastiancielma.MyAeroclub.order.model.Payment;
import pl.sebastiancielma.MyAeroclub.order.model.PaymentType;
import pl.sebastiancielma.MyAeroclub.order.model.Shipment;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderDto;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderSummary;
import pl.sebastiancielma.MyAeroclub.order.repository.OrderRepository;
import pl.sebastiancielma.MyAeroclub.order.repository.OrderRowRepository;
import pl.sebastiancielma.MyAeroclub.order.repository.PaymentRepository;
import pl.sebastiancielma.MyAeroclub.order.repository.ShipmentRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {
    @Mock
    private CartRepository cartRepository;
    @Mock
    private ShipmentRepository shipmentRepository;
    @Mock
    private PaymentRepository paymentRepository;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderRowRepository orderRowRepository;
    @Mock
    private CartItemRepository cartItemRepository;
    @Mock
    private EmailClientService emailSender;
    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldPlaceOrder() {

        OrderDto orderDto = createOrderDto();
        when(cartRepository.findById(any())).thenReturn(createCart());
        when(shipmentRepository.findById(any())).thenReturn(createShipment());
        when(paymentRepository.findById(any())).thenReturn(createPayment());
        when(orderRepository.save(any())).thenAnswer(invocation -> invocation.getArguments()[0]);
        when(emailSender.getInstance()).thenReturn(new FakeEmailService());
        Long userId=1L;

        OrderSummary orderSummary = orderService.placeOrder(orderDto,userId);

        assertThat(orderSummary).isNotNull();
        assertThat(orderSummary.getStatus()).isEqualTo(OrderStatus.NEW);
        assertThat(orderSummary.getGrossValue()).isEqualTo(new BigDecimal("64.44"));
        assertThat(orderSummary.getPayment().getType()).isEqualTo(PaymentType.BANK_TRANSFER);
        assertThat(orderSummary.getPayment().getName()).isEqualTo("test payment");
        assertThat(orderSummary.getPayment().getId()).isEqualTo(1L);

    }
    private Optional<Payment> createPayment() {
        return Optional.of(
                Payment.builder()
                        .id(1L)
                        .name("test payment")
                        .type(PaymentType.BANK_TRANSFER)
                        .defaultPayment(true)
                        .build()
        );
    }
    private Optional<Shipment> createShipment() {
        return Optional.of(
                Shipment.builder()
                        .id(2L)
                        .price(new BigDecimal("20.00"))
                        .defaultShipment(true)
                        .build()
        );
    }


    private Optional<Cart> createCart() {
        return Optional.of(Cart.builder()
                .id(1L)
                .created(LocalDateTime.now())
                .items(createItems())
                .build());
    }

    private List<CartItem> createItems() {
        return List.of(
                CartItem.builder()
                        .id(1L)
                        .cartId(1L)
                        .quantity(1)
                        .airplane(Airplane.builder()
                                .id(1L)
                                .price(new BigDecimal("22.22"))
                                .build())
                        .build(),
                CartItem.builder()
                        .id(2L)
                        .cartId(1L)
                        .quantity(1)
                        .airplane(Airplane.builder()
                                .id(2L)
                                .price(new BigDecimal("22.22"))
                                .build())
                        .build()
        );

    }

    private OrderDto createOrderDto() {
        return OrderDto.builder()
                .firstname("firstname")
                .lastname("lastname")
                .street("street")
                .zipcode("zipcode")
                .city("city")
                .email("email")
                .phone("phone")
                .cartId(1L)
                .shipmentId(2L)
                .paymentId(3L)
                .build();
    }


}