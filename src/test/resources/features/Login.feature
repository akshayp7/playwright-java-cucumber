Feature: Login Page feature

  @smoke
  Scenario: Verify User is able to login to Book Store with correct credentials
    Given user navigates to "url"
    When user clicks on "Book Store Application" icon in main page
    And user clicks Login button
    And user enters "adminUsername" username
    And user enters "adminPassword" password
    And user clicks Login button
    Then verify that user is logged in and navigated to Profile page