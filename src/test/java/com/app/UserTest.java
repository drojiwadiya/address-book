package com.app;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.mockito.Mockito;

import com.google.common.collect.Sets;

public class UserTest {
	
	private User user;
	
	private final Contact contact1 = new Contact("contact1", "9999999999");
	
	@Test
	public void testAddAddressBook() {
		user = new User();
		user.addAddressBook("test");
		AddressBook addressBook = user.getAddressBook("test");
		assertNotNull(addressBook);
		
		user = new User();
		user.addAddressBook(new AddressBook("test"));
		addressBook = user.getAddressBook("test");
		assertNotNull(addressBook);
	}

	@Test
	public void testDeleteAddressBook() {
		user = new User();
		user.deleteAddressBook("test");
		
		AddressBook addressBook = user.getAddressBook("test");
		assertNull(addressBook);
	}
	
	@Test
	public void testAddContact() {
		user = new User();
		AddressBook mockedAddressBook = mock(AddressBook.class);
		when(mockedAddressBook.getName()).thenReturn("test");
		
		user.addAddressBook(mockedAddressBook);
		user.addContact("test", contact1);
		Mockito.verify(mockedAddressBook, Mockito.times(1)).addContact(contact1);
	}
	
	@Test
	public void testDeleteContact() {
		user = new User();
		AddressBook mockedAddressBook = mock(AddressBook.class);
		when(mockedAddressBook.getName()).thenReturn("test");
		
		user.addAddressBook(mockedAddressBook);
		user.deleteContact("test", "contact1");
		
		Mockito.verify(mockedAddressBook, Mockito.times(1)).deleteContact("contact1");
	}
	
	@Test
	public void testPrintContacts() {
		user = new User();
		AddressBook mockedAddressBook = mock(AddressBook.class);
		when(mockedAddressBook.getName()).thenReturn("test");
		
		user.addAddressBook(mockedAddressBook);
		user.addContact("test", contact1);
		user.printContacts("test");
		
		Mockito.verify(mockedAddressBook, Mockito.times(1)).printContacts();
	}
	
	@Test
	public void testPrintAllUniqueContacts() {
		user = new User();
		
		AddressBook mockedAddressBook1 = mock(AddressBook.class);
		when(mockedAddressBook1.getName()).thenReturn("test1");
		Contact contact1 = new Contact("con1","2222");
		when(mockedAddressBook1.getContacts())
			.thenReturn(Sets.newHashSet(contact1));
		Contact contact2 = new Contact("con2","2222");
		when(mockedAddressBook1.getContacts())
		.thenReturn(Sets.newHashSet(contact2));
		
		AddressBook mockedAddressBook2 = mock(AddressBook.class);
		when(mockedAddressBook2.getName()).thenReturn("test2");
		when(mockedAddressBook2.getContacts())
		.thenReturn(Sets.newHashSet(contact1));
		
		user.addAddressBook(mockedAddressBook1);
		user.addAddressBook(mockedAddressBook2);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
		
	    user.printAllUniqueContacts();
		
	    String original = outContent.toString();
		assertTrue(StringUtils.countMatches(original, contact1.toString()) == 1);
		assertTrue(StringUtils.countMatches(original, contact2.toString()) == 1);
	}
}
