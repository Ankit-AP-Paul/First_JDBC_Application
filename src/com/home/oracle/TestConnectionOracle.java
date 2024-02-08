package com.home.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnectionOracle {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "AccessMe");
		if(con==null) {
			System.out.println("Connection Failed");
		} else {
			System.out.println("Connection Established");
		}
	}

}
