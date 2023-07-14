package pl.sebastiancielma.MyAeroclub.admin.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Getter
@Entity
@Table(name = "airplane")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminAirplaneForSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long categoryId;
    private String description;
    private BigDecimal price;
    private String currency;
    private String image;
    private String slug;
}
