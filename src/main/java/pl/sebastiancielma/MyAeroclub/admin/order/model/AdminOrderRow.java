package pl.sebastiancielma.MyAeroclub.admin.order.model;

import jakarta.persistence.*;
import lombok.Getter;
import pl.sebastiancielma.MyAeroclub.admin.model.AdminAirplaneForSale;
import pl.sebastiancielma.MyAeroclub.order.model.Shipment;

import java.math.BigDecimal;

@Entity
@Table(name = "order_row")
@Getter
public class AdminOrderRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;
    @OneToOne
    @JoinColumn(name = "productId")
    private AdminAirplaneForSale airplane;
    private int quantity;
    private BigDecimal price;
    @OneToOne
    @JoinColumn(name = "shipmentId")
    private Shipment shipment;
}
