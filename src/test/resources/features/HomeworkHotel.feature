Feature: Hotel Test
  Background: :
    Given user enter on the caretta hotels webpage
    And user enter username
    And user enter password
    Then user enter login button
    Then user click the Hotel Management icon
    Then user click the Hotel List icon

  @TC01
  Scenario: TC01_Select and check IDGroup column
    When user select Hotel Type1 from IDGroup column
    And click on Search button
    Then The column should not include Hotel Type2
    When user select Hotel Type2 from IDGroup column
    And click on Search button
    Then The column should not include Hotel Type1
    When click on Clear button
    Then The column should include Hotel Type1 and Hotel Type2


  @TC02
  Scenario: TC02_Verify current date
    And Verify the date reflext current date as DD Month YYYY


  @TC03
  Scenario: TC03_Verify the number of default
    Then verify the number of default View record is 10
    When user selects 20
    Then verify the number of default View record is 20
    When user clicks clicks on > symbol
    Then verify user goes to the page 2

  Scenario: TC04_Downloaded
    Given user clicks on download button
    Then verify the excel file is donwload


