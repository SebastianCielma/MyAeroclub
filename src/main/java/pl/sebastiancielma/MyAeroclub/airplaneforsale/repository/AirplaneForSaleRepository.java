package pl.sebastiancielma.MyAeroclub.airplaneforsale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebastiancielma.MyAeroclub.airplaneforsale.model.Airplane;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirplaneForSaleRepository extends JpaRepository<Airplane,Long> {
Optional<Airplane> findBySlug(String slug);
Optional<Airplane> findByName(String name);
}
