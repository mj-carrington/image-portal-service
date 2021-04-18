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

    /**
     * Logs a user in, given a valid password and username.
     *
     * @param username The user name for login (required)
     * @param password The password for login in clear text (required)
     * @return either a 200 or 401, depending on whether the information provided is valid or not.
     */
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
