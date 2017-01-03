package demo.app.demoapp.data.domain;

import java.util.Date;

public class Customer {
	private Integer id;
	private String customerIdentifier;
	private String firstName;
	private String lastName;
	private Date birthDate;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String customerIdentifier, String firstName, String lastName, Date birthDate) {
		super();
		this.id = id;
		this.customerIdentifier = customerIdentifier;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerIdentifier() {
		return customerIdentifier;
	}

	public void setCustomerIdentifier(String customerIdentifier) {
		this.customerIdentifier = customerIdentifier;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerIdentifier=" + customerIdentifier + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
	}

	
	
}
