package com.image.portal.repository;

import com.image.portal.model.ImagePortalUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagePortalUserRepository extends MongoRepository<ImagePortalUser, String> {

    public ImagePortalUser findByFirstName(String firstName);

    public ImagePortalUser findByUsername(String username);
}
