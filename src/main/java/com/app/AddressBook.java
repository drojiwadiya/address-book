package com.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {

	private String addressBookName;
	private Map<String, Contact> contacts = new HashMap<>();

	public AddressBook(String addressBookName) {
		this.addressBookName = addressBookName;
	}

	public void addContact(Contact contact) {
		contacts.put(contact.getName(),  contact);
	}

	public Contact getContact(String contactName) {
		return contacts.get(contactName);
	}

	public String getName() {
		return addressBookName;
	}

	public void deleteContact(String contactName) {
		contacts.remove(contactName);
	}

	public void printContacts() {
		contacts.values().forEach(System.out::println);
	}

	public Collection<Contact> getContacts() {
		return contacts.values();
	}

}
