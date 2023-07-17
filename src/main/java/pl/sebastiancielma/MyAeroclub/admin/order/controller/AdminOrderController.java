package pl.sebastiancielma.MyAeroclub.admin.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.sebastiancielma.MyAeroclub.admin.order.controller.dto.AdminInitDataDto;
import pl.sebastiancielma.MyAeroclub.admin.order.controller.dto.AdminOrderDto;
import pl.sebastiancielma.MyAeroclub.admin.order.controller.mapper.AdminOrderMapper;
import pl.sebastiancielma.MyAeroclub.admin.order.model.AdminOrder;
import pl.sebastiancielma.MyAeroclub.admin.order.service.AdminOrderService;
import pl.sebastiancielma.MyAeroclub.common.model.OrderStatus;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/orders")
@RequiredArgsConstructor
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @GetMapping
    public Page<AdminOrderDto> getOrders(Pageable pageable) {
        return AdminOrderMapper.mapToPageDtos(adminOrderService.getOrders(pageable));
    }

    @GetMapping("/{id}")
    public AdminOrder getOrder(@PathVariable Long id) {
        return adminOrderService.getOrder(id);
    }


    @GetMapping("/initData")
    public AdminInitDataDto getInitData(){
        return new AdminInitDataDto(createOrderStatusesMap());
    }

    private Map<String, String> createOrderStatusesMap() {
        HashMap<String, String> statuses = new HashMap<>();
        for (OrderStatus value : OrderStatus.values()) {
            statuses.put(value.name(), value.getValue());
        }
        return statuses;
    }
}
