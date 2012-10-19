Feature: Login feature
  Scenario: As a valid user I can log into my app
    When I press "Sign In"
    Then I wait for progress
    When I enter "craig@habuma.com" into input field with id "input#login"
    And I enter "freebird" into input field with id "input#password"
    Then I press the button with id "form#signin p button"
    Then I wait for 5 seconds
    Then I press the button with id "button"
    Then I wait for progress
    Then I see "Events"
    When I press "SpringOne 2GX"
    Then I wait for "Event Details" to appear
    Then I see "Mon, Apr 9 - Thu, Apr 12, 2012"
    When I press "Session Schedule"
    Then I wait for "Session Schedule" to appear
    Then I see "Monday, Apr 9"
    Then I see "Tuesday, Apr 10"
    Then I see "Wednesday, Apr 11"
    When I press "Monday, Apr 9"
    Then I wait for "Monday, Apr 9" to appear
    Then I see "Opening Keynote"
    When I press "Opening Keynote"
    Then I wait for "Session Details" to appear
    Then I see "Rod kicks off #s2gx with a bang."