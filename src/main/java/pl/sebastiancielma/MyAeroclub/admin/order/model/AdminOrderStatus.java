package pl.sebastiancielma.MyAeroclub.admin.order.model;

public enum AdminOrderStatus {
    NEW("New"),
    PAID("Paid"),
    PROCESSING("Processing"),
    COMPLETED("Completed"),
    CANCELED("Canceled"),
    REFUND("Refund");

    private String value;

    AdminOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
