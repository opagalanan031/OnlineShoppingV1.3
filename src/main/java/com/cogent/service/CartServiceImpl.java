package com.cogent.service;

import java.util.List;

import com.cogent.dto.ItemDTO;
import com.cogent.repo.CartRepo;
import com.cogent.repo.CartRepoImpl;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-1:02:59 PM
 */
public class CartServiceImpl implements CartService {
	CartRepo cartRepo = CartRepoImpl.getInstance(); 
	
	public void addToCart(int choice) {
		cartRepo.addToCart(choice);
	}
	
	public List viewCart() {
		return cartRepo.viewCart();
	}
	
	public double checkout() {
		return cartRepo.checkout();
	}
}
