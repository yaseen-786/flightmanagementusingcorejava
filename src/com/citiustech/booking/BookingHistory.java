package com.citiustech.booking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.citiustech.customer.StaticInstance;
import com.citiustech.util.DatabaseConnection;

public class BookingHistory {
	public static void displayBookingHistory(){
		//System.out.println("Enter your booking id");
		//int custid = BookTicketData.getCustId(StaticInstance.username);
		try(Connection con = DatabaseConnection.getConnection()){
			String sql = "SELECT b.booking_id,c.cust_id,b.booking_amount,c.cust_name, f.flight_id, "
					+ "f.flight_name,f.flight_date,f.flight_source,f.flight_destination,f.flight_duration "
					+ "from ((customers as c inner join booking as b on c.cust_id = b.cust_id) inner join "
					+ "flightdetails as f on f.flight_id = b.flight_id)";
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setInt(1, custid);
			ResultSet rs = ps.executeQuery();
			System.out.println("---------------------------------------------------------------------------------------------------");
			System.out.printf("%5s %8s %8s %8s %10s %8s %8s %8s %8s %10s", "Bookid", "custid", "bookamnt", 
					"custname", "flightid", "name","flightdate","source","destination","duration\n");
			System.out.println("----------------------------------------------------------------------------------------------------");
			while(rs.next()){
				System.out.println(" "+rs.getInt(1)+"  |"+rs.getInt(2)+"  | "+rs.getFloat(3)+"   |"+rs.getString(4)+"  |"+rs.getInt(5)+
			"   |"+rs.getString(6)+"   |"+rs.getDate(7)+"   |"+rs.getString(8)+"  |"+rs.getString(9)+"   |"+rs.getFloat(10)+"\n");
				
			}
			con.close();
		}catch ( Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}
	public static void displayCustomerBookingHistory(){
		
				//System.out.println("Enter your booking id");
				int custid = BookTicketData.getCustId(StaticInstance.username);
				try(Connection con = DatabaseConnection.getConnection()){
					String sql = "SELECT * FROM bookhistory WHERE cust_id=?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, custid);
					ResultSet rs = ps.executeQuery();
					System.out.println("---------------------------------------------------------------------------------------------------");
					System.out.printf("%5s %8s %8s %8s %10s %8s %8s ",  "custid", "flyname", 
							"flightdate","source","destination","price","duration\n");
					System.out.println("----------------------------------------------------------------------------------------------------");
					while(rs.next()){
						System.out.println(" "+rs.getInt(2)+"  |"+rs.getString(3)+"  | "+rs.getDate(4)+"   |"+rs.getString(5)+"  |"+rs.getString(6)+
					"   |"+rs.getFloat(7)+"   |"+rs.getFloat(8)+"\n");
						
					}
					
					con.close();
				}catch ( Exception e) {
					System.out.println(e);
					// TODO: handle exception
				}
		
		
	}
	public static void getFlightDetails(int id ,float cost,int custid){
		 //ResultSet rs;
		String fname = null ;
		Date fdate = null;
		String fsrc  = null;
		String fdest=null;
		float dur=0F;
		try(Connection con = DatabaseConnection.getConnection()){
			//System.out.println("Database Connected");
			//System.out.println(id);
			//String sql = "SELECT * FROM flightdetails WHERE flight_id=?";
			
			PreparedStatement st = con.prepareStatement("SELECT * FROM flightdetails WHERE flight_id=?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				//System.out.println(rs.getString(2)+rs.getDate(3)+rs.getString(4)+rs.getString(5));
				 fname = rs.getString(2) ;
				 fdate =rs.getDate(3) ;
				 fsrc  = rs.getString(4);
				 fdest= rs.getString(5);
				 dur = rs.getFloat(7);
			}
			insertIntoBookingHistory(custid, fname, fdate, fsrc, fdest, cost, dur);
			con.close();
			
		}catch(Exception e){
			System.out.println("Connection failed"+e);
			//rs = null;
		}
		//return rs;
	}
	public static void insertIntoBookingHistory(int custid,String p2,Date p3,String p4,String p5,float cost,float dur ){
		
		
		
	try(Connection con = DatabaseConnection.getConnection()){
	
			PreparedStatement ps = con.prepareStatement("INSERT INTO bookhistory values (?,?,?,?,?,?,?,?)");
			ps.setString(1, null);
			ps.setInt(2, custid);
			ps.setString(3,p2 );
			ps.setDate(4, p3);
			ps.setString(5, p4);
			ps.setString(6, p5);
			ps.setFloat(7, cost);
			ps.setFloat(8, dur);
			ps.execute();
			
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	public void deleteCustomerBookingHistory(int id){
		
	}
}
