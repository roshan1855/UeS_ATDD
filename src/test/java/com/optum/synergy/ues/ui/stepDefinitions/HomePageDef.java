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
import com.optum.synergy.ues.ui.pageobjects.HomePage;
import com.optum.synergy.ues.ui.pageobjects.LoginScreen;
import com.optum.synergy.ues.ui.pageobjects.QuotePage;
import com.optum.synergy.ues.ui.utilities.Utilities;

import cucumber.api.java.en.Then;

public class HomePageDef {
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

	public HomePageDef() throws IOException {
		driver = Hooks.driver;
		utility = new Utilities();
		autoProperties = Hooks.autoProperties;
		common = new CommonLibrary();
		quotepage = new QuotePage();
		compensationpage = new CompensationPage();
		homepage = new HomePage();

	}

	@Then("^UeS_User verify User Name,Hearder and Footer on Home Page$")
	public void ues_userVerifyUserNameHearderAndFooterOnHomePage() throws Throwable {
		homepage.verifyUserName_Header_Footer(driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User verify News & Information/News & Rate Alerts/Whats New\\?/ Quick Links section on Home Page$")
	public void ues_userVerifyNewsInformationNewsRateAlertsWhatsNewQuickLinksSectionOnHomePage() throws Throwable {
		homepage.verifyUserName_Header_Footer(driver);
		homepage.verifyHomePageHeadings(driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User verify Forms, Help & Training ,Benefits Administration and Recognition tabs on Home Page then click on each tab$")
	public void ues_userVerifyFormsHelpTrainingBenefitsAdministrationAndRecognitionTabsOnHomePageThenClickOnEachTab()
			throws Throwable {
		homepage.verifyTabs(driver);
	}

	@Then("^UeS_User verify content on each page based on User selected tab on Home Page$")
	public void ues_userVerifyContentOnEachPageBasedOnUserSelectedTabOnHomePage() throws Throwable {
		homepage.verifyContentOnEachTab(driver);
		homepage.clickTab_verifyHelpTraining(driver);
		quotepage.tearDown(driver);
	}

	@Then("^UeS_User verify Sales Automation Management Link on Home Page and then click on SAM link$")
	public void ues_userVerifySalesAutomationManagementSAMLinkOnHomePageAndThenClickOnSAMLink() throws Throwable {
		homepage.verifyUserName_Header_Footer(driver);
		homepage.verifySAMLink(driver);
	}

	@Then("^UeS_User verify Sales Automation Management page displayed successfully$")
	public void ues_userVerifySalesAutomationManagementSAMPageDisplayedSuccessfully() throws Throwable {
		homepage.verifySAMPage(driver);
		quotepage.tearDown(driver);
	}
}
