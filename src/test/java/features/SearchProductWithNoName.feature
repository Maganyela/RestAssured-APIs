Feature: API Testing for searching the product with no name

  Scenario: Search the product  with no product name
    Given I hit the Post Url to search the product
    When I pass body of the search with no product name request
    Then I receive the response code as 200 for the request