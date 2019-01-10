package com.optum.synergy.ues.ui.pageobjects;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optum.synergy.ues.ui.stepDefinitions.CommonLibrary;
import com.optum.synergy.ues.ui.stepDefinitions.Hooks;
import com.optum.synergy.ues.ui.utilities.Utilities;

public class QuotePage {
	Utilities utility = new Utilities();
	public static Properties autoProperties;
	public static WebDriver driver;
	public static WebDriverWait driverVar;
	public static ArrayList<String> ACTList;
	public static ArrayList<String> EXPList;
	public static String baseURL = "http://dev1-ues.uhc.com/uessecured/index.jsp";
	public static WebElement element;
	public static JavascriptExecutor executor;
	DesiredCapabilities ieCapabilities;

	public static String userName;
	public static CommonLibrary common;

	By uesUserName = By.xpath(".//*[@id='U']");
	By uesPwd = By.xpath(".//*[@id='P']");
	By uesLoginBtn = By.xpath("//a[contains(text(),'Log In')]");
	By uesQuote = By.xpath(".//*[@id='M1']");
	By uesNewQuote = By.name("SM1_1o");
	// Census Page
	By censusDetailInformationFormAge = By.xpath("//input[@name='censusDetailInformationForm[0].employeeAge']");
	By censusDetailInformationFormAge1 = By.xpath("//input[@name='censusDetailInformationForm[1].employeeAge']");
	By censussubmitNext = By.xpath("//input[@name='submitNext' or @value='NEXT']");
	// Medical Plan Page
	By chkBoxmedicalInPackageForm = By.name("medicalInPackageForm[0].packageSelected");
	By btnMedicalPlansubmitNext = By.xpath("//input[@name='submitNext' or @value='NEXT']");
	By btnOptionalMedicalPlansubmitNext = By.xpath("//input[@name='submitNext' or @value='NEXT']");
	// Vision Plan Page
	By btnVisionPlansubmitNext = By.xpath("//input[@name='submitNext' or @value='NEXT']");
	// Proposal Information Page
	By btnPreviewProposal = By.xpath("//input[@name='submitPreviewProposal']");
	// Login Page
	By loginUsername = By.xpath(".//*[@id='divContent']/table[1]/tbody/tr/td/span");
	// Logging Levels
	By messageLoggingLevel = By.xpath(".//*[@id='divContent']/table/tbody/tr[1]/td/div");
	// Err Message
	By errMessage = By.xpath("//td[@class='bodyError']");
	// new Quote
	By quotepolicyEffDateMonth = By.xpath("//input[@name='policyEffDateMonth']");
	By quoteemployeeCount = By.xpath("//input[@name='employeeCount']");
	By quoteatneCount = By.xpath("//input[@name='atneCount']");
	By quoteNextBtn = By.xpath("//input[@name='submitATNE']");
	By quotepolicyEffDateDay = By.name("policyEffDateDay");
	By quotepolicyEffDateYear = By.name("policyEffDateYear");
	By quoteatneCount1 = By.xpath("//input[@name='atneCount' and @tabindex='7']"); // BFX
	By quoteatneCount2 = By.xpath("//input[@name='atneCount' and @tabindex='7']"); // STG
	// Quote SetUp
	By quoteSetUpquoteType = By.xpath("//select[@name='quoteType']");
	By quoteSetUpquoteCompanyName = By.xpath("//input[@name='quoteCompanyName']");
	By ckhBoxProductTypeMedical = By.xpath("//input[@name='selectProductTypeMedical']");
	By ckhBoxProductTypeDental = By.xpath("//input[@name='selectProductTypeDental']");
	By ckhBoxProductTypeLife = By.xpath("//input[@name='selectProductTypeLife']");
	By ckhBoxProductTypeVision = By.xpath("//input[@name='selectProductTypeVision']");
	By ckhBoxProductTypeStd = By.xpath("//input[@name='selectProductTypeStd']");
	By ckhBoxProductTypeLtd = By.xpath("//input[@name='selectProductTypeLtd']");
	By ckhBoxProductTypeEmpSupLife = By.xpath("//input[@name='selectProductTypeEmpSupLife']");
	By ckhBoxProductTypeDepSupLife = By.xpath("//input[@name='selectProductTypeDepSupLife']");
	By txtBoxstreetAddress = By.xpath("//input[@name='quoteLocationForm[0].streetAddress']");
	By txtBoxcityAddress = By.xpath("//input[@name='quoteLocationForm[0].cityAddress']");
	By dropDownState = By.xpath("//select[@name='quoteLocationForm[0].state']");
	By txtBoxzipCode = By.xpath("//input[@name='quoteLocationForm[0].zipCode']");
	By linkAutomatedLookup = By.xpath("//a[@href='javascript:sicDispatchSubmit()']");
	// SIC window
	By radioBtnSIC = By.xpath("//input[@value='SIC']");
	By linklookupLink = By.xpath(".//*[@id='lookupLink']/a");
	By btnsubmitNext = By.xpath("//input[@name='submitNext' or @value='NEXT']");
	By btnSUBMIT = By.xpath("//input[@value='SUBMIT']");
	// Quote SetUp Page
	By totNumActiveEmployeesApplying = By.xpath("//input[@name='quoteLocationForm[0].totNumActiveEmployeesApplying']");
	By txtBoxquoteTotalNumEmployees = By.xpath("//input[@name='quoteTotalNumEmployees']");
	By radioBtnMedicarePriPayer = By.xpath("//input[@name='selectMedicarePriPayer' and @value='false']");
	By btnquoteSetUpNext = By.xpath("//input[@onclick='javascript:return checkPageLoad();']");
	// Dental Plan page
	By chkBoxdentalPlanInformationForm = By.name("dentalPlanInformationForm[0].selectInd");
	By chkBoxdentalPlanInformationForm1 = By.name("dentalPlanInformationForm[1].selectInd");
	By btnsubmitNextDentalPLan = By.xpath("//input[@name='submitNext' or @value='NEXT']");
	// Life Plan page
	By chkBoxlifePlanBasicInformationForm = By.name("lifePlanBasicInformationForm[2].selectBasicInd");
	By btnsubmitNextlifePLan = By.xpath("//input[@name='submitNext' or @value='NEXT']");

	// Compensation Tab
	By menuCompensation = By.xpath(".//*[@id='M9']");
	By compHomeText = By.xpath("//div[@class='contentTitle']");
	By compProducerPerformanceGuide = By.xpath("//span[contains(text(), 'Producer Performance Guide')]");
	By compCommissionSchedule = By.xpath("//span[contains(text(), 'Commission Schedule')]");
	By compCommissionStatements = By.xpath("//a[contains(text(),'Commission Statements')]");
	By compRequestDirectDepositAuthorization = By.xpath("//a[contains(text(),'Request Direct Deposit Authorization')]");

	By txtBoxSICCODE = By.xpath("//input[@name='quoteLocationForm[0].sicCode']");

	static By unitedHealthcareLogo = By.xpath("//img[@title='UnitedHealthcare Logo']");
	static By unitedeServicesLogo = By.xpath("//img[@title='United eServices Logo']");

	public QuotePage() throws IOException {
		driver = Hooks.driver;
		utility = new Utilities();
		autoProperties = Hooks.autoProperties;
		common = new CommonLibrary();
	}

	public void pageUeSLogin() throws InterruptedException {
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		System.setProperty("webdriver.ie.driver", autoProperties.getProperty("IEDriver"));
		driver = new InternetExplorerDriver(caps);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get(baseURL);
		Thread.sleep(3000);
	}

