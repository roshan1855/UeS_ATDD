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

  @Regression_UeS @AddNewQuote_MV_with_salary
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

  @Regression_UeS @AddNewQuote_MV_Without_Salary
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

  @Regression_UeS @AddNewQuote_DVL_Without_Salary
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
  @Regression_UeS @AddNewQuote_DVL_With_Salary_with_DEP
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
  @Regression_UeS @AddNewQuote_DV_With_Salary_with_DEP
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

  @Regression_UeS @AddNewQuote_DV_Without_Salary
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

  @Regression_UeS @AddNewQuote_DL_With_Salary_with_DEP
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

  @Regression_UeS @AddNewQuote_DL_Without_Salary
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

  @Regression_UeS @AddNewQuote_VL_With_Salary
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

  @Regression_UeS @AddNewQuote_VL_Without_Salary
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
  @Regression_UeS @AddNewQuote_MV_Coverage_State_WA_TX_CA
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

  # Aug 2018
  @Regression_UeS @Validate_DentalPlanPage_Coverage_D
  Scenario Outline: "<TestCaseID>" Validate Dental plans page by "<Value>" with COMPARE SELECTED PLANS
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is Fill all the details without salary info of the Census page and click on next
    #And UeS_User is Fill all the details of the Census page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES button
    #And UeS_User is Select the ADD TO PROPOSAL checkboxes and click on COMPARE SELECTED PLANS button
    Then UeS_User is verify ANNUAL PREMIUM and BENEFIT in Dental Plan Comparison page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value                  |  | Information            |  | Zip Code |
      | Quote_TC_20 |  | TC_20      |  | CA    |  | Most Popular Plans     |  | Most Popular Plans     |  |    90001 |
      | Quote_TC_21 |  | TC_21      |  | CA    |  | Show All Plans         |  | Show All Plans         |  |    90001 |
      | Quote_TC_22 |  | TC_22      |  | CA    |  | Show My Selected Plans |  | Show My Selected Plans |  |    90001 |

  @Regression_UeS @Validate_DentalPlanPage_Coverage_D_1
  Scenario Outline: "<TestCaseID>" Validate Dental plans page by "<Value>" with COMPARE RATES FOR SELECTED PLANS
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is Fill all the details without salary info of the Census page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and selct plans then click on COMPARE RATES FOR SELECTED PLANS button
    Then UeS_User is verify Employer Contribution Premium and Total Annual Premium and EMPLOYEE CLASS in Dental Rate Comparison page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value                  |  | Zip Code |
      | Quote_TC_23 |  | TC_23      |  | CA    |  | Most Popular Plans     |  |    90001 |
      | Quote_TC_30 |  | TC_30      |  | CA    |  | Show All Plans         |  |    90001 |
      | Quote_TC_31 |  | TC_31      |  | CA    |  | Show My Selected Plans |  |    90001 |

  @Regression_UeS @Validate_DentalPlanPage_Coverage_D_HMO @HMO
  Scenario Outline: "<TestCaseID>" Verify Rates should be appear for HMO tab of plan "<Value>"
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is Fill all the details without salary info of the Census page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" then click on APPLY CHANGES button
    And UeS_User verify HMO tab in Dental Plans page and then click on HMO tab
    Then UeS_User is verify DHMO data displayed on Dental HMO Plan Information table based on "<Value>"

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value              |  | Zip Code |
      | Quote_TC_32 |  | TC_32      |  | CA    |  | Most Popular Plans |  |    90001 |
      | Quote_TC_33 |  | TC_33      |  | CA    |  | Show All Plans     |  |    90001 |

  @Regression_UeS @Validate_VisionPlanPage_Coverage_V
  Scenario Outline: "<TestCaseID>" Validate Vision plans page by "<Value>" with COMPARE SELECTED PLANS
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is select the coverage as "<Coverage>" and Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is Fill all the details without salary info of the Census page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES button in "<Coverage>" page
    And UeS_User select plans based on "<Value>" and click on COMPARE SELECTED PLANS button in Vision Plan Information table
    Then UeS_User is verify ANNUL PREMIUM and BENEFIT in  Vision Plan Comparison  page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value                  |  | Zip Code |  | Coverage |
      | Quote_TC_24 |  | TC_24      |  | CA    |  | Most Popular Plans     |  |    90001 |  | Vision   |
      | Quote_TC_25 |  | TC_25      |  | TX    |  | Show All Plans         |  |    73301 |  | Vision   |
      | Quote_TC_26 |  | TC_26      |  | WA    |  | Show My Selected Plans |  |    98001 |  | Vision   |

  @Regression_UeS @Validate_VisionPlanPage_Coverage_V_1
  Scenario Outline: "<TestCaseID>" Validate Vision plans page by "<Value>" with COMPARE RATES FOR SELECTED PLANS
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is select the coverage as "<Coverage>" and Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is Fill all the details without salary info of the Census page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES button in "<Coverage>" page
    And UeS_User select plans based on "<Value>" and click on COMPARE RATES FOR SELECTED PLANS button in Vision Plan Information table
    Then UeS_User is verify Monthly Premium and Annual Premium and EMPLOYEE CLASS in Vision Plan Comparison page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value                  |  | Zip Code |  | Coverage |
      | Quote_TC_27 |  | TC_27      |  | CA    |  | Most Popular Plans     |  |    90001 |  | Vision   |
      | Quote_TC_28 |  | TC_28      |  | TX    |  | Show All Plans         |  |    73301 |  | Vision   |
      | Quote_TC_29 |  | TC_29      |  | WA    |  | Show My Selected Plans |  |    98001 |  | Vision   |

  #Oct18 Iteration
  @Regression_UeS @Validate_LifePlanPage_Coverage_L_EmpSalWithOutDependent
  Scenario Outline: "<TestCaseID>" Validate Life Plans Page with only employee and no dependent(with salary)
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is select the coverage as "<Coverage>" and Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is enter Employee Age and Salary without Dependent in Census page and click on next
    Then UeS_User verify PREMIUM for both EMPLOYEE and DEPENDENT in Life Plans page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Zip Code |  | Coverage |
      | Quote_TC_41 |  | TC_41      |  | TX    |  |    73301 |  | Life     |

  @Regression_UeS @Validate_LifePlanPage_Coverage_L_EmpDepndtSal
  Scenario Outline: "<TestCaseID>" Validate Life Plans Page with employee and dependent(with salary)
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is select the coverage as "<Coverage>" and Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is enter Employee Age and Salary with Dependents in Census page and click on next
    Then UeS_User verify PREMIUM for EMPLOYEE and DEPENDENT in Life Plans page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Zip Code |  | Coverage |
      | Quote_TC_42 |  | TC_42      |  | TX    |  |    73301 |  | Life     |

  @Regression_UeS @Validate_LifePlanPage_Coverage_L_EmpWithoutDepndtandSal
  Scenario Outline: "<TestCaseID>" Validate Life Plans Page with only employee no dependent(without salary)
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is select the coverage as "<Coverage>" and Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is enter only Employee Age without Dependents and Salary in Census page and click on next
    Then UeS_User verify LIFEBENEFIT as "<Life Benefit>",PREMIUM as "<Premium>" for both EMPLOYEE and DEPENDENT in Life Plans page
    And UeS_User enter Life Benefit amount in Flat Life Benefit Amount text field as "<Life Benefit Amount>" and click on Go button
    Then UeS_User verify Life Benefit amount as "<Life Benefit Amount>" on Basic Life Plan Information table

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Zip Code |  | Coverage |  | Life Benefit |  | Premium |  | Life Benefit Amount |
      | Quote_TC_43 |  | TC_43      |  | TX    |  |    73301 |  | Life     |  | Multiple     |  | N/A     |  |              10,000 |

  @Regression_UeS @Validate_LifePlanPage_Coverage_L_EmpWithDepndtWithoutSal
  Scenario Outline: "<TestCaseID>" Validate Life Plans Page with employee and dependent(without salary)
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on next
    And UeS_User is select the coverage as "<Coverage>" and Fill all the details of the Quote Setup Page by using "<Zip Code>" and click on NEXT button
    And UeS_User is enter only Employee Age with Dependents and without Salary in Census page and click on next
    Then UeS_User verify LIFEBENEFIT,PREMIUM for EMPLOYEE and PREMIUM for DEPENDENT in Life Plans page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Zip Code |  | Coverage |
      | Quote_TC_44 |  | TC_44      |  | TX    |  |    73301 |  | Life     |

  @Display_STDRates_On_ShortTermPlanComWindow
  Scenario Outline: "<TestCaseID>" Display STD Rates for "<Value>" on Short Term Plan Comparison Window
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on NEXT
    And UeS_User is select all coverages and select the state as "<State>" then Fill all the details on Quote Setup page and click on next
    And UeS_User is enter Employee Age and Salary with Dependents in Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next button
    And UeS_User is Select the Plans from Optional Medical Riders Page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    And UeS_User is Select the Plans Supplemental Employee Life/AD&D Plans Page and click on NEXT button
    And UeS_User is Select the Plans Supplemental Dependent Life/AD&D Plans Page and click on NEXT button
    Then UeS_User verify the Display Plan as "<Value>" on Short Term Disability Plans page
    And UeS_User select plans from Disability Plan Information table on Short Term Disability Plans page
    And UeS_User select PLAN CODES and click on COMPARE SELECTED PLANS button in Disability Plan Information table
    Then UeS_User is verify BENEFIT,MONYHLY PREMIUM as "<Monthly Premium>" and ANNUAL PREMIUM as "<Annual Premium>" in Short Term Disability Plan Details table on STD Plan Comparison page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value              |  | Zip Code |  | Monthly Premium |  | Annual Premium |
      | Quote_TC_45 |  | TC_45      |  | TX    |  | Most Popular Plans |  |    73301 |  | Not Null        |  | Not Null       |
      | Quote_TC_46 |  | TC_46      |  | TX    |  | Show All Plans     |  |    73301 |  | Not Null        |  | Not Null       |

  @Display_STDRates_On_STDRateComparisonWindow
  Scenario Outline: "<TestCaseID>" "<TestCaseID>" Display STD Rates for "<Value>" on Short Term Rate Comparison Window
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on NEXT
    And UeS_User is select all coverages and select the state as "<State>" then Fill all the details on Quote Setup page and click on next
    And UeS_User is enter Employee Age and Salary with Dependents in Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next button
    And UeS_User is Select the Plans from Optional Medical Riders Page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    And UeS_User is Select the Plans Supplemental Employee Life/AD&D Plans Page and click on NEXT button
    And UeS_User is Select the Plans Supplemental Dependent Life/AD&D Plans Page and click on NEXT button
    Then UeS_User verify the Display Plan as "<Value>" on Short Term Disability Plans page
    And UeS_User select plans from Disability Plan Information table on Short Term Disability Plans page
    And UeS_User select PLAN CODES and click on COMPARE RATES FOR SELECTED PLANS button in Disability Plan Information table
    Then UeS_User is verify PLAN CODE,MONYHLY PREMIUM as "<Monthly Premium>" and ANNUAL PREMIUM as "<Annual Premium>" in STD Premiums table on STD Rate Comparison  page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value              |  | Zip Code |  | Monthly Premium |  | Annual Premium |
      | Quote_TC_47 |  | TC_47      |  | TX    |  | Most Popular Plans |  |    73301 |  | Not Null        |  | Not Null       |
      | Quote_TC_48 |  | TC_48      |  | TX    |  | Show All Plans     |  |    73301 |  | Not Null        |  | Not Null       |

  @Display_LTDRates_On_LTDPlanComWindow
  Scenario Outline: "<TestCaseID>" Display LTD Rates for "<Value>" on LTD Plan Comparison Window
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on NEXT
    And UeS_User is select all coverages and select the state as "<State>" then Fill all the details on Quote Setup page and click on next
    And UeS_User is enter Employee Age and Salary with Dependents in Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next button
    And UeS_User is Select the Plans from Optional Medical Riders Page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    And UeS_User is Select the Plans Supplemental Employee Life/AD&D Plans Page and click on NEXT button
    And UeS_User is Select the Plans Supplemental Dependent Life/AD&D Plans Page and click on NEXT button
    Then UeS_User select plan codes from Disability Plan Information table and click on NEXT button in Short Term Disability Plans page
    Then UeS_User verify the Display Plan as "<Value>" on Long Term Disability Plans page
    And UeS_User select PLAN CODES and click on COMPARE SELECTED PLANS button in Disability Plan Information table on Long Term Disability Plans page
    Then UeS_User is verify BENEFIT,MONYHLY PREMIUM as "<Monthly Premium>" and ANNUAL PREMIUM as "<Annual Premium>" in Long Term Disability Plan Details table on LTD Plan Comparison page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value              |  | Zip Code |  | Monthly Premium |  | Annual Premium |
      | Quote_TC_49 |  | TC_49      |  | TX    |  | Most Popular Plans |  |    73301 |  | Not Null        |  | Not Null       |
      | Quote_TC_50 |  | TC_50      |  | TX    |  | Show All Plans     |  |    73301 |  | Not Null        |  | Not Null       |

  @Display_LTDRates_On_LTDRateComWindow
  Scenario Outline: "<TestCaseID>" Display LTD Rates for "<Value>" on LTD Rate Comparison Window
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on NEXT
    And UeS_User is select all coverages and select the state as "<State>" then Fill all the details on Quote Setup page and click on next
    And UeS_User is enter Employee Age and Salary with Dependents in Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next button
    And UeS_User is Select the Plans from Optional Medical Riders Page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    And UeS_User is Select the Plans Supplemental Employee Life/AD&D Plans Page and click on NEXT button
    And UeS_User is Select the Plans Supplemental Dependent Life/AD&D Plans Page and click on NEXT button
    Then UeS_User select plan codes from Disability Plan Information table and click on NEXT button in Short Term Disability Plans page
    Then UeS_User verify the Display Plan as "<Value>" on Long Term Disability Plans page
    And UeS_User select PLAN CODES and click on COMPARE SELECTED PLANS button in Disability Plan Information table on Long Term Disability Plans page
    Then UeS_User is verify EMPLT,MONYHLY PREMIUM as "<Monthly Premium>" and ANNUAL PREMIUM as "<Annual Premium>" in Long Term Disability Plan Details table on LTD Rate Comparison page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value              |  | Zip Code |  | Monthly Premium |  | Annual Premium |
      | Quote_TC_51 |  | TC_51      |  | TX    |  | Most Popular Plans |  |    73301 |  | Not Null        |  | Not Null       |
      | Quote_TC_52 |  | TC_52      |  | TX    |  | Show All Plans     |  |    73301 |  | Not Null        |  | Not Null       |

  @Display_Class1_Class2_Plans_WithSalAndDep
  Scenario Outline: "<TestCaseID>" Display Class Plan Type as "<Class Plan Type>" With Salary With Dependents on Supplemental Employee Life/AD&D Plans page
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on NEXT
    And UeS_User is select all coverages,Fill all details and also enter No Of Classes as "<No Of Classes>" on Quote Setup page
    And UeS_User is click on ENTER CLASS DESCRIPTION button and enter Class Description then click on Submit button
    And Ues_User navigate back to Quote Setup page and click on NEXT button
    And UeS_User is select Class Type,enter Employee Age and Salary with Dependents in Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next button
    And UeS_User is Select the Plans from Optional Medical Riders Page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User verify Class Plan tab as "<Class Plan Type>" and also Class Plan tab value as "<Class Plan Value>" on Supplemental Employee Life/AD&D Plans page
    And UeS_User select PLAN CODES and click on COMPARE RATES FOR SELECTED PLANS button on Supplemental Employee Life/AD&D Plans Page
    Then UeS_User verify Class Plan name as "<Class Plan Name>" and Supplemental Life Class Plan codes on Supplemental Employee Life/AD&D Rate Comparison page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value              |  | No Of Classes |  | Class Plan Type |  | Class Plan Value |  | Class Plan Name |
      | Quote_TC_53 |  | TC_53      |  | TX    |  | Most Popular Plans |  |             2 |  | Class 1 Plans   |  | Class 1 Plans    |  | 1 - Class1      |
      | Quote_TC_55 |  | TC_55      |  | TX    |  | Most Popular Plans |  |             2 |  | Class 2 Plans   |  | Class 2 Plans    |  | 2 - Class2      |

  @Display_Class1_Class2_Plans_WithSalWithoutDep
  Scenario Outline: "<TestCaseID>" Display Class Plan Type as "<Class Plan Type>" With Salary Without Dependents on Supplemental Employee Life/AD&D Plans page
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User is on Home page and click on Quotes and then select New Quote
    And UeS_User is select the state as "<State>" and Fill all the details of the Quote Setup window and click on NEXT
    And UeS_User is select all coverages,Fill all details and also enter No Of Classes as "<No Of Classes>" on Quote Setup page
    And UeS_User is click on ENTER CLASS DESCRIPTION button and enter Class Description then click on Submit button
    And Ues_User navigate back to Quote Setup page and click on NEXT button
    And UeS_User is select Class Type,enter Employee Age and Salary without Dependents in Census page and click on next
    And UeS_User is Select the Plans from Medical Plans Page and click on next button
    And UeS_User is Select the Plans from Optional Medical Riders Page and click on next
    Then UeS_User verify the Display Plan as "<Value>" and select Display Plan as "<Value>" and click on APPLY CHANGES
    And UeS_User is Select the Plans from Dental Plans Page and click on next
    And UeS_User is Select the Plans from Vision Plans Page and click on next
    And UeS_User is Select the Plans from Life Plans Page and click on next
    Then UeS_User verify Class Plan tab as "<Class Plan Type>" and also Class Plan tab value as "<Class Plan Value>" on Supplemental Employee Life/AD&D Plans page
    And UeS_User select PLAN CODES and click on COMPARE RATES FOR SELECTED PLANS button on Supplemental Employee Life/AD&D Plans Page
    Then UeS_User verify Class Plan name as "<Class Plan Name>" and Supplemental Life Class Plan codes on Supplemental Employee Life/AD&D Rate Comparison page

    Examples: 
      | FileName    |  | TestCaseID |  | State |  | Value              |  | No Of Classes |  | Class Plan Type |  | Class Plan Value |  | Class Plan Name |
      | Quote_TC_54 |  | TC_55      |  | TX    |  | Most Popular Plans |  |             2 |  | Class 1 Plans   |  | Class 1 Plans    |  | 1 - Class1      |
      | Quote_TC_56 |  | TC_56      |  | TX    |  | Most Popular Plans |  |             2 |  | Class 2 Plans   |  | Class 2 Plans    |  | 2 - Class2      |

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
      | Test_TC_62 |  | TC_62      |
