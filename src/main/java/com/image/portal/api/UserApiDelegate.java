package com.image.portal.api;

import com.image.portal.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

/**
 * A delegate to be called by the {@link UserApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07" +
        ".734618300-05:00[America/Chicago]")
public interface UserApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /user/ : Retrieve info about the user&#39;s account
     *
     * @return successful operation (status code 200)
     * or Invalid input provided (status code 400)
     * @see UserApi#getUserInfo
     */
    default ResponseEntity<User> getUserInfo() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"userName\" : \"mcarrington\", \"password\" : \"passwordpassword\", " +
                            "\"firstName\" : \"M.J.\", \"lastName\" : \"Carrington\", \"location\" : \"St. Louis, " +
                            "MO\", \"bio\" : \"I do computer-things.\", \"twitter\" : \"http://www.twitter.com\", " +
                            "\"linkedin\" : \"http://www.linkedin.com\", \"personalSite\" : \"http://www.google" +
                            ".com\", \"userIcon\" : \"https://s3.amazonaws.com/TEST/f82dd4ac221b.png\", " +
                            "\"shareAbleData\" : [ \"twitter\", true ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /user/login : Logs user into the system
     *
     * @param username The user name for login (required)
     * @param password The password for login in clear text (required)
     * @return successful operation (status code 200)
     * or Invalid input provided (status code 400)
     * @see UserApi#loginUser
     */
    default ResponseEntity<Void> loginUser(String username,
                                           String password) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /user/ : Add or update info about the account
     *
     * @return successful operation (status code 200)
     * or Invalid input provided (status code 400)
     * @see UserApi#updateUserInfo
     */
    default ResponseEntity<User> updateUserInfo() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"userName\" : \"mcarrington\", \"password\" : \"passwordpassword\", " +
                            "\"firstName\" : \"M.J.\", \"lastName\" : \"Carrington\", \"location\" : \"St. Louis, " +
                            "MO\", \"bio\" : \"I do computer-things.\", \"twitter\" : \"http://www.twitter.com\", " +
                            "\"linkedin\" : \"http://www.linkedin.com\", \"personalSite\" : \"http://www.google" +
                            ".com\", \"userIcon\" : \"https://s3.amazonaws.com/TEST/f82dd4ac221b.png\", " +
                            "\"shareAbleData\" : [ \"twitter\", true ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
