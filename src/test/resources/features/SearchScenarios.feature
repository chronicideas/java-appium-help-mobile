@Nexus5xOreoChrome
Feature: Search Scenarios
  As a user of Google, I want to be able to search for stuff

  Scenario: 01. Search and select a result
    Given I navigate to the base URL
    When I search for "Reddit"
    And I select the first returned result
    Then I see the page title contains "reddit:"
    And I see the page Url contains "https://www.reddit.com/"
    And I see
      | log in      |
      | sign up     |
      | community   |