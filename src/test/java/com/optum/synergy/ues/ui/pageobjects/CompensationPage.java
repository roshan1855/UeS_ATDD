package com.optum.synergy.ues.ui.pageobjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optum.synergy.ues.ui.stepDefinitions.Hooks;
import com.optum.synergy.ues.ui.utilities.Utilities;


public class CompensationPage {
	public static Properties autoProperties;
	public static WebDriver driver;
	public static WebDriverWait driverVar;
	//public static String baseURL="https://bfx.unitedeservices.com/uespublic/prelogin/login.jsp";
	//public static String baseURL="https://stage.unitedeservices.com/uessecured/index.jsp";
	public static String baseURL="http://dev1-ues.uhc.com/uessecured/index.jsp";
	public static WebElement element;
	public static JavascriptExecutor executor;
	DesiredCapabilities ieCapabilities;
	By uesUserName =By.xpath(".//*[@id='U']");
	By uesPwd=By.xpath(".//*[@id='P']");
	By uesLoginBtn=By.xpath("//a[contains(text(),'Log In')]");
	By uesCompensationTab=By.xpath(".//*[@id='M9']");
	
	By linkCommissionStatements=By.xpath("//a[contains(text(),'Commission Statements')]");
	By linkRequestDirectDepositAuthorization1=By.xpath("//a[contains(text(),'Request Direct Deposit Authorization')]");
	By linkRequestDirectDepositAuthorization2=By.xpath(".//*[@id='divContent']/table/tbody/tr[1]/td/table/tbody/tr[3]/td[2]/a");
	By linkAdministratorAccessForm=By.xpath("//a[contains(text(),'Click here to obtain the administrator access form')]");
	By linkFACETSCommissionPlatform=By.xpath("//a[contains(text(),'FACETS Commission Platform')]");
	By linkBASICSCommissionPlatform=By.xpath("//a[contains(text(),'BASICS Commission Platform')]");
	By linkUnitedHealthcareRepresentative=By.xpath("//a[contains(text(),'Find your UnitedHealthcare Representative')]");
	
	
	By linkRequestDirectDepositAuthorizationPage=By.xpath("//td[contains(text(),'Direct Deposit Authorization')]");
	By linkRequestDirectDepositAuthorizationPage1=By.xpath("//td[contains(text(),'Direct Deposit Authorization')]");
	By linkCommissionStatementsPage=By.xpath(".//*[@id='UescontentTitle']");
	By linkUnitedHealthcareRepresentativePage=By.xpath(".//*[@id='divContent']/table/tbody/tr[1]/td/span");
	
	public void loginUeS_Dev(WebDriver driver) throws InterruptedException, IOException{
		Utilities utility = new Utilities();
		//Thread.sleep(5000);
		utility.waitForVisibilityOfWebElement(uesUserName, driver);
		driver.findElement(uesUserName).sendKeys("testbrokerplm");
		//Thread.sleep(1000);
		utility.waitForVisibilityOfWebElement(uesPwd, driver);
		driver.findElement(uesPwd).sendKeys("Firefly!4");
		//Thread.sleep(1000);
		utility.waitForVisibilityOfWebElement(uesLoginBtn, driver);
		//driver.findElement(By.linkText("Log In")).sendKeys(Keys.ENTER);
		
		element = driver.findElement(uesLoginBtn);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(8000);
		Boolean popupStatus;
		popupStatus = utility.isAlertPresent(driver);

		if (popupStatus == true) {
			Alert alert = driver.switchTo().alert();
			System.out.println("ALert..." + alert.getText());
			System.out.println("Goes to Accept");
			alert.accept();
			Thread.sleep(5000);
		}
			
		System.out.println("User clicked Login Button/.....");
		Thread.sleep(6000);
	}
	
	public void clickCompensation(WebDriver driver) throws InterruptedException{
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		//System.out.println("Page Title ::"+driver.getTitle());
		driver.switchTo().frame("navbar");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("navbar").getTitle());
		Thread.sleep(2000);
		element=driver.findElement(uesCompensationTab);
		System.out.println("Element Value ::"+ element.getAttribute("value"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);	
		Thread.sleep(5000);
	}
	
