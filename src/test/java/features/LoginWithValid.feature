Feature: API Testing for Login with an Invalid credentials

  Scenario: Login With an valid credentials
    Given I hit the post url to Login
    When I pass body of the Valid email "mpho@gmail.com" and Valid Password "Maganyela@09" request
    Then I receive the response code as 200 for the request