package pl.sebastiancielma.MyAeroclub.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebastiancielma.MyAeroclub.order.model.Order;
import pl.sebastiancielma.MyAeroclub.order.model.OrderRow;

import java.util.List;

public interface OrderRowRepository extends JpaRepository<OrderRow, Long> {
}
