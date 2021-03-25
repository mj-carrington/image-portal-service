/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.image.portal.api;

import com.image.portal.model.Album;
import com.image.portal.model.Image;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07.734618300-05:00[America/Chicago]")
@Validated
@Api(value = "album", description = "the album API")
public interface AlbumApi {

    default AlbumApiDelegate getDelegate() {
        return new AlbumApiDelegate() {};
    }

    /**
     * POST /album/ : Add new album
     *
     * @param body Album object that needs to be added (required)
     * @return successful operation (status code 200)
     */
    @ApiOperation(value = "Add new album", nickname = "addAlbum", notes = "", tags={ "all albums page", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @PostMapping(
        value = "/album/",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> addAlbum(@ApiParam(value = "Album object that needs to be added" ,required=true )  @Valid @RequestBody Album body) {
        return getDelegate().addAlbum(body);
    }


    /**
     * POST /album/{albumId}/image/ : Add new image to album
     *
     * @param albumId Album id to perform operation on (required)
     * @param body Image object that needs to be added (required)
     * @return Operation Successful (status code 200)
     *         or Unable to locate album (status code 404)
     */
    @ApiOperation(value = "Add new image to album", nickname = "addImageToAlbum", notes = "", response = Image.class, tags={ "thumbnail view page", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Operation Successful", response = Image.class),
        @ApiResponse(code = 404, message = "Unable to locate album") })
    @PostMapping(
        value = "/album/{albumId}/image/",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Image> addImageToAlbum(@ApiParam(value = "Album id to perform operation on",required=true) @PathVariable("albumId") String albumId,@ApiParam(value = "Image object that needs to be added" ,required=true )  @Valid @RequestBody Image body) {
        return getDelegate().addImageToAlbum(albumId, body);
    }


    /**
     * DELETE /album/{albumId} : Deletes an album
     *
     * @param albumId Album id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Album not found (status code 404)
     */
    @ApiOperation(value = "Deletes an album", nickname = "deleteAlbum", notes = "", tags={ "thumbnail view page", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Album not found") })
    @DeleteMapping(
        value = "/album/{albumId}"
    )
    default ResponseEntity<Void> deleteAlbum(@ApiParam(value = "Album id to perform operation on",required=true) @PathVariable("albumId") String albumId) {
        return getDelegate().deleteAlbum(albumId);
    }


    /**
     * DELETE /album/{albumId}/image/{imageId} : Deletes an image via album and image id
     *
     * @param albumId Album id to perform operation on (required)
     * @param imageId image id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Image not found (status code 404)
     */
    @ApiOperation(value = "Deletes an image via album and image id", nickname = "deleteImageByAlbumIdAndImageId", notes = "", tags={ "image view page", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Image not found") })
    @DeleteMapping(
        value = "/album/{albumId}/image/{imageId}"
    )
    default ResponseEntity<Void> deleteImageByAlbumIdAndImageId(@ApiParam(value = "Album id to perform operation on",required=true) @PathVariable("albumId") String albumId,@ApiParam(value = "image id to perform operation on",required=true) @PathVariable("imageId") Long imageId) {
        return getDelegate().deleteImageByAlbumIdAndImageId(albumId, imageId);
    }


    /**
     * GET /album/{albumId} : Find album by ID
     * Returns a single album
     *
     * @param albumId Album id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Album not found (status code 404)
     */
    @ApiOperation(value = "Find album by ID", nickname = "getAlbumById", notes = "Returns a single album", response = Album.class, tags={ "all albums page","thumbnail view page","image view page", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Album.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Album not found") })
    @GetMapping(
        value = "/album/{albumId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Album> getAlbumById(@ApiParam(value = "Album id to perform operation on",required=true) @PathVariable("albumId") String albumId) {
        return getDelegate().getAlbumById(albumId);
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
     */
    @ApiOperation(value = "Find image by album id then image id", nickname = "getImageByAlbumIdAndImageId", notes = "Returns a single image", response = Image.class, tags={ "image view page", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Image.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied or invalid payload"),
        @ApiResponse(code = 404, message = "album or image not found") })
    @GetMapping(
        value = "/album/{albumId}/image/{imageId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Image> getImageByAlbumIdAndImageId(@ApiParam(value = "Album id to perform operation on",required=true) @PathVariable("albumId") String albumId,@ApiParam(value = "image id to perform operation on",required=true) @PathVariable("imageId") Long imageId) {
        return getDelegate().getImageByAlbumIdAndImageId(albumId, imageId);
    }


    /**
     * GET /album/{albumId}/images/ : Return images for album
     * Returns all images for a given album
     *
     * @param albumId Album id to perform operation on (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or album not found (status code 404)
     */
    @ApiOperation(value = "Return images for album", nickname = "getImagesByAlbumId", notes = "Returns all images for a given album", response = Image.class, responseContainer = "List", tags={ "thumbnail view page", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Image.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "album not found") })
    @GetMapping(
        value = "/album/{albumId}/images/",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Image>> getImagesByAlbumId(@ApiParam(value = "Album id to perform operation on",required=true) @PathVariable("albumId") String albumId) {
        return getDelegate().getImagesByAlbumId(albumId);
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
     */
    @ApiOperation(value = "Update an existing image", nickname = "updateImage", notes = "", tags={ "image view page", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation"),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Image not found") })
    @PutMapping(
        value = "/album/{albumId}/image/{imageId}",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> updateImage(@ApiParam(value = "Album id to perform operation on",required=true) @PathVariable("albumId") String albumId,@ApiParam(value = "image id to perform operation on",required=true) @PathVariable("imageId") Long imageId,@ApiParam(value = "Image object that needs to be updated" ,required=true )  @Valid @RequestBody Image body) {
        return getDelegate().updateImage(albumId, imageId, body);
    }

}
