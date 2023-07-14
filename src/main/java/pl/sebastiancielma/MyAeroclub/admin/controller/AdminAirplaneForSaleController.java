package pl.sebastiancielma.MyAeroclub.admin.controller;

import com.github.slugify.Slugify;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.sebastiancielma.MyAeroclub.admin.controller.dto.AdminAirplaneForSaleDto;
import pl.sebastiancielma.MyAeroclub.admin.controller.dto.UploadResponse;
import pl.sebastiancielma.MyAeroclub.admin.model.AdminAirplaneForSale;
import pl.sebastiancielma.MyAeroclub.admin.service.AdminAirplaneForSaleImageService;
import pl.sebastiancielma.MyAeroclub.admin.service.AdminAirplaneForSaleService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static pl.sebastiancielma.MyAeroclub.admin.common.utils.SlugifyUtils.slugifySlug;


@RestController
@RequiredArgsConstructor
public class AdminAirplaneForSaleController {
    public static final Long EMPTY_ID = null;
    private final AdminAirplaneForSaleService airplaneForSaleService;
    private final AdminAirplaneForSaleImageService airplaneForSaleImageService;

    @GetMapping("/admin/airplanesforsale")
    public Page<AdminAirplaneForSale> getAirplanesForSale(Pageable pageable){
        return airplaneForSaleService.getAirplanesForSale(pageable);
    }
@GetMapping("/admin/airplanesforsale/{id}")
    public AdminAirplaneForSale getAirplaneForSale(@PathVariable Long id){
        return airplaneForSaleService.getAirplanesForSale(id);
    }

    @PostMapping("/admin/airplanesforsale")
    public AdminAirplaneForSale createAirplaneForSale(@RequestBody @Valid AdminAirplaneForSaleDto adminAirplaneForSaleDto) {
        return airplaneForSaleService.createAirplaneForSale(mapAdminAirplaneForSale(adminAirplaneForSaleDto, EMPTY_ID));
    }

        @PutMapping("/admin/airplanesforsale/{id}")
        public AdminAirplaneForSale updateAirplaneForSale(@RequestBody @Valid AdminAirplaneForSaleDto adminAirplaneForSaleDto, @PathVariable Long id){
            return airplaneForSaleService.uptadeAirplaneForSale(mapAdminAirplaneForSale(adminAirplaneForSaleDto, id)
            );
        }
        @DeleteMapping("/admin/airplanesforsale/{id}")
        public void deleteAirplaneForSale(@PathVariable Long id){
        airplaneForSaleService.delete(id);
        }
@PostMapping("/admin/airplanesforsale/upload-image")
        public UploadResponse uploadImage (@RequestParam("file") MultipartFile multipartFile){
        String filename = multipartFile.getOriginalFilename();
        try(InputStream inputStream = multipartFile.getInputStream()) {
            String saveFileName = airplaneForSaleImageService.uploadImage(filename, inputStream);
            return new UploadResponse(saveFileName);
        } catch (IOException e) {
            throw new RuntimeException("something went wrong", e);
        }

    }



        @GetMapping("/data/airplanesforsaleimages/(filename)")
        public ResponseEntity<Resource> serveFiles(@PathVariable String filename) throws  IOException{
          Resource file =  airplaneForSaleImageService.serveFiles(filename);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Path.of(filename)))
                    .body(file);
        }

    private  AdminAirplaneForSale mapAdminAirplaneForSale(AdminAirplaneForSaleDto adminAirplaneForSaleDto, Long id) {
        return AdminAirplaneForSale.builder()
                .id(id)
                .name(adminAirplaneForSaleDto.getName())
                .price(adminAirplaneForSaleDto.getPrice())
                .currency(String.valueOf(adminAirplaneForSaleDto.getCurrency()))
                .description(adminAirplaneForSaleDto.getDescription())
                .categoryId(adminAirplaneForSaleDto.getCategoryId())
                .image(adminAirplaneForSaleDto.getImage())
                .slug(slugifySlug(adminAirplaneForSaleDto.getSlug()))
                .build();
    }

}


