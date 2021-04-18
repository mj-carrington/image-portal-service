package com.image.portal.utils;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilsTest {

    @Test
    void testConvertMultipartToFile() {
        File fileResult;

        try {
            fileResult = FileUtils.convertMultipartToFile(generateMultipartFile());
            assertTrue(fileResult.isFile());
        } catch (IOException e) {
            fail("Failing due to IO exception - " + e);
        }
    }

    @Test
    void testGenerateFileName() {
        String filenameResult = FileUtils.generateFileName(generateMultipartFile());
        assertFalse(filenameResult.isEmpty());
    }

    private MultipartFile generateMultipartFile() {
        return new MockMultipartFile(
                "file",
                "hello.png",
                MediaType.IMAGE_PNG_VALUE,
                "Hello, World!".getBytes()
        );
    }
}
