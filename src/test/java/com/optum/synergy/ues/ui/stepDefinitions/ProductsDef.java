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
import com.optum.synergy.ues.ui.pageobjects.ProductsPage;
import com.optum.synergy.ues.ui.pageobjects.QuotePage;
import com.optum.synergy.ues.ui.utilities.Utilities;

import cucumber.api.java.en.*;

public class ProductsDef {
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
	public static ProductsPage productspage;
	public static QuotePage quotepage;
	
	public ProductsDef() throws IOException {
		System.out.println("**** Begin Products Module Execution() ***** ");
		driver = Hooks.driver;
		utility = new Utilities();
		autoProperties = Hooks.autoProperties;
		
		common = new CommonLibrary();
		productspage=new ProductsPage();
		quotepage=new QuotePage();
	}
	
	@When("^UeS_User click on Products tab then verifies sub-tabs: Benefit Summaries,Product Grids,Benefit FAQs and Brochures$")
	public void ues_user_click_on_Products_tab_then_verifies_sub_tabs_Benefit_Summaries_Product_Grids_Benefit_FAQs_and_Brochures() throws Throwable {
		productspage.clickProductsTab(driver);	
		productspage.verifyProductsSubtabs(driver);
	}

	@When("^UeS_User verifies the title of the products home as \"([^\"]*)\"$")
	public void ues_user_verifies_the_title_of_the_products_home_as(String arg1) throws Throwable {
		productspage.verifyProductsHome(driver, arg1);

	}

	@Then("^UeS_User verifies Product sub link pages : Benefit Summaries,Product Grids,Benefit FAQs and Brochures$")
	public void ues_user_verifies_Product_sub_link_pages_Benefit_Summaries_Product_Grids_Benefit_FAQs_and_Brochures() throws Throwable {
		productspage.clickSubLinks_Validate(driver);
		quotepage.tearDown(driver);
	}
	
	@When("^UeS_User click on Products tab then verifies links:U-Invent New Product Idea Submission,UnitedHealthcare Pharmacy Information and Goldenrule$")
	public void ues_userClickOnProductsTabThenVerifiesLinksUInventNewProductIdeaSubmissionUnitedHealthcarePharmacyInformationAndGoldenrule() throws Throwable {
		productspage.clickProductsTab(driver);	
		productspage.verifyProductsLinks(driver);  
	}

	@Then("^UeS_User verifies Product sub link pages : U-Invent New Product Idea Submission,UnitedHealthcare Pharmacy Information and Goldenrule$")
	public void ues_userVerifiesProductSubLinkPagesUInventNewProductIdeaSubmissionUnitedHealthcarePharmacyInformationAndGoldenrule() throws Throwable {
	  //System.out.println("Links displayed successfully"); 
	   productspage.accessProdSubLinkPages(driver);
	   productspage.prodGoldenrulePage(driver);
	   quotepage.tearDown(driver);
	}
	

}
