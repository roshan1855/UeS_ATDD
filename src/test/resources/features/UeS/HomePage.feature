Feature: Home Page

  @Regression_UeS123 @Validate_UserName_Header_Footer_On_HomePage
  Scenario Outline: "<TestCaseID>" Validate UserName_ Hearder_ Footer on home page
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    Then UeS_User verify User Name,Hearder and Footer on Home Page

    Examples: 
      | FileName       |  | TestCaseID |
      | HomePage_TC_34 |  | TC_34      |

  @Regression_UeS123 @Validate_Headings_On_HomePage
  Scenario Outline: "<TestCaseID>" Validate News & Information/News & Rate Alerts/Whats New?/ Quick Links section on Home Page
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    Then UeS_User verify News & Information/News & Rate Alerts/Whats New?/ Quick Links section on Home Page

    Examples: 
      | FileName       |  | TestCaseID |
      | HomePage_TC_35 |  | TC_35      |

  @Regression_UeS123 @Display_SAM_Link_On_HomePage @SAM
  Scenario Outline: "<TestCaseID>" Display SAM: Sales Automation Management(SAM) link on Home Page
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    And UeS_User verify Sales Automation Management Link on Home Page and then click on SAM link
    Then UeS_User verify Sales Automation Management page displayed successfully

    Examples: 
      | FileName       |  | TestCaseID |
      | HomePage_TC_36 |  | TC_36      |

  @Regression_UeS123 @Display_Forms_Help&Training_BenefitsAdministration_Recognition_Tabs_On_HomePage @Home
  Scenario Outline: "<TestCaseID>" Display of tabs within homepage including Forms / Help & Training / Benefits Administration / Recognition
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    And UeS_User verify Forms, Help & Training ,Benefits Administration and Recognition tabs on Home Page then click on each tab
    Then UeS_User verify content on each page based on User selected tab on Home Page

    Examples: 
      | FileName       |  | TestCaseID |
      | HomePAge_TC_37 |  | TC_37      |
