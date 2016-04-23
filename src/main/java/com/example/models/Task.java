package com.example.models;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.sql.Clob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Task
 *
 */
@Entity
@Table(name="TASK")
public class Task implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskId;
	
	//private Project projectId;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	private String status;
	private String priority;
	private String subject;
	private Integer percentageComplete;
	private Boolean reminder;
	

	@Temporal(TemporalType.DATE)
	private Date completionDate;
	


	private static final long serialVersionUID = 1L;

	public Task() {
		super();
	}   
	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}   
	/*public Integer getProjectId() {
		return this.projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}   
	public Date getStartDate() {
		return this.startDate;
	}*/

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}   
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}   
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}   
	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}   
	public Integer getPercentageComplete() {
		return this.percentageComplete;
	}

	public void setPercentageComplete(Integer percentageComplete) {
		this.percentageComplete = percentageComplete;
	}   
	public Boolean getReminder() {
		return this.reminder;
	}

	public void setReminder(Boolean reminder) {
		this.reminder = reminder;
	}
	
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)	
	private List<Reminder> reminders;

	public List<Reminder> getReminders() {
		return reminders;
	}
	public void setReminders(List<Reminder> reminders) {
		this.reminders = reminders;
	}
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)	
	private List<Comment> comments;

	
	
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	@ManyToOne
	@JoinColumn(name="projectId")
    private Project project;

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

	/*private int projectId;

	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	*/
	
	
}
