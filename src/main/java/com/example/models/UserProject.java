package com.example.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * Entity implementation class for Entity: UserProject
 *
 */
@Entity

public class UserProject implements Serializable {

	@ManyToOne
	@JoinColumn(name="signum")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="projectId")
	private Project project;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userProjectId;
	private static final long serialVersionUID = 1L;

	public UserProject() {
		super();
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}   
	public Integer getUserProjectId() {
		return this.userProjectId;
	}

	public void setUserProjectId(Integer userProjectId) {
		this.userProjectId = userProjectId;
	}
   
}
