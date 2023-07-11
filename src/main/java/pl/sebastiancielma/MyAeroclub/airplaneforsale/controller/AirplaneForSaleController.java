package pl.sebastiancielma.MyAeroclub.airplaneforsale.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.model.Airplane;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.service.AirplaneForSaleService;

@RestController
@RequiredArgsConstructor
public class AirplaneForSaleController {
    private final AirplaneForSaleService airplaneForSaleService;

    @GetMapping("/airplanesforsale")
    public Page<Airplane> getPlanesForSale (){
        return airplaneForSaleService.getAirplanes();
    }

}
