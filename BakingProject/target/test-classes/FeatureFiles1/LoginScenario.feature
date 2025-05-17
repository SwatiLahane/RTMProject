
@Test1
Feature: Validate the login Functionality of grotechmind Banking Domain Project

  Scenario Outline: Validate the login Functionality of grotechmind Banking Domain Project
    Given user open url of banking application
    And user click on login button
    And user enter username as "<uid>"
    And user enter password as "<password>"
    When user click on submit button
   # Then Validate that user able to login successfully
   # Then also verify that the Title of the Login page is shown proper

    Examples: 
      | uid       | password  |
      | Swati@123 | Test@1234 |
