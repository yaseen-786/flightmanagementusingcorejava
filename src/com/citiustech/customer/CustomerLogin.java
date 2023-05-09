package com.citiustech.customer;

import java.util.Scanner;

import com.citiustech.admin.AdminMain;

public class CustomerLogin {
	public static void custlogin(){
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("------------------------Customer Login System--------");
			System.out.println("press 1 to registered");
			System.out.println("press 2 to login");
			System.out.println("Enter your choice");
			int ch = sc.nextInt();
			if(ch<=2){
				if(ch==1){
					InsertCustomer.insertCustomerToDB();
				}
				else {
					System.out.println("press 1 to login");
					System.out.println("press 2 to reset Password");
					int cho = sc.nextInt();
					if(cho==1){
					System.out.println("Please enter Your username");
					String user = sc.next();
					System.out.println("Please Enter Your Password");
					String pwd = sc.next();
					if(CustomerUsernameData.checkUserLogin(user, pwd)){
						StaticInstance.password = pwd;
						StaticInstance.username = user;
						CustomerMain.customerUI();
					}
					else{
						System.out.println("Invalid user");
						
					}
					}
					else if(cho==2){
						ResetPassword.resetPassword();
					}
					else{
						System.out.println("Invalid choice");
						
					}

				}
			}else{
				System.out.println("Invalid choice");
			}
			}

		}
	

}
