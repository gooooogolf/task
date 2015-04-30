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
@Table(name="COMPANY")
public class Company implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1301954879737136137L;

	@Id
	@GeneratedValue
	@Column(name = "COMPANY_ID")
	private int id;
	
	@Column(name = "COMPANY_NAME")
	private String name;
	
	@Column(name = "COMPANY_ADDRESS")
	private String address;
	
	@Column(name = "COMPANY_DESCRIPTON")
	private String description;
	
	@Column(name = "COMPANY_PHONE")
	private String phone;

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int id, String name, String address, String description,
			String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Dealer [id=" + id + ", name=" + name + ", address=" + address
				+ ", description=" + description + ", phone=" + phone + "]";
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
