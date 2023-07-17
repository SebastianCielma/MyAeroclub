package pl.sebastiancielma.MyAeroclub.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.order.model.Shipment;
import pl.sebastiancielma.MyAeroclub.order.repository.ShipmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public List<Shipment> getShipments(){
        return shipmentRepository.findAll();
    }
}
