package com.image.portal.api;

import com.image.portal.service.AmazonS3Service;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UploadApi {

    @Autowired
    private AmazonS3Service amazonS3Service;

    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid file uploaded")})
    @PostMapping("/mcarrington1/portal/1.0.0/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = amazonS3Service.uploadImageToAmazon(file);
            return ResponseEntity.ok(imageUrl);
        } catch (Exception e) {
            System.out.println("Exception occurred :" + e);
            return new ResponseEntity<>("Error Occurred: " + e, HttpStatus.BAD_REQUEST);
        }
    }
}