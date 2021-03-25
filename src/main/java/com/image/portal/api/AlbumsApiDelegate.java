package com.image.portal.api;

import com.image.portal.model.Album;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link AlbumsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07.734618300-05:00[America/Chicago]")
public interface AlbumsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /albums/ : get all albums
     * Returns all albums
     *
     * @return successful operation (status code 200)
     * @see AlbumsApi#getAlbums
     */
    default ResponseEntity<List<Album>> getAlbums() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"id\" : 1, \"name\" : \"Swim meet St. Louis Mar 2021\", \"description\" : \"St. Peters RecPlex Swimming\", \"created\" : \"2021-03-15T01:44:51.756+0000\", \"images\" : [ ] }, { \"id\" : 2, \"name\" : \"Swim meet St. Louis Jan 2021\", \"description\" : \"St. Peters RecPlex Swimming\", \"created\" : \"2021-01-15T01:44:51.756+0000\", \"images\" : [ ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
