Feature: Login To Jira

  @Regression
  Scenario: Login to Jira
    Given I navigate to Jira Login Page
    And I enter username as "OlgaKhobina"
    And I enter password as "OlgaKhobina"
    And I click on the login button
    Then I am on the Home Page

  @Regression
  Scenario Outline: Failed Logins to Jira
    Given I navigate to Jira Login Page
    And I enter username as <username>
    And I enter password as <password>
    And I click on the login button
    #And I debug
    Then Error message is displayed

    Examples:
      | username        | password        |
      | "OlgaKhobina"   | "wrongPassword" |
      | "wrongUsername" | "OlgaKhobina"   |