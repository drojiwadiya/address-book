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

public class PrintUniqueContactsFromAddressBooksSteps {
	private User user;
	private Contact contact1;
	private Contact contact2;
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Given("the first address book  with name '$addressBookName'")
	public void givenTheFirstAddressBook(String addressBookName) {
		user = new User();
		user.addAddressBook(new AddressBook(addressBookName));
	}
	
	@Given("add contact1 (name : '$contactName' & phonenumber : '$phoneNumber' ) in first address book '$addressBookName'")
	public void givenAddContact1InAddressBook1(String contactName, String phoneNumber, String addressBookName) {
		contact1 = new Contact(contactName, phoneNumber);
		user.addContact(addressBookName, contact1);
	}
	
	@Given("the second address book with name '$addressBookName'")
	public void givenTheSecondAddressBook(String addressBookName) {
		user.addAddressBook(new AddressBook(addressBookName));
	}
	
	@Given("add contact2 (name : '$contactName' & phonenumber : '$phoneNumber' ) in second address book '$addressBookName'")
	public void givenAddContact2InAddressBook2(String contactName, String phoneNumber, String addressBookName) {
		contact2 = new Contact(contactName, phoneNumber);
		user.addContact(addressBookName, contact2);
	}
	
	@Given("add contact1 (name : '$contactName' & phonenumber : '$phoneNumber' ) in second address book '$addressBookName'")
	public void givenAddContact1InAddressBook2(String contactName, String phoneNumber, String addressBookName) {
		contact1 = new Contact(contactName, phoneNumber);
		user.addContact(addressBookName, contact1);
	}
	
	@When("I print all unique contact available accross address books")
	public void whenIPrintAllUniqueContactTheAvailableAccrossAddressbooks() {
	    System.setOut(new PrintStream(outContent));
	    user.printAllUniqueContacts();
	}

	@Then("I should see all the unique contacts i.e contact1 & contact2 printed")
	public void thenIShouldSeeAllTheContactInAddressBookPrinted() {
		String original = outContent.toString();
		assertTrue(StringUtils.countMatches(original, contact1.toString()) == 1);
		assertTrue(StringUtils.countMatches(original, contact2.toString()) == 1);
	}
}
