package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import app.Contact;

class ContactTest {
	
	private String defaultID = "1234567890";
	private String defaultFirstName = "John";
	private String defaultLastName = "Smith";
	private String defaultPhone = "6039999999";
	private String defaultAddress = "1 Pleasant St";
	
	@Test
	public void testContact() {
		Contact contact = new Contact(defaultID, defaultFirstName, defaultLastName, defaultPhone, defaultAddress);
		assertTrue(contact.getId().equals(defaultID));
		assertTrue(contact.getFirstName().equals(defaultFirstName));
		assertTrue(contact.getLastName().equals(defaultLastName));
		assertTrue(contact.getPhone().equals(defaultPhone));
		assertTrue(contact.getAddress().equals(defaultAddress));
	}

	@Test
	public void testContactIDTooLongOrNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", defaultFirstName, defaultLastName, defaultPhone, defaultAddress);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, defaultFirstName, defaultLastName, defaultPhone, defaultAddress);
		});
	}
	
	@Test
	public void testContactFirstNameTooLongOrNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, "Christopher", defaultLastName, defaultPhone, defaultAddress);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, null, defaultLastName, defaultPhone, defaultAddress);
		});
	}
	
	@Test
	public void testContactLastNameTooLongOrNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, defaultFirstName, "Bartholomew", defaultPhone, defaultAddress);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, defaultFirstName, null, defaultPhone, defaultAddress);
		});
	}
	
	@Test
	public void testContactPhoneWrongLengthOrNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, defaultFirstName, defaultLastName, "5419999", defaultAddress);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, defaultFirstName, defaultLastName, "16039999999", defaultAddress);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, defaultFirstName, defaultLastName, null, defaultAddress);
		});
	}
	
	@Test
	public void testContactAddressTooLongOrNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, defaultFirstName, defaultLastName, defaultPhone, "1 Pleasant St, Manchester NH, 03102, United States");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(defaultID, defaultFirstName, defaultLastName, defaultPhone, null);
		});
	}
}
