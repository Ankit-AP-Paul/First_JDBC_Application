package com.home.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RunQueries {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/book_shop";
		String username="root";
		String password="AccessMe";
		
//		load and register driver
//		here Driver class has the static block which contains
//		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//		which actually works internally when the class is loaded
//		using Class.forName() method
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		establish connection b/w java application and database s/w
		Connection con=DriverManager.getConnection(url, username, password);
		
//		create a statement object
		Statement st=con.createStatement();
		
//		send and execute SQL queries;
//		DML command uses "executeQuery(String sql)" and returns a ResultSet
		ResultSet rs=st.executeQuery("SELECT * FROM books;");
		
//		process the result from ResultState
		while(rs.next()) {
			System.out.println(rs.getInt("book_id")+" : "+rs.getString("title"));
		}
		
//		Close the connection
		st.close();
		con.close();
		
	}

}
