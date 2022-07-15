package com.cogent.util;

import java.util.function.BiFunction;

/**
 * @author: Oliver
 * @time: Jan 20, 2022-4:39:18 PM
 */
public class Utility {
	static final String ADMIN_EMAIL = "admin@admin.com";
	static final String ADMIN_PASSWORD = "admin@123";
	
	public void checkCustomerNameLength(String customerName) {
		if(customerName.length() < 2 || customerName.length() > 20) {
			System.out.println("The length of your name is invalid");
			System.out.println("Minimum length is 2 and maximum length is 20");
			System.exit(0);
		} 
	}
	
	public void checkPasswordLength(String password) {
		if(password.length() < 8 || password.length() > 16) {
			System.out.println("The length of your password is invalid");
			System.out.println("Minimum length is 8 and maximum length is 16");
			System.exit(0);
		}
	}
	
	public void checkGender(String gender) {
		if(!gender.equals("Male") && !gender.equals("Female")) {
			System.out.println("The input for gender is invalid");
			System.out.println("Enter \"Male\" or \"Female\" only");
			System.exit(0);
		}
	}
	
	public void checkHouseNo(String houseNo) {
		try {
			Integer.parseInt(houseNo);
		} catch (NumberFormatException nfe) {
			System.out.println("Invalid input for house number");
			System.out.println("Enter a numerical value");
			System.exit(0);
		}
	}
	
	public boolean isAdmin(String email, String password) {

		BiFunction<String, String, Boolean> isAdmin = (e, p) -> {
			if(e.equals(ADMIN_EMAIL) && p.equals(ADMIN_PASSWORD)) {
				return true;
			} else {
				return false;
			}
		};

		return isAdmin.apply(email, password);

	}
}
