package com.citiustech.admin;

import java.util.Scanner;

public class AdminLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		//InsertFlightDetails.insertFlightDetailsToDB();
		//FlightDetailsData.displayFlights();
		//FlightUpdate.updateFlight();
		//FlightDelete.deleteFlight();
		while(true){
		System.out.println("------------------------Admin Login System--------");
		System.out.println("Please enter Your Id");
		int id = sc.nextInt();
		System.out.println("Please Enter Your Password");
		
		String pwd = sc.next();
		if(id == 101 && pwd.equals("admin123")){
			AdminMain.main(args);
		}
		else{
			System.out.println("Invalid user");
			
		}
		}

	}

}
