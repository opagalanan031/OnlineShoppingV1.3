package com.cogent.service;

import java.util.List;
import java.util.Optional;

import com.cogent.dto.CustomerDTO;

/**
 * @author: Oliver
 * @time: Jan 20, 2022-4:40:50 PM
 */
public interface CustomerService {
	
	boolean signIn(String email, String password);
	String signUp(CustomerDTO cdto);
	Optional<List<CustomerDTO>> viewCustomers();
}
