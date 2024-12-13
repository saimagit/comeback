
@tag
Feature: F001: Account creation in Walmart Canada 
  I want to create account in Walmart Canada using my email id so that I am able to log in using my email

 
  Scenario Outline: TC001 User is able to create account on Walmart Canada using email address
    Given I am on walmart CA home page.
    And I have a valid email id <email_id >
    When I click on Sign in Account
    Then sign in or Create new account is displayed on a pop up
    When I click on Sign in or create new account
    Then page is navigated to the sign in or create new account screen
    When I enter a valid email id
    And I click on Continue button
    Then page is navigated to the Create your Walmart account screen
    And email id is displayed.
    When I enter valid first name <firstName>
    And I enter valid sur name <surName>
    And I enter valid password <password>
    And I click on Create Account button
    Then a success message is displayed "Your account is created!"


    Examples: 
      | email_id              | firstName  | surName   | password | 
      | john1.smith@gmail.com |  Daria1    | Joseph1   | Keep@123 | 
    # | john2.smith@gmail.com |  Daria2    | Joseph2   | Keep@123 |
    # | john3.smith@gmail.com |  Daria3    | Joseph3   | Keep@123 |

    
  Scenario Outline: TC003 Error message is shown when user enters invalid email format during account creation
    Given I am on walmart CA home page.
    When I click on Sign in Account
    Then sign in or Create new account is displayed on a pop up
    When I click on Sign in or create new account
    Then page is navigated to the sign in or create new account screen
    When I enter a valid email id <email_id>
    And I click on Continue button
    Then a success message is displayed "Please enter a valid email address."


    Examples: 
      | email_id     |
      | john1!!.COM@ |
