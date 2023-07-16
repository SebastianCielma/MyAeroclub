package pl.sebastiancielma.MyAeroclub.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebastiancielma.MyAeroclub.order.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
