package com.image.portal.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ImagePortalUserTest {

    private final ImagePortalUser imagePortalUser = new ImagePortalUser();
    private final String TEST_ALBUM_ID = "qwerty-1234";

    @Test
    void testImagePortalUserUsername() {
        String imagePortalUsername = "test";

        imagePortalUser.setUsername(imagePortalUsername);
        assertEquals(imagePortalUsername, imagePortalUser.getUsername());
    }

    @Test
    void testImagePortalUserPassword() {
        String imagePortalPassword = "password";

        imagePortalUser.setPassword(imagePortalPassword);
        assertEquals(imagePortalPassword, imagePortalUser.getPassword());
    }

    @Test
    void testImagePortalFirstname() {
        String imagePortalFirstname = "First";

        imagePortalUser.setFirstName(imagePortalFirstname);
        assertEquals(imagePortalFirstname, imagePortalUser.getFirstName());
    }

    @Test
    void testImagePortalLastname() {
        String imagePortalLastname = "Last";

        imagePortalUser.setLastName(imagePortalLastname);
        assertEquals(imagePortalLastname, imagePortalUser.getLastName());
    }

    @Test
    void testImagePortalAlbums() {
        imagePortalUser.setAlbums(getTestAlbums(TEST_ALBUM_ID));
        assertEquals(getTestAlbums(TEST_ALBUM_ID), imagePortalUser.getAlbums());
    }

    @Test
    void testAddNewAlbum() {
        String secondTestAlbumId = "jklh9000";

        imagePortalUser.setAlbums(getTestAlbums(TEST_ALBUM_ID));
        imagePortalUser.addNewAlbum(getTestAlbum(secondTestAlbumId));

        System.out.println(imagePortalUser.getAlbums());

        // validate that we can find the new album in albums
        assertTrue(imagePortalUser
                .getAlbums()
                .contains(imagePortalUser
                        .getAlbumById(secondTestAlbumId)));

        // validate that our entire album list is accurate
        List<Album> expectedAlbums = new ArrayList<>();
        expectedAlbums.add(getTestAlbum(TEST_ALBUM_ID));
        expectedAlbums.add(getTestAlbum(secondTestAlbumId));

        assertEquals(expectedAlbums, imagePortalUser.getAlbums());
    }

    @Test
    void testGetAlbumById() {
        imagePortalUser.setAlbums(getTestAlbums(TEST_ALBUM_ID));

        assertEquals(getTestAlbum(TEST_ALBUM_ID), imagePortalUser.getAlbumById(TEST_ALBUM_ID));
    }

    @Test
    void testGetImageById() {
        imagePortalUser.setAlbums(getTestAlbums(TEST_ALBUM_ID));
        assertEquals(getTestImage(TEST_ALBUM_ID),
                imagePortalUser
                        .getImageById(getTestAlbum(TEST_ALBUM_ID), "img-" + TEST_ALBUM_ID));
    }

    @Test
    void testAddNewImageToAlbum() {
        String testImageId = "qwertyz-1234";
        imagePortalUser.setAlbums(getTestAlbums(TEST_ALBUM_ID));

        Image testImage = getTestImage(testImageId);
        Album expectedAlbum = imagePortalUser.addNewImageToAlbum(TEST_ALBUM_ID, testImage);
        Album actualAlbum = imagePortalUser.getAlbumById(TEST_ALBUM_ID);

        assertEquals(expectedAlbum, actualAlbum);
    }

    @Test
    void testUpdateImageToAlbum() {
        imagePortalUser.setAlbums(getTestAlbums(TEST_ALBUM_ID));

        Image updatedImage = getTestImage(TEST_ALBUM_ID);
        updatedImage.setImageTag("new-tag");
        updatedImage.setName("new-name");

        Album expectedAlbum = imagePortalUser
                .updateImageToAlbum(TEST_ALBUM_ID, "img-" + TEST_ALBUM_ID, updatedImage);

        Album actualAlbum = imagePortalUser
                .getAlbumById(TEST_ALBUM_ID);

        assertEquals(actualAlbum, expectedAlbum);
    }

    @Test
    void testRemoveAlbum() {
        imagePortalUser.setAlbums(getTestAlbums(TEST_ALBUM_ID));
        imagePortalUser.removeAlbum(TEST_ALBUM_ID);

        assertTrue(imagePortalUser.getAlbums().isEmpty());
    }

    @Test
    void testRemoveImageFromAlbum() {
        imagePortalUser.setAlbums(getTestAlbums(TEST_ALBUM_ID));

        Album expectedAlbum = imagePortalUser
                .removeImageFromAlbum(TEST_ALBUM_ID, "img" + TEST_ALBUM_ID);

        Album actualAlbum = imagePortalUser
                .getAlbumById(TEST_ALBUM_ID);

        assertEquals(actualAlbum, expectedAlbum);
    }

    private Album getTestAlbum(String albumId) {
        List<Image> images = new ArrayList<>();
        images.add(getTestImage(albumId));

        Album testAlbum = new Album();
        testAlbum.setId(albumId);
        testAlbum.setCreated("2021-04-15T10:22:11.692592500");
        testAlbum.setImages(images);

        return testAlbum;
    }

    private Image getTestImage(String albumId) {
        Image imageOne = new Image();
        imageOne.setId("img-" + albumId);
        imageOne.setImageTag("tag1");
        imageOne.setLocation("https://aws.amazon.com/1234.png");
        imageOne.setName("name-" + albumId);

        return imageOne;
    }

    private List<Album> getTestAlbums(String albumId) {
        List<Album> albums = new ArrayList<>();
        albums.add(getTestAlbum(albumId));

        return albums;
    }
}
