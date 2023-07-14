package pl.sebastiancielma.MyAeroclub.admin.category.controller;

import com.github.slugify.Slugify;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.sebastiancielma.MyAeroclub.admin.category.controller.dto.AdminCategoryDto;
import pl.sebastiancielma.MyAeroclub.admin.category.model.AdminCategory;
import pl.sebastiancielma.MyAeroclub.admin.category.service.AdminCategoryService;

import java.util.List;

import static pl.sebastiancielma.MyAeroclub.admin.common.utils.SlugifyUtils.slugifySlug;

@RestController
@RequestMapping("/admin/categories")
@RequiredArgsConstructor
public class AdminCategoryController {
    public static final Long EMPTY_ID = null;
    private final AdminCategoryService adminCategoryService;
    @GetMapping
    public List<AdminCategory> getCategories(){
        return adminCategoryService.getCategories();
    }
    @GetMapping("/{id}")
    public AdminCategory getCategory(@PathVariable Long id){
        return adminCategoryService.getCategory(id);
    }
    @PostMapping
    public AdminCategory createCategory(@RequestBody AdminCategoryDto adminCategoryDto){
        return adminCategoryService.createCategory(mapToAdminCategory(EMPTY_ID, adminCategoryDto));
    }

    private AdminCategory mapToAdminCategory(Long id, AdminCategoryDto adminCategoryDto) {
        return AdminCategory.builder()
                .id(id)
                .name(adminCategoryDto.getName())
                .description(adminCategoryDto.getDescription())
                .slug(slugifySlug(adminCategoryDto.getSlug()))
                .build();

    }


    @PutMapping("/{id}")
    public AdminCategory updateCategory(@PathVariable Long id, @RequestBody AdminCategoryDto adminCategoryDto){
        return adminCategoryService.updateCategory(mapToAdminCategory(id ,adminCategoryDto));
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        adminCategoryService.deleteCategory(id);

    }
}
