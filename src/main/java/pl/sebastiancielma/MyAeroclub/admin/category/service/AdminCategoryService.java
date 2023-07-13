package pl.sebastiancielma.MyAeroclub.admin.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.admin.category.model.AdminCategory;
import pl.sebastiancielma.MyAeroclub.admin.category.repository.AdminCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCategoryService {

    private final AdminCategoryRepository adminCategoryRepository;


    public List<AdminCategory> getCategories() {
        return adminCategoryRepository.findAll();
    }

    public AdminCategory getCategory(Long id) {

        return adminCategoryRepository.findById(id).orElseThrow();
    }

    public AdminCategory createCategory(AdminCategory mapToAdminCategory) {
       return adminCategoryRepository.save(mapToAdminCategory);
    }

    public AdminCategory updateCategory(AdminCategory mapToAdminCategory) {
        return adminCategoryRepository.save(mapToAdminCategory);
    }

    public void deleteCategory(Long id) {
        adminCategoryRepository.deleteById(id);
    }
}
