package pl.sebastiancielma.MyAeroclub.airplaneforsale.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
@AllArgsConstructor
public class AirPlane {
    private String name;
    private String category;
    private String description;
    private BigDecimal price;
    private String currency;


}
