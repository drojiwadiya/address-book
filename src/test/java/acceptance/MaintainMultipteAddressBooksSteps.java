package acceptance;

import static org.junit.Assert.assertNotNull;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.app.AddressBook;
import com.app.User;

public class MaintainMultipteAddressBooksSteps {
	private User user;
	
	@Given("the address book app is running")
	public void givenTheAddressBookAppIsRunning() {
		user = new User();
	}

	@When("I add a first address book with name '$addressBookName'")
	public void whenIAddAAddressBook1(String addressBookName) {
		user.addAddressBook( new AddressBook(addressBookName));
	}
	
	@When("I add a second address book with name '$addressBookName'")
	public void whenIAddAAddressBook2(String addressBookName) {
		user.addAddressBook( new AddressBook(addressBookName));
	}
	

	@Then("I should see the added address books '$addressBookName1' '$addressBookName2' in app")
	public void thenIShouldSeeTheAddedAddressBooksInApp(String addressBookName1, String addressBookName2) {
		
		assertNotNull(user.getAddressBook(addressBookName1));
		assertNotNull(user.getAddressBook(addressBookName2));
	}
	
}
