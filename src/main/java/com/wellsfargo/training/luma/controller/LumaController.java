package com.wellsfargo.training.luma.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wellsfargo.training.luma.model.Employee;
import com.wellsfargo.training.luma.model.EmployeeCard;
import com.wellsfargo.training.luma.model.EmployeeCardPK;
import com.wellsfargo.training.luma.model.Issue;
import com.wellsfargo.training.luma.model.Item;
import com.wellsfargo.training.luma.model.LoanCard;
import com.wellsfargo.training.luma.response.ApiResponse;
import com.wellsfargo.training.luma.services.*;


@RestController
public class LumaController {

	@Autowired private EmployeeDetails employeeDetails;
	
	@Autowired private ItemDetails itemDetails;
	
	@Autowired private IssueDetails issueDetails;

	@Autowired private EmployeeCardDetails employeeCardDetails;

	@Autowired private LoanCardDetails loanCardDetails;
	

	@PostMapping("/login")	
	@ResponseBody
	public Object login( @RequestBody Employee empRequest) {
		
		try{
			Optional<Employee> emp = employeeDetails.get(empRequest.getEmployeeId());
			if (emp.get().getEmployeeId().equals(empRequest.getEmployeeId()) && emp.get().getPassword().equals(empRequest.getPassword())) {
				return emp.get();
			}
			else {
				return new ApiResponse("Incorrect Username or Password");
			}
		}
		catch(Error e) {
			return new ApiResponse("Username or Password Field Empty");
		}

	}
	
	@GetMapping("/loan_apply")
	@ResponseBody
	public List<Item> getItems(){
		return itemDetails.getAll();
	}

	@PostMapping("/loan_apply")
	public ApiResponse loanApply( @RequestBody Map<String, String> request) {
		
		Employee employeeObj = employeeDetails.get(request.get("employeeId")).get();
		Item itemObj = itemDetails.findByDescription(request.get("itemDescription"));
		

		
		try{
			
			issueDetails.save(new Issue(String.valueOf(issueDetails.nextIssueId()),employeeObj, itemObj,Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now())));
			
			return new ApiResponse("Application Successfull.");
		}
		catch(Error e) {
			return new ApiResponse("Application Unsuccessfull.");
		}
		
	}

	@PostMapping("/view_cards")
	@ResponseBody
	public List<Map<String,Object>> viewCards(@RequestBody Employee empRequest) {
		
		List<Map<String,Object>> response = new ArrayList<>();
		
		Employee employee = employeeDetails.get(empRequest.getEmployeeId()).get();
		List<LoanCard> loanCardList  = loanCardDetails.getAll();
		for (LoanCard loanCard: loanCardList) {
			Map<String,Object> resp = new HashMap<>();
			EmployeeCardPK compositeKey = new EmployeeCardPK(employee, loanCard);
			EmployeeCard employeeCard = employeeCardDetails.get(compositeKey).get();
			resp.put("loanId",loanCard.getLoanId());
			resp.put("loadType",loanCard.getLoadType());
			resp.put("durationInYears",loanCard.getDurationInYears());
			resp.put("card_issue_date", employeeCard.getCardIssueDate());
			
			response.add(resp);
		}
		return response;

	}
	
	@PostMapping("/view_purchases")
	@ResponseBody
	public List<Map<String,Object>> viewPurchases(@RequestBody Employee empRequest) {
		
		List<Map<String,Object>> response = new ArrayList<>();
		
		Employee employee = employeeDetails.get(empRequest.getEmployeeId()).get();
		List<Issue> issueList  = issueDetails.getByEmployee(employee);
		for (Issue issue: issueList) {
			Map<String,Object> resp = new HashMap<>();
			Item item = issue.getItem();
			resp.put("issueId",issue.getIssueId());
			resp.put("itemDescription",item.getItemDescription());
			resp.put("itemMake",item.getItemMake());
			resp.put("itemCategory", item.getItemCategory());
			resp.put("itemValuation",item.getItemValuation());
			
			response.add(resp);
		}
		return response;
	}



}
