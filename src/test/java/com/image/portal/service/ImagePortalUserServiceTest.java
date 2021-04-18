package com.image.portal.service;

import com.image.portal.model.Album;
import com.image.portal.model.Image;
import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;


@ExtendWith(MockitoExtension.class)
public class ImagePortalUserServiceTest {

    @InjectMocks
    private ImagePortalUserService imagePortalUserService;

    @Mock
    private ImagePortalUserRepository mockImagePortalUserRepository;

    @Test
    void testRetrieveImagePortalUser() {
        ImagePortalUser actualImagePortalUser;
        ImagePortalUser expectedImagePortalUser;

        Mockito.when(mockImagePortalUserRepository
                .findByUsername(anyString()))
                .thenReturn(generateImagePortalUser());

        actualImagePortalUser = imagePortalUserService.retrieveImagePortalUser(mockImagePortalUserRepository);
        expectedImagePortalUser = generateImagePortalUser();
        assertEquals(actualImagePortalUser.getId(), expectedImagePortalUser.getId());
        assertEquals(actualImagePortalUser.getAlbums(), expectedImagePortalUser.getAlbums());
    }

    private ImagePortalUser generateImagePortalUser() {
        ImagePortalUser imagePortalUser = new ImagePortalUser();

        List<Album> albums = new ArrayList<>();
        albums.add(getTestAlbum());

        return imagePortalUser.setAlbums(albums)
                .setFirstName("m.j.")
                .setLastName("carrington")
                .setId("id_12345")
                .setUsername("user1")
                .setPassword("foo");
    }

    private Album getTestAlbum() {
        Album album = new Album();
        album.setCreated("01-16-2021");
        album.setDescription("test album");
        album.setId("Asdf1");
        album.setImages(getTestImageList());

        return album;
    }

    private List<Image> getTestImageList() {
        Image imageOne = new Image();
        imageOne.setId("Asdf1");
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
