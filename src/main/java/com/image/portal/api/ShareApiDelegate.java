package com.image.portal.api;

import com.image.portal.model.Share;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

/**
 * A delegate to be called by the {@link ShareApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-03-24T09:41:07" +
        ".734618300-05:00[America/Chicago]")
public interface ShareApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /share/ : share image(s) to a customer
     *
     * @param body Image(s) that need to be shared (required)
     * @return Operation Successful (status code 200)
     * or Invalid input provided (status code 400)
     * @see ShareApi#shareImages
     */
    default ResponseEntity<Share> shareImages(Share body) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"imageUrls\" : [ \"imageUrls\", \"imageUrls\" ], \"email\" : \"email\"" +
                            " }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
