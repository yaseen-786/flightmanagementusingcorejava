package com.citiustech.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.citiustech.util.DatabaseConnection;

public class FlightDetailsData {
	
	public static void displayFlights(){
		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database Connected");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select flight_id,flight_name,flight_date,flight_source,flight_destination,flight_price,flight_duration,flight_capacity from FlightDetails");
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			
			System.out.println("id\tname\t\t\tdate  \t\tsource  \tdestination  \tprice\tduration\tcapacity");
			System.out.println("---------------------------------------------------------------------------------------------------------------------");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t|  "+rs.getString(2)+"\t|  "+rs.getDate(3)+"\t|  "+rs.getString(4)+"\t|      "+rs.getString(5)+"\t|   "+rs.getFloat(6)+"\t|     "+rs.getFloat(7)+"\t|  "+rs.getInt(8));
				
			}
			con.close();
			
		}catch(Exception e){
			System.out.println("Connection failed");
		}
	}
	public static int returnCapacity(String fname){
		int cap = 0;
		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("database Connected");
			PreparedStatement ps =con.prepareStatement("SELECT flight_capacity FROM flightdetails WHERE flight_name=? ");
			ps.setString(1, fname);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
					cap = rs.getInt(1);
			}
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			
		}
		return cap;
		
	}
	public static void updateCapacity(int data,String fname){
		try(Connection con = DatabaseConnection.getConnection()){
			PreparedStatement ps = con.prepareStatement("update flightdetails set flight_capacity=? where flight_name=?");
			ps.setInt(1, data);
			ps.setString(2, fname);
			ps.execute();
			//System.out.println("Flight Details Updated");
			
			con.close();
		}catch (Exception e) {
			// TODO: handle exception
			//System.out.println("flight capacity not  updated"+e);
		}
		
	}
	

}
