package com.wellsfargo.training.luma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.luma.model.Item;
import com.wellsfargo.training.luma.repository.ItemRepository;

@Service
public class ItemDetails implements DAO<Item> {
	
	@Autowired
	private ItemRepository itemRepo;

	@Override
	public Optional<Item> get(String id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Item t) {
		// TODO Auto-generated method stub
		itemRepo.save(t);
	}

	@Override
	public void update(Item t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Item t) {
		// TODO Auto-generated method stub
		
	}

}
