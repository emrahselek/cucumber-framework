#When user search for the following capitals: London, Paris, Vienna, Berlin, Madrid
#Then verify the the result includes the the searched values
#FF: scenario_outline_2.feature

@scenario_outline_google_search
Feature: Search for the capitals

  Scenario Outline:
    Given user is on the google page
    And user search for "<capitals>"
    Then verify the result has "<capitals>"
    Then close the application


    Examples: Test Data
      | capitals |
      | London   |
      | Paris    |
      | Vienna   |
      | Berlin   |
      | Madrid   |