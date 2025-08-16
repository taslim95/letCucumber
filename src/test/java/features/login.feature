Feature: Bookcat Application tests

  Scenario: Login should be success #positive scenario--1
    Given User navigate to the Bookcart application
    And User clicks on the login button
    And user enter the username as "ortoni"
    And user enter the password as "Pass1234"
    When user click on the login button
    Then Login should be success

  Scenario: Login should not be success #negative Scenario--2
    Given User navigate to the Bookcart application
    And User clicks on the login button
    And user enter the username as "taslim"
    And user enter the password as "wrongpassword"
    When user click on the login button
    But Login should fail
 