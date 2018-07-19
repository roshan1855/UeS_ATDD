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
	import com.optum.synergy.ues.ui.pageobjects.LoginScreen;
	import com.optum.synergy.ues.ui.pageobjects.QuotePage;
	import com.optum.synergy.ues.ui.utilities.Utilities;
	import cucumber.api.java.en.*;


	public class CompensationDef{
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
		public static CompensationPage compensationpage;
		public static QuotePage quotepage;
		
		public CompensationDef() throws IOException {
			System.out.println("**** Begin Compensation Flow Execution() ***** ");
			driver = Hooks.driver;
			utility = new Utilities();
			autoProperties = Hooks.autoProperties;
			common = new CommonLibrary();
			compensationpage=new CompensationPage();
			quotepage=new QuotePage(); 
		}
		
		@Given("^UeS_User is on Dev environment Home Page$")
		public void ues_user_is_on_Dev_environment_Home_Page() throws Throwable {
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(autoProperties.getProperty("TestEnvironmentDevURLUeS"));
			utility.takeScreenShot(driver, "Homepage" + testCaseID);
			utility.GenerateReport("Quote", "", "info", "Execution Started.User is on the login Page",
					"Homepage" + testCaseID);   
		}
		
		@Then("^UeS_User click on Compensation tab$")
		public void ues_user_click_on_Compensation_tab() throws Throwable {
			compensationpage.clickCompensation(driver);
		}

		@Then("^UeS_User verify Compensation_Home is displayed successfully$")
		public void ues_user_verify_Compensation_Home_is_displayed_successfully() throws Throwable {
		    compensationpage.verifyCompHomePage(driver);
		    
		}

		@When("^UeS_User enters UserName and Password then click on login button$")
		public void ues_user_enters_UserName_and_Password_then_click_on_login_button() throws Throwable {
			compensationpage.loginUeS_Dev(driver);  
		}
		
		@Then("^UeS_User check links present in Compensation home : Commission Statements,Request Direct Deposit Authorization and other links$")
		public void ues_userCheckLinksPresentInCompensationHomeCommissionStatementsRequestDirectDepositAuthorizationAndOtherLinks() throws Throwable {
			compensationpage.verifyCompensationHomeLinks(driver);
		}

		@Then("^UeS_User verifies Compensation sub link pages : Commission Statements,Request Direct Deposit Authorization and other links$")
		public void ues_userVerifiesCompensationSubLinkPagesCommissionStatementsRequestDirectDepositAuthorizationAndOtherLinks() throws Throwable {
			compensationpage.accessCompSubLinkPages(driver);
			//compensationpage.accessCompSubLinkPDFPages(driver);
			quotepage.tearDown(driver);
		}
		
		/*@When("^UeS_UserFlow_fileName \"([^\"]*)\" and testCaseID \"([^\"]*)\" are captured$")
		public void ues_userflow_filename_and_testCaseID_are_captured(String arg1, String arg2) throws Throwable {
			reportName = arg1;
			testCaseID = arg2;
			utility.CreateReport(reportName, testCaseID); 
		   
		}

		@Given("^UeS_User is on Home Page$")
		public void ues_user_is_on_Home_Page() throws Throwable {
			// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					driver.get(autoProperties.getProperty("TestEnvironmentDevURLUeS"));
					// throw new PendingException();
					utility.takeScreenShot(driver, "Homepage" + testCaseID);
					utility.GenerateReport("Quote", "", "info", "Execution Started.User is on the login Page",
							"Homepage" + testCaseID); 
		}

		@When("^UeS_User Navigate to LogIn Page$")
		public void ues_user_Navigate_to_LogIn_Page() throws Throwable {
			System.out.println("DIRECTORY \t" + System.getProperty("user.dir"));
			System.out.println("User Is on login page");
			utility.takeScreenShot(driver, "Homepage" + testCaseID);
			utility.GenerateReport("Quote", "", "info", "Execution Started.User is on the login Page",
					"Homepage" + testCaseID);

			// throw new PendingException(); 
		}

		@When("^UeS_User enters UserName and Password$")
		public void ues_user_enters_UserName_and_Password() throws Throwable {
			// Thread.sleep(1000);

					ls = PageFactory.initElements(driver, LoginScreen.class);
					ls.setUserName(driver, "PU1");
					utility.takeScreenShot(driver, "username" + testCaseID);
					utility.GenerateReport("Quote", "Scenario Headline", "pass", "User is able to set UserName",
							"username" + testCaseID);
					ls.setPassword(driver, "B4s1cNP1");
					driver.findElement(By.xpath("//input[@value='Submit']")).sendKeys(Keys.ENTER);
			Thread.sleep(8000);
			driver.findElement(By.xpath(".//*[@id='U']")).sendKeys("Manibalan");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='P']")).sendKeys("M@tiba1a2");
			Thread.sleep(2000);
			element = driver.findElement(By.xpath("//a[contains(text(),'Log In')]"));
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			System.out.println("User clicked Login Button");
			Thread.sleep(10000);
		}

		@Then("^UeS_User displayed Login Successfully$")
		public void ues_user_displayed_Login_Successfully() throws Throwable {
			System.out.println("UeS Login Successfully done");
			utility.takeScreenShot(driver, "Login");
			utility.GenerateReport("", "", "info", "UeS Login is successfully completed", "Login"); 
		}


		
		@Then("^UeS_User displayed message Login Successfully$")
		public void ues_user_displayed_message_Login_Successfully() throws Throwable {
		    System.out.println("UeS Login Successfully");
		}



		@Then("^UeS_User click on Compensation tab$")
		public void ues_user_click_on_Compensation_tab() throws Throwable {
		    quotepage.clickCompensation();
		}

		@Then("^UeS_User verify Compensation_Home is displayed successfully$")
		public void ues_user_verify_Compensation_Home_is_displayed_successfully() throws Throwable {
		    quotepage.verifyCompensationHome();
		}*/

	}


