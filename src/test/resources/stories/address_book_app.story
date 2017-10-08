Address book application

Narrative:
As a Branch Manager
I would like an address book application on my PC
So that I can keep track of my customer contacts

Scenario: Address book will hold name and phone numbers of contact entries & Users should be able to add new contact entries
Given the addressBook with name 'addressBook1'
When I add contact with name 'dinesh' and number '99999999999' 
Then I should see the contact with name 'dinesh' and number '99999999999' in address book 'addressBook1'

Scenario: Users should be able to remove existing contact entries
Given the address book  'addressBook1' with a contact (name : 'dinesh' & phonenumber : '9999999999' ) 
When I remove the given contact from address book 'addressBook1'
Then I should not see the deleted contact in address book 'addressBook1'

Scenario: Users should be able to print all contacts in an address book
Given an address book 'addressBook1'
And with contact1 (name : 'dinesh' & phonenumber : '9999999999' )
And with contact2 (name : 'dinesh1' & phonenumber : '0999999999' )
When I print all contact in an address book 'addressBook1'
Then I should see all the contact in address book printed

Scenario: Users should be able to maintain multiple address books
Given the address book app is running
When I add a first address book with name 'addressBook1' 
When I add a second address book with name 'addressBook2' 
Then I should see the added address books 'addressBook1' 'addressBook2' in app

Scenario: Users should be able to print a unique set of all contacts across multiple address books
Given the first address book  with name 'addressBook1' 
And add contact1 (name : 'dinesh' & phonenumber : '9999999999' ) in first address book 'addressBook1'
And the second address book with name 'addressBook2'
And add contact2 (name : 'test' & phonenumber : '99999666666' ) in second address book 'addressBook2'
And add contact1 (name : 'dinesh' & phonenumber : '9999999999' ) in second address book 'addressBook2'
When I print all unique contact available accross address books
Then I should see all the unique contacts i.e contact1 & contact2 printed