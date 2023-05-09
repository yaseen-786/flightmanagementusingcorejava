package com.citiustech.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.citiustech.booking.BookTicketData;
import com.citiustech.booking.CancelTicket;
import com.citiustech.util.DatabaseConnection;

public class FlightDelete {
	public static void deleteFlight(){
		System.out.println("Enter your Flight_id");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		try(Connection con = DatabaseConnection.getConnection()){
			bookingDelete(id);
			try( PreparedStatement ps = con.prepareStatement(" delete from FlightDetails where flight_id = ?")){
				 ps.setInt(1, id);
				 ps.execute();
			}
				 //System.out.println(i+"record Deleted");}
			catch (Exception e) {
					 //System.out.println("Deletion of record failed"+e);
					// TODO: handle exception
			}
		con.close();
		//sc.close();
			
		}catch(Exception e){
			
			System.out.println("Database Connection fail"+e);
		}
	
		
	}
	public static void bookingDelete(int id){
		try(Connection con = DatabaseConnection.getConnection()){
			String sql = "SELECT booking_id FROM booking where flight_id=?";
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
	

}
