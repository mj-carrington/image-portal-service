package com.image.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Share
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07.734618300-05:00[America/Chicago]")
public class Share   {
  @JsonProperty("imageUrls")
  @Valid
  private List<String> imageUrls = new ArrayList<>();

  @JsonProperty("email")
  private String email;

  public Share imageUrls(List<String> imageUrls) {
    this.imageUrls = imageUrls;
    return this;
  }

  public Share addImageUrlsItem(String imageUrlsItem) {
    this.imageUrls.add(imageUrlsItem);
    return this;
  }

  /**
   * Get imageUrls
   * @return imageUrls
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public List<String> getImageUrls() {
    return imageUrls;
  }

  public void setImageUrls(List<String> imageUrls) {
    this.imageUrls = imageUrls;
  }

  public Share email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Share share = (Share) o;
    return Objects.equals(this.imageUrls, share.imageUrls) &&
        Objects.equals(this.email, share.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageUrls, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Share {\n");
    
    sb.append("    imageUrls: ").append(toIndentedString(imageUrls)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

