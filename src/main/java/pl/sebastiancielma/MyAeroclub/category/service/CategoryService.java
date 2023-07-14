package pl.sebastiancielma.MyAeroclub.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.category.model.Category;
import pl.sebastiancielma.MyAeroclub.category.repository.CategoryRespository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRespository categoryRespository;

    public List<Category> getCategories(){
        return categoryRespository.findAll();
    }

    public Category getCategoriesWithProducts(String slug, Pageable pageable) {
        Category categoryBySlug = categoryRespository.findBySlug(slug);
        return null;
    }
}
