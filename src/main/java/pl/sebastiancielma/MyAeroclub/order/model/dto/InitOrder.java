package pl.sebastiancielma.MyAeroclub.order.model.dto;

import lombok.Builder;
import lombok.Getter;
import pl.sebastiancielma.MyAeroclub.order.model.Payment;
import pl.sebastiancielma.MyAeroclub.order.model.Shipment;

import java.util.List;

@Getter
@Builder
public class InitOrder {
    private List<Shipment> shipment;
    private List<Payment> payment;
}
