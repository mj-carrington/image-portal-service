package com.image.portal.service;

import com.image.portal.model.Share;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class MailServiceTest {

    @InjectMocks
    private MailService mailService;

    @Mock
    private JavaMailSender mockJavaMailSender;

    @Test
    void testSendEmail() {
        List<String> imageUrls = new ArrayList<>();
        imageUrls.add("https://aws.amazon.com/img/url1.png");
        imageUrls.add("https://aws.amazon.com/img/url2.png");
        imageUrls.add("https://aws.amazon.com/img/url3.png");

        Share share = new Share();
        share.setImageUrls(imageUrls);
        share.setEmail("mcarrington1@test-email.edu");

        Mockito.doNothing().when(mockJavaMailSender).send(any(SimpleMailMessage.class));

        mailService.sendEmail(share);

        Mockito.verify(mockJavaMailSender, times(1)).send(any(SimpleMailMessage.class));
    }
}
