package pl.sebastiancielma.MyAeroclub.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import pl.sebastiancielma.MyAeroclub.order.model.dto.InitOrder;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderDto;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderListDto;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderSummary;
import pl.sebastiancielma.MyAeroclub.order.service.OrderService;
import pl.sebastiancielma.MyAeroclub.order.service.PaymentService;
import pl.sebastiancielma.MyAeroclub.order.service.ShipmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ShipmentService shipmentService;
    private final PaymentService paymentService;

    @PostMapping
    public OrderSummary placeOrder(@RequestBody OrderDto orderDto, @AuthenticationPrincipal Long userId) {
        return orderService.placeOrder(orderDto, userId);
    }

    @GetMapping("/initData")
    public InitOrder initData(@AuthenticationPrincipal String name) {
        return InitOrder.builder()
                .shipment(shipmentService.getShipments())
                .payment(paymentService.getPayments())
                .build();
    }
    @GetMapping
    public List<OrderListDto> getOrders(@AuthenticationPrincipal Long userId){
        if(userId == null){
            throw new IllegalArgumentException("user does not exist");
        }
        return orderService.getOrdersForCustomer(userId);
    }


}
