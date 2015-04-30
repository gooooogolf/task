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
@Table(name = "ROLE")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3600231640121287933L;
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "NAME")
	private String name;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
