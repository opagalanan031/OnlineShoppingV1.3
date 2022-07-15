package com.cogent.repo;

import java.util.ArrayList;
import java.util.List;

import com.cogent.dto.ItemDTO;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-11:44:02 AM
 */
public class ItemRepoImpl implements ItemRepo {
	List items = new ArrayList();
	public static ItemRepo itemRepo = null;
	
	private ItemRepoImpl() {
		super();
	}
	
	public static ItemRepo getInstance() {
		if(itemRepo == null) {
			itemRepo = new ItemRepoImpl();
		}
		return itemRepo;
	}
	
	public void addItem(ItemDTO idto) {
		
		items.add(idto);
		
	}
	
	public List viewAllItems() {
		List temp = new ArrayList();
		
		for(int i = 0; i < items.size(); i++) {
			temp.add(items.get(i));
		}
		return temp;
	}
	
	public List viewItemsByCategory(String category) {
		List temp = new ArrayList();
		
		for(int i = 0; i <= items.size(); i++) {
			if(items != null) {
				if(((ItemDTO) items.get(i)).getItemCategory().compareTo(category) == 0) {
					temp.add(items.get(i));
				}
			}
		}
		return temp;
	}
	
	public void deleteItem(int choice) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i) != null) {
				if(choice == ((ItemDTO) items.get(i)).getItemId()) {
					
					items.remove(i);
					
					break;
				}
			} else {
				System.out.println("Data does not exist. Nothing to delete.");
				break;
			}
		}
	}
}
