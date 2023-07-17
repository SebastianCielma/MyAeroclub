package pl.sebastiancielma.MyAeroclub.common.model;

public enum OrderStatus {
    NEW("New"),
    PAID("Paid"),
    PROCESSING("Processing"),
    COMPLETED("Completed"),
    CANCELED("Canceled"),
    REFUND("Refund");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

