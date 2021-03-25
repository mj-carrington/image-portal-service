package com.image.portal.service;

import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import org.springframework.stereotype.Service;

import static com.image.portal.constants.ImagePortalEnum.MVP_USERNAME;

@Service
public class ImagePortalUserService {

    public ImagePortalUser retrieveImagePortalUser(ImagePortalUserRepository imagePortalUserRepository) {
        return retrieveMvpUser(imagePortalUserRepository);
    }

    private ImagePortalUser retrieveMvpUser(ImagePortalUserRepository imagePortalUserRepository) {
        return imagePortalUserRepository.findByUsername(MVP_USERNAME.getValue());
    }

    // TODO: Throw exception here if ID is empty
    public String extractImagePortalUserId(ImagePortalUserRepository imagePortalUserRepository) {
        ImagePortalUser imagePortalUser = retrieveMvpUser(imagePortalUserRepository);
        return imagePortalUser.getId();
    }
}
