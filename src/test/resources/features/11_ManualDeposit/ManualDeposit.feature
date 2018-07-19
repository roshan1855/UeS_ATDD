Feature: Manual Deposit Module

  @Regression @DataIndependent
  Scenario Outline: "<TestCaseID>" Add Manual Deposit for Reason Code "<Reason Code>"
    When ManualDeposit_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given ManualDepositFlow_User is on Home Page
    When ManualDepositFlow_User Navigate to LogIn Page
    And ManualDepositFlow_User enters UserName and Password
    Then ManualDepositFlow_Message displayed Login Successfully
    When ManualDepositFlow_User is on Home page and click on Manual Deposit module
    And ManualDepositFlow_User is click on New Depost button
    When ManualDepositFlow_User is able to enter "<ProducerID>" and select Reason Code  "<Reason Code>"
    And enter all required details
    And ManualDepositFlow_User click on Save button
    And ManualDepositFlow_User is able to enter "<ProducerID>" and Reason Code "<Reason Code>" click on Search button
    Then ManualDepositFlow_User is verified Reason Code "<Reason Code>" with saved details

    Examples: 
      | FileName     |  | TestCaseID |  | Screen               |  | ProducerID |  | Reason Code                  |
      | Test_156_1_F |  | TC_156     |  | MD_AdvanceCheck      |  |     014168 |  | Advance Check                |
      | Test_157_2_F |  | TC_157     |  | MD_PaymentCorrection |  |     000054 |  | Payment Correction           |
      | Test_158_3_F |  | TC_158     |  | MD_TransferDebit     |  |     085038 |  | Transfer Debt ComCalc/BASICS |
      | Test_166_4_F |  | TC_166     |  | MD_Migration Payment |  |     173022 |  | Migration Payment            |

  @Regression @DataIndependent
  Scenario Outline: "<TestCaseID>" Add Manual Deposit of Reason Code "<Reason Code>"
    When ManualDeposit_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given ManualDepositFlow_User is on Home Page
    When ManualDepositFlow_User Navigate to LogIn Page
    And ManualDepositFlow_User enters UserName and Password
    Then ManualDepositFlow_Message displayed Login Successfully
    When ManualDepositFlow_User is on Home page and click on Manual Deposit module
    And ManualDepositFlow_User is click on New Depost button
    When ManualDepositFlow_User is able to enter "<ProducerID>" and select Reason Code  "<Reason Code>"
    And ManualDepositFlow_User is able to enter Mandatory data
    And ManualDepositFlow_User click on Save button
    And ManualDepositFlow_User is able to enter "<ProducerID>" and Reason Code "<Reason Code>" click on Search button
    Then ManualDepositFlow_User is verified Reason Code "<Reason Code>" with saved details

    Examples: 
      | FileName     |  | TestCaseID |  | Screen           |  | ProducerID |  | Reason Code   |
      | Test_159_5_F |  | TC_159     |  | MD_Garnishment   |  |     014168 |  | Garnishment   |
      | Test_160_6_F |  | TC_160     |  | MD_PaymentVoid   |  |     000054 |  | Payment Void  |
      | Test_161_7_F |  | TC_161     |  | MD_Reimbursement |  |     085038 |  | Reimbursement |

  @Regression @DataIndependent
  Scenario Outline: "<TestCaseID>" Add Manual Deposit of Reason Code "<Reason Code>" for Medica Alliance statement
    When ManualDeposit_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given ManualDepositFlow_User is on Home Page
    When ManualDepositFlow_User Navigate to LogIn Page
    And ManualDepositFlow_User enters UserName and Password
    Then ManualDepositFlow_Message displayed Login Successfully
    When ManualDepositFlow_User is on Home page and click on Manual Deposit module
    And ManualDepositFlow_User is click on New Depost button
    When ManualDepositFlow_User is able to enter "<ProducerID>" and select Reason Code  "<Reason Code>"
    And ManualDepositFlow_User is able to select Alliance Statement  "<Alliance Statement>"
    And ManualDepositFlow_User is able to enter all mandatory details
    And ManualDepositFlow_User click on Save button
    And ManualDepositFlow_User is able to enter "<ProducerID>" and Reason Code "<Reason Code>" click on Search button
    Then ManualDepositFlow_User is verified Reason Code "<Reason Code>" and  Alliance Statement "<Alliance Statement>" with saved details

    Examples: 
      | FileName     |  | TestCaseID |  | Screen                      |  | ProducerID |  | Reason Code        |  | Alliance Statement |
      | Test_162_8_F |  | TC_162     |  | MD_AdvanceCheck_Medica      |  |     000064 |  | Advance Check      |  | Medica             |
      | Test_163_9_F |  | TC_163     |  | MD_PaymentCorrection_Medica |  |     139562 |  | Payment Correction |  | Medica             |

  @Regression @DataIndependent
  Scenario Outline: "<TestCaseID>" Add Manual Deposit of Garnishment Reason code for Medica Alliance statement
    When ManualDeposit_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given ManualDepositFlow_User is on Home Page
    When ManualDepositFlow_User Navigate to LogIn Page
    And ManualDepositFlow_User enters UserName and Password
    Then ManualDepositFlow_Message displayed Login Successfully
    When ManualDepositFlow_User is on Home page and click on Manual Deposit module
    And ManualDepositFlow_User is click on New Depost button
    When ManualDepositFlow_User is able to enter "<ProducerID>" and select Reason Code  "<Reason Code>"
    And ManualDepositFlow_User is able to select Alliance Statement  "<Alliance Statement>"
    And ManualDepositFlow_User is able to enter all Mandatory Details
    And ManualDepositFlow_User click on Save button
    And ManualDepositFlow_User is able to enter "<ProducerID>" and Reason Code "<Reason Code>" click on Search button
    Then ManualDepositFlow_User is verified Reason Code "<Reason Code>" and  Alliance Statement "<Alliance Statement>" with saved details

    Examples: 
      | FileName      |  | TestCaseID |  | Screen                |  | ProducerID |  | Reason Code |  | Alliance Statement |
      | Test_164_10_F |  | TC_164     |  | MD_Garnishment_Medica |  |     000064 |  | Garnishment |  | Medica             |

  @Regression @DataIndependent
  Scenario Outline: "<TestCaseID>" Add Manual Deposit of write off code for Medica Alliance statement
    When ManualDeposit_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given ManualDepositFlow_User is on Home Page
    When ManualDepositFlow_User Navigate to LogIn Page
    And ManualDepositFlow_User enters UserName and Password
    Then ManualDepositFlow_Message displayed Login Successfully
    When ManualDepositFlow_User is on Home page and click on Manual Deposit module
    And ManualDepositFlow_User is click on New Depost button
    When ManualDepositFlow_User is able to enter "<ProducerID>" and select Reason Code  "<Reason Code>"
    And ManualDepositFlow_User is able to select Alliance Statement  "<Alliance Statement>"
    And ManualDepositFlow_User is able to enter all mandatory and GL Debit details
    And ManualDepositFlow_User is able to enter GL Credit details
    And ManualDepositFlow_User click on Save button
    And ManualDepositFlow_User is able to enter "<ProducerID>" and Reason Code "<Reason Code>" click on Search button
    Then ManualDepositFlow_User is verified Reason Code "<Reason Code>" and  Alliance Statement "<Alliance Statement>" with saved details

    Examples: 
      | FileName      |  | TestCaseID |  | Screen             |  | ProducerID |  | Reason Code |  | Alliance Statement |
      | Test_165_11_F |  | TC_165     |  | MD_Writeoff_Medica |  |     066564 |  | Writeoff    |  | Medica             |

  @Regression @DataIndependent
  Scenario Outline: "<TestCaseID>" Selected record fields data are disabled state
    When ManualDeposit_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given ManualDepositFlow_User is on Home Page
    When ManualDepositFlow_User Navigate to LogIn Page
    And ManualDepositFlow_User enters UserName and Password
    Then ManualDepositFlow_Message displayed Login Successfully
    When ManualDepositFlow_User is on Home page and click on Manual Deposit module
    And ManualDepositFlow_User is able to enter "<ProducerID>" and Reason Code "<Reason Code>" click on Search button
    When ManualDepositFlow_User is able to select record and click on View button
    Then ManualDepositFlow_User is verified whether data are disabled or enabled

    Examples: 
      | FileName      |  | TestCaseID |  | Screen         |  | ProducerID |  | Reason Code   |
      | Test_167_12_F |  | TC_167     |  | MD_View Record |  |     014168 |  | Advance Check |

  @Regression @DataIndependent
  Scenario Outline: "<TestCaseID>" Newly created record status changed to Approved
    When ManualDeposit_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given ManualDepositFlow_User is on Home Page
    When ManualDepositFlow_User Navigate to LogIn Page
    And ManualDepositFlow_User enters UserName and Password
    Then ManualDepositFlow_Message displayed Login Successfully
    When ManualDepositFlow_User is on Home page and click on Manual Deposit module
    And ManualDepositFlow_User is able to enter "<ProducerID>" and click on Search button
    When ManualDepositFlow_User is able to select Newly created record and click on Approve button
    Then ManualDepositFlow_User is verified whether status got changed to Approved or not

    Examples: 
      | FileName      |  | TestCaseID |  | Screen      |  | ProducerID |
      | Test_168_13_F |  | TC_168     |  | MD_Approved |  |     014168 |

  @Regression @DataIndependent
  Scenario Outline: "<TestCaseID>" Approved record status changed to Deleted
    When ManualDeposit_fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given ManualDepositFlow_User is on Home Page
    When ManualDepositFlow_User Navigate to LogIn Page
    And ManualDepositFlow_User enters UserName and Password
    Then ManualDepositFlow_Message displayed Login Successfully
    When ManualDepositFlow_User is on Home page and click on Manual Deposit module
    And ManualDepositFlow_User is able to enter "<ProducerID>" and click on Search button
    When ManualDepositFlow_User is able to select Appoved record and click on UnApprove button
    Then ManualDepositFlow_User is verified whether status got changed to Deleted or not

    Examples: 
      | FileName      |  | TestCaseID |  | Screen         |  | ProducerID |
      | Test_169_14_F |  | TC_169     |  | MD_Un-Approved |  |     014168 |
