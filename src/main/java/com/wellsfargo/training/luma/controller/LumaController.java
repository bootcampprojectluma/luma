package com.wellsfargo.training.luma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wellsfargo.training.luma.model.Employee;
import com.wellsfargo.training.luma.model.Item;
import com.wellsfargo.training.luma.response.ApiResponse;
import com.wellsfargo.training.luma.services.*;


@RestController
public class LumaController {
	
	@Autowired private EmployeeDetails employeeDetails;
	
	@Autowired private ItemDetails itemDetails;
	
	@PostMapping("/login")	
	public Object login( @RequestBody Employee empRequest) {

		List<Employee> empList = employeeDetails.getAll();
		System.out.println(empRequest.getEmployeeId()); //empList.get(0).getEmployeeId());
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
	
	

}
