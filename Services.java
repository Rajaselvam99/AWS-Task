package com.aws.upload.service;

import org.springframework.web.multipart.MultipartFile;

public interface Services {
	
	
	String upload(MultipartFile file);
	

}
