package pl.sebastiancielma.MyAeroclub.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebastiancielma.MyAeroclub.admin.model.AdminAirplaneForSale;

public interface AdminAirplaneForSaleRepository extends JpaRepository<AdminAirplaneForSale,Long> {
}
