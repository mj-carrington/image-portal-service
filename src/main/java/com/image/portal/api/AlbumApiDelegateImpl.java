package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.model.Image;
import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import com.image.portal.service.ImagePortalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AlbumApiDelegateImpl implements AlbumApiDelegate {

    @Autowired
    private ImagePortalUserRepository imagePortalUserRepository;
    private ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
    private ImagePortalUser updatedImagePortalUser;

    @Override
    public ResponseEntity<Void> addAlbum(Album album) {
        ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
        ImagePortalUser updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.addNewAlbum(album);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Image> addImageToAlbum(String albumId, Image body) {
        ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
        ImagePortalUser updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.addNewImageToAlbum(albumId, body);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteAlbum(String albumId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.removeAlbum(albumId);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
