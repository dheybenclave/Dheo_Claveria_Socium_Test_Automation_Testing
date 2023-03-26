Feature: Search by keyword

  @Searching
  Scenario: Searching for a term
    Given I researching things on the internet
    When I looks up "Cucumber"
    Then I should see information about "Cucumber"

