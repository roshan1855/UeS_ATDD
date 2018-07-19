package com.optum.synergy.ues.ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.optum.synergy.ues.ui.utilities.Utilities;

//import com.utilities.Utilities;

public class ManualDepositPage {
	Utilities utility;
	
	By mdmanualDepositMod=By.xpath("//a[@href='javascript:viewManualDeposit();']");
	//By mdmanualDepositMod=By.linkText("Manual Deposits"); 
	By mdproducedID=By.xpath(".//*[@id='producerId']");
	By mdcontactNumber=By.xpath(".//*[@id='contractNumber']");
	By mdpayPeriod=By.xpath("//select[@name='payPeriodId']");
	By mdreasonCode=By.xpath("//select[@name='reasonId']");
	By mdStatus=By.xpath("//select[@name='statusId']");
	By mdcompType=By.xpath("//select[@name='compTypeGroupCd']");
	By mdnewDeposit=By.xpath("//input[@onclick='ProcessNewDepositClick();' and @value='New Deposit']");
	By mdSearch=By.xpath("//input[@onclick='ProcessSearchClick();' and @value='Search']");
	By mdSearchResults=By.xpath(".//*[@id='divDataGrid']/table/tbody/tr[1]/td/img");
	By mdLogout=By.xpath("//a[@href='javascript:logoff()' and contains(text(),Logout)]");
	
	//New Doposit page
	By mdcommBusTypeDP=By.xpath("//select[@id='commBusType']");
	//By mdcommBusTypeDP=By.id("commBusType");
	By mdpayPeriodIdDP=By.name("payPeriodId");
	By mdreasonCodeDP=By.id("reasonCode");
	By mdstateCodeDP=By.name("stateCode");
	By mdcompTypeGroupCdDP=By.name("compTypeGroupCd");
	By mdsegmentIdDP=By.name("segmentId");
	By mddepositAmount=By.id("depositAmount");
	By mdcontractNumber=By.id("contractNumber");
	By mdcoverageTypeDP=By.id("coverageType");
	By mdrevenuePeriodStart=By.id("revenuePeriodStart");
	By mdglBusinessUnit=By.xpath(".//*[@id='glBusinessUnit']");
	By mdglOperatingUnit=By.xpath(".//*[@id='glOperatingUnit']");
	By mdglLocationCode=By.xpath(".//*[@id='glLocationCode']");
	By mdglAccountNumber=By.xpath(".//*[@id='glAccountNumber']");
	By mdglProductCode=By.xpath(".//*[@id='glProductCode']");
	By mdglCustomerNumber=By.xpath(".//*[@id='glCustomerNumber']");
	By mdfundingType=By.xpath(".//*[@id='fundingType']");
	By mdstmtComments=By.xpath(".//*[@id='stmtComments']");
	By mdcommentsAdditional=By.xpath(".//*[@id='commentsAdditional']");
	By mdSaveDataBtn=By.xpath(".//*[@id='SaveData']");
	By mdSearchResultsInfoTable=By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr[4]/td[6]");
	
	//GL Credit
	
	By mdglBusinessUnit2=By.xpath(".//*[@id='glBusinessUnit2']");
	By mdglOperatingUnit2=By.xpath(".//*[@id='glOperatingUnit2']");
	By mdglLocationCode2=By.xpath(".//*[@id='glLocationCode2']");
	By mdglAccountNumber2=By.xpath(".//*[@id='glAccountNumber2']");
	By mdglProductCode2=By.xpath(".//*[@id='glProductCode2']");
	By mdglCustomerNumber2=By.xpath(".//*[@id='glCustomerNumber2']");
	By mdfundingType2=By.xpath(".//*[@id='fundingType2']");
	
	By mdApproveBtn=By.xpath(".//*[@id='approveButton']");
	By mdUnApproveBtn=By.xpath(".//*[@id='unapproveButton']");
	By mdViewBtn=By.xpath("//input[@onclick='ProcessViewClick();']");
	
	public void enterProdIDandClickOnSearchBtn(WebDriver driver,String prodID) throws InterruptedException{
		Thread.sleep(4000);
		driver.findElement(mdproducedID).sendKeys(prodID);
		Thread.sleep(2000);
	}
	
