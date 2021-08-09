package ir.maktab56.ToDo.domain;

import java.sql.Date;
import javax.persistence.*;

import ir.maktab56.ToDo.domain.enumeration.UserType;

@Entity
@Table(name = "customer")
public class Customer extends User{

	@Column(name = "birthday")
	private Date birthday;
	
	@OneToOne(mappedBy = "customer")
	private Wallet wallet;
	
	public Customer() {
		super();
	}
	
	public Customer(Boolean isDeleted, String username, String password, String nationalCode, String firstName,
			String lastName, String email, String mobileNumber, UserType userType, Boolean isActive, Date birthday) {
		super(isDeleted, username, password, nationalCode, firstName, lastName, email, mobileNumber, userType,
				isActive);
		this.setBirthday(birthday);
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public String toString() {
		return "Id: " + getId() + ", First Name: " + getFirstName() + ", Last Name: " + getLastName()
				+ "\nUserName: " + getUsername() + ", National Code: " + getNationalCode();
	}
}
