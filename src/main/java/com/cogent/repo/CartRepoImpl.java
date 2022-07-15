package com.cogent.repo;

import java.util.ArrayList;
import java.util.List;

import com.cogent.dto.ItemDTO;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-1:02:47 PM
 */
public class CartRepoImpl implements CartRepo {
	List cart = new ArrayList();
	ItemRepo itemRepo = ItemRepoImpl.getInstance();
	public static CartRepo cartRepo = null;
	ItemRepoImpl itemRepoImpl = (ItemRepoImpl)itemRepo;
	
	private CartRepoImpl() {
		super();
	}
	
	public static CartRepo getInstance() {
		if(cartRepo == null) {
			cartRepo = new CartRepoImpl();
		}
		return cartRepo;
	}
	
	public void addToCart(int choice) {
		
		for(int i = 0; i < itemRepoImpl.items.size(); i++) {
			if(((ItemDTO) itemRepoImpl.items.get(i)).getItemId() == choice) {
				cart.add(itemRepoImpl.items.get(i));
				break;
			}
		}
			
		
	}
	
	public List viewCart() {
		List temp = new ArrayList();
		
		for(int i = 0; i < cart.size(); i++) {
			temp.add(cart.get(i));
		}
		return temp;
	}
	
	public double checkout() {
		double total = 0;
		for(int i = 0; i < cart.size(); i++) {
			if(cart.get(i) != null) {
				total = total + ((ItemDTO) cart.get(i)).getPrice();
			}
		}
		return total;
	}
}
