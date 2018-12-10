package com.optum.synergy.ues.ui.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.optum.synergy.ues.ui.pageobjects.CompensationPage;
import com.optum.synergy.ues.ui.pageobjects.LoginScreen;
import com.optum.synergy.ues.ui.pageobjects.QuotePage;
import com.optum.synergy.ues.ui.utilities.Utilities;
import cucumber.api.java.en.*;

public class QuoteDef {
	static WebDriver driver;
	public static WebElement element;
	public static JavascriptExecutor executor;
	Utilities utility = new Utilities();
	String fileName = utility.generateUniqueFileName();
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent1 = new ExtentReports();
	public static ExtentTest feature;
	public static ExtentTest scenario;
	public static LoginScreen ls;
	public static String fileExtension;
	public static String resourceName;
	public static ClassLoader loader;
	public static Properties autoProperties;
	public static String reportName;
	public static String testCaseID;
	public static String screenName;
	public static String customerID;
	public static String browserType;
	public static CommonLibrary common;
	public static String startDatePresent;
	public static String startDateHomeScreen;
	public static String startDateHS;
	public static String cridHomeScreen;
	public static String customerId;
	public static String parentWindow;
	DesiredCapabilities ieCapabilities;
	public static QuotePage quotepage;

	By ckhBoxProductTypeMedical = By.xpath("//input[@name='selectProductTypeMedical']");
	By ckhBoxProductTypeDental = By.xpath("//input[@name='selectProductTypeDental']");
	By ckhBoxProductTypeLife = By.xpath("//input[@name='selectProductTypeLife']");
	By ckhBoxProductTypeVision = By.xpath("//input[@name='selectProductTypeVision']");
	By ckhBoxProductTypeStd = By.xpath("//input[@name='selectProductTypeStd']");
	By ckhBoxProductTypeLtd = By.xpath("//input[@name='selectProductTypeLtd']");
	By ckhBoxProductTypeEmpSupLife = By.xpath("//input[@name='selectProductTypeEmpSupLife']");
	By ckhBoxProductTypeDepSupLife = By.xpath("//input[@name='selectProductTypeDepSupLife']");

	public static CompensationPage compensationpage;

	public QuoteDef() throws IOException {
		System.out.println("**** Begin UeS Application Execution() ***** ");
		driver = Hooks.driver;
		utility = new Utilities();
		autoProperties = Hooks.autoProperties;

		/*
		 * mhold = PageFactory.initElements(driver, ManualHold.class); SFA =
		 * PageFactory.initElements(driver, ServiceFeeAgreement.class); vcc =
		 * PageFactory.initElements(driver, VCCScreen.class); search =
		 * PageFactory.initElements(driver, SearchScreen.class);
		 */
		common = new CommonLibrary();
		quotepage = new QuotePage();
		compensationpage = new CompensationPage();

	}

	@When("^UeS_UserFlow_fileName \"([^\"]*)\" and testCaseID \"([^\"]*)\" are captured$")
	public void ues_userflow_filename_and_testCaseID_are_captured(String arg1, String arg2) throws Throwable {
		reportName = arg1;
		testCaseID = arg2;
		utility.CreateReport(reportName, testCaseID);

	}

	@Given("^UeS_User is on Home Page$")
	public void ues_user_is_on_Home_Page() throws Throwable {
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get(autoProperties.getProperty("BFX_URL"));
		driver.get(autoProperties.getProperty("STAGE_URL"));
		utility.takeScreenShot(driver, "Homepage" + testCaseID);
		utility.GenerateReport("Quote", "", "info", "Execution Started.User is on the login Page",
				"Homepage" + testCaseID);
	}

	@When("^UeS_User Navigate to LogIn Page$")
	public void ues_user_Navigate_to_LogIn_Page() throws Throwable {
		System.out.println("DIRECTORY \t" + System.getProperty("user.dir"));
		quotepage.verifyLoginPage(driver);
		utility.takeScreenShot(driver, "Homepage" + testCaseID);
		utility.GenerateReport("Quote", "", "info", "Execution Started.User is on the login Page",
				"Homepage" + testCaseID);

	}

