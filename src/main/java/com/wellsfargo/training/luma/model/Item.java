package com.wellsfargo.training.luma.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_master")
public class Item {
	
	@Id
	@Column(name="item_id", length=6)
	private String itemId;
	
	@Column(name="item_description", length=25)
	private String itemDescription;
	
	@Column(name="issue_status")
	private char issueStatus;
	
	@Column(name="item_make",length=25)
	private String itemMake;
	
	
	@Column(name="item_category",length=20)
	private String itemCategory;
	
	@Column(name="item_valuation")
	private int itemValuation;

	//---------- Getters and Setters
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public char getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(char issueStatus) {
		this.issueStatus = issueStatus;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemValuation() {
		return itemValuation;
	}

	public void setItemValuation(int itemValuation) {
		this.itemValuation = itemValuation;
	}
	
	
}