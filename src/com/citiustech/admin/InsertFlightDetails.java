package com.citiustech.admin;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.citiustech.util.DatabaseConnection;

public class InsertFlightDetails {
	
	public static void insertFlightDetailsToDB(){
		Scanner sc = new Scanner(System.in);
		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database Connected");
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
			try( PreparedStatement ps = con.prepareStatement("insert into FlightDetails values(?,?,?,?,?,?,?,?)")){
				 ps.setString(1, null);
				 ps.setString(2, flight_name);
				 ps.setDate(3, d);
				 ps.setString(4, source);
				 ps.setString(5, destination);
				 ps.setFloat(6, price);
				 ps.setFloat(7, duration);
				 ps.setInt(8, cap);

				 boolean i = ps.execute();
				 
				 System.out.println("record inserted");}catch (Exception e) {
					 System.out.println("Record not inserted because Flightname not unique");
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
