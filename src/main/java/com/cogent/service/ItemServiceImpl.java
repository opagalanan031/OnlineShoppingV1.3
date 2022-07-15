package com.cogent.service;

import com.cogent.repo.ItemRepo;
import com.cogent.repo.ItemRepoImpl;

import java.util.List;

import com.cogent.dto.ItemDTO;
/**
 * @author: Oliver
 * @time: Jan 18, 2022-11:45:44 AM
 */
public class ItemServiceImpl implements ItemService {
	ItemRepo itemRepo = ItemRepoImpl.getInstance();
		
	public void addItem(ItemDTO idto) {
		itemRepo.addItem(idto);
	}
	
	public List viewAllItems() {
		return itemRepo.viewAllItems();
	}
	
	public List viewItemsByCategory(String category) {
		return itemRepo.viewItemsByCategory(category);
	}
	
	public void deleteItem(int choice) {
		itemRepo.deleteItem(choice);
	}
}
