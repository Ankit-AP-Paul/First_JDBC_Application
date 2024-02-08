package com.home.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRow {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/book_shop";
		String username="root";
		String password="AccessMe";
		
//		load and register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		establish connection
		Connection con=DriverManager.getConnection(url, username, password);
		
//		create statement object
		Statement st=con.createStatement();
		
//		execute SQL DML command: using "executeUpdate(String sql)"
//		it returns an integer on how many rows affected
		int rows=st.executeUpdate("DELETE FROM books WHERE book_id=22");
		System.out.println(rows+" row(s) affected");
		
//		close the connection
		st.close();
		con.close();

	}

}
