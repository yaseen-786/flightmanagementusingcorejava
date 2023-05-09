package com.citiustech.admin;

import java.util.Scanner;

import com.citiustech.booking.BookTicketData;
import com.citiustech.booking.BookingHistory;
import com.citiustech.customer.CustomerUsernameData;
import com.citiustech.main.UserInterface;

public class AdminMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		//InsertFlightDetails.insertFlightDetailsToDB();
		//FlightDetailsData.displayFlights();
		//FlightUpdate.updateFlight();
		//FlightDelete.deleteFlight();
		while(true){
			System.out.println("=======================================================================================================================");
			System.out.println("-----------------Admin Menu----------------------");
			System.out.println("press 1 to insert Flight details");
			System.out.println("press 2 to update Flight details");
			System.out.println("press 3 to delete Flight Details");
			System.out.println("press 4 to show Customer  Details");
			System.out.println("press 5 to print Bookings");
			System.out.println("press 6 to displayFlights");
			System.out.println("press 7 for log out");
			System.out.println("press 8 to exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			if(choice<=8){
				switch (choice) {
				case 1:
					InsertFlightDetails.insertFlightDetailsToDB();
					break;
				case 2:
					FlightUpdate.updateFlight();
					break;
				case 3:
					FlightDelete.deleteFlight();
					break;
				case 4:
					CustomerUsernameData.displayCustomer();
					break;
				case 5:
					//FlightDelete.deleteFlight();
					BookingHistory.displayBookingHistory();
					break;
				case 6:
					FlightDetailsData.displayFlights();
					break;
				case 7:
					UserInterface.main(null);
					break;
				case 8:
					System.exit(0);
					break;
				
				default:
					
					break;
				}
				
			}
			else{
				System.out.println("Invalid Choice");
			}
		}
	}

}
