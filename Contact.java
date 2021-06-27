package app;

public class Contact {

	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String id, String firstName, String lastName, String phone, String address) {
		if (id == null)
			throw new IllegalArgumentException("Contact ID cannot be null.");
		if (id.length() > 10)
			throw new IllegalArgumentException("Contact ID cannot exceed 10 characters.");
		this.id = id;
		
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	public String getId() {
		return id;
	}
	
	public void setFirstName(String firstName) {
		if (firstName == null)
			throw new IllegalArgumentException("First name cannot be null.");
		if (firstName.length() > 10)
			throw new IllegalArgumentException("First name cannot exceed 10 characters.");
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		if (lastName == null)
			throw new IllegalArgumentException("Last name cannot be null.");
		if (lastName.length() > 10)
			throw new IllegalArgumentException("Last name cannot exceed 10 characters.");
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setPhone(String phone) {
		if (phone == null)
			throw new IllegalArgumentException("Phone number cannot be null.");
		if (phone.length() != 10)
			throw new IllegalArgumentException("Phone number must be 10 digits.");
		this.phone = phone;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setAddress(String address) {
		if (address == null)
			throw new IllegalArgumentException("Address cannot be null.");
		if (address.length() > 30)
			throw new IllegalArgumentException("Address cannot exceed 30 characters.");
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
}
