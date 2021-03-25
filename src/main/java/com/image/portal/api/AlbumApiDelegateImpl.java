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

import java.util.List;


@Service
public class AlbumApiDelegateImpl implements AlbumApiDelegate {

    @Autowired
    private ImagePortalUserRepository imagePortalUserRepository;
    private ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
    private ImagePortalUser updatedImagePortalUser;

    @Override
    public ResponseEntity<Void> addAlbum(Album album) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.addNewAlbum(album);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Image> addImageToAlbum(String albumId, Image body) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
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

    @Override
    public ResponseEntity<Void> deleteImageByAlbumIdAndImageId(String albumId, String imageId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.removeImageFromAlbum(albumId, imageId);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> getAlbumById(String albumId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        Album album = updatedImagePortalUser.getAlbumById(albumId);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Image> getImageByAlbumIdAndImageId(String albumId, String imageId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        Image image = updatedImagePortalUser.getImageByAlbumId(albumId, imageId);

        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Image>> getImagesByAlbumId(String albumId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.getAlbums();
        List<Image> images = updatedImagePortalUser.getImagesByAlbumId(albumId);

        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateImage(String albumId, String imageId, Image body) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);

        updatedImagePortalUser.updateImageToAlbum(albumId, imageId, body);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
