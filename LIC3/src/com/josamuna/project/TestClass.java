package com.josamuna.project;

import java.sql.Connection;
import java.sql.SQLException;

public class TestClass {

	public static void main(String[] args) {
		Connect connect = new Connect("localhost", 3306, "db_person", "root", "");
		try {
			Connection con = Singleton.getConnection(connect);
			System.out.println(String.format("%s %s With Con %s", "Successfully connected to the database", "db_person", con.toString()));
		} catch (SQLException e) {
			System.out.println("Enable to connect to the Database");
			e.printStackTrace();
		}
		System.out.println(Singleton.getInstance().toString());
	}

}
