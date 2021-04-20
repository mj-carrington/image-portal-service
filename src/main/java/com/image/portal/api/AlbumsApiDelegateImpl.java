package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.model.ImagePortalUser;
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
    private ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
    private ImagePortalUser updatedImagePortalUser;

    /**
     * Retrieves all albums for a given user.
     *
     * @return Returns a list of albums and a 200 code.
     */
    @Override
    public ResponseEntity<List<Album>> getAlbums() {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        List<Album> albums = updatedImagePortalUser.getAlbums();

        return ResponseEntity.ok(albums);
    }
}
