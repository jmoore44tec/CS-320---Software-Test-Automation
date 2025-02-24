package contact;

public class Contact {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	private final String id;
	
	public Contact(String firstName, String lastName, String phoneNumber, String address, String id) {
		if(firstName == null || firstName.length()>10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if (lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if(phoneNumber == null || phoneNumber.length()!= 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		if(id == null || id.length()>10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.id = id;
		
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public String getId() {
		return id;
	}

}
