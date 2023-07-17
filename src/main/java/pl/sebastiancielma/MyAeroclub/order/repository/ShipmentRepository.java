package pl.sebastiancielma.MyAeroclub.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebastiancielma.MyAeroclub.order.model.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
