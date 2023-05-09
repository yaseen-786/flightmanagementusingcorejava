package com.citiustech.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.citiustech.util.DatabaseConnection;

public class BookTicketData {
	
	public static int getCustId(String username){
		int id = 0;
		try (Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database connected");
			String sql = "select cust_id from customers where username=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
			}
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection failed");
		}
		
		
		return id;
		
		
	}
	public static int getFlightId(String fname){
		int id = 0;
		try (Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database connected");
			String sql = "select flight_id from flightdetails where flight_name=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fname);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
			}
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection failed");
		}
		
		
		return id;
		
	}
	public static float getFlightCost(String fname){
		float id = 0;
		try (Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database connected");
			String sql = "select flight_price from flightdetails where flight_name=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fname);
			//ps.setInt(2, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
			}
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection failed");
		}
		
		
		return id;
	}

	public static int  getBookingId(int custid){
		int id = 0;
		try (Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database connected");
			String sql = "select * from booking where cust_id=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, custid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				id = rs.getInt(1);
			}
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection failed");
		}
		
		
		return id;
	}
	public static boolean checkBookingId(int id){
		boolean flag  = false;
		try (Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database connected");
			String sql = "select booking_id from booking where booking_id=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)==id){
					flag = true;
				}
				
			}
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection failed");
		}
		return flag;
		
	}
	public static int getFlightId(int id){
		int flag  = 0;
		try (Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database connected");
			String sql = "select flight_id from booking where booking_id=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				flag = rs.getInt(1);
				
			}
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection failed");
		}
		return flag;

	}
	public static float getBookingAmnt(int id){
		//int cap =0;
		float amt = 0;
		//int fid = 0;
		try (Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database connected");
			String sql = "select booking_amount from booking where booking_id=? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				amt = rs.getInt(1);
				//fid = rs.getInt(2);
				
			}
			
//			String sq11 = "select flight_price from flightdetails where flight_id=?";
//			ps.setInt(1, fid);
//			ResultSet rs1 = ps.executeQuery(sq11);
//			while(rs1.next()){
//				float fprice = rs.getInt(1);
//				cap =  (int) ((int)amt/fprice);
//			}
//			
		con.close();	
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection failed"+e);
		}
		return amt;
		
	}
public static float getFlightCost(int id){
	int ide = getFlightId(id);
	float amt = 0;
	//int fid = 0;
	try (Connection con = DatabaseConnection.getConnection()){
		//System.out.println("Database connected");
		String sql = "select flight_price from flightdetails where flight_id=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ide);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			amt = rs.getInt(1);
			//fid = rs.getInt(2);
			
		}
		
//		String sq11 = "select flight_price from flightdetails where flight_id=?";
//		ps.setInt(1, fid);
//		ResultSet rs1 = ps.executeQuery(sq11);
//		while(rs1.next()){
//			float fprice = rs.getInt(1);
//			cap =  (int) ((int)amt/fprice);
//		}
//		
		con.close();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Connection failed"+e);
	}
	return amt;

	
		
		
	}
public static String getFlightName(int id){
	int ide = getFlightId(id);
	String flag = null;
	try (Connection con = DatabaseConnection.getConnection()){
		//System.out.println("Database connected");
		String sql = "select flight_name from flightdetails where flight_id=? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, ide);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			flag = rs.getString(1);
			//fid = rs.getInt(2);
			
		}
		
//		String sq11 = "select flight_price from flightdetails where flight_id=?";
//		ps.setInt(1, fid);
//		ResultSet rs1 = ps.executeQuery(sq11);
//		while(rs1.next()){
//			float fprice = rs.getInt(1);
//			cap =  (int) ((int)amt/fprice);
//		}
//		
		con.close();
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Connection failed"+e);
	}
	return flag;
	
}
public static void cancelBooking(int id){
	try(Connection con = DatabaseConnection.getConnection()){
		try( PreparedStatement ps = con.prepareStatement(" delete from booking where booking_id = ?")){
			 ps.setInt(1, id);
			 boolean i = ps.execute();
		}
			 
			 //System.out.println("Record Deleted");}
		catch (Exception e) {
				 System.out.println("Deletion of record failed");
				// TODO: handle exception
			}
		con.close();
	}catch(Exception e){
		
		System.out.println("Database Connection fail");
	}
}
public static void deleteBookingHistoryOfCust(int id){
	try(Connection con = DatabaseConnection.getConnection()){
		try( PreparedStatement ps = con.prepareStatement(" delete from bookhistory where bid = ?")){
			 ps.setInt(1, id);
			 boolean i = ps.execute();
			 
			 //System.out.println("Record Deleted");
			 }
		catch (Exception e) {
				 System.out.println("Deletion of record failed"+e);
				// TODO: handle exception
			}
		con.close();
	}catch(Exception e){
		
		System.out.println("Database Connection fail");
	}
}
	
}
