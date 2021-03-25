package com.image.portal.repository;

import com.image.portal.model.Album;
import com.image.portal.model.ImagePortalUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ImagePortalUserRepository extends MongoRepository<ImagePortalUser, String> {

    public ImagePortalUser findByUsername(String username);

    public Optional<ImagePortalUser> findById(String _id);

    public Album findAlbumById(String id);


}
