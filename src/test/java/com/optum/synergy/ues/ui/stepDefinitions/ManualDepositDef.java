package com.optum.synergy.ues.ui.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.optum.synergy.ues.ui.pageobjects.LoginScreen;
import com.optum.synergy.ues.ui.pageobjects.ManualDepositPage;
import com.optum.synergy.ues.ui.utilities.Utilities;

import cucumber.api.java.en.*;

public class ManualDepositDef {
	static WebDriver driver;

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

	public static CommonLibrary common;
	public static ManualDepositPage mdreqfform;
	public static String startDatePresent;

	public static String startDateHomeScreen;
	public static String startDateHS;
	public static String cridHomeScreen;
	DesiredCapabilities ieCapabilities;
	By mdproducedID=By.xpath(".//*[@id='producerId']");
	//ManualDepositRequestForm mdreqfform=new ManualDepositRequestForm();
	public ManualDepositDef() throws IOException {
		
		driver = Hooks.driver;
		autoProperties = Hooks.autoProperties;
		utility = new Utilities();
		//try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			//obj.load(resourceStream);
		//}

		common = new CommonLibrary();

		mdreqfform=new ManualDepositPage();
	}
	@When("^ManualDeposit_fileName \"([^\"]*)\" and testCaseID \"([^\"]*)\" are captured$")
	public void manualdeposit_filename_and_testCaseID_are_captured(String arg1, String arg2) throws Throwable {
		reportName = arg1;
		testCaseID = arg2;
		utility.CreateReport(reportName, testCaseID);

		// throw new PendingException();
	}

	@Given("^ManualDepositFlow_User is on Home Page$")
	public void manualdepositflow_user_is_on_Home_Page() throws Throwable {
		//driver = utility.OpenBrowser(browserType);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(autoProperties.getProperty("TestEnvironmentURL"));

		// throw new PendingException();
	}

	@When("^ManualDepositFlow_User Navigate to LogIn Page$")
	public void manualdepositflow_user_Navigate_to_LogIn_Page() throws Throwable {
		// Thread.sleep(5000);

				System.out.println("DIRECTORY \t" + System.getProperty("user.dir"));
				System.out.println("User Is on login page");
				utility.takeScreenShot(driver, "Homepage" + testCaseID);
				utility.GenerateReport("MD", "", "info", "Execution Started.User is on the login Page",
						"Homepage" + testCaseID);

				// throw new PendingException();
	}

	@When("^ManualDepositFlow_User enters UserName and Password$")
	public void manualdepositflow_user_enters_UserName_and_Password() throws Throwable {
		// Thread.sleep(1000);

				ls = PageFactory.initElements(driver, LoginScreen.class);
				ls.setUserName(driver, "PU1");
				utility.takeScreenShot(driver, "username" + testCaseID);
				utility.GenerateReport("MD", "Scenario Headline", "pass", "User is able to set UserName",
						"username" + testCaseID);
				ls.setPassword(driver, "B4s1cNP1");
				driver.findElement(By.xpath("//input[@value='Submit']")).sendKeys(Keys.ENTER);

				// throw new PendingException();
	}

	@Then("^ManualDepositFlow_Message displayed Login Successfully$")
	public void manualdepositflow_message_displayed_Login_Successfully() throws Throwable {
		System.out.println("Login Successfully done");
		utility.takeScreenShot(driver, "Login" + testCaseID);
		utility.GenerateReport("MD", "", "info", "Login is successfully completed", "Login" + testCaseID);

		// throw new PendingException();
	}
	
	@When("^ManualDepositFlow_User is on Home page and click on Manual Deposit module$")
	public void manualdepositflow_user_is_on_Home_page_and_click_on_Manual_Deposit_module() throws Throwable {
		Thread.sleep(2000);
		mdreqfform.clickManualDepositMod(driver);
	}

	@When("^ManualDepositFlow_User is click on New Depost button$")
	public void manualdepositflow_user_is_click_on_New_Depost_button() throws Throwable {
		Thread.sleep(2000);
		mdreqfform.clickNewDepositBtn(driver);
	}
	
	@When("^ManualDepositFlow_User is able to enter \"([^\"]*)\" and selectiten from Pay Period drop$")
	public void manualdepositflow_user_is_able_to_enter_and_selectiten_from_Pay_Period_drop(String prodID) throws Throwable {
		Thread.sleep(2000);
		mdreqfform.searchDetails(driver, prodID);
		
	}

	@When("^ManualDepositFlow_User click on Search button$")
	public void manualdepositflow_user_click_on_Search_button() throws Throwable {
		mdreqfform.clickSearchBtn(driver);
		Thread.sleep(1000);
	}

	@When("^ManualDepositFlow_User click on Save button$")
	public void manualdepositflow_user_click_on_Save_button() throws Throwable {
		mdreqfform.clickSaveBtn(driver);
		System.out.println("Clicked Save button/.....");
		Thread.sleep(3000);
		try{
		Boolean popupStatus;
		popupStatus = utility.isAlertPresent(driver);
		System.out.println("ALert...statred popupStatus"+ popupStatus);
		if (popupStatus == true) {
		Alert alert = driver.switchTo().alert();
		System.out.println("ALert..." + alert.getText());
	                      alert.accept();
		}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			
		}
	}

	@When("^ManualDepositFlow_User is able to enter \"([^\"]*)\" and select Reason Code  \"([^\"]*)\"$")
	public void manualdepositflow_user_is_able_to_enter_and_select_Reason_Code(String prodID, String reasonCode) throws Throwable {
		mdreqfform.enterProdIDandReasonCode(driver, prodID, reasonCode);
	}

	@When("^enter all required details$")
	public void enter_all_required_details() throws Throwable {
		mdreqfform.enterAdvanceCheckDetails(driver);
	}

