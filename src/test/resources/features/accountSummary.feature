Feature: Account summary
  As a user
  I want to my account summary details.

  Background:
    Given I am on the login page
    When I enter valid user name as "username" and "password"
    And I click on the login button
    Then I should be logged in to my account

  Scenario: Account Summary
    Given  I am on view account summary page
    When I select required account type
    And I click on the Go button
    Then I should get balance details