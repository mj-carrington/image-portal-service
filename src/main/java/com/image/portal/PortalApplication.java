package com.image.portal;

import com.image.portal.repository.ImagePortalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Import(MongoDbConfig.class)
@SpringBootApplication
public class PortalApplication implements CommandLineRunner {

	@Autowired
	private ImagePortalUserRepository imagePortalUserRepository;

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
//		ImagePortalUser imagePortalUser = new ImagePortalUser();
//		imagePortalUser.setFirstName("M.J.").setLastName("Carrington");
//
//		imagePortalUserRepository.save(imagePortalUser);

		System.out.println(imagePortalUserRepository.findAll());
	}

}
