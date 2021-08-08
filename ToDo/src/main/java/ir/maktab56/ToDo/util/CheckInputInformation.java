package ir.maktab56.ToDo.util;

import java.util.regex.Pattern;
public class CheckInputInformation {
	
	public boolean checkCustomerUsername(String username) {
		boolean check = ApplicationContext.customerRepo.checkUsername(username);
		if(check) {
			System.out.println("This Username is Alrady Exists.");
			return check;
		}
		boolean match = Pattern.matches("^[A-Za-z0-9_-]{3,15}$", username);
		return !match;
	}
	
	public boolean checkAdminUsername(String username) {
		boolean check = ApplicationContext.adminRepo.checkUsername(username);
		if(check) {
			System.out.println("This Username is Alrady Exists.");
			return check;
		}
		boolean match = Pattern.matches("^[a-z0-9_-]{3,15}$", username);
		return !match;
	}
	
	public boolean checkPassword(String password) {
		boolean match = Pattern.matches("^.{8,}$", password);
		return !match;
	}
	
	public boolean checkDate(String date) {
		boolean match = Pattern.matches("^(19|20)\\d\\d(-)(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$", date);
		return !match;
	}
	
	public boolean checkEmailAddress(String email) {
		boolean match = Pattern.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+", email);
		return !match;
	}
	
	public boolean checkPhoneNumber(String Phone) {
		boolean match = Pattern.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$", Phone);
		return !match;
	}
	
	public boolean checkCustomerInformation(String username, String password) {
		return ApplicationContext.customerRepo.checkCustomerInfo(username, password);
	}
	
	public boolean checkAdminInformation(String username, String password) {
		return ApplicationContext.adminRepo.checkAdminInfo(username, password);
	}
}
