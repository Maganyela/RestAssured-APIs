Feature: API Testing to get the list of all the brands

  Scenario: Get all the brands on the system
    Given I hit the Get Url to get all the brands
    When I pass the request i get all the brands
    Then I receive the response code as 200 for the request