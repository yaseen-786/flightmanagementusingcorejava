package com.citiustech.customer;

import java.util.Scanner;

import com.citiustech.admin.FlightDelete;
import com.citiustech.admin.FlightUpdate;
import com.citiustech.admin.InsertFlightDetails;
import com.citiustech.booking.BookTicket;
import com.citiustech.booking.BookingHistory;
import com.citiustech.booking.CancelTicket;
import com.citiustech.main.UserInterface;

public class CustomerMain {
	

	public static void customerUI() {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		//InsertCustomer.insertCustomerToDB();
		//System.out.println(CustomerUsernameData.checkUsername("yaseen1.khan"));
		//ResetPassword.resetPassword();
		//CustomerUpdate.update();
		//CustomerDelete.deleteCustomer();
		//CustomerUsernameData.displayCustomer();
		//BookTicket.bookTicket();
		while(true){
			System.out.println("==================================================================================");
			System.out.println("----------------customer menu---------------");
			System.out.println("press 1 to Update Customer Details");
			System.out.println("press 2 to Delete Customer Account");
			System.out.println("press 3 to Book flight ");
			System.out.println("press 4 to Cancel Ticket");
			System.out.println("press 5 to BookingHistory Bookings");
			System.out.println("press 6 to logout");
			System.out.println("press 7 to exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			if(choice<=7){
				switch (choice) {
				case 1:
					CustomerUpdate.update();
					break;
				case 2:
					CustomerDelete.deleteCustomer();
					break;
				case 3:
					BookTicket.bookTicket(StaticInstance.username);
					break;
				case 4:
					CancelTicket.ticketCancel();
					break;
				case 5:
					//FlightDelete.deleteFlight();
					BookingHistory.displayCustomerBookingHistory();;
					break;
				case 6:
					UserInterface.main(null);
					break;
				case 7:
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
