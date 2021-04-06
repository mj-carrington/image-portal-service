package com.image.portal.api;

import com.image.portal.model.Share;
import com.image.portal.service.MailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ShareApiDelegateImplTest {

    private final String TEST_ALBUM_ID = "axzy1234";
    private final String TEST_IMAGE_ID_ONE = "img1234";

    @InjectMocks
    private ShareApiDelegateImpl shareApiDelegateImpl;

    @Mock
    private MailService mockedMailService;

    @Test
    void testShareImagesSuccess() {
        Mockito.doNothing().when(mockedMailService).sendEmail(generateShare());
        ResponseEntity<Share> response = shareApiDelegateImpl.shareImages(generateShare());

        assertEquals(generateShare(), response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testShareImagesMailException() {
        Mockito.doThrow(MailSendException.class).when(mockedMailService).sendEmail(generateShare());
        ResponseEntity<Share> response = shareApiDelegateImpl.shareImages(generateShare());

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    private Share generateShare() {

        List<String> imageLocations = new ArrayList<>();
        imageLocations.add("location-1");
        imageLocations.add("location-2");
        imageLocations.add("location-3");

        Share share = new Share();
        share.setEmail("test@test-email.com");
        share.setImageUrls(imageLocations);

        return share;
    }

/*    @BeforeEach
    void mockImagePortalUser() {
        Mockito.when(mockedImagePortalUserService
                .retrieveImagePortalUser(mockedImagePortalUserRepository))
                .thenReturn(generateImagePortalUser());
    }*/
}
