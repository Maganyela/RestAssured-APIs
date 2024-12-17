Feature: API Testing To get User by Email

  Scenario: Get the User by the email that exist
    Given I hit the Get Url to get the User by Email
    When I pass the Email "mpho14@gmail.com" in the request
    Then I receive the response code as 200 for the request