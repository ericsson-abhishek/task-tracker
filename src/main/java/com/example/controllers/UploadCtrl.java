package com.example.controllers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class UploadCtrl {
	
	@Autowired
	ServletContext servletContext; 
	
	@ResponseBody
	@RequestMapping(path="/photo*", method = RequestMethod.GET, produces =MediaType.IMAGE_JPEG_VALUE )
	public byte[] testphoto() throws IOException {
		System.out.println("--------------------photo");
	    InputStream in = UploadCtrl.class.getResourceAsStream("/white-wallpapers-14.jpg");
	    return IOUtils.toByteArray(in);
	}
	
	@ResponseBody
	@RequestMapping(path="/photo1*", method = RequestMethod.GET, produces =MediaType.IMAGE_JPEG_VALUE )
	public byte[] testphoto1() throws IOException {
		System.out.println("--------------------1");
	    InputStream in = UploadCtrl.class.getResourceAsStream("/Photo1.jpg");
	    return IOUtils.toByteArray(in);
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String upload(@RequestParam("file") MultipartFile requestFile,MultipartHttpServletRequest  request) {

		System.out.println("This method invoked");
		
	    //org.springframework.web.multipart.MultipartHttpServletRequest
//	    MultipartHttpServletR equest mRequest;
//	    mRequest = (MultipartHttpServletRequest) request;
//
//	    Iterator<String> itr = mRequest.getFileNames();
//	    while (itr.hasNext()) {
//	        //org.springframework.web.multipart.MultipartFile
//	        MultipartFile mFile = mRequest.getFile(itr.next());
//	        String fileName = mFile.getOriginalFilename();
	        System.out.println("*****"+ requestFile.getOriginalFilename());
	        String s = System.nanoTime()+"";
	        return "{\"result\":\""+s+"\"}";

	        //To copy the file to a specific location in machine.
	        //File file = new File('path/to/new/location');
	        //FileCopyUtils.copy(mFile.getBytes(), file); //This will copy the file to the specific location.
	    }

}
