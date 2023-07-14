package pl.sebastiancielma.MyAeroclub.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sebastiancielma.MyAeroclub.common.model.Airplane;

import java.util.Optional;

@Repository
public interface AirplaneForSaleRepository extends JpaRepository<Airplane,Long> {
Optional<Airplane>  findBySlug(String slug);
Optional<Airplane> findByName(String name);

    Page<Airplane> findByCategoryId(Long id, Pageable pageable);
}
