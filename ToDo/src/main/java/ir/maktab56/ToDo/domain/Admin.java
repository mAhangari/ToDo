package ir.maktab56.ToDo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin extends User{
	
	@Column(name = "is_super_admin", columnDefinition = "TINYINT(1)")
	private Boolean isSuperAdmin;
	
	public Admin() {
		super();
	}
	
	public Admin(Long id, Boolean isDeleted, String username, String password, String nationalCode, String firstName,
			String lastName, String email, String mobileNumber, String userType, Boolean isActive,
			Boolean isSuperAdmin) {
		super(id, isDeleted, username, password, nationalCode, firstName, lastName, email, mobileNumber, userType,
				isActive);
		this.setIsSuperAdmin(isSuperAdmin);
	}

	public Boolean getIsSuperAdmin() {
		return isSuperAdmin;
	}

	public void setIsSuperAdmin(Boolean isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}
	
	public String toString() {
		return "Id: " + getId() + ", First Name: " + getFirstName() + ", Last Name: " + getLastName()
				+ "\nUserName: " + getUsername() + ", National Code: " + getNationalCode();
	}
}
