package com.example.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Entity implementation class for Entity: UserRole
 *
 */
@Entity
@Table( name = "UserRole",
uniqueConstraints = { @UniqueConstraint( columnNames = { "signum", "roleId" } ) } )
//@IdClass(UserRoleId.class)
@NamedQuery(query="select ur from UserRole ur where ur.user.signum= :signum AND ur.role.roleId= :roleId",name="UserRole.ifExists")
public class UserRole implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userRoleID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="signum")
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="roleId")
	private Role role;
	private static final long serialVersionUID = 1L;

	public UserRole() {
		super();
	}

	
	public int getUserRoleID() {
		return userRoleID;
	}


	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}   
   
}
