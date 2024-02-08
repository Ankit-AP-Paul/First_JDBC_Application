package com.home.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessing {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/test_db";
		String username="root";
		String password="AccessMe";
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		
//		first we prepare the entire batch then we commit it
		con.setAutoCommit(false);
		
//		using statement object
		
		
		
		
//		using prepared statement object
		
		
		
		con.close();
	}

}
