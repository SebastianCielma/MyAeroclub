package pl.sebastiancielma.MyAeroclub.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sebastiancielma.MyAeroclub.order.model.dto.InitOrder;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderDto;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderSummary;
import pl.sebastiancielma.MyAeroclub.order.service.OrderService;
import pl.sebastiancielma.MyAeroclub.order.service.PaymentService;
import pl.sebastiancielma.MyAeroclub.order.service.ShipmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ShipmentService shipmentService;
    private final PaymentService paymentService;

    @PostMapping
    public OrderSummary placeOrder(@RequestBody OrderDto orderDto) {
        return orderService.placeOrder(orderDto);
    }

    @GetMapping("/initData")
    public InitOrder initData() {
        return InitOrder.builder()
                .shipment(shipmentService.getShipments())
                .payment(paymentService.getPayments())
                .build();
    }
}
