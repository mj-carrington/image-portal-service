package com.image.portal.api;

import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserApiDelegateImpl implements UserApiDelegate {

    @Autowired
    private ImagePortalUserRepository imagePortalUserRepository;

    @Override
    public ResponseEntity<Void> loginUser(String username, String password) {
        ImagePortalUser imagePortalUser = imagePortalUserRepository.findByUsername(username);

        if (imagePortalUser.getPassword().equals(password)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
