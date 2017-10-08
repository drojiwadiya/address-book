package acceptance;

import static org.junit.Assert.assertTrue;

import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.app.AddressBook;
import com.app.Contact;
import com.app.User;

public class AddContactEntrySteps {
	private User user;
    private AddressBook addressBook;
    private Contact contact;
    
    @Given("the addressBook with name '$name'")
    @Aliases(values={"a address book app with $name"})
    public void theAddressBookAppIsRunning(String addressBookName) {
    	user = new User();
    	this.addressBook = new AddressBook(addressBookName);
    	user.addAddressBook(this.addressBook);
    }
    
    @When("I add contact with name '$name' and number '$phoneNumber'")
    public void iToggleTheCellAt(String name, String phoneNumber) {
    	contact = new Contact(name, phoneNumber);
		user.addContact(addressBook.getName(), contact);
    }
     
    @Then("I should see the contact with name '$contactName' and number '$contactNumber' in address book '$addressBookName'")
    public void theGridShouldLookLike(String contactName, String contactNumber, String  addressBookName) {
        assertTrue(user.getAddressBook(addressBookName).getContacts().contains(new Contact(contactName, contactNumber)));
    }
}