	@When("^UeS_User enters UserName and Password$")
	public void ues_user_enters_UserName_and_Password() throws Throwable {
		// Thread.sleep(1000);

		/*
		 * ls = PageFactory.initElements(driver, LoginScreen.class);
		 * ls.setUserName(driver, "PU1"); utility.takeScreenShot(driver,
		 * "username" + testCaseID); utility.GenerateReport("Quote",
		 * "Scenario Headline", "pass", "User is able to set UserName",
		 * "username" + testCaseID); ls.setPassword(driver, "B4s1cNP1");
		 * driver.findElement(By.xpath("//input[@value='Submit']")).sendKeys(
		 * Keys.ENTER);
		 */
		quotepage.loginUeSApp(driver);
	}

	@Then("^UeS_User displayed Login Successfully$")
	public void ues_user_displayed_Login_Successfully() throws Throwable {
		quotepage.verifyUeSLogos_Home(driver);
		System.out.println("UeS Login Successfully done");
		utility.takeScreenShot(driver, "Login");
		utility.GenerateReport("", "", "info", "UeS Login is successfully completed", "Login");
	}

	@Given("^UeS_User is on UeS Login page$")
	public void ues_user_is_on_UeS_Login_page() throws Throwable {
		quotepage.pageUeSLogin();
	}

	@When("^UeS_User enters UserName Password and click on login button$")
	public void ues_user_enters_UserName_Password_and_click_on_login_button() throws Throwable {
		quotepage.username_pwd();
	}

	@Then("^UeS_User displayed message Login Successfully$")
	public void ues_user_displayed_message_Login_Successfully() throws Throwable {
		System.out.println("UeS Login Successfully");
	}

	@When("^UeS_User is on Home page and click on Quotes and then select New Quote$")
	public void ues_user_is_on_Home_page_and_click_on_Quotes_and_then_select_New_Quote() throws Throwable {
		quotepage.clickQuote_NewQuote(driver);
	}

	@When("^UeS_User is Fill all the details of the Quote Setup Page and click on next$")
	public void ues_user_is_Fill_all_the_details_of_the_Quote_Setup_Page_and_click_on_next() throws Throwable {
		quotepage.quoteSetupPage(driver);
	}

	@When("^Ues_user choose medical and vision coverage and fill the details on quote information page$")
	public void Ues_user_choose_medical_and_vision_coverage_and_fill_the_details_on_quote_information_page()
			throws Throwable {
		quotepage.M_V_quoteSetupPage(driver);
	}

	@Then("^Ues_user choose dental vision and life coverage and fill the details on quote information page$")
	public void Ues_user_choose_dental_vision_and_life_coverage_and_fill_the_details_on_quote_information_page()
			throws Throwable {
		quotepage.M_V_quoteSetupPage(driver);
	}

	@When("^UeS_User is Fill all the details of the Census page and click on next$")
	public void ues_user_is_Fill_all_the_details_of_the_Census_page_and_click_on_next() throws Throwable {
		quotepage.censusPage(driver);
	}

	/*
	 * @Then("^Ues_user choose dental vision and life coverage and fill the details on\"([^\"]*)\" quote information page$"
	 * ) public void
	 * ues_userChooseDentalVisionAndLifeCoverageAndFillTheDetailsOnQuoteInformationPage
	 * (String coverage) throws Throwable {
	 * quotepage.D_V_L_quoteSetupPage(driver, coverage); }
	 */

	@Then("^Ues_user choose \"([^\"]*)\" coverage and fill the details on quote information page$")
	public void ues_userChooseCoverageAndFillTheDetailsOnQuoteInformationPage(String coverage) throws Throwable {
		quotepage.D_V_L_quoteSetupPage(driver, coverage);
	}

	@When("^UeS_User_should_fill_Census_page_with_Dep_without_Salary_EE_only_and_click_on_next$")
	public void UeS_User_should_fill_Census_page_with_Dep_without_Salary_EE_only_and_click_on_next() throws Throwable {
		quotepage.censusPage_Dep_EE_WithoutSalary(driver);
	}

	@When("^UeS_User is Fill all the details without salary info of the Census page and click on next$")
	public void ues_userIsFillAllTheDetailsWithoutSalaryInfoOfTheCensusPageAndClickOnNext() throws Throwable {
		quotepage.censusPageWithOutSal(driver);
	}

