package com.wellsfargo.training.luma.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wellsfargo.training.luma.model.Employee;
import com.wellsfargo.training.luma.model.EmployeeCard;
import com.wellsfargo.training.luma.model.Item;
import com.wellsfargo.training.luma.model.LoanCard;
import com.wellsfargo.training.luma.response.ApiResponse;
import com.wellsfargo.training.luma.services.*;


@RestController
public class LumaController {

	@Autowired private EmployeeDetails employeeDetails;
	
	@Autowired private ItemDetails itemDetails;

	@Autowired private EmployeeCardDetails employeeCardDetails;

	@Autowired private LoanCardDetails loanCardDetails;

	@PostMapping("/login")	
	public Object login( @RequestBody Employee empRequest) {

		List<Employee> empList = employeeDetails.getAll();
		for (Employee emp: empList) {
			if (empRequest.getEmployeeId().equals(emp.getEmployeeId())
					&& empRequest.getPassword().equals(emp.getPassword()))
				return emp;
		}
		return new ApiResponse("Incorrect Username or Password");

	}

	@PostMapping("/loan_apply")
	public ApiResponse loanApply( @RequestBody Item item) {
		try {
			itemDetails.save(item);
		}
		catch(Error e) {
			return new ApiResponse("Application Unsuccessfull.");
		}
		return new ApiResponse("Application Successfull.");
	}

	@PostMapping("/view_cards")
	public Object viewCards(@RequestBody Employee empRequest) {

		List<EmployeeCard> temp1;
		String temp2;
		
		List<LoanCard> loanCards = new ArrayList<>();


		List<EmployeeCard> empCardList = employeeCardDetails.getAll();
		List<LoanCard> loanCardList  = loanCardDetails.getAll();
		
		
		List<Map<String,Object>> response = new ArrayList<>();
		
		for (EmployeeCard empCard: empCardList) {
			if (empRequest.getEmployeeId().equals(empCard.getEmpCardId().getEmployee().getEmployeeId())) {
				temp1 =  employeeCardDetails.getAll();
				for (EmployeeCard empCard2: temp1) {
					temp2 = empCard2.getEmpCardId().getLoanCard().getLoanId();
					
					for(LoanCard card: loanCardList) {
						if (card.getLoanId().equals(temp2)) {
							Map<String,Object> something = new HashMap<>();
							
							something.put("loanId",card.getLoanId());
							something.put("loadType",card.getLoadType());
							something.put("durationInYears",card.getDurationInYears());
							something.put("card_issue_date", empCard2.getCardIssueDate());
							
							response.add(something);
						}
					}
				}
			}
			return response;

		}

		return new ApiResponse("Error");

	}



}
