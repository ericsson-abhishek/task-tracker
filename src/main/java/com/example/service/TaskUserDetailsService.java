package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.models.User;
import com.example.models.UserRole;
import com.example.repos.UserRepo;

@Service
public class TaskUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String uName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		System.out.println("Name entered in the page is " + uName);
		User dbUser = userRepo.findBySignum(uName);

		System.out.println(userRepo.findBySignum(uName));

		if (dbUser != null) {
			List<UserRole> usrRoles = dbUser.getAllroles();
			List<GrantedAuthority> auths = new ArrayList<>();
			for (UserRole usrRole : usrRoles) {
				GrantedAuthority auth = new SimpleGrantedAuthority(usrRole.getRole().getRoleName());
				auths.add(auth);
			}
			org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
					dbUser.getSignum(), dbUser.getPassword(), auths);
			
			return user;

		} else {

			throw new UsernameNotFoundException("Not found");
		}

	}

}
