Feature: Payment Transaction

  Scenario: Successful Payment Transaction
    Given the user is on the payment page
    When the user enters valid card details
    And the user confirms the payment
    Then the payment should be successful

  Scenario: Failed Payment Transaction
    Given the user is on the payment page
    When the user enters invalid card details
    And the user confirms the payment
    Then the payment should be declined
