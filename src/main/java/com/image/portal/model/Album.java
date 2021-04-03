package com.image.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.RandomStringUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Album
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07.734618300-05:00[America/Chicago]")
public class Album   {
  @JsonProperty("id")
  private String albumId = RandomStringUtils.randomAlphanumeric(8);

  @JsonProperty("name")
  private String albumName;

  @JsonProperty("description")
  private String albumDescription;

  @JsonProperty("created")
  private String created = LocalDateTime.now().toString();

  @JsonProperty("images")
  @Valid
  private List<Image> images = null;

  public Album id(String id) {
    this.albumId = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return albumId;
  }

  public void setId(String id) {
    this.albumId = id;
  }

  public Album name(String name) {
    this.albumName = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return albumName;
  }

  public void setName(String name) {
    this.albumName = name;
  }

  public Album description(String description) {
    this.albumDescription = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(value = "")


  public String getDescription() {
    return albumDescription;
  }

  public void setDescription(String description) {
    this.albumDescription = description;
  }

  public Album created(String created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   * @return created
  */
  @ApiModelProperty(value = "")

  @Valid

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public Album images(List<Image> images) {
    this.images = images;
    return this;
  }

  public Album addImagesItem(Image imagesItem) {
    if (this.images == null) {
      this.images = new ArrayList<>();
    }
    this.images.add(imagesItem);
    return this;
  }

  /**
   * Get images
   * @return images
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<Image> getImages() {
    return images;
  }

  public void setImages(List<Image> images) {
    this.images = images;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Album album = (Album) o;
    return Objects.equals(this.albumId, album.albumId) &&
        Objects.equals(this.albumName, album.albumName) &&
        Objects.equals(this.albumDescription, album.albumDescription) &&
        Objects.equals(this.created, album.created) &&
        Objects.equals(this.images, album.images);
  }

  @Override
  public int hashCode() {
    return Objects.hash(albumId, albumName, albumDescription, created, images);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Album {\n");
    
    sb.append("    id: ").append(toIndentedString(albumId)).append("\n");
    sb.append("    name: ").append(toIndentedString(albumName)).append("\n");
    sb.append("    description: ").append(toIndentedString(albumDescription)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

