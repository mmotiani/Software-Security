package com.group10.sparkysbank.model;


// default package
// Generated Oct 26, 2014 3:05:06 AM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Transactions generated by hbm2java
 */
@Entity
@Table(name = "transactions", catalog = "sparkysbankdb")
public class Transactions implements java.io.Serializable {

	@Id
	@Column(name = "idtransactions", unique = true, nullable = false)
	@GeneratedValue
	private int idtransactions;
	private String transactionTypes;
	private Integer fromAccount;
	private Integer amtInvolved;
	private Integer toAccountno;
	private String creditDebit;
	private Integer approvalNeeded;
	private Integer approved;
	private Integer status;

	public Transactions() {
	}

	public Transactions(int idtransactions) {
		this.idtransactions = idtransactions;
	}

	public Transactions(int idtransactions, String transactionTypes,
			Integer fromAccount, Integer amtInvolved, Integer toAccountno,
			String creditDebit, Integer approvalNeeded, Integer approved,
			Integer status) {
		this.idtransactions = idtransactions;
		this.transactionTypes = transactionTypes;
		this.fromAccount = fromAccount;
		this.amtInvolved = amtInvolved;
		this.toAccountno = toAccountno;
		this.creditDebit = creditDebit;
		this.approvalNeeded = approvalNeeded;
		this.approved = approved;
		this.status = status;
	}

	
	public int getIdtransactions() {
		return this.idtransactions;
	}

	public void setIdtransactions(int idtransactions) {
		this.idtransactions = idtransactions;
	}


	public String getTransactionTypes() {
		return this.transactionTypes;
	}

	public void setTransactionTypes(String transactionTypes) {
		this.transactionTypes = transactionTypes;
	}


	public Integer getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(Integer fromAccount) {
		this.fromAccount = fromAccount;
	}

	@Column(name = "amt_involved")
	public Integer getAmtInvolved() {
		return this.amtInvolved;
	}

	public void setAmtInvolved(Integer amtInvolved) {
		this.amtInvolved = amtInvolved;
	}

	@Column(name = "to_accountno", length = 50)
	public Integer getToAccountno() {
		return this.toAccountno;
	}

	public void setToAccountno(Integer toAccountno) {
		this.toAccountno = toAccountno;
	}

	@Column(name = "credit_debit", length = 45)
	public String getCreditDebit() {
		return this.creditDebit;
	}

	public void setCreditDebit(String creditDebit) {
		this.creditDebit = creditDebit;
	}

	@Column(name = "approval_needed")
	public Integer getApprovalNeeded() {
		return this.approvalNeeded;
	}

	public void setApprovalNeeded(Integer approvalNeeded) {
		this.approvalNeeded = approvalNeeded;
	}

	@Column(name = "approved")
	public Integer getApproved() {
		return this.approved;
	}

	public void setApproved(Integer approved) {
		this.approved = approved;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
