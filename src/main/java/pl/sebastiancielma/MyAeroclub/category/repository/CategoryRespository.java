package pl.sebastiancielma.MyAeroclub.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.sebastiancielma.MyAeroclub.category.model.Category;

public interface CategoryRespository extends JpaRepository<Category,Long> {
    Category findBySlug(String slug);
}
