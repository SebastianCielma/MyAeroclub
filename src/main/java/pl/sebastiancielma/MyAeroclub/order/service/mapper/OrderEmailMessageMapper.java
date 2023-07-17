package pl.sebastiancielma.MyAeroclub.order.service.mapper;

import pl.sebastiancielma.MyAeroclub.order.model.Order;

import java.time.format.DateTimeFormatter;

public class OrderEmailMessageMapper {
    public static String createEmailMessage(Order order) {
        return "Your order ID: " + order.getId() +
                "\nOrder date: " + order.getPlaceDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                "\nTotal amount " + order.getGrossValue() + " PLN " +
                "\n\n" +
                "\nPayment method: " + order.getPayment().getName() +
                (order.getPayment().getNote() != null ? "\n" + order.getPayment().getNote() : "") +
                "\n\nThank you for your purchase.";
    }
}
