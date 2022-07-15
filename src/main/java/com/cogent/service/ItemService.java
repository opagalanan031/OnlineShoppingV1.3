package com.cogent.service;

import java.util.List;

import com.cogent.dto.ItemDTO;

/**
 * @author: Oliver
 * @time: Jan 20, 2022-4:41:03 PM
 */
public interface ItemService {
	
	void addItem(ItemDTO idto);
	List viewAllItems();
	List viewItemsByCategory(String category);
	void deleteItem(int choice);
	
}
