Feature: compose and sent mail

  Background:
    Given I am authorized

    Scenario:
      Given I click button Compose
      When I fill whom
      And I fill theme
      And I fill textbox
      And I click button sent
      Then I see success page

