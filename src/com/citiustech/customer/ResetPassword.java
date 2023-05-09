package com.citiustech.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.citiustech.util.DatabaseConnection;

public class ResetPassword {
	
	public static void resetPassword(){
		Scanner sc  = new Scanner(System.in);
		System.out.println("Please enter the following Credential for verification");
		System.out.println("Enter your username\n");
		String user = sc.next();
		System.out.println("Enter your emailid\n");
		String email = sc.next();
		if(CustomerUsernameData.checkUsername(user)){
			if(CustomerUsernameData.checkEmail(email)){
				System.out.println("Enter the reset password");
				String pwd = sc.next();
				try(Connection con = DatabaseConnection.getConnection()){
					try( PreparedStatement ps = con.prepareStatement(" update Customers set password =? where username=?")){
						 ps.setString(1, pwd);
						 ps.setString(2, user);
						 boolean i = ps.execute();
						 
						 System.out.println("record updated");}catch (Exception e) {
							 System.out.println("Updation of record failed");
							// TODO: handle exception
						}
					
				}catch(Exception e){
					
					System.out.println("Database Connection fail");
				}
			}
			else{
				System.out.println("email invalid");
			}
			
		}
		else{
			System.out.println("Username invalid");
		};
		
		
	}

}
