/*
	Prepared statement is used to execute SQL queries with place holders for parameters
	these place holders are then filled with specific values when the query is executed
	advantages:
	* protection against SQL injection
	* improved performance
	* code readability and maintainability
	* automatic data type handling
	* portability
*/

package com.home.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsingPreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/book_shop";
		String username="root";
		String password="AccessMe";
		
		String query="INSERT INTO books(title, author_fname, author_lname) VALUES (?, ?, ?)"; // ? is placeholder
		
//		load and register driver s/w
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		establish connection
		Connection con=DriverManager.getConnection(url, username, password);
		
//		create prepared statement object and provide the missing values
//		placeholder's value start from 1
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, "Gitanjali");
		pst.setString(2, "Rabindranath");
		pst.setString(3, "Tagore");
		
//		execute DML query
		int rows=pst.executeUpdate();
		System.out.println(rows+" row(s) affected");
		
//		close the connection
		pst.close();
		con.close();

	}

}
