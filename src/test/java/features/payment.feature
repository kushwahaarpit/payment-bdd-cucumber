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

  Scenario: Payment fails due to qualification failure
    Given the user is on the payment page
    When the user submits payment with unqualified details
    Then an error "Qualification failed" should be shown


  Scenario: Payment fails due to sanction check
    Given the user is on the payment page
    When the user submits payment and fails sanction screening
    Then an error "Sanction failed" should be shown

  Scenario: Payment fails due to fund control error
    Given the user is on the payment page
    When the user tries to pay an amount beyond fund control limit
    Then an error "Fund control failed" should be shown

  Scenario: Payment fails due to clearing NACK
    Given the user is on the payment page
    When the clearing house rejects the payment
    Then an error "Clearing nack" should be shown
