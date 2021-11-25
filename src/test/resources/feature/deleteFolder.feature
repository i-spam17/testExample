Feature: delete folder

  Background:
    Given I am authorized

    Scenario:
      Given I context click on created folder
      And I choose delete folder
      And I click button DeleteFolder
      Then Folder is deleted