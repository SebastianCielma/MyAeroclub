package pl.sebastiancielma.MyAeroclub.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sebastiancielma.MyAeroclub.common.model.Category;

public interface CategoryRespository extends JpaRepository<Category,Long> {
    Category findBySlug(String slug);
}
