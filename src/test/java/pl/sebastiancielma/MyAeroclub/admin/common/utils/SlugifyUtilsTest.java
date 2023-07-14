package pl.sebastiancielma.MyAeroclub.admin.common.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pl.sebastiancielma.MyAeroclub.admin.common.utils.SlugifyUtils;

import static org.junit.jupiter.api.Assertions.*;
class SlugifyUtilsTest {
    @ParameterizedTest
    @CsvSource({
            "test test.png, test-test.png",
            "śężźółąń.png, sezzolan.png",
            "photo 1.png, photo-1.png"

    })
    void shouldSlugifyFileName(String in, String out){
        String fileName = SlugifyUtils.slugifyFileName(in);
        assertEquals(fileName, out);

    }

}