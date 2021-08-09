package ir.maktab56.ToDo.service.impl;

import java.sql.Date;
import java.util.*;
import ir.maktab56.ToDo.base.service.impl.BaseServiceImpl;
import ir.maktab56.ToDo.domain.Customer;
import ir.maktab56.ToDo.domain.enumeration.UserType;
import ir.maktab56.ToDo.repository.impl.CustomerRepositoryImpl;
import ir.maktab56.ToDo.service.CustomerService;
import ir.maktab56.ToDo.util.ApplicationContext;

public class CustomerServiceImpl extends BaseServiceImpl<Customer, Long, CustomerRepositoryImpl> implements CustomerService {

	public List<Customer> customers = new ArrayList<Customer>();
	private Scanner input = new Scanner(System.in);
	
	public CustomerServiceImpl(CustomerRepositoryImpl repository) {
		super(repository);
	}
		
	public void login() {
		System.out.print("Insert Your Username: ");
		var username = input.next();

		System.out.print("Insert Your Password: ");
		var password = input.next();
		
		if(ApplicationContext.chInInformation.checkCustomerInformation(username, password)) {
			System.out.println("\n************************");
			System.out.println("* Welcome to Your Page *");
			System.out.println("************************");
			ApplicationContext.menu.loginUser(choosCustomer(username));
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
		
		System.out.print("Insert Your First Name: ");
		var firstName = input.next();
		
		System.out.print("Insert Your Last Name: ");
		var lastName = input.next();
		
		do{
			System.out.println("Your Username Must Have 3 To 15 Charecter And Must Have One Of These Charecter([a-z0-9_-]).");
			System.out.print("Insert Your Username: ");
			username = input.next();
			
		}while(ApplicationContext.chInInformation.checkCustomerUsername(username));
		
		do{
			System.out.println("Your Password Must Have 8 or more Charecter.");
			System.out.print("Insert Your Password: ");
			password = input.next();
			
		}while(ApplicationContext.chInInformation.checkPassword(password));
		
		System.out.print("Insert Your National Cod: ");
		var nationalCode = input.next();
		
		do {
			System.out.print("Insert Your Phone Number: ");
			phoneNumber = input.next();
		}while(ApplicationContext.chInInformation.checkPhoneNumber(phoneNumber));
		
		do {
			System.out.print("Insert Your Email: ");
			email = input.next();
		}while(ApplicationContext.chInInformation.checkEmailAddress(email));
		
		do {
			System.out.print("Insert Your Berthday(yyyy-mm-dd): ");
			birthday = input.next();
		}while(ApplicationContext.chInInformation.checkDate(birthday));
		
		Date date = Date.valueOf(birthday);
		
		Customer customer = new Customer(false, username, password, nationalCode, firstName, lastName, email, phoneNumber, UserType.CUSTOMER, true, date);
		ApplicationContext.customerRepo.save(customer);
		System.out.println("\nCongratulations! Your Registration was Successful.\n But you should wait until admin accept your sign up.\n");
	}
	
	private Customer choosCustomer(String username) {
		return ApplicationContext.customerRepo.findByUsername(username);
	}

	public void showAllActivity() {
		// TODO Auto-generated method stub
		
	}
}
