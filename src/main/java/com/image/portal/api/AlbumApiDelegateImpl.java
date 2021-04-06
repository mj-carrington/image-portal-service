package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.model.Image;
import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import com.image.portal.service.AmazonS3Service;
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
    @Autowired
    private AmazonS3Service amazonS3Service;
    private ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
    private ImagePortalUser updatedImagePortalUser;

    /**
     * Add an album for a given portal user
     * @param album A single album object with various numbers of pictures
     * @return response entity only returns a 201
     */
    @Override
    public ResponseEntity<Void> addAlbum(Album album) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.addNewAlbum(album);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Add an image to an existing album. The only adds the meta data for the image, not the actual file.
     * @param albumId Album id to perform operation on (required)
     * @param body Image object that needs to be added (required)
     * @return response entity only returns a 201
     */
    @Override
    public ResponseEntity<Image> addImageToAlbum(String albumId, Image body) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.addNewImageToAlbum(albumId, body);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Deletes an album. Also makes a chained call to S3 to remove the file.
     * @param albumId Album id to perform operation on (required)
     * @return response entity only returns a 200 (if call is successful)
     */
    @Override
    public ResponseEntity<Void> deleteAlbum(String albumId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        // delete from S3
        List<Image> images = updatedImagePortalUser.getImagesByAlbumId(albumId);
        images.forEach((image) -> amazonS3Service.removeImageFromAmazon(image));
        // delete from MongoDB
        updatedImagePortalUser.removeAlbum(albumId);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Remove a single image from an album. Makes a chained call to S3 to remove the file.
     * @param albumId Album id to perform operation on (required)
     * @param imageId image id to perform operation on (required)
     * @return response entity returns a 200.
     */
    @Override
    public ResponseEntity<Void> deleteImageByAlbumIdAndImageId(String albumId, String imageId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        // delete from S3
        Image image = updatedImagePortalUser.getImageByAlbumId(albumId, imageId);
        amazonS3Service.removeImageFromAmazon(image);
        // delete from MongoDB
        updatedImagePortalUser.removeImageFromAlbum(albumId, imageId);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Retrieves an album object (with associated images) from a given album id
     * @param albumId Album id to perform operation on (required)
     * @return response entity returns a 200
     */
    @Override
    public ResponseEntity<Album> getAlbumById(String albumId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        Album album = updatedImagePortalUser.getAlbumById(albumId);
        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    /**
     * Retrieve a single image from a given album id and image id
     * @param albumId Album id to perform operation on (required)
     * @param imageId image id to perform operation on (required)
     * @return returns the image object (which includes a url for the file) and 200
     */
    @Override
    public ResponseEntity<Image> getImageByAlbumIdAndImageId(String albumId, String imageId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        Image image = updatedImagePortalUser.getImageByAlbumId(albumId, imageId);

        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    /**
     * Retrieves all images in a list
     * @param albumId Album id to perform operation on (required)
     * @return returns a list of image objects and a 200
     */
    @Override
    public ResponseEntity<List<Image>> getImagesByAlbumId(String albumId) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);
        updatedImagePortalUser.getAlbums();
        List<Image> images = updatedImagePortalUser.getImagesByAlbumId(albumId);

        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    /**
     * Updates a given image's meta data.
     * @param albumId Album id to perform operation on (required)
     * @param imageId image id to perform operation on (required)
     * @param body Image object that needs to be updated (required)
     * @return returns a 200
     */
    @Override
    public ResponseEntity<Void> updateImage(String albumId, String imageId, Image body) {
        updatedImagePortalUser = imagePortalUserService.retrieveImagePortalUser(imagePortalUserRepository);

        updatedImagePortalUser.updateImageToAlbum(albumId, imageId, body);
        imagePortalUserRepository.save(updatedImagePortalUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
