package com.image.portal.configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.image.portal.repository"})
public class MongoDbConfig {


}
