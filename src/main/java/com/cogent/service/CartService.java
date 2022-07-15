package com.cogent.service;

import java.util.List;

import com.cogent.dto.ItemDTO;

/**
 * @author: Oliver
 * @time: Jan 20, 2022-4:41:17 PM
 */
public interface CartService {
	
	void addToCart(int choice);
	List viewCart();
	double checkout();
	
}
