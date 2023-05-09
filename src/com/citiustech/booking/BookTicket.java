package com.citiustech.booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.citiustech.admin.FlightDetailsData;
import com.citiustech.util.DatabaseConnection;

public class BookTicket {
	
	public static void bookTicket(String username) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the source of the flight\n");
		String src = sc.next();
		System.out.println("Enter the destination of the flight\n");
		String dest = sc.next().toLowerCase();
		//System.out.print("Enter the date in the yyyy-mm-dd format\n ");
		System.out.println("Enter the FlightDatein yyyy-mm-dd\n");
		String date = sc.next().toLowerCase();
		Date d = Date.valueOf(date);
		
		try(Connection con = DatabaseConnection.getConnection() ){
			//System.out.println("Database Connected Sucessfulyy");
			String query = "SELECT * FROM flightdetails WHERE flight_source=? AND flight_destination=? AND flight_date = ? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, src);
			ps.setString(2, dest);
			ps.setDate(3, d);
			//boolean val = ps.execute();
			//System.out.println(val);
			ResultSet rs = ps.executeQuery();
			//System.out.println("Query Executed");
			//System.out.println(rs);
			//if(rs.next()){
			//System.out.println("flightname\tprice\tduration\tcapacity");
			if(rs.next()==false){
				
				
//			}else{
//				System.out.println("Flight not found");
//			}
				System.out.println("Flight with source destination or date not found");
			}
			else{
				System.out.println("flightname\tamount\tduration\tcapacity");
				do{
					System.out.println(" "+rs.getString(2)+"     |"+rs.getFloat(6)+"     |"+rs.getFloat(7)+"     |"+rs.getInt(8));
				}while(rs.next());
					
				ContinueBooking( username);
				
			}
			
			
			
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Database Connection failed"+e);
		}
				
	
	
		
	}
	public static void ContinueBooking(String username){
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the flightname");
		String fname = sc.next().toUpperCase();
		System.out.println("Enter the number of ticket");
		int no = sc.nextInt();
		//System.out.println(FlightDetailsData.returnCapacity(fname));
		if(FlightDetailsData.returnCapacity(fname)>=no){
			int cap = (FlightDetailsData.returnCapacity(fname));
			
			int custid=BookTicketData.getCustId(username);
			int flightid = BookTicketData.getFlightId(fname);
			float cost = BookTicketData.getFlightCost(fname)*no;
			int seatno = custid;
			//System.out.printf("%d %d %f %d",custid,flightid,cost,seatno);
			try(Connection con = DatabaseConnection.getConnection()){
				String sql = "insert into booking values (?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, null);
				ps.setInt(2, custid);
				ps.setInt(3, flightid);
				ps.setFloat(4, cost);
				ps.setInt(5, seatno);
				ps.execute();
				FlightDetailsData.updateCapacity(cap-no, fname);
				System.out.println("Your Booking Sucessfull with booking Id is "+BookTicketData.getBookingId(custid));
				BookingHistory.getFlightDetails(flightid,cost,custid);
				//BookingHistory.insertIntoBookingHistory(custid, resultSet, cost);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
		}
		else{
			System.out.println("the capacity has exceeded the limit you applied");
		}
	}

}
