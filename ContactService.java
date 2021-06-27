package app;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	
	private Map<String, Contact> contacts;
	
	public ContactService() {
		contacts = new HashMap<String, Contact>();
	}
	
	public boolean hasContact(String id) {
		return contacts.containsKey(id);
	}
	
	public void addContact(Contact contact) {
		if (hasContact(contact.getId()))
			throw new IllegalArgumentException("Contact does not have a unique ID.");
		contacts.put(contact.getId(), contact);
	}
	
	public void deleteContact(String id) {
		contacts.remove(id);
	}
	
	public void updateFirstName(String id, String firstName) {
		if (!hasContact(id))
			throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
		contacts.get(id).setFirstName(firstName);
	}
	
	public void updateLastName(String id, String lastName) {
		if (!hasContact(id))
			throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
		contacts.get(id).setLastName(lastName);
	}
	
	public void updatePhone(String id, String phone) {
		if (!hasContact(id))
			throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
		contacts.get(id).setPhone(phone);
	}
	
	public void updateAddress(String id, String address) {
		if (!hasContact(id))
			throw new IllegalArgumentException("Contact with ID " + id + " does not exist.");
		contacts.get(id).setAddress(address);
	}
}
