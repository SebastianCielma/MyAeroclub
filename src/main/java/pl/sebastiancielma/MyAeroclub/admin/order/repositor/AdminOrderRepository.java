package pl.sebastiancielma.MyAeroclub.admin.order.repositor;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebastiancielma.MyAeroclub.admin.order.model.AdminOrder;
import pl.sebastiancielma.MyAeroclub.admin.order.model.AdminOrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminOrderRepository extends JpaRepository<AdminOrder, Long> {
    List<AdminOrder> findAllByPlaceDateIsBetweenAndOrderStatus(LocalDateTime from, LocalDateTime to, AdminOrderStatus orderStatus);
}
