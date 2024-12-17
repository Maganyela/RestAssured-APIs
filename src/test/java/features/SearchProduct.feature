Feature: API Testing for searching the product

  Scenario: Search the product and retrieve it
    Given I hit the Post Url to search the product
    When I pass the body of the Search the product request
    Then I receive the response code as 200 for the request