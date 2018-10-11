Feature: Administration Module

  @Administration_New
  Scenario Outline: "<TestCaseID>" Display All Links in Adminsitration Page
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    Then Click on Administration Link
    And UeS_User verifies the title of the Administration page as "<Title>"
    #Then Verify all the links are present or not in Site Administration Page
    #Then Check all the links one by one
    And UeS_User verify followed links on Site Administration page Create & Register a New User,Manage Existing Users and Manage B2B Account
    Then UeS_User click on above links and verify pages Create & Register a New User,Manage Existing Users and Manage B2B Account
    And UeS_User verify followed links on Site Administration page Manage Organization,Manage Organization Users and Manage Broker Delegates
    Then UeS_User click on above links and verify pages Manage Organization,Manage Organization Users and Manage Broker Delegates
    And UeS_User verify followed links on Site Administration page Manage United Advantage Report Access and Manage Quote & Renewal News, Alerts and Notations
    Then UeS_User click on above links and verify pages Manage United Advantage Report Access and Manage Quote & Renewal News, Alerts and Notations
    And UeS_User verify followed links on Site Administration page Clear Cache,Modify Logging Levels and View Renewal Package Mailing Preference & History
    Then UeS_User click on above links and verify pages Clear Cache,Modify Logging Levels and View Renewal Package Mailing Preference & History

    Examples: 
      | FileName             |  | TestCaseID |  | Title               |
      | Administration_TC_40 |  | TC_40      |  | Site Administration |
