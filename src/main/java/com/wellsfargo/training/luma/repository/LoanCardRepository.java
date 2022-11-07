package com.wellsfargo.training.luma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.training.luma.model.LoanCard;

@Repository
public interface LoanCardRepository extends JpaRepository<LoanCard, String>{
	
	
}
