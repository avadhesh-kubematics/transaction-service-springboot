Feature: Customer provides the details and Cashier passes the information to transaction service

  Scenario: When transaction event occurred and consumer listens
    Given Cashier produces an Credit Transaction event
    When Transaction service consumes the Credit Transaction event
#    Then The API should return status 201
