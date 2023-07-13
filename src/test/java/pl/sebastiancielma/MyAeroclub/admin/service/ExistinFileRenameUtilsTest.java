package pl.sebastiancielma.MyAeroclub.admin.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class ExistinFileRenameUtilsTest {
    @Test
    void shouldNotRenameFile(@TempDir Path tempDir) throws IOException {
        String newName =  ExistinFileRenameUtils.renameIfExists(Path.of(String.valueOf(tempDir)),"test.png");
        assertEquals("test.png", newName);

    }
    @Test
    void shouldRenameExistingFile(@TempDir Path tempDir) throws IOException {
        Files.createFile(tempDir.resolve("test.png"));
       String newName =  ExistinFileRenameUtils.renameIfExists(Path.of(String.valueOf(tempDir)),"test.png");
       assertEquals("test-1.png", newName);

    }
    @Test
    void shouldRenameManyExistingFile(@TempDir Path tempDir) throws IOException {
        Files.createFile(tempDir.resolve("test.png"));
        Files.createFile(tempDir.resolve("test-1.png"));
        Files.createFile(tempDir.resolve("test-2.png"));
        Files.createFile(tempDir.resolve("test-3.png"));
        String newName =  ExistinFileRenameUtils.renameIfExists(Path.of(String.valueOf(tempDir)),"test.png");
        assertEquals("test-4.png", newName);

    }

}