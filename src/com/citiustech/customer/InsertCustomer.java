package com.citiustech.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.citiustech.util.DatabaseConnection;

public class InsertCustomer {
	public static void insertCustomerToDB() {
		boolean flag = true;
		String username;
		try(Connection con = DatabaseConnection.getConnection()){
				
		//DriverManager.getConnection("jdbc:mysql://localhost/FlightManagement","root","root")){
		//System.out.println("Connection sucessful");
		 //PreparedStatement ps = DatabaseConnection.getConnection().prepareStatement("insert into Customers values(?,?,?,?,?)");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name\n");
		String name = sc.next();
		System.out.println("Enter your username\n");
		username = sc.next();
		if(CustomerUsernameData.checkUsername(username)==true){
			System.out.println("Username exist ");
			CustomerLogin.custlogin();
		}
		else{
			flag = false;
		}
		System.out.println("Enter your password\n");
		String pwd = sc.next();
		System.out.println("Enter your email\n");
		String email = sc.next();
		System.out.println("Enter your phonenumber");
		String phone = sc.next();
		
		System.out.println();
		
		try( PreparedStatement ps = con.prepareStatement("insert into Customers values(?,?,?,?,?,?)")){
		 ps.setString(1, null);
		 ps.setString(2, name);
		 ps.setString(3, username);
		 ps.setString(4, pwd);
		 ps.setString(5, email);
		 ps.setString(6, phone);
		 boolean i = ps.execute();
		 
		 System.out.println("User Registered");}catch (Exception e) {
			 System.out.println("Record not inserted because username not unique");
			// TODO: handle exception
		}
		
		}catch (Exception e) {
			System.out.println("Database not connected");
			// TODO: handle exception
		}
		 //DatabaseConnection.getConnection().close();
	}
}

