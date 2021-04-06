package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.model.Image;
import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import com.image.portal.service.ImagePortalUserService;
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
public class AlbumsApiDelegateImplTest {

    private final String TEST_ALBUM_ID_ONE = "axzy1234";
    private final String TEST_ALBUM_ID_TWO = "jklh7890";
    private final String TEST_IMAGE_ID_ONE = "img1234";

    @InjectMocks
    private AlbumsApiDelegateImpl albumsApiDelegateImpl;

    @Mock
    private ImagePortalUserRepository mockedImagePortalUserRepository;
    @Mock
    private ImagePortalUserService mockedImagePortalUserService;

    @Test
    void testGetAlbums() {
        Mockito.when(mockedImagePortalUserService
                .retrieveImagePortalUser(mockedImagePortalUserRepository))
                .thenReturn(generateImagePortalUser())
                .thenCallRealMethod();

        ResponseEntity<List<Album>> response = albumsApiDelegateImpl.getAlbums();

        assertEquals(getTestAlbums(), response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private ImagePortalUser generateImagePortalUser() {
        ImagePortalUser imagePortalUser = new ImagePortalUser();
        return imagePortalUser.setAlbums(getTestAlbums())
                .setFirstName("m.j.")
                .setLastName("carrington")
                .setId("id_12345")
                .setPassword("password")
                .setUsername("user1");
    }

    private List<Album> getTestAlbums() {
        Album albumOne = new Album();
        albumOne.setId("img_12345a");
        albumOne.setCreated("01-16-2021");
        albumOne.setDescription("test album");
        albumOne.setId(TEST_ALBUM_ID_ONE);
        albumOne.setImages(getTestImageList());

        Album albumTwo = new Album();
        albumOne.setId("img_12345b");
        albumTwo.setCreated("01-16-2020");
        albumTwo.setDescription("test album 2");
        albumTwo.setId(TEST_ALBUM_ID_TWO);
        albumTwo.setImages(getTestImageList());

        List<Album> albums = new ArrayList<>();
        albums.add(albumOne);
        albums.add(albumTwo);

        return albums;
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
