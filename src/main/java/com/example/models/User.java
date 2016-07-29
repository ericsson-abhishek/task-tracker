package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

	@Id
	private String signum;
	private String userName;
	private String password;

	//@Column(name="ImageId")
	private String imageId;
	
	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String signum, String userName, String password) {
		super();
		this.signum = signum;
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSignum() {
		return this.signum;
	}

	public void setSignum(String signum) {
		this.signum = signum;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name="user_role" , joinColumns= {@JoinColumn(name="signum" ,
	 * referencedColumnName = "id")}, inverseJoinColumns= {@JoinColumn(name
	 * ="roleId" , referencedColumnName = "id")}) public List<Role> getRoles() {
	 * return roles; } public void setRoles(List<Role> roles) { this.roles =
	 * roles; }
	 */

	@RestResource(exported=false)
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<UserRole> roles = new ArrayList<UserRole>();

	@RestResource(exported=false)
	public List<UserRole> getAllroles() {
		return roles;
	}
	
	@RestResource(exported=false)
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<UserTask> tasks = new ArrayList<UserTask>();
	@RestResource(exported=false)
	public List<UserTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<UserTask> tasks) {
		this.tasks = tasks;
	}

	
	

	/*
	 * @ManyToMany(targetEntity=Role.class) private Set<Role> roles;
	 * 
	 * public Set<Role> getRoles() { return roles; } public void
	 * setRoles(Set<Role> roles) { this.roles = roles; }
	 */

}
