Feature: Demo Analyses

  Scenario: validates presence and availability of all 3 Demo workspaces
    Given the user is logged with "Mahmoud Abuzaid"
    Then the user should view the following demo workspaces
      | Order to Cash        |
      | Purchase to Pay      |
      | ServiceNow Ticketing |

  Scenario: validates presence and availability of all 3 Demo analyses
    Given the user is logged with "Mahmoud Abuzaid"
    When user click on all workspaces
    Then the user should view the following demo analyses
      | Order to Cash        |
      | Purchase to Pay      |
      | ServiceNow Ticketing |

  Scenario Outline:  ensuring that the analyses load successfully and display the content correctly
    Given the user is logged with "Mahmoud Abuzaid"
    And user click on all workspaces
    When user open "<analyses>" chart
    Then the chart analyses page is opened
    Examples:
      | analyses                  |
      | SAP ECC - Order to Cash   |
      | SAP ECC - Purchase to Pay |
      | ServiceNow Ticketing      |

  Scenario Outline: test login scenarios
    Given user write "<email>" into email field and "<password>" into password field
    When
    Examples:
      | email   | password |
      |         | 123456   |
      | a@a     | 12345    |
      | aa.com  | 123456   |
      | a@a.com |          |
      | a@a.com | 1        |