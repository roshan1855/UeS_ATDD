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
      | FileName    |  | TestCaseID |
      | Quote_TC_34 |  | TC_34      |

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
      | FileName    |  | TestCaseID |
      | Quote_TC_35 |  | TC_35      |
