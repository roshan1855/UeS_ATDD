package com.optum.synergy.ues.ui.pageobjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optum.synergy.ues.ui.utilities.Utilities;

public class MyAccountPage {
	public static Properties autoProperties;
	public static WebDriver driver;
	public static WebDriverWait driverVar;

	public static Utilities utility;
	public static WebElement element;
	public static JavascriptExecutor executor;
	DesiredCapabilities ieCapabilities;
	By linkChangePassword = By.linkText("Change Password");
	By linkChangeSecretQuestions = By.linkText("Change Secret Questions");
	By linkUpdateUnitedAdvantageComInformation = By.linkText("Update UnitedAdvantage.com Information");
	By linkViewEditContactInformation = By.linkText("View/Edit Contact Information");

	By linkQuoteSetup = By.linkText("Quote Setup");
	By linkQuoteGenerationOptions = By.linkText("Quote Generation Options");
	By linkCustomLogoSelection = By.linkText("Custom Logo Selection");
	By linkDefineSalesMaterialandBenefitSearches = By.linkText("Define Sales Material and Benefit Searches");

	By pageChangePassword = By.xpath("//td[contains(text(),'Change Password')]");
	By pageChangeSecretQuestions = By.xpath("//span[contains(text(),'Secret Question and Answer')]");
	By pageUpdateUnitedAdvantageComInformation = By
			.xpath("//td[contains(text(),'United Advantage Logon Information')]");
	By pageViewEditContactInformation = By.xpath("//td[contains(text(),'View/Edit Contact Information')]");

	By pageQuoteSetup = By.xpath("//td[contains(text(),'Quote Setup Information')]");
	By pageQuoteGenerationOptions = By.xpath("//td[contains(text(),'Quote Generation Options')]");
	By pageCustomLogoSelection = By.xpath("//td[contains(text(),'Custom Logo Selection')]");
	By pageDefineSalesMaterialandBenefitSearches = By.xpath("//td[contains(text(),'Sales Material Search Options')]");

	public MyAccountPage() throws IOException {
		utility = new Utilities();
	}

