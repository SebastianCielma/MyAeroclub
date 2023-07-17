package pl.sebastiancielma.MyAeroclub.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pl.sebastiancielma.MyAeroclub.common.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
public class OrderListDto {
    private Long id;
    private LocalDateTime placeDate;
    private String orderStatus;
    private BigDecimal grossValue;

    public OrderListDto(Long id, LocalDateTime placeDate, OrderStatus orderStatus, BigDecimal grossValue) {

    }
}
