package com.image.portal.service;

import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import org.springframework.stereotype.Service;

import static com.image.portal.constants.ImagePortalEnum.MVP_USERNAME;

@Service
public class ImagePortalUserService {

    /**
     * Retrieve an image portal user object from the MongoDB Repository
     * @param imagePortalUserRepository
     * @return
     */
    public ImagePortalUser retrieveImagePortalUser(ImagePortalUserRepository imagePortalUserRepository) {
        return retrieveMvpUser(imagePortalUserRepository);
    }

    /**
     * Retrieves our MVP user, this is done because our project only supports one user right now.
     * @param imagePortalUserRepository
     * @return
     */
    private ImagePortalUser retrieveMvpUser(ImagePortalUserRepository imagePortalUserRepository) {
        return imagePortalUserRepository.findByUsername(MVP_USERNAME.getValue());
    }
}
