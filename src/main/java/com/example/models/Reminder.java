package com.example.models;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Entity implementation class for Entity: Reminder
 *
 */
@Entity

public class Reminder implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer reminderId;
	
	
	//private Task taskId;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	private String time;
	private static final long serialVersionUID = 1L;

	public Reminder() {
		super();
	}   
	 
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public Integer getReminderId() {
		return reminderId;
	}
	public void setReminderId(Integer reminderId) {
		this.reminderId = reminderId;
	}
	
	@ManyToOne
	@JoinColumn(name="taskId")
	private Task task;

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	
	
   
}
