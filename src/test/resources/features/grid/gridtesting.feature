Feature: Grid Filtering Testing

  @Grid @UISmoke @Grid_Scenario_1
  Scenario Outline: Validate and Verify the Filter grid using parent controls
    Given I navigate to <Page>
    When I verify the element navigation search box in the page
    And I go to Grid > Filtering > Misc modules
    Then I verify the grid filter using parent control element
    And I filter the grid using the following :
      | control  | field   | value       |
      | textbox  | person  | Tracy       |
      | textbox  | food    | Oat meal    |
      | dropdown | country | Greville    |
      | dropdown | country | any country |
#  Get Multple result in grid
    Then I validate the grid result using the following :
      | Id   | Person | Food     | Country   | Date      | Location | Chef             |
      | 1447 | Tracy  | Oat meal | Orgrimmar | 7/17/2019 | Home     | Chronos Timpus   |
      | 1873 | Tracy  | Oat meal | Greville  | 3/23/2010 | Visit    | Fromage Sandwich |
#  Get Specific result in grid
    And I filter the grid using the following :
      | control | field | value |
      | textbox | food  | Apple |
    Then I validate the grid result using the following :
      | Id   | Person | Food  | Country    | Date      | Location | Chef         |
      | 2021 | Tracy  | Apple | Piccadilly | 8/15/2014 | Home     | Hercules Oat |
    Examples:
      | Page               |
      | DEMOASPAWESOMEPAGE |





