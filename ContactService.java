package contact;

import java.util.*;

public class ContactService {
	private final HashMap<String, Contact> contacts;

	public ContactService() { // hash map to store contacts
		this.contacts = new HashMap<>();
	}
	
	public void addContact(Contact contact) { // adding a contact
		if(contacts.containsKey(contact.getId())) {
			throw new IllegalArgumentException("Contact ID already exists, try again.");			
		}
		contacts.put(contact.getId(), contact);
	}
	
	public Contact getContactById(String contactId) { // "get" contact based on ID
		if(!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found.");
		}
		return contacts.get(contactId);
	}
	
	
	public void updateFirstName(String contactId, String firstName) { // change first name based on ID
		Contact contact = getContactById(contactId);
		if(firstName == null || firstName.length()>10 ) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		contact = new Contact(firstName, contact.getLastName(), contact.getPhoneNumber(), contact.getAddress(), contact.getId());
		contacts.put(contactId,  contact);
	}
	
	public void updateLastName(String contactId, String lastName) {	// change last name based on ID
		Contact contact = getContactById(contactId);
		if(lastName == null || lastName.length()>10) {
			throw new IllegalArgumentException("Invalid Last Name, must contain 1-10 characters.");
		}
		contact = new Contact(contact.getFirstName(), lastName, contact.getPhoneNumber(), contact.getAddress(), contact.getId());
		contacts.put(contactId,  contact);
	}
	
	public void updatePhoneNumber(String contactId, String phoneNumber) { // change phone number based on ID
		Contact contact = getContactById(contactId);
		if(phoneNumber == null || phoneNumber.length()!=10) {
			throw new IllegalArgumentException("Invalid Phone Number");			
		}
		contact = new Contact(contact.getFirstName(), contact.getLastName(), phoneNumber, contact.getAddress(), contact.getId());
		contacts.put(contactId, contact);
	}
	
	public void updateAddress(String contactId, String address) { // change address based on ID
		Contact contact = getContactById(contactId);
		if(address == null || address.length()>30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		contact = new Contact(contact.getFirstName(), contact.getLastName(), contact.getPhoneNumber(), address, contact.getId());
		contacts.put(contactId,  contact);
	}
	
	public void deleteContact(String contactId) { // delete a contact based on ID
		if(!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found.");			
		}
		contacts.remove(contactId);
	}
}
