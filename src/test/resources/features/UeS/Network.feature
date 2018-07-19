Feature: Network Module

  @Regression_UeS @Validate_Network_Home @Suri
  Scenario Outline: "<TestCaseID>" Display Physician directories/Network Fact sheets/Network Maps links on home page and below Network tabs
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User click on Network tab then verifies sub-tabs: Physician Directories,Network Fact Sheets and Network Maps
    And UeS_User verifies the title of the network page as "<Title>"
    And UeS_User verifies the site copy below the title
    And UeS_User verifies the links present: Network Fact Sheets,Network Maps and Physician Directories
    Then UeS_User verifies Network sub link pages : Physician Directories, Network Fact Sheets and Network Maps

    Examples: 
      | FileName      |  | TestCaseID |  | Title        |
      | Network_TC_04 |  | TC_04      |  | Network Home |
