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
@Table(name="PETTY_CASH_DETAIL")
public class PettyCashDetail {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;
	
	@Column(name = "PETTY_CASH_DATE")
    private Date cashDate;
	
	@Column(name = "PETTY_CASH_DESC")
	private String description;
	
	@Column(name = "PETTY_CASH_WITHDRAW")
	private float cashWithdraw;
	
	@Column(name = "PETTY_CASH_USED")
	private float cashUsed;
	
	@Column(name = "PETTY_CASH_BALANCE")
	private float cashBalance;
	
	@ManyToOne
    @JoinColumn(name="REQUEST_NUMBER", referencedColumnName = "REQUEST_NUMBER", insertable = true, updatable = true)
	private PettyCash pettyCash;
	
	@ManyToOne
    @JoinColumn(name="USER_NAME", referencedColumnName = "USER_NAME", insertable = true, updatable = true)
	private User userModify;

	public PettyCashDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PettyCashDetail(int id, Date effectiveDate, Date cashDate,
			String description, float cashWithdraw, float cashUsed,
			float cashBalance, PettyCash pettyCash, User userModify) {
		super();
		this.id = id;
		this.effectiveDate = effectiveDate;
		this.cashDate = cashDate;
		this.description = description;
		this.cashWithdraw = cashWithdraw;
		this.cashUsed = cashUsed;
		this.cashBalance = cashBalance;
		this.pettyCash = pettyCash;
		this.userModify = userModify;
	}

	@Override
	public String toString() {
		return "PettyCashDetail [id=" + id + ", effectiveDate=" + effectiveDate
				+ ", cashDate=" + cashDate + ", description=" + description
				+ ", cashWithdraw=" + cashWithdraw + ", cashUsed=" + cashUsed
				+ ", cashBalance=" + cashBalance + ", pettyCash=" + pettyCash
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

	@JsonSerialize(using = JsonDateSerializer.class)
	public Date getCashDate() {
		return cashDate;
	}

	public void setCashDate(Date cashDate) {
		this.cashDate = cashDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCashWithdraw() {
		return cashWithdraw;
	}

	public void setCashWithdraw(float cashWithdraw) {
		this.cashWithdraw = cashWithdraw;
	}

	public float getCashUsed() {
		return cashUsed;
	}

	public void setCashUsed(float cashUsed) {
		this.cashUsed = cashUsed;
	}

	public float getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(float cashBalance) {
		this.cashBalance = cashBalance;
	}

	public PettyCash getPettyCash() {
		return pettyCash;
	}

	public void setPettyCash(PettyCash pettyCash) {
		this.pettyCash = pettyCash;
	}

	public User getUserModify() {
		return userModify;
	}

	public void setUserModify(User userModify) {
		this.userModify = userModify;
	}
	
	
}
