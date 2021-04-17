package com.image.portal.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.IntStream;

@Document(collection = "imagePortalUsers")
public class ImagePortalUser {
    @Id
    private String _id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List<Album> albums;

    public String getId() {
        return _id;
    }

    public ImagePortalUser setId(String _id) {
        this._id = _id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ImagePortalUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() { return password; }

    public ImagePortalUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ImagePortalUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ImagePortalUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public ImagePortalUser setAlbums(List<Album> albums) {
        this.albums = albums;
        return this;
    }

    public void addNewAlbum(Album album) {
        this.albums.add(album);
    }

    private void replaceAlbum(Album album) {

        int index = IntStream.range(0, this.albums.size())
                .filter(i -> this.albums.get(i).getId().equals(album.getId()))
                .findFirst()
                .orElse(-1);

        this.albums.set(index, album);
    }

    public Album getAlbumById(String albumId) {
        return this.albums.stream()
                .filter(singleAlbum -> singleAlbum.getId().equals(albumId))
                .findAny()
                .orElse(null);
    }

    public Image getImageById(Album album, String imageId) {
        return album.getImages().stream()
                .filter(image -> image.getId().equals(imageId))
                .findAny()
                .orElse(null);
    }

    public Image getImageByAlbumId(String albumId, String imageId) {
        // 1 - find the album
        Album album = getAlbumById(albumId);
        // 2 - find the image & return
        return getImageById(album, imageId);
    }

    public List<Image> getImagesByAlbumId(String albumId) {
        return getAlbumById(albumId).getImages();
    }

    /**
     * Add new image meta data reference to an existing album
     * @param albumId album id
     * @param image Image object
     * @return return back the album we composed, mainly used for testing presently
     */
    public Album addNewImageToAlbum(String albumId, Image image) {
        Album albumToUpdate = getAlbumById(albumId);

        // build an album with our updated image
        albumToUpdate.getImages().add(image);

        // replace our album in the existing list
        replaceAlbum(albumToUpdate);

        return albumToUpdate;
    }

    /**
     * Perform meta data updates to an image. Internally calls updateImageMetadata()
     * @param albumId album id where the image resides
     * @param imageId Image Id that we want to update
     * @param image Changes to the meta data in the image we want to apply.
     * @return return back the album we composed, mainly used for testing presently
     */
    public Album updateImageToAlbum(String albumId, String imageId, Image image) {
        Album albumToUpdate = getAlbumById(albumId);
        image.setId(imageId);

        // find location of image by id
        int index = IntStream.range(0, albumToUpdate.getImages().size())
                .filter(i -> albumToUpdate.getImages().get(i).getId().equals(image.getId()))
                .findFirst()
                .orElse(-1);

        // stitch together new image
        Image updatedImage = updateImageMetadata(albumToUpdate.getImages().get(index), image);

        System.out.println("Updated Image Payload :: " + updatedImage.toString());
        // replace old image with new in MongoDB
        albumToUpdate.getImages().set(index, updatedImage);

        // put back together album and replace
        replaceAlbum(albumToUpdate);

        return albumToUpdate;
    }

    /**
     * Updates the existing attributes for an image already in an album
     * @param oldImage Existing Image object that we're updating
     * @param imageUpdates Changes to the Image object
     * @return updated image
     */
    private Image updateImageMetadata(Image oldImage, Image imageUpdates) {
        Image newImage = new Image();

        newImage.setId(oldImage.getId());
        newImage.setLocation(oldImage.getLocation());

        if (!StringUtils.isEmpty(imageUpdates.getName())) {
            newImage.setName(imageUpdates.getName());
        } else {
            newImage.setName(oldImage.getName());
        }
        if (!StringUtils.isEmpty(imageUpdates.getImageTag())) {
            newImage.setImageTag(imageUpdates.getImageTag());
        } else {
            newImage.setImageTag(oldImage.getImageTag());
        }
        return newImage;
    }

    /**
     * Removes entire album and contents
     * @param albumId
     */
    public void removeAlbum(String albumId) {
        this.albums.removeIf(e -> e.getId().equals(albumId));
    }

    /**
     * Removes a single image from an album. Will result in an error if the album and id do not exist.
     * @param albumId
     * @param imageId imageId
     * @return Returns the new album with 1 less image; mainly used for testing
     */
    public Album removeImageFromAlbum(String albumId, String imageId) {
        // get album to update
        Album albumToUpdate = getAlbumById(albumId);

        // find specific image and delete
        albumToUpdate.getImages().removeIf(e -> e.getId().equals(imageId));

        // send updated album
        replaceAlbum(albumToUpdate);

        return albumToUpdate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImagePortalUser{");
        sb.append("id=").append(_id);
        sb.append(", username=").append(username);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", password=").append(password);
        sb.append(", albums=").append(albums);
        sb.append('}');
        return sb.toString();
    }

}
