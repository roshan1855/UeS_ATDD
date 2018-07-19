package com.optum.synergy.ues.ui.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.xpath.operations.Quo;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optum.synergy.ues.ui.utilities.Utilities;


public class QuotePage {
	Utilities utility;
	public static Properties autoProperties;
	public static WebDriver driver;
	public static WebDriverWait driverVar;
	public static ArrayList<String> ACTList;
    public static ArrayList<String> EXPList;
	//public static String baseURL="https://bfx.unitedeservices.com/uespublic/prelogin/login.jsp";
	//public static String baseURL="https://stage.unitedeservices.com/uessecured/index.jsp";
	public static String baseURL="http://dev1-ues.uhc.com/uessecured/index.jsp";
	public static WebElement element;
	public static JavascriptExecutor executor;
	DesiredCapabilities ieCapabilities;
	By uesUserName =By.xpath(".//*[@id='U']");
	By uesPwd=By.xpath(".//*[@id='P']");
	By uesLoginBtn=By.xpath("//a[contains(text(),'Log In')]");
	By uesQuote=By.xpath(".//*[@id='M1']");
	By uesNewQuote=By.name("SM1_1o");	
	//Census Page
	By censusDetailInformationFormAge=By.xpath("//input[@name='censusDetailInformationForm[0].employeeAge']");
	By censusDetailInformationFormAge1=By.xpath("//input[@name='censusDetailInformationForm[1].employeeAge']");
	By censussubmitNext=By.xpath("//input[@name='submitNext' or @value='NEXT']");
	//Medical Plan Page
	By chkBoxmedicalInPackageForm=By.name("medicalInPackageForm[0].packageSelected");
	By btnMedicalPlansubmitNext=By.xpath("//input[@name='submitNext' or @value='NEXT']");
	By btnOptionalMedicalPlansubmitNext=By.xpath("//input[@name='submitNext' or @value='NEXT']");
	//Vision Plan Page
	By btnVisionPlansubmitNext=By.xpath("//input[@name='submitNext' or @value='NEXT']");
	//Proposal Information Page
	By btnPreviewProposal=By.xpath("//input[@name='submitPreviewProposal']");
	//Login Page
	By loginUsername=By.xpath(".//*[@id='divContent']/table[1]/tbody/tr/td/span");
	//Logging Levels
	By messageLoggingLevel=By.xpath(".//*[@id='divContent']/table/tbody/tr[1]/td/div");
	//Err Message
	By errMessage=By.xpath("//td[@class='bodyError']");
	//new Quote
	By quotepolicyEffDateMonth=By.xpath("//input[@name='policyEffDateMonth']");
	By quoteemployeeCount=By.xpath("//input[@name='employeeCount']");
	By quoteatneCount=By.xpath("//input[@name='atneCount']");
	By quoteNextBtn=By.xpath("//input[@name='submitATNE']");
	By quotepolicyEffDateDay=By.name("policyEffDateDay");
	By quotepolicyEffDateYear=By.name("policyEffDateYear");
	By quoteatneCount1=By.xpath(".//*[@id='popupForm']/table/tbody/tr[3]/td/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input");
	//Quote SetUp
	By quoteSetUpquoteType=By.xpath("//select[@name='quoteType']");
	By quoteSetUpquoteCompanyName=By.xpath("//input[@name='quoteCompanyName']");
	By ckhBoxProductTypeMedical=By.xpath("//input[@name='selectProductTypeMedical']");
	By ckhBoxProductTypeDental=By.xpath("//input[@name='selectProductTypeDental']");
	By ckhBoxProductTypeLife=By.xpath("//input[@name='selectProductTypeLife']");
	By ckhBoxProductTypeVision=By.xpath("//input[@name='selectProductTypeVision']");
	By ckhBoxProductTypeStd=By.xpath("//input[@name='selectProductTypeStd']");
	By ckhBoxProductTypeLtd=By.xpath("//input[@name='selectProductTypeLtd']");
	By ckhBoxProductTypeEmpSupLife=By.xpath("//input[@name='selectProductTypeEmpSupLife']");
	By ckhBoxProductTypeDepSupLife=By.xpath("//input[@name='selectProductTypeDepSupLife']");
	By txtBoxstreetAddress=By.xpath("//input[@name='quoteLocationForm[0].streetAddress']");
	By txtBoxcityAddress=By.xpath("//input[@name='quoteLocationForm[0].cityAddress']");
	By dropDownState=By.xpath("//select[@name='quoteLocationForm[0].state']");
	By txtBoxzipCode=By.xpath("//input[@name='quoteLocationForm[0].zipCode']");
	By linkAutomatedLookup=By.xpath("//a[@href='javascript:sicDispatchSubmit()']");
	//SIC window
	By radioBtnSIC=By.xpath("//input[@value='SIC']");
	By linklookupLink=By.xpath(".//*[@id='lookupLink']/a");
	By btnsubmitNext=By.xpath("//input[@name='submitNext' or @value='NEXT']");
	By btnSUBMIT=By.xpath("//input[@value='SUBMIT']");
	//Quote SetUp Page
	By totNumActiveEmployeesApplying=By.xpath("//input[@name='quoteLocationForm[0].totNumActiveEmployeesApplying']");
	By txtBoxquoteTotalNumEmployees=By.xpath("//input[@name='quoteTotalNumEmployees']");
	By radioBtnMedicarePriPayer=By.xpath("//input[@name='selectMedicarePriPayer' and @value='false']");
	By btnquoteSetUpNext=By.xpath("//input[@onclick='javascript:return checkPageLoad();']");
	//Dental Plan page
	By chkBoxdentalPlanInformationForm=By.name("dentalPlanInformationForm[0].selectInd");
	By btnsubmitNextDentalPLan=By.xpath("//input[@name='submitNext' or @value='NEXT']");
	//Life Plan page
	By chkBoxlifePlanBasicInformationForm=By.name("lifePlanBasicInformationForm[2].selectBasicInd");
	By btnsubmitNextlifePLan=By.xpath("//input[@name='submitNext' or @value='NEXT']");
	
	//Compensation Tab
	By menuCompensation=By.xpath(".//*[@id='M9']");
	By compHomeText=By.xpath("//div[@class='contentTitle']");
	By compProducerPerformanceGuide=By.xpath("//span[contains(text(), 'Producer Performance Guide')]");
	By compCommissionSchedule=By.xpath("//span[contains(text(), 'Commission Schedule')]");
	By compCommissionStatements=By.xpath("//a[contains(text(),'Commission Statements')]");
	By compRequestDirectDepositAuthorization=By.xpath("//a[contains(text(),'Request Direct Deposit Authorization')]");
	
public QuotePage() throws IOException {
		
		utility = new Utilities();

	}

	
	public void pageUeSLogin() throws InterruptedException{
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	    caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	    caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	    System.setProperty("webdriver.ie.driver", autoProperties.getProperty("IEDriver"));
	    driver = new InternetExplorerDriver(caps);
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get(baseURL);  
		Thread.sleep(3000);
	}
	public void loginUeSApp(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(uesUserName).sendKeys("roshanadmin05");
		Thread.sleep(1000);
		driver.findElement(uesPwd).sendKeys("Computer$4");
		Thread.sleep(1000);
		element = driver.findElement(uesLoginBtn);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("User clicked Login Button.....");
		Thread.sleep(6000);
	}
	public void username_pwd() throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(uesUserName).sendKeys("roshanAdmin05");
		Thread.sleep(1000);
		driver.findElement(uesPwd).sendKeys("Computer$4");
		Thread.sleep(1000);
		element = driver.findElement(uesLoginBtn);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void clickQuote_NewQuote(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		//System.out.println("Page Title ::"+driver.getTitle());
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		driver.switchTo().frame("navbar");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("navbar").getTitle());
		Thread.sleep(2000);
		
