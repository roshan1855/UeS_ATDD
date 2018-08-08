Feature: Compensation Module

  @Regression @Validate_Compensation_Home
  Scenario Outline: "<TestCaseID>" Display Links on Compensation Home Page
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Dev environment Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password then click on login button
    Then UeS_User displayed Login Successfully
    And UeS_User click on Compensation tab
    Then UeS_User verify Compensation_Home is displayed successfully
    And UeS_User check links present in Compensation home : Commission Statements,Request Direct Deposit Authorization and other links
    Then UeS_User verifies Compensation sub link pages : Commission Statements,Request Direct Deposit Authorization and other links

    Examples: 
      | FileName           |  | TestCaseID |
      | Compensation_TC_05 |  | TC_05      |
      
      
      
  @Chandu
  Scenario: Test Login
    When Test_User Navigate to LogIn Page
    And Test_User enters UserName and Password then click on login button
    Then _User displayed Login Successfully
 
      
