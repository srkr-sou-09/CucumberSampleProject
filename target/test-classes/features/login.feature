Feature: As a user of application I want to validate login functionality

  Background:
    Given user has launched url "https://www.saucedemo.com"

  @smoke @mainTestCase @validCredentials
  Scenario: Validate login functionality with valid credentials
    When user entered the credentials
      |userName       |Password       |
      |standard_user  |secret_sauce   |
    And user has clicked on Login button
    Then user verify "Products" on Dashboard
    And close the browser

  @validCredentials
  Scenario: Validate login functionality with valid credentials
    When user entered username "visual_user" and password "secret_sauce"
    And user has clicked on Login button
    Then user verify "Products" on Dashboard
    And close the browser

  Scenario: Validate login functionality with invalid credentials
    When user entered the credentials
      |userName       |Password       |
      |standard_user  |secret_sauce   |
      |visual_user    |secret_sauce   |
    And user has clicked on Login button
    Then user verify "Products" on Dashboard
    And close the browser

  @validCredentials
  Scenario Outline: Validate login functionality with valid credentials
    When user entered username "<UserName>" and password "<Password>"
    And user has clicked on Login button
    Then user verify "Products" on Dashboard
    And close the browser

    Examples:
      |UserName       |Password       |
      |standard_user  |secret_sauce   |


