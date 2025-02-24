package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    @Test
    void testContactAdd() {
        Contact contact = new Contact("Jesse", "Moore", "9995555555", "Somewhere Currently", "0001");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContactById("0001"));
    }

    @Test
    void testDuplicateId() {
        Contact contact1 = new Contact("Jesse", "Moore", "9999999999", "Sparks", "0002");
        Contact contact2 = new Contact("Kristin", "Moore", "8889999999", "Sparks", "0002");
        contactService.addContact(contact1);

        try {
            contactService.addContact(contact2);
            fail("Expected IllegalArgumentException was not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Contact ID already exists, try again.", e.getMessage());
        }
    }

    @Test
    public void testDeleteContactSuccess() {
        Contact contact = new Contact("Jesse", "Moore", "9995555555", "Some place cold", "0001");
        contactService.addContact(contact);
        contactService.deleteContact("0001");

        try {
            contactService.getContactById("0001");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Contact ID not found.", e.getMessage());
        }
    }

    @Test
    public void testUpdateFirstNameSuccess() {
        Contact contact = new Contact("Jesse", "Moore", "9995555555", "Some place cold", "0001");
        contactService.addContact(contact);
        contactService.updateFirstName("0001", "Johnny");
        assertEquals("Johnny", contactService.getContactById("0001").getFirstName());
    }

    @Test
    public void testUpdateFirstNameInvalid() {
        Contact contact = new Contact("Jesse", "Moore", "9995555555", "Some place cold", "0001");
        contactService.addContact(contact);

        try {
            contactService.updateFirstName("0001", null);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid First Name", e.getMessage());
        }
    }

    @Test
    public void testUpdatePhoneNumberSuccess() {
        Contact contact = new Contact("Jesse", "Moore", "9995555555", "Some place cold", "0001");
        contactService.addContact(contact);
        contactService.updatePhoneNumber("0001", "0987654321");
        assertEquals("0987654321", contactService.getContactById("0001").getPhoneNumber());
    }

    @Test
    public void testUpdatePhoneNumberInvalid() {
        Contact contact = new Contact("Jesse", "Moore", "9995555555", "Some place cold", "0001");
        contactService.addContact(contact);

        try {
            contactService.updatePhoneNumber("0001", "123");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Phone Number", e.getMessage());
        }
    }

    @Test
    public void testUpdateAddressSuccess() {
        Contact contact = new Contact("Jesse", "Moore", "9995555555", "Some place cold", "0001");
        contactService.addContact(contact);
        contactService.updateAddress("0001", "Slightly Warmer Place");
        assertEquals("Slightly Warmer Place", contactService.getContactById("0001").getAddress());
    }

    @Test
    public void testUpdateAddressInvalid() {
        Contact contact = new Contact("Jesse", "Moore", "9995555555", "Some place cold", "0001");
        contactService.addContact(contact);

        try {
            contactService.updateAddress("0001", null);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Address", e.getMessage());
        }
    }

    @Test
    public void testGetContactByIdNotFound() {
        try {
            contactService.getContactById("0001");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Contact ID not found.", e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        contactService = null;
    }
}