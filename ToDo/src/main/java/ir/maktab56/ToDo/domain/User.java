package ir.maktab56.ToDo.domain;

import java.util.*;
import javax.persistence.*;
import ir.maktab56.ToDo.base.domain.BaseEntity;
import ir.maktab56.ToDo.domain.enumeration.UserType;

@MappedSuperclass
public class User extends BaseEntity<Long>{
	
	@Column(length = 50, unique = true)
	private String username;
	
	@Column(length = 20)
    private String password;
	
	@Column(name = "national_code", length = 15, unique = true)
    private String nationalCode;
	
	@Column(name = "first_name", length = 50)
    private String firstName;
	
	@Column(name = "last_name", length = 50)
    private String lastName;
	
	@Column(name = "email_address", unique = true)
    private String email;
	
	@Column(name = "mobile_number")
    private String mobileNumber;
	
	@Column(name = "user_type")
    private UserType userType;
	
	@Column(name = "is_active", columnDefinition = "TINYINT(1)")
    private Boolean isActive;
	
	@OneToMany(mappedBy = "customer")
	private List<Activity> avtivities = new ArrayList<>();
    
	public User() {
		super();
	}
	
    public User(Boolean isDeleted, String username, String password, String nationalCode, String firstName,
			String lastName, String email, String mobileNumber, UserType userType, Boolean isActive) {
		super(isDeleted);
		this.setUsername(username);
		this.setPassword(password);
		this.setNationalCode(nationalCode);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmail(email);
		this.setMobileNumber(mobileNumber);
		this.setUserType(userType);
		this.setActive(isActive);
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

	public List<Activity> getAvtivities() {
		return avtivities;
	}

	public void setAvtivities(List<Activity> avtivities) {
		this.avtivities = avtivities;
	}
}