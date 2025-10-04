Feature: Validate dashboards

  Background:
    Given user has launched url "https://www.saucedemo.com"

  @smoke @validCredentials
  Scenario: Validate login functionality with valid credentials
    When user entered the credentials
      |userName       |Password       |
      |standard_user  |secret_sauce   |
    And user has clicked on Login button
    Then user verify "Products" on Dashboard
    And close the browser

  @smoke @validCredentials
  Scenario: Validate login functionality with valid credentials 2
    When user entered the credentials
      |userName       |Password       |
      |standard_user  |secret_sauce   |
    And user has clicked on Login button
    Then user verify "Products" on Dashboard
    And close the browser

  @smoke @validCredentials
  Scenario: Validate login functionality with valid credentials 3
    When user entered the credentials
      |userName       |Password       |
      |standard_user  |secret_sauce   |
    And user has clicked on Login button
    Then user verify "Products" on Dashboard
    And close the browser