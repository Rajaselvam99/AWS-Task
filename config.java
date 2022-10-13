package com.aws.upload.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class config{
   
   
   @Bean
   public AmazonS3 getUser() {  

	return (AmazonS3) AmazonS3ClientBuilder.standard()
			.withRegion("eu-west-2").build();
   
   }
	     
   
   }
