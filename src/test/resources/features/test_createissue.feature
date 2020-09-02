@Regression
Feature: Create Issue

    Background: User is logged in
      Given I navigate to Jira Login Page
      And I enter username as "OlgaKhobina"
      And I enter password as "OlgaKhobina"
      And I click on the login button
      Then I am on the Home Page

    Scenario: Create Jira Issue
      When I click on Create issue button
      Then I am on Create issue form
      And I enter project name as "Webinar (WEBINAR)"
      #And I enter issue type as "Test"
      #And I enter summary as "Summary"
      #And I enter reporter name as "OlgaKhobina"
      #And I enter description as "Some description"
      #And I click on Submit issue button
      #Then I can see a Success popup window