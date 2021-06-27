package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import app.Contact;
import app.ContactService;

class ContactServiceTest {
	
	@Test
	public void testContactServiceAddContact() {
		Contact contact1 = new Contact("123", "John", "Smith", "6039999999", "1 Pleasant St");
		Contact contact2 = new Contact("123", "Jane", "Doe", "6039099999", "2 Pleasant St");
		ContactService cs = new ContactService();
		cs.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			cs.addContact(contact2);
		});
		assertTrue(cs.hasContact(contact1.getId()));
	}

	@Test
	public void testContactServiceDeleteContact() {
		Contact contact1 = new Contact("123", "John", "Smith", "6039999999", "1 Pleasant St");
		Contact contact2 = new Contact("456", "Jane", "Doe", "6039099999", "2 Pleasant St");
		ContactService cs = new ContactService();
		cs.addContact(contact1);
		cs.addContact(contact2);
		cs.deleteContact(contact1.getId());
		assertTrue(!cs.hasContact(contact1.getId()) && cs.hasContact(contact2.getId()));
	}
	
	@Test
	public void testContactServiceUpdateContact() {
		Contact contact1 = new Contact("123", "John", "Smith", "6039999999", "1 Pleasant St");
		ContactService cs = new ContactService();
		cs.addContact(contact1);
		cs.updateFirstName("123", "Jane");
		cs.updateLastName("123", "Doe");
		cs.updatePhone("123", "6039099999");
		cs.updateAddress("123", "2 Pleasant St");
		assertTrue(contact1.getFirstName().equals("Jane"));
		assertTrue(contact1.getLastName().equals("Doe"));
		assertTrue(contact1.getPhone().equals("6039099999"));
		assertTrue(contact1.getAddress().equals("2 Pleasant St"));
	}
}
