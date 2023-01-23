@tag
Feature: Test sunflower App

  @smoke1
  Scenario: Verify text message on Landing screen
    When User launch Sunflower app
    Then User sees My Garden screen with "Your garden is empty" text

  @smoke2
  Scenario: Verify Button visibility on Landing screen
    When User launch Sunflower app
    Then User sees My Garden screen with "ADD PLANT" button

  @func1
  Scenario: Landing screen Button visibility in Sunflower App
    When User launch Sunflower app
    Then User sees My Garden screen with "ADD PLANT" button

  @func2
  Scenario: Landing screen Button visibility in Sunflower App
    When User launch Sunflower app
    Then User sees My Garden screen with "ADD PLANT" button
