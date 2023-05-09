package com.citiustech.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.citiustech.util.DatabaseConnection;

public class FlightUpdate {
	
	public static void updateFlight(){
		Scanner sc = new Scanner(System.in);
		try(Connection con = DatabaseConnection.getConnection()){
			System.out.println("Database Connected");
			System.out.println("Enter the flightid\n");
			int id = sc.nextInt();
			System.out.println("Enter the Flightname\n");
			String flight_name = sc.next().toUpperCase();
			System.out.println("Enter the FlightDatein yyyy-mm-dd\n");
			String date = sc.next();
			Date d = Date.valueOf(date);
			//Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			//System.out.println(d.getDate());
			System.out.println("Enter the Source location");
			String source = sc.next().toLowerCase();
			System.out.println("Enter the destination location");
			String destination = sc.next().toLowerCase();
			System.out.println("Enter the flight price");
			Float price = sc.nextFloat();
			System.out.println("Enter the flight duration");
			Float duration = sc.nextFloat();
			System.out.println("Enter the flight Capacity");
			int cap = sc.nextInt();
			try( PreparedStatement ps = con.prepareStatement("update FlightDetails set flight_name=?,flight_date=?,flight_source=?,flight_destination=?,flight_price=?,flight_duration=?,flight_capacity=? where flight_id=?")){
				
				 ps.setString(1, flight_name);
				 ps.setDate(2, d);
				 ps.setString(3, source);
				 ps.setString(4, destination);
				 ps.setFloat(5, price);
				 ps.setFloat(6, duration);
				 ps.setInt(7, cap);
				 ps.setInt(8, id);

				  ps.executeUpdate();
				 System.out.println("Records Updated Sucessfully!");
				 
				 //System.out.println(i+"record inserted");}catch (Exception e) {
					// System.out.println("Record not inserted because username not unique");
					// TODO: handle exception
				}
			
			
			
			con.close();
			//sc.close();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		
		
	}

}