		String unitedHealthcareLogo="//img[@title='UnitedHealthcare Logo']";
		//String unitedLogo=".//*[@id='table11']/tbody/tr/td[1]/p/a/img";
		//System.out.println("UnitedHealthcare Logo title Text : :" + driver.findElement(By.xpath(unitedHealthcareLogo)).getAttribute("title"));
		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");
		
		String unitedeServicesLogo="//img[@title='United eServices Logo']";
		//String unitedLogo=".//*[@id='table11']/tbody/tr/td[2]/p/a/img";
		//System.out.println("United Logo title Text : :" + driver.findElement(By.xpath(unitedeServicesLogo)).getAttribute("title"));
		//System.out.println("United Logo alt Text : :" + driver.findElement(By.xpath(unitedLogo)).getAttribute("alt"));
		QuotePage.verifyPageDisplay_logo(driver,unitedeServicesLogo, "United eServices Logo");
		
		element=driver.findElement(uesQuote);
		System.out.println("Element Value ::"+ element.getAttribute("value"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		//element.click();
	
		element=driver.findElement(uesNewQuote);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(6000);
		
	}
	
	public void verifyLoginPage(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='login']"));
		if(element.getText().contains("Log In")){
			System.out.println("User Is on UeS login page");
		}
		else{
			System.out.println("User Is not in UeS login page");	
		}
	}
	
	
	
	public void censusPage(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String cencusPage=".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";
		
		QuotePage.verifyPageDisplay(driver,cencusPage, "Census");
		Thread.sleep(2000);
		
		String cencusInfoTable="//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver,cencusInfoTable, "Census Information");
		Thread.sleep(2000);
		
		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement>  ele4=driver.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1=ele4.size();
		Thread.sleep(2000);
		
		System.out.println("Row Count :: " +count1 + "Row Count  ::" + (count1-7));

		int j=1000;
		for(int i=0;i<=count1-7;i++){
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].employeeAge']")).sendKeys("23");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].spouseAge']")).sendKeys("22");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].childrenToAdd']")).sendKeys("1");
			Thread.sleep(2000);
			
			element=driver.findElement(By.xpath("//input[@id='add"+j+"']"));
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].dependentChildren[0].age']")).sendKeys("14");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].annualSalary']")).sendKeys("12000");
			Thread.sleep(2000);
			j=j+1000;
		}
		
/*		for(int i=0;i<=10;i++){
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].annualSalary']")).sendKeys("5000");
			Thread.sleep(1000);
			
		}*/
		
		/*List<WebElement>  ele4=driver.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1=ele4.size();
		
		System.out.println("Row Count :: " +count1);

		for(int i=5;i<count1;i++){
		WebElement ele2=driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr["+i+"]/td[7]"));
		System.out.println("Inside TD : :" +ele2.getText());
		
		By.xpath("//input[@name='censusDetailInformationForm[0].employeeAge']");
		if(ele2.getText().contains("Approved")){
			System.out.println("Status got updated to Approved");
			Thread.sleep(1000);
			break;
		}
	}*/
		
