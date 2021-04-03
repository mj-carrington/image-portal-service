package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.model.Image;
import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import com.image.portal.service.ImagePortalUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AlbumApiDelegateImplTest {

    private final String TEST_ALBUM_ID = "axzy1234";
    private final String TEST_IMAGE_ID_ONE = "img1234";

    @InjectMocks
    private AlbumApiDelegateImpl albumApiDelegateimpl;

    @Mock
    private ImagePortalUserRepository mockedImagePortalUserRepository;
    @Mock
    private ImagePortalUserService mockedImagePortalUserService;
    @Mock
    private ImagePortalUser mockImagePortalUser;


    @BeforeEach
    void mockImagePortalUser() {
        Mockito.when(mockedImagePortalUserService
                .retrieveImagePortalUser(mockedImagePortalUserRepository))
                .thenReturn(generateImagePortalUser());
    }

    @Test
    void testGetAlbumById() {
        ResponseEntity<Album> response = albumApiDelegateimpl.getAlbumById(TEST_ALBUM_ID);

        assertEquals(getTestAlbumList(), response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetImagesByAlbumId() {
        ResponseEntity<List<Image>> response = albumApiDelegateimpl.getImagesByAlbumId(TEST_ALBUM_ID);

        assertEquals(getTestImageList(), response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetImageByAlbumIdAndImageId() {
        ResponseEntity<Image> response = albumApiDelegateimpl.getImageByAlbumIdAndImageId(TEST_ALBUM_ID, TEST_IMAGE_ID_ONE);

        Image expectedImage = getTestImageList().get(0);

        assertEquals(expectedImage, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testUpdateImage() {
        Image updatedImage = new Image();
        updatedImage.setName("new name");
        updatedImage.setLocation("https://aws.amazon.com/1234-new.png");
        updatedImage.setImageTag("new tag");

        ResponseEntity<Void> response = albumApiDelegateimpl.updateImage(TEST_ALBUM_ID, TEST_IMAGE_ID_ONE, updatedImage);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        // TODO: If implementation changes to return list we should verify the body
    }


    private ImagePortalUser generateImagePortalUser() {
        ImagePortalUser imagePortalUser = new ImagePortalUser();

        List<Album> albums = new ArrayList<>();
        albums.add(getTestAlbumList());

        return imagePortalUser.setAlbums(albums)
                .setFirstName("m.j.")
                .setLastName("carrington")
                .setId("id_12345")
                .setUsername("user1");
    }

    private Album getTestAlbumList() {
        Album album = new Album();
        album.setCreated("01-16-2021");
        album.setDescription("test album");
        album.setId(TEST_ALBUM_ID);
        album.setImages(getTestImageList());

        return album;
    }

    private List<Image> getTestImageList() {
        Image imageOne = new Image();
        imageOne.setId(TEST_IMAGE_ID_ONE);
        imageOne.setImageTag("tag1");
        imageOne.setLocation("https://aws.amazon.com/1234.png");
        imageOne.setName("name1");

        Image imageTwo = new Image();
        imageTwo.setId("img5678");
        imageTwo.setImageTag("tag2");
        imageTwo.setLocation("https://aws.amazon.com/5678.png");
        imageTwo.setName("name2");

        List<Image> images = new ArrayList<>();
        images.add(imageOne);
        images.add(imageTwo);

        return images;
    }
}
