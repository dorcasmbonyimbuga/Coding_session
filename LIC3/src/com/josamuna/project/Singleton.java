package com.josamuna.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
	private static Singleton instance = null;
	private static Connection connection = null;
	
	private Singleton() {		
	}

	public static Singleton getInstance() {
		if(instance == null) 
			instance = new Singleton();	
		return instance;
	}

	/**
	 * Instantiate the connection string and return it
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConnection(Connect connect) throws SQLException {
		if(connection == null) {
			String strCon = formatConnectionString(connect);
			connection = DriverManager.getConnection(strCon);
		}
			
		return connection;
	}
	
	private static String formatConnectionString(Connect connect) {
		//jdbc:mysql://host:portNumber/?user=root&pasword=&ServerTimeZone=UTC
		StringBuilder strCon = new StringBuilder();
		strCon.append("jdbc:mysql://")
		.append(connect.getHost())
		.append(":")
		.append(connect.getPort())
		.append("/")
		.append(connect.getDatabase())
		.append("?user=")
		.append(connect.getUsername())
		.append("&pasword=")
		.append(connect.getPassword())
		.append("&ServerTimeZone=UTC");
		
		return strCon.toString();
	}

}
