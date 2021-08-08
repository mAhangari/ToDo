package ir.maktab56.ToDo.domain;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer extends User{

	@Column(name = "birthday")
	private Date birthday;
	
	public Customer() {
		super();
	}
	
	public Customer(Long id, Boolean isDeleted, String username, String password, String nationalCode, String firstName,
			String lastName, String email, String mobileNumber, String userType, Boolean isActive, Date birthday) {
		super(id, isDeleted, username, password, nationalCode, firstName, lastName, email, mobileNumber, userType,
				isActive);
		this.setBirthday(birthday);
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String toString() {
		return "Id: " + getId() + ", First Name: " + getFirstName() + ", Last Name: " + getLastName()
				+ "\nUserName: " + getUsername() + ", National Code: " + getNationalCode();
	}
}