	public void SelectNewlyCreatedRecordandClickOnApproveBtn(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		driver.switchTo().frame("DataGridFrame");
		Thread.sleep(2000);
		
		List<WebElement>  ele1=driver.findElements(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr"));
		int count=ele1.size();

		for(int i=4;i<=count;i++){
		WebElement ele2=driver.findElement(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr["+i+"]/td[10]"));
		System.out.println(ele2.getText());
		if(ele2.getText().contains("Newly created")){
			System.out.println("Data Present in Manual Deposit Listing Data table");
			Thread.sleep(5000);
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", driver.findElement(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr["+i+"]/td[10]/../td[1]/input")));
			break;
		}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", driver.findElement(mdApproveBtn));
		System.out.println(driver.getTitle());
	}

	
	public void verifyStatusApproved(WebDriver driver) throws InterruptedException{
			
		Thread.sleep(2000);
		driver.switchTo().frame("DataGridFrame");
		System.out.println(driver.getTitle());
		
		List<WebElement>  ele4=driver.findElements(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr"));
		int count1=ele4.size();

		for(int i=4;i<=count1;i++){
		WebElement ele2=driver.findElement(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr["+i+"]/td[10]"));
		System.out.println(ele2.getText());
		if(ele2.getText().contains("Approved")){
			System.out.println("Status got updated to Approved");
			Thread.sleep(1000);
			break;
		}
	}
		Thread.sleep(300);
		driver.switchTo().defaultContent();
}
	
	public void SelectNewlyCreatedRecordandClickOnUnApproveBtn(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		driver.switchTo().frame("DataGridFrame");
		Thread.sleep(2000);
		
		List<WebElement>  ele1=driver.findElements(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr"));
		int count=ele1.size();

		for(int i=4;i<=count;i++){
		WebElement ele2=driver.findElement(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr["+i+"]/td[10]"));
		System.out.println(ele2.getText());
		if(ele2.getText().contains("Approved")){
			System.out.println("Data Present in Manual Deposit Listing Data table");
			Thread.sleep(5000);
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", driver.findElement(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr["+i+"]/td[10]/../td[1]/input")));
			break;
		}
		}
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", driver.findElement(mdUnApproveBtn));
		System.out.println(driver.getTitle());
	}
	
	public void verifyStatusDeleted(WebDriver driver) throws InterruptedException{
		
		Thread.sleep(2000);
		driver.switchTo().frame("DataGridFrame");
		System.out.println(driver.getTitle());
		
		List<WebElement>  ele4=driver.findElements(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr"));
		int count1=ele4.size();

		for(int i=4;i<=count1;i++){
		WebElement ele2=driver.findElement(By.xpath("//form[@id='ManualDepositListingData']/table[2]/tbody/tr["+i+"]/td[10]"));
		System.out.println(ele2.getText());
		if(ele2.getText().contains("Newly created")){
			System.out.println("Status got updated to Newly created");
			Thread.sleep(1000);
			break;
		}
	}
		Thread.sleep(300);
		driver.switchTo().defaultContent();
}
	
	public void selectRecordAndClickViewBtn(WebDriver driver) throws InterruptedException{
	Thread.sleep(2000);
	driver.switchTo().frame("DataGridFrame");
	Thread.sleep(5000);
	JavascriptExecutor executor2 = (JavascriptExecutor) driver;
	executor2.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='selectedIds']")));
	Thread.sleep(5000);
	
	driver.switchTo().defaultContent();
	Thread.sleep(3000);
	
	JavascriptExecutor executor3 = (JavascriptExecutor) driver;
	//executor3.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@onclick='ProcessViewClick();']")));
	executor3.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@id='viewButton' and @name='viewButton']")));
	Thread.sleep(3000);
	}
	
