package com.optum.synergy.ues.ui.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductsPage {
	public static Properties autoProperties;
	public static WebDriver driver;
	public static WebDriverWait driverVar;
	public static WebElement element;
	public static JavascriptExecutor executor;
	
	By uesProducts=By.xpath(".//*[@id='M5']");
	By subLinkBenefitSummaries=By.name("SM5_1o");
	By subLinkProductGrids=By.name("SM5_2o");
	By subLinkBenefitFAQs=By.name("SM5_4o");
	By subLinkBrochures=By.name("SM5_5o");
	
	By pageSubLinkBenefitSummaries=By.xpath("//span[contains(text(),'Benefit Summaries')]");
	By pageSubLinkProductGrids=By.xpath("//span[contains(text(),'Product Grids')]");
	By pageSubLinkBenefitFAQs=By.xpath("//span[contains(text(),'Benefit FAQs')]");
	By pageSubLinkBrochures=By.xpath("//span[contains(text(),'Brochures')]");
	
	public void clickProductsTab(WebDriver driver) throws InterruptedException{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(3000);
		
		element = driver.findElement(uesProducts);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}
	
	public void verifyProductsHome(WebDriver driver, String txtNetwork) throws InterruptedException{
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(3000);
		element=driver.findElement(By.xpath("//span[contains(text(),'Products Home')]"));
		
		//System.out.println("Network Home Text::" + element.getText());
		
		if(element.getText().contains(txtNetwork)){
			System.out.println(txtNetwork + " dsiplayed successfully");
		}
		else{
			System.out.println(txtNetwork + " not dsiplayed");
		}		
	}
	
	public void verifyProductsSubtabs(WebDriver driver){
		//System.out.println("Physician Directories title ::" +driver.findElement(uesPhysicianDirectories).getAttribute("title"));
		//System.out.println("Network Fact Sheets title ::" +driver.findElement(uesNetworkFactSheets).getAttribute("title"));
		//System.out.println("Network Maps title ::" +driver.findElement(uesNetworkMaps).getAttribute("title"));
		
	
		String uesBenefitSummariesTab,uesProductGridsTab,uesBenefitFAQstab,uesLinkBrochurestab;
		uesBenefitSummariesTab=driver.findElement(subLinkBenefitSummaries).getAttribute("title");
		uesProductGridsTab=driver.findElement(subLinkProductGrids).getAttribute("title");
		uesBenefitFAQstab=driver.findElement(subLinkBenefitFAQs).getAttribute("title");
		uesLinkBrochurestab=driver.findElement(subLinkBrochures).getAttribute("title");
		
		if((uesBenefitSummariesTab.trim().contains("Benefit Summaries") && (uesProductGridsTab.trim().contains("Product Grids")
				&& (uesBenefitFAQstab.trim().contains("Benefit FAQs") && (uesLinkBrochurestab.trim().contains("Brochures")))))){
			System.out.println("Products Subtabs are " + uesBenefitSummariesTab + " , " + uesProductGridsTab + " , " + uesBenefitFAQstab + "  and " + uesLinkBrochurestab
					+ " displayed sucessfully"  );
		}
		else{
			System.out.println("Products Subtabs are not displayed");
		}
		
	}
	
	public void verifyProductsLinks(WebDriver driver) throws InterruptedException{
		//System.out.println("Physician Directories title ::" +driver.findElement(uesPhysicianDirectories).getAttribute("title"));
		//System.out.println("Network Fact Sheets title ::" +driver.findElement(uesNetworkFactSheets).getAttribute("title"));
		//System.out.println("Network Maps title ::" +driver.findElement(uesNetworkMaps).getAttribute("title"));
		
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		
		By linkU_InventNewProductIdeaSubmission=By.xpath("//a[contains(text(),'U-Invent New Product Idea Submission')]");
		By linkUnitedHealthcarePharmacyInformation=By.xpath("//a[contains(text(),'UnitedHealthcare Pharmacy Information')]");
		By linkGoldenrule=By.xpath("//a[@href='http://www.goldenrule.com/']");
		
		
		System.out.println("U-Invent New Product Idea Submission Text ::" +driver.findElement(linkU_InventNewProductIdeaSubmission).getText());
		System.out.println("UnitedHealthcare Pharmacy Information Text ::" +driver.findElement(linkUnitedHealthcarePharmacyInformation).getText());
		System.out.println("Golden Rule Text ::" +driver.findElement(linkGoldenrule).getText());
		
		
		String prod_linkU_InventNewProductIdeaSubmission,prod_linkUnitedHealthcarePharmacyInformation,prod_linkGoldenrule;
		prod_linkU_InventNewProductIdeaSubmission=driver.findElement(linkU_InventNewProductIdeaSubmission).getText();
		prod_linkUnitedHealthcarePharmacyInformation=driver.findElement(linkUnitedHealthcarePharmacyInformation).getText();
		prod_linkGoldenrule=driver.findElement(linkGoldenrule).getText();
				
		if((prod_linkU_InventNewProductIdeaSubmission.trim().contains("U-Invent New Product Idea Submission") && (prod_linkUnitedHealthcarePharmacyInformation.trim().contains("UnitedHealthcare Pharmacy Information")
				&& (prod_linkGoldenrule.trim().contains("www.goldenrule.com") )))){
			System.out.println("Products links are " + prod_linkU_InventNewProductIdeaSubmission + " , " + prod_linkUnitedHealthcarePharmacyInformation + " and " + prod_linkGoldenrule 	+ " displayed sucessfully"  );
		}
		else{
			System.out.println("Products links are not displayed");
			
		}
		
	}
	
	public void clickSubLinks_Validate(WebDriver driver) throws InterruptedException{
		ProductsPage.validateProductsSubLinks(driver, subLinkBenefitSummaries, pageSubLinkBenefitSummaries, "Benefit Summaries");
		ProductsPage.validateProductsSubLinks(driver, subLinkProductGrids, pageSubLinkProductGrids,"Product Grids");
		ProductsPage.validateProductsSubLinks(driver, subLinkBenefitFAQs, pageSubLinkBenefitFAQs,"Benefit FAQs");
		ProductsPage.validateProductsSubLinks(driver, subLinkBrochures, pageSubLinkBrochures,"Brochures");
		
	}
	
	public static void validateProductsSubLinks(WebDriver driver,By subLink,By validateSubLinkPage,String contentSubLinkPage) throws InterruptedException{
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
	
	public void accessProdSubLinkPages(WebDriver driver) throws InterruptedException{
		By linkU_InventNewProductIdeaSubmission=By.xpath("//a[contains(text(),'U-Invent New Product Idea Submission')]");
		By linkUnitedHealthcarePharmacyInformation=By.xpath("//a[contains(text(),'UnitedHealthcare Pharmacy Information')]");
		
		
		By linkU_InventNewProductIdeaSubmissionPage=By.xpath("//span[contains(text(),'U-Invent')]");
		By linkUnitedHealthcarePharmacyInformationPage=By.xpath("//div[contains(text(),'Disclaimer')]");
		
		ProductsPage.prodSubLinkPages(driver,linkU_InventNewProductIdeaSubmission,linkU_InventNewProductIdeaSubmissionPage, uesProducts, "U-Invent");
		ProductsPage.prodSubLinkPages(driver,linkUnitedHealthcarePharmacyInformation,linkUnitedHealthcarePharmacyInformationPage, uesProducts, "Disclaimer");
		//CompensationPage.compSubLinkPages(driver,linkRequestDirectDepositAuthorization2,linkRequestDirectDepositAuthorizationPage1, uesCompensationTab, "Direct Deposit Authorization");
	}
	
	public static void prodSubLinkPages(WebDriver driver,By prodSubLink,By verifyprodSubLinkPagePath,By prodTab,String verifyprodSubLinkPage) throws InterruptedException{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		
		element=driver.findElement(prodSubLink);
		
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		Thread.sleep(5000);
		element=driver.findElement(verifyprodSubLinkPagePath);
		
		if(element.getText().contains(verifyprodSubLinkPage)){
			System.out.println(verifyprodSubLinkPage + " Sub Link page displayed successfully");
		}
		else{
			System.out.println(verifyprodSubLinkPage + " not displayed");
		}
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(2000);
		element=driver.findElement(prodTab);
		System.out.println("Element Value ::"+ element.getAttribute("value"));
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);	
		Thread.sleep(3000);

	}
	
	public void prodGoldenrulePage(WebDriver driver) throws InterruptedException{
		
		
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		
		By linkGoldenrule=By.xpath("//a[@href='http://www.goldenrule.com/']");
		
		element=driver.findElement(linkGoldenrule);
		executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		Thread.sleep(5000);
		
		for (String handle1 : driver.getWindowHandles()) {
        	//System.out.println("Child window : :" + handle1);

        	driver.switchTo().window(handle1);
        	System.out.println("Title : : " +driver.getTitle());
        	if(driver.getTitle().contains("Health insurance made simple")){
        		System.out.println("Health insurance made simple | UnitedHealthOne page displayed successfully");
        		Thread.sleep(3000);
        		driver.switchTo().window(handle1).close();
    		}
/*    		else{
    			System.out.println("Health insurance made simple | UnitedHealthOne not displayed");
    		}*/
        	}
		
	}
}
