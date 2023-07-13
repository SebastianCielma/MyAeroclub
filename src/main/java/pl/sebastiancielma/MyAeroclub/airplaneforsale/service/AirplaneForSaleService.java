package pl.sebastiancielma.MyAeroclub.airplaneforsale.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.model.Airplane;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.repository.AirplaneForSaleRepository;
@Service
@RequiredArgsConstructor
public class AirplaneForSaleService {
    private final AirplaneForSaleRepository airplaneForSaleRepository;
    public Page<Airplane> getAirplanes(Pageable pageable){
        return airplaneForSaleRepository.findAll(pageable);
    }

    public Airplane getAirplanesBySlug(String slug) {
        return airplaneForSaleRepository.findBySlug(slug).orElseThrow();
    }
    public Airplane getAirplanesByName(String name){
        return airplaneForSaleRepository.findByName(name).orElseThrow();
    }
}
