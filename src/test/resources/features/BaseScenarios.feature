@Nexus5xOreoChrome
Feature: BaseScenarios
  These scenarios can be used in any project

  Background:
    Given I navigate to the base URL

  Scenario: 01. Validate the title of a website
    Then I see the page title contains "Google"

  Scenario: 02. Validate the Url of the website
    Then I see the page Url contains "https://www.google.com"

  Scenario: 03. Validate the PageSource string on the website
    Then I see "Google Search" in the PageSource

  Scenario: 04. Validate existence of multiple texts in PageSource
    Then I see
      | Gmail         |
      | Images        |
      | Google Search |