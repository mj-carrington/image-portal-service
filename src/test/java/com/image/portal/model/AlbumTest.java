package com.image.portal.model;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlbumTest {

    private final Album testAlbum = new Album();

    @Test
    void testAlbumId() {
        assertTrue(StringUtils.isNotBlank(testAlbum.getId()));
    }

    @Test
    void testAlbumName() {
        String testAlbumName = "test name";

        testAlbum.setName(testAlbumName);
        assertEquals(testAlbumName, testAlbum.getName());
    }

    @Test
    void testAlbumDescription() {
        String testDescription = "test descrip";

        testAlbum.setDescription(testDescription);
        assertEquals(testDescription, testAlbum.getDescription());
    }

    @Test
    void testAlbumCreated() {
        assertTrue(isValidDate(testAlbum.getCreated()));
    }

    @Test
    void testAlbumImages() {
        Image imageOne = new Image();
        imageOne.setId("abdc1234");
        imageOne.setImageTag("tag1");
        imageOne.setLocation("https://aws.amazon.com/1234.png");
        imageOne.setName("name1");

        List<Image> images = new ArrayList<>();
        images.add(imageOne);

        testAlbum.setImages(images);
        assertEquals(images, testAlbum.getImages());
    }

    private static boolean isValidDate(String inDate) {
        try {
            LocalDateTime.parse(inDate);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }
}