	public void verifyStatusOfData(WebDriver driver) throws InterruptedException{
		
	boolean cprodid=driver.findElement(mdproducedID).isEnabled();
	boolean ccommBusTypeDP=driver.findElement(mdcommBusTypeDP).isEnabled();
	boolean cpayPeriodIdDP=driver.findElement(mdpayPeriodIdDP).isEnabled();
	boolean csegmentIdDP=driver.findElement(mdsegmentIdDP).isEnabled();
	boolean cmdcontractNumber=driver.findElement(mdcontractNumber).isEnabled();
	boolean cmdglBusinessUnit=driver.findElement(mdglBusinessUnit).isEnabled();
	boolean cmdstmtComments=driver.findElement(mdstmtComments).isEnabled();
	
	if(cprodid==false && ccommBusTypeDP==false && cpayPeriodIdDP==false && csegmentIdDP==false && cmdcontractNumber==false && cmdglBusinessUnit==false && cmdstmtComments==false ){
		System.out.println("Data disabled for selected record");			
	}
	else{
		System.out.println("Data enabled for selected record");
	}
}

	
	public void clickSaveBtn(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(mdSaveDataBtn));
		//driver.findElement(mdSaveDataBtn).click();
	}
	public void enterProdIDandReasonCode(WebDriver driver,String prodID,String reasonCode) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(mdproducedID).sendKeys(prodID);
		Thread.sleep(2000);
		Select reasonCodeDP=new Select(driver.findElement(mdreasonCodeDP));
		reasonCodeDP.selectByVisibleText(reasonCode);
		Thread.sleep(2000);
	}
	
	public void enterProdIDandSelectReasonCode(WebDriver driver,String prodID,String reasonCode) throws InterruptedException{
		Thread.sleep(5000);
		driver.findElement(mdproducedID).sendKeys(prodID);
		Thread.sleep(3000);
		Select reasonCodeDP=new Select(driver.findElement(mdreasonCode));
		reasonCodeDP.selectByVisibleText(reasonCode);
		Thread.sleep(2000);
	}
	
	public void selectAllianceStatement(WebDriver driver,String allianceStatement) throws InterruptedException{
		Thread.sleep(3000);
		Select segmentIdDP=new Select(driver.findElement(mdsegmentIdDP));
		segmentIdDP.selectByVisibleText(allianceStatement);
		Thread.sleep(2000);
	}
	
	public void enterManualDepositDetails(WebDriver driver) throws InterruptedException{
		Thread.sleep(1000);
		
		Select scommBusTypeDP=new Select(driver.findElement(mdcommBusTypeDP));
		scommBusTypeDP.selectByVisibleText("Commercial");
		Thread.sleep(1000);
		
		//Select payPeriodIdDP=new Select(driver.findElement(mdpayPeriodIdDP));
		//payPeriodIdDP.selectByVisibleText("12/05/2017");
		//Thread.sleep(1000);
		
		Select stateCodeDP=new Select(driver.findElement(mdstateCodeDP));
		stateCodeDP.selectByVisibleText("All");
		Thread.sleep(1000);
		
		Select compTypeGroupCd=new Select(driver.findElement(mdcompTypeGroupCdDP));
		compTypeGroupCd.selectByVisibleText("All");
		Thread.sleep(1000);
		
		//Select segmentIdDP=new Select(driver.findElement(mdsegmentIdDP));
		//segmentIdDP.selectByVisibleText("UHG");
		//Thread.sleep(1000);
		
		//driver.findElement(mddepositAmount).clear();
		//Thread.sleep(2000);
		//driver.findElement(mddepositAmount).sendKeys("$10.00");
		//Thread.sleep(2000);
		
		//driver.findElement(mdcontractNumber).sendKeys("9703814749");
		//Thread.sleep(2000);

		//driver.findElement(mdcontractNumber).sendKeys("9703814749");
		//Thread.sleep(2000);
		
		Select coverageTypeDP=new Select(driver.findElement(mdcoverageTypeDP));
		coverageTypeDP.selectByVisibleText("All");
		Thread.sleep(1000);
		
		//driver.findElement(mdrevenuePeriodStart).sendKeys("12/05/2017");
		//Thread.sleep(2000);
		
		driver.findElement(mdglBusinessUnit).sendKeys("43156");
		Thread.sleep(1000);
		
		driver.findElement(mdglOperatingUnit).sendKeys("09200");
		Thread.sleep(1000);
		
		driver.findElement(mdglLocationCode).sendKeys("PRIPR500");
		Thread.sleep(1000);
		
		driver.findElement(mdglProductCode).sendKeys("151000");;
		Thread.sleep(1000);
		
		driver.findElement(mdglCustomerNumber).sendKeys("0038450");
		Thread.sleep(1000);
		
		driver.findElement(mdfundingType).sendKeys("FI");
		Thread.sleep(1000);
		
		driver.findElement(mdstmtComments).sendKeys("Writeoff_Test");
		Thread.sleep(1000);
		
		driver.findElement(mdcommentsAdditional).sendKeys("Writeoff_Test");
		Thread.sleep(1000);
		
	}
	
	public void enterGLDebitDetails(WebDriver driver) throws InterruptedException{
		Thread.sleep(1000);
		
		Select scommBusTypeDP=new Select(driver.findElement(mdcommBusTypeDP));
		scommBusTypeDP.selectByVisibleText("Commercial");
		Thread.sleep(1000);
		
		//Select payPeriodIdDP=new Select(driver.findElement(mdpayPeriodIdDP));
		//payPeriodIdDP.selectByVisibleText("12/05/2017");
		//Thread.sleep(1000);
		
		Select stateCodeDP=new Select(driver.findElement(mdstateCodeDP));
		stateCodeDP.selectByVisibleText("All");
		Thread.sleep(1000);
		
		Select compTypeGroupCd=new Select(driver.findElement(mdcompTypeGroupCdDP));
		compTypeGroupCd.selectByVisibleText("All");
		Thread.sleep(1000);
		
		//Select segmentIdDP=new Select(driver.findElement(mdsegmentIdDP));
		//segmentIdDP.selectByVisibleText("UHG");
		//Thread.sleep(1000);
		
		//driver.findElement(mddepositAmount).clear();
		//Thread.sleep(2000);
		//driver.findElement(mddepositAmount).sendKeys("$10.00");
		//Thread.sleep(2000);
		
		//driver.findElement(mdcontractNumber).sendKeys("9703814749");
		//Thread.sleep(2000);

		//driver.findElement(mdcontractNumber).sendKeys("9703814749");
		//Thread.sleep(2000);
		
		Select coverageTypeDP=new Select(driver.findElement(mdcoverageTypeDP));
		coverageTypeDP.selectByVisibleText("All");
		Thread.sleep(1000);
		
		//driver.findElement(mdrevenuePeriodStart).sendKeys("12/05/2017");
		//Thread.sleep(2000);
		
		driver.findElement(mdglBusinessUnit).sendKeys("43156");
		Thread.sleep(1000);
		
		driver.findElement(mdglOperatingUnit).sendKeys("09200");
		Thread.sleep(1000);
		
		driver.findElement(mdglLocationCode).sendKeys("PRIPR500");
		Thread.sleep(1000);
		
		driver.findElement(mdglAccountNumber).sendKeys("79899");
		Thread.sleep(1000);
		
		driver.findElement(mdglProductCode).sendKeys("151000");;
		Thread.sleep(1000);
		
		driver.findElement(mdglCustomerNumber).sendKeys("0038450");
		Thread.sleep(1000);
		
		driver.findElement(mdfundingType).sendKeys("FI");
		Thread.sleep(1000);
			
	}
	
	public void enterGLCredit(WebDriver driver) throws InterruptedException{
		Thread.sleep(1000);
					
		driver.findElement(mdglBusinessUnit2).sendKeys("43156");
		Thread.sleep(1000);
		
		driver.findElement(mdglOperatingUnit2).sendKeys("09200");
		Thread.sleep(1000);
		
		driver.findElement(mdglLocationCode2).sendKeys("PRIPR500");
		Thread.sleep(1000);
		
		driver.findElement(mdglAccountNumber2).sendKeys("79900");
		Thread.sleep(1000);
		
		driver.findElement(mdglProductCode2).sendKeys("151000");;
		Thread.sleep(1000);
		
		driver.findElement(mdglCustomerNumber2).sendKeys("0038450");
		Thread.sleep(1000);
		
		driver.findElement(mdfundingType2).sendKeys("FI");
		Thread.sleep(1000);
		
		driver.findElement(mdstmtComments).sendKeys("Writeoff_Test");
		Thread.sleep(1000);
		
		driver.findElement(mdcommentsAdditional).sendKeys("Writeoff_Test");
		Thread.sleep(1000);
		
	}

	
	public void enterManualDepositDetailsforMedica(WebDriver driver) throws InterruptedException{
		Thread.sleep(1000);
		
		Select scommBusTypeDP=new Select(driver.findElement(mdcommBusTypeDP));
		scommBusTypeDP.selectByVisibleText("Commercial");
		Thread.sleep(1000);
		
		//Select payPeriodIdDP=new Select(driver.findElement(mdpayPeriodIdDP));
		//payPeriodIdDP.selectByVisibleText("12/05/2017");
		//Thread.sleep(1000);
		
		Select stateCodeDP=new Select(driver.findElement(mdstateCodeDP));
		stateCodeDP.selectByVisibleText("All");
		Thread.sleep(1000);
		
		Select compTypeGroupCd=new Select(driver.findElement(mdcompTypeGroupCdDP));
		compTypeGroupCd.selectByVisibleText("All");
		Thread.sleep(1000);
		
		//Select segmentIdDP=new Select(driver.findElement(mdsegmentIdDP));
		//segmentIdDP.selectByVisibleText("UHG");
		//Thread.sleep(1000);
		
		//driver.findElement(mddepositAmount).clear();
		//Thread.sleep(2000);
		//driver.findElement(mddepositAmount).sendKeys("$10.00");
		//Thread.sleep(2000);
		driver.findElement(mdstmtComments).sendKeys("MedicaBasicsTest");
		Thread.sleep(1000);
		
		driver.findElement(mdcommentsAdditional).sendKeys("MedicaBasicsTest");
		Thread.sleep(1000);
	}
	public void enterManualDepositDetails1(WebDriver driver) throws InterruptedException{
		Thread.sleep(1000);
		
		Select scommBusTypeDP=new Select(driver.findElement(mdcommBusTypeDP));
		scommBusTypeDP.selectByVisibleText("Commercial");
		Thread.sleep(1000);
		
		//Select payPeriodIdDP=new Select(driver.findElement(mdpayPeriodIdDP));
		//payPeriodIdDP.selectByVisibleText("12/05/2017");
		//Thread.sleep(1000);
		
		Select stateCodeDP=new Select(driver.findElement(mdstateCodeDP));
		stateCodeDP.selectByVisibleText("All");
		Thread.sleep(1000);
		
		Select compTypeGroupCd=new Select(driver.findElement(mdcompTypeGroupCdDP));
		compTypeGroupCd.selectByVisibleText("All");
		Thread.sleep(1000);
		
		Select segmentIdDP=new Select(driver.findElement(mdsegmentIdDP));
		segmentIdDP.selectByVisibleText("UHG");
		Thread.sleep(1000);
		
		//driver.findElement(mddepositAmount).clear();
		//Thread.sleep(2000);
		//driver.findElement(mddepositAmount).sendKeys("$10.00");
		//Thread.sleep(2000);
		driver.findElement(mdstmtComments).sendKeys("BasicsTest");
		Thread.sleep(1000);
		
		driver.findElement(mdcommentsAdditional).sendKeys("BasicsTest");
		Thread.sleep(1000);
	}
	
	public void enterAdvanceCheckDetails(WebDriver driver) throws InterruptedException{
		Thread.sleep(2000);
		
		Select scommBusTypeDP=new Select(driver.findElement(mdcommBusTypeDP));
		scommBusTypeDP.selectByVisibleText("Commercial");
		Thread.sleep(2000);
		
		//Select payPeriodIdDP=new Select(driver.findElement(mdpayPeriodIdDP));
		//payPeriodIdDP.selectByVisibleText("12/05/2017");
		//Thread.sleep(2000);
		
		Select stateCodeDP=new Select(driver.findElement(mdstateCodeDP));
		stateCodeDP.selectByVisibleText("All");
		Thread.sleep(2000);
		
		Select compTypeGroupCd=new Select(driver.findElement(mdcompTypeGroupCdDP));
		compTypeGroupCd.selectByVisibleText("All");
		Thread.sleep(2000);
		
		Select segmentIdDP=new Select(driver.findElement(mdsegmentIdDP));
		segmentIdDP.selectByVisibleText("UHG");
		Thread.sleep(2000);
		
		//driver.findElement(mddepositAmount).clear();
		//Thread.sleep(2000);
		//driver.findElement(mddepositAmount).sendKeys("$10.00");
		//Thread.sleep(2000);
		
		//driver.findElement(mdcontractNumber).sendKeys("9703814749");
		//Thread.sleep(2000);

		//driver.findElement(mdcontractNumber).sendKeys("9703814749");
		//Thread.sleep(2000);
		
		Select coverageTypeDP=new Select(driver.findElement(mdcoverageTypeDP));
		coverageTypeDP.selectByVisibleText("All");
		Thread.sleep(2000);
		
		//driver.findElement(mdrevenuePeriodStart).sendKeys("12/05/2017");
		//Thread.sleep(2000);
		
		driver.findElement(mdglBusinessUnit).sendKeys("43156");
		Thread.sleep(2000);
		
		driver.findElement(mdglOperatingUnit).sendKeys("09200");
		Thread.sleep(2000);
		
		driver.findElement(mdglLocationCode).sendKeys("PRIPR500");
		Thread.sleep(2000);
		
		driver.findElement(mdglProductCode).sendKeys("151000");;
		Thread.sleep(2000);
		
		driver.findElement(mdglCustomerNumber).sendKeys("0038450");
		Thread.sleep(2000);
		
		driver.findElement(mdfundingType).sendKeys("FI");
		Thread.sleep(2000);
		
		driver.findElement(mdstmtComments).sendKeys("Test");
		Thread.sleep(2000);
		
		driver.findElement(mdcommentsAdditional).sendKeys("Test");
		Thread.sleep(2000);
		
	}
	
	
	public void clickManualDepositMod(WebDriver driver) throws InterruptedException {
		//utility.fluentWait(mdmanualDepositMod, driver);
		Thread.sleep(8000);
		System.out.println("Manual Deposit Module/...");
		//driver.findElement(mdmanualDepositMod).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(mdmanualDepositMod));
	}
	
	public void clickNewDepositBtn(WebDriver driver) throws InterruptedException {
		//utility.fluentWait(mdnewDeposit, driver);
		System.out.println("click New Deposit Button/...");
		//driver.findElement(mdnewDeposit).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(mdnewDeposit));
	}
	
	public void searchDetails(WebDriver driver,String prodId) throws InterruptedException{
		Thread.sleep(2000);
		driver.findElement(mdproducedID).sendKeys(prodId);
		Thread.sleep(1000);
		//Select payeePeriod=new Select(driver.findElement(mdpayPeriod));
		//payeePeriod.selectByVisibleText("11/28/2016");
		
	}
	public void clickSearchBtn(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("click Search Button/...");
		//driver.findElement(mdnewDeposit).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(mdSearch));
	}
	public void searchResults(WebDriver driver,String reasonCode) throws InterruptedException{
		
		Thread.sleep(2000);
		driver.switchTo().frame("DataGridFrame");
		Thread.sleep(3000);
		WebElement ele1=driver.findElement(mdSearchResultsInfoTable);
		if(ele1.isDisplayed()==true){
		//System.out.println(ele1.getText());
		//Thread.sleep(1000);
		//if(ele1.getText().contains(reasonCode)){
			System.out.println(reasonCode + " Reason Code Manual Deposit added sucessfully");
		}
		else{
			System.out.println(reasonCode + " Reason Code Manual Deposit not added");
		}
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		//System.out.println(driver.getTitle());
	}
	
	public void tearDown(WebDriver driver) throws InterruptedException{
		Thread.sleep(3000);
		driver.findElement(mdLogout).click();
		System.out.println("Clicked logout button/.........");
		Thread.sleep(3000);
		//driver.close();
		driver.quit();
		System.out.println("Application closed/.......");
	}
	
	public void searchResults(WebDriver driver,String reasonCode,String allianceStatement) throws InterruptedException{
		
		Thread.sleep(3000);
		driver.switchTo().frame("DataGridFrame");
		Thread.sleep(4000);
		WebElement ele1=driver.findElement(mdSearchResultsInfoTable);
		if(ele1.isDisplayed()==true){
		//System.out.println(ele1.getText());
		//Thread.sleep(1000);
		//if(ele1.getText().contains(reasonCode)){
			System.out.println(reasonCode + " Reason Code " + " for " + allianceStatement +" Alliance Statemnet manual deposit added");
		}
		else{
			System.out.println(reasonCode + " Reason Code " + " for " + allianceStatement +" Alliance statemnet manual deposit not added");
		}
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		//System.out.println(driver.getTitle());
	}
	
	
}
