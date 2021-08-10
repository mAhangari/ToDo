package ir.maktab56.ToDo.service.impl;

import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import ir.maktab56.ToDo.domain.Activity;
import ir.maktab56.ToDo.domain.Customer;
import ir.maktab56.ToDo.util.ApplicationContext;

public class Menu {
	Scanner input = new Scanner(System.in);
	
	public void loginUser(Customer customer, Comparator<Activity> comparator) {
		try {
			
			System.out.println("    +-----------------------------+");
			System.out.printf("%5s     %-22s%3s\n", "|", "Welcome to your Page", "|");
			System.out.println("    +-----------------------------+");
			
			
			System.out.println("    +-----------------------------+");
			System.out.printf("%5s     %-22s%3s\n", "|", "1. Show All Activity", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "2. Wallet", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "3. Activity", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "4. Exit", "|");
			System.out.println("    +-----------------------------+");
			System.out.print("       Select an Option: ");
			switch(input.nextInt()) {
			case 1:
				ApplicationContext.customerServ.showAllActivity(customer, comparator);
				loginUser(customer, comparator);
				break;
			case 2:
				showWallet(customer, comparator);
				loginUser(customer, comparator);
				break;
			case 3:
				activityMenu(customer, comparator);
				break;
			case 4:
				break;
			default:
				System.out.println("    +--------------------------------+");
				System.out.printf("%5s     %-25s%3s\n", "|", "Your Number Was Wrong!!", "|");
				System.out.println("    +--------------------------------+");
				loginUser(customer, comparator);
			}
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			loginUser(customer, comparator);
		}
	}
	
	private void activityMenu(Customer customer, Comparator<Activity> comparator) {
		
		try {
			System.out.println("    +---------------------------------------+");
			System.out.printf("%5s     %-32s%3s\n", "|", "1. New Activity", "|");
			System.out.printf("%5s     %-32s%3s\n", "|", "2. Change State Of an Activity", "|");
			System.out.printf("%5s     %-32s%3s\n", "|", "3. Change Activity Sorting", "|");
			System.out.printf("%5s     %-32s%3s\n", "|", "4. Exit", "|");
			System.out.println("    +---------------------------------------+");
			System.out.print("       Select an Option: ");
			switch(input.nextInt()) {
				case 1:
					ApplicationContext.customerServ.addNewActivity(customer);
					activityMenu(customer, comparator);
					break;
				case 2:
					if(ApplicationContext.customerServ.showAllActivity(customer, comparator))
						ApplicationContext.activityServ.changeState(customer);
					else {
						System.out.println("    +--------------------------------+");
						System.out.printf("%5s     %-25s%3s\n", "|", "No Activity Exist!!", "|");
						System.out.println("    +--------------------------------+");
					}
					activityMenu(customer, comparator);
					break;
				case 3:
					comparator = ApplicationContext.activityServ.sorting();
					loginUser(customer, comparator);
					break;
				case 4:
					loginUser(customer, comparator);
					break;
				default:
					System.out.println("    +--------------------------------+");
					System.out.printf("%5s     %-25s%3s\n", "|", "Your Number Was Wrong!!", "|");
					System.out.println("    +--------------------------------+");
					activityMenu(customer, comparator);
			}
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			activityMenu(customer, comparator);
		}
		
	}

	private void showWallet(Customer customer, Comparator<Activity> comparator) {
		try {
			System.out.println("    +-----------------------------+");
			System.out.printf("%5s     %-22s%3s\n", "|", "1. Change Cash", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "2. Show Cash", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "3. Exit", "|");
			System.out.println("    +-----------------------------+");
			System.out.print("       Select an Option: ");
			switch(input.nextInt()) {
			case 1:
				ApplicationContext.walletServ.changeCash(customer.getWallet());
				showWallet(customer, comparator);
				break;
			case 2:
				ApplicationContext.walletServ.showCash(customer.getId());
				showWallet(customer, comparator);
				break;
			case 3:
				break;
			default:
				System.out.println("    +--------------------------------+");
				System.out.printf("%5s     %-25s%3s\n", "|", "Your Number Was Wrong!!", "|");
				System.out.println("    +--------------------------------+");
				loginUser(customer, comparator);
			}
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			loginUser(customer, comparator);
		}
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
				System.out.println("    +--------------------------------+");
				System.out.printf("%5s     %-25s%3s\n", "|", "Your Number Was Wrong!!", "|");
				System.out.println("    +--------------------------------+");
				showMenu();
			}
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			showMenu();
		}
		
	}
}