	@Then("^UeS_User click on Preview Proposal button and verify Preview Proposal PDf is displayed successfully$")
	public void ues_user_click_on_Preview_Proposal_button_and_verify_Preview_Proposal_PDf_is_displayed_successfully()
			throws Throwable {
		quotepage.proposalInformationPage(driver);
		quotepage.tearDown(driver);
	}

	@When("^UeS_User is Select the Plans from Medical Plans Page and click on next$")
	public void ues_user_is_Select_the_Plans_from_Medical_Plans_Page_and_click_on_next() throws Throwable {
		quotepage.medicalPlanPage(driver);
	}

	@When("^UeS_User is Select the Plans from Vision Plans Page and click on next$")
	public void ues_user_is_Select_the_Plans_from_Vision_Plans_Page_and_click_on_next() throws Throwable {
		quotepage.visionPlanPage(driver);
	}

	@When("^UeS_User is Select the Plans from Dental Plans Page and click on next$")
	public void ues_userIsSelectThePlansFromDentalPlansPageAndClickOnNext() throws Throwable {
		quotepage.dentalPlanPage(driver);
	}

	@When("^UeS_User is Select the Plans from Life Plans Page and click on next$")
	public void ues_userIsSelectThePlansFromLifePlansPageAndClickOnNext() throws Throwable {
		quotepage.lifePlanPage(driver);
	}

	@When("^UeS_User enters UserName as \"([^\"]*)\" Password as \"([^\"]*)\" and click on login button$")
	public void ues_user_enters_UserName_as_Password_as_and_click_on_login_button(String usrname, String pwd)
			throws Throwable {
		quotepage.loginUeS(usrname, pwd);
	}

	@When("^UeS_User is Fill all the details of the Census page and click on COMPARE RATES FOR SELECTED PLANS button$")
	public void ues_user_is_Fill_all_the_details_of_the_Census_page_and_click_on_COMPARE_RATES_FOR_SELECTED_PLANS_button()
			throws Throwable {
		// quotepage.censusPage_clickCOMPARERATE();
	}

