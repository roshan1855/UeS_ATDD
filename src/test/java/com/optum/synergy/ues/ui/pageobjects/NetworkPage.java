package com.optum.synergy.ues.ui.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NetworkPage {
	public static Properties autoProperties;
	public static WebDriver driver;
	public static WebDriverWait driverVar;
	public static WebElement element;
	public static JavascriptExecutor executor;
	
	By uesNetwork=By.xpath(".//*[@id='M4']");
	By uesPhysicianDirectories=By.name("SM4_2o");
	By uesNetworkFactSheets=By.name("SM4_3o");
	By uesNetworkMaps=By.name("SM4_4o");
	
	By subLinkPhysicianDirectories=By.xpath(".//*[@id='SM4_2o']");
	By sublinkNetworkFactSheets=By.xpath(".//*[@id='SM4_3o']");
	By subLinkNetworkMaps=By.xpath(".//*[@id='SM4_4o']");
	
	By pageSubLinkPhysicianDirectories=By.xpath("//span[contains(text(),'Physician Directories')]");
	By pageSubLinkNetworkFactSheets=By.xpath("//span[contains(text(),'Network Fact Sheets')]");
	By pageSubLinkNetworkMaps=By.xpath("//td[contains(text(),'Network Maps')]");
	
	
	public void clickNetworkTab(WebDriver driver) throws InterruptedException{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(3000);
		
		element = driver.findElement(uesNetwork);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}
	
	public void verifyNetworkSubtabs(WebDriver driver){
		//System.out.println("Physician Directories title ::" +driver.findElement(uesPhysicianDirectories).getAttribute("title"));
		//System.out.println("Network Fact Sheets title ::" +driver.findElement(uesNetworkFactSheets).getAttribute("title"));
		//System.out.println("Network Maps title ::" +driver.findElement(uesNetworkMaps).getAttribute("title"));
		
		String uesPhysicianDirectoriesTab,uesNetworkFactSheetsTab,uesNetworkMapstab;
		uesPhysicianDirectoriesTab=driver.findElement(uesPhysicianDirectories).getAttribute("title");
		uesNetworkFactSheetsTab=driver.findElement(uesNetworkFactSheets).getAttribute("title");
		uesNetworkMapstab=driver.findElement(uesNetworkMaps).getAttribute("title");
		
		if((uesPhysicianDirectoriesTab.trim().contains("Physician Directories") && (uesNetworkFactSheetsTab.trim().contains("Network Fact Sheets")
				&& (uesNetworkMapstab.trim().contains("Network Maps"))))){
			System.out.println("Network Subtabs are " + uesPhysicianDirectoriesTab + " , " + uesNetworkFactSheetsTab + " and " + uesNetworkMapstab + " "
					+ "displayed sucessfully"  );
		}
		else{
			System.out.println("Network Subtabs are not displayed");
		}
		
	}
	
	public void verifyNetWorkHome(WebDriver driver, String txtNetwork) throws InterruptedException{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(3000);
		element=driver.findElement(By.xpath("//span[contains(text(),'Network Home')]"));
		
		//System.out.println("Network Home Text::" + element.getText());
		
		if(element.getText().contains(txtNetwork)){
			System.out.println(txtNetwork + " dsiplayed successfully");
		}
		else{
			System.out.println(txtNetwork + " not dsiplayed");
		}		
	}
	
	public void verifySiteCopyMesage(WebDriver driver){
		element=driver.findElement(By.xpath(".//*[@id='divContent']/table/tbody/tr[1]/td"));
		//System.out.println("Site copy information :: " + element.getText());
		
		if(element.getText().contains("Review, download and print information")){
			System.out.println("Site copy information dsiplayed successfully");
		}
		else{
			System.out.println("Site copy information not dsiplayed");
		}	
	}
	
	public void verifyLinks(WebDriver driver){
		String linkNetworkFactSheets,linkNetworkMaps,linkPhysicianDirectories;
		linkNetworkFactSheets=driver.findElement(By.linkText("Network Fact Sheets")).getText();
		linkNetworkMaps=driver.findElement(By.linkText("Network Maps")).getText();
		linkPhysicianDirectories=driver.findElement(By.linkText("Physician Directories")).getText();
		
		if((linkNetworkFactSheets.trim().contains("Network Fact Sheets") && (linkNetworkMaps.trim().contains("Network Maps") && (linkPhysicianDirectories.trim().contains("Physician Directories"))))){
			System.out.println("Links are displayed successfully in NetWork Home page");
		}
		else{
			System.out.println("Links not displayed in NetWork Home page");
		}
	}
	
	public void verifyNetwork_SubLinks(WebDriver driver){
		String sublinkNetworkFactSheetsTxt,sublinkNetworkMapsTxt,sublinkPhysicianDirectoriesTxt;
		
		sublinkPhysicianDirectoriesTxt=driver.findElement(subLinkPhysicianDirectories).getText();
		sublinkNetworkFactSheetsTxt=driver.findElement(sublinkNetworkFactSheets).getText();
		sublinkNetworkMapsTxt=driver.findElement(subLinkNetworkMaps).getText();
		
		if((sublinkNetworkFactSheetsTxt.trim().contains("Network Fact Sheets") && (sublinkNetworkMapsTxt.trim().contains("Network Maps") && (sublinkPhysicianDirectoriesTxt.trim().contains("Physician Directories"))))){
			System.out.println("Sub Links are displayed successfully under NetWork tab");
		}
		else{
			System.out.println("Sub Links not displayed under NetWork tab");
		}
		
	}
	
	public void clickSubLinks_Validate(WebDriver driver) throws InterruptedException{
		NetworkPage.validateNetworkSubLinks(driver, subLinkPhysicianDirectories, pageSubLinkPhysicianDirectories, "Physician Directories");
		NetworkPage.validateNetworkSubLinks(driver, sublinkNetworkFactSheets, pageSubLinkNetworkFactSheets,"Network Fact Sheets");
		NetworkPage.validateNetworkSubLinks(driver, subLinkNetworkMaps, pageSubLinkNetworkMaps,"Network Maps");
		
	}
	
	public static void validateNetworkSubLinks(WebDriver driver,By subLink,By validateSubLinkPage,String contentSubLinkPage) throws InterruptedException{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("navbar");
		Thread.sleep(2000);
		
		element=driver.findElement(subLink);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.switchTo().frame("content");
		Thread.sleep(2000);
		
		element = driver.findElement(validateSubLinkPage);
		if(element.getText().contains(contentSubLinkPage)){
			System.out.println(contentSubLinkPage + " SubLink page displayed successfully");
		}
		else{
			System.out.println(contentSubLinkPage + " SubLink page not displayed");
		}
		
	}
	
}
