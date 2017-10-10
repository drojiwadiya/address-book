package com.app;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class User {
	
	private Map<String, AddressBook> addressBooks = new HashMap<>();
	
	public void addAddressBook(String addressBookName) {
		addressBooks.put(addressBookName, new AddressBook(addressBookName));
	}

	public void addAddressBook(AddressBook addressBook) {
		addressBooks.put(addressBook.getName(), addressBook);
	}
	
	public AddressBook getAddressBook(String addressBookName) {
		return addressBooks.get(addressBookName);
	}

	public void deleteAddressBook(String addressBookName) {
		 addressBooks.remove(addressBookName);
	}

	public void addContact(String addressBookName, Contact contact) {
		 AddressBook addressBook = getAddressBook(addressBookName);
		 addressBook.addContact(contact);
	}

	public void deleteContact(String addressBookName, String contactName) {
		AddressBook addressBook = getAddressBook(addressBookName);
		addressBook.deleteContact(contactName);
	}

	public void printContacts(String addressBookName) {
		AddressBook addressBook = getAddressBook(addressBookName);
		addressBook.printContacts();
	}

	public void printAllUniqueContacts() {
		addressBooks.values().stream()
		.map(addressBook -> addressBook.getContacts())
		.flatMap(contacts -> contacts.stream())
		.collect(Collectors.toSet()).forEach(System.out::println);
	}
	
}
