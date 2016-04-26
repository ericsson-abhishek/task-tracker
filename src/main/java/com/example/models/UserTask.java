package com.example.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 * Entity implementation class for Entity: UserTask
 *
 */
@Entity

public class UserTask implements Serializable {

	@ManyToOne
	@JoinColumn(name="signum")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="taskId")
	private Task task;   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userTaskId;
	private static final long serialVersionUID = 1L;

	public UserTask() {
		super();
	}   
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}   
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}   
	public Integer getUserTaskId() {
		return this.userTaskId;
	}

	public void setUserTaskId(Integer userTaskId) {
		this.userTaskId = userTaskId;
	}
   
}
