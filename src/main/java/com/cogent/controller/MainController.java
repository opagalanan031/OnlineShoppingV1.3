package com.cogent.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.cogent.dto.AddressDTO;
import com.cogent.dto.CustomerDTO;
import com.cogent.dto.ItemDTO;
import com.cogent.service.CartService;
import com.cogent.service.CustomerService;
import com.cogent.service.ItemService;
import com.cogent.service.CartServiceImpl;
import com.cogent.service.CustomerServiceImpl;
import com.cogent.service.ItemServiceImpl;
import com.cogent.util.Utility;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-10:33:28 AM
 */
public class MainController {
	static CustomerService customerService = null;
	static ItemService itemService = null;
	static CartService cartService = null;
	static Utility util = null;
	static Scanner scan = null;
	static int choice = 0;
	static int initialCustomerId = 101;
	
	public static void main(String[] args) throws Exception {
		
		welcome();
		
	}
	
	static void welcome() throws Exception {
		
		scan = new Scanner(System.in);
		System.out.println("Welcome User!");		
		System.out.println("====================");		
		System.out.println("Press 1 to Sign In");		
		System.out.println("Press 2 to Sign Up");
		System.out.println("====================");
		System.out.println("Choice: ");
		choice = scan.nextInt();
		
		
		if(choice == 1) {
			signIn();
		} else if(choice == 2) {
			signUp();
		} else {
			System.exit(0);
		}
	}
	
	static void signIn() throws Exception {
		customerService = new CustomerServiceImpl();
		util = new Utility();
		scan = new Scanner(System.in);
		boolean inSystem = false;
		
		System.out.println("Please enter email address:");
		String email = scan.nextLine();
		System.out.println("Please enter password:");
		String password = scan.nextLine();
		
		if(util.isAdmin(email, password)) {
			adminHome();
		} else {
			inSystem = customerService.signIn(email, password);
			
			if(inSystem) {
				customerPortal();
			} else {
				System.out.println("User does not exist in the system. Try to Sign Up.");
			}
		} 
	}
		
	static void signUp() throws Exception {
		CustomerDTO cdto = new CustomerDTO();
		AddressDTO adto = new AddressDTO();
		cdto.setAdto(adto);
		customerService = new CustomerServiceImpl();
		util = new Utility();
		scan = new Scanner(System.in);
		DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		
		cdto.setCustomerId(initialCustomerId);
		System.out.println("Enter name:");
		cdto.setCustomerName(scan.next());
		util.checkCustomerNameLength(cdto.getCustomerName());
		System.out.println("Enter date of birth in format yyyy-MM-dd:");
		String sDate = scan.next();
		cdto.setDob(LocalDate.parse(sDate, inputFormat));
		System.out.println("Enter gender:");
		cdto.setGender(scan.next());
		util.checkGender(cdto.getGender());
		System.out.println("Enter house number:");
		adto.setHouseNo(scan.next());
		util.checkHouseNo(adto.getHouseNo());
		System.out.println("Enter street:");
		adto.setStreet(scan.next());
		System.out.println("Enter city:");
		adto.setCity(scan.next());
		System.out.println("Enter state:");
		adto.setState(scan.next());
		System.out.println("Enter email:");
		cdto.setEmail(scan.next());
		System.out.println("Enter password:");
		cdto.setPassword(scan.next());
		util.checkPasswordLength(cdto.getPassword());
		System.out.println("Confirm password:");
		String confirmPassword = scan.next();
		
		
		if(cdto.getPassword().equals(confirmPassword)) {
			System.out.println(customerService.signUp(cdto));
			initialCustomerId++;
			welcome();
		} else {
			System.out.println("Passwords do not match!");
		}
	}
	
