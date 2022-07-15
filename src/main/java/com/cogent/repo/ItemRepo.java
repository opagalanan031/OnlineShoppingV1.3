package com.cogent.repo;

import java.util.List;

import com.cogent.dto.ItemDTO;

/**
 * @author: Oliver
 * @time: Jan 20, 2022-4:40:02 PM
 */
public interface ItemRepo {
	
	void addItem(ItemDTO idto);
	List viewAllItems();
	List viewItemsByCategory(String category);
	void deleteItem(int choice);
	
}
