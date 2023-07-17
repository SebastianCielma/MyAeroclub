package pl.sebastiancielma.MyAeroclub.cart.controller.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CartSummaryItemDto {
    private Long id;
    private int quantity;
    private AirplaneDto airplane;
    private BigDecimal lineValue;
}
