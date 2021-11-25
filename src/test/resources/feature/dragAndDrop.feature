Feature: drag and drop mail to folder

  Background:
    Given I am authorized

    Scenario:
      Given I drag and drop mail in to folder
      And I click in DnD folder
      Then I see moving mail