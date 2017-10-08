package com.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class AddressBookTest {

	private AddressBook addressBook;
	
	private final Contact contact1 = new Contact("contact1", "9999999999");
	
	@Test
	public void testAddContact() {
		addressBook = new AddressBook("addressBook1");
		addressBook.addContact(contact1);
		
		Contact contact = addressBook.getContact(contact1.getName());
		assertTrue(contact1.equals(contact));
	}

	@Test
	public void testDeleteContact() {
		addressBook = new AddressBook("addressBook1");
		addressBook.addContact(contact1);
		addressBook.deleteContact(contact1.getName());
		
		Contact contact = addressBook.getContact(contact1.getName());
		assertNull(contact);
	}
	
	@Test
	public void testPrintContacts() {
		addressBook = new AddressBook("addressBook1");
		addressBook.addContact(contact1);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
		addressBook.printContacts();
		
		String original = outContent.toString();
		assertTrue(StringUtils.countMatches(original, contact1.toString()) == 1);
	}

}
