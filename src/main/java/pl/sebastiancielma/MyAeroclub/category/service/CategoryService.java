package pl.sebastiancielma.MyAeroclub.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sebastiancielma.MyAeroclub.common.dto.AirplaneForSaleListDto;
import pl.sebastiancielma.MyAeroclub.common.model.Airplane;
import pl.sebastiancielma.MyAeroclub.common.repository.AirplaneForSaleRepository;
import pl.sebastiancielma.MyAeroclub.common.model.Category;
import pl.sebastiancielma.MyAeroclub.category.dto.CategoryAirplanesDto;
import pl.sebastiancielma.MyAeroclub.category.repository.CategoryRespository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRespository categoryRespository;
    private final AirplaneForSaleRepository airplaneForSaleRepository;

    public List<Category> getCategories(){
        return categoryRespository.findAll();
    }
@Transactional(readOnly = true)
    public CategoryAirplanesDto getCategoriesWithProducts(String slug, Pageable pageable) {
        Category category = categoryRespository.findBySlug(slug);
       Page<Airplane> page = airplaneForSaleRepository.findByCategoryId(category.getId(), pageable);
    List<AirplaneForSaleListDto> airplaneForSaleListDtos = page.getContent().stream()
            .map(airplane -> AirplaneForSaleListDto.builder()
                    .id(airplane.getId())
                    .name(airplane.getName())
                    .price(airplane.getPrice())
                    .image(airplane.getImage())
                    .currency(airplane.getCurrency())
                    .description(airplane.getDescription())
                    .slug(airplane.getSlug())
                    .build())
            .toList();
       return new CategoryAirplanesDto(category,new PageImpl<>(airplaneForSaleListDtos, pageable, page.getTotalElements()));
    }
}
