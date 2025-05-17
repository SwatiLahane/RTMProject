
@test1
Feature: Validate the Contact Us Scenario of grotech mind baanking application

  Scenario Outline: validate the Contact us scenario of grotech mind banking application
    Given user click on contact us link
    And user enter first name in the name field as name "<name>"
    And user enter email in the email field as "<emailid>"
    And user enter phone number in phone number field as "<phonenumber>"
    And user enter address in the address field as "<address>"
    And user enetr the country in the country field  as "<country>"
    Then user enter pin code in the field of zipcode as "<zipcode>"
    When User Click on submit button of Contact Us Page
    Then Validate that user get success message after clicking on button

    Examples: 
      | name  | emailid         | phonenumber | address | country | zipcode |
      | Harry | Harry@gmail.com |  9876234567 | Mumbai  | india   |  411046 |
