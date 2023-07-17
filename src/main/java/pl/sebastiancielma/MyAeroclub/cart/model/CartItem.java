package pl.sebastiancielma.MyAeroclub.cart.model;

import jakarta.persistence.*;
import lombok.*;
import pl.sebastiancielma.MyAeroclub.common.model.Airplane;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    @OneToOne
    private Airplane airplane;
    private Long cartId;
}
