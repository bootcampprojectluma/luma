package com.wellsfargo.training.luma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.luma.model.EmployeeCard;
import com.wellsfargo.training.luma.model.EmployeeCardPK;
import com.wellsfargo.training.luma.repository.EmployeeCardRepository;

@Service
public class EmployeeCardDetails implements DAO<EmployeeCard> {
	
	@Autowired
	private EmployeeCardRepository employeeCardRepo;
	

	@Override
	public Optional<EmployeeCard> get(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	
	public Optional<EmployeeCard> get(EmployeeCardPK employeeCardPK) {
		return Optional.ofNullable(employeeCardRepo.getReferenceById(employeeCardPK));
	}

	@Override
	public List<EmployeeCard> getAll() {
		
		return employeeCardRepo.findAll();
	}

	@Override
	public void save(EmployeeCard t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EmployeeCard t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EmployeeCard t) {
		// TODO Auto-generated method stub
		
	}

	

}