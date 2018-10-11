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
import com.optum.synergy.ues.ui.pageobjects.AdministrationPage;
import com.optum.synergy.ues.ui.pageobjects.LoginScreen;
import com.optum.synergy.ues.ui.pageobjects.NetworkPage;
import com.optum.synergy.ues.ui.pageobjects.QuotePage;
import com.optum.synergy.ues.ui.utilities.Utilities;

import cucumber.api.java.en.*;

public class AdministrationDef {
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
	public static AdministrationPage adminpage;
	public static QuotePage quotepage;
	
	public AdministrationDef() throws IOException {
		//System.out.println("**** Begin Network Module Execution() ***** ");
		driver = Hooks.driver;
		utility = new Utilities();
		autoProperties = Hooks.autoProperties;
		
		common = new CommonLibrary();
		adminpage=new AdministrationPage();
		
	}
	
	@Then("^Click on Administration Link$")
	public void click_on_Administration_Link() throws Throwable {
		adminpage.clickAdministrationkTab(driver);
	}

	@Then("^UeS_User verifies the title of the Administration page as \"([^\"]*)\"$")
	public void ues_user_verifies_the_title_of_the_Administration_page_as(String txtAdmin) throws Throwable {
		adminpage.verifyAdministrationkHome(driver, txtAdmin);
	}

	@Then("^Verify all the links are present or not in Site Administration Page$")
	public void Verify_all_the_links_are_present_or_not_in_Site_Administration_Page() throws Throwable {
		adminpage.verifyLinks(driver);
	}
	@Then("^Check all the links one by one$")
	public void check_all_the_links_one_by_one() throws Throwable {
        adminpage.verifyClickableLinks(driver);
	}
	
	@Then("^UeS_User verify followed links on Site Administration page Create & Register a New User,Manage Existing Users and Manage B(\\d+)B Account$")
	public void ues_userVerifyFollowedLinksOnSiteAdministrationPageCreateRegisterANewUserManageExistingUsersAndManageBBAccount(int arg1) throws Throwable {
		adminpage.verifySiteAdministration_Links_Set1(driver);
	}

	@Then("^UeS_User click on above links and verify pages Create & Register a New User,Manage Existing Users and Manage B(\\d+)B Account$")
	public void ues_userClickOnAboveLinksAndVerifyPagesCreateRegisterANewUserManageExistingUsersAndManageBBAccount(int arg1) throws Throwable {
		adminpage.verifyLinkPages_Set1(driver);
	}

	@Then("^UeS_User verify followed links on Site Administration page Manage Organization,Manage Organization Users and Manage Broker Delegates$")
	public void ues_userVerifyFollowedLinksOnSiteAdministrationPageManageOrganizationManageOrganizationUsersAndManageBrokerDelegates() throws Throwable {
		adminpage.verifySiteAdministration_Links_Set2(driver);
	}

	@Then("^UeS_User click on above links and verify pages Manage Organization,Manage Organization Users and Manage Broker Delegates$")
	public void ues_userClickOnAboveLinksAndVerifyPagesManageOrganizationManageOrganizationUsersAndManageBrokerDelegates() throws Throwable {
		adminpage.verifyLinkPages_Set2(driver);
	}

	@Then("^UeS_User verify followed links on Site Administration page Manage United Advantage Report Access and Manage Quote & Renewal News, Alerts and Notations$")
	public void ues_userVerifyFollowedLinksOnSiteAdministrationPageManageUnitedAdvantageReportAccessAndManageQuoteRenewalNewsAlertsAndNotations() throws Throwable {
		adminpage.verifySiteAdministration_Links_Set3(driver);
	}

	@Then("^UeS_User click on above links and verify pages Manage United Advantage Report Access and Manage Quote & Renewal News, Alerts and Notations$")
	public void ues_userClickOnAboveLinksAndVerifyPagesManageUnitedAdvantageReportAccessAndManageQuoteRenewalNewsAlertsAndNotations() throws Throwable {
		adminpage.verifyLinkPages_Set3(driver);
	}

	@Then("^UeS_User verify followed links on Site Administration page Clear Cache,Modify Logging Levels and View Renewal Package Mailing Preference & History$")
	public void ues_userVerifyFollowedLinksOnSiteAdministrationPageClearCacheModifyLoggingLevelsAndViewRenewalPackageMailingPreferenceHistory() throws Throwable {
		adminpage.verifySiteAdministration_Links_Set4(driver);
	}

	@Then("^UeS_User click on above links and verify pages Clear Cache,Modify Logging Levels and View Renewal Package Mailing Preference & History$")
	public void ues_userClickOnAboveLinksAndVerifyPagesClearCacheModifyLoggingLevelsAndViewRenewalPackageMailingPreferenceHistory() throws Throwable {
		adminpage.verifyLinkPages_Set4(driver);
		//quotepage.tearDown(driver);
	}

}
