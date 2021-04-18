package com.image.portal.service;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.image.portal.model.Image;
import com.image.portal.utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AmazonS3Service extends AmazonClientService {

    /**
     * Uploads a multipart file to Amazon S3. This is a wrapper class with some stubbed out validation.
     *
     * @param multipartFile
     * @return
     */
    public String uploadImageToAmazon(MultipartFile multipartFile) {

/*        // Additional file validation that is not being used presently.
        List<String> validExtensions = Arrays.asList("jpeg", "jpg", "png");

        // Get extension of MultipartFile
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());*/

        return uploadMultipartFile(multipartFile);
    }

    /**
     * Deletes an image, relies on the "location" attribute of an Image object
     *
     * @param image
     */
    public void removeImageFromAmazon(Image image) {
        String fileName = image.getLocation().substring(image.getLocation().lastIndexOf("/") + 1);
        getClient().deleteObject(new DeleteObjectRequest(getBucketName(), fileName));
    }

    /**
     * Performs the actual uploading. As part of the process it temporarily parses a file, hence the delete.
     * This also generates a unique file name as part of the process, so we do not accidentally overwrite.
     *
     * @param multipartFile
     * @return Returns the location of the file
     */
    private String uploadMultipartFile(MultipartFile multipartFile) {
        String fileUrl = "Upload Unsuccessful!";

        try {
            // Get the file from MultipartFile.
            File file = FileUtils.convertMultipartToFile(multipartFile);

            // Extract the file name.
            String fileName = FileUtils.generateFileName(multipartFile);

            // Upload file.
            uploadPublicFile(fileName, file);

            // Delete the file and get the File Url.
            file.delete();
            fileUrl = getUrl().concat(fileName);
        } catch (IOException e) {

        }

        return fileUrl;
    }

    /**
     * Actual concrete implementation for the upload
     *
     * @param fileName
     * @param file
     */
    private void uploadPublicFile(String fileName, File file) {
        getClient().putObject(new PutObjectRequest(getBucketName(), fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }
}
