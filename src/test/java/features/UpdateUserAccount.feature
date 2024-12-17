Feature: API Testing to update the user account

  Scenario: Update the User account details
    Given I hit the Put Url to update the User details
    When I pass body of the user account details in the request
    Then  I receive the response code as 200 for the request