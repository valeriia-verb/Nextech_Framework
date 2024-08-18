Feature: 'Schedule a Demo' form feature

  # User story:
  # As a user, I should be able to fill and submit "Schedule a Demo" form

  #AC: If the user skips any field the form should not be submitted

  #@wip
  Scenario: Verify "Schedule a Demo" form is not submitted if one field is missing
    Given the user is on the Schedule a Demo page
    When the user enters random test data for the form missing a field
    And the user presses the 'Schedule a Demo' button
    Then the user should see missing field highlighted