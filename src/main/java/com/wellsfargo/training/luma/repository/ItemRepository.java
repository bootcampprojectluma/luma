package com.wellsfargo.training.luma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.training.luma.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{
	
	
}
