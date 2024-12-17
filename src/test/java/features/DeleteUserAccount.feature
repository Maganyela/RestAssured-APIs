Feature: API Testing to Delete the user account

  Scenario: Delete the User account in the system
    Given I hit the Delete Url to delete the user account
    When I pass the email and password detail in the request
    Then I receive the response code as 200 for the request