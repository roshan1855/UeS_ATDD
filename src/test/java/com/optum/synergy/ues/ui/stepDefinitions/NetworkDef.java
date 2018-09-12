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
import com.optum.synergy.ues.ui.pageobjects.LoginScreen;
import com.optum.synergy.ues.ui.pageobjects.NetworkPage;
import com.optum.synergy.ues.ui.pageobjects.QuotePage;
import com.optum.synergy.ues.ui.utilities.Utilities;

import cucumber.api.java.en.*;

public class NetworkDef {
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
	public static NetworkPage networkpage;
	public static QuotePage quotepage;
	
	public NetworkDef() throws IOException {
		//System.out.println("**** Begin Network Module Execution() ***** ");
		driver = Hooks.driver;
		utility = new Utilities();
		autoProperties = Hooks.autoProperties;
		
		common = new CommonLibrary();
		networkpage=new NetworkPage();
		quotepage=new QuotePage();
	}
	
	
	@When("^Flow_Fetch fileName \"([^\"]*)\" and testCaseID \"([^\"]*)\" are captured$")
	public void flow_fetch_fileName_and_testCaseID_are_captured(String arg1, String arg2) throws Throwable {
		reportName = arg1;
		testCaseID = arg2;
		utility.CreateReport(reportName, testCaseID); 
	}

	@When("^UeS_User click on Network tab then verifies sub-tabs: Physician Directories,Network Fact Sheets and Network Maps$")
	public void ues_user_click_on_Network_tab_then_verifies_sub_tabs_Physician_Directories_Network_Fact_Sheets_and_Network_Maps() throws Throwable {
	    networkpage.clickNetworkTab(driver);
	    networkpage.verifyNetworkSubtabs(driver);
	}

	@When("^UeS_User verifies the title of the network page as \"([^\"]*)\"$")
	public void ues_user_verifies_the_title_of_the_network_page_as(String arg1) throws Throwable {
		networkpage.verifyNetWorkHome(driver, arg1);
	}

	@When("^UeS_User verifies tabs: Quote,Case,Renewal,Network,Products,Help&Training,Forms,Benefits Administration,Compensation and Recognition$")
	public void ues_user_verifies_tabs_Quote_Case_Renewal_Network_Products_Help_Training_Forms_Benefits_Administration_Compensation_and_Recognition() throws Throwable {
		networkpage.verifyLinks(driver);
	}

	@When("^UeS_User verifies the site copy below the title$")
	public void ues_user_verifies_the_site_copy_below_the_title() throws Throwable {
		networkpage.verifySiteCopyMesage(driver);
	}

	@When("^UeS_User verifies the links present: Network Fact Sheets,Network Maps and Physician Directories$")
	public void ues_user_verifies_the_links_present_Network_Fact_Sheets_Network_Maps_and_Physician_Directories() throws Throwable {
		//System.out.println("Links are displayed in Network Home page");
		//System.out.println("SSSSSSSSSSSSSSSSSSSs");
		networkpage.verifyLinks(driver);
	}
	
	@Then("^UeS_User verifies Network sub link pages : Physician Directories, Network Fact Sheets and Network Maps$")
	public void ues_user_verifies_Network_sub_link_pages_Physician_Directories_Network_Fact_Sheets_and_Network_Maps() throws Throwable {
		networkpage.clickSubLinks_Validate(driver);
		quotepage.tearDown(driver);
	}

}
