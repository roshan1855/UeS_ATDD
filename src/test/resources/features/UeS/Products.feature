Feature: Products Module

  @Products @Regression_UeS @Validate_Products_Home @Suri
  Scenario Outline: "<TestCaseID>" Display of links-Benefit Summaries/Product Grids/Benefit FAQs/other links on Products tab
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User click on Products tab then verifies sub-tabs: Benefit Summaries,Product Grids,Benefit FAQs and Brochures
    And UeS_User verifies the title of the products home as "<Title>"
    Then UeS_User verifies Product sub link pages : Benefit Summaries,Product Grids,Benefit FAQs and Brochures

    Examples: 
      | FileName      |  | TestCaseID |  | Title         |
      | Product_TC_03 |  | TC_03      |  | Products Home |
      
  # July2018    

  @Products_1 @Regression_UeS @Validate_Products_Home @July_Products
  Scenario Outline: "<TestCaseID>" Display U-Invent New Product Idea Submission/UnitedHealthcare Pharmacy Information/www.goldenrule.com links on Products Home Page
 links on Products tab
    When Flow_Fetch fileName "<FileName>" and testCaseID "<TestCaseID>" are captured
    Given Flow_Fetch Data from excel Sheet for "<TestCaseID>"
    Given UeS_User is on Home Page
    When UeS_User Navigate to LogIn Page
    And UeS_User enters UserName and Password
    Then UeS_User displayed Login Successfully
    When UeS_User click on Products tab then verifies links:U-Invent New Product Idea Submission,UnitedHealthcare Pharmacy Information and Goldenrule
    And UeS_User verifies the title of the products home as "<Title>"
    Then UeS_User verifies Product sub link pages : U-Invent New Product Idea Submission,UnitedHealthcare Pharmacy Information and Goldenrule

    Examples: 
      | FileName      |  | TestCaseID |  | Title         |
      | Product_TC_19 |  | TC_19      |  | Products Home |
