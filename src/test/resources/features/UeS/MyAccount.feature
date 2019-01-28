Feature: MyAccount Module

  @Regression_UeS @MyAccount_Broker
  Scenario Outline: "<TestCaseID>" Display all links(all page) on My Account page when user logging as Broker
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName as "<UserName>" and Password as "<PWD>" for Broker login
    Then UeS_User displayed Login Successfully
    #Then UeS_User verify Broker User Name,Hearder and Footer on Home Page
    And UeS_User verify My Account link on Home page and then click on My Account link
    And UeS_User verify followed links on MyAccount page View/Edit Renewal Package Mailing Preference,Change Password and Change Secret Questions
    Then UeS_User click on above links and verify pages View/Edit Renewal Package Mailing Preference,Change Password and Change Secret Questions
    And UeS_User verify followed links on MyAccount page Update Employer eServices Information,Update UnitedAdvantage.com Information and View/Edit Contact Information
    Then UeS_User click on above links and verify pages Update Employer eServices Information,Update UnitedAdvantage.com Information and View/Edit Contact Information
    And UeS_User verify followed links on MyAccount page Manage My Delegates,View License & Appointments and Change Renewal Alerts Status
    Then UeS_User click on above links and verify pages Manage My Delegates,View License & Appointments and Change Renewal Alerts Status
    And UeS_User verify followed links on MyAccount page Change Commission Alerts Status,Change Late Premium and Cancel Case Alerts Status and Quote Setup
    Then UeS_User click on above links and verify pages Change Commission Alerts Status,Change Late Premium and Cancel Case Alerts Status and Quote Setup
    And UeS_User verify followed links on MyAccount page Quote Generation Options,Custom Logo Selection and Define Sales Material & Benefit Searches
    Then UeS_User click on above links and verify pages Quote Generation Options,Custom Logo Selection and Define Sales Material & Benefit Searches

    Examples: 
      | FileName        |  | TestCaseID |  | UserName |  | PWD        |
      | MyAccount_TC_38 |  | TC_38      |  | CommTest |  | Password$4 |

  @Regression_UeS @MyAccount_Admin
  Scenario Outline: "<TestCaseID>" Display all links(all page) on My Account page when user logging as Administrator
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    #Then UeS_User verify User Name,Hearder and Footer on Home Page
    And UeS_User verify My Account link on Home page and then click on My Account link
    #And UeS_User verify links on My Account page when user logging as Administrator
    #Then UeS_User click on each link on My Account page and verify page displayed successfully based on User clicked on link
    And UeS_User verify followed links on MyAccount page Change Password,Change Secret Questions and Update UnitedAdvantage.com Information
    Then UeS_User click on above links and verify pages Change Password,Change Secret Questions and Update UnitedAdvantage.com Information
    And UeS_User verify followed links on MyAccount page View/Edit Contact Information,Quote Setup and Quote Generation Options
    Then UeS_User click on above links and verify pages View/Edit Contact Information,Quote Setup and Quote Generation Options
    And UeS_User verify followed links on MyAccount page Custom Logo Selection and Define Sales Material & Benefit Searches
    Then UeS_User click on above links and verify pages Custom Logo Selection and Define Sales Material & Benefit Searches

    Examples: 
      | FileName        |  | TestCaseID |
      | MyAccount_TC_39 |  | TC_39      |
