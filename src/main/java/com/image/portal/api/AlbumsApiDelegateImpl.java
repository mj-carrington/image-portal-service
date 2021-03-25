package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.repository.ImagePortalUserRepository;
import com.image.portal.service.ImagePortalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumsApiDelegateImpl implements AlbumsApiDelegate {

    @Autowired
    private ImagePortalUserRepository imagePortalUserRepository;

    @Override
    public ResponseEntity<List<Album>> getAlbums() {
        ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
        return ResponseEntity.ok(imagePortalUserService
                .retrieveImagePortalUser(imagePortalUserRepository)
                .getAlbums());
    }
}