/*		driver.findElement(censusDetailInformationFormAge).sendKeys("25");
		Thread.sleep(1000);
		
		driver.findElement(censusDetailInformationFormAge1).sendKeys("26");
		Thread.sleep(1000);*/
		
		element=driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
	}
	
	public void censusPage_OnlyEE_Salary(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String cencusPage=".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";
		
		QuotePage.verifyPageDisplay(driver,cencusPage, "Census");
		Thread.sleep(2000);
		
		String cencusInfoTable="//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver,cencusInfoTable, "Census Information");
		Thread.sleep(2000);
		
		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement>  ele4=driver.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1=ele4.size();
		Thread.sleep(2000);
		System.out.println("Row Count :: " +count1 + "Row Count  ::" + (count1-7));
		
		Random rand = new Random();
		int Low = 25;
		int High = 40;
		int Result = rand.nextInt(High-Low) + Low;
		System.out.println("Result ::" + Result);

		int j=1000;
		for(int i=0;i<=count1-7;i++){
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].employeeAge']")).sendKeys("25");
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].spouseAge']")).sendKeys("22");
			//Thread.sleep(1000);
			//driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].childrenToAdd']")).sendKeys("1");
			//Thread.sleep(1000);
			
			element=driver.findElement(By.xpath("//input[@id='add"+j+"']"));
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
			/*Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].dependentChildren[0].age']")).sendKeys("14");
			Thread.sleep(1000);*/
			
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].annualSalary']")).sendKeys("500000");
			Thread.sleep(1000);
			j=j+1000; 
		}

		element=driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
	}
	
	
	public void censusPageWithOutSal(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String cencusPage=".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";
		
		QuotePage.verifyPageDisplay(driver,cencusPage, "Census");
		
		String cencusInfoTable="//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver,cencusInfoTable, "Census Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		//driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement>  ele4=driver.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1=ele4.size();
		
		System.out.println("Row Count :: " +count1 + "Row Count  ::" + (count1-7));
		
		Random rand = new Random();
		int Low = 25;
		int High = 40;
		int Result = rand.nextInt(High-Low) + Low;
		System.out.println("Result ::" + Result);

		int j=1000;
		for(int i=0;i<=count1-7;i++){
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].employeeAge']")).sendKeys("25");
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].spouseAge']")).sendKeys("22");
			//Thread.sleep(1000);
			//driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].childrenToAdd']")).sendKeys("1");
			/*Thread.sleep(1000);
			
			element=driver.findElement(By.xpath("//input[@id='add"+j+"']"));
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].dependentChildren[0].age']")).sendKeys("14");
			Thread.sleep(1000);*/
			
			/*driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].annualSalary']")).sendKeys("5000");
			Thread.sleep(1000);
			j=j+1000; */
		}

		element=driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
	}
	
	public void censusPage_Dep_EE_WithoutSalary(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String cencusPage=".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";
		Thread.sleep(2000);
		
		QuotePage.verifyPageDisplay(driver,cencusPage, "Census");
		Thread.sleep(2000);
		
		String cencusInfoTable="//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver,cencusInfoTable, "Census Information");
		Thread.sleep(2000);
		
		QuotePage.verifyFooterLinks(driver);
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr[5]"));
		List<WebElement>  ele4=driver.findElements(By.xpath(".//*[@id='census-form']/table[8]/tbody/tr[2]/td/table/tbody/tr"));
		int count1=ele4.size();
		Thread.sleep(2000);
		
		System.out.println("Row Count :: " +count1 + "Row Count  ::" + (count1-7));
		
		Random rand = new Random();
		int Low = 25;
		int High = 40;
		int Result = rand.nextInt(High-Low) + Low;
		System.out.println("Result ::" + Result);

		int j=1000;
		for(int i=0;i<=count1-7;i++){
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].employeeAge']")).sendKeys("25");
			Thread.sleep(500);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].spouseAge']")).sendKeys("22");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].childrenToAdd']")).sendKeys("1");
			Thread.sleep(1000);
			
			element=driver.findElement(By.xpath("//input[@id='add"+j+"']"));
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].dependentChildren[0].age']")).sendKeys("14");
			Thread.sleep(1000);
			/*
			driver.findElement(By.xpath("//input[@name='censusDetailInformationForm["+i+"].annualSalary']")).sendKeys("500000");
			Thread.sleep(1000);*/
			j=j+1000; 
		}

		element=driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
	}
	
	
	public void censusPage_clickNext(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String censusPage=".//*[@id='census-form']/table[1]/tbody/tr[2]/td[1]";
		QuotePage.verifyPageDisplay(driver,censusPage, "Census");
		
		String cencusInfoTable="//td[contains(text(),'Census Information')]";
		QuotePage.verifyPageInfoTable(driver,cencusInfoTable, "Census Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		driver.findElement(censusDetailInformationFormAge).sendKeys("14");
		Thread.sleep(2000);
		
		driver.findElement(censusDetailInformationFormAge1).sendKeys("14");
		Thread.sleep(2000);
		
		element=driver.findElement(censussubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
	}
	
	
	public void medicalPlanPage(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(10000);
		String medicalPage=".//*[@id='divContent']/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]";
		QuotePage.verifyPageDisplay(driver,medicalPage, "Medical Plans");
		Thread.sleep(10000);
		
		String medicalInfoTable="//td[contains(text(),'Medical Plan Information')]";
		//String medicalInformationTable=".//*[@id='divContent']/form/table/tbody/tr[12]/td/table/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver,medicalInfoTable, "Medical Plan Information");
		Thread.sleep(4000);
		
		//QuotePage.verifyFooterLinks(driver);
		
		element=driver.findElement(chkBoxmedicalInPackageForm);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		
		//QuotePage.verifyFooterLinks(driver);
		
		element=driver.findElement(btnMedicalPlansubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
		
		String optionalMedicalRidersPage= "//td[contains(text(),'Optional Medical Riders')]";
		QuotePage.verifyPageDisplay(driver,optionalMedicalRidersPage, "Optional Medical Riders");
		Thread.sleep(5000);
		
		String optionalMedicalRiderInfoTable="//td[contains(text(),'Medical Rider Information')]";
		QuotePage.verifyPageInfoTable(driver,optionalMedicalRiderInfoTable, "Medical Rider Information");
		Thread.sleep(5000);
		
		element=driver.findElement(btnOptionalMedicalPlansubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}
	
	
	public void visionPlanPage(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		//Vision Plans
		String visionPlansPage="//td[contains(text(),'Vision Plans')]";
		QuotePage.verifyPageDisplay(driver,visionPlansPage, "Vision Plans");
		
		String visionVisionPlanInfoTable="//td[contains(text(),'Vision Plan Information')]";
		QuotePage.verifyPageInfoTable(driver,visionVisionPlanInfoTable, "Vision Plan Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		element=driver.findElement(btnVisionPlansubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}
	
	public void proposalInformationPage(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		//Proposal Information
		
		Thread.sleep(8000);
		
		String proposalInformationPage= "//td[contains(text(),'Proposal Information')]";
		QuotePage.verifyPageDisplay(driver,proposalInformationPage, "Proposal Information");
		Thread.sleep(1000);	
		
		String proposalSetupTable="//td[contains(text(),'Proposal Setup')]";
		QuotePage.verifyPageInfoTable(driver,proposalSetupTable, "Proposal Setup");
		
		QuotePage.verifyFooterLinks(driver);
				
		        element=driver.findElement(btnPreviewProposal);
				System.out.println("PDF Value :"+element.getAttribute("value"));
				//System.out.println("PDF Value :"+element.getText());
				
			if (element.getAttribute("value").trim().contains("PREVIEW PROPOSAL")){
	        		System.out.println("Proposal Preview PDF displayed successfully");
	        		Thread.sleep(2000);
	        		//driver.switchTo().window(handle1).close();
	        	}
				
				element=driver.findElement(btnPreviewProposal);
				executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(15000);
				
				/*for (String handle1 : driver.getWindowHandles()) {
	        	//System.out.println("Child window : :" + handle1);

	        	driver.switchTo().window(handle1);
	        	Thread.sleep(5000);
	        	String pdfTitle=driver.switchTo().window(handle1).getTitle();
	        	String pdfTitle1=driver.switchTo().window(handle1).getCurrentUrl();
	        	//System.out.println("PDF Title is ::" + pdfTitle);
	        	//System.out.println("PDF Title URL is ::" + pdfTitle1);
	        	if ((pdfTitle.contains("proposalDocumentSetup")) || (pdfTitle1.contains("proposalDocumentSetup"))){
	        		System.out.println("Proposal PDF page displayed successfully");
	        		Thread.sleep(3000);
	        		driver.switchTo().window(handle1).close();
	        	}
	        	//break;
	        	}*/
				
	}
	
	public void loginUeS(String usrname,String pwd) throws InterruptedException{
		Thread.sleep(8000);
		driver.findElement(uesUserName).sendKeys(usrname);
		Thread.sleep(2000);
		driver.findElement(uesPwd).sendKeys(pwd);
		Thread.sleep(2000);
		element = driver.findElement(uesLoginBtn);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	public void clickCompensation(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		//System.out.println("Page Title ::"+driver.getTitle());
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("navbar").getTitle());
		Thread.sleep(3000);
		
		element=driver.findElement(menuCompensation);
		System.out.println("Element Value ::"+ element.getAttribute("value"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);	
		Thread.sleep(5000);
	}
	public void verifyCompensationHome(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		//System.out.println("Page Title ::"+driver.getTitle());
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		QuotePage.verifyFooterLinks(driver);
		
		String compHome;
		compHome=driver.findElement(compHomeText).getText();
		//System.out.println("Compensation Home text ::"+compHome);
		
		String comSchedule;
		comSchedule=driver.findElement(compProducerPerformanceGuide).getText();
		//System.out.println("Producer Performance Guide text ::"+comSchedule);
		
		String comSchedule1;
		comSchedule1=driver.findElement(compCommissionSchedule).getText();
		//System.out.println("Commission Schedule Text ::"+comSchedule1);
		
		String comSchedule2;
		comSchedule2=driver.findElement(compCommissionStatements).getText();
		//System.out.println("Commission Statements text ::"+comSchedule2);
		
		String comSchedule3;
		comSchedule3=driver.findElement(compRequestDirectDepositAuthorization).getText();
		//System.out.println("Request Direct Deposit Authorization text ::"+comSchedule3);
		
		ACTList=new ArrayList<>();
		ACTList.add("Compensation Home");
		ACTList.add("Producer Performance Guide");
		ACTList.add("Commission Schedule");
		ACTList.add("Commission Statements");
		ACTList.add("Request Direct Deposit Authorization");
		
		EXPList=new ArrayList<>();
		EXPList.add(compHome);
		EXPList.add(comSchedule);
		EXPList.add(comSchedule1);
		EXPList.add(comSchedule2);
		EXPList.add(comSchedule3);
			
		//System.out.println("Size of ACTList ::" + ACTList.size() );
		//System.out.println("Size of EXPList ::" + EXPList.size() );
		int ExpFlag=5;
		int Flag=0;
		if(ACTList.size()== EXPList.size()){
            
           for(int i =0 ; i<ACTList.size();i++){                           
                           if(((String)ACTList.get(i).trim()).equals((String)EXPList.get(i).trim())){
                              System.out.println("values are matching::"+ACTList.get(i) +":"+EXPList.get(i) );
                              Flag=Flag+1;
                           }
                           else{
                              System.out.println("values are not matching::" + ACTList.get(i) +":"+EXPList.get(i) );
                           }
           }            
            if(Flag==ExpFlag){
            	System.out.println("Compensation Home page displayed with expected Data");
            }
            else{
            	System.out.println("Compensation Home page not displayed with expected Data");
            }
		}
		
	}		
		
		/*if (compHome.contains("Compensation Home")){
			System.out.println("Compensation Home page displayed successfully");
		}
		else{
			System.out.println("Compensation Home page not displayed");
		}
	}*/
	
	public void verifyLogin(String usrname,WebDriver driver) throws InterruptedException{
		Thread.sleep(2000);
		//System.out.println("Page Title ::"+driver.getTitle());
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		
		String uesHome;
		uesHome=driver.findElement(loginUsername).getText();
		System.out.println("UeS Home Text ::"+uesHome);
		
		if (uesHome.contains("roshan")){
			System.out.println("UeS Home page displayed successfully");
		}
		else{
			System.out.println("UeS Home page not displayed");
		}
		
		QuotePage.verifyFooterLinks(driver);
	}
	
	public void clickLink_Administration_ModifyLoggingLevels(WebDriver driver) throws InterruptedException{
		Thread.sleep(6000);
		//System.out.println("Page Title ::"+driver.getTitle());
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("navbar");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("navbar").getTitle());
		Thread.sleep(3000);
		
		String unitedHealthcareLogo="//img[@title='UnitedHealthcare Logo']";
		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");
		
		String unitedeServicesLogo="//img[@title='United eServices Logo']";
		QuotePage.verifyPageDisplay_logo(driver,unitedeServicesLogo, "United eServices Logo");
		
		Thread.sleep(3000);
		element=driver.findElement(By.linkText("Administration"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(3000);
		
		String siteAdministrationPage="//div[contains(text(),'Site Administration')]";
		QuotePage.verifyPageInfoTable(driver, siteAdministrationPage, "Site Administration");
		
		QuotePage.verifyFooterLinks(driver);
		
		element=driver.findElement(By.linkText("Modify Logging Levels"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
	}
	
	public void selectDropdown_Application_LoggingLevel(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		
		String modifyLoggingLevelsPage="//td[contains(text(),'Modify Logging Levels')]";
		QuotePage.verifyPageDisplay(driver,modifyLoggingLevelsPage, "Modify Logging Levels");
		
		QuotePage.verifyFooterLinks(driver);
		
		element=driver.findElement(By.name("application"));
		Select appDropDown=new Select(element);
		appDropDown.selectByVisibleText("uespublicEAR");
		
		Thread.sleep(1000);
		
		element=driver.findElement(By.name("loggingLevel"));
		Select loglevelDropDown=new Select(element);
		loglevelDropDown.selectByVisibleText("DEBUG");
		
		Thread.sleep(2000);
		By loggingPagesubmitNext=By.xpath("//input[@name='submitNext' and @value='SUBMIT']");
		
		element=driver.findElement(loggingPagesubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public void verifyMessage(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		
		QuotePage.verifyUeSLogos(driver);
		
		QuotePage.verifyFooterLinks(driver);
		
		element=driver.findElement(messageLoggingLevel);
		System.out.println("Logging Level Text::"+element.getText());
		
		if(element.getText().trim().contains("Modify Logging Levels Success")){
			System.out.println("Modify Logging Levels Success");
		}
		else
		{
			System.out.println("Not Modify Logging Levels");
		}
	}
	
	public void verifyErrMessage(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
				
		element=driver.findElement(errMessage);
		//System.out.println("Error Meassge ::"+element.getText());
		
		if(element.getText().contains("Employee's age must be greater than 14")){
			System.out.println("Employee's age must be greater than 14 for employee");
		}
		else{
			System.out.println("Not displayed any err message for Employee age below 14");
		}
		
	}
	
	public void quoteSetupPage(WebDriver driver) throws InterruptedException{
		//System.out.println("out side Tilte : :"+driver.getTitle());
		String pwindow=driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(200);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(2000);
		
		String quoteSetUpInfoWindow=".//*[@id='ui-dialog-title-dialogQuote']";
		//System.out.println("Quote Set Up Window text : :" + driver.findElement(By.xpath(quoteSetUpInfoWindow)).getText());
		QuotePage.verifyPageDisplay(driver,quoteSetUpInfoWindow, "Quote Setup");
		
		driver.findElement(quotepolicyEffDateMonth).sendKeys("07");
		Thread.sleep(2000);
		
		driver.findElement(quotepolicyEffDateDay).sendKeys("01");
		Thread.sleep(2000);
		
		
		driver.findElement(quotepolicyEffDateYear).sendKeys("18");
		Thread.sleep(2000);
		
		Select cominfoState=new Select(driver.findElement(By.name("state")));
		cominfoState.selectByVisibleText("CA");
		Thread.sleep(2000);
		
		driver.findElement(quoteemployeeCount).clear();
		driver.findElement(quoteemployeeCount).sendKeys("11");
		Thread.sleep(2000);
		
		//driver.findElement(By.name("atneCount")).sendKeys("5");
		//Thread.sleep(2000);
		
		driver.findElement(quoteatneCount1).clear();
		driver.findElement(quoteatneCount1).sendKeys("11");
		Thread.sleep(2000);
						
		element=driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		
		String quoteSetUpPage=".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver,quoteSetUpPage, "Quote Setup");
		
		String quoteSetUpInfoTable=".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		Select quoteType=new Select(driver.findElement(quoteSetUpquoteType));
		quoteType.selectByVisibleText("New Business");
		
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
		element=driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		element=driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		element=driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		Thread.sleep(2000);
		
		driver.findElement(txtBoxcityAddress).sendKeys("Site2");
		Thread.sleep(2000);
		
		Select stateSel=new Select(driver.findElement(dropDownState));
		stateSel.selectByVisibleText("CA");
		
		driver.findElement(txtBoxzipCode).sendKeys("90701");
		Thread.sleep(5000);
		
		element=driver.findElement(linkAutomatedLookup);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		
		
		for (String handle1 : driver.getWindowHandles()) {
        	//System.out.println("Child window : :" + handle1);

        	driver.switchTo().window(handle1);
        	//System.out.println("Inside Window");
        	//break;
        	}	
		
		Thread.sleep(10000);
		String sicInputWindow="//td[@class='sectionHeading11']";
		QuotePage.verifyPageDisplay(driver,sicInputWindow, "SIC Input");
		
		Thread.sleep(10000);
		element=driver.findElement(radioBtnSIC);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		
		element=driver.findElement(linklookupLink);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		
		element=driver.findElement(btnsubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		
		element=driver.findElement(btnsubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		
		element=driver.findElement(btnSUBMIT);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		
	
		
		driver.switchTo().window(pwindow);
		Thread.sleep(10000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(3000);
		
		driver.findElement(totNumActiveEmployeesApplying).clear();
		driver.findElement(totNumActiveEmployeesApplying).sendKeys("11");
		Thread.sleep(1000);
		
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("11");
		Thread.sleep(1000);
		
		element=driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		element=driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000); 
	}
	
	public void M_V_quoteSetupPage(WebDriver driver) throws InterruptedException{
		//System.out.println("out side Tilte : :"+driver.getTitle());
		String pwindow=driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(2000);
		
		String quoteSetUpInfoWindow=".//*[@id='ui-dialog-title-dialogQuote']";
		//System.out.println("Quote Set Up Window text : :" + driver.findElement(By.xpath(quoteSetUpInfoWindow)).getText());
		QuotePage.verifyPageDisplay(driver,quoteSetUpInfoWindow, "Quote Setup");
		
		driver.findElement(quotepolicyEffDateMonth).sendKeys("07");
		Thread.sleep(1000);
		
		driver.findElement(quotepolicyEffDateDay).sendKeys("01");
		Thread.sleep(1000);
		
		
		driver.findElement(quotepolicyEffDateYear).sendKeys("18");
		Thread.sleep(1000);
		
		Select cominfoState=new Select(driver.findElement(By.name("state")));
		cominfoState.selectByVisibleText("CA");
		Thread.sleep(1000);
		
		driver.findElement(quoteemployeeCount).clear();
		driver.findElement(quoteemployeeCount).sendKeys("11");
		Thread.sleep(1000);
		
		//driver.findElement(By.name("atneCount")).sendKeys("5");
		//Thread.sleep(2000);
		
		driver.findElement(quoteatneCount1).clear();
		driver.findElement(quoteatneCount1).sendKeys("11");
		Thread.sleep(1000);
						
		element=driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
		
		String quoteSetUpPage=".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver,quoteSetUpPage, "Quote Setup");
		
		String quoteSetUpInfoTable=".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		Select quoteType=new Select(driver.findElement(quoteSetUpquoteType));
		quoteType.selectByVisibleText("New Business");
		
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum_M_V");
		Thread.sleep(1000);
		
		
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeDental);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		element=driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		element=driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		Thread.sleep(1000);
		
		driver.findElement(txtBoxcityAddress).sendKeys("Site2");
		Thread.sleep(1000);
		
		Select stateSel=new Select(driver.findElement(dropDownState));
		stateSel.selectByVisibleText("CA");
		
		driver.findElement(txtBoxzipCode).sendKeys("90701");
		Thread.sleep(2000);
		
		element=driver.findElement(linkAutomatedLookup);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		
		
		for (String handle1 : driver.getWindowHandles()) {
        	//System.out.println("Child window : :" + handle1);

        	driver.switchTo().window(handle1);
        	//System.out.println("Inside Window");
        	//break;
        	}	
		
		Thread.sleep(15000);
		String sicInputWindow="//td[@class='sectionHeading11']";
		QuotePage.verifyPageDisplay(driver,sicInputWindow, "SIC Input");
		
		Thread.sleep(2000);
		element=driver.findElement(radioBtnSIC);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
/*		element=driver.findElement(linklookupLink);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(btnsubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(btnsubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(btnSUBMIT);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);*/
		
		driver.findElement(By.xpath("//input[@class='contentText8']")).sendKeys("9111");
		Thread.sleep(2000);
		
		By btnSicInputSubmit=By.xpath("//input[@type='submit']");
		
		
		element=driver.findElement(btnSicInputSubmit);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
	
		
		driver.switchTo().window(pwindow);
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(1000);
		
		driver.findElement(totNumActiveEmployeesApplying).clear();
		driver.findElement(totNumActiveEmployeesApplying).sendKeys("11");
		Thread.sleep(1000);
		
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("11");
		Thread.sleep(1000);
		
		element=driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		element=driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000); 
	}
	
	public void D_V_L_quoteSetupPage(WebDriver driver,String coverage) throws InterruptedException{
		//System.out.println("out side Tilte : :"+driver.getTitle());
		String pwindow=driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(2000);
		
		String quoteSetUpInfoWindow=".//*[@id='ui-dialog-title-dialogQuote']";
		//System.out.println("Quote Set Up Window text : :" + driver.findElement(By.xpath(quoteSetUpInfoWindow)).getText());
		QuotePage.verifyPageDisplay(driver,quoteSetUpInfoWindow, "Quote Setup");
		
		driver.findElement(quotepolicyEffDateMonth).sendKeys("07");
		Thread.sleep(1000);
		
		driver.findElement(quotepolicyEffDateDay).sendKeys("01");
		Thread.sleep(1000);
		
		
		driver.findElement(quotepolicyEffDateYear).sendKeys("18");
		Thread.sleep(1000);
		
		Select cominfoState=new Select(driver.findElement(By.name("state")));
		cominfoState.selectByVisibleText("CA");
		Thread.sleep(1000);
		
		driver.findElement(quoteemployeeCount).clear();
		driver.findElement(quoteemployeeCount).sendKeys("11");
		Thread.sleep(1000);
		
		//driver.findElement(By.name("atneCount")).sendKeys("5");
		//Thread.sleep(2000);
		
		driver.findElement(quoteatneCount1).clear();
		driver.findElement(quoteatneCount1).sendKeys("11");
		Thread.sleep(1000);
						
		element=driver.findElement(quoteNextBtn);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
		
		String quoteSetUpPage=".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver,quoteSetUpPage, "Quote Setup");
		
		String quoteSetUpInfoTable=".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		Select quoteType=new Select(driver.findElement(quoteSetUpquoteType));
		quoteType.selectByVisibleText("New Business");
		
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum_" + coverage);
		Thread.sleep(1000);
		
		
		Thread.sleep(1000);
		
	
		element=driver.findElement(ckhBoxProductTypeMedical);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);

		if (!coverage.equals("DVL"))
		{		
			if (!coverage.equals("DV"))
		     {
				if (!coverage.equals("DL")){
		element=driver.findElement(ckhBoxProductTypeDental);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
				}
				if (!coverage.equals("VL")){
		element=driver.findElement(ckhBoxProductTypeVision);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
				}
		     }
			if (!coverage.equals("DL")&& !coverage.equals("VL")){
		  element=driver.findElement(ckhBoxProductTypeLife);
		  executor = (JavascriptExecutor)driver;
		  executor.executeScript("arguments[0].click();", element);
		  Thread.sleep(1000);
			}
		}
		
		element=driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(200);
		
		element=driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(200);
		
		element=driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		
		driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		Thread.sleep(1000);
		
		driver.findElement(txtBoxcityAddress).sendKeys("Site2");
		Thread.sleep(1000);
		
		Select stateSel=new Select(driver.findElement(dropDownState));
		stateSel.selectByVisibleText("CA");
		
		driver.findElement(txtBoxzipCode).sendKeys("90701");
		Thread.sleep(2000);
		
		element=driver.findElement(linkAutomatedLookup);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(15000);
		
		
		for (String handle1 : driver.getWindowHandles()) {
        	//System.out.println("Child window : :" + handle1);

        	driver.switchTo().window(handle1);
        	//System.out.println("Inside Window");
        	//break;
        	}	
		
		Thread.sleep(15000);
		String sicInputWindow="//td[@class='sectionHeading11']";
		QuotePage.verifyPageDisplay(driver,sicInputWindow, "SIC Input");
		
		Thread.sleep(8000);
		element=driver.findElement(radioBtnSIC);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
		
		element=driver.findElement(linklookupLink);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
		
		element=driver.findElement(btnsubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		
		element=driver.findElement(btnsubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		
		element=driver.findElement(btnSUBMIT);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
		
	
		
		driver.switchTo().window(pwindow);
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(2000);
		
		driver.findElement(totNumActiveEmployeesApplying).clear();
		driver.findElement(totNumActiveEmployeesApplying).sendKeys("11");
		Thread.sleep(2000);
		
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("11");
		Thread.sleep(1000);
		
		element=driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		element=driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000); 
	}

	
	
	public void dentalPlanPage(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(5000);
		
		String dentalPlansPage="//td[contains(text(),'Dental Plans')]";
		Thread.sleep(4000);
		QuotePage.verifyPageDisplay(driver,dentalPlansPage, "Dental Plans");
		
		String dentalPlanInformationTable="//td[contains(text(),'Dental PPO/Indemnity Plan Information')]";
		QuotePage.verifyPageInfoTable(driver,dentalPlanInformationTable, "Dental PPO/Indemnity Plan Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		element=driver.findElement(chkBoxdentalPlanInformationForm);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		
		element=driver.findElement(btnsubmitNextDentalPLan);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
	}
	
	public void lifePlanPage(WebDriver driver) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(2000);
		String lifePlansPage="//td[contains(text(),'Life Plans')]";
		QuotePage.verifyPageDisplay(driver,lifePlansPage, "Life Plans");
		
		String lifeBasicLifePlanInfoTable="//td[contains(text(),'Basic Life Plan Information')]";
		QuotePage.verifyPageInfoTable(driver,lifeBasicLifePlanInfoTable, "Basic Life Plan Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		 element=driver.findElement(chkBoxlifePlanBasicInformationForm);
		 executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", element);
		 Thread.sleep(2000);
			
		 element=driver.findElement(btnsubmitNextlifePLan);
		 executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", element);
		 Thread.sleep(3000);
	}
	
	public static void verifyPageDisplay(WebDriver driver,String path,String pageName) throws InterruptedException{
		//driver.findElement(By.xpath(path)).getText().trim().contains(pageName);
		Thread.sleep(5000);
		//element=driver.findElement(By.xpath(path));
		if(driver.findElement(By.xpath(path)).getText().trim().contains(pageName)){
			System.out.println(pageName + " Page displayed successfully");
		}
		else{
			System.out.println(pageName + " Page not displayed");
		}
			
	}
	
	public static void verifyPageInfoTable(WebDriver driver,String path,String pageInfoTable) throws InterruptedException{
		//driver.findElement(By.xpath(path)).getText().trim().contains(pageName);
		Thread.sleep(1000);
		//element=driver.findElement(By.xpath(path));
		if(driver.findElement(By.xpath(path)).getText().trim().contains(pageInfoTable)){
			System.out.println(pageInfoTable + " table displayed successfully");
		}
		else{
			System.out.println(pageInfoTable + " table not displayed");
		}
			
	}
	
	public static void verifyPageDisplay_logo(WebDriver driver,String path,String pageName) throws InterruptedException{
		Thread.sleep(1000);
		//element=driver.findElement(By.xpath(path));
		if(driver.findElement(By.xpath(path)).getAttribute("title").trim().contains(pageName)){
			System.out.println(pageName + " displayed successfully");
		}
		else{
			System.out.println(pageName + " not displayed");
		}
			
	}
	
	public static void verifyUeSLogos(WebDriver driver) throws InterruptedException{
		//System.out.println("out side Tilte : :"+driver.getTitle());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("navbar");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("navbar").getTitle());
		Thread.sleep(1000);
		
		String unitedHealthcareLogo="//img[@title='UnitedHealthcare Logo']";
		//String unitedLogo=".//*[@id='table11']/tbody/tr/td[1]/p/a/img";
		//System.out.println("UnitedHealthcare Logo title Text : :" + driver.findElement(By.xpath(unitedHealthcareLogo)).getAttribute("title"));
		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");
		
		String unitedeServicesLogo="//img[@title='United eServices Logo']";
		//String unitedLogo=".//*[@id='table11']/tbody/tr/td[2]/p/a/img";
		//System.out.println("United Logo title Text : :" + driver.findElement(By.xpath(unitedeServicesLogo)).getAttribute("title"));
		//System.out.println("United Logo alt Text : :" + driver.findElement(By.xpath(unitedLogo)).getAttribute("alt"));
		QuotePage.verifyPageDisplay_logo(driver,unitedeServicesLogo, "United eServices Logo");
		
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(2000);
	}
	
	public void verifyUeSLogos_Home(WebDriver driver) throws InterruptedException{
		//System.out.println("out side Tilte : :"+driver.getTitle());
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("navbar").getTitle());
		Thread.sleep(3000);
		
		String unitedHealthcareLogo="//img[@title='UnitedHealthcare Logo']";
		//String unitedLogo=".//*[@id='table11']/tbody/tr/td[1]/p/a/img";
		//System.out.println("UnitedHealthcare Logo title Text : :" + driver.findElement(By.xpath(unitedHealthcareLogo)).getAttribute("title"));
		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");
		
		String unitedeServicesLogo="//img[@title='United eServices Logo']";
		//String unitedLogo=".//*[@id='table11']/tbody/tr/td[2]/p/a/img";
		//System.out.println("United Logo title Text : :" + driver.findElement(By.xpath(unitedeServicesLogo)).getAttribute("title"));
		//System.out.println("United Logo alt Text : :" + driver.findElement(By.xpath(unitedLogo)).getAttribute("alt"));
		QuotePage.verifyPageDisplay_logo(driver,unitedeServicesLogo, "United eServices Logo");
	}
	
	public static void verifyFooterLinks(WebDriver driver) throws InterruptedException{
		Thread.sleep(6000);
		By aboutUs=By.xpath("//a[contains(text(),'About Us')]");
		By privacyPolicy=By.xpath("//a[contains(text(),'Privacy Policy')]");
		By termsOfUse=By.xpath("//a[contains(text(),'Terms of Use')]");
		
		String aboutUsText,privacyPolicyText,termsOfUseText;
		aboutUsText=driver.findElement(aboutUs).getText();
		privacyPolicyText=driver.findElement(privacyPolicy).getText();
		termsOfUseText=driver.findElement(termsOfUse).getText();
		
		if((aboutUsText.contains("About Us")) && (privacyPolicyText.contains("Privacy Policy")) && (termsOfUseText.contains("Terms of Use"))){
			System.out.println(aboutUsText + "," + privacyPolicyText + " and "+ termsOfUseText + " Footer links are displayed successfully");
		}
		else{
			System.out.println(aboutUsText + "," + privacyPolicyText + " and "+ termsOfUseText + " Footer links are not displayed");
		}
			
      //assertEquals("status is different than 0" ,"EXIT STATUS = 0", status); 
	}
	
	public void quoteSetUpWindow(WebDriver driver,String state) throws InterruptedException{
		//System.out.println("out side Tilte : :"+driver.getTitle());
				String pwindow=driver.getWindowHandle();
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				Thread.sleep(1000);
				driver.switchTo().frame("content");
				//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
				Thread.sleep(2000);
				
				String quoteSetUpInfoWindow=".//*[@id='ui-dialog-title-dialogQuote']";
				//System.out.println("Quote Set Up Window text : :" + driver.findElement(By.xpath(quoteSetUpInfoWindow)).getText());
				QuotePage.verifyPageDisplay(driver,quoteSetUpInfoWindow, "Quote Setup");
				
				driver.findElement(quotepolicyEffDateMonth).sendKeys("07");
				Thread.sleep(1000);
				
				driver.findElement(quotepolicyEffDateDay).sendKeys("01");
				Thread.sleep(1000);
				
				
				driver.findElement(quotepolicyEffDateYear).sendKeys("18");
				Thread.sleep(1000);
				
				Select cominfoState=new Select(driver.findElement(By.name("state")));
				cominfoState.selectByVisibleText(state);
				Thread.sleep(1000);
				
				driver.findElement(quoteemployeeCount).clear();
				driver.findElement(quoteemployeeCount).sendKeys("11");
				Thread.sleep(1000);
				
				//driver.findElement(By.name("atneCount")).sendKeys("5");
				//Thread.sleep(2000);
				
				driver.findElement(quoteatneCount1).clear();
				driver.findElement(quoteatneCount1).sendKeys("11");
				Thread.sleep(1000);
								
				element=driver.findElement(quoteNextBtn);
				executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(3000);
	}
	
	public void QuoteSetUpPage(WebDriver driver,String zip) throws InterruptedException{
		Thread.sleep(3000);
		String quoteSetUpPage=".//*[@id='quoteForm']/table[1]/tbody/tr[2]/td/table/tbody/tr[1]/td[1]";
		QuotePage.verifyPageDisplay(driver,quoteSetUpPage, "Quote Setup");
		
		String quoteSetUpInfoTable=".//*[@id='quoteForm']/table[3]/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver, quoteSetUpInfoTable, "Quote Information");
		
		QuotePage.verifyFooterLinks(driver);
		
		String pwindow=driver.getWindowHandle();
		Select quoteType=new Select(driver.findElement(quoteSetUpquoteType));
		quoteType.selectByVisibleText("New Business");
		
		driver.findElement(quoteSetUpquoteCompanyName).sendKeys("Optum");
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeDental);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeStd);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeLtd);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeEmpSupLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		element=driver.findElement(ckhBoxProductTypeDepSupLife);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(1000);
		
		driver.findElement(txtBoxstreetAddress).sendKeys("Hyderabad");
		Thread.sleep(1000);
		
		driver.findElement(txtBoxcityAddress).sendKeys("Site1");
		Thread.sleep(1000);
		
		//Select stateSel=new Select(driver.findElement(dropDownState));
		//stateSel.selectByVisibleText("CA");
		
		driver.findElement(txtBoxzipCode).sendKeys(zip);
		Thread.sleep(5000);
		
		element=driver.findElement(linkAutomatedLookup);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(15000);
		
		
		for (String handle1 : driver.getWindowHandles()) {
        	//System.out.println("Child window : :" + handle1);

        	driver.switchTo().window(handle1);
        	//System.out.println("Inside Window");
        	//break;
        	}	
		
		Thread.sleep(15000);
		String sicInputWindow="//td[@class='sectionHeading11']";
		QuotePage.verifyPageDisplay(driver,sicInputWindow, "SIC Input");
		
		Thread.sleep(3000);
		element=driver.findElement(radioBtnSIC);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
/*		element=driver.findElement(linklookupLink);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);*/
		
		
		
		driver.findElement(By.xpath("//input[@class='contentText8']")).sendKeys("9111");
		Thread.sleep(2000);
		
		By btnSicInputSubmit=By.xpath("//input[@type='submit']");
		
		
		element=driver.findElement(btnSicInputSubmit);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
		/*		element=driver.findElement(btnsubmitNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		
		element=driver.findElement(btnSUBMIT);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);*/
		
	
		//driver.switchTo().defaultContent();
		driver.switchTo().window(pwindow);
		Thread.sleep(10000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		Thread.sleep(3000);
		
		driver.findElement(totNumActiveEmployeesApplying).clear();
		driver.findElement(totNumActiveEmployeesApplying).sendKeys("11");
		Thread.sleep(1000);
		
		driver.findElement(txtBoxquoteTotalNumEmployees).sendKeys("11");
		Thread.sleep(1000);
		
		element=driver.findElement(radioBtnMedicarePriPayer);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		
		element=driver.findElement(btnquoteSetUpNext);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}
	
	public void verifyRatingMethodValue(WebDriver driver,String ratingmethodval) throws InterruptedException{
		QuotePage.verifyUeSLogos(driver);
		Thread.sleep(10000);
		String medicalPage=".//*[@id='divContent']/form/table/tbody/tr[1]/td/table/tbody/tr/td[1]";
		QuotePage.verifyPageDisplay(driver,medicalPage, "Medical Plans");
		Thread.sleep(10000);
		
		String medicalInfoTable="//td[contains(text(),'Medical Plan Information')]";
		//String medicalInformationTable=".//*[@id='divContent']/form/table/tbody/tr[12]/td/table/tbody/tr/td";
		QuotePage.verifyPageInfoTable(driver,medicalInfoTable, "Medical Plan Information");
		Thread.sleep(4000);
		
		Select medicalRatingMethodVal=new Select(driver.findElement(By.name("ratingMethodSelection")));
		//Get all options
	    List<WebElement> dd = medicalRatingMethodVal.getOptions();

	    System.out.println(dd.size());

	    for (int j = 0; j < dd.size(); j++) {
	        System.out.println(dd.get(j).getText());
	        if(dd.get(j).getText().contains(ratingmethodval)){
	        	System.out.println(ratingmethodval + " value present in Medical Plan page");
	        }
	    }
	}
	
	public void medicalPlan_btnComparePlan(WebDriver driver) throws InterruptedException{

			//QuotePage.verifyFooterLinks(driver);
			
			element=driver.findElement(chkBoxmedicalInPackageForm);
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
			By btnSubmitRateCompare=By.xpath("//input[@name='submitRateCompare']");
				
			element=driver.findElement(btnSubmitRateCompare);
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
			
			Thread.sleep(4000);
			
			//QuotePage.verifyFooterLinks(driver);
	}
	public void btnMedicalPlansubmitNext(WebDriver driver) throws InterruptedException{
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame("content");
			//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
			Thread.sleep(2000);
			element=driver.findElement(btnMedicalPlansubmitNext);
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(8000);
	}
	 public void pageOptionalMedicalRiders(WebDriver driver) throws InterruptedException{
			String optionalMedicalRidersPage= "//td[contains(text(),'Optional Medical Riders')]";
			QuotePage.verifyPageDisplay(driver,optionalMedicalRidersPage, "Optional Medical Riders");
			Thread.sleep(5000);
			
			String optionalMedicalRiderInfoTable="//td[contains(text(),'Medical Rider Information')]";
			QuotePage.verifyPageInfoTable(driver,optionalMedicalRiderInfoTable, "Medical Rider Information");
			Thread.sleep(5000);
			
			element=driver.findElement(btnOptionalMedicalPlansubmitNext);
			executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(5000);
		}
	 public void pageMedicalRateComparison(WebDriver driver,String info) throws InterruptedException{
		 String pwindow=driver.getWindowHandle();
		 
		 for (String handle1 : driver.getWindowHandles()) {
	        	//System.out.println("Child window : :" + handle1);
			
	        	driver.switchTo().window(handle1);
	        	//System.out.println("Inside Window");
	        	String pageURL=driver.getCurrentUrl();
	        	if(pageURL.contains("medicalPlanSelection")){
	        	if(info.contains("2 Tier")){	
	        	String txtemployeeClass;
	   		 	By employeeClass=By.xpath(".//*[@id='divContent']/form/table/tbody/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[2]/td");
	   		  	txtemployeeClass=driver.findElement(employeeClass).getText();
	   		  	if(txtemployeeClass.trim().contains("Under 21")){
	   		  		System.out.println("Under 21 is present in Medical Rate Comparison page");
	   		  		//driver.close();
	   		  		driver.switchTo().window(handle1).close();
	   		 	}
	        	}
	        	
	        	if(info.contains("4 Tier")){	
		        	String txtemployeeClass;
		   		 	By employeeClass=By.xpath("//td[contains(.,'Four Tier for ACR Table')]");
		   		  	txtemployeeClass=driver.findElement(employeeClass).getText();
		   		  	if(txtemployeeClass.trim().contains("Four Tier for ACR Table")){
		   		  		System.out.println("Four Tier for ACR Table is present in Medical Rate Comparison page");
		   		  		//driver.close();
		   		  		driver.switchTo().window(handle1).close();
		   		 	}
		        	}
	        	if(info.contains("Age Banded for ACR")){	
		        	String txtemployeeClass;
		   		 	By employeeClass=By.xpath("//div[@class='sectionHeading11 divHeading11']");
		   		  	txtemployeeClass=driver.findElement(employeeClass).getText();
		   		  	if(txtemployeeClass.trim().contains("Age Banded for ACR")){
		   		  		System.out.println("Age Banded for ACR Table is present in Medical Rate Comparison page");
		   		  		//driver.close();
		   		  		Thread.sleep(3000);
		   		  		driver.switchTo().window(handle1).close();
		   		 	}
		        	}
	        	
	        	
	        	      	
	        	}
		 }
		 driver.switchTo().window(pwindow);
	 }
	 public void btnSubmitGenerateProposal(WebDriver driver) throws InterruptedException, AWTException{
		 QuotePage.verifyUeSLogos(driver);
			//Proposal Information
			
			Thread.sleep(8000);
			
			String proposalInformationPage= "//td[contains(text(),'Proposal Information')]";
			QuotePage.verifyPageDisplay(driver,proposalInformationPage, "Proposal Information");
			Thread.sleep(1000);	
			
			String proposalSetupTable="//td[contains(text(),'Proposal Setup')]";
			QuotePage.verifyPageInfoTable(driver,proposalSetupTable, "Proposal Setup");
			
			QuotePage.verifyFooterLinks(driver);
					
			        element=driver.findElement(btnPreviewProposal);
					System.out.println("PDF Value :"+element.getAttribute("value"));
					//System.out.println("PDF Value :"+element.getText());
					
				if (element.getAttribute("value").trim().contains("PREVIEW PROPOSAL")){
		        		System.out.println("Proposal Preview page displayed successfully");
		        		Thread.sleep(2000);
		        		//driver.switchTo().window(handle1).close();
		        	}
				
/*				element=driver.findElement(btnPreviewProposal);
				executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				Thread.sleep(15000);*/
			 
				Thread.sleep(2000);		
		 By submitGenerateProposal=By.xpath("//input[@name='submitGenerateProposal']");
		 driver.findElement(submitGenerateProposal).sendKeys(Keys.CONTROL , Keys.SUBTRACT);

		 element=driver.findElement(submitGenerateProposal);
		/* executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", element); */
		
		 element.click();
		 Thread.sleep(5000);
 
		    // Switching to Alert        
	        Alert alert = driver.switchTo().alert();	
	        Thread.sleep(2000);
	        System.out.println("Inside Alert");		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        System.out.println(alertMessage);	
	        Thread.sleep(2000);
	        alert.accept();	
	        System.out.println("After accepting Alert");
	        Thread.sleep(15000);
	        
/*		 new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		 driver.switchTo().alert().accept();*/
/*		 
		 Robot r = new Robot();
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);*/
	        
	        Boolean popupStatus;
	    	popupStatus = utility.isAlertPresent(driver);
	    	System.out.println("ALert...statred popupStatus1 ::" + popupStatus);
	    	if (popupStatus == true) {
	    	Alert alert1 = driver.switchTo().alert();
	    	System.out.println("ALert..." + alert1.getText());
	    	alert1.dismiss();
	    	}
				
			Thread.sleep(2000);
					for (String handle1 : driver.getWindowHandles()) {
		        	//System.out.println("Child window : :" + handle1);
						Boolean popupStatus1;
				    	popupStatus1 = utility.isAlertPresent(driver);
				    	System.out.println("ALert...statred popupStatus2 ::" + popupStatus1);
				    	if (popupStatus1 == true) {
				    	Alert alert2 = driver.switchTo().alert();
				    	System.out.println("ALert..." + alert2.getText());
				    	alert2.dismiss();
				    	}
		        	driver.switchTo().window(handle1);
		        	Boolean popupStatus2;
			    	popupStatus2 = utility.isAlertPresent(driver);
			    	System.out.println("ALert...statred popupStatus3 :: " + popupStatus2);
			    	if (popupStatus1 == true) {
			    	Alert alert3 = driver.switchTo().alert();
			    	System.out.println("ALert..." + alert3.getText());
			    	alert3.dismiss();
			    	}
		        	Thread.sleep(5000);
		        	String pdfTitle=driver.switchTo().window(handle1).getTitle();
		        	String pdfTitle1=driver.switchTo().window(handle1).getCurrentUrl();
		        	System.out.println("PDF Title is ::" + pdfTitle);
		        	System.out.println("PDF Title URL is ::" + pdfTitle1);
		        	if ((pdfTitle.contains("proposalDocumentSetup")) || (pdfTitle1.contains("proposalDocumentSetup"))){
		        		System.out.println("Proposal PDF page displayed successfully");
		        		Thread.sleep(3000);
		        		driver.switchTo().window(handle1).close();
		        	}
		        	//break;
		        	}

 }
		
	public void tearDown(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
		System.out.println("Application closed/.......");
		//driver.close();
	}
}

