package com.wellsfargo.training.luma.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee_card_details")
public class EmployeeCard {
	
	@EmbeddedId
	private EmployeeCardPK empCardId;
	
	@Column(name="card_issue_date")
	private Date cardIssueDate;
	
	//---------- Getters and Setters

	public EmployeeCardPK getEmpCardId() {
		return empCardId;
	}

	public void setEmpCardId(EmployeeCardPK empCardId) {
		this.empCardId = empCardId;
	}

	public Date getCardIssueDate() {
		return cardIssueDate;
	}

	public void setCardIssueDate(Date cardIssueDate) {
		this.cardIssueDate = cardIssueDate;
	}
	
	

}
