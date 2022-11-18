Feature: Log In Test Feature

  Scenario Outline: Login User With Correct Email and Password
    Given   user navigate to chrome browser running
    When    user hit on login link
    And     user enters email as "<email>"
    And     user enters password as "<password>"
    And     user click on log in button
    Then    login should be successful

    Examples:
      | email                | password |
      | HusseinNour20@gmail.com | 123456   |

  Scenario Outline: Login User With Incorrect Email and Password
    Given   user navigate to chrome browser running
    When    user hit on login link
    And     user enters email as "<email>"
    And     user enters password as "<password>"
    And     user click on log in button
    Then    login should be unsuccessful

    Examples:
      | email                   | password |
      | HusseinNour82453@gmail.com | 123456   |

