package com.example.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Project;

public interface ProjectRepo extends JpaRepository<Project, Integer> {
	
	
	 List<Project> findAll() ;

}
