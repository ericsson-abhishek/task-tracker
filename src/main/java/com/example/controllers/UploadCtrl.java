package com.example.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

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
	
	
	@RequestMapping(path="/getCurrentUser",method=RequestMethod.GET)
	public Map<String, String> getUserName()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null)
		{
			System.out.println("got the auth");
			return Collections.singletonMap("name",authentication.getName());
		}
		else
		{
			System.out.println("got no auth");
			 return Collections.singletonMap("name","none");
		}
	}
	@ApiOperation("This Method is used to upload User's profile picture")
	@RequestMapping(value="/uploadProfilePic", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String upload(
			@ApiParam("requestFile expects a multipart file request")
			@RequestParam("file") MultipartFile requestFile,
			MultipartHttpServletRequest  request) {

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
	
	@RequestMapping(value="/uploadComment", method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String uploadComment(@RequestParam("file") MultipartFile [] requestFile,@RequestParam(name="comment",required=false)String comment,MultipartHttpServletRequest  request) {

		System.out.println("This method invoked for"+comment);
		
	    //org.springframework.web.multipart.MultipartHttpServletRequest
//	    MultipartHttpServletR equest mRequest;
//	    mRequest = (MultipartHttpServletRequest) request;
//
//	    Iterator<String> itr = mRequest.getFileNames();
//	    while (itr.hasNext()) {
//	        //org.springframework.web.multipart.MultipartFile
//	        MultipartFile mFile = mRequest.getFile(itr.next());
//	        String fileName = mFile.getOriginalFilename();
		for(int i=0;i<requestFile.length;i++)
		{
			System.out.println("*****"+ requestFile[i].getOriginalFilename());
		}
	        String s = System.nanoTime()+"";
	        return "{\"result\":\""+s+"\"}";

	        //To copy the file to a specific location in machine.
	        //File file = new File('path/to/new/location');
	        //FileCopyUtils.copy(mFile.getBytes(), file); //This will copy the file to the specific location.
	    }
	
	

}
