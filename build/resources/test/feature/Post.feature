Feature: Information det individual user

  Scenario: Send information get individual user with response success
    Given I load customer information user
      |id|name  |job |
      |1 |Alvaro|Java|
    When I call Post user API
    Then I should see the status code 201
    And I validate quantity key is 4
    And I validate schema response "PostJsonSchema"
    And I validate fields get response api
    And I validate get response contain data expected