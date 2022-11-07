package com.wellsfargo.training.luma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan_card_master")
public class LoanCard {
	
	@Id
	@Column(name="loan_id",length=6)
	private String loanId;
	
	@Column(name="load_type",length=15)
	private String loadType;
	
	@Column(name="duration_in_years")
	private int durationInYears;
	
	//---------- Getters and Setters

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getLoadType() {
		return loadType;
	}

	public void setLoadType(String loadType) {
		this.loadType = loadType;
	}

	public int getDurationInYears() {
		return durationInYears;
	}

	public void setDurationInYears(int durationInYears) {
		this.durationInYears = durationInYears;
	}
	
	

}