	public void loginUeSApp(WebDriver driver) throws InterruptedException {
		common = new CommonLibrary();
		utility.waitForVisibilityOfWebElement(uesUserName, driver);
		// driver.findElement(uesUserName).sendKeys("roshanadmin05");
		driver.findElement(uesUserName).sendKeys(autoProperties.getProperty("loginUserName_BFX"));
		// driver.findElement(uesUserName).sendKeys("roshankumar");
		//driver.findElement(uesUserName).sendKeys(autoProperties.getProperty("loginUserName_STG"));

		utility.waitForVisibilityOfWebElement(uesPwd, driver);
		// driver.findElement(uesPwd).sendKeys("Computer$4");
		// driver.findElement(uesPwd).sendKeys("Computer$5");
		// driver.findElement(uesPwd).sendKeys(autoProperties.getProperty("loginPassword_BFX"));
		driver.findElement(uesPwd).sendKeys(autoProperties.getProperty("loginPassword_STG"));

		// driver.findElement(uesUserName).sendKeys(common.getUserName());
		// driver.findElement(uesPwd).sendKeys(common.getPassword());

		utility.waitForVisibilityOfWebElement(uesLoginBtn, driver);
		element = driver.findElement(uesLoginBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("User clicked Login Button.....");
		// Thread.sleep(2000);

		/*
		 * Alert Windowalert = driver.switchTo().alert();
		 * Windowalert.authenticateUsing((Credentials) new
		 * UserAndPassword("roshanAdmin05", "Computer$5")); //
		 * Windowalert.accept();
		 */ Thread.sleep(6000);
	}

	public void loginUeS_Broker(WebDriver driver, String userName, String pwd) throws InterruptedException {
		utility.waitForVisibilityOfWebElement(uesUserName, driver);
		driver.findElement(uesUserName).sendKeys(userName);
		// driver.findElement(uesUserName).sendKeys("roshankumar");

		utility.waitForVisibilityOfWebElement(uesPwd, driver);
		// driver.findElement(uesPwd).sendKeys("Computer$4");
		driver.findElement(uesPwd).sendKeys(pwd);

		utility.waitForVisibilityOfWebElement(uesLoginBtn, driver);
		element = driver.findElement(uesLoginBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("User clicked Login Button.....");
		Thread.sleep(6000);
	}

	public void username_pwd() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(uesUserName).sendKeys("roshanAdmin05");
		Thread.sleep(1000);
		driver.findElement(uesPwd).sendKeys("Computer$4");
		Thread.sleep(1000);
		element = driver.findElement(uesLoginBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickQuote_NewQuote(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");

		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");

		QuotePage.verifyPageDisplay_logo(driver, unitedeServicesLogo, "United eServices Logo");

		element = driver.findElement(uesQuote);
		System.out.println("Element Value ::" + element.getAttribute("value"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// element.click();

		element = driver.findElement(uesNewQuote);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

	}

	public void verifyLoginPage(WebDriver driver) {
		// utility.waitForVisibilityOfWebElement(By.xpath(".//*[@id='login']"),
		// driver);
		element = driver.findElement(By.xpath(".//*[@id='login']"));
		if (element.getText().contains("Log In")) {
			System.out.println("User Is on UeS login page");
		} else {
			System.out.println("User Is not in UeS login page");
		}
	}

	public void censusPage(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(1000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(1000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(1000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		int j = 1000;
		for (int i = 0; i <= count1 - 7; i++) {

			Random rand = new Random();
			int Low = 25;
			int High = 40;
			int Result = rand.nextInt(High - Low) + Low;

			int WifeAgeLow = 15;
			int WifeAgeHigh = 30;
			int WifeAgeResult = rand.nextInt(WifeAgeHigh - WifeAgeLow) + WifeAgeLow;

			int AgeLow = 12;
			int AgeHigh = 14;
			int ChildAge = rand.nextInt(AgeHigh - AgeLow) + AgeLow;

			int LowSal = 50000;
			int HighSal = 100000;
			int TotSal = rand.nextInt(HighSal - LowSal) + LowSal;

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys(Integer.toString(Result));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].spouseAge']"))
					.sendKeys(Integer.toString(WifeAgeResult));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].childrenToAdd']"))
					.sendKeys("1");
			Thread.sleep(1000);

			element = driver.findElement(By.xpath("//input[@id='add" + j + "']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//input[@name='censusDetailInformationForm[" + i + "].dependentChildren[0].age']"))
					.sendKeys(Integer.toString(ChildAge));
			Thread.sleep(500);

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].annualSalary']"))
					.sendKeys(Integer.toString(TotSal));
			Thread.sleep(500);
			j = j + 1000;
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(7000);
	}

	public void censusPage_Class1_2_Plans(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(1000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(1000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(1000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		int j = 1000;
		for (int i = 0; i <= count1 - 7; i++) {

			Random rand = new Random();
			int Low = 25;
			int High = 40;
			int Result = rand.nextInt(High - Low) + Low;

			int WifeAgeLow = 15;
			int WifeAgeHigh = 30;
			int WifeAgeResult = rand.nextInt(WifeAgeHigh - WifeAgeLow) + WifeAgeLow;

			int AgeLow = 12;
			int AgeHigh = 14;
			int ChildAge = rand.nextInt(AgeHigh - AgeLow) + AgeLow;

			int LowSal = 50000;
			int HighSal = 100000;
			int TotSal = rand.nextInt(HighSal - LowSal) + LowSal;

			if (i < 5) {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText("Class 1 - Class1");
			} else {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText("Class 2 - Class2");
			}

			if (i < 12) {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText("COBRA");
				Thread.sleep(1000);
				driver.findElement(By.name("censusDetailInformationForm[" + i + "].transEmploymentStatus")).sendKeys("C");
			}

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys(Integer.toString(Result));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].spouseAge']"))
					.sendKeys(Integer.toString(WifeAgeResult));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].childrenToAdd']"))
					.sendKeys("1");
			Thread.sleep(1000);

			element = driver.findElement(By.xpath("//input[@id='add" + j + "']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//input[@name='censusDetailInformationForm[" + i + "].dependentChildren[0].age']"))
					.sendKeys(Integer.toString(ChildAge));
			Thread.sleep(500);

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].annualSalary']"))
					.sendKeys(Integer.toString(TotSal));
			Thread.sleep(500);
			j = j + 1000;
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void censusPage_Class1_2_Plans_WithoutSal(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(1000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(1000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(1000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		int j = 1000;
		for (int i = 0; i <= count1 - 7; i++) {

			Random rand = new Random();
			int Low = 25;
			int High = 40;
			int Result = rand.nextInt(High - Low) + Low;

			int LowSal = 50000;
			int HighSal = 100000;
			int TotSal = rand.nextInt(HighSal - LowSal) + LowSal;

			if (i < 5) {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText("Class 1 - Class1");
			} else {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText("Class 2 - Class2");
			}

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys(Integer.toString(Result));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].annualSalary']"))
					.sendKeys(Integer.toString(TotSal));
			Thread.sleep(500);
			j = j + 1000;
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void censusPage_Class1_2_Plans_WithoutSalAndDep(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(1000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(1000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(1000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		int j = 1000;
		for (int i = 0; i <= count1 - 7; i++) {

			Random rand = new Random();
			int Low = 25;
			int High = 40;
			int Result = rand.nextInt(High - Low) + Low;

			int LowSal = 50000;
			int HighSal = 100000;
			int TotSal = rand.nextInt(HighSal - LowSal) + LowSal;

			if (i < 5) {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText("Class 1 - Class1");
			} else {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText("Class 2 - Class2");
			}

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys(Integer.toString(Result));
			Thread.sleep(500);
			j = j + 1000;
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void censusPage_OnlyEE_Salary(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(2000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(2000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(2000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);
		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		Random rand = new Random();
		int Low = 25;
		int High = 40;
		int Result = rand.nextInt(High - Low) + Low;
		System.out.println("Result ::" + Result);

		int j = 1000;
		for (int i = 0; i <= count1 - 7; i++) {
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys("25");
			Thread.sleep(1000);
			element = driver.findElement(By.xpath("//input[@id='add" + j + "']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].annualSalary']"))
					.sendKeys("500000");
			Thread.sleep(1000);
			j = j + 1000;
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
	}

	public void censusPageWithOutSal(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);

		utility.waitForVisibilityOfWebElement(By.xpath(".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]"), driver);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");

		QuotePage.verifyFooterLinks(driver);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		for (int i = 0; i <= count1 - 7; i++) {
			Random rand = new Random();
			int Low = 25;
			int High = 40;
			int Result = rand.nextInt(High - Low) + Low;
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys(Integer.toString(Result));
			Thread.sleep(500);
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
	}

	public void censusPage_Dep_EE_WithoutSalary(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";
		Thread.sleep(2000);

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(2000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(2000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(2000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		Random rand = new Random();
		int Low = 25;
		int High = 40;
		int Result = rand.nextInt(High - Low) + Low;
		System.out.println("Result ::" + Result);

		int j = 1000;
		for (int i = 0; i <= count1 - 7; i++) {
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys("25");
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].spouseAge']"))
					.sendKeys("22");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].childrenToAdd']"))
					.sendKeys("1");
			Thread.sleep(1000);

			element = driver.findElement(By.xpath("//input[@id='add" + j + "']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//input[@name='censusDetailInformationForm[" + i + "].dependentChildren[0].age']"))
					.sendKeys("14");
			Thread.sleep(1000);
			j = j + 1000;
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
	}

	public void censusPage_clickNext(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String censusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";
		QuotePage.verifyPageDisplay(driver, censusPage, "Census");

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");

		QuotePage.verifyFooterLinks(driver);

		driver.findElement(censusDetailInformationFormAge).sendKeys("14");
		Thread.sleep(1000);

		driver.findElement(censusDetailInformationFormAge1).sendKeys("14");
		Thread.sleep(1000);

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
	}

	public void medicalPlanPage(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(5000);
		String medicalPage = ".//*[@id='divContent']/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]";
		QuotePage.verifyPageDisplay(driver, medicalPage, "Medical Plans");
		Thread.sleep(5000);

		String medicalInfoTable = "//td[contains(text(),'Medical Plan Information')]";
		// String
		// medicalInformationTable=".//*[@id='divContent']/form/table/tbody/tr[12]/td/table/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, medicalInfoTable, "Medical Plan Information");
		Thread.sleep(2000);

		// QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(chkBoxmedicalInPackageForm);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		// QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(btnMedicalPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);

		String optionalMedicalRidersPage = "//td[contains(text(),'Optional Medical Riders')]";
		QuotePage.verifyPageDisplay(driver, optionalMedicalRidersPage, "Optional Medical Riders");
		Thread.sleep(2000);

		String optionalMedicalRiderInfoTable = "//td[contains(text(),'Medical Rider Information')]";
		QuotePage.verifyPageInfoTable(driver, optionalMedicalRiderInfoTable, "Medical Rider Information");
		Thread.sleep(2000);

		element = driver.findElement(btnOptionalMedicalPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(7000);
	}

	public void visionPlanPage(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		// Vision Plans
		String visionPlansPage = "//td[contains(text(),'Vision Plans')]";
		QuotePage.verifyPageDisplay(driver, visionPlansPage, "Vision Plans");

		String visionVisionPlanInfoTable = "//td[contains(text(),'Vision Plan Information')]";
		QuotePage.verifyPageInfoTable(driver, visionVisionPlanInfoTable, "Vision Plan Information");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(btnVisionPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
	}

	public void proposalInformationPage(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		// Proposal Information

		Thread.sleep(6000);

		String proposalInformationPage = "//td[contains(text(),'Proposal Information')]";
		QuotePage.verifyPageDisplay(driver, proposalInformationPage, "Proposal Information");
		Thread.sleep(1000);

		String proposalSetupTable = "//td[contains(text(),'Proposal Setup')]";
		QuotePage.verifyPageInfoTable(driver, proposalSetupTable, "Proposal Setup");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(btnPreviewProposal);
		System.out.println("PDF Value :" + element.getAttribute("value"));
		// System.out.println("PDF Value :"+element.getText());

		if (element.getAttribute("value").trim().contains("PREVIEW PROPOSAL")) {
			System.out.println("Proposal Preview PDF displayed successfully");
			Thread.sleep(1000);
			// driver.switchTo().window(handle1).close();
		}

		element = driver.findElement(btnPreviewProposal);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(15000);
		
		//String pwindow = driver.getWindowHandle();
		/*utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("proposalDocumentSetup")) {
				System.out.println("proposalDocumentSetup PDF displayed successfully");
				System.out.println("PDF URL :: " + driver.switchTo().window(winHandle).getCurrentUrl());
				Thread.sleep(5000);
				driver.switchTo().window(winHandle).close();
				// driver.close();
			}
		}*/

		/*driver.switchTo().window(pwindow);
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);*/

	}

	public void loginUeS(String usrname, String pwd) throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(uesUserName).sendKeys(usrname);
		Thread.sleep(1000);
		driver.findElement(uesPwd).sendKeys(pwd);
		Thread.sleep(1000);
		element = driver.findElement(uesLoginBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void clickCompensation(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(2000);

		element = driver.findElement(menuCompensation);
		System.out.println("Element Value ::" + element.getAttribute("value"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void verifyCompensationHome(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		QuotePage.verifyFooterLinks(driver);

		String compHome;
		compHome = driver.findElement(compHomeText).getText();
		// System.out.println("Compensation Home text ::"+compHome);

		String comSchedule;
		comSchedule = driver.findElement(compProducerPerformanceGuide).getText();
		// System.out.println("Producer Performance Guide text ::"+comSchedule);

		String comSchedule1;
		comSchedule1 = driver.findElement(compCommissionSchedule).getText();
		// System.out.println("Commission Schedule Text ::"+comSchedule1);

		String comSchedule2;
		comSchedule2 = driver.findElement(compCommissionStatements).getText();
		// System.out.println("Commission Statements text ::"+comSchedule2);

		String comSchedule3;
		comSchedule3 = driver.findElement(compRequestDirectDepositAuthorization).getText();
		// System.out.println("Request Direct Deposit Authorization text
		// ::"+comSchedule3);

		ACTList = new ArrayList<>();
		ACTList.add("Compensation Home");
		ACTList.add("Producer Performance Guide");
		ACTList.add("Commission Schedule");
		ACTList.add("Commission Statements");
		ACTList.add("Request Direct Deposit Authorization");

		EXPList = new ArrayList<>();
		EXPList.add(compHome);
		EXPList.add(comSchedule);
		EXPList.add(comSchedule1);
		EXPList.add(comSchedule2);
		EXPList.add(comSchedule3);

		// System.out.println("Size of ACTList ::" + ACTList.size() );
		// System.out.println("Size of EXPList ::" + EXPList.size() );
		int ExpFlag = 5;
		int Flag = 0;
		if (ACTList.size() == EXPList.size()) {

			for (int i = 0; i < ACTList.size(); i++) {
				if (((String) ACTList.get(i).trim()).equals((String) EXPList.get(i).trim())) {
					System.out.println("values are matching::" + ACTList.get(i) + ":" + EXPList.get(i));
					Flag = Flag + 1;
				} else {
					System.out.println("values are not matching::" + ACTList.get(i) + ":" + EXPList.get(i));
				}
			}
			if (Flag == ExpFlag) {
				System.out.println("Compensation Home page displayed with expected Data");
			} else {
				System.out.println("Compensation Home page not displayed with expected Data");
			}
		}

	}

	public void verifyLogin(String usrname, WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");

		String uesHome;
		uesHome = driver.findElement(loginUsername).getText();
		System.out.println("UeS Home Text ::" + uesHome);

		if (uesHome.contains("roshan")) {
			System.out.println("UeS Home page displayed successfully");
		} else {
			System.out.println("UeS Home page not displayed");
		}

		QuotePage.verifyFooterLinks(driver);
	}

	public void clickLink_Administration_ModifyLoggingLevels(WebDriver driver)
			throws InterruptedException, IOException {
		Thread.sleep(6000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("navbar");
		Thread.sleep(3000);

		// String unitedHealthcareLogo = "//img[@title='UnitedHealthcare
		// Logo']";
		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");

		// String unitedeServicesLogo = "//img[@title='United eServices Logo']";
		QuotePage.verifyPageDisplay_logo(driver, unitedeServicesLogo, "United eServices Logo");

		Thread.sleep(3000);
		element = driver.findElement(By.linkText("Administration"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		Thread.sleep(3000);

		String siteAdministrationPage = "//div[contains(text(),'Site Administration')]";
		QuotePage.verifyPageInfoTable(driver, siteAdministrationPage, "Site Administration");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(By.linkText("Modify Logging Levels"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
	}

	public void selectDropdown_Application_LoggingLevel(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);

		String modifyLoggingLevelsPage = "//td[contains(text(),'Modify Logging Levels')]";
		QuotePage.verifyPageDisplay(driver, modifyLoggingLevelsPage, "Modify Logging Levels");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(By.name("application"));
		Select appDropDown = new Select(element);
		appDropDown.selectByVisibleText("uespublicEAR");

		Thread.sleep(1000);

		element = driver.findElement(By.name("loggingLevel"));
		Select loglevelDropDown = new Select(element);
		loglevelDropDown.selectByVisibleText("DEBUG");

		Thread.sleep(1000);
		By loggingPagesubmitNext = By.xpath("//input[@name='submitNext' and @value='SUBMIT']");

		element = driver.findElement(loggingPagesubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void verifyMessage(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(3000);

		QuotePage.verifyUeSLogos(driver);

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(messageLoggingLevel);
		System.out.println("Logging Level Text::" + element.getText());

		if (element.getText().trim().contains("Modify Logging Levels Success")) {
			System.out.println("Modify Logging Levels Success");
		} else {
			System.out.println("Not Modify Logging Levels");
		}
	}

	public void verifyErrMessage(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);

		element = driver.findElement(errMessage);
		// System.out.println("Error Meassge ::"+element.getText());

		if (element.getText().contains("Employee's age must be greater than 14")) {
			System.out.println("Employee's age must be greater than 14 for employee");
		} else {
			System.out.println("Not displayed any err message for Employee age below 14");
		}

	}

	public void quoteSetupPage(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(200);
		driver.switchTo().frame("content");
		Thread.sleep(2000);

		String quoteSetUpInfoWindow = ".//*[@id='ui-dialog-title-dialogQuote']";
		// System.out.println("Quote Set Up Window text : :" +
		// driver.findElement(By.xpath(quoteSetUpInfoWindow)).getText());
		QuotePage.verifyPageDisplay(driver, quoteSetUpInfoWindow, "Quote Setup");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		// System.out.println(formatter.format(date));

		String str = formatter.format(date);
		String[] arrOfStr = str.split("/");

		// int i=Integer.parseInt(arrOfStr[0]);
		// System.out.println(arrOfStr[0]);

		driver.findElement(quotepolicyEffDateMonth).sendKeys(arrOfStr[1]);
		Thread.sleep(500);

		if (arrOfStr[0].compareTo("16") > 0) {
			driver.findElement(quotepolicyEffDateDay).sendKeys("15");
			Thread.sleep(500);
		} else {
			driver.findElement(quotepolicyEffDateDay).sendKeys("01");
			Thread.sleep(500);
		}

		driver.findElement(quotepolicyEffDateYear).sendKeys("19");
		Thread.sleep(500);

		Select cominfoState = new Select(driver.findElement(By.name("state")));
		cominfoState.selectByVisibleText(common.getState());
		// cominfoState.selectByVisibleText("CA");
		Thread.sleep(500);

		driver.findElement(quoteemployeeCount).clear();
		// driver.findElement(quoteemployeeCount).sendKeys("8");
		driver.findElement(quoteemployeeCount).sendKeys(common.getTotEligibleEmployess());
		Thread.sleep(500);

		// driver.findElement(By.name("atneCount")).sendKeys("5");
		// Thread.sleep(2000);

		driver.findElement(quoteatneCount1).clear();
		// driver.findElement(quoteatneCount1).sendKeys("8");
		driver.findElement(quoteatneCount1).sendKeys(common.getAvgTotEligibleEmployess());
		Thread.sleep(500);

		element = driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		// driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxstreetAddress).sendKeys(common.getAddress());
		Thread.sleep(500);

		// driver.findElement(txtBoxcityAddress).sendKeys("Site2");
		driver.findElement(txtBoxcityAddress).sendKeys(common.getCity());
		Thread.sleep(500);

		Select stateSel = new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");
		stateSel.selectByVisibleText(common.getState());

		// driver.findElement(txtBoxzipCode).sendKeys("90701");
		driver.findElement(txtBoxzipCode).sendKeys(common.getZipCode());
		Thread.sleep(500);

		// driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		Thread.sleep(500);

		driver.findElement(totNumActiveEmployeesApplying).clear();
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("8");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());
		Thread.sleep(500);

		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("8");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		Thread.sleep(500);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void M_V_quoteSetupPage(WebDriver driver) throws InterruptedException {
		// String pwindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(2000);

		String quoteSetUpInfoWindow = ".//*[@id='ui-dialog-title-dialogQuote']";
		// System.out.println("Quote Set Up Window text : :" +
		// driver.findElement(By.xpath(quoteSetUpInfoWindow)).getText());
		QuotePage.verifyPageDisplay(driver, quoteSetUpInfoWindow, "Quote Setup");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		// System.out.println(formatter.format(date));

		String str = formatter.format(date);
		String[] arrOfStr = str.split("/");

		// int i=Integer.parseInt(arrOfStr[0]);
		// System.out.println(arrOfStr[0]);

		driver.findElement(quotepolicyEffDateMonth).sendKeys(arrOfStr[1]);
		Thread.sleep(500);

		if (arrOfStr[0].compareTo("16") > 0) {
			driver.findElement(quotepolicyEffDateDay).sendKeys("15");
			Thread.sleep(500);
		} else {
			driver.findElement(quotepolicyEffDateDay).sendKeys("01");
			Thread.sleep(500);
		}

		driver.findElement(quotepolicyEffDateYear).sendKeys("19");
		Thread.sleep(500);

		Select cominfoState = new Select(driver.findElement(By.name("state")));
		// cominfoState.selectByVisibleText("CA");
		cominfoState.selectByVisibleText(common.getState());
		Thread.sleep(500);

		driver.findElement(quoteemployeeCount).clear();
		// driver.findElement(quoteemployeeCount).sendKeys("8");
		driver.findElement(quoteemployeeCount).sendKeys(common.getTotEligibleEmployess());
		Thread.sleep(500);

		// driver.findElement(By.name("atneCount")).sendKeys("5");
		// Thread.sleep(2000);

		driver.findElement(quoteatneCount1).clear();
		// driver.findElement(quoteatneCount1).sendKeys("8");
		driver.findElement(quoteatneCount1).sendKeys(common.getAvgTotEligibleEmployess());
		Thread.sleep(500);

		element = driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum_M_V");
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeDental);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		// driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxstreetAddress).sendKeys(common.getAddress());
		Thread.sleep(500);

		// driver.findElement(txtBoxcityAddress).sendKeys("Site2");
		driver.findElement(txtBoxcityAddress).sendKeys(common.getCity());
		Thread.sleep(500);

		Select stateSel = new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");
		stateSel.selectByVisibleText(common.getState());

		// driver.findElement(txtBoxzipCode).sendKeys("90701");
		driver.findElement(txtBoxzipCode).sendKeys(common.getZipCode());
		Thread.sleep(500);

		driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		Thread.sleep(500);

		driver.findElement(totNumActiveEmployeesApplying).clear();
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("8");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());
		Thread.sleep(500);

		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("8");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		Thread.sleep(1000);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void D_V_L_quoteSetupPage(WebDriver driver, String coverage) throws InterruptedException {

		// String pwindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(2000);

		String quoteSetUpInfoWindow = ".//*[@id='ui-dialog-title-dialogQuote']";
		// System.out.println("Quote Set Up Window text : :" +
		// driver.findElement(By.xpath(quoteSetUpInfoWindow)).getText());
		QuotePage.verifyPageDisplay(driver, quoteSetUpInfoWindow, "Quote Setup");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		// System.out.println(formatter.format(date));

		String str = formatter.format(date);
		String[] arrOfStr = str.split("/");

		// int i=Integer.parseInt(arrOfStr[0]);
		System.out.println(arrOfStr[0]);

		driver.findElement(quotepolicyEffDateMonth).sendKeys(arrOfStr[1]);
		Thread.sleep(500);

		if (arrOfStr[0].compareTo("16") > 0) {
			driver.findElement(quotepolicyEffDateDay).sendKeys("15");
			Thread.sleep(500);
		} else {
			driver.findElement(quotepolicyEffDateDay).sendKeys("01");
			Thread.sleep(500);
		}
		driver.findElement(quotepolicyEffDateYear).sendKeys("19");
		Thread.sleep(500);

		Select cominfoState = new Select(driver.findElement(By.name("state")));
		// cominfoState.selectByVisibleText("CA");
		cominfoState.selectByVisibleText(common.getState());
		Thread.sleep(500);

		driver.findElement(quoteemployeeCount).clear();
		// driver.findElement(quoteemployeeCount).sendKeys("8");
		driver.findElement(quoteemployeeCount).sendKeys(common.getTotEligibleEmployess());
		Thread.sleep(1000);

		// driver.findElement(By.name("atneCount")).sendKeys("5");
		// Thread.sleep(2000);

		driver.findElement(quoteatneCount1).clear();
		// driver.findElement(quoteatneCount1).sendKeys("8");
		driver.findElement(quoteatneCount1).sendKeys(common.getAvgTotEligibleEmployess());
		Thread.sleep(500);

		element = driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);

		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum_" +
		// coverage);
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeMedical);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		if (!coverage.equals("DVL")) {
			if (!coverage.equals("DV")) {
				if (!coverage.equals("DL")) {
					element = driver.findElement(ckhBoxProductTypeDental);
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(500);
				}
				if (!coverage.equals("VL")) {
					element = driver.findElement(ckhBoxProductTypeVision);
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(500);
				}
			}
			if (!coverage.equals("DL") && !coverage.equals("VL")) {
				element = driver.findElement(ckhBoxProductTypeLife);
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(500);
			}
		}

		element = driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		// driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxstreetAddress).sendKeys(common.getAddress());
		Thread.sleep(500);

		// driver.findElement(txtBoxcityAddress).sendKeys("Site2");
		driver.findElement(txtBoxcityAddress).sendKeys(common.getCity());
		Thread.sleep(500);

		Select stateSel = new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");
		stateSel.selectByVisibleText(common.getState());

		// driver.findElement(txtBoxzipCode).sendKeys("90701");
		driver.findElement(txtBoxzipCode).sendKeys(common.getZipCode());
		Thread.sleep(500);

		// driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		Thread.sleep(500);

		driver.findElement(totNumActiveEmployeesApplying).clear();
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("8");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());
		Thread.sleep(500);

		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("8");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		Thread.sleep(1000);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(500);

		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
	}

	public void dentalPlanPage(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(5000);
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);

		String dentalPlansPage = "//td[contains(text(),'Dental Plans')]";
		Thread.sleep(2000);
		QuotePage.verifyPageDisplay(driver, dentalPlansPage, "Dental Plans");

		String dentalPlanInformationTable = "//td[contains(text(),'Dental PPO/Indemnity Plan Information')]";
		QuotePage.verifyPageInfoTable(driver, dentalPlanInformationTable, "Dental PPO/Indemnity Plan Information");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(chkBoxdentalPlanInformationForm);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(chkBoxdentalPlanInformationForm1);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(btnsubmitNextDentalPLan);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void lifePlanPage(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String lifePlansPage = "//td[contains(text(),'Life Plans')]";
		QuotePage.verifyPageDisplay(driver, lifePlansPage, "Life Plans");

		String lifeBasicLifePlanInfoTable = "//td[contains(text(),'Basic Life Plan Information')]";
		QuotePage.verifyPageInfoTable(driver, lifeBasicLifePlanInfoTable, "Basic Life Plan Information");

		QuotePage.verifyFooterLinks(driver);

		// utility.waitForVisibilityOfWebElement(By.xpath(".//input[@name='calculatePercent']"),
		// driver);
		element = driver.findElement(chkBoxlifePlanBasicInformationForm);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		element = driver.findElement(btnsubmitNextlifePLan);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void verifyPageDisplay(WebDriver driver, String path, String pageName) throws InterruptedException {
		// driver.findElement(By.xpath(path)).getText().trim().contains(pageName);
		// Thread.sleep(5000);
		// element=driver.findElement(By.xpath(path));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (driver.findElement(By.xpath(path)).getText().trim().contains(pageName)) {
			System.out.println(pageName + " Page displayed successfully");
		} else {
			System.out.println(pageName + " Page not displayed");
		}

	}

	public static void verifyPageInfoTable(WebDriver driver, String path, String pageInfoTable)
			throws InterruptedException {
		// driver.findElement(By.xpath(path)).getText().trim().contains(pageName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// element=driver.findElement(By.xpath(path));
		if (driver.findElement(By.xpath(path)).getText().trim().contains(pageInfoTable)) {
			System.out.println(pageInfoTable + " table displayed successfully");
		} else {
			System.out.println(pageInfoTable + " table not displayed");
		}

	}

	public static void verifyPageDisplay_logo(WebDriver driver, By path, String pageName)
			throws InterruptedException, IOException {
		// element=driver.findElement(By.xpath(path));
		// utility.waitForVisibilityOfWebElement(By.xpath(path), driver);
		Thread.sleep(3000);
		if (driver.findElement(path).getAttribute("title").trim().contains(pageName)) {
			System.out.println(pageName + " displayed successfully");
		} else {
			System.out.println(pageName + " not displayed");
		}

	}

	public static void verifyUeSLogos(WebDriver driver) throws InterruptedException, IOException {
		driver.switchTo().defaultContent();
		Thread.sleep(2000);

		WebElement iframeSwitch = driver.findElement(By.name("navbar"));
		driver.switchTo().frame(iframeSwitch);

		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");

		QuotePage.verifyPageDisplay_logo(driver, unitedeServicesLogo, "United eServices Logo");

		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);
	}

	public void verifyUeSLogos_Home(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("navbar");
		Thread.sleep(6000);

		// utility.waitForVisibilityOfWebElement(unitedHealthcareLogo, driver);
		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");

		// utility.waitForVisibilityOfWebElement(unitedeServicesLogo, driver);
		QuotePage.verifyPageDisplay_logo(driver, unitedeServicesLogo, "United eServices Logo");
	}

	public static void verifyFooterLinks(WebDriver driver) throws InterruptedException {
		Thread.sleep(4000);
		By aboutUs = By.xpath("//a[contains(text(),'About Us')]");
		By privacyPolicy = By.xpath("//a[contains(text(),'Privacy')]");
		By termsOfUse = By.xpath("//a[contains(text(),'Terms of Use')]");

		String aboutUsText, privacyPolicyText, termsOfUseText;
		aboutUsText = driver.findElement(aboutUs).getText();
		privacyPolicyText = driver.findElement(privacyPolicy).getText();
		termsOfUseText = driver.findElement(termsOfUse).getText();

		if ((aboutUsText.contains("About Us")) && (privacyPolicyText.contains("Privacy"))
				&& (termsOfUseText.contains("Terms of Use"))) {
			System.out.println(aboutUsText + "," + privacyPolicyText + " and " + termsOfUseText
					+ " Footer links are displayed successfully");
		} else {
			System.out.println(aboutUsText + "," + privacyPolicyText + " and " + termsOfUseText
					+ " Footer links are not displayed");
		}

		// assertEquals("status is different than 0" ,"EXIT STATUS = 0",
		// status);
	}

	public void verifyUserName_Header_Footer(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// utility.waitforSwitchtoFrame(By.name("navbar"), driver);
		driver.switchTo().frame("navbar");
		// String unitedHealthcareLogo = "//img[@title='UnitedHealthcare
		// Logo']";
		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");

		// String unitedeServicesLogo = "//img[@title='United eServices Logo']";
		QuotePage.verifyPageDisplay_logo(driver, unitedeServicesLogo, "United eServices Logo");

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");

		String uesHome;
		uesHome = driver.findElement(loginUsername).getText();
		System.out.println("UeS Home Text ::" + uesHome);

		if (uesHome.contains("roshan")) {
			System.out.println("User Name :: " + uesHome + " displayed successfully");
		} else {
			System.out.println("User Name :: " + uesHome + " snot displayed");
		}

		QuotePage.verifyFooterLinks(driver);

	}

	public void quoteSetUpWindow(WebDriver driver, String state) throws InterruptedException {
		// String pwindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// utility.waitforSwitchtoFrame(By.xpath("content"), driver);
		driver.switchTo().frame("content");
		Thread.sleep(5000);

		utility.waitForVisibilityOfWebElement(By.xpath(".//*[@id='ui-dialog-title-dialogQuote']"), driver);
		String quoteSetUpInfoWindow = ".//*[@id='ui-dialog-title-dialogQuote']";
		QuotePage.verifyPageDisplay(driver, quoteSetUpInfoWindow, "Quote Setup");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		// System.out.println(formatter.format(date));

		String str = formatter.format(date);
		String[] arrOfStr = str.split("/");

		// int i=Integer.parseInt(arrOfStr[0]);
		// System.out.println(arrOfStr[0]);

		driver.findElement(quotepolicyEffDateMonth).sendKeys(arrOfStr[1]);
		Thread.sleep(500);

		if (arrOfStr[0].compareTo("16") > 0) {
			utility.waitForVisibilityOfWebElement(quotepolicyEffDateDay, driver);
			driver.findElement(quotepolicyEffDateDay).sendKeys("15");
			// Thread.sleep(1000);
		} else {
			utility.waitForVisibilityOfWebElement(quotepolicyEffDateDay, driver);
			driver.findElement(quotepolicyEffDateDay).sendKeys("01");
			// Thread.sleep(1000);
		}
		utility.waitForVisibilityOfWebElement(quotepolicyEffDateYear, driver);
		driver.findElement(quotepolicyEffDateYear).sendKeys("19");
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(By.name("state"), driver);
		Select cominfoState = new Select(driver.findElement(By.name("state")));
		cominfoState.selectByVisibleText(state);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(quoteemployeeCount, driver);
		driver.findElement(quoteemployeeCount).clear();
		// driver.findElement(quoteemployeeCount).sendKeys("8");
		driver.findElement(quoteemployeeCount).sendKeys(common.getTotEligibleEmployess());

		utility.waitForVisibilityOfWebElement(quoteatneCount1, driver);
		driver.findElement(quoteatneCount1).clear();
		// driver.findElement(quoteatneCount1).sendKeys("8");
		driver.findElement(quoteatneCount1).sendKeys(common.getAvgTotEligibleEmployess());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(quoteNextBtn, driver);
		element = driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
	}

	public void quoteSetUpWindow_Coverage_All(WebDriver driver, String state) throws InterruptedException {
		// String pwindow = driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// utility.waitforSwitchtoFrame(By.xpath("content"), driver);
		driver.switchTo().frame("content");
		Thread.sleep(5000);

		utility.waitForVisibilityOfWebElement(By.xpath(".//*[@id='ui-dialog-title-dialogQuote']"), driver);
		String quoteSetUpInfoWindow = ".//*[@id='ui-dialog-title-dialogQuote']";
		QuotePage.verifyPageDisplay(driver, quoteSetUpInfoWindow, "Quote Setup");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		// System.out.println(formatter.format(date));

		String str = formatter.format(date);
		String[] arrOfStr = str.split("/");

		// int i=Integer.parseInt(arrOfStr[0]);
		// System.out.println(arrOfStr[0]);

		driver.findElement(quotepolicyEffDateMonth).sendKeys(arrOfStr[1]);
		Thread.sleep(500);

		if (arrOfStr[0].compareTo("16") > 0) {
			utility.waitForVisibilityOfWebElement(quotepolicyEffDateDay, driver);
			driver.findElement(quotepolicyEffDateDay).sendKeys("15");
			// Thread.sleep(1000);
		} else {
			utility.waitForVisibilityOfWebElement(quotepolicyEffDateDay, driver);
			driver.findElement(quotepolicyEffDateDay).sendKeys("01");
			// Thread.sleep(1000);
		}
		utility.waitForVisibilityOfWebElement(quotepolicyEffDateYear, driver);
		driver.findElement(quotepolicyEffDateYear).sendKeys("19");
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(By.name("state"), driver);
		Select cominfoState = new Select(driver.findElement(By.name("state")));
		cominfoState.selectByVisibleText(state);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(quoteemployeeCount, driver);
		driver.findElement(quoteemployeeCount).clear();
		// driver.findElement(quoteemployeeCount).sendKeys("10");
		driver.findElement(quoteemployeeCount).sendKeys(common.getTotEligibleEmployess());

		// Thread.sleep(2000);
		utility.waitForVisibilityOfWebElement(quoteatneCount2, driver);
		driver.findElement(quoteatneCount2).clear();
		// driver.findElement(quoteatneCount2).sendKeys("10");
		driver.findElement(quoteatneCount2).sendKeys(common.getAvgTotEligibleEmployess());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(quoteNextBtn, driver);
		element = driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
	}

	public void quoteSetUpPageNew(WebDriver driver, String coverage, String zip) throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		// String pwindow = driver.getWindowHandle();
		utility.waitForVisibilityOfWebElement(quoteSetUpquoteType, driver);
		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteCompanyName, driver);
		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());

		if (coverage.trim().contains("Vision")) {
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeMedical);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeDental);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeLife);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeStd);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeLtd);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeEmpSupLife);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeDepSupLife);
		}

		if (coverage.trim().contains("Life")) {
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeMedical);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeDental);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeVision);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeStd);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeLtd);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeEmpSupLife);
			QuotePage.check_CheckBox(driver, ckhBoxProductTypeDepSupLife);
		}

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteCompanyName, driver);
		// driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxstreetAddress).sendKeys(common.getAddress());

		utility.waitForVisibilityOfWebElement(txtBoxcityAddress, driver);
		// driver.findElement(txtBoxcityAddress).sendKeys("Site1");
		driver.findElement(txtBoxcityAddress).sendKeys(common.getCity());

		// Select stateSel=new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");
		utility.waitForVisibilityOfWebElement(txtBoxzipCode, driver);
		driver.findElement(txtBoxzipCode).sendKeys(zip);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxSICCODE, driver);
		// driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		// Thread.sleep(1000);

		driver.findElement(totNumActiveEmployeesApplying).clear();
		utility.waitForVisibilityOfWebElement(totNumActiveEmployeesApplying, driver);
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("8");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxquoteTotalNumEmployees, driver);
		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("8");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		// Thread.sleep(1000);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void QuoteSetUpPage(WebDriver driver, String zip) throws InterruptedException {
		Thread.sleep(3000);
		utility.waitForVisibilityOfWebElement(
				By.xpath(".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]"), driver);
		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		utility.waitForVisibilityOfWebElement(By.xpath(".//*[@id='quoteForm']/table[3]/tbody/tr/td"), driver);
		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		// String pwindow = driver.getWindowHandle();
		utility.waitForVisibilityOfWebElement(quoteSetUpquoteType, driver);
		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteCompanyName, driver);
		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(ckhBoxProductTypeDental, driver);
		element = driver.findElement(ckhBoxProductTypeDental);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(ckhBoxProductTypeLife, driver);
		element = driver.findElement(ckhBoxProductTypeLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(ckhBoxProductTypeStd, driver);
		element = driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(ckhBoxProductTypeLtd, driver);
		element = driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(ckhBoxProductTypeEmpSupLife, driver);
		element = driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(ckhBoxProductTypeDepSupLife, driver);
		element = driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxstreetAddress, driver);
		// driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxstreetAddress).sendKeys(common.getAddress());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxcityAddress, driver);
		// driver.findElement(txtBoxcityAddress).sendKeys("Site1");
		driver.findElement(txtBoxcityAddress).sendKeys(common.getCity());

		utility.waitForVisibilityOfWebElement(txtBoxzipCode, driver);
		driver.findElement(txtBoxzipCode).sendKeys(zip);
		// Thread.sleep(5000);

		utility.waitForVisibilityOfWebElement(txtBoxSICCODE, driver);
		// driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(totNumActiveEmployeesApplying, driver);
		driver.findElement(totNumActiveEmployeesApplying).clear();
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("8");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxquoteTotalNumEmployees, driver);
		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("8");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(radioBtnMedicarePriPayer, driver);
		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Thread.sleep(2000);

		utility.waitForVisibilityOfWebElement(btnquoteSetUpNext, driver);
		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
	}

	public void verifyRatingMethodValue(WebDriver driver, String ratingmethodval)
			throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		// Thread.sleep(10000);
		utility.waitForVisibilityOfWebElement(
				By.xpath(".//*[@id='divContent']/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]"), driver);
		String medicalPage = ".//*[@id='divContent']/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]";
		QuotePage.verifyPageDisplay(driver, medicalPage, "Medical Plans");
		// Thread.sleep(10000);

		utility.waitForVisibilityOfWebElement(By.xpath("//td[contains(text(),'Medical Plan Information')]"), driver);
		String medicalInfoTable = "//td[contains(text(),'Medical Plan Information')]";
		QuotePage.verifyPageInfoTable(driver, medicalInfoTable, "Medical Plan Information");
		// Thread.sleep(4000);

		utility.waitForVisibilityOfWebElement(By.name("ratingMethodSelection"), driver);
		Select medicalRatingMethodVal = new Select(driver.findElement(By.name("ratingMethodSelection")));
		// Get all options
		List<WebElement> dd = medicalRatingMethodVal.getOptions();

		System.out.println(dd.size());

		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());
			if (dd.get(j).getText().contains(ratingmethodval)) {
				System.out.println(ratingmethodval + " value present in Medical Plan page");
			}
		}
	}

	public void medicalPlan_btnComparePlan(WebDriver driver) throws InterruptedException {

		// QuotePage.verifyFooterLinks(driver);
		By chkBoxmedicalInPackageForm_CA_TX = By.xpath("//input[@name='medicalInPackageForm[0].packageSelected']");
		By chkBox1medicalInPackageForm_WA = By.xpath(
				"//input[@name='medicalInPackageForm[0].medicalPlanInNetInformationForm[0].metallicLevelForm[0].selected']");
		By chkBox2medicalInPackageForm_WA = By.xpath(
				"//input[@name='medicalInPackageForm[0].medicalPlanInNetInformationForm[1].metallicLevelForm[0].selected']");

		element = driver.findElement(chkBoxmedicalInPackageForm_CA_TX);
		System.out.println("Value :: " + element.getAttribute("value"));
		System.out.println("onClick Value :: " + element.getAttribute("onclick"));
		if (element.getAttribute("value").contains("on")
				&& (element.getAttribute("onclick").contains("checkUncheckPackageAll"))) {
			System.out.println("Check Box in Medical page Value:: " + element.getAttribute("value"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}
		// else if(element.getAttribute("value").contains("on")){
		else {
			element = driver.findElement(chkBox1medicalInPackageForm_WA);
			System.out.println("Check Box1 in Medical page by using WA State Value:: " + element.getAttribute("value"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			element = driver.findElement(chkBox2medicalInPackageForm_WA);
			System.out.println("Check Box2 in Medical page by using WA State Value:: " + element.getAttribute("value"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}

		By btnSubmitRateCompare = By.xpath("//input[@name='submitRateCompare']");
		element = driver.findElement(btnSubmitRateCompare);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		// QuotePage.verifyFooterLinks(driver);
	}

	public void btnMedicalPlansubmitNext(WebDriver driver) throws InterruptedException {
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(2000);
		element = driver.findElement(btnMedicalPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
	}

	public void pageOptionalMedicalRiders(WebDriver driver) throws InterruptedException {
		String optionalMedicalRidersPage = "//td[contains(text(),'Optional Medical Riders')]";
		QuotePage.verifyPageDisplay(driver, optionalMedicalRidersPage, "Optional Medical Riders");
		Thread.sleep(2000);

		String optionalMedicalRiderInfoTable = "//td[contains(text(),'Medical Rider Information')]";
		QuotePage.verifyPageInfoTable(driver, optionalMedicalRiderInfoTable, "Medical Rider Information");
		Thread.sleep(2000);

		element = driver.findElement(btnOptionalMedicalPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void pageMedicalRateComparison(WebDriver driver, String info) throws InterruptedException {
		String pwindow = driver.getWindowHandle();

		for (String handle1 : driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
			String pageURL = driver.getCurrentUrl();
			if (pageURL.contains("medicalPlanSelection")) {
				if (info.contains("2 Tier")) {
					String txtemployeeClass;
					By employeeClass = By.xpath(
							".//*[@id='divContent']/form/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td");
					txtemployeeClass = driver.findElement(employeeClass).getText();
					if (txtemployeeClass.trim().contains("Under 21")) {
						System.out.println("Under 21 is present in Medical Rate Comparison page");
						// driver.close();
						driver.switchTo().window(handle1).close();
					}
				}

				if (info.contains("4 Tier")) {
					String txtemployeeClass;
					By employeeClass = By.xpath("//td[contains(.,'Four Tier for ACR Table')]");
					txtemployeeClass = driver.findElement(employeeClass).getText();
					if (txtemployeeClass.trim().contains("Four Tier for ACR Table")) {
						System.out.println("Four Tier for ACR Table is present in Medical Rate Comparison page");
						// driver.close();
						driver.switchTo().window(handle1).close();
					}
				}
				if (info.contains("Age Banded for ACR")) {
					String txtemployeeClass;
					By employeeClass = By.xpath("//div[@class='sectionHeading11 divHeading11']");
					txtemployeeClass = driver.findElement(employeeClass).getText();
					if (txtemployeeClass.trim().contains("Age Banded for ACR")) {
						System.out.println("Age Banded for ACR Table is present in Medical Rate Comparison page");
						// driver.close();
						Thread.sleep(3000);
						driver.switchTo().window(handle1).close();
					}
				}
			}
		}
		driver.switchTo().window(pwindow);
	}

	public void btnSubmitGenerateProposal(WebDriver driver) throws InterruptedException, AWTException, IOException {
		QuotePage.verifyUeSLogos(driver);
		// Proposal Information

		// Thread.sleep(8000);
		utility.waitForVisibilityOfWebElement(By.xpath("//td[contains(text(),'Proposal Information')]"), driver);
		String proposalInformationPage = "//td[contains(text(),'Proposal Information')]";
		QuotePage.verifyPageDisplay(driver, proposalInformationPage, "Proposal Information");
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(By.xpath("//td[contains(text(),'Proposal Setup')]"), driver);
		String proposalSetupTable = "//td[contains(text(),'Proposal Setup')]";
		QuotePage.verifyPageInfoTable(driver, proposalSetupTable, "Proposal Setup");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(btnPreviewProposal);
		System.out.println("PDF Value :" + element.getAttribute("value"));
		// System.out.println("PDF Value :"+element.getText());

		if (element.getAttribute("value").trim().contains("PREVIEW PROPOSAL")) {
			System.out.println("Proposal Preview PDF displayed successfully");
			Thread.sleep(2000);
			// driver.switchTo().window(handle1).close();
		}

		element = driver.findElement(btnPreviewProposal);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(15000);
	}

	public void testingUeS(WebDriver driver) throws InterruptedException {
		// Quote Window
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(2000);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		// System.out.println(formatter.format(date));

		String str = formatter.format(date);
		String[] arrOfStr = str.split("/");

		driver.findElement(quotepolicyEffDateMonth).sendKeys(arrOfStr[1]);
		Thread.sleep(1000);

		if (arrOfStr[0].compareTo("16") > 0) {
			driver.findElement(quotepolicyEffDateDay).sendKeys("15");
			Thread.sleep(1000);
		} else {
			driver.findElement(quotepolicyEffDateDay).sendKeys("01");
			Thread.sleep(1000);
		}

		driver.findElement(quotepolicyEffDateYear).sendKeys("19");
		Thread.sleep(1000);

		Select cominfoState = new Select(driver.findElement(By.name("state")));
		cominfoState.selectByVisibleText("WA");
		Thread.sleep(1000);

		driver.findElement(quoteemployeeCount).clear();
		driver.findElement(quoteemployeeCount).sendKeys("8");
		Thread.sleep(1000);

		driver.findElement(quoteatneCount1).clear();
		driver.findElement(quoteatneCount1).sendKeys("8");
		Thread.sleep(1000);

		element = driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);

		// Quote SetUp page
		// String pwindow = driver.getWindowHandle();
		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		quoteType.selectByVisibleText("New Business");

		driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		Thread.sleep(1000);

		element = driver.findElement(ckhBoxProductTypeDental);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(ckhBoxProductTypeLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		Thread.sleep(1000);

		driver.findElement(txtBoxcityAddress).sendKeys("Site1");
		Thread.sleep(1000);

		// Select stateSel=new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");

		driver.findElement(txtBoxzipCode).sendKeys("98001");
		Thread.sleep(1000);

		driver.findElement(txtBoxSICCODE).sendKeys("9111");
		Thread.sleep(1000);

		/*
		 * element = driver.findElement(linkAutomatedLookup); executor =
		 * (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", element);
		 * Thread.sleep(20000);
		 * 
		 * for (String handle1 : driver.getWindowHandles()) { //
		 * System.out.println("Child window : :" + handle1);
		 * driver.switchTo().window(handle1);
		 * System.out.println("Before page URL :: " +
		 * driver.switchTo().window(handle1).getCurrentUrl()); if
		 * (driver.switchTo().window(handle1).getCurrentUrl().contains(
		 * "sicInputSetup")) { // Thread.sleep(18000);
		 * System.out.println("sicInputSetup page URL :: " +
		 * driver.switchTo().window(handle1).getCurrentUrl()); String
		 * sicInputWindow = "//td[@class='sectionHeading11']";
		 * QuotePage.verifyPageDisplay(driver, sicInputWindow, "SIC Input");
		 * 
		 * Thread.sleep(2000); element = driver.findElement(radioBtnSIC);
		 * executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", element);
		 * Thread.sleep(2000);
		 * 
		 * driver.findElement(By.xpath("//input[@class='contentText8']")).
		 * sendKeys("9111"); Thread.sleep(1000);
		 * 
		 * By btnSicInputSubmit = By.xpath("//input[@type='submit']"); element =
		 * driver.findElement(btnSicInputSubmit); executor =
		 * (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", element);
		 * Thread.sleep(1000); // driver.switchTo().window(handle1).close(); //
		 * driver.close(); } // System.out.println("Inside Window"); // break; }
		 * 
		 * 
		 * element=driver.findElement(linklookupLink); executor =
		 * (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", element);
		 * Thread.sleep(5000);
		 * 
		 * 
		 * // driver.switchTo().defaultContent();
		 * driver.switchTo().window(pwindow); Thread.sleep(5000);
		 * driver.switchTo().frame("content"); Thread.sleep(3000);
		 */
		driver.findElement(totNumActiveEmployeesApplying).clear();
		driver.findElement(totNumActiveEmployeesApplying).sendKeys("8");
		Thread.sleep(1000);

		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("8");
		Thread.sleep(1000);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(btnquoteSetUpNext, driver);
		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + " Row Count  ::" + (count1 - 7));

		for (int i = 0; i <= count1 - 7; i++) {
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys("23");
			Thread.sleep(500);
		}

		utility.waitForVisibilityOfWebElement(censussubmitNext, driver);
		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);

		utility.waitForVisibilityOfWebElement(chkBoxmedicalInPackageForm, driver);
		element = driver.findElement(chkBoxmedicalInPackageForm);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForVisibilityOfWebElement(btnMedicalPlansubmitNext, driver);
		element = driver.findElement(btnMedicalPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);

		utility.waitForVisibilityOfWebElement(btnOptionalMedicalPlansubmitNext, driver);
		element = driver.findElement(btnOptionalMedicalPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);

		utility.waitForVisibilityOfWebElement(btnVisionPlansubmitNext, driver);
		element = driver.findElement(btnVisionPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);

		utility.waitForVisibilityOfWebElement(btnPreviewProposal, driver);
		element = driver.findElement(btnPreviewProposal);
		System.out.println("PDF Value :" + element.getAttribute("value"));
		// System.out.println("PDF Value :"+element.getText());

		if (element.getAttribute("value").trim().contains("PREVIEW PROPOSAL")) {
			System.out.println("Proposal Preview PDF displayed successfully");
			Thread.sleep(1000);
			// driver.switchTo().window(handle1).close();
		}

		/*
		 * element=driver.findElement(btnPreviewProposal); executor =
		 * (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", element);
		 * Thread.sleep(15000);
		 */

		Thread.sleep(1000);
		By submitGenerateProposal = By.xpath("//input[@name='submitGenerateProposal']");
		driver.findElement(submitGenerateProposal).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		/*
		 * driver.findElement(submitGenerateProposal).sendKeys(Keys.CONTROL ,
		 * Keys.SUBTRACT);
		 * 
		 * element=driver.findElement(submitGenerateProposal); //executor =
		 * (JavascriptExecutor)driver;
		 * //executor.executeScript("arguments[0].click();", element);
		 * 
		 * //element.submit(); element.click();
		 * //driver.findElement(submitGenerateProposal).sendKeys(Keys.CONTROL,
		 * Keys.CONTROL.ADD); Thread.sleep(5000);
		 */

		Boolean popupStatus = utility.isAlertPresent(driver);
		if (popupStatus == true) {
			Alert alert = driver.switchTo().alert();
			System.out.println("ALert..." + alert.getText());
			System.out.println("Goes to Accept");
			alert.accept();
		}
		Thread.sleep(15000);

		/*
		 * new WebDriverWait(driver,
		 * 10).until(ExpectedConditions.alertIsPresent());
		 * driver.switchTo().alert().accept();
		 * 
		 * Robot r = new Robot(); r.keyPress(KeyEvent.VK_ENTER);
		 * r.keyRelease(KeyEvent.VK_ENTER);
		 */

		Thread.sleep(2000);
		for (String handle1 : driver.getWindowHandles()) {
			// System.out.println("Child window : :" + handle1);
			driver.switchTo().window(handle1);
			String pdfTitle = driver.switchTo().window(handle1).getTitle();
			String pdfTitle1 = driver.switchTo().window(handle1).getCurrentUrl();
			System.out.println("PDF Title is ::" + pdfTitle);
			System.out.println("PDF Title URL is ::" + pdfTitle1);
			if ((pdfTitle.contains("proposalDocumentSetup")) || (pdfTitle1.contains("proposalDocumentSetup"))) {
				System.out.println("Proposal PDF page displayed successfully");
				Thread.sleep(2000);
				driver.switchTo().window(handle1).close();
			}
		}
	}

	public void clickCheckBoxes(WebDriver driver) {
		element = driver.findElement(ckhBoxProductTypeMedical);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeVision);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

	}

	public void dentalQuoteSetUpPage(WebDriver driver, String zip) throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		// String pwindow = driver.getWindowHandle();
		utility.waitForVisibilityOfWebElement(quoteSetUpquoteType, driver);
		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteCompanyName, driver);
		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());

		element = driver.findElement(ckhBoxProductTypeMedical);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeVision);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxcityAddress).sendKeys("Site1");

		// Select stateSel=new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");

		utility.waitForVisibilityOfWebElement(txtBoxzipCode, driver);
		driver.findElement(txtBoxzipCode).sendKeys(zip);
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxSICCODE, driver);
		// driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(totNumActiveEmployeesApplying, driver);
		driver.findElement(totNumActiveEmployeesApplying).clear();
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("8");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());

		utility.waitForVisibilityOfWebElement(txtBoxquoteTotalNumEmployees, driver);
		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("8");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		// Thread.sleep(1000);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void verifyDisplayPlans_SelectPlanCode(WebDriver driver, String displayPlan) throws InterruptedException {
		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
		Select medicalRatingMethodVal = new Select(driver.findElement(By.name("planDisplaySelection")));
		// Get all options
		List<WebElement> dd = medicalRatingMethodVal.getOptions();
		System.out.println(dd.size());

		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());
			// Show All Plans
			// Show My Selected Plans
			if (dd.get(j).getText().contains(displayPlan)) {
				System.out.println(displayPlan + " present in Display Plans drop down");
				medicalRatingMethodVal.selectByVisibleText(displayPlan);
				if ((displayPlan.contains("Most Popular Plans") || (displayPlan.contains("Show All Plans")))) {
					System.out.println("inside if ::" + displayPlan);
					Thread.sleep(1000);
					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(10000);

					utility.waitForVisibilityOfWebElement(
							By.xpath("//input[@name='dentalPlanInformationForm[0].selectInd']"), driver);
					element = driver.findElement(By.xpath("//input[@name='dentalPlanInformationForm[0].selectInd']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);

					utility.waitForVisibilityOfWebElement(
							By.xpath("//input[@name='dentalPlanInformationForm[1].selectInd']"), driver);
					element = driver.findElement(By.xpath("//input[@name='dentalPlanInformationForm[1].selectInd']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(1000);
					break;
				}

				if (displayPlan.contains("Show My Selected Plans")) {

					utility.waitForVisibilityOfWebElement(
							By.xpath("//input[@name='dentalPlanInformationForm[0].selectInd']"), driver);
					element = driver.findElement(By.xpath("//input[@name='dentalPlanInformationForm[0].selectInd']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);

					utility.waitForVisibilityOfWebElement(
							By.xpath("//input[@name='dentalPlanInformationForm[1].selectInd']"), driver);
					element = driver.findElement(By.xpath("//input[@name='dentalPlanInformationForm[1].selectInd']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(1000);

					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
					break;
				}

			}
		}
	}

	public void verifyDisplayPlan_SelectPlanCode(WebDriver driver, String displayPlan)
			throws InterruptedException, IOException {
		Thread.sleep(5000);
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(5000);

		String dentalPlansPage = "//td[contains(text(),'Dental Plans')]";
		Thread.sleep(2000);
		QuotePage.verifyPageDisplay(driver, dentalPlansPage, "Dental Plans");

		QuotePage.verifyFooterLinks(driver);

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
		Select medicalRatingMethodVal = new Select(driver.findElement(By.name("planDisplaySelection")));
		// Get all options
		List<WebElement> dd = medicalRatingMethodVal.getOptions();
		System.out.println(dd.size());

		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());

			if (dd.get(j).getText().contains(displayPlan)) {
				System.out.println(displayPlan + " present in Display Plans drop down");
				medicalRatingMethodVal.selectByVisibleText(displayPlan);
				if ((displayPlan.contains("Most Popular Plans")) || (displayPlan.contains("Show All Plans"))) {
					System.out.println("inside if ::" + displayPlan);
					Thread.sleep(1000);
					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(10000);
					break;
				}
			}
		}
	}

	public void verifyDisplayPlans_SelectPlanCode_HMO(WebDriver driver, String displayPlan)
			throws InterruptedException {
		if ((displayPlan.contains("Most Popular Plans"))) {
			System.out.println("inside if ::" + displayPlan);
			Thread.sleep(1000);

			utility.waitForVisibilityOfWebElement(
					By.xpath("//input[@name='dentalPlanHMOInformationForm[0].dhmoSelectInd']"), driver);
			element = driver.findElement(By.xpath("//input[@name='dentalPlanHMOInformationForm[0].dhmoSelectInd']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(1000);

			String textHMO = driver
					.findElement(By
							.xpath(".//*[@name='DentalPlanSelectionForm']/table/tbody/tr[14]/td/table/tbody/tr[5]/td[6]"))
					.getText();

			if (textHMO.contains("DHMO")) {
				System.out.println("DHMO is present in Dental HMO Plan Information table for selected " + displayPlan);
			} else {
				System.out.println("DHMO not present in Dental HMO Plan Information table for selected " + displayPlan);
			}
		}
		if ((displayPlan.contains("Show All Plans"))) {
			System.out.println("inside if ::" + displayPlan);
			Thread.sleep(1000);
			utility.waitForVisibilityOfWebElement(
					By.xpath("//input[@name='dentalPlanHMOInformationForm[0].dhmoSelectInd']"), driver);
			element = driver.findElement(By.xpath("//input[@name='dentalPlanHMOInformationForm[0].dhmoSelectInd']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			utility.waitForVisibilityOfWebElement(
					By.xpath("//input[@name='dentalPlanHMOInformationForm[1].dhmoSelectInd']"), driver);
			element = driver.findElement(By.xpath("//input[@name='dentalPlanHMOInformationForm[1].dhmoSelectInd']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			String textHMO1 = driver
					.findElement(By
							.xpath(".//*[@name='DentalPlanSelectionForm']/table/tbody/tr[14]/td/table/tbody/tr[5]/td[6]"))
					.getText();
			String textHMO2 = driver
					.findElement(By
							.xpath(".//*[@name='DentalPlanSelectionForm']/table/tbody/tr[14]/td/table/tbody/tr[6]/td[6]"))
					.getText();

			if ((textHMO1.contains("DHMO") && (textHMO2.contains("DHMO")))) {
				System.out.println(
						"DHMO content is present in Dental HMO Plan Information table for selected " + displayPlan);
			} else {
				System.out.println(
						"DHMO content not present in Dental HMO Plan Information table of selected " + displayPlan);
			}
		}
	}

	public void verifyHMO_clikHMOTab(WebDriver driver) throws InterruptedException {
		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitHMOPlans' and @value='HMO']"), driver);
		String nameHMOTab = driver.findElement(By.xpath("//input[@name='submitHMOPlans' and @value='HMO']"))
				.getAttribute("name");
		System.out.println("HMO tab Name :: " + nameHMOTab);

		if (nameHMOTab.contains("HMO")) {
			System.out.println("HMO tab present on Dental Plans page");
			utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitHMOPlans' and @value='HMO']"), driver);
			element = driver.findElement(By.xpath("//input[@name='submitHMOPlans' and @value='HMO']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(3000);
		} else {
			System.out.println("HMO tab not present on Dental Plans page");
		}

	}

	public void verifyDisplayPlans_clickBtnCOMPSELPLAN(WebDriver driver, String displayPlan)
			throws InterruptedException {
		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
		Select medicalRatingMethodVal = new Select(driver.findElement(By.name("planDisplaySelection")));
		// Get all options
		List<WebElement> dd = medicalRatingMethodVal.getOptions();
		System.out.println(dd.size());

		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());
			// Show All Plans
			// Show My Selected Plans
			if (dd.get(j).getText().contains(displayPlan)) {
				System.out.println(displayPlan + " present in Display Plans drop down");
				medicalRatingMethodVal.selectByVisibleText(displayPlan);
				if ((displayPlan.contains("Most Popular Plans")) || (displayPlan.contains("Show My Selected Plans"))) {
					System.out.println("inside if ::" + displayPlan);
					Thread.sleep(1000);
					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(10000);
					break;
				}
				if ((displayPlan.contains("Show All Plans"))) {
					System.out.println("inside if ::" + displayPlan);
					Thread.sleep(1000);
					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(10000);

					By planCode1 = By.xpath("//input[@name='visionPlanDetailForm[0].selectInd']");
					By planCode2 = By.xpath("//input[@name='visionPlanDetailForm[1].selectInd']");

					element = driver.findElement(planCode1);
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(1000);
					element = driver.findElement(planCode2);
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					// QuotePage.check_CheckBox(driver,planCode1);
					// QuotePage.check_CheckBox(driver,planCode2);
					Thread.sleep(1000);
					break;
				}
			}
		}
	}

	public void verifyDisplayPlans_SelectPlanCode_CompareRates(WebDriver driver, String displayPlan)
			throws InterruptedException {
		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
		Select medicalRatingMethodVal = new Select(driver.findElement(By.name("planDisplaySelection")));
		// Get all options
		List<WebElement> dd = medicalRatingMethodVal.getOptions();
		System.out.println(dd.size());

		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());
			// Show All Plans
			// Show My Selected Plans
			if (dd.get(j).getText().contains(displayPlan)) {
				System.out.println(displayPlan + " present in Display Plans drop down");
				medicalRatingMethodVal.selectByVisibleText(displayPlan);
				if ((displayPlan.contains("Most Popular Plans")) || (displayPlan.contains("Show All Plans"))) {
					System.out.println("inside if ::" + displayPlan);
					Thread.sleep(1000);
					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(10000);

					utility.waitForVisibilityOfWebElement(
							By.xpath("//input[@name='dentalPlanInformationForm[0].selectInd']"), driver);
					element = driver.findElement(By.xpath("//input[@name='dentalPlanInformationForm[0].selectInd']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);

					utility.waitForVisibilityOfWebElement(
							By.xpath("//input[@name='dentalPlanInformationForm[1].selectInd']"), driver);
					element = driver.findElement(By.xpath("//input[@name='dentalPlanInformationForm[1].selectInd']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(1000);
					break;
				}

				if (displayPlan.contains("Show My Selected Plans")) {
					utility.waitForVisibilityOfWebElement(
							By.xpath("//input[@name='dentalPlanInformationForm[0].selectInd']"), driver);
					element = driver.findElement(By.xpath("//input[@name='dentalPlanInformationForm[0].selectInd']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);

					utility.waitForVisibilityOfWebElement(
							By.xpath("//input[@name='dentalPlanInformationForm[1].selectInd']"), driver);
					element = driver.findElement(By.xpath("//input[@name='dentalPlanInformationForm[1].selectInd']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(1000);

					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(5000);
					break;
				}

			}
		}
	}

	public void verifyANNUALPREMIUM_BENEFIT_Vision(WebDriver driver) throws InterruptedException {

		element = driver.findElement(
				By.xpath(".//*[@name='VisionPlanSelectionForm']/table/tbody/tr[15]/td/table/tbody/tr[4]/td[2]"));
		String code1 = element.getText();
		System.out.println("BENEFIT Before Code1::" + code1);

		element = driver.findElement(
				By.xpath(".//*[@name='VisionPlanSelectionForm']/table/tbody/tr[15]/td/table/tbody/tr[5]/td[2]"));
		String code2 = element.getText();
		System.out.println("BENEFIT Before Code2::" + code2);
		Thread.sleep(5000);
		// String winHandleBefore = driver.getWindowHandle();

		// input[@name='submitRateCompare']
		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitPlanCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitPlanCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("SBQuoteWeb")) {

				List<WebElement> ele4 = driver.findElements(By.xpath(
						".//*[@name='VisionPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count1 = ele4.size();

				System.out.println("Row Count :: " + count1);
				for (int i = 1; i <= count1; i++) {
					element = driver.findElement(By
							.xpath(".//*[@name='VisionPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ i + "]"));
					// System.out.println("Text"+i + "::" +element.getText());
					if (element.getText().trim().contains("ANNUAL PREMIUM")) {
						System.out.println("ANNUAL PREMIUM present in Vision Plan Details table");
						element = driver.findElement(By.xpath(
								".//*[@name='VisionPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[2]/table/tbody/tr[21]/td"));
						System.out.println("ANNUAL PREMIUM Amount ::" + element.getText());

						String AnnualPremium1 = element.getText().substring(1, 6);
						String[] AnnulPremium_1 = AnnualPremium1.split("\\.");

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='VisionPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[3]/table/tbody/tr[21]/td"));
						System.out.println("ANNUAL PREMIUM Amount ::" + element1.getText());

						String AnnualPremium2 = element1.getText().substring(1, 6);
						String[] AnnulPremium_2 = AnnualPremium2.split("\\.");

						if ((Integer.parseInt(AnnulPremium_1[0]) != 0) && (Integer.parseInt(AnnulPremium_2[0]) != 0)) {
							System.out.println("ANNUAL PREMIUM Amounts ::" + element.getText() + " and "
									+ element1.getText() + " displayed successfully");
							// driver.switchTo().window(winHandle).close();
						} else {
							System.out.println("ANNUAL PREMIUM Amount ::" + element.getText() + " and "
									+ element1.getText() + "not displayed");
						}
					}

				}

				List<WebElement> ele5 = driver.findElements(By.xpath(
						".//*[@name='VisionPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count2 = ele5.size();

				System.out.println("Row Count :: " + count2);
				for (int j = 1; j <= count2; j++) {
					element = driver.findElement(By
							.xpath(".//*[@name='VisionPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ j + "]"));
					// System.out.println("Text"+i + "::" +element.getText());
					if (element.getText().trim().contains("BENEFIT")) {
						System.out.println("BENEFIT present in Vision Plan Details table");

						element = driver.findElement(By.xpath(
								".//*[@name='VisionPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[2]/table/tbody/tr[7]/td"));
						System.out.println("BENEFIT code1 ::" + element.getText());

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='VisionPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[3]/table/tbody/tr[7]/td"));
						System.out.println("BENEFIT code2 ::" + element1.getText());

						if ((element.getText().contains(code1)) && (element1.getText().contains(code2))) {
							System.out.println("PLAN CODES ::" + element.getText() + " and " + element1.getText()
									+ " displayed successfully");
							Thread.sleep(1000);
							driver.switchTo().window(winHandle).close();
							break;
						} else {
							System.out.println("PLAN CODES ::" + element.getText() + " and " + element1.getText()
									+ " not displayed");
						}
					}
				}
			}

		}
	}

	public void verifyANNUALPREMIUM_BENEFIT(WebDriver driver) throws InterruptedException {

		element = driver.findElement(
				By.xpath("//form[@name='DentalPlanSelectionForm']/table/tbody/tr[15]/td/table/tbody/tr[5]/td[2]"));
		String code1 = element.getText();
		System.out.println("BENEFIT Before Code1::" + code1);

		element = driver.findElement(
				By.xpath("//form[@name='DentalPlanSelectionForm']/table/tbody/tr[15]/td/table/tbody/tr[6]/td[2]"));
		String code2 = element.getText();
		System.out.println("BENEFIT Before Code2::" + code2);
		Thread.sleep(5000);
		// String winHandleBefore = driver.getWindowHandle();

		// input[@name='submitRateCompare']
		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitPlanCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitPlanCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("SBQuoteWeb")) {

				List<WebElement> ele4 = driver.findElements(By.xpath(
						".//*[@name='DentalPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count1 = ele4.size();

				System.out.println("Row Count :: " + count1);
				for (int i = 1; i <= count1; i++) {
					element = driver.findElement(By
							.xpath(".//*[@name='DentalPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ i + "]"));
					// System.out.println("Text"+i + "::" +element.getText());
					if (element.getText().trim().contains("ANNUAL PREMIUM")) {
						System.out.println("ANNUAL PREMIUM present in Dental PPO/Indemnity Plan Details table");
						element = driver.findElement(By.xpath(
								".//*[@name='DentalPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[2]/table/tbody/tr[36]/td"));
						System.out.println("ANNUAL PREMIUM Amount ::" + element.getText());

						String AnnualPremium1 = element.getText().substring(1, 8);
						String[] AnnulPremium_1 = AnnualPremium1.split(",");

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='DentalPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[3]/table/tbody/tr[36]/td"));
						System.out.println("ANNUAL PREMIUM Amount ::" + element1.getText());

						String AnnualPremium2 = element1.getText().substring(1, 8);
						String[] AnnulPremium_2 = AnnualPremium2.split(",");

						if ((Integer.parseInt(AnnulPremium_1[0]) != 0) && (Integer.parseInt(AnnulPremium_2[0]) != 0)) {
							System.out.println("ANNUAL PREMIUM Amounts ::" + element.getText() + " and "
									+ element1.getText() + " displayed successfully");
							// driver.switchTo().window(winHandle).close();
						} else {
							System.out.println("ANNUAL PREMIUM Amount ::" + element.getText() + " and "
									+ element1.getText() + "not displayed");
						}
					}

				}

				List<WebElement> ele5 = driver.findElements(By.xpath(
						".//*[@name='DentalPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count2 = ele5.size();

				System.out.println("Row Count :: " + count2);
				for (int j = 1; j <= count2; j++) {
					element = driver.findElement(By
							.xpath(".//*[@name='DentalPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ j + "]"));
					// System.out.println("Text"+i + "::" +element.getText());
					if (element.getText().trim().contains("BENEFIT")) {
						System.out.println("BENEFIT present in Dental PPO/Indemnity Plan Details table");

						element = driver.findElement(By.xpath(
								".//*[@name='DentalPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[2]/table/tbody/tr[26]/td"));
						System.out.println("BENEFIT code1 ::" + element.getText());

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='DentalPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[3]/table/tbody/tr[26]/td"));
						System.out.println("BENEFIT code2 ::" + element1.getText());

						if ((element.getText().contains(code1)) && (element1.getText().contains(code2))) {
							System.out.println("PLAN CODES ::" + element.getText() + " and " + element1.getText()
									+ " displayed successfully");
							Thread.sleep(1000);
							driver.switchTo().window(winHandle).close();
							break;
						} else {
							System.out.println("PLAN CODES ::" + element.getText() + " and " + element1.getText()
									+ " not displayed");
						}
					}
				}
			}

		}
	}

	public void verifyTotalAnnualPremium_ContributionPremium_EMPLOYEECLASS(WebDriver driver)
			throws InterruptedException {

		element = driver.findElement(
				By.xpath("//form[@name='DentalPlanSelectionForm']/table/tbody/tr[15]/td/table/tbody/tr[5]/td[2]"));
		String code1 = element.getText();
		System.out.println("Employee Class Before Code1::" + code1);

		element = driver.findElement(
				By.xpath("//form[@name='DentalPlanSelectionForm']/table/tbody/tr[15]/td/table/tbody/tr[6]/td[2]"));
		String code2 = element.getText();
		System.out.println("Employee Class Before Code2::" + code2);
		Thread.sleep(5000);
		// String winHandleBefore = driver.getWindowHandle();

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitRateCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitRateCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("SBQuoteWeb")) {

				List<WebElement> ele3 = driver.findElements(By.xpath(
						".//*[@name='DentalRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count4 = ele3.size();

				System.out.println("Row Count :: " + count4);
				for (int i = 1; i <= count4; i++) {
					element = driver.findElement(By
							.xpath(".//*[@name='DentalRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ i + "]"));
					System.out.println("Text" + i + "::" + element.getText());
					if (element.getText().trim().contains("Contribution Premium")) {
						System.out.println("Contribution Premium present in Dental Premiums table");

						element = driver.findElement(By.xpath(
								".//*[@name='DentalRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td"));
						System.out.println("Contribution Premium Amount1 ::" + element.getText());

						if ((element.getText().contains("N/A"))) {
							System.out.println(
									"Contribution Premium Amount 1 ::" + element.getText() + " displayed successfully");
						} else {
							String AnnualPremium1 = element.getText().substring(1, 7);
							String[] AnnulPremium_1 = AnnualPremium1.split("\\.");
							System.out.println("Value1 ::" + Integer.parseInt(AnnulPremium_1[0]));
							if ((Integer.parseInt(AnnulPremium_1[0]) != 0)) {
								System.out.println("Contribution Premium Amoun1 1 ::" + element.getText()
										+ " displayed successfully");
								// driver.switchTo().window(winHandle).close();
							} else {
								System.out.println(
										"Contribution Premium Amount ::" + element.getText() + " not displayed");
							}
						}

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='DentalRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[4]/td"));
						System.out.println("Contribution Premium Amount2 ::" + element1.getText());

						if ((element1.getText().contains("N/A"))) {
							System.out.println("Contribution Premium Amount 2 ::" + element1.getText()
									+ " displayed successfully");
						} else {
							String AnnualPremium2 = element1.getText().substring(1, 7);
							String[] AnnulPremium_2 = AnnualPremium2.split("\\.");
							System.out.println("Value2 ::" + Integer.parseInt(AnnulPremium_2[0]));
							if ((Integer.parseInt(AnnulPremium_2[0]) != 0)) {
								System.out.println("Contribution Premium Amount 2 ::" + element1.getText()
										+ " displayed successfully");
								// driver.switchTo().window(winHandle).close();
							} else {
								System.out.println(
										"Contribution Premium Amount 2 ::" + element1.getText() + " not displayed");
							}

						}

					}
				}

				List<WebElement> ele4 = driver.findElements(By.xpath(
						".//*[@name='DentalRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count1 = ele4.size();

				System.out.println("Row Count :: " + count1);
				for (int i = 1; i <= count1; i++) {
					element = driver.findElement(By
							.xpath(".//*[@name='DentalRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ i + "]"));
					System.out.println("Text" + i + "::" + element.getText());
					if (element.getText().trim().contains("Estimated Total Annual Premium")) {
						System.out.println("Estimated Total Annual Premium present in Dental Premiums table");
						element = driver.findElement(By.xpath(
								".//*[@name='DentalRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td"));
						System.out.println("Estimated Total Annual Premium Amount1 ::" + element.getText());

						String AnnualPremium1 = element.getText().substring(1, 8);
						String[] AnnulPremium_1 = AnnualPremium1.split(",");

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='DentalRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[5]/td"));
						System.out.println("Estimated Total Annual Premium Amount2 ::" + element1.getText());

						String AnnualPremium2 = element1.getText().substring(1, 8);
						String[] AnnulPremium_2 = AnnualPremium2.split(",");

						if ((Integer.parseInt(AnnulPremium_1[0]) != 0) && (Integer.parseInt(AnnulPremium_2[0]) != 0)) {
							System.out.println("Estimated Total Annual Premium Amounts ::" + element.getText() + " and "
									+ element1.getText() + " are displayed successfully");
							// driver.switchTo().window(winHandle).close();
						} else {
							System.out.println("Estimated Total Annual Premium Amounts ::" + element.getText() + " and "
									+ element1.getText() + " are not displayed");
						}
					}

				}

				List<WebElement> ele5 = driver.findElements(By.xpath(
						".//*[@name='DentalRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count2 = ele5.size();

				System.out.println("Row Count :: " + count2);
				for (int j = 1; j <= count2; j++) {
					element = driver.findElement(By
							.xpath(".//*[@name='DentalRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ j + "]"));
					// System.out.println("Text"+i + "::" +element.getText());
					if (element.getText().trim().contains("EMPLOYEE CLASS")) {
						System.out.println("EMPLOYEE CLASS present in Four Tier Table");

						element = driver.findElement(By.xpath(
								".//*[@name='DentalRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td"));
						System.out.println("EMPLOYEE CLASS code1 ::" + element.getText());

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='DentalRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[3]/table/tbody/tr[1]/td"));
						System.out.println("EMPLOYEE CLASS code2 ::" + element1.getText());

						if ((element.getText().contains(code1)) && (element1.getText().contains(code2))) {
							System.out.println("PLAN CODES ::" + element.getText() + " and " + element1.getText()
									+ " are displayed successfully");
							Thread.sleep(1000);
							driver.switchTo().window(winHandle).close();
							break;
						} else {
							System.out.println("PLAN CODES ::" + element.getText() + " and " + element1.getText()
									+ " are not displayed");
						}
					}
				}
			}

		}
	}

	public void verifyMonthlyPremium_AnnualPremium_EMPLOYEECLASS(WebDriver driver) throws InterruptedException {

		element = driver.findElement(
				By.xpath(".//*[@name='VisionPlanSelectionForm']/table/tbody/tr[15]/td/table/tbody/tr[4]/td[2]"));
		String code1 = element.getText();
		System.out.println("Employee Class Before Code1::" + code1);

		element = driver.findElement(
				By.xpath(".//*[@name='VisionPlanSelectionForm']/table/tbody/tr[15]/td/table/tbody/tr[5]/td[2]"));
		String code2 = element.getText();
		System.out.println("Employee Class Before Code2::" + code2);
		Thread.sleep(5000);
		// String winHandleBefore = driver.getWindowHandle();

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitRateCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitRateCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("SBQuoteWeb")) {

				List<WebElement> ele3 = driver.findElements(By.xpath(
						".//*[@name='VisionRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count4 = ele3.size();

				System.out.println("Row Count :: " + count4);
				for (int i = 1; i <= count4; i++) {
					element = driver.findElement(By
							.xpath(".//*[@name='VisionRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ i + "]"));
					System.out.println("Text" + i + "::" + element.getText());
					if (element.getText().trim().contains("Monthly Premium")) {
						System.out.println("Monthly Premium present in Vision Premiums table");
						element = driver.findElement(By.xpath(
								".//*[@name='VisionRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
						System.out.println("Monthly Premium Amount1 ::" + element.getText());

						String AnnualPremium1 = element.getText().substring(1, 5);
						String[] AnnulPremium_1 = AnnualPremium1.split("\\.");
						System.out.println("Value1 ::" + Integer.parseInt(AnnulPremium_1[0]));

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='VisionRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td"));
						System.out.println("Monthly Premium Amount2 ::" + element1.getText());

						String AnnualPremium2 = element1.getText().substring(1, 5);
						String[] AnnulPremium_2 = AnnualPremium2.split("\\.");
						System.out.println("Value1 ::" + Integer.parseInt(AnnulPremium_2[0]));

						if ((Integer.parseInt(AnnulPremium_1[0]) != 0) && (Integer.parseInt(AnnulPremium_2[0]) != 0)) {
							System.out.println("Monthly Premium Amounts ::" + element.getText() + " and "
									+ element1.getText() + " are displayed successfully");
							// driver.switchTo().window(winHandle).close();
						} else {
							System.out.println("Monthly Premium Amounts ::" + element.getText() + " and "
									+ element1.getText() + " are not displayed");
						}
					}
				}

				List<WebElement> ele4 = driver.findElements(By.xpath(
						".//*[@name='VisionRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count5 = ele4.size();

				System.out.println("Row Count :: " + count5);
				for (int i = 1; i <= count5; i++) {
					element = driver.findElement(By
							.xpath(".//*[@name='VisionRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ i + "]"));
					System.out.println("Text" + i + "::" + element.getText());
					if (element.getText().trim().contains("Annual Premium")) {
						System.out.println("Annual Premium present in Vision Premiums table");
						element = driver.findElement(By.xpath(
								".//*[@name='VisionRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td"));
						System.out.println("Annual Premium Amount1 ::" + element.getText());

						String AnnualPremium1 = element.getText().substring(1, 7);
						String[] AnnulPremium_1 = AnnualPremium1.split("\\.");
						System.out.println("Value1 ::" + Integer.parseInt(AnnulPremium_1[0]));

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='VisionRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td"));
						System.out.println("Annual Premium Amount2 ::" + element1.getText());

						String AnnualPremium2 = element1.getText().substring(1, 7);
						String[] AnnulPremium_2 = AnnualPremium2.split("\\.");
						System.out.println("Value1 ::" + Integer.parseInt(AnnulPremium_2[0]));

						if ((Integer.parseInt(AnnulPremium_1[0]) != 0) && (Integer.parseInt(AnnulPremium_2[0]) != 0)) {
							System.out.println("Annual Premium Amounts ::" + element.getText() + " and "
									+ element1.getText() + " are displayed successfully");
							// driver.switchTo().window(winHandle).close();
						} else {
							System.out.println("Annual Premium Amounts ::" + element.getText() + " and "
									+ element1.getText() + " are not displayed");
						}
					}
				}
				List<WebElement> ele5 = driver.findElements(By.xpath(
						".//*[@name='VisionRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr"));
				int count2 = ele5.size();

				System.out.println("Row Count :: " + count2);
				for (int j = 1; j <= count2; j++) {
					element = driver.findElement(By
							.xpath(".//*[@name='VisionRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[1]/table/tbody/tr["
									+ j + "]"));
					// System.out.println("Text"+i + "::" +element.getText());
					if (element.getText().trim().contains("EMPLOYEE CLASS")) {
						System.out.println("EMPLOYEE CLASS present in Four Tier Table");

						element = driver.findElement(By.xpath(
								".//*[@name='VisionRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td"));
						System.out.println("EMPLOYEE CLASS code1 ::" + element.getText());

						WebElement element1 = driver.findElement(By.xpath(
								".//*[@name='VisionRateComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr/td[3]/table/tbody/tr[1]/td"));
						System.out.println("EMPLOYEE CLASS code2 ::" + element1.getText());

						if ((element.getText().contains(code1)) && (element1.getText().contains(code2))) {
							System.out.println("EMPLOYEE CLASS Plan Codes ::" + element.getText() + " and "
									+ element1.getText() + " are displayed successfully");
							Thread.sleep(1000);
							driver.switchTo().window(winHandle).close();
							break;
						} else {
							System.out.println("EMPLOYEE CLASS Plan Codes ::" + element.getText() + " and "
									+ element1.getText() + " are not displayed");
						}
					}
				}
			}
		}
	}

	public static void check_CheckBox(WebDriver driver, By path) {
		element = driver.findElement(path);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void tearDown(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Application closed/.......");
		// driver.close();
	}

	// Oct18 Iteration
	public void censusPage_EmpAge_WithSal_WithoutDependent(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(1000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(1000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(1000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));
		for (int i = 0; i <= count1 - 7; i++) {

			Random rand = new Random();
			int Low = 25;
			int High = 40;
			int Result = rand.nextInt(High - Low) + Low;

			int LowSal = 50000;
			int HighSal = 100000;
			int TotSal = rand.nextInt(HighSal - LowSal) + LowSal;

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys(Integer.toString(Result));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].annualSalary']"))
					.sendKeys(Integer.toString(TotSal));
			Thread.sleep(500);
			// j = j + 1000;
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
	}

	public void verifyLifePlansPage_PREMIUM_EMPWithoutDepSal(WebDriver driver, String BenfitCode, String Premium)
			throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(3000);
		String lifePlansPage = "//td[contains(text(),'Life Plans')]";
		QuotePage.verifyPageDisplay(driver, lifePlansPage, "Life Plans");

		String lifeBasicLifePlanInfoTable = "//td[contains(text(),'Basic Life Plan Information')]";
		QuotePage.verifyPageInfoTable(driver, lifeBasicLifePlanInfoTable, "Basic Life Plan Information");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]"));

		String LifeBenifit1 = element.getText();

		WebElement element1 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[4]/td[2]"));
		// System.out.println("ANNUAL PREMIUM Amount ::" + element1.getText());

		String LifeBenifit2 = element1.getText();

		if ((LifeBenifit1.trim().contains(BenfitCode)) && (LifeBenifit2.trim().contains(BenfitCode))) {
			System.out.println(
					"LIFE BENEFITS ::" + element.getText() + " and " + element1.getText() + " displayed successfully");
		} else {
			System.out
					.println("LIFE BENEFITS ::" + element.getText() + " and " + element1.getText() + " not displayed");
		}

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td[3]"));
		WebElement element2 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[4]/td[3]"));

		if ((element.getText().trim().contains(Premium)) && (element2.getText().trim().contains(Premium))) {
			System.out.println("Employee PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " displayed successfully");
		} else {
			System.out.println("Employee PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " not displayed");
		}

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td[4]"));
		String DependentPremium1 = element.getText();

		WebElement element3 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[3]/table/tbody/tr[4]/td[4]"));
		String DependentPremium2 = element3.getText();

		if ((DependentPremium1.trim().contains(Premium)) && (DependentPremium2.trim().contains(Premium))) {
			System.out.println("Dependent PREMIUM MONTH Amounts ::" + element.getText() + " and " + element3.getText()
					+ " displayed successfully");
		} else {
			System.out.println("Dependent PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " not displayed ");
		}
	}

	public void enterLifeBenefitAmount(WebDriver driver, String amountLifeBenefit) throws InterruptedException {

		driver.findElement(By.xpath("//input[@name='benefitAmount']")).sendKeys(amountLifeBenefit);
		Thread.sleep(1000);

		By buttonGO = By.xpath("//input[@name='submitAddBenefit' or @value='GO']");

		element = driver.findElement(buttonGO);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void verifyLifeBenefitAmount(WebDriver driver, String amountLifeBenefit) throws InterruptedException {

		/*
		 * element = driver.findElement(By.name(
		 * "lifePlanBasicInformationForm[4].selectBasicInd")); executor =
		 * (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", element);
		 * Thread.sleep(1000);
		 */

		List<WebElement> amountlifeBenefit = driver.findElements(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr/td[2]"));
		System.out.println("Life Benefit Amount Table size ::" + amountlifeBenefit.size());
		for (int i = 3; i <= amountlifeBenefit.size(); i++) {
			element = driver.findElement(By
					.xpath("//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr["
							+ i + "]/td[2]"));
			// System.out.println("amountLifeBenefit Value :: " +
			// element.getText());
			if (element.getText().trim().contains(amountLifeBenefit)) {
				System.out.println(element.getText() + " value present in Basic Life Plan Information table");
				break;
			} /*
				 * else { System.out.
				 * println("FLAT $10,000 value not present in Basic Life Plan Information table"
				 * ); }
				 */
		}
	}

	public void verifyLifePlansPage_PREMIUM(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String lifePlansPage = "//td[contains(text(),'Life Plans')]";
		QuotePage.verifyPageDisplay(driver, lifePlansPage, "Life Plans");

		String lifeBasicLifePlanInfoTable = "//td[contains(text(),'Basic Life Plan Information')]";
		QuotePage.verifyPageInfoTable(driver, lifeBasicLifePlanInfoTable, "Basic Life Plan Information");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(By.xpath("//input[@name='lifePlanBasicInformationForm[0].selectBasicInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath("//input[@name='lifePlanBasicInformationForm[1].selectBasicInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td[3]"));

		String Premium1 = element.getText().substring(1, 3);
		String[] PremiumMonth_1 = Premium1.split("\\.");

		WebElement element1 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[4]/td[3]"));
		// System.out.println("ANNUAL PREMIUM Amount ::" + element1.getText());

		String Premium2 = element1.getText().substring(1, 3);
		String[] PremiumMonth_2 = Premium2.split("\\.");

		if ((Integer.parseInt(PremiumMonth_1[0]) != 0) && (Integer.parseInt(PremiumMonth_2[0]) != 0)) {
			System.out.println("Employee PREMIUM MONTH Amounts ::" + element.getText() + " and " + element1.getText()
					+ " displayed successfully");
			// driver.switchTo().window(winHandle).close();
		} else {
			System.out.println("Employee PREMIUM MONTH Amounts ::" + element.getText() + " and " + element1.getText()
					+ " not displayed");
		}

		element = driver.findElement(By.xpath("//input[@name='lifePlanDepInformationForm[0].selectDependentInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath("//input[@name='lifePlanDepInformationForm[1].selectDependentInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td[4]"));
		String DependentPremium1 = element.getText();

		WebElement element2 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[3]/table/tbody/tr[4]/td[4]"));
		String DependentPremium2 = element2.getText();

		if ((DependentPremium1.trim().contains("N/A")) && (DependentPremium2.trim().contains("N/A"))) {
			System.out.println("Dependent PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " displayed successfully");
		} else {
			System.out.println("Dependent PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " not displayed successfully");
		}

		driver.findElement(By.xpath("//input[@name='benefitAmount']")).sendKeys("10000");
		Thread.sleep(1000);

		By buttonGO = By.xpath("//input[@name='submitAddBenefit' or @value='GO']");

		element = driver.findElement(buttonGO);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);

		element = driver.findElement(By.name("lifePlanBasicInformationForm[0].selectBasicInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]"));
		System.out.println("Value :: " + element.getText());
		if (element.getText().contains("FLAT $10,000")) {
			System.out.println(element.getText() + " value present in Basic Life Plan Information table");
		} else {
			System.out.println(element.getText() + " value not present in Basic Life Plan Information table");
		}
	}

	public void censusPage_EmpWithDepndntWithoutSal(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(1000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(1000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(1000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		int j = 1000;
		for (int i = 0; i <= count1 - 7; i++) {

			Random rand = new Random();
			int Low = 25;
			int High = 40;
			int Result = rand.nextInt(High - Low) + Low;

			int WifeAgeLow = 15;
			int WifeAgeHigh = 30;
			int WifeAgeResult = rand.nextInt(WifeAgeHigh - WifeAgeLow) + WifeAgeLow;

			int AgeLow = 12;
			int AgeHigh = 14;
			int ChildAge = rand.nextInt(AgeHigh - AgeLow) + AgeLow;

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys(Integer.toString(Result));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].spouseAge']"))
					.sendKeys(Integer.toString(WifeAgeResult));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].childrenToAdd']"))
					.sendKeys("1");
			Thread.sleep(1000);

			element = driver.findElement(By.xpath("//input[@id='add" + j + "']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//input[@name='censusDetailInformationForm[" + i + "].dependentChildren[0].age']"))
					.sendKeys(Integer.toString(ChildAge));
			Thread.sleep(500);

			j = j + 1000;
		}

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(7000);
	}

	public void verifyLifePlansPage_PREMIUM_EmpWithDepandSal(WebDriver driver)
			throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String lifePlansPage = "//td[contains(text(),'Life Plans')]";
		QuotePage.verifyPageDisplay(driver, lifePlansPage, "Life Plans");

		String lifeBasicLifePlanInfoTable = "//td[contains(text(),'Basic Life Plan Information')]";
		QuotePage.verifyPageInfoTable(driver, lifeBasicLifePlanInfoTable, "Basic Life Plan Information");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(By.xpath("//input[@name='lifePlanBasicInformationForm[0].selectBasicInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath("//input[@name='lifePlanBasicInformationForm[1].selectBasicInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td[3]"));

		String Premium1 = element.getText().substring(1, 3);
		String[] PremiumMonth_1 = Premium1.split("\\.");

		WebElement element1 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[4]/td[3]"));
		// System.out.println("ANNUAL PREMIUM Amount ::" + element1.getText());

		String Premium2 = element1.getText().substring(1, 3);
		String[] PremiumMonth_2 = Premium2.split("\\.");

		if ((Integer.parseInt(PremiumMonth_1[0]) != 0) && (Integer.parseInt(PremiumMonth_2[0]) != 0)) {
			System.out.println("Employee PREMIUM MONTH Amounts ::" + element.getText() + " and " + element1.getText()
					+ " displayed successfully");
			// driver.switchTo().window(winHandle).close();
		} else {
			System.out.println("Employee PREMIUM MONTH Amounts ::" + element.getText() + " and " + element1.getText()
					+ " not displayed");
		}

		element = driver.findElement(By.xpath("//input[@name='lifePlanDepInformationForm[0].selectDependentInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath("//input[@name='lifePlanDepInformationForm[1].selectDependentInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td[4]"));
		String DependentPremium1 = element.getText().substring(1, 3);
		String[] DependentPremium_1 = DependentPremium1.split("\\.");

		WebElement element2 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[3]/table/tbody/tr[4]/td[4]"));
		String DependentPremium2 = element2.getText().substring(1, 3);
		String[] DependentPremium_2 = DependentPremium2.split("\\.");

		if ((Integer.parseInt(DependentPremium_1[0]) != 0) && (Integer.parseInt(DependentPremium_2[0]) != 0)) {
			System.out.println("Dependent PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " displayed successfully");
		} else {
			System.out.println("Dependent PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " not displayed successfully");
		}

		driver.findElement(By.xpath("//input[@name='benefitAmount']")).sendKeys("10000");
		Thread.sleep(1000);

		By buttonGO = By.xpath("//input[@name='submitAddBenefit' or @value='GO']");

		element = driver.findElement(buttonGO);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);

		element = driver.findElement(By.name("lifePlanBasicInformationForm[0].selectBasicInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]"));
		System.out.println("Value :: " + element.getText());
		if (element.getText().contains("FLAT $10,000")) {
			System.out.println(element.getText() + " value present in Basic Life Plan Information table");
		} else {
			System.out.println(element.getText() + " value not present in Basic Life Plan Information table");
		}
	}

	public void verifyLifePlansPage_PREMIUM_EMPWithDepWithoutSal(WebDriver driver)
			throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String lifePlansPage = "//td[contains(text(),'Life Plans')]";
		QuotePage.verifyPageDisplay(driver, lifePlansPage, "Life Plans");

		String lifeBasicLifePlanInfoTable = "//td[contains(text(),'Basic Life Plan Information')]";
		QuotePage.verifyPageInfoTable(driver, lifeBasicLifePlanInfoTable, "Basic Life Plan Information");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]"));

		String LifeBenifit1 = element.getText();

		WebElement element1 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[4]/td[2]"));
		// System.out.println("ANNUAL PREMIUM Amount ::" + element1.getText());

		String LifeBenifit2 = element1.getText();

		if ((LifeBenifit1.contains("Multiple")) && (LifeBenifit2.contains("Multiple"))) {
			System.out.println(
					"LIFE BENEFITS ::" + element.getText() + " and " + element1.getText() + " displayed successfully");
		} else {
			System.out
					.println("LIFE BENEFITS ::" + element.getText() + " and " + element1.getText() + " not displayed");
		}

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td[3]"));
		WebElement element2 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[4]/td[3]"));

		if ((element.getText().trim().contains("N/A")) && (element2.getText().trim().contains("N/A"))) {
			System.out.println("Employee PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " displayed successfully");
		} else {
			System.out.println("Employee PREMIUM MONTH Amounts ::" + element.getText() + " and " + element2.getText()
					+ " not displayed");
		}

		element = driver.findElement(By.xpath("//input[@name='lifePlanDepInformationForm[0].selectDependentInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath("//input[@name='lifePlanDepInformationForm[1].selectDependentInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td[4]"));
		String DependentPremium1 = element.getText().substring(1, 3);
		String[] DependentPremium_1 = DependentPremium1.split("\\.");

		WebElement element3 = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[3]/table/tbody/tr[4]/td[4]"));
		String DependentPremium2 = element3.getText().substring(1, 3);
		String[] DependentPremium_2 = DependentPremium2.split("\\.");

		if ((Integer.parseInt(DependentPremium_1[0]) != 0) && (Integer.parseInt(DependentPremium_2[0]) != 0)) {
			System.out.println("Dependent PREMIUM MONTH Amounts ::" + element.getText() + " and " + element3.getText()
					+ " displayed successfully");
		} else {
			System.out.println("Dependent PREMIUM MONTH Amounts ::" + element.getText() + " and " + element3.getText()
					+ " not displayed successfully");
		}

		driver.findElement(By.xpath("//input[@name='benefitAmount']")).sendKeys("10000");
		Thread.sleep(1000);

		By buttonGO = By.xpath("//input[@name='submitAddBenefit' or @value='GO']");

		element = driver.findElement(buttonGO);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);

		element = driver.findElement(By.name("lifePlanBasicInformationForm[4].selectBasicInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(By.xpath(
				"//form[@name='LifePlanSelectionForm']/table/tbody/tr[13]/td/table/tbody/tr/td[1]/table/tbody/tr[7]/td[2]"));
		System.out.println("Value :: " + element.getText());
		if (element.getText().contains("FLAT $10,000")) {
			System.out.println("FLAT $10,000 value present in Basic Life Plan Information table");
		} else {
			System.out.println("FLAT $10,000 value not present in Basic Life Plan Information table");
		}
	}

	public void quoteSetUpPage_SelectAllCoverages(WebDriver driver, String coverage) throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		String pwindow = driver.getWindowHandle();

		utility.waitForVisibilityOfWebElement(By.xpath("//a[@href='javascript:openAccountExecSearch();']/img"), driver);

		element = driver.findElement(By.xpath("//a[@href='javascript:openAccountExecSearch();']/img"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("accountExecutiveSearch")) {
				System.out.println("Account Executive Search web page displayed successfully");
				System.out.println(
						"Account Executive Search page URL :: " + driver.switchTo().window(winHandle).getCurrentUrl());

				driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Smith");
				Thread.sleep(1000);

				By btnSicInputSubmit = By.xpath("//input[@name='submitSearch' or @value='SEARCH']");
				element = driver.findElement(btnSicInputSubmit);
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);

				element = driver.findElement(By.linkText("Select"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);
				// driver.switchTo().window(handle1).close();
				// driver.close();
			}
		}

		driver.switchTo().window(pwindow);
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteType, driver);
		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteCompanyName, driver);
		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());

		utility.waitForVisibilityOfWebElement(txtBoxstreetAddress, driver);
		// driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxstreetAddress).sendKeys(common.getAddress());

		utility.waitForVisibilityOfWebElement(txtBoxcityAddress, driver);
		// driver.findElement(txtBoxcityAddress).sendKeys("Site1");
		driver.findElement(txtBoxcityAddress).sendKeys(common.getCity());

		// Select stateSel=new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");

		utility.waitForVisibilityOfWebElement(txtBoxzipCode, driver);
		// driver.findElement(txtBoxzipCode).sendKeys("73301");
		driver.findElement(txtBoxzipCode).sendKeys(common.getZipCode());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxSICCODE, driver);
		// driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(totNumActiveEmployeesApplying, driver);
		driver.findElement(totNumActiveEmployeesApplying).clear();
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("10");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxquoteTotalNumEmployees, driver);
		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("10");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		// Thread.sleep(1000);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		/*
		 * driver.findElement(By.xpath(
		 * "//input[@name='quoteTotalNumDisabilityClasses']")).clear();
		 * driver.findElement(By.xpath(
		 * "//input[@name='quoteTotalNumDisabilityClasses']")).sendKeys("2");
		 * Thread.sleep(2000);
		 * 
		 * driver.findElement(By.
		 * xpath("//input[@id='disClassButton' and @value='ENTER CLASS DESCRIPTION']"
		 * )).click(); //
		 * driver.findElement(By.xpath("//input[@id='disClassButton' and
		 * // @value='ENTER CLASS DESCRIPTION']")).sendKeys(Keys.ENTER); element
		 * = driver.findElement(By.
		 * xpath("//input[@id='disClassButton' and @value='ENTER CLASS DESCRIPTION']"
		 * )); executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", element);
		 * 
		 * utility.waitForNumberOfWindowsToEqual(2); for (String winHandle :
		 * driver.getWindowHandles()) { driver.switchTo().window(winHandle); if
		 * (driver.switchTo().window(winHandle).getCurrentUrl().contains(
		 * "disabilityClassDefinitionsSetup")) { System.out.
		 * println("Enter Class Descriptions web page displayed successfully");
		 * System.out.println( "Enter Class Descriptions page URL :: " +
		 * driver.switchTo().window(winHandle).getCurrentUrl());
		 * 
		 * element = driver.findElement(By.
		 * xpath("//td[contains(text(),'Enter Class Descriptions')]")); if
		 * (element.getText().trim().contains("Enter Class Descriptions")) {
		 * System.out.
		 * println("Enter Class Descriptions text present on Enter Class Descriptions page"
		 * ); } else { System.out.
		 * println("Enter Class Descriptions text not present on Enter Class Descriptions page"
		 * ); } Thread.sleep(1000);
		 * 
		 * driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[0].classDescription']")).sendKeys(
		 * "Class1"); Thread.sleep(1000); driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[1].classDescription']")).sendKeys(
		 * "Class2"); Thread.sleep(1000);
		 * 
		 * driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[0].totalEmployeesApplying']")).clear(
		 * ); driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[0].totalEmployeesApplying']"))
		 * .sendKeys("5"); Thread.sleep(1000); driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[1].totalEmployeesApplying']")).clear(
		 * ); driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[1].totalEmployeesApplying']"))
		 * .sendKeys("6"); Thread.sleep(1000);
		 * 
		 * By btnClassSubmit =
		 * By.xpath("//input[@name='submit' and @value='SUBMIT']"); element =
		 * driver.findElement(btnClassSubmit); executor = (JavascriptExecutor)
		 * driver; executor.executeScript("arguments[0].click();", element);
		 * Thread.sleep(1000); // driver.switchTo().window(handle1).close(); //
		 * driver.close(); } }
		 * 
		 * driver.switchTo().window(pwindow); Thread.sleep(1000);
		 * driver.switchTo().frame("content"); Thread.sleep(1000);
		 */
		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void medicalPlanPage_1(WebDriver driver) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(5000);
		String medicalPage = ".//*[@id='divContent']/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]";
		QuotePage.verifyPageDisplay(driver, medicalPage, "Medical Plans");
		Thread.sleep(2000);

		String medicalInfoTable = "//td[contains(text(),'Medical Plan Information')]";
		// String
		// medicalInformationTable=".//*[@id='divContent']/form/table/tbody/tr[12]/td/table/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, medicalInfoTable, "Medical Plan Information");
		Thread.sleep(2000);

		// QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(chkBoxmedicalInPackageForm);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		// QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(btnMedicalPlansubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
	}

	public void verifyDisplayPlans_clickBtnApplyChanges(WebDriver driver, String displayPlan)
			throws InterruptedException {
		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
		Select medicalRatingMethodVal = new Select(driver.findElement(By.name("planDisplaySelection")));
		// Get all options
		List<WebElement> dd = medicalRatingMethodVal.getOptions();
		System.out.println(dd.size());

		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());
			// Show All Plans
			// Show My Selected Plans
			if (dd.get(j).getText().contains(displayPlan)) {
				System.out.println(displayPlan + " present in Display Plans drop down");
				medicalRatingMethodVal.selectByVisibleText(displayPlan);
				if ((displayPlan.contains("Most Popular Plans") || (displayPlan.contains("Show All Plans")))) {
					System.out.println("inside if ::" + displayPlan);
					Thread.sleep(1000);
					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(10000);
					break;
				}
			}
		}
	}

	public void page_SupplementalEmployeeLife(WebDriver driver) throws InterruptedException, IOException {

		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String pageSupplementalEmployeeLife = "//td[contains(text(),'Supplemental Employee Life/AD&D Plans')]";
		QuotePage.verifyPageDisplay(driver, pageSupplementalEmployeeLife, "Supplemental Employee Life/AD&D Plans");

		Thread.sleep(1000);
		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(2000);
		
		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
	}

	public void page_SupplementalDependentLife(WebDriver driver) throws InterruptedException, IOException {

		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String pageSupplementalDependentLife = "//td[contains(text(),'Supplemental Dependent Life/AD&D Plans')]";
		QuotePage.verifyPageDisplay(driver, pageSupplementalDependentLife, "Supplemental Dependent Life/AD&D Plans");

		Thread.sleep(1000);
		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(2000);

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
	}

	public void page_ShortTermDisabilityPlans(WebDriver driver, String displayPlan) throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'Short Term Disability Plans')]"));
		if (element.getText().contains("Short Term Disability Plans")) {
			System.out.println("Short Term Disability Plans page displayed successfully");
		} else {
			System.out.println("Short Term Disability Plans page not displayed");
		}

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
		Select medicalRatingMethodVal = new Select(driver.findElement(By.name("planDisplaySelection")));
		// Get all options
		List<WebElement> dd = medicalRatingMethodVal.getOptions();
		System.out.println(dd.size());

		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());
			// Show All Plans
			// Show My Selected Plans
			if (dd.get(j).getText().contains(displayPlan)) {
				System.out.println(displayPlan + " present in Display Plans drop down");
				// medicalRatingMethodVal.selectByVisibleText(displayPlan);
				// break;

				if ((displayPlan.contains("Show All Plans"))) {
					System.out.println("inside if ::" + displayPlan);
					medicalRatingMethodVal.selectByVisibleText(displayPlan);
					Thread.sleep(1000);
					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(8000);
				}
			}
		}
	}

	public void page_LongTermDisabilityPlans(WebDriver driver, String displayPlan) throws InterruptedException {

		WebElement element = driver.findElement(By.xpath("//td[contains(text(),'Long Term Disability Plans')]"));
		if (element.getText().contains("Long Term Disability Plans")) {
			System.out.println("Long Term Disability Plans page displayed successfully");
		} else {
			System.out.println("Long Term Disability Plans page not displayed");
		}

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
		Select medicalRatingMethodVal = new Select(driver.findElement(By.name("planDisplaySelection")));
		// Get all options
		List<WebElement> dd = medicalRatingMethodVal.getOptions();
		System.out.println(dd.size());

		for (int j = 0; j < dd.size(); j++) {
			System.out.println(dd.get(j).getText());
			// Show All Plans
			// Show My Selected Plans
			if (dd.get(j).getText().contains(displayPlan)) {
				System.out.println(displayPlan + " present in Display Plans drop down");
				// medicalRatingMethodVal.selectByVisibleText(displayPlan);
				// break;

				if ((displayPlan.contains("Show All Plans"))) {
					System.out.println("inside if ::" + displayPlan);
					medicalRatingMethodVal.selectByVisibleText(displayPlan);
					Thread.sleep(1000);
					utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitApplyOptions']"), driver);
					element = driver.findElement(By.xpath("//input[@name='submitApplyOptions']"));
					executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();", element);
					Thread.sleep(8000);
				}
			}
		}
	}

	public void selectPlanCode_ShortTermDisabilityPlans(WebDriver driver) throws InterruptedException {
		/*
		 * driver.findElement(By.name(
		 * "disabilityClassPlanInformationForm[0].selectInd")).click();
		 * Thread.sleep(1000); driver.findElement(By.name(
		 * "disabilityClassPlanInformationForm[1].selectInd")).click();
		 */

		element = driver.findElement(By.name("disabilityClassPlanInformationForm[0].selectInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.name("disabilityClassPlanInformationForm[1].selectInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
	}

	public void selectPlanCode_clickNext_ShortTermDisabilityPlans(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(By.name("disabilityClassPlanInformationForm[0].selectInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element = driver.findElement(By.name("disabilityClassPlanInformationForm[1].selectInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
	}
	
	public void selectPlanCode_clickNext_LongTermDisabilityPlans(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(By.name("disabilityClassPlanInformationForm[0].selectInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		element = driver.findElement(By.name("disabilityClassPlanInformationForm[1].selectInd"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
	}

	public void verify_BENEFITCODE_MONTHLYPREMIUM_ANNUALPREMIUM(WebDriver driver) throws InterruptedException {
		WebElement element = driver.findElement(By.name("disabilityClassPlanInformationForm[0].planId"));

		System.out.println("Ben Code1 ::" + element.getAttribute("value"));
		String BenefitCode1 = element.getText();
		WebElement element1 = driver.findElement(By.name("disabilityClassPlanInformationForm[1].planId"));

		System.out.println("Ben Code2 ::" + element1.getAttribute("value"));
		String BenefitCode2 = element1.getText();

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitPlanCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitPlanCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("shortTermDisabilityPlanSelection")) {
				System.out.println("Short Term Disability Plan Selection web page displayed successfully");
				System.out.println("Short Term Disability Plan Selection page URL :: "
						+ driver.switchTo().window(winHandle).getCurrentUrl());

				Thread.sleep(1000);
				WebElement element2 = driver.findElement(By.xpath("//td[contains(text(),'STD Plan Comparison')]"));
				if (element2.getText().contains("STD Plan Comparison")) {
					System.out.println("STD Plan Comparison page displayed successfully");
				} else {
					System.out.println("STD Plan Comparison page not displayed");
				}

				element = driver.findElement(By.xpath(
						"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[1]/td[1]"));

				if (element.getText().trim().contains("BENEFIT")) {
					System.out
							.println("BENEFIT text displayed successfully on Short Term Disability Plan Details table");

					element = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[1]/td[2]"));

					WebElement element3 = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[1]/td[3]"));
					if ((element.getText().trim().contains(BenefitCode1)
							&& (element.getText().trim().contains(BenefitCode2)))) {
						System.out.println(" BENEFIT Codes :: " + element.getText() + " and " + element3.getText()
								+ " displayed successfully");
					} else {
						System.out.println("BENEFIT Codes :: " + element.getText() + " and " + element3.getText()
								+ " not displayed");
					}

				} else {
					System.out.println("BENEFIT text not displayed on Short Term Disability Plan Details table");
				}

				element = driver.findElement(By.xpath(
						"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[10]/td[1]"));

				if (element.getText().trim().contains("MONTHLY PREMIUM")) {
					System.out.println(
							"MONTHLY PREMIUM text displayed successfully on Short Term Disability Plan Details table");

					element = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[10]/td[2]"));
					String MonthlyPremium1 = element.getText().substring(1, 5);
					String[] MonthlyPremium1_1 = MonthlyPremium1.split("\\.");

					WebElement element3 = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[10]/td[3]"));
					String MonthlyPremium2 = element3.getText().substring(1, 5);
					String[] MonthlyPremium2_2 = MonthlyPremium2.split("\\.");

					if ((Integer.parseInt(MonthlyPremium1_1[0]) != 0)
							&& (Integer.parseInt(MonthlyPremium2_2[0]) != 0)) {
						System.out.println("MONTHLY PREMIUM Amounts :: " + element.getText() + " and "
								+ element3.getText() + " displayed successfully");
					} else {
						System.out.println("MONTHLY PREMIUM Amounts :: " + element.getText() + " and "
								+ element3.getText() + " not displayed");
					}

				} else {
					System.out
							.println("MONTHLY PREMIUM text not displayed on Short Term Disability Plan Details table");
				}

				element = driver.findElement(By.xpath(
						"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[11]/td[1]"));

				if (element.getText().trim().contains("ANNUAL PREMIUM")) {
					System.out.println(
							"ANNUAL PREMIUM text displayed successfully on Short Term Disability Plan Details table");

					element = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[11]/td[2]"));
					String ANNUALPremium1 = element.getText().substring(1, 5);
					String[] ANNUALPremium1_1 = ANNUALPremium1.split("\\.");

					WebElement element3 = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[11]/td[3]"));
					String ANNUALPremium2 = element3.getText().substring(1, 5);
					String[] ANNUALPremium2_2 = ANNUALPremium2.split("\\.");

					if ((Integer.parseInt(ANNUALPremium1_1[0]) != 0) && (Integer.parseInt(ANNUALPremium2_2[0]) != 0)) {
						System.out.println("ANNUAL PREMIUM Amounts :: " + element.getText() + " and "
								+ element3.getText() + " displayed successfully");
						driver.switchTo().window(winHandle).close();
					} else {
						System.out.println("ANNUAL PREMIUM Amounts :: " + element.getText() + " and "
								+ element3.getText() + " not displayed");
					}

				} else {
					System.out.println("ANNUAL PREMIUM text not displayed on Short Term Disability Plan Details table");
				}
				// driver.switchTo().window(handle1).close();
				// driver.close();
			}
		}
	}

	public void selectPlanCodes_LTDPlanPage(WebDriver driver) throws InterruptedException, IOException {

		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String pageSupplementalDependentLife = "//td[contains(text(),'Long Term Disability Plans')]";
		QuotePage.verifyPageDisplay(driver, pageSupplementalDependentLife, "Long Term Disability Plans");

		QuotePage.verifyFooterLinks(driver);

		element = driver.findElement(By.xpath("//input[@name='disabilityClassPlanInformationForm[0].selectInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		element = driver.findElement(By.xpath("//input[@name='disabilityClassPlanInformationForm[1].selectInd']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void verify_BENEFITCODE_MONTHLYPREMIUM_ANNUALPREMIUM_On_LTDPlanComparison(WebDriver driver)
			throws InterruptedException {

		WebElement planCode1 = driver.findElement(By.name("disabilityClassPlanInformationForm[0].planId"));
		System.out.println("Plan Code1 ::" + planCode1.getAttribute("value"));
		String PlanCode1 = planCode1.getText();

		WebElement planCode2 = driver.findElement(By.name("disabilityClassPlanInformationForm[1].planId"));
		System.out.println("Plan Code2 ::" + planCode2.getAttribute("value"));
		String PlanCode2 = planCode2.getText();

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitPlanCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitPlanCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("longTermDisabilityPlanSelection")) {
				System.out.println("Long Term Disability Plan Selection web page displayed successfully");
				System.out.println("Long Term Disability Plan Selection page URL :: "
						+ driver.switchTo().window(winHandle).getCurrentUrl());

				Thread.sleep(1000);
				WebElement element2 = driver.findElement(By.xpath("//td[contains(text(),'LTD Plan Comparison')]"));
				if (element2.getText().trim().contains("LTD Plan Comparison")) {
					System.out.println("LTD Plan Comparison page displayed successfully");
				} else {
					System.out.println("LTD Plan Comparison page not displayed");
				}

				WebElement txtBenefit = driver.findElement(By.xpath(
						"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[1]/td[1]"));

				if (txtBenefit.getText().trim().contains("BENEFIT")) {
					System.out
							.println("BENEFIT text displayed successfully on Long Term Disability Plan Details table");

					WebElement LTDPlanComparison_planCode1 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[1]/td[2]"));

					System.out.println("LTDPlanComparison_planCode1 :: " + LTDPlanComparison_planCode1.getText());
					WebElement LTDPlanComparison_planCode2 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[1]/td[3]"));
					if ((LTDPlanComparison_planCode1.getText().trim().trim().contains(PlanCode1)
							&& (LTDPlanComparison_planCode2.getText().trim().contains(PlanCode2)))) {
						System.out.println("Plan Codes :: " + LTDPlanComparison_planCode1.getText() + " and "
								+ LTDPlanComparison_planCode2.getText() + " displayed successfully");
					} else {
						System.out.println("Plan Codes :: " + LTDPlanComparison_planCode1.getText() + " and "
								+ LTDPlanComparison_planCode2.getText() + " not displayed");
					}

				} else {
					System.out.println("BENEFIT text not displayed on Long Term Disability Plan Details table");
				}

				WebElement LTDPlanComparison_txtMONTHLYPREMIUM = driver.findElement(By.xpath(
						"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[12]/td[1]"));

				if (LTDPlanComparison_txtMONTHLYPREMIUM.getText().trim().contains("MONTHLY PREMIUM")) {
					System.out.println(
							"MONTHLY PREMIUM text displayed successfully on Long Term Disability Plan Details table");

					WebElement LTDPlanComparison_amountMONTHLYPREMIUM1 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[12]/td[2]"));
					String MonthlyPremium1 = LTDPlanComparison_amountMONTHLYPREMIUM1.getText().substring(1, 5);
					String[] MonthlyPremium1_1 = MonthlyPremium1.split("\\.");

					WebElement LTDPlanComparison_amountMONTHLYPREMIUM2 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[12]/td[2]"));
					String MonthlyPremium2 = LTDPlanComparison_amountMONTHLYPREMIUM2.getText().substring(1, 5);
					String[] MonthlyPremium2_2 = MonthlyPremium2.split("\\.");

					if ((Integer.parseInt(MonthlyPremium1_1[0]) != 0)
							&& (Integer.parseInt(MonthlyPremium2_2[0]) != 0)) {
						System.out.println("MONTHLY PREMIUM Amounts :: "
								+ LTDPlanComparison_amountMONTHLYPREMIUM1.getText() + " and "
								+ LTDPlanComparison_amountMONTHLYPREMIUM2.getText() + " displayed successfully");
					} else {
						System.out.println("MONTHLY PREMIUM Amounts :: "
								+ LTDPlanComparison_amountMONTHLYPREMIUM1.getText() + " and "
								+ LTDPlanComparison_amountMONTHLYPREMIUM2.getText() + " not displayed");
					}

				} else {
					System.out.println("MONTHLY PREMIUM text not displayed on Long Term Disability Plan Details table");
				}

				WebElement LTDPlanComparison_txtANNUALPREMIUM = driver.findElement(By.xpath(
						"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[13]/td[1]"));

				if (LTDPlanComparison_txtANNUALPREMIUM.getText().trim().contains("ANNUAL PREMIUM")) {
					System.out.println(
							"ANNUAL PREMIUM text displayed successfully on Long Term Disability Plan Details table");

					WebElement LTDPlanComparison_amountANNUALPREMIUM1 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[13]/td[2]"));
					String ANNUALPremium1 = LTDPlanComparison_amountANNUALPREMIUM1.getText().substring(1, 5);
					String[] ANNUALPremium1_1 = ANNUALPremium1.split("\\.");

					WebElement LTDPlanComparison_amountANNUALPREMIUM2 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityPlanComparisonForm']/table/tbody/tr[8]/td/table/tbody/tr[13]/td[3]"));
					String ANNUALPremium2 = LTDPlanComparison_amountANNUALPREMIUM2.getText().substring(1, 5);
					String[] ANNUALPremium2_2 = ANNUALPremium2.split("\\.");

					if ((Integer.parseInt(ANNUALPremium1_1[0]) != 0) && (Integer.parseInt(ANNUALPremium2_2[0]) != 0)) {
						System.out.println("ANNUAL PREMIUM Amounts :: "
								+ LTDPlanComparison_amountANNUALPREMIUM1.getText() + " and "
								+ LTDPlanComparison_amountANNUALPREMIUM2.getText() + " displayed successfully");
						driver.switchTo().window(winHandle).close();
					} else {
						System.out.println("ANNUAL PREMIUM Amounts :: "
								+ LTDPlanComparison_amountANNUALPREMIUM1.getText() + " and "
								+ LTDPlanComparison_amountANNUALPREMIUM2.getText() + " not displayed");
					}

				} else {
					System.out.println("ANNUAL PREMIUM text not displayed on Long Term Disability Plan Details table");
				}
				// driver.switchTo().window(handle1).close();
				// driver.close();
			}
		}
	}

	public void verify_BENEFITCODE_MONTHLYPREMIUM_ANNUALPREMIUM_On_LTDRateComparison(WebDriver driver)
			throws InterruptedException {

		WebElement planCode1 = driver.findElement(By.name("disabilityClassPlanInformationForm[0].planId"));
		System.out.println("Plan Code1 ::" + planCode1.getAttribute("value"));
		String PlanCode1 = planCode1.getText();

		WebElement planCode2 = driver.findElement(By.name("disabilityClassPlanInformationForm[1].planId"));
		System.out.println("Plan Code2 ::" + planCode2.getAttribute("value"));
		String PlanCode2 = planCode2.getText();

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitRateCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitRateCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("longTermDisabilityPlanSelection")) {
				System.out.println("Long Term Disability Plan Selection web page displayed successfully");
				System.out.println("Long Term Disability Plan Selection page URL :: "
						+ driver.switchTo().window(winHandle).getCurrentUrl());

				Thread.sleep(1000);
				WebElement element2 = driver.findElement(By.xpath("//td[contains(text(),'LTD Rate Comparison')]"));
				if (element2.getText().trim().contains("LTD Rate Comparison")) {
					System.out.println("LTD Rate Comparison page displayed successfully");
				} else {
					System.out.println("LTD Rate Comparison page not displayed");
				}

				WebElement LTDPlanComparison_planCode1 = driver.findElement(By.xpath(
						"//form[@name='LongTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td"));

				System.out.println("LTDPlanComparison_planCode1 :: " + LTDPlanComparison_planCode1.getText());
				WebElement LTDPlanComparison_planCode2 = driver.findElement(By.xpath(
						"//form[@name='LongTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[1]/td"));
				if ((LTDPlanComparison_planCode1.getText().trim().trim().contains(PlanCode1)
						&& (LTDPlanComparison_planCode2.getText().trim().contains(PlanCode2)))) {
					System.out.println("Plan Codes :: " + LTDPlanComparison_planCode1.getText() + " and "
							+ LTDPlanComparison_planCode2.getText() + " displayed successfully");
				} else {
					System.out.println("Plan Codes :: " + LTDPlanComparison_planCode1.getText() + " and "
							+ LTDPlanComparison_planCode2.getText() + " not displayed");
				}

				WebElement LTDPlanComparison_txtMONTHLYPREMIUM = driver.findElement(By.xpath(
						"//form[@name='LongTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td"));

				if (LTDPlanComparison_txtMONTHLYPREMIUM.getText().trim().contains("Monthly Premium")) {
					System.out.println("Monthly Premium text displayed successfully on LTD Premiums table");

					WebElement LTDPlanComparison_amountMONTHLYPREMIUM1 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td"));
					String MonthlyPremium1 = LTDPlanComparison_amountMONTHLYPREMIUM1.getText().substring(1, 5);
					String[] MonthlyPremium1_1 = MonthlyPremium1.split("\\.");

					WebElement LTDPlanComparison_amountMONTHLYPREMIUM2 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[2]/td"));
					String MonthlyPremium2 = LTDPlanComparison_amountMONTHLYPREMIUM2.getText().substring(1, 5);
					String[] MonthlyPremium2_2 = MonthlyPremium2.split("\\.");

					if ((Integer.parseInt(MonthlyPremium1_1[0]) != 0)
							&& (Integer.parseInt(MonthlyPremium2_2[0]) != 0)) {
						System.out.println("Monthly Premium Amounts :: "
								+ LTDPlanComparison_amountMONTHLYPREMIUM1.getText() + " and "
								+ LTDPlanComparison_amountMONTHLYPREMIUM2.getText() + " displayed successfully");
					} else {
						System.out.println("Monthly Premium Amounts :: "
								+ LTDPlanComparison_amountMONTHLYPREMIUM1.getText() + " and "
								+ LTDPlanComparison_amountMONTHLYPREMIUM2.getText() + " not displayed");
					}

				} else {
					System.out.println("Monthly Premium text not displayed on LTD Premiums table");
				}

				WebElement LTDPlanComparison_txtANNUALPREMIUM = driver.findElement(By.xpath(
						"//form[@name='LongTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr[3]/td"));

				if (LTDPlanComparison_txtANNUALPREMIUM.getText().trim().contains("Annual Premium")) {
					System.out.println("Annual Premium text displayed successfully on LTD Premiums table");

					WebElement LTDPlanComparison_amountANNUALPREMIUM1 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td"));
					String ANNUALPremium1 = LTDPlanComparison_amountANNUALPREMIUM1.getText().substring(1, 5);
					String[] ANNUALPremium1_1 = ANNUALPremium1.split("\\.");

					WebElement LTDPlanComparison_amountANNUALPREMIUM2 = driver.findElement(By.xpath(
							"//form[@name='LongTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[3]/td"));
					String ANNUALPremium2 = LTDPlanComparison_amountANNUALPREMIUM2.getText().substring(1, 5);
					String[] ANNUALPremium2_2 = ANNUALPremium2.split("\\.");

					if ((Integer.parseInt(ANNUALPremium1_1[0]) != 0) && (Integer.parseInt(ANNUALPremium2_2[0]) != 0)) {
						System.out.println("ANNUAL PREMIUM Amounts :: "
								+ LTDPlanComparison_amountANNUALPREMIUM1.getText() + " and "
								+ LTDPlanComparison_amountANNUALPREMIUM2.getText() + " displayed successfully");
						driver.switchTo().window(winHandle).close();
					} else {
						System.out.println("Annual Premium Amounts :: "
								+ LTDPlanComparison_amountANNUALPREMIUM1.getText() + " and "
								+ LTDPlanComparison_amountANNUALPREMIUM2.getText() + " not displayed");
					}

				} else {
					System.out.println("Annual Premium text not displayed on LTD Premiums table");
				}
				// driver.switchTo().window(handle1).close();
				// driver.close();
			}
		}
	}

	public void verify_PLANCODE_MONTHLYPREMIUM_ANNUALPREMIUM(WebDriver driver) throws InterruptedException {
		WebElement element = driver.findElement(By.name("disabilityClassPlanInformationForm[0].planId"));

		System.out.println("Plan Code1 ::" + element.getAttribute("value"));
		String PlanCode1 = element.getText();
		WebElement element1 = driver.findElement(By.name("disabilityClassPlanInformationForm[1].planId"));

		System.out.println("Plan Code2 ::" + element1.getAttribute("value"));
		String PlanCode2 = element1.getText();

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitRateCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitRateCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("shortTermDisabilityPlanSelection")) {
				System.out.println("Short Term Disability Plan Selection web page displayed successfully");
				System.out.println("Short Term Disability Plan Selection page URL :: "
						+ driver.switchTo().window(winHandle).getCurrentUrl());

				Thread.sleep(1000);
				WebElement element2 = driver.findElement(By.xpath("//td[contains(text(),'STD Rate Comparison')]"));
				if (element2.getText().contains("STD Rate Comparison")) {
					System.out.println("STD Rate Comparison page displayed successfully");
				} else {
					System.out.println("STD Rate Comparison page not displayed");
				}

				WebElement plancode1 = driver.findElement(By.xpath(
						"//form[@name='ShortTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[1]"));

				WebElement plancode2 = driver.findElement(By.xpath(
						"//form[@name='ShortTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[1]"));
				if ((plancode1.getText().trim().contains(PlanCode1)
						&& (plancode2.getText().trim().contains(PlanCode2)))) {
					System.out.println(" PLAN CODES :: " + plancode1.getText() + " and " + plancode2.getText()
							+ " displayed successfully");
				} else {
					System.out.println(
							" PLAN CODES :: " + plancode1.getText() + " and " + plancode2.getText() + " not displayed");
				}

				WebElement monthlypremium = driver.findElement(By.xpath(
						"//form[@name='ShortTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr[2]"));

				if (monthlypremium.getText().trim().contains("Monthly Premium")) {
					System.out.println(
							"Estimated Total Monthly Premium text displayed successfully on STD Premiums table");

					WebElement monthlypremium1 = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[2]"));
					String MonthlyPremium1 = monthlypremium1.getText().substring(1, 4);
					String[] MonthlyPremium1_1 = MonthlyPremium1.split("\\.");

					WebElement monthlypremium2 = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[2]"));
					String MonthlyPremium2 = monthlypremium2.getText().substring(1, 4);
					String[] MonthlyPremium2_2 = MonthlyPremium2.split("\\.");

					if ((Integer.parseInt(MonthlyPremium1_1[0]) != 0)
							&& (Integer.parseInt(MonthlyPremium2_2[0]) != 0)) {
						System.out.println("Estimated Total Monthly Premium Amounts :: " + monthlypremium1.getText()
								+ " and " + monthlypremium2.getText() + " displayed successfully");
					} else {
						System.out.println("Estimated Total Monthly Premium Amounts :: " + monthlypremium1.getText()
								+ " and " + monthlypremium2.getText() + " not displayed");
					}

				} else {
					System.out.println("Estimated Total Monthly Premium text not displayed on STD Premiums table");
				}

				WebElement annualpremium = driver.findElement(By.xpath(
						"//form[@name='ShortTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[1]/table/tbody/tr[3]"));

				if (annualpremium.getText().trim().contains("Annual Premium")) {
					System.out.println(
							"Estimated Total Annual Premium text displayed successfully on STD Premiums table");

					WebElement annualpremium1 = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[2]/table/tbody/tr[3]"));
					String ANNUALPremium1 = annualpremium1.getText().substring(1, 5);
					String[] ANNUALPremium1_1 = ANNUALPremium1.split("\\.");

					WebElement annualpremium2 = driver.findElement(By.xpath(
							"//form[@name='ShortTermDisabilityRateComparisonForm']/table/tbody/tr[16]/td/table/tbody/tr/td[3]/table/tbody/tr[3]"));
					String ANNUALPremium2 = annualpremium2.getText().substring(1, 5);
					String[] ANNUALPremium2_2 = ANNUALPremium2.split("\\.");

					if ((Integer.parseInt(ANNUALPremium1_1[0]) != 0) && (Integer.parseInt(ANNUALPremium2_2[0]) != 0)) {
						System.out.println("Estimated Total Annual Premium Amounts :: " + annualpremium1.getText()
								+ " and " + annualpremium2.getText() + " displayed successfully");
						driver.switchTo().window(winHandle).close();
					} else {
						System.out.println("Estimated Total Annual Premium Amounts :: " + annualpremium1.getText()
								+ " and " + annualpremium2.getText() + " not displayed");
					}

				} else {
					System.out.println("Estimated Total Annual Premium text not displayed on STD Premiums table");
				}
			}
		}
	}

	public void quoteSetUpPage_Class1_2_Plans(WebDriver driver, String noofCoverages, String coverage)
			throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		String pwindow = driver.getWindowHandle();

		utility.waitForVisibilityOfWebElement(By.xpath("//a[@href='javascript:openAccountExecSearch();']/img"), driver);

		element = driver.findElement(By.xpath("//a[@href='javascript:openAccountExecSearch();']/img"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("accountExecutiveSearch")) {
				System.out.println("Account Executive Search web page displayed successfully");
				System.out.println(
						"Account Executive Search page URL :: " + driver.switchTo().window(winHandle).getCurrentUrl());

				driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Smith");
				Thread.sleep(1000);

				By btnSicInputSubmit = By.xpath("//input[@name='submitSearch' or @value='SEARCH']");
				element = driver.findElement(btnSicInputSubmit);
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);

				element = driver.findElement(By.linkText("Select"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);
				// driver.switchTo().window(handle1).close();
				// driver.close();
			}
		}

		driver.switchTo().window(pwindow);
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteType, driver);
		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		if (coverage.trim().contains("LTD")) {
			utility.waitForVisibilityOfWebElement(ckhBoxProductTypeLtd, driver);
			element = driver.findElement(ckhBoxProductTypeLtd);
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
		}

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteCompanyName, driver);
		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());

		utility.waitForVisibilityOfWebElement(txtBoxstreetAddress, driver);
		// driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxstreetAddress).sendKeys(common.getAddress());

		utility.waitForVisibilityOfWebElement(txtBoxcityAddress, driver);
		// driver.findElement(txtBoxcityAddress).sendKeys("Site1");
		driver.findElement(txtBoxcityAddress).sendKeys(common.getCity());

		// Select stateSel=new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");

		utility.waitForVisibilityOfWebElement(txtBoxzipCode, driver);
		// driver.findElement(txtBoxzipCode).sendKeys("73301");
		driver.findElement(txtBoxzipCode).sendKeys(common.getZipCode());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxSICCODE, driver);
		// driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(totNumActiveEmployeesApplying, driver);
		driver.findElement(totNumActiveEmployeesApplying).clear();
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("10");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxquoteTotalNumEmployees, driver);
		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("10");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		// Thread.sleep(1000);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='quoteTotalNumDisabilityClasses']")).clear();
		driver.findElement(By.xpath("//input[@name='quoteTotalNumDisabilityClasses']")).sendKeys(noofCoverages);
		Thread.sleep(2000);
	}

	public void btnENTERCLASSDESCRIPTION_enterClassDescrition(WebDriver driver) throws InterruptedException {
		String pwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//input[@id='disClassButton' and @value='ENTER CLASS DESCRIPTION']")).click();
		// driver.findElement(By.xpath("//input[@id='disClassButton' and
		// @value='ENTER CLASS DESCRIPTION']")).sendKeys(Keys.ENTER);
		element = driver.findElement(By.xpath("//input[@id='disClassButton' and @value='ENTER CLASS DESCRIPTION']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("disabilityClassDefinitionsSetup")) {
				System.out.println("Enter Class Descriptions web page displayed successfully");
				System.out.println(
						"Enter Class Descriptions page URL :: " + driver.switchTo().window(winHandle).getCurrentUrl());

				element = driver.findElement(By.xpath("//td[contains(text(),'Enter Class Descriptions')]"));
				if (element.getText().trim().contains("Enter Class Descriptions")) {
					System.out.println("Enter Class Descriptions text present on Enter Class Descriptions page");
				} else {
					System.out.println("Enter Class Descriptions text not present on Enter Class Descriptions page");
				}
				Thread.sleep(1000);

				driver.findElement(By.xpath("//input[@name='disabilityClass[0].classDescription']")).sendKeys("Class1");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@name='disabilityClass[1].classDescription']")).sendKeys("Class2");
				Thread.sleep(1000);

				driver.findElement(By.xpath("//input[@name='disabilityClass[0].totalEmployeesApplying']")).clear();
				driver.findElement(By.xpath("//input[@name='disabilityClass[0].totalEmployeesApplying']"))
						.sendKeys("5");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@name='disabilityClass[1].totalEmployeesApplying']")).clear();
				driver.findElement(By.xpath("//input[@name='disabilityClass[1].totalEmployeesApplying']"))
						.sendKeys("6");
				Thread.sleep(1000);

				By btnClassSubmit = By.xpath("//input[@name='submit' and @value='SUBMIT']");
				element = driver.findElement(btnClassSubmit);
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);
				// driver.switchTo().window(handle1).close();
				// driver.close();
			}
		}

		driver.switchTo().window(pwindow);
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);
	}

	public void btnquoteSetUpNext(WebDriver driver) throws InterruptedException {
		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}

	public void tabClassPlanType(WebDriver driver, String classPlanType, String classPlanValue)
			throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String pageSupplementalEmployeeLife = "//td[contains(text(),'Supplemental Employee Life/AD&D Plans')]";
		QuotePage.verifyPageDisplay(driver, pageSupplementalEmployeeLife, "Supplemental Employee Life/AD&D Plans");

		QuotePage.verifyFooterLinks(driver);

		if (classPlanType.equals("Class 1 Plans")) {
			element = driver.findElement(By.name("class one"));

			if (element.getAttribute("value").trim().contains(classPlanType)) {
				System.out.println(classPlanType + " tab present on Supplemental Employee Life/AD&D Plans page");
			} else {
				System.out.println(classPlanType + " tab not present on Supplemental Employee Life/AD&D Plans page");
			}
		}

		if (classPlanType.equals("Class 2 Plans")) {
			element = driver.findElement(By.name("submitClassTwo"));

			if (element.getAttribute("value").trim().contains("Class 2 Plans")) {
				System.out.println(classPlanType + " tab present on Supplemental Employee Life/AD&D Plans page");
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(3000);
			} else {
				System.out.println(classPlanType + " tab not present on Supplemental Employee Life/AD&D Plans page");
			}
		}
	}

	public void verifyClassPlanName_PlanCodes(WebDriver driver, String classPlanName) throws InterruptedException {
		WebElement planCode1 = driver.findElement(By.name("supLifeClassPlanInformationForm[0].planId"));
		System.out.println("Plan Code1 ::" + planCode1.getAttribute("value"));

		WebElement planCode2 = driver.findElement(By.name("supLifeClassPlanInformationForm[1].planId"));
		System.out.println("Plan Code2 ::" + planCode2.getAttribute("value"));

		WebElement planCode3 = driver.findElement(By.name("supLifeClassPlanInformationForm[2].planId"));
		System.out.println("Plan Code1 ::" + planCode3.getAttribute("value"));

		WebElement planCode4 = driver.findElement(By.name("supLifeClassPlanInformationForm[3].planId"));
		System.out.println("Plan Code2 ::" + planCode4.getAttribute("value"));

		String P1 = planCode1.getAttribute("value");
		String P2 = planCode2.getAttribute("value");
		String P3 = planCode3.getAttribute("value");
		String P4 = planCode4.getAttribute("value");

		utility.waitForVisibilityOfWebElement(By.xpath("//input[@name='submitRateCompare']"), driver);
		element = driver.findElement(By.xpath("//input[@name='submitRateCompare']"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("employeeSupLifePlanSelection")) {
				System.out.println("Supplemental Employee Life/AD&D Rate Comparison web page displayed successfully");
				System.out.println("Supplemental Employee Life/AD&D Rate Comparison page URL :: "
						+ driver.switchTo().window(winHandle).getCurrentUrl());

				Thread.sleep(1000);
				WebElement element2 = driver.findElement(
						By.xpath("//td[contains(text(),'Supplemental Employee Life/AD&D Rate Comparison')]"));
				if (element2.getText().contains("Supplemental Employee Life/AD&D Rate Comparison")) {
					System.out.println("Supplemental Employee Life/AD&D Rate Comparison text displayed successfully");
				} else {
					System.out.println("Supplemental Employee Life/AD&D Rate Comparison text not displayed");
				}

				// element = driver.findElement(By.xpath(
				// "//form[@name='EmployeeSupLifeRateComparisonForm']/table/tbody/tr[9]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td"));
				if (classPlanName.equals("1 - Class1")) {
					element = driver.findElement(By.xpath("//td[contains(text(),'1 - Class1')]"));
				} else if (classPlanName.equals("2 - Class2")) {
					element = driver.findElement(By.xpath("//td[contains(text(),'2 - Class2')]"));
				}

				if (element.getText().trim().contains(classPlanName)) {
					System.out.println(classPlanName + " text displayed successfully on Plan Information table");

					WebElement PlanCode1 = driver.findElement(By.xpath(
							"//form[@name='EmployeeSupLifeRateComparisonForm']/table/tbody/tr[9]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]"));

					WebElement PlanCode2 = driver.findElement(By.xpath(
							"//form[@name='EmployeeSupLifeRateComparisonForm']/table/tbody/tr[9]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]"));

					WebElement PlanCode3 = driver.findElement(By.xpath(
							"//form[@name='EmployeeSupLifeRateComparisonForm']/table/tbody/tr[9]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/table/tbody/tr[1]"));

					WebElement PlanCode4 = driver.findElement(By.xpath(
							"//form[@name='EmployeeSupLifeRateComparisonForm']/table/tbody/tr[9]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[4]/table/tbody/tr[1]"));

					if ((PlanCode1.getText().trim().contains(P1)) && (PlanCode2.getText().trim().contains(P2))
							&& (PlanCode3.getText().trim().contains(P3)) && (PlanCode4.getText().trim().contains(P4))) {
						System.out.println("Plan Codes :: " + PlanCode1.getText() + " and " + PlanCode2.getText()
								+ " displayed successfully");
						System.out.println("Plan Codes :: " + PlanCode3.getText() + " and " + PlanCode4.getText()
								+ " displayed successfully");
						driver.switchTo().window(winHandle).close();
					} else {
						System.out.println("Plan Codes :: " + PlanCode1.getText() + " and " + PlanCode2.getText()
								+ " not displayed");
						System.out.println("Plan Codes :: " + PlanCode3.getText() + " and " + PlanCode4.getText()
								+ " not displayed");
						driver.switchTo().window(winHandle).close();
					}

				} else {
					System.out.println(classPlanName + " text not displayed on Plan Information table");
				}
			}
		}

	}

	public void quoteSetUpPage_SelectAllCoverages_ClassType_COBRA(WebDriver driver, String cobraEmpTotal)
			throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String quoteSetUpPage = ".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver, quoteSetUpPage, "Quote Setup");

		String quoteSetUpInfoTable = ".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");

		QuotePage.verifyFooterLinks(driver);

		String pwindow = driver.getWindowHandle();

		utility.waitForVisibilityOfWebElement(By.xpath("//a[@href='javascript:openAccountExecSearch();']/img"), driver);

		element = driver.findElement(By.xpath("//a[@href='javascript:openAccountExecSearch();']/img"));
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("accountExecutiveSearch")) {
				System.out.println("Account Executive Search web page displayed successfully");
				System.out.println(
						"Account Executive Search page URL :: " + driver.switchTo().window(winHandle).getCurrentUrl());

				driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Smith");
				Thread.sleep(1000);

				By btnSicInputSubmit = By.xpath("//input[@name='submitSearch' or @value='SEARCH']");
				element = driver.findElement(btnSicInputSubmit);
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);

				element = driver.findElement(By.linkText("Select"));
				executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(1000);
				// driver.switchTo().window(handle1).close();
				// driver.close();
			}
		}

		driver.switchTo().window(pwindow);
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteType, driver);
		Select quoteType = new Select(driver.findElement(quoteSetUpquoteType));
		// quoteType.selectByVisibleText("New Business");
		quoteType.selectByVisibleText(common.getQuoteType());

		utility.waitForVisibilityOfWebElement(quoteSetUpquoteCompanyName, driver);
		// driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys(common.getCompanyName());

		utility.waitForVisibilityOfWebElement(txtBoxstreetAddress, driver);
		// driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		driver.findElement(txtBoxstreetAddress).sendKeys(common.getAddress());

		utility.waitForVisibilityOfWebElement(txtBoxcityAddress, driver);
		// driver.findElement(txtBoxcityAddress).sendKeys("Site1");
		driver.findElement(txtBoxcityAddress).sendKeys(common.getCity());

		// Select stateSel=new Select(driver.findElement(dropDownState));
		// stateSel.selectByVisibleText("CA");

		utility.waitForVisibilityOfWebElement(txtBoxzipCode, driver);
		// driver.findElement(txtBoxzipCode).sendKeys("73301");
		driver.findElement(txtBoxzipCode).sendKeys(common.getZipCode());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(txtBoxSICCODE, driver);
		// driver.findElement(txtBoxSICCODE).sendKeys("9111");
		driver.findElement(txtBoxSICCODE).sendKeys(common.getSICCode());
		// Thread.sleep(1000);

		utility.waitForVisibilityOfWebElement(totNumActiveEmployeesApplying, driver);
		driver.findElement(totNumActiveEmployeesApplying).clear();
		// driver.findElement(totNumActiveEmployeesApplying).sendKeys("10");
		driver.findElement(totNumActiveEmployeesApplying).sendKeys(common.getNonCOBRAEmployees());
		// Thread.sleep(1000);

		driver.findElement(By.name("quoteLocationForm[0].totNumCobraEmployeesApplying")).sendKeys(cobraEmpTotal);

		utility.waitForVisibilityOfWebElement(txtBoxquoteTotalNumEmployees, driver);
		// driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("10");
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys(common.getTotalEmployees());
		// Thread.sleep(1000);

		element = driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		/*
		 * driver.findElement(By.xpath(
		 * "//input[@name='quoteTotalNumDisabilityClasses']")).clear();
		 * driver.findElement(By.xpath(
		 * "//input[@name='quoteTotalNumDisabilityClasses']")).sendKeys("2");
		 * Thread.sleep(2000);
		 * 
		 * driver.findElement(By.
		 * xpath("//input[@id='disClassButton' and @value='ENTER CLASS DESCRIPTION']"
		 * )).click(); //
		 * driver.findElement(By.xpath("//input[@id='disClassButton' and
		 * // @value='ENTER CLASS DESCRIPTION']")).sendKeys(Keys.ENTER); element
		 * = driver.findElement(By.
		 * xpath("//input[@id='disClassButton' and @value='ENTER CLASS DESCRIPTION']"
		 * )); executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", element);
		 * 
		 * utility.waitForNumberOfWindowsToEqual(2); for (String winHandle :
		 * driver.getWindowHandles()) { driver.switchTo().window(winHandle); if
		 * (driver.switchTo().window(winHandle).getCurrentUrl().contains(
		 * "disabilityClassDefinitionsSetup")) { System.out.
		 * println("Enter Class Descriptions web page displayed successfully");
		 * System.out.println( "Enter Class Descriptions page URL :: " +
		 * driver.switchTo().window(winHandle).getCurrentUrl());
		 * 
		 * element = driver.findElement(By.
		 * xpath("//td[contains(text(),'Enter Class Descriptions')]")); if
		 * (element.getText().trim().contains("Enter Class Descriptions")) {
		 * System.out.
		 * println("Enter Class Descriptions text present on Enter Class Descriptions page"
		 * ); } else { System.out.
		 * println("Enter Class Descriptions text not present on Enter Class Descriptions page"
		 * ); } Thread.sleep(1000);
		 * 
		 * driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[0].classDescription']")).sendKeys(
		 * "Class1"); Thread.sleep(1000); driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[1].classDescription']")).sendKeys(
		 * "Class2"); Thread.sleep(1000);
		 * 
		 * driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[0].totalEmployeesApplying']")).clear(
		 * ); driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[0].totalEmployeesApplying']"))
		 * .sendKeys("5"); Thread.sleep(1000); driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[1].totalEmployeesApplying']")).clear(
		 * ); driver.findElement(By.xpath(
		 * "//input[@name='disabilityClass[1].totalEmployeesApplying']"))
		 * .sendKeys("6"); Thread.sleep(1000);
		 * 
		 * By btnClassSubmit =
		 * By.xpath("//input[@name='submit' and @value='SUBMIT']"); element =
		 * driver.findElement(btnClassSubmit); executor = (JavascriptExecutor)
		 * driver; executor.executeScript("arguments[0].click();", element);
		 * Thread.sleep(1000); // driver.switchTo().window(handle1).close(); //
		 * driver.close(); } }
		 * 
		 * driver.switchTo().window(pwindow); Thread.sleep(1000);
		 * driver.switchTo().frame("content"); Thread.sleep(1000);
		 */
		element = driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}
	public void censusPage_COBRA(WebDriver driver,String empCOBRA) throws InterruptedException, IOException {
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(1000);
		String cencusPage = ".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";

		QuotePage.verifyPageDisplay(driver, cencusPage, "Census");
		Thread.sleep(1000);

		String cencusInfoTable = "//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver, cencusInfoTable, "Census Information");
		Thread.sleep(1000);

		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(1000);

		// driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement> ele4 = driver
				.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1 = ele4.size();
		Thread.sleep(1000);

		System.out.println("Row Count :: " + count1 + "Row Count  ::" + (count1 - 7));

		int j = 1000;
		for (int i = 0; i <= count1 - 7; i++) {

			Random rand = new Random();
			int Low = 25;
			int High = 40;
			int Result = rand.nextInt(High - Low) + Low;

			int WifeAgeLow = 15;
			int WifeAgeHigh = 30;
			int WifeAgeResult = rand.nextInt(WifeAgeHigh - WifeAgeLow) + WifeAgeLow;

			int AgeLow = 12;
			int AgeHigh = 14;
			int ChildAge = rand.nextInt(AgeHigh - AgeLow) + AgeLow;

			int LowSal = 50000;
			int HighSal = 100000;
			int TotSal = rand.nextInt(HighSal - LowSal) + LowSal;

			if (i < 11) {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText("Class 1 - All Employees");
			} else {
				Select ClassType = new Select(
						driver.findElement(By.name("censusDetailInformationForm[" + i + "].disabilityClassNumber")));
				ClassType.selectByVisibleText(empCOBRA);
				Thread.sleep(1000);
			}

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].employeeAge']"))
					.sendKeys(Integer.toString(Result));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].spouseAge']"))
					.sendKeys(Integer.toString(WifeAgeResult));
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].childrenToAdd']"))
					.sendKeys("1");
			Thread.sleep(1000);

			element = driver.findElement(By.xpath("//input[@id='add" + j + "']"));
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//input[@name='censusDetailInformationForm[" + i + "].dependentChildren[0].age']"))
					.sendKeys(Integer.toString(ChildAge));
			Thread.sleep(500);
			
			if (i < 11) {
				driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].transEmploymentStatus']")).sendKeys("A");
			} else {
				driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].transEmploymentStatus']")).clear();
				Thread.sleep(500);
				driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].transEmploymentStatus']")).sendKeys("C");				
			}

			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm[" + i + "].annualSalary']"))
					.sendKeys(Integer.toString(TotSal));
			Thread.sleep(500);
			j = j + 1000;
		}
		
		element = driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(7000);
	}


}
