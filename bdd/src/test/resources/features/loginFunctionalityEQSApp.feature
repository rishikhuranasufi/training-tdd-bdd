Feature: Login Functionality Feature
  @Web
  Scenario: As a DevOps Engineer, I want to login to EQS training app.
    Given User navigates to EQS training app login page
      |url                           |
      |http://naughtyano.info/#/login|
    When User sign in using Username as
      |username|
      |rishikhu|
    And User sign in with Password as
      |password |
      |rishikhu|
    Then EQS App Login should be successful as
      |user|
      |Rishi Khurana|
    And EQS App Log out from the application

  @Web
  Scenario: As a DevOps Engineer, I want to login to EQS training app.
    Given User navigates to EQS training app login page
      |url                           |
      |http://naughtyano.info/#/login|
    When User sign in using Username as
      |username|
      |rishikhu|
    And User sign in with Password as
      |password |
      |rishikhu|
    Then EQS App Login should be successful as
      |user|
      |Rishi Khurana|
    And EQS App Log out from the application