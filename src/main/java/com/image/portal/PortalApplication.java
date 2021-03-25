package com.image.portal;

import com.image.portal.repository.ImagePortalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Import(MongoDbConfig.class)
@SpringBootApplication
public class PortalApplication {

	@Autowired
	private ImagePortalUserRepository imagePortalUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

}
