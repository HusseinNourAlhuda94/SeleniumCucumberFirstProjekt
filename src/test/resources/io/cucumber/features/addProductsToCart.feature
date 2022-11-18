Feature: Add Products to the Cart

  Scenario: Add Products To Shopping Card
    Given user navigate to chrome browser running
    When  user clicks on Books
    And   user adds book to cart
    And   user adds another book to cart
    Then  the selected books will be added to shopping cart