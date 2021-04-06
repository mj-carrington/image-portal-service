package com.image.portal.api;

import com.image.portal.service.AmazonS3Service;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class UploadApiTest {

    private final String TEST_ALBUM_ID = "axzy1234";
    private final String TEST_IMAGE_ID_ONE = "img1234";

    @InjectMocks
    private UploadApi uploadApi;

    @Mock
    private AmazonS3Service mockedAmazonS3Service;

    @Test
    void testUploadFileSuccess() {
        String imageUrl = "https://aws.amazon.com/result-location.png";

        lenient().when(mockedAmazonS3Service
                .uploadImageToAmazon(generateMultiPartFile()))
                .thenReturn(imageUrl);

        ResponseEntity<?> response = uploadApi.uploadFile(generateMultiPartFile());

        assertEquals(imageUrl, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testUploadFileException() {
        lenient().when(mockedAmazonS3Service
                .uploadImageToAmazon(generateMultiPartFile()))
                .thenThrow(IOException.class);

        ResponseEntity<?> response = uploadApi.uploadFile(generateMultiPartFile());

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    private MultipartFile generateMultiPartFile() {
        File file = new File("src/test/resources/cat.png");
        MultipartFile multipartFile;

        try {
            FileInputStream input = new FileInputStream(file);

            multipartFile = new MockMultipartFile("file",
                    file.getName(), "image/png", IOUtils.toByteArray(input));
        } catch (IOException e) {
            multipartFile = null;
        }

        return multipartFile;
    }
}
