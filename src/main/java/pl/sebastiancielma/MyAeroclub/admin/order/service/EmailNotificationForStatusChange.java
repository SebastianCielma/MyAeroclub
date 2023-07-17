package pl.sebastiancielma.MyAeroclub.admin.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.admin.order.model.AdminOrder;
import pl.sebastiancielma.MyAeroclub.common.mail.EmailClientService;
import pl.sebastiancielma.MyAeroclub.common.model.OrderStatus;

import static pl.sebastiancielma.MyAeroclub.admin.order.service.AdminOrderEmailMessage.*;

@Service
@RequiredArgsConstructor
class EmailNotificationForStatusChange {

    private final EmailClientService emailClientService;

    void sendEmailNotification(OrderStatus newStatus, AdminOrder adminOrder) {
        if(newStatus == OrderStatus.PROCESSING){
            sendEmail(adminOrder.getEmail(),
                    "Order " + adminOrder.getId() + "  has changed status to  " + newStatus.getValue(),
                    createProcessingEmailMessage(adminOrder.getId(), newStatus));
        } else if (newStatus == OrderStatus.COMPLETED){
            sendEmail(adminOrder.getEmail(),
                    "Order " + adminOrder.getId() + "has been completed",
                    createCompletedEmailMessage(adminOrder.getId(), newStatus));
        } else if (newStatus == OrderStatus.REFUND){
            sendEmail(
                    adminOrder.getEmail(),
                    "Order " + adminOrder.getId() + " has been refunded",
                    createRefundEmailMessage(adminOrder.getId(), newStatus));
        }
    }

    private void sendEmail(String email, String subject, String message) {
        emailClientService.getInstance().send(email, subject, message);
    }
}
