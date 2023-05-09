package com.citiustech.booking;

import java.util.Scanner;

import com.citiustech.admin.FlightDetailsData;

public class CancelTicket {
	public static void ticketCancel(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Booking id");
		int id = sc.nextInt();
		if(BookTicketData.checkBookingId(id)){
			//System.out.println(BookTicketData.getBookingAmnt(id));
			//System.out.println(BookTicketData.getFlightCost(id));
			int cap = (int) (BookTicketData.getBookingAmnt(id)/BookTicketData.getFlightCost(id));
			//System.out.println(cap);
			
			int inicap = FlightDetailsData.returnCapacity(BookTicketData.getFlightName(id));
			//System.out.println(inicap);
			int totalcap = cap+inicap;
			//System.out.println(BookTicketData.getFlightName(id));
			String s = BookTicketData.getFlightName(id);
			FlightDetailsData.updateCapacity(totalcap, s);
			BookTicketData.cancelBooking(id);
			//FlightDetailsData.updateCapacity(FlightDetailsData.returnCapacity(BookTicketData.getFlightName(id))+cap, BookTicketData.getFlightName(id));
			System.out.println("Your Booking is Canceled for Booking Id"+id);
		}
		else{
			System.out.println("Invalid BookingId");
		}
		
		
		
	}

}
