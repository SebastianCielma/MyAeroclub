package pl.sebastiancielma.MyAeroclub.airplaneforsale.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.model.AirPlane;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class AirPlaneForSaleController {
    @GetMapping("/airplaneforsale")
    public List<AirPlane> getPlanesForSale (){
        return List.of(
                new AirPlane("Cessna 152", "Single Engine","Description", new BigDecimal(100000),"PLN"),
                new AirPlane("Cessna 172", "Single Engine","Description", new BigDecimal(152000),"PLN"),
                new AirPlane("AN2", "Multi Engine","Description", new BigDecimal(200000),"PLN"),
                new AirPlane("AT3", "Single Engine","Description", new BigDecimal(300000),"PLN")
        );
    }

}
