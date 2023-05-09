package com.citiustech.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.citiustech.util.DatabaseConnection;

public class CustomerUpdate {
	public static void update(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your id number\n");
		int id = sc.nextInt();
		if(CustomerUsernameData.checkuser(id)){
		System.out.println("Enter your name\n");
		String name = sc.next();
		System.out.println("Enter your username\n");
		String username = sc.next();
		System.out.println("Enter your password\n");
		String pwd = sc.next();
		System.out.println("Enter your email\n");
		String email = sc.next();
		System.out.println("Enter your phonenumber");
		String phone = sc.next();
		try(Connection con = DatabaseConnection.getConnection()){
			try( PreparedStatement ps = con.prepareStatement("update Customers set cust_name=?,username=?,password=?,email=?,phone=? where cust_id=?")){
				 ps.setString(1, name);
				 ps.setString(2, username);
				 ps.setString(3, pwd);
				 ps.setString(4, email);
				 ps.setString(5, phone);
				 ps.setInt(6, id);
				 boolean i = ps.execute();
				 
				 System.out.println("record Updated");}catch (Exception e) {
					 System.out.println("Record not updated  because invalid id");
					// TODO: handle exception
				}
		
			
		}catch(Exception e)
		{
			System.out.println("Database connection fail");
		}
		System.out.println();
		}
		else{
			System.out.println("Enter a valid id");
		}
	}
}
