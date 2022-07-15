package com.cogent.service;


import java.util.List;
import java.util.Optional;

import com.cogent.dto.CustomerDTO;
import com.cogent.repo.CustomerRepo;
import com.cogent.repo.CustomerRepoImpl;
//import com.cogent.dto.AddressDTO;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-10:28:29 AM
 */
public class CustomerServiceImpl implements CustomerService {
	CustomerRepo customerRepo = CustomerRepoImpl.getInstance();
	
	public boolean signIn(String email, String password) {
		return customerRepo.signIn(email, password);
	}
	
	public String signUp(CustomerDTO cdto) {
		return customerRepo.signUp(cdto);
	}
	
	public Optional<List<CustomerDTO>> viewCustomers() {
		return customerRepo.viewCustomers();
	}
	
}
