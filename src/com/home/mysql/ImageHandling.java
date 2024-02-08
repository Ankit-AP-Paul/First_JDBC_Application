package com.home.mysql;

//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ImageHandling {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String url="jdbc:mysql://localhost:3306/test_db";
		String username="root";
		String password="AccessMe";
		
//		for inserting image data into table

//		String image_path="C:\\Users\\ANKIT\\OneDrive\\Pictures\\Screenshots\\Screenshot (15).png";
//		
//		String query="INSERT INTO image_table(image_data) VALUES (?);";
//		
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection con=DriverManager.getConnection(url, username, password);
//		
//		FileInputStream fileInputStream=new FileInputStream(image_path);
//		byte[] imageData = new byte[fileInputStream.available()];
//		fileInputStream.read(imageData);
//		
//		PreparedStatement pst=con.prepareStatement(query);
//		pst.setBytes(1, imageData);
//		int rowsAffected=pst.executeUpdate();
//		System.out.println(rowsAffected+" row(s) affected");
//		
//		fileInputStream.close();
//		con.close();

		
//		for retriving image data from table
		
		String folder_path="E:\\Pictures\\personal\\";
		
		String query="SELECT image_data FROM image_table WHERE image_id = ?";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url, username, password);
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, 1);
		ResultSet rs=pst.executeQuery();
		if(rs.next()) {
			byte[] imageData=rs.getBytes("image_data");
			String image_path=folder_path+"pokemon.png";
			OutputStream outputStream=new FileOutputStream(image_path);
			outputStream.write(imageData);
			System.out.println("Image retrival successful");
			outputStream.close();
		} else {
			System.out.println("Image not found");
		}
		
		con.close();
		
	}

}
