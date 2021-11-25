Feature: create folder

  Background:
    Given I am authorized

    Scenario:
      Given I click on CreateFolder
      And I enter NameFolder
      And I click button AddFolder
      Then I see created folder

