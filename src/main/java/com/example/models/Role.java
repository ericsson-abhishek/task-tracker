package com.example.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@NamedQuery(query="select r from Role r where r.roleName= :roleName", name = "Role.findRoleByRolename")
//@NamedQuery(name = "Role.findAll",query="select r from Role r")
public class Role implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;

	private String roleName;   


	//private List<User> users;


	/*@ManyToMany
	@JoinTable(name="user_role" , joinColumns= {@JoinColumn(name="roleId")},
	inverseJoinColumns= {@JoinColumn(name ="signum")})
	public List<User> getUsers() {
		return users;
	}

	@ManyToMany(mappedBy = "roles")
	public void setUsers(List<User> users) {
		this.users = users;
	}*/

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Role() {
		super();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/*@ManyToMany(targetEntity=User.class)
	private Set<User> users;


	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	 */

}
