@test1
Feature: Validate the Forget Password functionality of grotechmind Banking Application

  Scenario Outline: Validate the Forget Password functionality of grotechmind Banking Application
    Given user open url of banking application
    And user click on forget password link
    And user enter email id as "<email>"
    And user enter mobile number as "<mobilenumber>"
    When user click on reset password button
    Then validate the confirmation message for resetting password
    Then Also verify the title of the page showing proper 
      
    Examples: 
      
      | email           | mobilenumber |
      | swati@gmail.com |  8712354675 |
