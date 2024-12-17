Feature: API Testing for User Account Creation and Retrieval


  Scenario: Create a new user account and retrieve it
    Given I hit the post url to create account endpoint
    When I pass the body of the create account request
    Then I receive the response code as 200
