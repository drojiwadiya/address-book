# address-book

## User Story
```
As a Branch Manager
I would like an address book application on my PC
So that I can keep track of my customer contacts

Acceptance Criteria
o	Address book will hold name and phone numbers of contact entries
o	Users should be able to add new contact entries
o	Users should be able to remove existing contact entries
o	Users should be able to print all contacts in an address book
o	Users should be able to maintain multiple address books
o	Users should be able to print a unique set of all contacts across multiple address books
```
## Built With
* Java 8
* [Maven](https://maven.apache.org/) - Dependency Management
* [JBehave](http://jbehave.org/) - Used for BDD
* [Thucydides](http://www.thucydides.info/) - Used for BDD

## Acceptance tests
* To build the project or run acceptance tests,execute command **mvn clean install** or **mvn verify**
* **view thucydides report** at ~/address-book/target/site/thucydides/index.html
![thucydides_report](https://user-images.githubusercontent.com/12387336/31316150-75c7d214-ac73-11e7-89bc-2bc2bcc49bcb.PNG)
* **view jbehave report** at ~/address-book/target/jbehave/stories.address_book_app.html
![jbehave_report](https://user-images.githubusercontent.com/12387336/31316187-3b841ed6-ac74-11e7-8c5d-efa151a5ab11.PNG)


## Note
Negative scenario's are covered
