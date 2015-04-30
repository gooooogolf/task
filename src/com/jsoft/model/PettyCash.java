/**
 * 
 */
package com.jsoft.model;

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
 *
 */
@Entity
@Table(name="PETTY_CASH")
public class PettyCash {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;
	
	@Column(name = "REQUEST_NUMBER")
	private String requestNumber;
	
	@Column(name = "REQUEST_DATE")
    private Date requestDate;
	
	@Column(name = "REQUEST_DETAIL")
	private String requestDetail;
	
	@Column(name = "STATUSCODE")
	private String statusCode;
	
	@ManyToOne
    @JoinColumn(name="WITHDRAWAL", referencedColumnName = "USER_NAME", insertable = true, updatable = true)
	private User withdrawal;
	
	@Column(name = "WITHDRAWAL_DATE")
    private Date withdrawalDate;
	
	@ManyToOne
    @JoinColumn(name="ENDORSEE", referencedColumnName = "USER_NAME", insertable = true, updatable = true)
	private User endorsee;
	
	@Column(name = "ENDORSEE_DATE")
    private Date endorseeDate;
	
	@ManyToOne
    @JoinColumn(name="ORG_ID", referencedColumnName = "ORG_ID", insertable = true, updatable = true)
	private Organization organization;
	
	@ManyToOne
    @JoinColumn(name="DEALER_ID", referencedColumnName = "DEALER_ID", insertable = true, updatable = true)
	private Dealer dealer;
	
	@ManyToOne
    @JoinColumn(name="USER_NAME", referencedColumnName = "USER_NAME", insertable = true, updatable = true)
	private User userModify;

	public PettyCash() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PettyCash(int id, Date effectiveDate, String requestNumber,
			Date requestDate, String requestDetail, String statusCode,
			User withdrawal, Date withdrawalDate, User endorsee,
			Date endorseeDate, Organization organization, Dealer dealer,
			User userModify) {
		super();
		this.id = id;
		this.effectiveDate = effectiveDate;
		this.requestNumber = requestNumber;
		this.requestDate = requestDate;
		this.requestDetail = requestDetail;
		this.statusCode = statusCode;
		this.withdrawal = withdrawal;
		this.withdrawalDate = withdrawalDate;
		this.endorsee = endorsee;
		this.endorseeDate = endorseeDate;
		this.organization = organization;
		this.dealer = dealer;
		this.userModify = userModify;
	}

	@Override
	public String toString() {
		return "PettyCash [id=" + id + ", effectiveDate=" + effectiveDate
				+ ", requestNumber=" + requestNumber + ", requestDate="
				+ requestDate + ", requestDetail=" + requestDetail
				+ ", statusCode=" + statusCode + ", withdrawal=" + withdrawal
				+ ", withdrawalDate=" + withdrawalDate + ", endorsee="
				+ endorsee + ", endorseeDate=" + endorseeDate
				+ ", organization=" + organization + ", dealer=" + dealer
				+ ", userModify=" + userModify + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestDetail() {
		return requestDetail;
	}

	public void setRequestDetail(String requestDetail) {
		this.requestDetail = requestDetail;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public User getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(User withdrawal) {
		this.withdrawal = withdrawal;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getWithdrawalDate() {
		return withdrawalDate;
	}

	public void setWithdrawalDate(Date withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	public User getEndorsee() {
		return endorsee;
	}

	public void setEndorsee(User endorsee) {
		this.endorsee = endorsee;
	}

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getEndorseeDate() {
		return endorseeDate;
	}

	public void setEndorseeDate(Date endorseeDate) {
		this.endorseeDate = endorseeDate;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public User getUserModify() {
		return userModify;
	}

	public void setUserModify(User userModify) {
		this.userModify = userModify;
	}
	
	
}
