package acceptance;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.app.AddressBook;
import com.app.Contact;
import com.app.User;

public class DeleteContactEntrySteps {
	private User user;
	private AddressBook addressBook;
	private Contact contact;

	@Given("the address book  '$addressBookName' with a contact (name : '$contactName' & phonenumber : '$phoneNumber' )")
	public void givenTheAddressBookWithAContact(String addressBookName,
			String contactName, String phoneNumber) {
		user = new User();
		this.addressBook = new AddressBook(addressBookName);
		user.addAddressBook(addressBook);
		contact = new Contact(contactName, phoneNumber);
		user.addContact(addressBook.getName(), contact);
	}

	@When("I remove the given contact from address book '$addressBookName'")
	public void whenIRemoveAContactFromAddressBook(String addressBookName) {
		user.deleteContact(addressBookName, contact.getName());
	}

	@Then("I should not see the deleted contact in address book '$addressBookName'")
	public void thenIShouldNotSeeTheContactInAddressBook(String addressBookName) {
		assertTrue(!user.getAddressBook(addressBookName).getContacts()
				.contains(contact));
	}
}
