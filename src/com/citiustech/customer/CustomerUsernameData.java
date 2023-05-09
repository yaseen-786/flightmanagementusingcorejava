package com.citiustech.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.citiustech.util.DatabaseConnection;

public class CustomerUsernameData {
	
	public static boolean checkUsername(String user){
		boolean flag = false;
		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database Connected");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select username from Customers");
			//System.out.println("eid\tename\tesal\t");
			//System.out.println("----------------------------------------------------------------------");
			while(rs.next()){
				if(rs.getString(1).equals(user)){
					flag = true;
				}
				
			}
			
			con.close();
			
			
		}catch(Exception e){
			System.out.println("Connection failed");
		}
		return flag;
	}
	public static boolean checkEmail(String Email){
		boolean flag = false;
		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database Connected");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select email from Customers");
			//System.out.println("eid\tename\tesal\t");
			//System.out.println("----------------------------");
			while(rs.next()){
				if(rs.getString(1).equals(Email)){
					flag = true;
				}
				
			}
			
			con.close();
			
			
		}catch(Exception e){
			System.out.println("Connection failed");
		}
		return flag;
	}
	public static boolean checkuser(int id){
		boolean flag = false;
		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database Connected");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select cust_id from Customers");
			//System.out.println("eid\tename\tesal\t");
			//System.out.println("----------------------------");
			while(rs.next()){
				if(rs.getInt(1)==id){
					flag = true;
				}
				
			}
			
			con.close();
			
			
		}catch(Exception e){
			System.out.println("Connection failed");
		}
		return flag;
	}
	public static boolean checkUserLogin(String user,String pwd){
		
		boolean flag = false;
		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database Connected");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select username,password from Customers");
			//System.out.println("eid\tename\tesal\t");
			//System.out.println("----------------------------");
			while(rs.next()){
				if(rs.getString(1).equals(user) && rs.getString(2).equals(pwd)){
					flag = true;
				}
				
			}
			
			con.close();
			
			
		}catch(Exception e){
			System.out.println("Connection failed");
		}
		return flag;
		
		
		
		
		
		
		
	}
	public static void displayCustomer(){

		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database Connected");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select cust_id,cust_name,username,password,email,phone from Customers");
			System.out.println("---------------------------------------------------------------------------------------");
			
			System.out.println("cust_id\tcust_name\tusername\tpasssword\temail\t\t\tphone");
			System.out.println("---------------------------------------------------------------------------------------");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t|  "+rs.getString(2)+"\t| "+rs.getString(3)+"\t|  "+rs.getString(4)+"\t|  "+rs.getString(5)+"\t|  "+rs.getString(6));
				
			}
			con.close();
			
		}catch(Exception e){
			System.out.println("Connection failed");
		}
	}

}
