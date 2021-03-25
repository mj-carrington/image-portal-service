package com.image.portal.api;

import com.image.portal.model.ImagePortalUser;
import com.image.portal.repository.ImagePortalUserRepository;
import com.image.portal.service.ImagePortalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShareApiDelegateImpl implements ShareApiDelegate {

    @Autowired
    private ImagePortalUserRepository imagePortalUserRepository;
    private ImagePortalUserService imagePortalUserService = new ImagePortalUserService();
    private ImagePortalUser updatedImagePortalUser;

}
