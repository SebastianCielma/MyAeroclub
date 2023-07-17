package pl.sebastiancielma.MyAeroclub.cart.controller.dto;

import ch.qos.logback.classic.spi.LoggingEventVO;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class AirplaneDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private String currency;
    private String image;
    private String slug;
    
}

