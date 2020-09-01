Feature: Login To Jira

  @Regression
  Scenario: Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - "OlgaKhobina"
    And I enter password - "OlgaKhobina"
    And I click on the login button
    Then I am on the Home Page

  @Regression @wip
  Scenario: Failed Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - "OlgaKhobina"
    And I enter password - "wrongPassword"
    And I click on the login button
    #And I debug
    Then Error message is displayed