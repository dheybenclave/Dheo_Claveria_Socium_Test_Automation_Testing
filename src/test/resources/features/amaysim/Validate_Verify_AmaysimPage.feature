Feature: UI Smoke Testing - Amaysim Page

  @UISmoke @Amaysim @Page_Scenario_1 @Service
  Scenario Outline: Validate and Verify the Service Page
    Given I login in the application <Page> as <User>
    Then I verify the dashboard page
    Then I verify the following text in the page :
      | Welcome back!      |
      | mobile plans       |
      | UAT2 - 0466134574  |
      | Manage plan        |
      | new mobile plan    |
      | Already got a SIM? |

    Examples:
      | Page        | User     |
      | AMAYSIMPAGE | Customer |

  @UISmoke @Amaysim @Page_Scenario_2 @Account
  Scenario Outline: Validate and Verify the Account Page
    Given I login in the application <Page> as <User>
    Then I verify the dashboard page
    And I click on the Account Tab
    And I cancel the authentication dialog if exists
    Then I verify the account page
    Then I verify the following text in the page :
      | UAT2 - 0466134574 |
      | 15GB Data Plan    |
      | My dashboard      |
    Examples:
      | Page        | User     |
      | AMAYSIMPAGE | Customer |

  @UISmoke @Amaysim @Page_Scenario_3 @Help
  Scenario Outline: Validate and Verify the Help Page
    Given I login in the application <Page> as <User>
    Then I verify the dashboard page
    And I click on the Help Tab
    Then I verify the help page
    And I click on the Account Tab

    Examples:
      | Page        | User     |
      | AMAYSIMPAGE | Customer |




