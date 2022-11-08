package com.wellsfargo.training.luma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.training.luma.model.EmployeeCard;
import com.wellsfargo.training.luma.model.EmployeeCardPK;

@Repository
public interface EmployeeCardRepository extends JpaRepository<EmployeeCard, EmployeeCardPK>{
	
	
}
