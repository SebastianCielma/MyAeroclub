package pl.sebastiancielma.MyAeroclub.airplaneforsale.controller;

import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.model.Airplane;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.service.AirplaneForSaleService;
@Validated
@RestController
@RequiredArgsConstructor
public class AirplaneForSaleController {
    private final AirplaneForSaleService airplaneForSaleService;

    @GetMapping("/airplanesforsale")
    public Page<Airplane> getAirplanes(Pageable pageable) {
        return airplaneForSaleService.getAirplanes(pageable);

    }
    @GetMapping("/airplanesforsale/{slug}")
    public Airplane getAirplanesBySlug(@PathVariable
                                     @Length( max = 255)
                                     @Pattern(regexp = "[a-z0-9\\-]+")
                                     String slug){

        return airplaneForSaleService.getAirplanesBySlug(slug);
    }
    @GetMapping("/airplanesforsale/{name}")
    public Airplane getAirplanesByName(@PathVariable String name){
        return airplaneForSaleService.getAirplanesByName(name);
    }
}
