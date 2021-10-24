@google_search
Feature: Google Search Functionality

#    Describe the behaviour
#    Given should be used as a preconditions.Usually Given is used in the first Step
#    Then should be used for verification.Usually it is used at the end
#    And and When is used in teh middle steps to describe actions

  Scenario: TC01_iPhone search

    Given user is on the google page
    And user search for iPhone
    When verify the result has iPhone
    Then close the application
    And see my name on the console


  Scenario: TC02_teapot search
    Given user is on the google page
    And user search for tea pot
    Then verify the result has tea pot
    Then close the application

  Scenario: TC03_flower search
    Given user is on the google page
    And user search for flower
    Then verify the result has flower
    Then close the application

  Scenario: TC04_tesla search
    Given user is on the google page
    And user search for tesla
    Then verify the result has tesla
    Then close the application