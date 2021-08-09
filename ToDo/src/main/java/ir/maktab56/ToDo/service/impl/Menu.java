package ir.maktab56.ToDo.service.impl;

import java.util.InputMismatchException;
import java.util.Scanner;
import ir.maktab56.ToDo.domain.Customer;
import ir.maktab56.ToDo.util.ApplicationContext;

public class Menu {
	Scanner input = new Scanner(System.in);
	
	public void loginUser(Customer customer) {
		try {
			System.out.println("    +-----------------------------+");
			System.out.printf("%5s     %-22s%3s\n", "|", "1. Show All Activity", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "2. Wallet", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "3. Log Out", "|");
			System.out.println("    +-----------------------------+");
			System.out.print("       Select an Option: ");
			switch(input.nextInt()) {
			case 1:
				ApplicationContext.customerServ.showAllActivity();
				System.out.println();
				loginUser(customer);
				break;
			case 2:
				showWallet();
				//ApplicationContext.customerServ.showCartProducts(customer.getId());
				System.out.println();
				loginUser(customer);
				break;
			case 3:
				System.out.println();
				break;
			default:
				System.out.println("Your Number Was Wrong!!");
				System.out.println();
				loginUser(customer);
			}
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("Please Insert a Right Number!\n");
			loginUser(customer);
		}
	}
	
	private void showWallet() {
		
	}
	
	public void showMenu() {
		try {
			System.out.println("    +----------------------+");
			System.out.printf("%5s     %-15s%3s\n", "|", "1. Login User", "|");
			System.out.printf("%5s     %-15s%3s\n", "|", "2. Sign Up", "|");
			System.out.printf("%5s     %-15s%3s\n", "|", "3. Exit", "|");
			System.out.println("    +----------------------+");
			System.out.print("       Select an Option: ");
			
			switch(input.nextInt()) {
			case 1:
				ApplicationContext.customerServ.login();
				showMenu();
				break;
				
			case 2:
				ApplicationContext.customerServ.signUp();
				showMenu();
				break;
			case 3:
				break;
			default:
				System.out.println("Your Number is Incorrect!!");
				showMenu();
			}
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("Please Insert a Number!\n");
			showMenu();
		}
		
	}
}

