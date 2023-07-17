package pl.sebastiancielma.MyAeroclub.airplaneforsale.controller;

import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sebastiancielma.MyAeroclub.common.dto.AirplaneForSaleListDto;
import pl.sebastiancielma.MyAeroclub.common.model.Airplane;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.service.AirplaneForSaleService;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
public class AirplaneForSaleController {
    private final AirplaneForSaleService airplaneForSaleService;

    @GetMapping("/airplanesforsale/all")
    public Page<AirplaneForSaleListDto> getAirplanes(Pageable pageable) {
        Page<Airplane> airplanes = airplaneForSaleService.getAirplanes(pageable);
        List<AirplaneForSaleListDto> airplaneForSaleListDtos = airplanes.getContent().stream()
                .map(airplane -> AirplaneForSaleListDto.builder()
                        .id(airplane.getId())
                        .name(airplane.getName())
                        .price(airplane.getPrice())
                        .image(airplane.getImage())
                        .currency(airplane.getCurrency())
                        .description(airplane.getDescription())
                        .slug(airplane.getSlug())
                        .build())
                .toList();
        return new PageImpl<>(airplaneForSaleListDtos,pageable, airplanes.getTotalElements());

    }
    @GetMapping("/airplanesforsale/{slug}")
    public Airplane getAirplanesBySlug(@PathVariable
                                     @Length( max = 255)
                                     @Pattern(regexp = "[a-z0-9\\-]+")
                                     String slug){

        return airplaneForSaleService.getAirplanesBySlug(slug);
    }
    @GetMapping("/airplanesforsale/name/{name}")
    public Airplane getAirplanesByName(@PathVariable String name){
        return airplaneForSaleService.getAirplanesByName(name);
    }
    @GetMapping("/airplanesforsale/id/{id}")
    public Airplane getAirplanesById(@PathVariable Long id){
        return airplaneForSaleService.getAirplanesById(id);
    }
}
