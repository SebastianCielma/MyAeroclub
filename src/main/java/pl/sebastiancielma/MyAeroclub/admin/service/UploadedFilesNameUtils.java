package pl.sebastiancielma.MyAeroclub.admin.service;

import com.github.slugify.Slugify;
import org.apache.commons.io.FilenameUtils;

class UploadedFilesNameUtils {

    public static String slugifyFileName(String filename) {
        String name = FilenameUtils.getBaseName(filename);
        Slugify slg = Slugify.builder().build();
        String changedName = slg.slugify(name);

        return changedName + "." + FilenameUtils.getExtension(filename);
    }
}