	@When("^ManualDepositFlow_User is able to enter \"([^\"]*)\" and click on Searh button$")
	public void manualdepositflow_user_is_able_to_enter_and_click_on_Searh_button(String prodId) throws Throwable {
		mdreqfform.searchDetails(driver, prodId);
		mdreqfform.clickSearchBtn(driver);
	}
	@Then("^ManualDepositFlow_User is verified Reason Code \"([^\"]*)\" with saved details$")
	public void manualdepositflow_user_is_verified_Reason_Code_with_saved_details(String reasonCode) throws Throwable {
		mdreqfform.searchResults(driver, reasonCode);
		mdreqfform.tearDown(driver);
	}
	
	@When("^ManualDepositFlow_User is able to select Alliance Statement  \"([^\"]*)\"$")
	public void manualdepositflow_user_is_able_to_select_Alliance_Statement(String allianceStatement) throws Throwable {
		mdreqfform.selectAllianceStatement(driver,allianceStatement);
	}

	@When("^ManualDepositFlow_User is able to enter all mandatory details$")
	public void manualdepositflow_user_is_able_to_enter_all_mandatory_details() throws Throwable {
		mdreqfform.enterManualDepositDetails(driver);
	}
	
	@When("^ManualDepositFlow_User is able to enter all mandatory and GL Debit details$")
	public void manualdepositflow_user_is_able_to_enter_all_mandatory_and_GL_Debit_details() throws Throwable {
		Thread.sleep(2000);
		mdreqfform.enterGLDebitDetails(driver);
	}
	
	@When("^ManualDepositFlow_User is able to enter GL Credit details$")
	public void manualdepositflow_user_is_able_to_enter_GL_Credit_details() throws Throwable {
		Thread.sleep(2000);
		mdreqfform.enterGLCredit(driver);
	}
	
	
	@When("^ManualDepositFlow_User is able to enter all Mandatory Details$")
	public void manualdepositflow_user_is_able_to_enter_all_Mandatory_Details() throws Throwable {
		mdreqfform.enterManualDepositDetailsforMedica(driver);
	}

	
	@Then("^ManualDepositFlow_User is verified Reason Code \"([^\"]*)\" and  Alliance Statement \"([^\"]*)\" with saved details$")
	public void manualdepositflow_user_is_verified_Reason_Code_and_Alliance_Statement_with_saved_details(String reasonCode, String allianceStatement) throws Throwable {
		mdreqfform.searchResults(driver, reasonCode, allianceStatement);
		mdreqfform.tearDown(driver);
	}
	
	@When("^ManualDepositFlow_User is able to enter Mandatory data$")
	public void manualdepositflow_user_is_able_to_enter_Mandatory_data() throws Throwable {
		mdreqfform.enterManualDepositDetails1(driver);
	}
	
	@When("^ManualDepositFlow_User is able to enter \"([^\"]*)\" and Reason Code \"([^\"]*)\" click on Search button$")
	public void manualdepositflow_user_is_able_to_enter_and_Reason_Code_click_on_Searh_button(String prodID, String reasonCode) throws Throwable {
		mdreqfform.enterProdIDandSelectReasonCode(driver, prodID, reasonCode);
		mdreqfform.clickSearchBtn(driver);
		Thread.sleep(2000);
		//utility.takeScreenShot(driver, "Results" + testCaseID);
		//utility.GenerateReport("Manual Deposit", "", "info", "Searched results are dislayed", "Results" + testCaseID);

	}
	@When("^ManualDepositFlow_User is able to select record and click on View button$")
	public void manualdepositflow_user_is_able_to_select_record_and_click_on_View_button() throws Throwable {
		mdreqfform.selectRecordAndClickViewBtn(driver);
	}

	@Then("^ManualDepositFlow_User is verified whether data are disabled or enabled$")
	public void manualdepositflow_user_is_verified_whether_data_are_disabled_or_enabled() throws Throwable {
		mdreqfform.verifyStatusOfData(driver);
		Thread.sleep(2000);
		mdreqfform.tearDown(driver);
		
	}
	@When("^ManualDepositFlow_User is able to enter \"([^\"]*)\" and click on Search button$")
	public void manualdepositflow_user_is_able_to_enter_and_click_on_Search_button(String prodID) throws Throwable {
		mdreqfform.enterProdIDandClickOnSearchBtn(driver, prodID);
		mdreqfform.clickSearchBtn(driver);
	}

	@When("^ManualDepositFlow_User is able to select Newly created record and click on Approve button$")
	public void manualdepositflow_user_is_able_to_select_Newly_created_record_and_click_on_Approve_button() throws Throwable {
		mdreqfform.SelectNewlyCreatedRecordandClickOnApproveBtn(driver);
	}

	@Then("^ManualDepositFlow_User is verified whether status got changed to Approved or not$")
	public void manualdepositflow_user_is_verified_whether_status_got_changed_to_Approved_or_not() throws Throwable {
		mdreqfform.verifyStatusApproved(driver);
		Thread.sleep(2000);
		mdreqfform.tearDown(driver);
		
	}
	
	@When("^ManualDepositFlow_User is able to select Appoved record and click on UnApprove button$")
	public void manualdepositflow_user_is_able_to_select_Appoved_record_and_click_on_UnApprove_button() throws Throwable {
		mdreqfform.SelectNewlyCreatedRecordandClickOnUnApproveBtn(driver);
	}

	@Then("^ManualDepositFlow_User is verified whether status got changed to Deleted or not$")
	public void manualdepositflow_user_is_verified_whether_status_got_changed_to_Deleted_or_not() throws Throwable {
		mdreqfform.verifyStatusDeleted(driver);
		Thread.sleep(2000);
		mdreqfform.tearDown(driver);
		
	}

}
