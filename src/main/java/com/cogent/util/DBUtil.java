package com.cogent.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: Oliver Pagalanan
 * @time: Jan 27, 2022-2:17:07 PM
 */

// Preferred way to get and close Connection
public class DBUtil {
	
	// properties object
	private static Properties properties = loadProperties();
	
	public static Connection getConnection() {
		// to provide the Connection 
		// if I will call getConnection 100 times 
		// then loadProperties will be called 100 times
		
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
					properties.getProperty("jdbc.url"), 
					properties.getProperty("jdbc.username"), 
					properties.getProperty("jdbc.password")
					);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void closeConnection(Connection connection) {
		// call when done reading the database
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// to get resources from the application.properties file
	private static Properties loadProperties() {
		Properties properties = null;	// a Map, holds data in key-value pairs
		
		InputStream inputStream = null;
		
		inputStream = DBUtil.class.getClassLoader().getResourceAsStream("application.properties");
		
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// gives you the properties that are loaded from application.properties
		return properties;
	}
}
