$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Demo-Analyses.feature");
formatter.feature({
  "line": 1,
  "name": "Demo Analyses",
  "description": "",
  "id": "demo-analyses",
  "keyword": "Feature"
});
formatter.before({
  "duration": 4777543600,
  "status": "passed"
});
formatter.before({
  "duration": 3295581600,
  "status": "passed"
});
formatter.before({
  "duration": 23955200,
  "status": "passed"
});
formatter.before({
  "duration": 138400,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "validates presence and availability of all 3 Demo workspaces",
  "description": "",
  "id": "demo-analyses;validates-presence-and-availability-of-all-3-demo-workspaces",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the user is logged with \"Mahmoud Abuzaid\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user should view the following demo workspaces",
  "rows": [
    {
      "cells": [
        "Order to Cash"
      ],
      "line": 6
    },
    {
      "cells": [
        "Purchase to Pay"
      ],
      "line": 7
    },
    {
      "cells": [
        "ServiceNow Ticketing"
      ],
      "line": 8
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mahmoud Abuzaid",
      "offset": 25
    }
  ],
  "location": "LoginStepDef.loginByUserName(String)"
});
formatter.result({
  "duration": 2286076100,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.verifyPageSectionsDisplayed(DataTable)"
});
formatter.result({
  "duration": 6396164100,
  "status": "passed"
});
formatter.after({
  "duration": 62700,
  "status": "passed"
});
formatter.after({
  "duration": 144900,
  "status": "passed"
});
formatter.after({
  "duration": 27535200,
  "status": "passed"
});
formatter.after({
  "duration": 124200,
  "status": "passed"
});
formatter.before({
  "duration": 367900,
  "status": "passed"
});
formatter.before({
  "duration": 453969400,
  "status": "passed"
});
formatter.before({
  "duration": 22720600,
  "status": "passed"
});
formatter.before({
  "duration": 72300,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "validates presence and availability of all 3 Demo analyses",
  "description": "",
  "id": "demo-analyses;validates-presence-and-availability-of-all-3-demo-analyses",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "the user is logged with \"Mahmoud Abuzaid\"",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "user click on all workspaces",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "the user should view the following demo analyses",
  "rows": [
    {
      "cells": [
        "Order to Cash"
      ],
      "line": 14
    },
    {
      "cells": [
        "Purchase to Pay"
      ],
      "line": 15
    },
    {
      "cells": [
        "ServiceNow Ticketing"
      ],
      "line": 16
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mahmoud Abuzaid",
      "offset": 25
    }
  ],
  "location": "LoginStepDef.loginByUserName(String)"
});
formatter.result({
  "duration": 1596895900,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.userClickOnAllWorkspaces()"
});
formatter.result({
  "duration": 3530898900,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.theUserShouldViewTheFollowingDemoAnalyses(DataTable)"
});
formatter.result({
  "duration": 340619000,
  "status": "passed"
});
formatter.after({
  "duration": 64600,
  "status": "passed"
});
formatter.after({
  "duration": 91300,
  "status": "passed"
});
formatter.after({
  "duration": 47340800,
  "status": "passed"
});
formatter.after({
  "duration": 120700,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 18,
  "name": "ensuring that the analyses load successfully and display the content correctly",
  "description": "",
  "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 19,
  "name": "the user is logged with \"Mahmoud Abuzaid\"",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user click on all workspaces",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "user open \"\u003canalyses\u003e\" chart",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "the chart analyses page is opened",
  "keyword": "Then "
});
formatter.examples({
  "line": 23,
  "name": "",
  "description": "",
  "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly;",
  "rows": [
    {
      "cells": [
        "analyses"
      ],
      "line": 24,
      "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly;;1"
    },
    {
      "cells": [
        "SAP ECC - Order to Cash"
      ],
      "line": 25,
      "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly;;2"
    },
    {
      "cells": [
        "SAP ECC - Purchase to Pay"
      ],
      "line": 26,
      "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly;;3"
    },
    {
      "cells": [
        "ServiceNow Ticketing"
      ],
      "line": 27,
      "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly;;4"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 480600,
  "status": "passed"
});
formatter.before({
  "duration": 644414300,
  "status": "passed"
});
formatter.before({
  "duration": 22322000,
  "status": "passed"
});
formatter.before({
  "duration": 89800,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "ensuring that the analyses load successfully and display the content correctly",
  "description": "",
  "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 19,
  "name": "the user is logged with \"Mahmoud Abuzaid\"",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user click on all workspaces",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "user open \"SAP ECC - Order to Cash\" chart",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "the chart analyses page is opened",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mahmoud Abuzaid",
      "offset": 25
    }
  ],
  "location": "LoginStepDef.loginByUserName(String)"
});
formatter.result({
  "duration": 1666279400,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.userClickOnAllWorkspaces()"
});
formatter.result({
  "duration": 2540915800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SAP ECC - Order to Cash",
      "offset": 11
    }
  ],
  "location": "WorkspacesStepDef.userOpenChart(String)"
});
formatter.result({
  "duration": 5423323100,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.theChartPageIsOpened()"
});
formatter.result({
  "duration": 2448895600,
  "status": "passed"
});
formatter.after({
  "duration": 55500,
  "status": "passed"
});
formatter.after({
  "duration": 79500,
  "status": "passed"
});
formatter.after({
  "duration": 33832200,
  "status": "passed"
});
formatter.after({
  "duration": 97300,
  "status": "passed"
});
formatter.before({
  "duration": 398200,
  "status": "passed"
});
formatter.before({
  "duration": 596477800,
  "status": "passed"
});
formatter.before({
  "duration": 33567900,
  "status": "passed"
});
formatter.before({
  "duration": 62600,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "ensuring that the analyses load successfully and display the content correctly",
  "description": "",
  "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 19,
  "name": "the user is logged with \"Mahmoud Abuzaid\"",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user click on all workspaces",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "user open \"SAP ECC - Purchase to Pay\" chart",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "the chart analyses page is opened",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mahmoud Abuzaid",
      "offset": 25
    }
  ],
  "location": "LoginStepDef.loginByUserName(String)"
});
formatter.result({
  "duration": 1493204400,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.userClickOnAllWorkspaces()"
});
formatter.result({
  "duration": 3327383300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SAP ECC - Purchase to Pay",
      "offset": 11
    }
  ],
  "location": "WorkspacesStepDef.userOpenChart(String)"
});
formatter.result({
  "duration": 2541569600,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.theChartPageIsOpened()"
});
formatter.result({
  "duration": 3467301600,
  "status": "passed"
});
formatter.after({
  "duration": 55000,
  "status": "passed"
});
formatter.after({
  "duration": 75700,
  "status": "passed"
});
formatter.after({
  "duration": 47772100,
  "status": "passed"
});
formatter.after({
  "duration": 119400,
  "status": "passed"
});
formatter.before({
  "duration": 437300,
  "status": "passed"
});
formatter.before({
  "duration": 420173200,
  "status": "passed"
});
formatter.before({
  "duration": 24417800,
  "status": "passed"
});
formatter.before({
  "duration": 68000,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "ensuring that the analyses load successfully and display the content correctly",
  "description": "",
  "id": "demo-analyses;ensuring-that-the-analyses-load-successfully-and-display-the-content-correctly;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 19,
  "name": "the user is logged with \"Mahmoud Abuzaid\"",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "user click on all workspaces",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "user open \"ServiceNow Ticketing\" chart",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "the chart analyses page is opened",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mahmoud Abuzaid",
      "offset": 25
    }
  ],
  "location": "LoginStepDef.loginByUserName(String)"
});
formatter.result({
  "duration": 1565562200,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.userClickOnAllWorkspaces()"
});
formatter.result({
  "duration": 3151703500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ServiceNow Ticketing",
      "offset": 11
    }
  ],
  "location": "WorkspacesStepDef.userOpenChart(String)"
});
formatter.result({
  "duration": 1329843700,
  "status": "passed"
});
formatter.match({
  "location": "WorkspacesStepDef.theChartPageIsOpened()"
});
formatter.result({
  "duration": 1731448700,
  "status": "passed"
});
formatter.after({
  "duration": 32500,
  "status": "passed"
});
formatter.after({
  "duration": 200100,
  "status": "passed"
});
formatter.after({
  "duration": 28294500,
  "status": "passed"
});
formatter.after({
  "duration": 49200,
  "status": "passed"
});
formatter.uri("test-login.feature");
formatter.feature({
  "line": 1,
  "name": "Test Celonis login page",
  "description": "",
  "id": "test-celonis-login-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 280200,
  "status": "passed"
});
formatter.before({
  "duration": 552491200,
  "status": "passed"
});
formatter.before({
  "duration": 18735200,
  "status": "passed"
});
formatter.before({
  "duration": 50800,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Test login with correct credential",
  "description": "",
  "id": "test-celonis-login-page;test-login-with-correct-credential",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the user is logged with \"Mahmoud Abuzaid\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "the user should view the following sections",
  "rows": [
    {
      "cells": [
        "Workspaces"
      ],
      "line": 6
    },
    {
      "cells": [
        "Analyses"
      ],
      "line": 7
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Mahmoud Abuzaid",
      "offset": 25
    }
  ],
  "location": "LoginStepDef.loginByUserName(String)"
});
formatter.result({
  "duration": 1530640000,
  "status": "passed"
});
formatter.match({
  "location": "LoginStepDef.verifyPageSectionsDisplayed(DataTable)"
});
formatter.result({
  "duration": 2394497700,
  "status": "passed"
});
formatter.after({
  "duration": 51000,
  "status": "passed"
});
formatter.after({
  "duration": 84000,
  "status": "passed"
});
formatter.after({
  "duration": 48195900,
  "status": "passed"
});
formatter.after({
  "duration": 97300,
  "status": "passed"
});
});