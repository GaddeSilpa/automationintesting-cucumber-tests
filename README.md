### Table of Contents
* Project Overview

* Technologies Used

* Setup & Installation

* How to Run Tests

* Notes

### Project Overview

This framework automates the testing of the Automation in Testing demo website’s core functionalities such as:

* Booking creation for different room types (Single, Double, Suite) with date validation.

* Contact form submission with validation for positive and negative scenarios.

* Location page navigation and verification.

* Admin page login verification with sample credentials.

It uses BDD approach with Cucumber feature files and step definitions, and follows the Page Object Model design pattern for maintainable code.

### Technologies Used
* Java 11+

* Selenium WebDriver

* Cucumber BDD

* Maven for build and dependency management

* TestNG as test runner

* Page Object Model pattern

* Git for version control

### Setup & Installation

* Clone the repo:
  
```
git clone https://github.com/GaddeSilpa/automationintesting-cucumber-tests.git

cd automationintesting-cucumber-tests
```
* Ensure Java and Maven are installed and configured in your PATH.
* Build the project and download dependencies:

```
mvn clean install
```
### How to Run Tests
Run all tests using Maven:

```
mvn test
```
Or run individual feature files/scenarios using your IDE’s Cucumber.

### Notes
* Page Object Model design pattern is followed to maintain clean and reusable code.

* Cucumber scenario outlines and examples are used for data-driven testing.

* Date validation messages are checked in booking success confirmations.

* You can add more tests and enhance the framework with parallel execution and reporting.
