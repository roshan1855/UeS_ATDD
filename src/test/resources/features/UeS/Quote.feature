Feature: Quotes Module

  @Regression_UeS @AddNewQuote_MDVL_Coverage_With_Sal
  Scenario Outline: "<TestCaseID>" Generate proposal_MDVL with census incluidng EEs with salary info / with dependents
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is Fill all the details of the Quote Setup Page and click on next
    And UeS_User is Fill all the details of the Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_01 |  | TC_01      |

  @Regression_UeS @AddNewQuote_MDVL_Coverage_Without_Sal
  Scenario Outline: "<TestCaseID>" Generate proposal_MDVL with census incluidng EEs without salary info
    When UeS_UserFlow_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is Fill all the details of the Quote Setup Page and click on next
    And UeS_User is Fill all the details without salary info of the Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_02 |  | TC_02      |

  @SmokeBed_UeS @Validate_Employee_Age
  Scenario Outline: "<TestCaseID>" Validate the Employee Age
    When UeS_UserFlow_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is Fill all the details of the Quote Setup Page and click on next
    And UeS_User is Fill all the details of the Census page and click on Next button
    Then UeS_User verify error message 'Employees age must be greater than 14' under Census page

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_30 |  | TC_301     |

  @SmokeBed_UeS @UeS_Login
  Scenario Outline: "<TestCaseID>" Validate the UeS Login
    When UeS_UserFlow_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    Then UeS_User verify user name as "<Username>" is displayed successfully in Home page

    Examples: 
      | FileName       |  | TestCaseID |  | Username      |
      | Logon_Login_TC |  | TC_302     |  | roshanAdmin05 |

  @SmokeBed_UeS1 @UeS_Administration
  Scenario Outline: "<TestCaseID>" Verify the message 'Modify Logging Levels Success'
    When UeS_UserFlow_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User click on Administration link and then click on Modify Logging Levels link
    And UeS_User select values from Application and Logging Level dropdowns then click on Sumit btton
    Then UeS_User verify the message 'Modify Logging Levels Success'

    Examples: 
      | FileName             |  | TestCaseID |
      | Administration_TC_09 |  | TC_303     |

  @Regression_UeS @AddNewQuote_Medical_Vision_with_salary
  Scenario Outline: "<TestCaseID>" Generate proposal_MV with census incluidng EEs with salary info
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    When Ues_user choose medical and vision coverage and fill the details on quote information page
    And UeS_User is Fill all the details of the Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_06 |  | TC_06      |

  @Regression_UeS @AddNewQuote_Medical_Vision_Without_Salary
  Scenario Outline: "<TestCaseID>" Generate proposal_MV with census incluidng EEs without salary info / with dependents
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    When Ues_user choose medical and vision coverage and fill the details on quote information page
    And UeS_User_should_fill_Census_page_with_Dep_without_Salary_EE_only_and_click_on_next
    And UeS_User is Select the Plans from Medical Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_07 |  | TC_07      |

  @Regression_UeS @AddNewQuote_Dental_Vision_Life_Without_Salary
  Scenario Outline: "<TestCaseID>" Generate proposal_DVL with census incluidng EEs without salary info / with dependents
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    Then Ues_user choose "DVL" coverage and fill the details on quote information page
    And UeS_User_should_fill_Census_page_with_Dep_without_Salary_EE_only_and_click_on_next
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_08 |  | TC_08      |

  #Last Validated on june 19
  @Regression_UeS @AddNewQuote_Dental_Vision_Life_With_Salary_with_DEP
  Scenario Outline: "<TestCaseID>" Generate proposal_DVL with census incluidng EEs with salary info
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    Then Ues_user choose "DVL" coverage and fill the details on quote information page
    And UeS_User is Fill all the details of the Census page and click on next
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_09 |  | TC_09      |

  #Validated on june 19
  @Regression_UeS @AddNewQuote_Dental_Vision_With_Salary_with_DEP
  Scenario Outline: "<TestCaseID>" Generate proposal_DV with census incluidng EEs with salary info  / with dependents
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    Then Ues_user choose "DV" coverage and fill the details on quote information page
    And UeS_User_should_fill_Census_page_with_Dep_without_Salary_EE_only_and_click_on_next
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_10 |  | TC_10      |

  @Regression_UeS @AddNewQuote_Dental_Vision_Without_Salary
  Scenario Outline: "<TestCaseID>" Generate proposal_DV with census incluidng EEs without salary info
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    Then Ues_user choose "DV" coverage and fill the details on quote information page
    And UeS_User is Fill all the details of the Census page and click on next
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_11 |  | TC_11      |

  @Regression_UeS @AddNewQuote_Dental_Life_With_Salary_with_DEP
  Scenario Outline: "<TestCaseID>" Generate proposal_DL with census incluidng EEs with salary info
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    Then Ues_user choose "DL" coverage and fill the details on quote information page
    And UeS_User_should_fill_Census_page_with_Dep_without_Salary_EE_only_and_click_on_next
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_12 |  | TC_12      |

  @Regression_UeS @AddNewQuote_Dental_Life_Without_Salary
  Scenario Outline: "<TestCaseID>" Generate proposal_DL with census incluidng EEs without salary info  / with dependents
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    Then Ues_user choose "DL" coverage and fill the details on quote information page
    And UeS_User is Fill all the details of the Census page and click on next
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_13 |  | TC_13      |

  @Regression_UeS @AddNewQuote_Vision_Life_With_Salary
  Scenario Outline: "<TestCaseID>" Generate proposal_VL with census incluidng EEs with salary info  / with dependents
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    Then Ues_user choose "VL" coverage and fill the details on quote information page
    And UeS_User is Fill all the details of the Census page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_14 |  | TC_14      |

  @Regression_UeS @AddNewQuote_Vision_Life_Without_Salary
  Scenario Outline: "<TestCaseID>" Generate proposal_VL with census incluidng EEs without salary info
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    Then Ues_user choose "VL" coverage and fill the details on quote information page
    And UeS_User_should_fill_Census_page_with_Dep_without_Salary_EE_only_and_click_on_next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |
      | Quote_TC_15 |  | TC_15      |

  # July 2018
  @Regression_UeS @AddNewQuote_Medical_Vision_Coverage_State_WA_TX_CA
  Scenario Outline: "<TestCaseID>" Validate "<Information>" on coverages_MV using "<State>" state
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on next button
    And UeS_User is Fill all the details of the Census page and click on next
    Then UeS_User verify Rating Method as "<Value>"
    And UeS_User is Select the Plans from Medical Plans Page and click on Compare Rates For Selected Plans button
    Then UeS_User is verify EMPLOYEE CLASS in Medical Rate Comparison page by using "<Information>"
    And UeS_User is navigate back to Medical Plans Page and click on next
    And UeS_User is Select the Plans from Optional Medical Riders Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    Then UeS_User click on GENERATE FINAL PROPOSAL button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value                    |  | Information        |  | Zip Code |
      | Quote_TC_16 |  | TC_16      |  | WA    |  | 2 Tier Composite for ACR |  | 2 Tier             |  |    98001 |
      | Quote_TC_17 |  | TC_17      |  | TX    |  | 4 Tier Composite for ACR |  | 4 Tier             |  |    73301 |
      | Quote_TC_18 |  | TC_18      |  | CA    |  | Age Banded for ACR       |  | Age Banded for ACR |  |    90001 |

  @Testing
  Scenario Outline: "<TestCaseID>" Testing
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And fill all details
    Then UeS_User click on GENERATE FINAL PROPOSAL1 button and verify Preview Proposal PDf is displayed successfully

    Examples: 
      | FileName   |  | TestCaseID |
      | Test_TC_20 |  | TC_20      |
