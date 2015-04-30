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

/**
 * @author Sirimongkol
 *
 */
@Entity
@Table(name="J_STOCK")
public class Stock {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "SEQ")
	private String sequence;
	
	@Column(name = "YEAR")
	private String stockYear;
	
	@Column(name = "GENERATION")
	private String generation;
	
	@Column(name = "RECEIVER")
	private String receiver;
	
	@Column(name = "AMP")
	private String amp;
	
	@Column(name = "SERIAL_NUMBER")
	private String serialNumber;
		
	@Column(name = "LICENSE_REQUEST")
	private String licenseRequest;
	
	@Column(name = "LICENSE_NUMBER")
	private String licenseNumber;
	
	@Column(name = "STOCK_DESC", columnDefinition = "TEXT")
	private String description;
		
	@Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;
	
	@ManyToOne
    @JoinColumn(name="ORG_ID", referencedColumnName = "ORG_ID", insertable = true, updatable = true)
	private Organization organization;
	
	@ManyToOne
    @JoinColumn(name="DEALER_ID", referencedColumnName = "DEALER_ID", insertable = true, updatable = true)
	private Dealer dealer;

	@ManyToOne
    @JoinColumn(name="USER_NAME", referencedColumnName = "USER_NAME", insertable = true, updatable = true)
	private User userModify;
	
	
	@Override
	public String toString() {
		return "Stock [id=" + id + ", sequence=" + sequence + ", stockYear="
				+ stockYear + ", generation=" + generation + ", receiver="
				+ receiver + ", amp=" + amp + ", serialNumber=" + serialNumber
				+ ", licenseRequest=" + licenseRequest + ", licenseNumber="
				+ licenseNumber + ", description=" + description
				+ ", effectiveDate=" + effectiveDate + ", organization="
				+ organization + ", dealer=" + dealer + ", userModify="
				+ userModify + "]";
	}

	public Stock(int id, String sequence, String stockYear, String generation,
			String receiver, String amp, String serialNumber,
			String licenseRequest, String licenseNumber, String description,
			Date effectiveDate, Organization organization, Dealer dealer,
			User userModify) {
		super();
		this.id = id;
		this.sequence = sequence;
		this.stockYear = stockYear;
		this.generation = generation;
		this.receiver = receiver;
		this.amp = amp;
		this.serialNumber = serialNumber;
		this.licenseRequest = licenseRequest;
		this.licenseNumber = licenseNumber;
		this.description = description;
		this.effectiveDate = effectiveDate;
		this.organization = organization;
		this.dealer = dealer;
		this.userModify = userModify;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLicenseRequest() {
		return licenseRequest;
	}

	public void setLicenseRequest(String licenseRequest) {
		this.licenseRequest = licenseRequest;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAmp() {
		return amp;
	}

	public void setAmp(String amp) {
		this.amp = amp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSequence() {
		return sequence;
	}

	public void setSequence(String sequence) {
		this.sequence = sequence;
	}

	public String getStockYear() {
		return stockYear;
	}

	public void setStockYear(String stockYear) {
		this.stockYear = stockYear;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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
