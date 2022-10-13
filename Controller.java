package com.aws.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.aws.upload.service.ServiceClass;

@RestController
public class Controller {
	
	@Autowired
	private ServiceClass service;
	
	@PostMapping("/uploadfile")
	public String uploadfile(@RequestParam MultipartFile file) {
		return service.upload(file);
		
	}
	

}








