Feature: Register Feature Test

  Scenario: Register Test

    Given user navigate to chrome browser running
    When  user clicks on register link
    And   user gives first name
    And   user gives last name
    And   user gives email
    And   user gives Password
    And   user gives confirm password
    And   user clicks on register button
    Then  user should get message your registration completed
    And   user clicks on continue button
    Then  user should be successfully registered

  Scenario: Register Test With Invalid Email Input

    Given user navigate to chrome browser running
    When  user clicks on register link
    And   user gives first name
    And   user gives last name
    And   user gives invalid email format
    And   user gives Password
    Then  user should get massage Wrong email


  Scenario: Register User with Confirmation Of Password That dose Not Match

    Given user navigate to chrome browser running
    When  user clicks on register link
    And   user gives first name
    And   user gives last name
    And   user gives email
    And   user gives Password
    And   user gives a different confirm password
    And   user clicks on register button
    When  user should get a message The password and confirmation password do not match



  Scenario: Register User with existing email

    Given user navigate to chrome browser running
    And   user clicks on register link
    And   user gives first name
    And   user gives last name
    When  user gives existing email
    And   user gives Password
    And   user gives confirm password
    And   user clicks on register button
    Then  user should get message The specified email already exists


