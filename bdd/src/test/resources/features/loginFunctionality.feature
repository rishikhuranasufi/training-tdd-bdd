Feature: Login Functionality Feature
  @Web
  Scenario: As a DevOps Engineer, I want to login to timespoints.com.
    Given User navigates to timespoints.com's login page
      |url                                                                                                                  |
      |https://jsso.indiatimes.com/sso/identity/login?channel=timespoints&ru=https%3A%2F%2Fwww.timespoints.com%2F |
    When User logs in using Username as
      |username             |
      |satpalsahab@gmail.com|
    And User logs in with Password as
      |password |
      |guess@123|
    Then Login should be successful as
      |user|
      |satpalsahab|
    And Home page should be displayed
    And Log out from the application