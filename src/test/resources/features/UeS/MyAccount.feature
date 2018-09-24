Feature: MyAccount Page

  @Regression_UeS123 @MyAccount_Admin
  Scenario Outline: "<TestCaseID>" Display all links(all page) on My Account page when user logging as Administrator
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    #Then UeS_User verify User Name,Hearder and Footer on Home Page
    And UeS_User verify My Account link on Home page and then click on My Account link
    And UeS_User verify links on My Account page when user logging as Administrator
    Then UeS_User click on each link on My Account page and verify page displayed successfully based on User clicked on link

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_39 |  | TC_39      |