package com.image.portal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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