	public void verifyMyAccount(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(2000);

		String uesMyAccountLink;
		uesMyAccountLink = driver.findElement(By.linkText("My Account")).getText();
		System.out.println("UeS My Account Text ::" + uesMyAccountLink);

		if (uesMyAccountLink.contains("My Account")) {
			System.out.println("My Account link  :: " + uesMyAccountLink + " displayed successfully");
			Thread.sleep(1000);

			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("My Account")));
			Thread.sleep(3000);

		} else {
			System.out.println("My Account link :: " + uesMyAccountLink + " not displayed");
		}
	}

	public static void verifyLink_MyAccountPage(WebDriver driver, By path, String name, String elementType)
			throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);

		String nameLink = driver.findElement(path).getText();
		// System.out.println("Heading Name :: " + nameHeading);

		if (nameLink.contains(name)) {
			System.out.println(nameLink + " :: " + elementType + " present on My Account Page");
		} else {
			System.out.println(nameLink + "  ::" + elementType + " not present on My Account Page");
			// Assert.assertEquals(nameHeading, name);
		}
	}

	public static void verifyLinkPage(WebDriver driver, By linkPath, String name, By linkPagePath)
			throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);

		element = driver.findElement(linkPath);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		
		Thread.sleep(4000);
		//utility.waitForVisibilityOfWebElement(linkPagePath, driver);
		String nameLinkPage = driver.findElement(linkPagePath).getText();
		//System.out.println("Link Page Text :: " + nameLinkPage);

		if (nameLinkPage.trim().contains(name)) {
			System.out.println(nameLinkPage + " :: " + " Page displayed successfully");

			By submitBack=By.xpath("//input[@name='submitBack']");
			utility.waitForVisibilityOfWebElement(submitBack, driver);
			element = driver.findElement(submitBack);
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",element);
			Thread.sleep(2000);
		} else {
			System.out.println(nameLinkPage + "  ::" + " Page not displayed");
			// Assert.assertEquals(nameHeading, name);
			By submitBack=By.xpath("//input[@name='submitBack']");
			utility.waitForVisibilityOfWebElement(submitBack, driver);
			element = driver.findElement(submitBack);
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",element);
			Thread.sleep(3000);
		}
	}

	public void verifyLinkPages(WebDriver driver) throws InterruptedException {
		MyAccountPage.verifyLinkPage(driver, linkChangePassword, "Change Password", pageChangePassword);
		MyAccountPage.verifyLinkPage(driver, linkChangeSecretQuestions, "Secret Question and Answer",
				pageChangeSecretQuestions);
		MyAccountPage.verifyLinkPage(driver, linkUpdateUnitedAdvantageComInformation,
				"United Advantage Logon Information", pageUpdateUnitedAdvantageComInformation);
		MyAccountPage.verifyLinkPage(driver, linkViewEditContactInformation, "View/Edit Contact Information",
				pageViewEditContactInformation);

		MyAccountPage.verifyLinkPage(driver, linkQuoteSetup, "Quote Setup Information", pageQuoteSetup);
		MyAccountPage.verifyLinkPage(driver, linkQuoteGenerationOptions, "Quote Generation Options",
				pageQuoteGenerationOptions);
		MyAccountPage.verifyLinkPage(driver, linkCustomLogoSelection, "Custom Logo Selection", pageCustomLogoSelection);
		MyAccountPage.verifyLinkPage(driver, linkDefineSalesMaterialandBenefitSearches, "Sales Material Search Options",
				pageDefineSalesMaterialandBenefitSearches);
	}

	public void verifyMyAccountPage_Links_Admin(WebDriver driver) throws InterruptedException {
		MyAccountPage.verifyLink_MyAccountPage(driver, linkChangePassword, "Change Password", "link");
		MyAccountPage.verifyLink_MyAccountPage(driver, linkChangeSecretQuestions, "Change Secret Questions", "link");
		MyAccountPage.verifyLink_MyAccountPage(driver, linkUpdateUnitedAdvantageComInformation,
				"Update UnitedAdvantage.com Information", "link");
		MyAccountPage.verifyLink_MyAccountPage(driver, linkViewEditContactInformation, "View/Edit Contact Information",
				"link");

		MyAccountPage.verifyLink_MyAccountPage(driver, linkQuoteSetup, "Quote Setup", "link");
		MyAccountPage.verifyLink_MyAccountPage(driver, linkQuoteGenerationOptions, "Quote Generation Options", "link");
		MyAccountPage.verifyLink_MyAccountPage(driver, linkCustomLogoSelection, "Custom Logo Selection", "link");
		MyAccountPage.verifyLink_MyAccountPage(driver, linkDefineSalesMaterialandBenefitSearches,
				"Define Sales Material and Benefit Searches", "link");
	}

	public void verifyLinkPages_Broker(WebDriver driver) throws InterruptedException {

		By pageViewEditRenewalPackageMailingPreference = By
				.xpath("//span[contains(text(),'View / Edit Renewal Package Mailing Preference')]");
		By linkViewEditRenewalPackageMailingPreference = By.linkText("View / Edit Renewal Package Mailing Preference");

		By pageUpdateEmployereServicesInformation = By
				.xpath("//span[contains(text(),'Update Employer eServices Information')]");
		By linkUpdateEmployereServicesInformation = By.linkText("Update Employer eServices Information");

		By pageManageMyDelegates = By.xpath("//td[contains(text(),'My Delegates')]");
		By linkManageMyDelegates = By.linkText("Manage My Delegates"); // navigating
																		// SiteAdministration
		By pageViewLicenseAppointments = By.xpath("//td[contains(text(),'Company Appointments')]");
		By linkViewLicenseAppointments = By.linkText("View License & Appointments");
		
		By pageChangeRenewalAlertsStatus = By.xpath("//td[contains(text(),'Change Renewal Alerts Status')]");
		By linkChangeRenewalAlertsStatus = By.linkText("Change Renewal Alerts Status");
		
		By pageChangeCommissionAlertsStatus = By.xpath("//td[contains(text(),'Change Commission Alerts Status')]");
		By linkChangeCommissionAlertsStatus = By.linkText("Change Commission Alerts Status");
		
		By pageChangeLatePremiumandCancelCaseAlertsStatus = By.xpath("//td[contains(text(),'Change Late Premium and Cancel Case Alerts Status')]");
		By linkChangeLatePremiumandCancelCaseAlertsStatus = By.linkText("Change Late Premium and Cancel Case Alerts Status");
		
		
		MyAccountPage.verifyLinkPage(driver, linkViewEditRenewalPackageMailingPreference,
				"View / Edit Renewal Package Mailing Preference", pageViewEditRenewalPackageMailingPreference);

		MyAccountPage.verifyLinkPage(driver, linkUpdateEmployereServicesInformation,
				"Update Employer eServices Information", pageUpdateEmployereServicesInformation);

		MyAccountPage.verifyLinkPage(driver, linkManageMyDelegates, "My Delegates", pageManageMyDelegates);

		MyAccountPage.verifyLinkPage(driver, linkViewLicenseAppointments, "Company Appointments",
				pageViewLicenseAppointments);
		
		MyAccountPage.verifyLinkPage(driver, linkChangeRenewalAlertsStatus, "Change Renewal Alerts Status",
				pageChangeRenewalAlertsStatus);
		
		MyAccountPage.verifyLinkPage(driver, linkChangeCommissionAlertsStatus, "Change Commission Alerts Status",
				pageChangeCommissionAlertsStatus);
		
		MyAccountPage.verifyLinkPage(driver, linkChangeLatePremiumandCancelCaseAlertsStatus, "Change Late Premium and Cancel Case Alerts Status",
				pageChangeLatePremiumandCancelCaseAlertsStatus);
	}

}
