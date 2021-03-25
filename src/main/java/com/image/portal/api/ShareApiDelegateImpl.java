package com.image.portal.api;

import com.image.portal.model.ImagePortalUser;
import com.image.portal.model.Share;
import com.image.portal.repository.ImagePortalUserRepository;
import com.image.portal.service.ImagePortalUserService;
import com.image.portal.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

@Service
public class ShareApiDelegateImpl implements ShareApiDelegate {

    @Autowired
    private ImagePortalUserRepository imagePortalUserRepository;
    private ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
    private ImagePortalUser updatedImagePortalUser;

    @Autowired
    private MailService mailService;

    @Override
    public ResponseEntity<Share> shareImages(Share body) {
        try {
            mailService.sendEmail(body);
        } catch (MailException mailException) {
            System.out.println(mailException);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

}
