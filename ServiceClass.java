package com.aws.upload.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectResult;


@Service
public class ServiceClass implements Services {
	
	String bucket ="bucket181101";
	
	private  final AmazonS3 s3;

	public ServiceClass(AmazonS3 s3){
		this.s3 = s3;
		
		
	}
	
	@Override
	public String upload(MultipartFile file) {
	    String originalFilename = file.getOriginalFilename();
        try {
            File file1 = convertMultiPartToFile(file);
            PutObjectResult putObjectResult = s3.putObject(bucket, originalFilename, file1);
            return putObjectResult.getContentMd5();
        } catch (IOException e) {
            throw  new RuntimeException(e);
        }

	}
	
	private File convertMultiPartToFile(MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }

}
