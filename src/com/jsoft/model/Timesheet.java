/**
 * 
 */
package com.jsoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.jsoft.util.JsonDateSerializer;

/**
 * @author Sirimongkol
 * ระวัง @JsonSerialize(using=JsonDateSerializer.class) เวลาเปลี่ยน Model
 */
@Entity
@Table(name="TIMESHEET")
public class Timesheet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4097989296768899248L;

	@Id
	@GeneratedValue
	@Column(name = "TIMESHEET_ID")
	private int id;
		
	@Column(name = "TIMESHEET_CONTACT_NAME")
	private String contactName;
	
	@Column(name = "TIMESHEET_CONTACT_POSITION")
	private String contactPosition;
	
	@Column(name = "TIMESHEET_CONTACT_PHONE")
	private String contactPhone;
	
	@Column(name = "TIMESHEET_DESC", columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne
    @JoinColumn(name="USER_NAME", referencedColumnName = "USER_NAME", insertable = true, updatable = true)
	private User userModify;
	
	@ManyToOne
    @JoinColumn(name="JOB_ID", referencedColumnName = "JOB_ID", insertable = true, updatable = true)
	private Job job;
	
	@ManyToOne
    @JoinColumn(name="STATUS_ID", referencedColumnName = "STATUS_ID", insertable = true, updatable = true)
	private Status status;
	
	@ManyToOne
    @JoinColumn(name="ORG_ID", referencedColumnName = "ORG_ID", insertable = true, updatable = true)
	private Organization organization;

	@ManyToOne
    @JoinColumn(name="UPLOAD_ID", referencedColumnName = "UPLOAD_ID", insertable = false, updatable = true)
	private UploadFile uploadFile;

	@Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;

	@Column(name = "EFFECTIVE_REMIND_DATE")
    private Date effectiveRemindDate;

	@ManyToOne
    @JoinColumn(name="DEALER_ID", referencedColumnName = "DEALER_ID", insertable = true, updatable = true)
	private Dealer dealer;

	@Column(name = "TIMESHEET_BUDGET_YEAR")
	private String budgetYear;
	
	@Column(name = "TIMESHEET_BUDGET")
	private String budget;
	
	@Column(name = "TIMESHEET_RESULT")
	private String result;
	
	public Timesheet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPosition() {
		return contactPosition;
	}

	public void setContactPosition(String contactPosition) {
		this.contactPosition = contactPosition;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public UploadFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(UploadFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEffectiveRemindDate() {
		return effectiveRemindDate;
	}

	public void setEffectiveRemindDate(Date effectiveRemindDate) {
		this.effectiveRemindDate = effectiveRemindDate;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public User getUserModify() {
		return userModify;
	}

	public void setUserModify(User userModify) {
		this.userModify = userModify;
	}

	public String getBudgetYear() {
		return budgetYear;
	}

	public void setBudgetYear(String budgetYear) {
		this.budgetYear = budgetYear;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Timesheet(int id, String contactName, String contactPosition,
			String contactPhone, String description, User userModify, Job job,
			Status status, Organization organization, UploadFile uploadFile,
			Date effectiveDate, Date effectiveRemindDate, Dealer dealer,
			String budgetYear, String budget, String result) {
		super();
		this.id = id;
		this.contactName = contactName;
		this.contactPosition = contactPosition;
		this.contactPhone = contactPhone;
		this.description = description;
		this.userModify = userModify;
		this.job = job;
		this.status = status;
		this.organization = organization;
		this.uploadFile = uploadFile;
		this.effectiveDate = effectiveDate;
		this.effectiveRemindDate = effectiveRemindDate;
		this.dealer = dealer;
		this.budgetYear = budgetYear;
		this.budget = budget;
		this.result = result;
	}

	@Override
	public String toString() {
		return "Timesheet [id=" + id + ", contactName=" + contactName
				+ ", contactPosition=" + contactPosition + ", contactPhone="
				+ contactPhone + ", description=" + description
				+ ", userModify=" + userModify + ", job=" + job + ", status="
				+ status + ", organization=" + organization + ", uploadFile="
				+ uploadFile + ", effectiveDate=" + effectiveDate
				+ ", effectiveRemindDate=" + effectiveRemindDate + ", dealer="
				+ dealer + ", budgetYear=" + budgetYear + ", budget=" + budget
				+ ", result=" + result + "]";
	}


	

	
}
