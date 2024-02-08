package com.home.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionHandling {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url="jdbc:mysql://localhost:3306/test_db";
		String username="root";
		String password="AccessMe";
		
		String withdraw="update accounts set balance=balance-? where acc_no=?";
		String deposit="update accounts set balance=balance+? where acc_no=?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,username,password);
		
		con.setAutoCommit(false);
		
		try {
			PreparedStatement withdrawStmt=con.prepareStatement(withdraw);
			PreparedStatement depositStmt=con.prepareStatement(deposit);
			withdrawStmt.setDouble(1, 500.00);
			withdrawStmt.setString(2, "acc123");
			depositStmt.setDouble(1, 500.00);
			depositStmt.setString(2, "acc456");
			int rowsAffectedWithdrawl=withdrawStmt.executeUpdate();
			int rowsAffectedDeposit=depositStmt.executeUpdate();
			
			if (rowsAffectedWithdrawl==1 && rowsAffectedDeposit==1) {
				con.commit();
				System.out.println("Transaction Successful");
			} else {
				con.rollback();
				System.out.println("Transaction Failed");
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		con.close();
	}

}
