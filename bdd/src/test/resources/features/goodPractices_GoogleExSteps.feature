# BAD EXAMPLE!
  #Scenario: Search from the search bar
    #Given a web browser is at the Google home page
    #When User Enter "lion" to google search.
    #Add User clicks on "Google Search"
    #Or User clicks on "I'm Feeling Lucky"
    #Then links related to "lion" are shown on the results page

  # msg 1 - Dynamic values at runtime - Line 19 and 21 we should replace values
  # msg 2 - OR will not work. We need to create 2 scenarios
  # msg 3 - why background is important

Feature: Google Searching

  Background:
    Given a web browser is at the Google home page

  Scenario: Search from the search bar
    When User Enter lion to google search
    And User clicks "Google Search"
    Then Details related to lion are shown on the next page

  Scenario: Search from the search bar
    When User Enter lion to google search
    And User clicks "I'm Feeling Lucky"
    Then Details related to lion are shown on the next page
