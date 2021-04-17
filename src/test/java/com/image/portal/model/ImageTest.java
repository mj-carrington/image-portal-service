package com.image.portal.model;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImageTest {

    private final Image testImage = new Image();

    @Test
    void testImageId() {
        assertTrue(StringUtils.isNotBlank(testImage.getId()));
    }

    @Test
    void testImageName() {
        String testImageName = "test name";

        testImage.setName(testImageName);
        assertEquals(testImageName, testImage.getName());
    }

    @Test
    void testImageTag() {
        String testImageTag = "Test tag";
        testImage.setImageTag(testImageTag);
        assertEquals(testImageTag, testImage.getImageTag());
    }

    @Test
    void testImageLocation() {
        String imageLocation = "https://aws.amazon.com/s3/testlocationofimage.jpg";
        testImage.setLocation(imageLocation);
        assertEquals(imageLocation, testImage.getLocation());
    }

    @Test
    void testImageCreated() {
        assertTrue(isValidDate(testImage.getCreated()));
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
