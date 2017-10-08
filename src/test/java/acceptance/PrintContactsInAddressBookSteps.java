package acceptance;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.apache.commons.lang.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.app.AddressBook;
import com.app.Contact;
import com.app.User;

public class PrintContactsInAddressBookSteps {
	private User user;
	private AddressBook addressBook;
	private Contact contact1;
	private Contact contact2;
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Given("the address book  '$addressBookName' with a contact (name : '$contactName' & phonenumber : '$phoneNumber' )")
	public void givenTheAddressBookWithAContact(String addressBookName,
			String contactName, String phoneNumber) {
		user = new User();
		this.addressBook = new AddressBook(addressBookName);
		user.addAddressBook(addressBook);
	}

	@Given("an address book '$addressBookName'")
	public void givenAnAddressBook(String addressBookName) {
		user = new User();
		this.addressBook = new AddressBook(addressBookName);
		user.addAddressBook(addressBook);
	}
	
	@Given("with contact1 (name : '$contactName' & phonenumber : '$phoneNumber' )")
	public void givenAContact1(String contactName, String phoneNumber) {
		contact1 = new Contact(contactName, phoneNumber);
		user.addContact(addressBook.getName(), contact1);
	}
	
	@Given("with contact2 (name : '$contactName' & phonenumber : '$phoneNumber' )")
	public void givenAContact2(String contactName, String phoneNumber) {
		contact2 = new Contact(contactName, phoneNumber);
		user.addContact(addressBook.getName(), contact2);
	}
	
	@When("I print all contact in an address book '$addressBookName'")
	public void whenIPrintAllContactInAnAddressBookaddressBook1(String addressBookName) {
		
	    System.setOut(new PrintStream(outContent));
	    user.printContacts(addressBookName);
	}

	@Then("I should see all the contact in address book printed")
	public void thenIShouldSeeAllTheContactInAddressBookPrinted() {
		String original = outContent.toString();
		assertTrue(StringUtils.countMatches(original, contact1.toString()) == 1);
		assertTrue(StringUtils.countMatches(original, contact2.toString()) == 1);
	}
}
