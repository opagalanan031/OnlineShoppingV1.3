package com.cogent.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cogent.dto.AddressDTO;
import com.cogent.dto.CustomerDTO;
import com.cogent.util.DBUtil;

/**
 * @author: Oliver
 * @time: Jan 18, 2022-10:24:31 AM
 */
public class CustomerRepoImpl implements CustomerRepo {
	public static CustomerRepo customerRepo = null;
	
	private CustomerRepoImpl() {
		super();
	}
	
	public static CustomerRepo getInstance() {
		if(customerRepo == null) {
			customerRepo = new CustomerRepoImpl();
		}
		return customerRepo;
	}
	
	public boolean signIn(String email, String password) {
		boolean doesExist = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String query = "select * from customer_table where email=? and password=?";
		ResultSet result;
		
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			
			result = preparedStatement.executeQuery();	// will return resultSetObject by reading the DQL
			
			if(result.next()) {
				
				doesExist = true;
				
			}			
										
		} catch (SQLException e) {
			e.printStackTrace();
			return doesExist;
			
		} finally {
			DBUtil.closeConnection(connection);
		}
		
		return doesExist;
		
	}
	
	public String signUp(CustomerDTO cdto) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "insert customer_table (cid, customername, dob, gender, houseNo, street, city, state, email, password) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, cdto.getCustomerId());
			preparedStatement.setString(2, cdto.getCustomerName()); 
			preparedStatement.setDate(3, Date.valueOf(cdto.getDob()));
			preparedStatement.setString(4, cdto.getGender());
			preparedStatement.setString(5, cdto.getAdto().getHouseNo());
			preparedStatement.setString(6, cdto.getAdto().getStreet());
			preparedStatement.setString(7, cdto.getAdto().getCity());
			preparedStatement.setString(8, cdto.getAdto().getState());
			preparedStatement.setString(9, cdto.getEmail());
			preparedStatement.setString(10, cdto.getPassword());
			
			int result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				return "User Sign Up success!\n";
			} else {
				return "User Sign Up failed!\n";
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			return "User Sign Up failed!\n";
		} finally {
			// close the connection
			DBUtil.closeConnection(connection);
		}
			
	}
	
	public Optional<List<CustomerDTO>> viewCustomers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String query = "select * from customer_table";
		ResultSet result;
		List<CustomerDTO> customers = null;
				
		try {
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement(query);
								
			result = preparedStatement.executeQuery();
			
			if(result != null) {
				customers = new ArrayList<>();
			}
			
			if(customers == null) {
				System.out.println("Check status");
			}
			
			while(result.next()) {
				CustomerDTO cdto = new CustomerDTO();
				AddressDTO adto = new AddressDTO();
				
				cdto.setAdto(adto);
				cdto.setCustomerId(result.getInt("cid"));
				cdto.setCustomerName(result.getString("customername")); 
				cdto.setDob(LocalDate.parse(result.getDate("dob").toString()));
				cdto.setGender(result.getString("gender"));
				cdto.getAdto().setHouseNo(result.getString("houseNo"));
				cdto.getAdto().setStreet(result.getString("street"));
				cdto.getAdto().setCity(result.getString("city"));
				cdto.getAdto().setState(result.getString("state"));		
				cdto.setEmail(result.getString("email"));
				cdto.setPassword(result.getString("password"));
				customers.add(cdto);
			}
			
			if(customers.size()==0) {
				return Optional.empty();
			}
					
												
		} catch (SQLException e) {
			e.printStackTrace();
					
		} finally {
			DBUtil.closeConnection(connection);
		}
				
		return Optional.ofNullable(customers);
	}
	
}
