package com.example.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.models.User;

@RepositoryRestResource(path="/users")
public interface UserRepo extends CrudRepository<User, String> {
	User findBySignum(@Param("signum")String signum);
	
	

}
