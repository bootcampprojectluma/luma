package com.wellsfargo.training.luma.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="employee_issue_details")
public class Issue {

	@Id
	@Column(name="issue_id",length=6)
	private String issueId;
	
	
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	
	@OneToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	@Column(name="issue_date")
	private Date issueDate;
	
	@Column(name="return_date")
	private Date returnDate;
	
	
	public Issue() {};
	
	
	public Issue(String issueId, Employee employee, Item item, Date issueDate, Date returnDate) {
		this.issueId = issueId;
		this.employee = employee;
		this.item = item;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	//---------- Getters and Setters

	public String getIssueId() {
		return issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}


	
	
}
