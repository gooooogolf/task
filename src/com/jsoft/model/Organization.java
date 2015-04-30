/**
 * 
 */
package com.jsoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sirimongkol
 *
 */
@Entity
@Table(name = "ORGINFO")
public class Organization implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1658598694355418481L;
	@Id
	@Column(name = "ORG_ID")
	private String orgId;
	
	@Column(name = "ORG_NAME")
	private String orgName;
	
	@Column(name = "AMPHUR_NAME")
	private String amphurName;
	
	@Column(name = "PROVINCE_NAME")
	private String provinceName;

	public Organization() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Organization(String orgId, String orgName, String amphurName,
			String provinceName) {
		super();
		this.orgId = orgId;
		this.orgName = orgName;
		this.amphurName = amphurName;
		this.provinceName = provinceName;
	}

	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgName=" + orgName
				+ ", amphurName=" + amphurName + ", provinceName="
				+ provinceName + "]";
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getAmphurName() {
		return amphurName;
	}

	public void setAmphurName(String amphurName) {
		this.amphurName = amphurName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}
