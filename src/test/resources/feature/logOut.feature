Feature: log out

  Background:
    Given I am authorized

    Scenario:
      Given I click button Account
      When I click Exit
      Then I see Main page
