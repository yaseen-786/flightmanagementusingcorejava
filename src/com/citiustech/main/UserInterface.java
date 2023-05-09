package com.citiustech.main;

import java.util.Scanner;

import com.citiustech.admin.AdminLogin;
import com.citiustech.admin.AdminMain;
import com.citiustech.customer.CustomerLogin;
import com.citiustech.customer.CustomerMain;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true){
		System.out.println("=======Welcome to ctair========");
		System.out.println("press 1 for admin");
		System.out.println("press 2 for customer");
		System.out.println("press 3 to exit");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		if(choice == 1){
			AdminLogin.main(args);
		}
		else if(choice == 2){
			CustomerLogin.custlogin();
		}
		else if(choice == 3){
			System.exit(0);
		}
		else{
			System.out.println("Enter a valid choice");
		}
		}
	}

}
