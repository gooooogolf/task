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
@Table(name="STATUS")
public class Status implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8849050187327138004L;
	@Id
	@GeneratedValue
	@Column(name = "STATUS_ID")
	private int id;
	
	@Column(name = "STATUS_NAME")
	private String name;
	
	@Column(name = "STATUS_DESC")
	private String description;

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + ", description="
				+ description + "]";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
//	@OneToMany(mappedBy="status", targetEntity=Timesheet.class, fetch=FetchType.EAGER)
//	private List<Timesheet> timesheets;

	
}
