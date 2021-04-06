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

    /**
     * Passes along an email address and list of images (a share object) to the mail service
     * @param body Image(s) that need to be shared (required)
     * @return body of the request and a 200 code
     */
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
