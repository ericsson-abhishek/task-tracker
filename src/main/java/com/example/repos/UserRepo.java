package com.example.repos;

import org.springframework.data.repository.Repository;

import com.example.models.User;
import java.lang.String;
import java.util.List;

public interface UserRepo extends Repository<User, String> {
	User findBySignum(String signum);
	
	

}
