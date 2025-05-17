@Test1
Feature: Validate SignUp Functionality of GrotechMinds Banking Application

  Scenario Outline: Validate signup functionality in GrotechMinds Banking Application
    Given user open the url for banking application
    And user clicks on SignUp button in WebPage
    And user enters the firstname as "<firstname>"
    And user enters the lastname as "<lastname>"
    And user enters the phonenumber as "<phonenumber>"
    And user enters the dateofBirth as "<DOB>"
    And user selects the gender
    And user enters the cityname as "<city>"
    And user enters the userid as "<uid>"
    And user enters the password as "<password>"
    When user clicks on Submit button
    Then validate that user is getting proper response from site
    And also verify that the Title of the page is showing correct value 
   

    Examples: 
      | firstname | lastname | phonenumber | DOB        | city    | uid    | password  |
      | Harry     | dsouza   |  9088786654 | 05-05-2007 | Kolkata | 137846 | Test@1234 |
