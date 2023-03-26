Feature: Grid Filtering Testing

  @Grid @UISmoke @Grid_Scenario_1
  Scenario Outline: Validate and Verify the Filter grid using parent controls
    Given I navigate to <Page>
    When I verify the element navigation search box in the page
    And I go to Grid > Filtering > Misc modules
    Then I verify the grid filter using parent control element
    And I filter the grid using the following :
      | control  | field   | value         |
      | textbox  | person  | Earl          |
      | textbox  | food    | Soup          |
      | dropdown | country | Elwynn Forest |
      | dropdown | country | any country   |
#  Get Multple result in grid
    Then I validate the grid result using the following :
      | Id   | Person | Food | Country    | Date      | Chef                      |
      | 1719 | Earl   | Soup | Sylvanaar  | 6/15/2012 | University Chronos Timpus |
      | 1803 | Earl   | Soup | Piccadilly | 4/9/2013  | Pepper Tomato             |
#  Get Specific result in grid
    And I filter the grid using the following :
      | control | field | value |
      | textbox | food  | Apple |
    Then I validate the grid result using the following :
      | Id   | Person | Food  | Country   | Date      | Chef           |
      | 2021 | Earl   | Apple | Stormwind | 10/7/2018 | Phoebe Phoebes |
    Examples:
      | Page               |
      | DEMOASPAWESOMEPAGE |





