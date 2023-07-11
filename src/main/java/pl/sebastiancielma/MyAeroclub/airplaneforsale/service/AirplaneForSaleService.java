package pl.sebastiancielma.MyAeroclub.airplaneforsale.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.model.Airplane;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.repository.AirplaneForSaleRepository;

@Service
@RequiredArgsConstructor
public class AirplaneForSaleService {
    private final AirplaneForSaleRepository airplaneForSaleRepository;
    public Page<Airplane> getAirplanes(){
        return airplaneForSaleRepository.findAll(PageRequest.of(0,25));
    }
}
