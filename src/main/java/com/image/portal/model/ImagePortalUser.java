package com.image.portal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.IntStream;

@Document(collection = "imagePortalUsers")
public class ImagePortalUser {
    @Id
    private String _id;
    private String username;
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

    private Album findAlbumById(String albumId) {
        return this.albums.stream()
                .filter(singleAlbum -> singleAlbum.getId().equals(albumId))
                .findAny()
                .orElse(null);
    }

    public void addNewImageToAlbum(String albumId, Image image) {
        // find the right album from the albums list
/*        Album albumToUpdate = this.albums.stream()
                .filter(singleAlbum -> singleAlbum.getId().equals(album.getId()))
                .findAny()
                .orElse(null);*/

/*        Album albumToUpdate = this.albums.stream()
                .filter(singleAlbum -> singleAlbum.getId().equals(albumId))
                .findAny()
                .orElse(null);*/

        Album albumToUpdate = findAlbumById(albumId);

        // build an album with our updated image
        albumToUpdate.getImages().add(image);

        // replace our album in the existing list
        replaceAlbum(albumToUpdate);
    }

    public void removeAlbum(String albumId) {
        this.albums.removeIf(e -> e.getId().equals(albumId));
    }

    // TODO: WIP
    public void deleteImageFromAlbum(String albumId, Image image) {
        // get album to update
        Album albumToUpdate = findAlbumById(albumId);

        // find specific image


        // delete image

        // send updated album
        replaceAlbum(albumToUpdate);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ImagePortalUser{");
        sb.append("id=").append(_id);
        sb.append(", username=").append(username);
        sb.append(", firstName=").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", albums=").append(albums);
        sb.append('}');
        return sb.toString();
    }

}
