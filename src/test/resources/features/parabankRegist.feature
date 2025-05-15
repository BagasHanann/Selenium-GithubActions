@ALL
  Feature: Para bank registration

    @Positive @Register
      Scenario: Success register
        Given User on ParaBank homepage
        When User click register link button
        Then User is in register page
        When User input name
        And User input address detail
        And user fill valid username and password
        And User input password confirmation
        When User click register button
        Then User register successfully

    @Negative @Register
      Scenario: Failed register - Missmatch password
        Given User on ParaBank homepage
        When User click register link button
        Then User is in register page
        When User input name
        And User input address detail
        And user fill valid username and password
        And User input invalid password confirmation
        When User click register button
        Then User set error password did not match