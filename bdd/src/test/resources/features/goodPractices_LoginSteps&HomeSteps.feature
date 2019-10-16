
# Example 1 - Msg 1 - handling multiple set of data with RegEx

  # Example 2 - Handling dynamic data with Datatables


Feature: Login to timespoints
#Data testing with multiple set of data. we can test with different pwd for example to fail the TC
  Scenario Outline: As a DevOps Engineer, I want to login to timespoints.com.
    Given User navigates to application and login with username "<username>" and password "<password>"
    Then Home page should be displayed.
    And Log out from the application
    Examples:
      |username               |password |
      |satpalsahab@gmail.com  |guess@123|
      |mayuri720@yahoo.com    |googlemind@420|