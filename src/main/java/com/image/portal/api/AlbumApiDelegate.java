package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.model.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

/**
 * A delegate to be called by the {@link AlbumApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07.734618300-05:00[America/Chicago]")
public interface AlbumApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /album/ : Add new album
     *
     * @param body Album object that needs to be added (required)
     * @return successful operation (status code 200)
     * @see AlbumApi#addAlbum
     */
    default ResponseEntity<Void> addAlbum(Album body) {
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    /**
     * POST /album/{albumId}/image/ : Add new image to album
     *
     * @param albumId Album id to perform operation on (required)
     * @param body Image object that needs to be added (required)
     * @return Operation Successful (status code 200)
     *         or Unable to locate album (status code 404)
     * @see AlbumApi#addImageToAlbum
     */
    default ResponseEntity<Image> addImageToAlbum(String albumId,
        Image body) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"id\" : 1, \"name\" : \"12312312.png\", \"tag\" : \"ID-123145\", \"location\" : \"https://s3.amazonaws.com/TEST/f82dd4ac221b.png\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /album/{albumId} : Deletes an album
     *
     * @param albumId Album id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Album not found (status code 404)
     * @see AlbumApi#deleteAlbum
     */
    default ResponseEntity<Void> deleteAlbum(String albumId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /album/{albumId}/image/{imageId} : Deletes an image via album and image id
     *
     * @param albumId Album id to perform operation on (required)
     * @param imageId image id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Image not found (status code 404)
     * @see AlbumApi#deleteImageByAlbumIdAndImageId
     */
    default ResponseEntity<Void> deleteImageByAlbumIdAndImageId(String albumId,
        Long imageId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /album/{albumId} : Find album by ID
     * Returns a single album
     *
     * @param albumId Album id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Album not found (status code 404)
     * @see AlbumApi#getAlbumById
     */
    default ResponseEntity<Album> getAlbumById(String albumId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"id\" : 1, \"name\" : \"Swim meet St. Louis Mar 2021\", \"description\" : \"St. Peters RecPlex Swimming\", \"created\" : \"2021-03-15T01:44:51.756+0000\", \"images\" : [ ] } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /album/{albumId}/image/{imageId} : Find image by album id then image id
     * Returns a single image
     *
     * @param albumId Album id to perform operation on (required)
     * @param imageId image id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied or invalid payload (status code 400)
     *         or album or image not found (status code 404)
     * @see AlbumApi#getImageByAlbumIdAndImageId
     */
    default ResponseEntity<Image> getImageByAlbumIdAndImageId(String albumId,
        Long imageId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"id\" : 1, \"name\" : \"12312312.png\", \"tag\" : \"ID-123145\", \"location\" : \"https://s3.amazonaws.com/TEST/f82dd4ac221b.png\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /album/{albumId}/images/ : Return images for album
     * Returns all images for a given album
     *
     * @param albumId Album id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or album not found (status code 404)
     * @see AlbumApi#getImagesByAlbumId
     */
    default ResponseEntity<List<Image>> getImagesByAlbumId(String albumId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"id\" : 1, \"name\" : \"12312312.png\", \"tag\" : \"ID-123145\", \"location\" : \"https://s3.amazonaws.com/TEST/f82dd4ac221b.png\" }, { \"id\" : 2, \"name\" : \"12312315.png\", \"tag\" : \"ID-123199\", \"location\" : \"https://s3.amazonaws.com/TEST/f82dd4ac100b.png\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /album/{albumId}/image/{imageId} : Update an existing image
     *
     * @param albumId Album id to perform operation on (required)
     * @param imageId image id to perform operation on (required)
     * @param body Image object that needs to be updated (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Image not found (status code 404)
     * @see AlbumApi#updateImage
     */
    default ResponseEntity<Void> updateImage(String albumId,
        Long imageId,
        Image body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
