package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

@SpringBootApplication
public class TaskTrackerApplication {

	public static void main(String[] args) {
		System.out.println("TaskTracker Is starting");
		SpringApplication.run(TaskTrackerApplication.class, args);
	}
	
}
