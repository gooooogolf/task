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
@Table(name="JOB")
public class Job implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -551334607367181119L;
	
	@Id
	@GeneratedValue
	@Column(name = "JOB_ID")
	private int id;
	
	@Column(name = "JOB_NAME")
	private String name;
	
	@Column(name = "JOB_DESC")
	private String description;

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", name=" + name + ", description="
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
	
//	@OneToMany(mappedBy="job", targetEntity=Timesheet.class, fetch=FetchType.EAGER)
//	private List<Timesheet> timesheets;


}
