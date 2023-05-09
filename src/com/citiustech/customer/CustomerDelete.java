package com.citiustech.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.citiustech.booking.BookTicketData;
import com.citiustech.main.UserInterface;
import com.citiustech.util.DatabaseConnection;

public class CustomerDelete {

	public static void deleteCustomer(){
		System.out.println("Enter your id");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		if(CustomerUsernameData.checkuser(id)){
			try(Connection con = DatabaseConnection.getConnection()){
				deleteBooking(id);
				deleteBookingHistory(id);
				try( PreparedStatement ps = con.prepareStatement(" delete from Customers where cust_id = ?")){
					 ps.setInt(1, id);
					 boolean i = ps.execute();
					 
					 System.out.println("record Deleted");
					 UserInterface.main(null);
					 }
				catch (Exception e) {
						 System.out.println("Deletion of record failed"+e);
						// TODO: handle exception
					}
				
			}catch(Exception e){
				
				System.out.println("Database Connection fail");
			}
			
		}
		else{
			System.out.println("Invalid user");
		}
		}
	public static void deleteBooking(int id){
		try(Connection con = DatabaseConnection.getConnection()){
			String sql = "SELECT booking_id FROM booking where cust_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				BookTicketData.cancelBooking(rs.getInt(1));
			}
			con.close();
		}catch ( Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	public static void deleteBookingHistory(int id){
		try(Connection con = DatabaseConnection.getConnection()){
			String sql = "SELECT bid FROM bookhistory where cust_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				BookTicketData.deleteBookingHistoryOfCust(rs.getInt(1));
			}
			con.close();
		}catch ( Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
}
