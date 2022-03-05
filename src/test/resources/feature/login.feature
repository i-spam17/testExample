Feature: log in mail.ru

    Scenario:
      Given I go to URL
      When I fill login
      And I click button Enter password
      And I fill password
      And I click button Enter
      Then I see inbox page
