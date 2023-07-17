package pl.sebastiancielma.MyAeroclub.admin.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sebastiancielma.MyAeroclub.admin.order.model.AdminOrder;
import pl.sebastiancielma.MyAeroclub.admin.order.model.AdminOrderLog;
import pl.sebastiancielma.MyAeroclub.admin.order.repositor.AdminOrderLogRepository;
import pl.sebastiancielma.MyAeroclub.admin.order.repositor.AdminOrderRepository;
import pl.sebastiancielma.MyAeroclub.common.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminOrderService {

    private final AdminOrderRepository orderRepository;
    private final AdminOrderLogRepository adminOrderLogRepository;
    private final EmailNotificationForStatusChange emailNotificationForStatusChange;

    public Page<AdminOrder> getOrders(Pageable pageable) {
        return orderRepository.findAll(
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by("id").descending())
        );
    }

    public AdminOrder getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow();
    }


}
