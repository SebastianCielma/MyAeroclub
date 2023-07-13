package pl.sebastiancielma.MyAeroclub.admin.service;

import org.apache.commons.io.FilenameUtils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
class ExistinFileRenameUtils {
    public static String renameIfExists(Path uploadDirectory, String fileName) {
      if(Files.exists(uploadDirectory.resolve(fileName))){
          return renameAndCheck(Path.of(String.valueOf(uploadDirectory)), fileName);
      }
      return fileName;


    }

    private static String renameAndCheck(Path uploadDirectory, String fileName) {
        String newName = renameFileName(fileName);
        if (Files.exists(uploadDirectory.resolve(newName))) {
            newName = renameAndCheck(uploadDirectory, newName);
        }
        return newName;
    }
    private static String renameFileName(String fileName){
        String baseName = FilenameUtils.getBaseName(fileName);
        String[] split = baseName.split("-(?=[0-9]+$)");
        int counter = split.length>1 ? Integer.parseInt(split[1]) + 1 : 1;
        return split[0] + "-" + counter + "." + FilenameUtils.getExtension(fileName);
    }
}


