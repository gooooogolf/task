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
@Table(name = "UPLOAD_FILE")
public class UploadFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9075330378502632238L;
	@Id
	@Column(name = "UPLOAD_ID")
	@GeneratedValue
	private int id;
	
	@Column(name = "UPLOAD_NAME")
	private String name;
	
	@Column(name = "UPLOAD_SIZE")
	private int size;
	
	@Column(name = "URL")
	private String url;

	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadFile(int id, String name, int size, String url) {
		super();
		this.id = id;
		this.name = name;
		this.size = size;
		this.url = url;
	}

	@Override
	public String toString() {
		return "UploadFile [id=" + id + ", name=" + name + ", size=" + size
				+ ", url=" + url + "]";
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}
