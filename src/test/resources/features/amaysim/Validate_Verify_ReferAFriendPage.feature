Feature: UI Smoke Testing - Refer A Friend Page


  @UISmoke @Amaysim @ReferAFriend_Scenario_1 @ReferAFriend
  Scenario Outline: Validate and Verify the functionality of Refer A Friend Page
    Given I login in the application <Page> as <User>
    Then I verify the dashboard page
    And I click on the Account Tab
    And I cancel the authentication dialog if exists
    Then I verify the account page
    When I click the Menu Item Refer a friend
    Then I verify the refer a friend page
    Then I verify the visible label in the refer a friend page :
      | Give your friends $10 in account credit and you'll also get $10 in account credit when they sign up                                                           |
      | Send your friends an email                                                                                                                                    |
      | Personalise your message to your friend by adding your name, so they know who it's from.                                                                      |
      | By clicking SHARE, you confirm that you have your friends consent to share their email and that they are happy to receive emails about this referral program. |
      | Send my friend a reminder in 3 days                                                                                                                           |
    Then I validate and Verify the Referral Section
    Then I validate and Verify the Share Section
    Then I validate and Verify the Messenger Social Media
    Then I verify the visible label in the refer a friend page :
      | Thanks for sharing the big love |
      | Share Again                     |
    And I click the Share Again button
    Then I validate and Verify the Facebook Social Media
    Then I verify the visible label in the refer a friend page :
      | Once your friend signs up you'll find your $10 credit in your account |
      | Share Again                                                           |
    And I click the Share Again button
    Then I validate and Verify the Twitter Social Media
    Then I verify the visible label in the refer a friend page :
      | Please remember, you must have auto-renew still on to be  eligible to receive referral account credits. |
      | Share Again                                                                                             |
    Examples:
      | Page        | User     |
      | AMAYSIMPAGE | Customer |


