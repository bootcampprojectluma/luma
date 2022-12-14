package com.wellsfargo.training.luma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.luma.model.Employee;
import com.wellsfargo.training.luma.repository.EmployeeRepository;

@Service
public class EmployeeDetails implements DAO<Employee> {
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public Optional<Employee> get(String id) {
		return employeeRepo.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepo.findAll();
	}

	@Override
	public void save(Employee t) {
		employeeRepo.save(t);
	}

	@Override
	public void update(Employee t, String[] params) {
				
	}

	@Override
	public void delete(Employee t) {
		
	}

	

}