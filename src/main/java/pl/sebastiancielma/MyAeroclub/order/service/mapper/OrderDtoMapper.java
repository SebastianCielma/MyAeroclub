package pl.sebastiancielma.MyAeroclub.order.service.mapper;

import pl.sebastiancielma.MyAeroclub.order.model.Order;
import pl.sebastiancielma.MyAeroclub.order.model.dto.OrderListDto;

import java.util.List;

public class OrderDtoMapper {
    public static List<OrderListDto> mapToOrderListDto(List<Order> orders) {
        return orders.stream()
                .map(order -> new OrderListDto(order.getId(),
                        order.getPlaceDate(),
                        order.getOrderStatus(),
                        order.getGrossValue()))
                .toList();

    }
}
