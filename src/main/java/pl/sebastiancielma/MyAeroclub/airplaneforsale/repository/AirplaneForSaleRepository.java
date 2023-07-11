package pl.sebastiancielma.MyAeroclub.airplaneforsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.model.Airplane;

import java.util.List;

@Repository
public interface AirplaneForSaleRepository extends JpaRepository<Airplane,Long> {

}
