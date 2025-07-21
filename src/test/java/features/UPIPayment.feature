Feature: UPI Payment Transaction

  Scenario: Successful UPI Payment
    Given the user selects bank account "SBI"
    And enters UPI ID "test@upi" and amount "1000" with remark "Test payment"
    When the user initiates the UPI payment
    Then payment should succeed with message "Payment Successful"

  Scenario: Payment fails due to payment engine validation
    Given the user selects bank account "HDFC"
    And enters UPI ID "failengine@upi" and amount "500" with remark "Fail Engine"
    When the user initiates the UPI payment
    Then payment should fail with message "Payment Engine validation failed"

  Scenario: Payment fails due to insufficient balance
    Given the user selects bank account "Axis"
    And enters UPI ID "nobalance@upi" and amount "20000" with remark "Insufficient fund"
    When the user initiates the UPI payment
    Then payment should fail with message "Insufficient balance"

  Scenario: Payment fails due to clearing agent rejection
    Given the user selects bank account "ICICI"
    And enters UPI ID "clearnack@upi" and amount "900" with remark "Clearing failure"
    When the user initiates the UPI payment
    Then payment should fail with message "Clearing NACK from bank"
  Scenario: Qualification success
    Given the user provides UPI ID "test@upi"
    When the system checks the payment status from mock API
    Then the payment result should be "success"

  Scenario: Qualification failed
    Given the user provides UPI ID "failengine@upi"
    When the system checks the payment status from mock API
    Then the payment result should be "Payment Engine validation failed"

  Scenario: Fund control failed
    Given the user provides UPI ID "nobalance@upi"
    When the system checks the payment status from mock API
    Then the payment result should be "Insufficient balance"

  Scenario: Clearing NACK
    Given the user provides UPI ID "clearnack@upi"
    When the system checks the payment status from mock API
    Then the payment result should be "Clearing NACK from bank"