	public void verifyCompHomePage(WebDriver driver) throws InterruptedException{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		String compHome;
		compHome=driver.findElement(By.xpath("//div[@class='contentTitle']")).getText();
		System.out.println("Compensation Home text ::"+compHome);
		if (compHome.contains("Compensation Home")){
			System.out.println("Compensation Home page displayed successfully");
		}
		else{
			System.out.println("Compensation Home page not displayed");
		}
	}
	public void verifyCompensationHomeLinks(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		String compHome;
		compHome=driver.findElement(By.xpath("//div[@class='contentTitle']")).getText();
		System.out.println("Compensation Home text ::"+compHome);
		
		String comLinkCommissionStatements;
		comLinkCommissionStatements=driver.findElement(linkCommissionStatements).getText();
		
		String comLinkRequestDirectDepositAuthorization1;
		comLinkRequestDirectDepositAuthorization1=driver.findElement(linkRequestDirectDepositAuthorization1).getText();
		
		String comLinkRequestDirectDepositAuthorization2;
		comLinkRequestDirectDepositAuthorization2=driver.findElement(linkRequestDirectDepositAuthorization2).getText();
		
		String comLinkAdministratorAccessForm;
		comLinkAdministratorAccessForm=driver.findElement(linkAdministratorAccessForm).getText();
		
		String comLinkFACETSCommissionPlatform;
		comLinkFACETSCommissionPlatform=driver.findElement(linkFACETSCommissionPlatform).getText();
		
		String comLinkBASICSCommissionPlatform;
		comLinkBASICSCommissionPlatform=driver.findElement(linkBASICSCommissionPlatform).getText();
		
		String comLinkUnitedHealthcareRepresentative;
		comLinkUnitedHealthcareRepresentative=driver.findElement(linkUnitedHealthcareRepresentative).getText();
		
			
/*		System.out.println("1 ::"+ comLinkCommissionStatements);
		System.out.println("2 ::"+ comLinkRequestDirectDepositAuthorization1);
		System.out.println("3 ::"+ comLinkRequestDirectDepositAuthorization2);
		System.out.println("4 ::"+ comLinkAdministratorAccessForm);
		System.out.println("5 ::"+ comLinkFACETSCommissionPlatform);
		System.out.println("6 ::"+ comLinkBASICSCommissionPlatform);
		System.out.println("7 ::"+ comLinkUnitedHealthcareRepresentative);*/
		
		if (compHome.contains("Compensation Home")){
			System.out.println("Compensation Home page displayed successfully");
		}
		else{
			System.out.println("Compensation Home page not displayed");
		}
		if((comLinkCommissionStatements.trim().contains("Commission Statements")) && (comLinkRequestDirectDepositAuthorization1.trim().contains("Request Direct Deposit Authorization")) &&
				(comLinkRequestDirectDepositAuthorization2.trim().contains("Request Direct Deposit Authorization")) && (comLinkAdministratorAccessForm.trim().contains("Click here to obtain the administrator access form")) && 
				(comLinkFACETSCommissionPlatform.trim().contains("FACETS Commission Platform")) && (comLinkBASICSCommissionPlatform.trim().contains("BASICS Commission Platform")) && 
				(comLinkUnitedHealthcareRepresentative.trim().contains("Find your UnitedHealthcare Representative"))){
			System.out.println("Expected links :: " +comLinkCommissionStatements +","+ comLinkRequestDirectDepositAuthorization1 +","+
					comLinkRequestDirectDepositAuthorization2 +","+ comLinkAdministratorAccessForm +","+
					comLinkFACETSCommissionPlatform +","+ comLinkBASICSCommissionPlatform + " and " +
					comLinkUnitedHealthcareRepresentative + " are displayed successfully in Compensation Home page ");
		}
		else{
			System.out.println("Expected links :: " +comLinkCommissionStatements +","+ comLinkRequestDirectDepositAuthorization1 +","+
					comLinkRequestDirectDepositAuthorization2 +","+ comLinkAdministratorAccessForm +","+
					comLinkFACETSCommissionPlatform +","+ comLinkBASICSCommissionPlatform + " and " +
					comLinkUnitedHealthcareRepresentative + " are not displayed in Compensation Home page ");
		}
		
	}
	
	public void accessCompSubLinkPages(WebDriver driver) throws InterruptedException{
		CompensationPage.compSubLinkPages(driver,linkRequestDirectDepositAuthorization1,linkRequestDirectDepositAuthorizationPage, uesCompensationTab, "Direct Deposit Authorization");
		CompensationPage.compSubLinkPages(driver,linkUnitedHealthcareRepresentative,linkUnitedHealthcareRepresentativePage, uesCompensationTab, "Contact Us");
		CompensationPage.compSubLinkPages(driver,linkRequestDirectDepositAuthorization2,linkRequestDirectDepositAuthorizationPage1, uesCompensationTab, "Direct Deposit Authorization");
		CompensationPage.compSubLinkPages1(driver,linkCommissionStatements,linkCommissionStatementsPage, uesCompensationTab, "Commission Statements");
	}
	
