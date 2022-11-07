package com.wellsfargo.training.luma.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Table(name="employee_card_details")
public class EmployeeCardPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@OneToOne
	@JoinColumn(name = "loan_id")
	private LoanCard loanCard;
	
	
	
	//---------- Getters and Setters

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LoanCard getLoanCard() {
		return loanCard;
	}

	public void setLoanCard(LoanCard loanCard) {
		this.loanCard = loanCard;
	}
	
}
