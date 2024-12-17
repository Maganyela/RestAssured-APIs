Feature: API Testing to get the list of product

  Scenario: Get all the product available
    Given I hit the Get Url to get all the product
    When I pass the request i get all the product
    Then I receive the response code as 200 for the request