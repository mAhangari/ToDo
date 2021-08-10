package ir.maktab56.ToDo.service.impl;

import java.sql.Date;
import java.util.*;
import ir.maktab56.ToDo.base.service.impl.BaseServiceImpl;
import ir.maktab56.ToDo.domain.*;
import ir.maktab56.ToDo.domain.enumeration.*;
import ir.maktab56.ToDo.repository.impl.CustomerRepositoryImpl;
import ir.maktab56.ToDo.service.CustomerService;
import ir.maktab56.ToDo.util.ApplicationContext;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepositoryImpl> implements CustomerService {

	private Scanner input = new Scanner(System.in);
	
	public CustomerServiceImpl(CustomerRepositoryImpl repository) {
		super(repository);
	}
		
	public void login() {
		Comparator<Activity> comparator = null;
		System.out.print("       Insert Your Username: ");
		var username = input.next();

		System.out.print("       Insert Your Password: ");
		var password = input.next();
		
		if(ApplicationContext.chInInformation.checkCustomerInformation(username, password)) {
			ApplicationContext.menu.loginUser(choosCustomer(username), comparator);
		}
		else {
			System.out.println("Your Username or Password is Incorrect.\n");
		}
	}
	
	public void signUp() {
		var username = "";
		var password = "";
		var birthday = "";
		var phoneNumber = "";
		var email = "";
		
		System.out.print("       Insert Your First Name: ");
		var firstName = input.next();
		
		System.out.print("       Insert Your Last Name: ");
		var lastName = input.next();
		
		do{
			System.out.println("Your Username Must Have 3 To 15 Charecter And Must Have One Of These Charecter([a-z0-9_-]).");
			System.out.print("       Insert Your Username: ");
			username = input.next();
			
		}while(ApplicationContext.chInInformation.checkCustomerUsername(username));
		
		do{
			System.out.println("Your Password Must Have 8 or more Charecter.");
			System.out.print("       Insert Your Password: ");
			password = input.next();
			
		}while(ApplicationContext.chInInformation.checkPassword(password));
		
		System.out.print("       Insert Your National Cod: ");
		var nationalCode = input.next();
		
		do {
			System.out.print("       Insert Your Phone Number: ");
			phoneNumber = input.next();
		}while(ApplicationContext.chInInformation.checkPhoneNumber(phoneNumber));
		
		do {
			System.out.print("       Insert Your Email: ");
			email = input.next();
		}while(ApplicationContext.chInInformation.checkEmailAddress(email));
		
		do {
			System.out.print("       Insert Your Berthday(yyyy-mm-dd): ");
			birthday = input.next();
		}while(ApplicationContext.chInInformation.checkDate(birthday));
		
		Date date = Date.valueOf(birthday);
		
		Customer customer = new Customer(false, username, password, nationalCode, firstName, lastName, email, phoneNumber, UserType.CUSTOMER, true, date);
		Wallet wallet = new Wallet(false, 0l, 0l, 0l);
		wallet.setCustomer(customer);
		ApplicationContext.walletServ.save(wallet);
		System.out.println("    +----------------------------------------+");
		System.out.printf("%5s     %-33s%3s\n", "|", "       Congratulations!", "|");
		System.out.printf("%5s     %-33s%3s\n", "|", "Your Registration was Successful.", "|");
		System.out.println("    +----------------------------------------+");
	}
	
	private Customer choosCustomer(String username) {
		return ApplicationContext.customerRepo.findByUsername(username);
	}

	public boolean showAllActivity(Customer customer, Comparator<Activity> comparator) {
		return ApplicationContext.activityServ.showCustomerActivity(customer.getId(), comparator);
	}

	public void addNewActivity(Customer customer) {
		try {
			State state = null;
			System.out.print("       Enter Activity Title: ");
			input.nextLine();
			var title = input.nextLine();
			System.out.println("    +------ Stete Of Activity -----+");
			System.out.printf("%5s     %-23s%3s\n", "|", "1. Open an Activity", "|");
			System.out.printf("%5s     %-23s%3s\n", "|", "2. Activity In Progress", "|");
			System.out.printf("%5s     %-23s%3s\n", "|", "3. Activity Completed", "|");
			System.out.println("    +------------------------------+");
			System.out.print("       Select an Option: ");
			
			switch(input.nextInt()) {
			
			case 1:
				state = State.OPEN;
				break;
			case 2:
				state = State.IN_PROGRESS;
				break;
			case 3:
				state = State.COMPLETED;
				break;
			default:
				System.out.println("    +--------------------------------+");
				System.out.printf("%5s     %-25s%3s\n", "|", "Your Number Was Wrong!!", "|");
				System.out.println("    +--------------------------------+");
				addNewActivity(customer);
			}
			
			ApplicationContext.activityServ.addActivity(customer, state, title);
			
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			addNewActivity(customer);
		}
	}
}