	@Then("^UeS_User verify user name as \"([^\"]*)\" is displayed successfully in Home page$")
	public void ues_user_verify_user_name_as_is_displayed_successfully_in_Home_page(String arg1) throws Throwable {
		quotepage.verifyLogin(arg1, driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User verify Age is displayed successfully under Medical Rate Comparison page$")
	public void ues_user_verify_Age_is_displayed_successfully_under_Medical_Rate_Comparison_page() throws Throwable {
		// quotepage.verifyAge(driver);
	}

	@When("^UeS_User click on Administration link and then click on Modify Logging Levels link$")
	public void ues_user_click_on_Administration_link_and_then_click_on_Modify_Logging_Levels_link() throws Throwable {
		quotepage.clickLink_Administration_ModifyLoggingLevels(driver);
	}

	@When("^UeS_User select values from Application and Logging Level dropdowns then click on Sumit btton$")
	public void ues_user_select_values_from_Application_and_Logging_Level_dropdowns_then_click_on_Sumit_btton()
			throws Throwable {
		quotepage.selectDropdown_Application_LoggingLevel(driver);
	}

	@Then("^UeS_User verify the message 'Modify Logging Levels Success'$")
	public void ues_user_verify_the_message_Modify_Logging_Levels_Success() throws Throwable {
		quotepage.verifyMessage(driver);
		quotepage.tearDown(driver);
	}

	@When("^UeS_User is Fill all the details of the Census page and click on Next button$")
	public void ues_user_is_Fill_all_the_details_of_the_Census_page_and_click_on_Next_button() throws Throwable {
		quotepage.censusPage_clickNext(driver);
	}

	@Then("^UeS_User verify error message 'Employees age must be greater than (\\d+)' under Census page$")
	public void ues_user_verify_error_message_Employees_age_must_be_greater_than_under_Census_page(int arg1)
			throws Throwable {
		quotepage.verifyErrMessage(driver);
		quotepage.tearDown(driver);
	}

	@When("^UeS_User is select the state as \"([^\"]*)\" and Fill all the details of the Quote Setup window and click on next$")
	public void ues_userIsSelectTheStateAsAndFillAllTheDetailsOfTheQuoteSetupWindowAndClickOnNext(String arg1)
			throws Throwable {
		quotepage.quoteSetUpWindow(driver, arg1);
	}
	
	@When("^UeS_User is select the state as \"([^\"]*)\" and Fill all the details of the Quote Setup window and click on NEXT$")
	public void ues_userIsSelectTheStateAsAndFillAllTheDetailsOfTheQuoteSetupWindowAndClickOnNEXT(String arg1)
			throws Throwable {
		quotepage.quoteSetUpWindow_Coverage_All(driver, arg1);
	}
	

	@When("^UeS_User is Fill all the details of the Quote Setup Page by using \"([^\"]*)\" and click on next button$")
	public void ues_userIsFillAllTheDetailsOfTheQuoteSetupPageByUsingAndClickOnNextButton(String arg1)
			throws Throwable {
		quotepage.QuoteSetUpPage(driver, arg1);
	}

	@Then("^UeS_User verify Rating Method as \"([^\"]*)\"$")
	public void ues_userVerifyRatingMethodAs(String arg1) throws Throwable {
		quotepage.verifyRatingMethodValue(driver, arg1);
	}

	@Then("^UeS_User is Select the Plans from Medical Plans Page and click on Compare Rates For Selected Plans button$")
	public void ues_userIsSelectThePlansFromMedicalPlansPageAndClickOnCompareRatesForSelectedPlansButton()
			throws Throwable {
		quotepage.medicalPlan_btnComparePlan(driver);
	}

	@Then("^UeS_User is verify EMPLOYEE CLASS in Medical Rate Comparison page by using \"([^\"]*)\"$")
	public void ues_userIsVerifyEMPLOYEECLASSInMedicalRateComparisonPageByUsing(String arg1) throws Throwable {
		quotepage.pageMedicalRateComparison(driver, arg1);
	}

	@Then("^UeS_User is navigate back to Medical Plans Page and click on next$")
	public void ues_userIsNavigateBackToMedicalPlansPageAndClickOnNext() throws Throwable {
		quotepage.btnMedicalPlansubmitNext(driver);
	}

	@Then("^UeS_User is Select the Plans from Optional Medical Riders Page and click on next$")
	public void ues_userIsSelectThePlansFromOptionalMedicalRidersPageAndClickOnNext() throws Throwable {
		quotepage.pageOptionalMedicalRiders(driver);
	}

	@Then("^UeS_User click on GENERATE FINAL PROPOSAL button and verify Preview Proposal PDf is displayed successfully$")
	public void ues_userClickOnGENERATEFINALPROPOSALButtonAndVerifyPreviewProposalPDfIsDisplayedSuccessfully()
			throws Throwable {
		quotepage.btnSubmitGenerateProposal(driver);
		quotepage.tearDown(driver);
	}

	@When("^fill all details$")
	public void fillAllDetails() throws Throwable {
		quotepage.testingUeS(driver);
	}

	@Then("^UeS_User click on GENERATE FINAL PROPOSAL(\\d+) button and verify Preview Proposal PDf is displayed successfully$")
	public void ues_userClickOnGENERATEFINALPROPOSALButtonAndVerifyPreviewProposalPDfIsDisplayedSuccessfully(int arg1)
			throws Throwable {
		System.out.println("Final Page");
		quotepage.tearDown(driver);
	}

	// August18

	@When("^UeS_User is Fill all the details of the Quote Setup Page by using \"([^\"]*)\" and click on NEXT button$")
	public void ues_userIsFillAllTheDetailsOfTheQuoteSetupPageByUsingAndClickOnNEXTButton(String arg1)
			throws Throwable {
		quotepage.dentalQuoteSetUpPage(driver, arg1);
	}

	@Then("^UeS_User verify the Display Plan as \"([^\"]*)\" and select Display Plan as \"([^\"]*)\" and click on APPLY CHANGES button$")
	public void ues_userVerifyTheDisplayPlanAsAndSelectDisplayPlanAsAndClickOnAPPLYCHANGESButton(String arg1,
			String arg2) throws Throwable {
		quotepage.verifyDisplayPlans_SelectPlanCode(driver, arg1);
	}

	@Then("^UeS_User is Select the ADD TO PROPOSAL checkboxes and click on COMPARE SELECTED PLANS button$")
	public void ues_userIsSelectTheADDTOPROPOSALCheckboxesAndClickOnCOMPARESELECTEDPLANSButton() throws Throwable {
		quotepage.verifyANNUALPREMIUM_BENEFIT(driver);
	}

	@Then("^UeS_User is verify ANNUAL PREMIUM and BENEFIT in Dental Plan Comparison page$")
	public void ues_userIsVerifyANNUALPREMIUMAndBENEFITInDentalPlanComparisonPage() throws Throwable {
		quotepage.verifyANNUALPREMIUM_BENEFIT(driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User verify the Display Plan as \"([^\"]*)\" and select Display Plan as \"([^\"]*)\" and selct plans then click on COMPARE RATES FOR SELECTED PLANS button$")
	public void ues_userVerifyTheDisplayPlanAsAndSelectDisplayPlanAsAndSelctPlansThenClickOnCOMPARERATESFORSELECTEDPLANSButton(
			String arg1, String arg2) throws Throwable {
		quotepage.verifyDisplayPlans_SelectPlanCode_CompareRates(driver, arg1);
	}

	@When("^UeS_User is select the coverage as \"([^\"]*)\" and Fill all the details of the Quote Setup Page by using \"([^\"]*)\" and click on NEXT button$")
	public void ues_userIsSelectTheCoverageAsAndFillAllTheDetailsOfTheQuoteSetupPageByUsingAndClickOnNEXTButton(
			String arg1, String arg2) throws Throwable {
		quotepage.quoteSetUpPageNew(driver, arg1, arg2);
	}

	@Then("^UeS_User verify the Display Plan as \"([^\"]*)\" and select Display Plan as \"([^\"]*)\" and click on APPLY CHANGES button in \"([^\"]*)\" page$")
	public void ues_userVerifyTheDisplayPlanAsAndSelectDisplayPlanAsAndClickOnAPPLYCHANGESButtonInPage(String arg1,
			String arg2, String arg3) throws Throwable {
		quotepage.verifyDisplayPlans_clickBtnCOMPSELPLAN(driver, arg1);
	}

	@Then("^UeS_User select plans based on \"([^\"]*)\" and click on COMPARE SELECTED PLANS button in Vision Plan Information table$")
	public void ues_userSelectPlansBasedOnAndClickOnCOMPARESELECTEDPLANSButtonInVisionPlanInformationTable(String arg1)
			throws Throwable {
		System.out.println("User selected plan and click on COMPARE SELECTED RATES");
	}

	@Then("^UeS_User is verify ANNUL PREMIUM and BENEFIT in  Vision Plan Comparison  page$")
	public void ues_userIsVerifyANNULPREMIUMAndBENEFITInVisionPlanComparisonPage() throws Throwable {
		quotepage.verifyANNUALPREMIUM_BENEFIT_Vision(driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User is verify Employer Contribution Premium and Total Annual Premium and EMPLOYEE CLASS in Dental Rate Comparison page$")
	public void ues_userIsVerifyEmployerContributionPremiumAndTotalAnnualPremiumAndEMPLOYEECLASSInDentalRateComparisonPage()
			throws Throwable {
		quotepage.verifyTotalAnnualPremium_ContributionPremium_EMPLOYEECLASS(driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User select plans based on \"([^\"]*)\" and click on COMPARE RATES FOR SELECTED PLANS button in Vision Plan Information table$")
	public void ues_userSelectPlansBasedOnAndClickOnCOMPARERATESFORSELECTEDPLANSButtonInVisionPlanInformationTable(
			String arg1) throws Throwable {
		System.out.println("User selected plan and click on COMPARE RATES FOR SELECTED PLANS button");
	}

	@Then("^UeS_User is verify Monthly Premium and Annual Premium and EMPLOYEE CLASS in Vision Plan Comparison page$")
	public void ues_userIsVerifyMonthlyPremiumAndAnnualPremiumAndEMPLOYEECLASSInVisionPlanComparisonPage()
			throws Throwable {
		quotepage.verifyMonthlyPremium_AnnualPremium_EMPLOYEECLASS(driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User verify the Display Plan as \"([^\"]*)\" and select Display Plan as \"([^\"]*)\" then click on APPLY CHANGES button$")
	public void ues_userVerifyTheDisplayPlanAsAndSelectDisplayPlanAsThenClickOnAPPLYCHANGESButton(String arg1,
			String arg2) throws Throwable {
		quotepage.verifyDisplayPlan_SelectPlanCode(driver, arg1);
	}

	@Then("^UeS_User verify HMO tab in Dental Plans page and then click on HMO tab$")
	public void ues_userVerifyHMOTabInDentalPlansPageAndThenClickOnHMOTab() throws Throwable {
		quotepage.verifyHMO_clikHMOTab(driver);
	}

	@Then("^UeS_User is verify DHMO data displayed on Dental HMO Plan Information table based on \"([^\"]*)\"$")
	public void ues_userIsVerifyDHMODataDisplayedOnDentalHMOPlanInformationTableBasedOn(String arg1) throws Throwable {
		quotepage.verifyDisplayPlans_SelectPlanCode_HMO(driver, arg1);
		quotepage.tearDown(driver);
	}

	// OCT18 Iteration
	@When("^UeS_User is enter Employee Age and Salary without Dependent in Census page and click on next$")
	public void ues_userIsEnterEmployeeAgeAndSalaryWithoutDependentInCensusPageAndClickOnNext() throws Throwable {
		quotepage.censusPage_EmpAge_WithSal_WithoutDependent(driver);
	}

	@Then("^UeS_User verify PREMIUM for both EMPLOYEE and DEPENDENT in Life Plans page$")
	public void ues_userVerifyPREMIUMForBothEMPLOYEEAndDEPENDENTInLifePlansPage() throws Throwable {
		// System.out.println("Life Plan page displayed successfully");
		quotepage.verifyLifePlansPage_PREMIUM(driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User verify PREMIUM for EMPLOYEE and DEPENDENT in Life Plans page$")
	public void ues_userVerifyPREMIUMForEMPLOYEEAndDEPENDENTInLifePlansPage() throws Throwable {
		quotepage.verifyLifePlansPage_PREMIUM_EmpWithDepandSal(driver);
		quotepage.tearDown(driver);
	}

	@When("^UeS_User is enter Employee Age and Salary with Dependents in Census page and click on next$")
	public void ues_userIsEnterEmployeeAgeAndSalaryWithDependentsInCensusPageAndClickOnNext() throws Throwable {
		//quotepage.censusPage(driver);
		quotepage.censusPage_Class1_2_Plans(driver);
	}

	@When("^UeS_User is enter only Employee Age without Dependents and Salary in Census page and click on next$")
	public void ues_userIsEnterOnlyEmployeeAgeWithoutDependentsAndSalaryInCensusPageAndClickOnNext() throws Throwable {
		quotepage.censusPageWithOutSal(driver);
	}

	@Then("^UeS_User verify LIFEBENEFIT,PREMIUM for both EMPLOYEE and DEPENDENT in Life Plans page$")
	public void ues_userVerifyLIFEBENEFITPREMIUMForBothEMPLOYEEAndDEPENDENTInLifePlansPage() throws Throwable {
		// quotepage.verifyLifePlansPage_PREMIUM_EMPWithoutDepSal(driver);
		// quotepage.tearDown(driver);
	}

	@When("^UeS_User is enter only Employee Age with Dependents and without Salary in Census page and click on next$")
	public void ues_userIsEnterOnlyEmployeeAgeWithDependentsAndWithoutSalaryInCensusPageAndClickOnNext()
			throws Throwable {
		quotepage.censusPage_EmpWithDepndntWithoutSal(driver);
	}

	@Then("^UeS_User verify LIFEBENEFIT,PREMIUM for EMPLOYEE and PREMIUM for DEPENDENT in Life Plans page$")
	public void ues_userVerifyLIFEBENEFITPREMIUMForEMPLOYEEAndPREMIUMForDEPENDENTInLifePlansPage() throws Throwable {
		quotepage.verifyLifePlansPage_PREMIUM_EMPWithDepWithoutSal(driver);
		quotepage.tearDown(driver);
	}

	@When("^UeS_User is select all coverages and select the state as \"([^\"]*)\" then Fill all the details on Quote Setup page and click on next$")
	public void ues_userIsSelectAllCoveragesAndSelectTheStateAsThenFillAllTheDetailsOnQuoteSetupPageAndClickOnNext(
			String arg1) throws Throwable {
		quotepage.quoteSetUpPage_SelectAllCoverages(driver, arg1);
	}

	@Then("^UeS_User select plan on Dental PPO/Indemnity Plan Information table then click on NEXT button$")
	public void ues_userSelectPlanOnDentalPPOIndemnityPlanInformationTableThenClickOnNEXTButton() throws Throwable {

	}

	@Then("^UeS_User is Select the Plans Supplemental Employee Life/AD&D Plans Page and click on NEXT button$")
	public void ues_userIsSelectThePlansSupplementalEmployeeLifeADDPlansPageAndClickOnNEXTButton() throws Throwable {
		quotepage.page_SupplementalEmployeeLife(driver);
	}

	@Then("^UeS_User is Select the Plans Supplemental Dependent Life/AD&D Plans Page and click on NEXT button$")
	public void ues_userIsSelectThePlansSupplementalDependentLifeADDPlansPageAndClickOnNEXTButton() throws Throwable {
		quotepage.page_SupplementalDependentLife(driver);
	}

	@Then("^UeS_User verify the Display Plan as \"([^\"]*)\" on Short Term Disability Plans page$")
	public void ues_userVerifyTheDisplayPlanAsOnShortTermDisabilityPlansPage(String arg1) throws Throwable {
		quotepage.page_ShortTermDisabilityPlans(driver, arg1);
	}
	
	@Then("^UeS_User verify the Display Plan as \"([^\"]*)\" on Long Term Disability Plans page$")
	public void ues_userVerifyTheDisplayPlanAsOnLongTermDisabilityPlansPage(String arg1) throws Throwable {
		quotepage.page_LongTermDisabilityPlans(driver, arg1);
	}

	@Then("^UeS_User select plans from Disability Plan Information table on Short Term Disability Plans page$")
	public void ues_userSelectPlansFromDisabilityPlanInformationTableOnShortTermDisabilityPlansPage() throws Throwable {
		quotepage.selectPlanCode_ShortTermDisabilityPlans(driver);
	}

	@Then("^UeS_User select PLAN CODES and click on COMPARE SELECTED PLANS button in Disability Plan Information table$")
	public void ues_userSelectPLANCODESAndClickOnCOMPARESELECTEDPLANSButtonInDisabilityPlanInformationTable()
			throws Throwable {
		System.out.println("User selected plans from Disability Plan Information table");
	}

	@Then("^UeS_User is verify BENEFIT,MONYHLY PREMIUM and ANNUAL PREMIUM inShort Term Disability Plan Details on STD Plan Comparison page$")
	public void ues_userIsVerifyBENEFITMONYHLYPREMIUMAndANNUALPREMIUMInShortTermDisabilityPlanDetailsOnSTDPlanComparisonPage()
			throws Throwable {
		quotepage.verify_BENEFITCODE_MONTHLYPREMIUM_ANNUALPREMIUM(driver);
		quotepage.tearDown(driver);
	}

	@When("^UeS_User is Select the Plans from Medical Plans Page and click on next button$")
	public void ues_user_is_Select_the_Plans_from_Medical_Plans_Page_and_click_on_next_button() throws Throwable {
		quotepage.medicalPlanPage_1(driver);
	}

	@Then("^UeS_User verify the Display Plan as \"([^\"]*)\" and select Display Plan as \"([^\"]*)\" and click on APPLY CHANGES$")
	public void ues_userVerifyTheDisplayPlanAsAndSelectDisplayPlanAsAndClickOnAPPLYCHANGES(String arg1, String arg2)
			throws Throwable {
		quotepage.verifyDisplayPlans_clickBtnApplyChanges(driver, arg1);
	}

	@Then("^UeS_User verify LIFEBENEFIT as \"([^\"]*)\",PREMIUM as \"([^\"]*)\" for both EMPLOYEE and DEPENDENT in Life Plans page$")
	public void ues_userVerifyLIFEBENEFITAsPREMIUMAsForBothEMPLOYEEAndDEPENDENTInLifePlansPage(String arg1, String arg2)
			throws Throwable {
		quotepage.verifyLifePlansPage_PREMIUM_EMPWithoutDepSal(driver, arg1, arg2);
	}

	@Then("^UeS_User enter Life Benefit amount in Flat Life Benefit Amount text field as \"([^\"]*)\" and click on Go button$")
	public void ues_userEnterLifeBenefitAmountInFlatLifeBenefitAmountTextFieldAsAndClickOnGoButton(String arg1)
			throws Throwable {
		quotepage.enterLifeBenefitAmount(driver, arg1);
	}

	@Then("^UeS_User verify Life Benefit amount as \"([^\"]*)\" on Basic Life Plan Information table$")
	public void ues_userVerifyLifeBenefitAmountAsOnBasicLifePlanInformationTable(String arg1) throws Throwable {
		quotepage.verifyLifeBenefitAmount(driver, arg1);
		quotepage.tearDown(driver);
	}
	
	@Then("^UeS_User is verify BENEFIT,MONYHLY PREMIUM as \"([^\"]*)\" and ANNUAL PREMIUM as \"([^\"]*)\" in Short Term Disability Plan Details table on STD Plan Comparison page$")
	public void ues_userIsVerifyBENEFITMONYHLYPREMIUMAsAndANNUALPREMIUMAsInShortTermDisabilityPlanDetailsTableOnSTDPlanComparisonPage(String arg1, String arg2) throws Throwable {
		quotepage.verify_BENEFITCODE_MONTHLYPREMIUM_ANNUALPREMIUM(driver);
		quotepage.tearDown(driver);
	}
	
	@Then("^UeS_User select PLAN CODES and click on COMPARE RATES FOR SELECTED PLANS button in Disability Plan Information table$")
	public void ues_userSelectPLANCODESAndClickOnCOMPARERATESFORSELECTEDPLANSButtonInDisabilityPlanInformationTable() throws Throwable {
		System.out.println("User selected plans from Disability Plan Information table");
	}

	@Then("^UeS_User is verify PLAN CODE,MONYHLY PREMIUM as \"([^\"]*)\" and ANNUAL PREMIUM as \"([^\"]*)\" in STD Premiums table on STD Rate Comparison  page$")
	public void ues_userIsVerifyPLANCODEMONYHLYPREMIUMAsAndANNUALPREMIUMAsInSTDPremiumsTableOnSTDRateComparisonPage(String arg1, String arg2) throws Throwable {
		quotepage.verify_PLANCODE_MONTHLYPREMIUM_ANNUALPREMIUM(driver);
		quotepage.tearDown(driver);  
	}
	@Then("^UeS_User select plan codes from Disability Plan Information table and click on NEXT button in Short Term Disability Plans page$")
	public void ues_userSelectPlanCodesFromDisabilityPlanInformationTableAndClickOnNEXTButtonInShortTermDisabilityPlansPage() throws Throwable {
		quotepage.selectPlanCode_clickNext_ShortTermDisabilityPlans(driver);
	}

	@Then("^UeS_User select PLAN CODES and click on COMPARE SELECTED PLANS button in Disability Plan Information table on Long Term Disability Plans page$")
	public void ues_userSelectPLANCODESAndClickOnCOMPARESELECTEDPLANSButtonInDisabilityPlanInformationTableOnLongTermDisabilityPlansPage() throws Throwable {
		quotepage.selectPlanCodes_LTDPlanPage(driver);
	}
	@Then("^UeS_User is verify BENEFIT,MONYHLY PREMIUM as \"([^\"]*)\" and ANNUAL PREMIUM as \"([^\"]*)\" in Long Term Disability Plan Details table on LTD Plan Comparison page$")
	public void ues_userIsVerifyBENEFITMONYHLYPREMIUMAsAndANNUALPREMIUMAsInLongTermDisabilityPlanDetailsTableOnLTDPlanComparisonPage(String arg1, String arg2) throws Throwable {
		quotepage.verify_BENEFITCODE_MONTHLYPREMIUM_ANNUALPREMIUM_On_LTDPlanComparison(driver);
		quotepage.verify_BENEFITCODE_MONTHLYPREMIUM_ANNUALPREMIUM_On_LTDRateComparison(driver);
		quotepage.tearDown(driver);
	}
	
	@Then("^UeS_User is verify EMPLT,MONYHLY PREMIUM as \"([^\"]*)\" and ANNUAL PREMIUM as \"([^\"]*)\" in Long Term Disability Plan Details table on LTD Rate Comparison page$")
	public void ues_userIsVerifyEMPLTMONYHLYPREMIUMAsAndANNUALPREMIUMAsInLongTermDisabilityPlanDetailsTableOnLTDRateComparisonPage(String arg1, String arg2) throws Throwable {
		quotepage.verify_BENEFITCODE_MONTHLYPREMIUM_ANNUALPREMIUM_On_LTDRateComparison(driver);
		quotepage.tearDown(driver);
	}


}
