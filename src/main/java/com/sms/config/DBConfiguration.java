package com.sms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.sms.repo.StudentRepository;
/**
 * 
 * @author Dilaj
 *
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
@PropertySource("classpath:mongo.properties")
public class DBConfiguration {

	@Value("${mongo.database}")
	private String database;
	
	@Value("${mongo.host}")
	private String host;
	
	@Value("${mongo.port}")
	private int port;
	
	@Value("${mongo.username}")
	private String username;
	
	@Value("${mongo.password}")
	private String password;

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		Mongo mongo = new Mongo(host, port);
		UserCredentials userCredentials = new UserCredentials(username,password);
		MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, database,userCredentials);
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory);
		return mongoTemplate;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	 
}
