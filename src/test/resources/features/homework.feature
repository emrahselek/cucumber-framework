Feature: Hotel Test

  Background: :
    Given user enter on the caretta hotels webpage
    And user enter username
    And user enter password
    Then user enter login button
    Then user click the Hotel Management icon
    Then user click the Hotel List icon

  @TC01 @Smoke
  Scenario: TC01_ Select and check IDGroup column
    When user select Hotel Type1 from IDGroup column
    And click on Search button
    Then The column should not include Hotel Type2
    When user select Hotel Type2 from IDGroup column
    And click on Search button
    Then The column should not include Hotel Type1
    And click on Clear button
    When The column should include Hotel Type1 and Hotel Type2

  @TC02 @Smoke
  Scenario: TC02_Verify current date
    And Verify the date reflext current date as DD Month YYYY

  @TC03 @Smoke @Regression
  Scenario: TC03_Verify the number of default
#      Given user is on the Hotel List page (var olan test case)
    Then verify the number of default View record is 10
    When user selects 20
    Then verify the number of default View record is 20
    When user clicks clicks on > symbol
    Then verify user goes to the page 2

  Scenario: TC04_Downloaded
#      Given user is on the Hotel List page (var olan test case)
    When user clicks on download button
    Then verify the excel file is downloaded

  Scenario: TC05 Hotel List Page and Display
#      Given user is on the Hotel List page (var olan test case)
    And click on Details of the first hotel
    And verify Edit hotel page is displayed

  Scenario: TC06 Edit Hotel
    Given user is on th Edit hotel Page
    And changes the hotel code
    And verify the success message