package com.optum.synergy.ues.ui.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.optum.synergy.ues.ui.pageobjects.CompensationPage;
import com.optum.synergy.ues.ui.pageobjects.HomePage;
import com.optum.synergy.ues.ui.pageobjects.LoginScreen;
import com.optum.synergy.ues.ui.pageobjects.MyAccountPage;
import com.optum.synergy.ues.ui.pageobjects.QuotePage;
import com.optum.synergy.ues.ui.utilities.Utilities;

import cucumber.api.java.en.*;

public class MyAccountDef {
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
	public static CompensationPage compensationpage;
	public static HomePage homepage;
	public static MyAccountPage myaccountpage;

	public MyAccountDef() throws IOException {
		driver = Hooks.driver;
		utility = new Utilities();
		autoProperties = Hooks.autoProperties;
		common = new CommonLibrary();
		quotepage = new QuotePage();
		compensationpage = new CompensationPage();
		homepage = new HomePage();
		myaccountpage = new MyAccountPage();
	}

	@Then("^UeS_User verify My Account link on Home page and then click on My Account link$")
	public void ues_userVerifyMyAccountLinkOnHomePageAndThenClickOnMyAccountLink() throws Throwable {
		homepage.verifyUserName_Header_Footer(driver);
		myaccountpage.verifyMyAccount(driver);
	}

	@Then("^UeS_User verify links on My Account page when user logging as Administrator$")
	public void ues_userVerifyLinksOnMyAccountPageWhenUserLoggingAsAdministrator() throws Throwable {
		myaccountpage.verifyMyAccountPage_Links_Admin(driver);
	}

	@Then("^UeS_User click on each link on My Account page and verify page displayed successfully based on User clicked on link$")
	public void ues_userClickOnEachLinkOnMyAccountPageAndVerifyPageDisplayedSuccessfullyBasedOnUserClickedOnLink()
			throws Throwable {
		myaccountpage.verifyLinkPages(driver);
		quotepage.tearDown(driver);
	}

	@When("^UeS_User enters UserName as \"([^\"]*)\" and Password as \"([^\"]*)\" for Broker login$")
	public void ues_userEntersUserNameAsAndPasswordAsForBrokerLogin(String arg1, String arg2) throws Throwable {
		quotepage.loginUeS_Broker(driver, arg1, arg2);
	}

	@Then("^UeS_User verify Broker User Name,Hearder and Footer on Home Page$")
	public void ues_userVerifyBrokerUserNameHearderAndFooterOnHomePage() throws Throwable {
		homepage.verifyUserName_Header_Footer(driver);
	}

	@Then("^UeS_User verify followed links on MyAccount page View/Edit Renewal Package Mailing Preference,Change Password and Change Secret Questions$")
	public void ues_userVerifyFollowedLinksOnMyAccountPageViewEditRenewalPackageMailingPreferenceChangePasswordAndChangeSecretQuestions()
			throws Throwable {
		myaccountpage.verifyMyAccountPage_Links_Broker_Set1(driver);
	}

	@Then("^UeS_User click on above links and verify pages View/Edit Renewal Package Mailing Preference,Change Password and Change Secret Questions$")
	public void ues_userClickOnAboveLinksAndVerifyPagesViewEditRenewalPackageMailingPreferenceChangePasswordAndChangeSecretQuestions()
			throws Throwable {
		myaccountpage.verifyLinkPages_Broker_Set1(driver);
	}

	@Then("^UeS_User verify followed links on MyAccount page Update Employer eServices Information,Update UnitedAdvantage\\.com Information and View/Edit Contact Information$")
	public void ues_userVerifyFollowedLinksOnMyAccountPageUpdateEmployerEServicesInformationUpdateUnitedAdvantageComInformationAndViewEditContactInformation()
			throws Throwable {
		myaccountpage.verifyMyAccountPage_Links_Broker_Set2(driver);
	}

	@Then("^UeS_User click on above links and verify pages Update Employer eServices Information,Update UnitedAdvantage\\.com Information and View/Edit Contact Information$")
	public void ues_userClickOnAboveLinksAndVerifyPagesUpdateEmployerEServicesInformationUpdateUnitedAdvantageComInformationAndViewEditContactInformation()
			throws Throwable {
		myaccountpage.verifyLinkPages_Broker_Set2(driver);
	}

	@Then("^UeS_User verify followed links on MyAccount page Manage My Delegates,View License & Appointments and Change Renewal Alerts Status$")
	public void ues_userVerifyFollowedLinksOnMyAccountPageManageMyDelegatesViewLicenseAppointmentsAndChangeRenewalAlertsStatus()
			throws Throwable {
		myaccountpage.verifyMyAccountPage_Links_Broker_Set3(driver);
	}

	@Then("^UeS_User click on above links and verify pages Manage My Delegates,View License & Appointments and Change Renewal Alerts Status$")
	public void ues_userClickOnAboveLinksAndVerifyPagesManageMyDelegatesViewLicenseAppointmentsAndChangeRenewalAlertsStatus()
			throws Throwable {
		myaccountpage.verifyLinkPages_Broker_Set3(driver);
	}

	@Then("^UeS_User verify followed links on MyAccount page Change Commission Alerts Status,Change Late Premium and Cancel Case Alerts Status and Quote Setup$")
	public void ues_userVerifyFollowedLinksOnMyAccountPageChangeCommissionAlertsStatusChangeLatePremiumAndCancelCaseAlertsStatusAndQuoteSetup()
			throws Throwable {
		myaccountpage.verifyMyAccountPage_Links_Broker_Set4(driver);
	}

	@Then("^UeS_User click on above links and verify pages Change Commission Alerts Status,Change Late Premium and Cancel Case Alerts Status and Quote Setup$")
	public void ues_userClickOnAboveLinksAndVerifyPagesChangeCommissionAlertsStatusChangeLatePremiumAndCancelCaseAlertsStatusAndQuoteSetup()
			throws Throwable {
		myaccountpage.verifyLinkPages_Broker_Set4(driver);
	}

	@Then("^UeS_User verify followed links on MyAccount page Quote Generation Options,Custom Logo Selection and Define Sales Material & Benefit Searches$")
	public void ues_userVerifyFollowedLinksOnMyAccountPageQuoteGenerationOptionsCustomLogoSelectionAndDefineSalesMaterialBenefitSearches()
			throws Throwable {
		myaccountpage.verifyMyAccountPage_Links_Broker_Set5(driver);
	}

	@Then("^UeS_User click on above links and verify pages Quote Generation Options,Custom Logo Selection and Define Sales Material & Benefit Searches$")
	public void ues_userClickOnAboveLinksAndVerifyPagesQuoteGenerationOptionsCustomLogoSelectionAndDefineSalesMaterialBenefitSearches()
			throws Throwable {
		myaccountpage.verifyLinkPages_Broker_Set5(driver);
		quotepage.tearDown(driver);
	}

}
