package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.model.Image;
import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
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
public class UserApiDelegateImplTest {

    private final String TEST_ALBUM_ID = "axzy1234";
    private final String TEST_IMAGE_ID_ONE = "img1234";
    private final String USERNAME = "user1";
    private final String PASSWORD = "password";

    @InjectMocks
    private UserApiDelegateImpl userApiDelegateImpl;

    @Mock
    private ImagePortalUserRepository mockedImagePortalUserRepository;

    @BeforeEach
    void findMockImagePortalUser() {
        Mockito.when(mockedImagePortalUserRepository
                .findByUsername(USERNAME))
                .thenReturn(generateImagePortalUser());
    }

    @Test
    void testLoginUserSuccess() {
        ResponseEntity<Void> response = userApiDelegateImpl.loginUser(USERNAME, PASSWORD);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testLoginUserUnsuccessful() {
        ResponseEntity<Void> response = userApiDelegateImpl.loginUser(USERNAME, "wrong");
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    private ImagePortalUser generateImagePortalUser() {
        ImagePortalUser imagePortalUser = new ImagePortalUser();

        List<Album> albums = new ArrayList<>();
        albums.add(getTestAlbum());

        return imagePortalUser.setAlbums(albums)
                .setFirstName("m.j.")
                .setLastName("carrington")
                .setId("id_12345")
                .setPassword("password")
                .setUsername("user1");
    }

    private Album getTestAlbum() {
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
