package com.cogent.repo;

import java.util.List;
import java.util.Optional;

import com.cogent.dto.CustomerDTO;

/**
 * @author: Oliver
 * @time: Jan 20, 2022-4:39:44 PM
 */
public interface CustomerRepo {
	
	boolean signIn(String email, String password);
	String signUp(CustomerDTO cdto);
	Optional<List<CustomerDTO>> viewCustomers();
	
}
