package com.image.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Image
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07.734618300-05:00[America/Chicago]")
public class Image   {
  @JsonProperty("id")
  private String imageId = RandomStringUtils.randomAlphanumeric(8);

  @JsonProperty("name")
  private String imageName;

  @JsonProperty("tag")
  private String imageTag;

  @JsonProperty("location")
  private String imageLocation;

  private String imageUpload;

  private MultipartFile file;

  public Image id(String id) {
    this.imageId = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getId() {
    return imageId;
  }

  public void setId(String id) {
    this.imageId = id;
  }

  public Image name(String name) {
    this.imageName = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return imageName;
  }

  public void setName(String name) {
    this.imageName = name;
  }

  public Image tag(String tag) {
    this.imageTag = tag;
    return this;
  }

  /**
   * Get tag
   * @return tag
  */
  @ApiModelProperty(value = "")


  public String getImageTag() {
    return imageTag;
  }

  public void setImageTag(String imageTag) {
    this.imageTag = imageTag;
  }

  public Image location(String location) {
    this.imageLocation = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  @ApiModelProperty(value = "")


  public String getLocation() {
    return imageLocation;
  }

  public void setLocation(String location) {
    this.imageLocation = location;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Image image = (Image) o;
    return Objects.equals(this.imageId, image.imageId) &&
        Objects.equals(this.imageName, image.imageName) &&
        Objects.equals(this.imageTag, image.imageTag) &&
        Objects.equals(this.imageLocation, image.imageLocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageId, imageName, imageTag, imageLocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Image {\n");
    
    sb.append("    id: ").append(toIndentedString(imageId)).append("\n");
    sb.append("    name: ").append(toIndentedString(imageName)).append("\n");
    sb.append("    tag: ").append(toIndentedString(imageTag)).append("\n");
    sb.append("    location: ").append(toIndentedString(imageLocation)).append("\n");
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

