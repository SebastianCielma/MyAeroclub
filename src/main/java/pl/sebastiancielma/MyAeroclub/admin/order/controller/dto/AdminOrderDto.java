package pl.sebastiancielma.MyAeroclub.admin.order.controller.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sebastiancielma.MyAeroclub.common.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class AdminOrderDto {
    private Long id;
    private LocalDateTime placeDate;
    private OrderStatus orderStatus;
    private BigDecimal grossValue;
}
