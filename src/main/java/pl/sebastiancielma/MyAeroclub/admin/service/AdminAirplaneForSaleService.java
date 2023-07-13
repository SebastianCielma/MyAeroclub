package pl.sebastiancielma.MyAeroclub.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.admin.model.AdminAirplaneForSale;
import pl.sebastiancielma.MyAeroclub.admin.repository.AdminAirplaneForSaleRepository;

@Service
@RequiredArgsConstructor
public class AdminAirplaneForSaleService {
    private final AdminAirplaneForSaleRepository airplaneForSaleRepository;

    public  AdminAirplaneForSale createAirplaneForSale(AdminAirplaneForSale airplaneForSale) {
        return airplaneForSaleRepository.save(airplaneForSale);
    }

    public Page<AdminAirplaneForSale> getAirplanesForSale(Pageable pageable){
        return airplaneForSaleRepository.findAll(pageable);
    }

    public AdminAirplaneForSale getAirplanesForSale(Long id) {
        return airplaneForSaleRepository.findById(id).orElseThrow();
    }

    public AdminAirplaneForSale uptadeAirplaneForSale(AdminAirplaneForSale airplaneForSale) {
        return airplaneForSaleRepository.save(airplaneForSale);
    }

    public void delete(Long id) {
        airplaneForSaleRepository.deleteById(id);
    }
}