	static void adminHome() throws Exception {
		scan = new Scanner(System.in);
		
		do {
			System.out.println("Welcome to Admin Home");
			System.out.println("=========================");
			System.out.println("1: Add Item");
			System.out.println("2: View all Items");
			System.out.println("3: View all Items by Category");
			System.out.println("4: Delete Item");
			System.out.println("5: View Customers");
			System.out.println("6: Log Out");
			System.out.println("=========================");
			System.out.println("Choice: ");
			choice = scan.nextInt();
			
			if(choice == 1) {
				addItem();
			} else if (choice == 2) {
				viewAllItems();
			} else if (choice == 3) {
				viewItemsByCategory();
			} else if (choice == 4) {
				deleteItem();
			} else if (choice == 5) {
				viewCustomers();
			}
		} while (choice != 6);
		
		welcome();
		
	}
	
	static void customerPortal() throws Exception {
		scan = new Scanner(System.in);
		
		do {
			System.out.println("Welcome to Customer Portal");
			System.out.println("==============================");
			System.out.println("1: View all Items");	
			System.out.println("2: View Items by Category");
			System.out.println("3: View Cart");
			System.out.println("4: Checkout");
			System.out.println("5: Log Out");
			System.out.println("==============================");
			System.out.println("Choice: ");
			choice = scan.nextInt();
			
			if(choice == 1) {
				viewAllItems();
				addToCart();
			} else if (choice == 2) {
				viewItemsByCategory();
				addToCart();
			} else if (choice == 3) {
				viewCart();
			} else if (choice == 4) {
				checkout();
			}
		} while (choice != 5);
		
		welcome();
	}
	
	static void addItem() throws Exception {
		itemService = new ItemServiceImpl();
		ItemDTO idto = new ItemDTO();
		
		System.out.println("Enter the item ID:");
		idto.setItemId(scan.nextInt());
		System.out.println("Enter the item name:");
		idto.setItemName(scan.next());
		System.out.println("Enter item category:");
		idto.setItemCategory(scan.next());
		System.out.println("Enter item price:");
		idto.setPrice(scan.nextDouble());
		
		itemService.addItem(idto);
		
		System.out.println("Item added successfully!\n");
				
	}
	
	static void viewAllItems() {
		itemService = new ItemServiceImpl();
		
		System.out.println(itemService.viewAllItems());
		
	}
	
	static void viewItemsByCategory() {
		itemService = new ItemServiceImpl();
		scan = new Scanner(System.in);
		
		System.out.println("Enter category:");
		String category = scan.next();
		System.out.println(itemService.viewItemsByCategory(category));
	}
	
	static void deleteItem() throws Exception {
		scan = new Scanner(System.in);
		itemService = new ItemServiceImpl();
		
		System.out.println("Enter the ID of the Item to be deleted:");
		choice = scan.nextInt();
		
		itemService.deleteItem(choice);
		
		System.out.println("Item deleted successfully!\n");
		
	}
	
	static void viewCustomers() {
		customerService = new CustomerServiceImpl();
		
		Optional<List<CustomerDTO>> customers = customerService.viewCustomers();
		System.out.println(customers.get());
		
	}
	
	static void addToCart() throws Exception {
		cartService = new CartServiceImpl();
		scan = new Scanner(System.in);
		
		System.out.println("Would you like to add any item to cart? Enter y if yes and anything if not:");
		char add = scan.next().charAt(0);
		
		if(add == 'y') {
			System.out.println("Enter the ID of the Item you want to add to cart:");
			choice = scan.nextInt();
			
			cartService.addToCart(choice);
			System.out.println("Item added to cart successfully!\n");
			customerPortal();
		} else {
			customerPortal();
		}
		
	}
	
	static void viewCart() {
		cartService = new CartServiceImpl();
		
		System.out.println(cartService.viewCart());
	}
	
	static void checkout() {
		cartService = new CartServiceImpl();
		
		System.out.println("Your bought items:");
		viewCart();
		System.out.printf("Your total bill is: %.2f\n", cartService.checkout());
		System.out.println("Than you for shopping with us!!!\n");
	}
}
