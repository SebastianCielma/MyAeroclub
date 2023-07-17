package pl.sebastiancielma.MyAeroclub.admin.controller.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import pl.sebastiancielma.MyAeroclub.admin.model.AdminAirplaneForSaleCurrency;

import java.math.BigDecimal;
@Getter
public class AdminAirplaneForSaleDto {
    private String name;
    private Long categoryId;
    @Length(min = 5)
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private AdminAirplaneForSaleCurrency currency;
    private String image;
    private String slug;
}
