package pl.sebastiancielma.MyAeroclub.admin.order.service;

import pl.sebastiancielma.MyAeroclub.common.model.OrderStatus;

public class AdminOrderEmailMessage {
    public static String createProcessingEmailMessage(Long id, OrderStatus newStatus) {
        return "Your ordeer with id :  " + id + " is being processed" +
                "\nThe status of your order has been changed to: " + newStatus.getValue() +
                "\n MyAeroclub";
    }



    public static String createCompletedEmailMessage(Long id, OrderStatus newStatus) {
        return "Your ordeer with id : " + id + " is ready for pickup." +
                "\nThe status of your order has been changed to: " + newStatus.getValue() +
                "\n\n Thank you for shopping with us, and we look forward to serving you again" +
                "\n MyAeroclub";
    }

    public static String createRefundEmailMessage(Long id, OrderStatus newStatus) {
        return "Your ordeer with id : " + id + " has been refunded" +
                "\nThe status of your order has been changed to  " + newStatus.getValue() +
                "\n MyAeroclub";
    }
}
