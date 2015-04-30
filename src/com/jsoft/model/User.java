/**
 * 
 */
package com.jsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sirimongkol
 *
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3866082807860635054L;
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "USER_NAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "USER_DESC")
	private String description;
	
	@Column(name = "ROLE_ID")
	private int roleId;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User(int id, String username, String password, String description,
			int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.description = description;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", description=" + description + ", roleId="
				+ roleId + "]";
	}


	


	
	
}
