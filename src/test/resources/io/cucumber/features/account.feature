Feature: Account Page Feature

  Background:
    Given User has already logged in to Application
      |email|password|
      |HusseinNour20@gmail.com|123456|


  Scenario: Log Out Functionality Test
    Given user is on account page
    When  user hits the Log out button
    Then  user should be logged out



  Scenario: Subscribe For Newsletters Functionality Test
    Given user is on account page
    When  user enters an email address in the Subscribe field
    And   user hits the Subscribe button for newsletters
    Then  user should be subscribed and get message Thank you for signing up!



  Scenario: Make sure the above menu bar exists

    Given user is on account page
    And "BOOKS" is visible
    And "COMPUTERS" is visible
    And "ELECTRONICS" is visible
    And "APPAREL & SHOES" is visible
    And "DIGITAL DOWNLOADS" is visible
    And "JEWELRY" is visible
    And "GIFT CARDS" is visible



  Scenario: User Want To Add A Gift Card To The Wish List and remove it

    Given  user is on account page
    When   user moves to gift card in the bar menu
    And    user select a card
    And    user should give Recipient's Name and email
    And    user click on button add to wishlist
    And    selected card is added to wishlist successfully
    And    user moves to wishlist
    When   user select product to remove
    And    user hit update wishlist button
    Then   selected product should be removed

  Scenario: User want to find Product using the search field and add it to Shopping Cart

    Given  user is on account page
    When   user give product name in search field
    And    user hits search button
    And    user select the product
    And    user add the product to the cart
    Then   product should be added to shopping cart


