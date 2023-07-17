package pl.sebastiancielma.MyAeroclub.admin.order.repositor;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebastiancielma.MyAeroclub.admin.order.model.AdminOrderLog;

public interface AdminOrderLogRepository extends JpaRepository<AdminOrderLog, Long> {
}
