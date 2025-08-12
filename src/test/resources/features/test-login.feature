Feature:Test Celonis login page

  Scenario:Test login with correct credential
    Given the user is logged with "Mahmoud Abuzaid"
    Then the user should view the following sections
      | Workspaces |
      | Analyses   |