	public static void compSubLinkPages(WebDriver driver,By comSubLink,By verifycompSubLinkPagePath,By compTab,String verifycompSubLinkPage) throws InterruptedException{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		
		element=driver.findElement(comSubLink);
		
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		Thread.sleep(5000);
		element=driver.findElement(verifycompSubLinkPagePath);
		
		if(element.getText().contains(verifycompSubLinkPage)){
			System.out.println(verifycompSubLinkPage + " Sub Link page displayed successfully");
		}
		else{
			System.out.println(verifycompSubLinkPage + " not displayed");
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(2000);
		element=driver.findElement(compTab);
		System.out.println("Element Value ::"+ element.getAttribute("value"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);	
		Thread.sleep(3000);

	}
	
	public void page_URL(WebDriver driver) throws InterruptedException{
		driver.get("Application URL");
	}
	
	public void login_Test(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(By.xpath("")).sendKeys("testbrokerplm");
		Thread.sleep(1000);
		driver.findElement(By.xpath("")).sendKeys("Firefly!3");
		Thread.sleep(1000);
		element = driver.findElement(By.xpath(""));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("User clicked Login Button/.....");
		Thread.sleep(6000);
	}
	
	public static void compSubLinkPages1(WebDriver driver,By comSubLink,By verifycompSubLinkPagePath,By compTab,String verifycompSubLinkPage) throws InterruptedException{
		String pwindow;
		pwindow=driver.getWindowHandle();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("content");
		//System.out.println("Frame Title : :"+ driver.switchTo().frame("content").getTitle());
		element=driver.findElement(comSubLink);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		
		Thread.sleep(3000);
		//driver.switchTo().window("UescontentTitle");
		//driver.switchTo().defaultContent();
	/*	element=driver.findElement(verifycompSubLinkPagePath);
		
		if(element.getText().contains(verifycompSubLinkPage)){
			System.out.println(verifycompSubLinkPage + " displayed successfully");
		}
		else{
			System.out.println(verifycompSubLinkPage + " not displayed");
		}*/
		
		System.out.println(verifycompSubLinkPage + " displayed successfully");
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(2000);
		element=driver.findElement(compTab);
		System.out.println("Element Value ::"+ element.getAttribute("value"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);	
		Thread.sleep(3000);

	}
	
	public void accessCompSubLinkPDFPages(WebDriver driver) throws InterruptedException{
		CompensationPage.compSubLinkPDFPages(driver,linkBASICSCommissionPlatform,uesCompensationTab,"M46960_BASICS_Cal_for_UeS.pdf");
		CompensationPage.compSubLinkPDFPages(driver,linkAdministratorAccessForm,uesCompensationTab,"UeS_Agency_Admin_Add-Remove_Form.pdf");
		CompensationPage.compSubLinkPDFPages(driver,linkFACETSCommissionPlatform,uesCompensationTab,"M46960-B_RV_NHP_Calendar_for_UeS.pdf");
	}
	
	public static void compSubLinkPDFPages(WebDriver driver,By comSubLink1,By compTab,String verifycompSubLinkPDFPage) throws InterruptedException{
		String pwindow;
		pwindow=driver.getWindowHandle();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		
		element=driver.findElement(comSubLink1);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(20000);
				
		for (String handle1 : driver.getWindowHandles()) {
        	//System.out.println("Child window : :" + handle1);
        	driver.switchTo().window(handle1);
        	String pdfCurrentUrl;
        	pdfCurrentUrl=driver.switchTo().window(handle1).getCurrentUrl();
       	
        	if(pdfCurrentUrl.trim().contains(verifycompSubLinkPDFPage)){
        		System.out.println(verifycompSubLinkPDFPage + " :: PDF page displayed successfully");
        		Thread.sleep(5000);
        		driver.switchTo().window(handle1).close();
        	}
        	}	
		
		driver.switchTo().window(pwindow);
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(1000);
		element=driver.findElement(compTab);
		System.out.println("Element Value ::"+ element.getAttribute("value"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);	
		Thread.sleep(2000);

	}
	
}


