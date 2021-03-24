package com.image.portal.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * User
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07.734618300-05:00[America/Chicago]")
public class User   {

  @JsonProperty("userName")
  private String userName;

  @JsonProperty("password")
  private String password;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("location")
  private String location;

  @JsonProperty("bio")
  private String bio;

  @JsonProperty("twitter")
  private String twitter;

  @JsonProperty("linkedin")
  private String linkedin;

  @JsonProperty("personalSite")
  private String personalSite;

  @JsonProperty("userIcon")
  private String userIcon;

  @JsonProperty("shareAbleData")
  @Valid
  private List<ShareAbleData> shareAbleData = null;

  public User userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  @ApiModelProperty(value = "")


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  @ApiModelProperty(value = "")


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  */
  @ApiModelProperty(value = "")


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public User bio(String bio) {
    this.bio = bio;
    return this;
  }

  /**
   * Get bio
   * @return bio
  */
  @ApiModelProperty(value = "")


  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }

  public User twitter(String twitter) {
    this.twitter = twitter;
    return this;
  }

  /**
   * Get twitter
   * @return twitter
  */
  @ApiModelProperty(value = "")


  public String getTwitter() {
    return twitter;
  }

  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }

  public User linkedin(String linkedin) {
    this.linkedin = linkedin;
    return this;
  }

  /**
   * Get linkedin
   * @return linkedin
  */
  @ApiModelProperty(value = "")


  public String getLinkedin() {
    return linkedin;
  }

  public void setLinkedin(String linkedin) {
    this.linkedin = linkedin;
  }

  public User personalSite(String personalSite) {
    this.personalSite = personalSite;
    return this;
  }

  /**
   * Get personalSite
   * @return personalSite
  */
  @ApiModelProperty(value = "")


  public String getPersonalSite() {
    return personalSite;
  }

  public void setPersonalSite(String personalSite) {
    this.personalSite = personalSite;
  }

  public User userIcon(String userIcon) {
    this.userIcon = userIcon;
    return this;
  }

  /**
   * Get userIcon
   * @return userIcon
  */
  @ApiModelProperty(value = "")


  public String getUserIcon() {
    return userIcon;
  }

  public void setUserIcon(String userIcon) {
    this.userIcon = userIcon;
  }

  public User shareAbleData(List<ShareAbleData> shareAbleData) {
    this.shareAbleData = shareAbleData;
    return this;
  }

  public User addShareAbleDataItem(ShareAbleData shareAbleDataItem) {
    if (this.shareAbleData == null) {
      this.shareAbleData = new ArrayList<>();
    }
    this.shareAbleData.add(shareAbleDataItem);
    return this;
  }

  /**
   * Get shareAbleData
   * @return shareAbleData
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ShareAbleData> getShareAbleData() {
    return shareAbleData;
  }

  public void setShareAbleData(List<ShareAbleData> shareAbleData) {
    this.shareAbleData = shareAbleData;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.userName, user.userName) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.location, user.location) &&
        Objects.equals(this.bio, user.bio) &&
        Objects.equals(this.twitter, user.twitter) &&
        Objects.equals(this.linkedin, user.linkedin) &&
        Objects.equals(this.personalSite, user.personalSite) &&
        Objects.equals(this.userIcon, user.userIcon) &&
        Objects.equals(this.shareAbleData, user.shareAbleData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, password, firstName, lastName, location, bio, twitter, linkedin, personalSite, userIcon, shareAbleData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    bio: ").append(toIndentedString(bio)).append("\n");
    sb.append("    twitter: ").append(toIndentedString(twitter)).append("\n");
    sb.append("    linkedin: ").append(toIndentedString(linkedin)).append("\n");
    sb.append("    personalSite: ").append(toIndentedString(personalSite)).append("\n");
    sb.append("    userIcon: ").append(toIndentedString(userIcon)).append("\n");
    sb.append("    shareAbleData: ").append(toIndentedString(shareAbleData)).append("\n");
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

