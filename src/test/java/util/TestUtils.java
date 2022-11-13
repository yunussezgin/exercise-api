package util;

import org.apache.commons.io.IOUtils;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestUtils {

    public static MockMultipartFile generateCsvFileParam(String fileName) throws IOException {
        File file = new File("src/test/resources/data/" + fileName);
        FileInputStream input = new FileInputStream(file);
        return new MockMultipartFile("csvFile",
                file.getName(), "text/plain", IOUtils.toByteArray(input));
    }

}
