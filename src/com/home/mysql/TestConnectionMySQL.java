package com.home.mysql;

import java.sql.*;

public class TestConnectionMySQL {

	public static void main(String[] args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/book_shop";
		String username="root";
		String password="AccessMe";
		
//		load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		establish connection b/w java application and database s/w
		Connection con=DriverManager.getConnection(url, username, password);
		if(con==null) {
			System.out.println("Connection Failed");
		} else {
			System.out.println("Connection Established");
		}
		
	}

}
