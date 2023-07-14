package pl.sebastiancielma.MyAeroclub.admin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import pl.sebastiancielma.MyAeroclub.admin.common.utils.SlugifyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class AdminAirplaneForSaleImageService {
    @Value("${app.uploadDirectory}")
   private String uploadDirectory;
    public String uploadImage(String filename, InputStream inputStream) {
        String newFileName = SlugifyUtils.slugifyFileName(filename);
         newFileName = ExistinFileRenameUtils.renameIfExists(Path.of(String.valueOf(Path.of(uploadDirectory))), newFileName);

        Path filePath = Paths.get(uploadDirectory).resolve(newFileName);

        OutputStream outputStream = null;
        try {
            outputStream = Files.newOutputStream(filePath);
            inputStream.transferTo(outputStream);
        } catch (IOException e) {
            throw new RuntimeException("file could not be saved",e);
        }
        return filename;

    }

    public Resource serveFiles(String filename) {
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();
        return fileSystemResourceLoader.getResource(uploadDirectory + filename);

    }
}
