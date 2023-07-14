package pl.sebastiancielma.MyAeroclub.category.dto;

import org.springframework.data.domain.Page;
import pl.sebastiancielma.MyAeroclub.common.dto.AirplaneForSaleListDto;
import pl.sebastiancielma.MyAeroclub.common.model.Category;

public record CategoryAirplanesDto(Category category, Page<AirplaneForSaleListDto> airplane) {
}
