package com.cogent.repo;

import java.util.List;

import com.cogent.dto.ItemDTO;

/**
 * @author: Oliver
 * @time: Jan 20, 2022-4:40:19 PM
 */
public interface CartRepo {
	
	void addToCart(int choice);
	List viewCart();
	double checkout();
	
}
