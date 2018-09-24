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

import cucumber.api.java.en.Then;

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

}
