package com.wellsfargo.training.luma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.luma.model.LoanCard;
import com.wellsfargo.training.luma.repository.LoanCardRepository;

@Service
public class LoanCardDetails implements DAO<LoanCard> {
	
	@Autowired
	private LoanCardRepository loanCardRepo;

	@Override
	public Optional<LoanCard> get(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<LoanCard> getAll() {
		
		return loanCardRepo.findAll();
	}

	@Override
	public void save(LoanCard t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LoanCard t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LoanCard t) {
		// TODO Auto-generated method stub
		
	}

	

}