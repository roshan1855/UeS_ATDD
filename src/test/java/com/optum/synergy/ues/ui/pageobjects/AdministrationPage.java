package com.optum.synergy.ues.ui.pageobjects;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.optum.synergy.ues.ui.utilities.Utilities;

public class AdministrationPage {
	public static Properties autoProperties;
	public static WebDriver driver;
	public static WebDriverWait driverVar;
	public static WebElement element;
	public static JavascriptExecutor executor;
	public static Utilities utility;

	By linkCreate_and_Register_a_New_User = By.linkText("Create and Register a New User");
	By linkManage_Existing_Users = By.linkText("Manage Existing Users");
	By linkManage_B2B_Account = By.linkText("Manage B2B Account");
	By linkManage_Organization = By.linkText("Manage Organization");
	By linkManage_Organization_Users = By.linkText("Manage Organization Users");
	By linkManage_Broker_Delegates = By.linkText("Manage Broker Delegates");
	By linkManage_United_Advantage_Report_Access = By.linkText("Manage United Advantage Report Access");
	By linkManage_Quote_and_Renewal_News_and_Alerts_and_Notations = By
			.linkText("Manage Quote and Renewal News, Alerts and Notations");
	By linkClear_Cache = By.linkText("Clear Cache");
	By linkModify_Logging_Levels = By.linkText("Modify Logging Levels");
	By linkView_Renewal_Package_Mailing_Preference_and_History = By
			.linkText("View Renewal Package Mailing Preference and History");
	By linkAdministration = By.xpath("//*[contains(text(),'Administration')]");
	By siteAdministration = By.xpath("//div[contains(text(),'Site Administration')]");

	By pageCreate_and_Register_a_New_User = By.xpath("//td[contains(text(),'Create and Register a New User')]");
	By pageManage_Existing_Users = By.xpath("//td[contains(text(),'User Search - Manage Existing Users')]");
	By pageManage_B2B_Account = By.xpath("//td[contains(text(),'B2B Partner System Accounts')]");
	By pageManage_Organization = By.xpath("//td[contains(text(),'Manage Organization')]");
	By pageManage_Organization_Users = By.xpath("//*[contains(text(),'Data')]");
	By pageManage_Broker_Delegates = By.xpath("//*[contains(text(),'My Delegates')]");
	By pageManage_United_Advantage_Report_Access = By.xpath("//*[contains(text(),'Data')]");
	By pageManage_Quote_and_Renewal_News_and_Alerts_and_Notations = By
			.xpath("//td[contains(text(),'Manage Quote and Renewal News, Alerts and Notations')]");
	By pageClear_Cache = By.xpath("//td[contains(text(),'Refresh Cache')]");
	By pageModify_Logging_Levels = By.xpath("//td[contains(text(),'Modify Logging Levels')]");
	By pageView_Renewal_Package_Mailing_Preference_and_History = By
			.xpath("//*[contains(text(),'View Renewal Package Mailing Preference and History')]");

	public void clickAdministrationkTab(WebDriver driver) throws InterruptedException {
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("navbar");
		Thread.sleep(1000);

		element = driver.findElement(linkAdministration);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(4000);
	}

	public void verifyAdministrationkHome(WebDriver driver, String txtAdmin) throws InterruptedException {
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);
		element = driver.findElement(siteAdministration);

		if (element.getText().contains(txtAdmin)) {
			System.out.println(txtAdmin + " dsiplayed successfully");
		} else {
			System.out.println(txtAdmin + " not dsiplayed");
		}
	}

	public void verifyLinks(WebDriver driver) {
		String Create_and_Register_a_New_User, Manage_Existing_Users;
		String Manage_B2B_Account, Manage_Organization;
		String Manage_Organization_Users, Manage_Broker_Delegates;
		String Manage_United_Advantage_Report_Access, Manage_Quote_and_Renewal_News_and_Alerts_and_Notations;
		String Clear_Cache, Modify_Logging_Levels, View_Renewal_Package_Mailing_Preference_and_History;

		Create_and_Register_a_New_User = driver.findElement(By.linkText("Create and Register a New User")).getText();
		Manage_Existing_Users = driver.findElement(By.linkText("Manage Existing Users")).getText();
		Manage_B2B_Account = driver.findElement(By.linkText("Manage B2B Account")).getText();
		Manage_Organization = driver.findElement(By.linkText("Manage Organization")).getText();
		Manage_Organization_Users = driver.findElement(By.linkText("Manage Organization Users")).getText();
		Manage_Broker_Delegates = driver.findElement(By.linkText("Manage Broker Delegates")).getText();
		Manage_United_Advantage_Report_Access = driver.findElement(By.linkText("Manage United Advantage Report Access"))
				.getText();
		Manage_Quote_and_Renewal_News_and_Alerts_and_Notations = driver
				.findElement(By.linkText("Manage Quote and Renewal News, Alerts and Notations")).getText();
		Clear_Cache = driver.findElement(By.linkText("Clear Cache")).getText();
		Modify_Logging_Levels = driver.findElement(By.linkText("Modify Logging Levels")).getText();
		View_Renewal_Package_Mailing_Preference_and_History = driver
				.findElement(By.linkText("View Renewal Package Mailing Preference and History")).getText();

		if ((Create_and_Register_a_New_User.trim().contains("Create and Register a New User")
				&& (Manage_Existing_Users.trim().contains("Manage Existing Users")
						&& (Manage_B2B_Account.trim().contains("Manage B2B Account"))))) {
			System.out.println(
					"||Create and Register a New User||Manage Existing Users||Manage B2B Account || Links are displayed successfully in NetWork Home page");
		} else {
			System.out.println(
					"||Create and Register a New User||Manage Existing Users||Manage B2B Account || Issue in this links");
		}

		if ((Manage_Organization.trim().contains("Manage Organization")
				&& (Manage_Organization_Users.trim().contains("Manage Organization Users")
						&& (Manage_Broker_Delegates.trim().contains("Manage Broker Delegates"))))) {
			System.out.println(
					"||Manage Organization||Manage Organization Users||Manage Broker Delegates|| Links are displayed successfully in NetWork Home page");
		} else {
			System.out.println(
					"||Manage Organization||Manage Organization Users||Manage Broker Delegates|| Issue is this links");
		}
		if ((Manage_United_Advantage_Report_Access.trim().contains("Manage United Advantage Report Access")
				&& (Manage_Quote_and_Renewal_News_and_Alerts_and_Notations.trim()
						.contains("Manage Quote and Renewal News, Alerts and Notations")
						&& (Clear_Cache.trim().contains("Clear Cache"))))) {
			System.out.println(
					"||Manage United Advantage Report Access||Manage Quote and Renewal News, Alerts and Notations||Clear Cache|| Links are displayed successfully in NetWork Home page");
		} else {
			System.out.println(
					"||Manage United Advantage Report Access||Manage Quote and Renewal News, Alerts and Notations||Clear Cache|| Issue is this links");
		}
		if ((Modify_Logging_Levels.trim().contains("Modify Logging Levels")
				&& (View_Renewal_Package_Mailing_Preference_and_History.trim()
						.contains("View Renewal Package Mailing Preference and History")))) {
			System.out.println(
					"||Modify Logging Levels||View Renewal Package Mailing Preference and History|| Links are displayed successfully in NetWork Home page");
		} else {
			System.out.println(
					"||Modify Logging Levels||View Renewal Package Mailing Preference and History|| Issue is this links");
		}

	}

	public void verifyClickableLinks(WebDriver driver) throws InterruptedException {

		By Create_and_Register_a_New_User = By.xpath("//a[@href='createRequest.do']");
		clickOnLink(driver, Create_and_Register_a_New_User);
		By Manage_Existing_Users = By.xpath("//a[@href='accountSearch.jsp']");
		clickOnLink(driver, Manage_Existing_Users);
		By Manage_B2B_Account = By.xpath("//a[@href='/uessecured/securityadmin/B2BAccessSearch.do']");
		clickOnLink(driver, Manage_B2B_Account);
		By Manage_Organization = By
				.xpath("//a[@href='/uessecured/securityadmin/organization/manageOrganizationSetup.do']");
		clickOnLink(driver, Manage_Organization);
		By Manage_Organization_Users = By.xpath("//a[@href='/uessecured/delegation/ManageDelegatesSetup.do']");
		clickOnLink(driver, Manage_Organization_Users);
		By Manage_Broker_Delegates = By
				.xpath("//a[@href='/uessecured/brokerdelegation/ManageBrokerDelegatesSetup.do']");
		clickOnLink(driver, Manage_Broker_Delegates);
		By Manage_United_Advantage_Report_Access = By
				.xpath("//a[@href='/uessecured/delegation/ReportManageDelegatesSetup.do']");
		clickOnLink(driver, Manage_United_Advantage_Report_Access);
		By Manage_Quote_and_Renewal_News_and_Alerts_and_Notations = By
				.xpath("//a[@href='/uessecured/securityadmin/organization/manageOrganizationSetup.do']");
		clickOnLink(driver, Manage_Quote_and_Renewal_News_and_Alerts_and_Notations);
		By Clear_Cache = By.xpath("//a[@href='/uessecured/securityadmin/getModifyMessages.do?messagetype=Q']");
		clickOnLink(driver, Clear_Cache);
		By Modify_Logging_Levels = By.xpath("//a[@href='modifyLoggingLevelsSetupAction.do']");
		clickOnLink(driver, Modify_Logging_Levels);
		By View_Renewal_Package_Mailing_Preference_and_History = By
				.xpath("//a[@href='.././myaccount/BrokerGoGreenSearchSetup.do']");
		clickOnLink(driver, View_Renewal_Package_Mailing_Preference_and_History);// a[@href='.././myaccount/BrokerGoGreenSearchSetup.do']

	}

	int count = 0;

	public void clickOnLink(WebDriver driver, By adminLink) throws InterruptedException {

		Thread.sleep(3000);
		driver.switchTo().defaultContent();

		Thread.sleep(3000);
		driver.switchTo().frame("content");
		Thread.sleep(2000);

		System.out.println("roshan************############");
		element = driver.findElement(adminLink);
		Thread.sleep(2000);
		executor = (JavascriptExecutor) driver;
		Thread.sleep(7000);
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(15000);
		driver.navigate().back();
		count++;
		System.out.println("Link no " + count + "is closed");
		Thread.sleep(5000);

		// driver.switchTo().defaultContent();
		// Thread.sleep(3000);
		// driver.switchTo().frame("content");
		// Thread.sleep(2000);
	}

	public static void verifyLink_SiteAdministrationPage(WebDriver driver, By path, String name, String elementType)
			throws InterruptedException {
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(3000);

		String nameLink = driver.findElement(path).getText();
		// System.out.println("Heading Name :: " + nameHeading);

		if (nameLink.contains(name)) {
			System.out.println(nameLink + " :: " + elementType + " present on Site Administration Page");
		} else {
			System.out.println(nameLink + "  ::" + elementType + " not present on Site Administration Page");
			// Assert.assertEquals(nameHeading, name);
		}
	}

	public void verifySiteAdministration_Links_Set1(WebDriver driver) throws InterruptedException {
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkCreate_and_Register_a_New_User,
				"Create and Register a New User", "link");
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkManage_Existing_Users, "Manage Existing Users",
				"link");
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkManage_B2B_Account, "Manage B2B Account",
				"link");
	}

	public void verifySiteAdministration_Links_Set2(WebDriver driver) throws InterruptedException {
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkManage_Organization, "Manage Organization",
				"link");
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkManage_Organization_Users,
				"Manage Organization Users", "link");
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkManage_Broker_Delegates,
				"Manage Broker Delegates", "link");
	}

	public void verifySiteAdministration_Links_Set3(WebDriver driver) throws InterruptedException {
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkManage_United_Advantage_Report_Access,
				"Manage United Advantage Report Access", "link");
		AdministrationPage.verifyLink_SiteAdministrationPage(driver,
				linkManage_Quote_and_Renewal_News_and_Alerts_and_Notations,
				"Manage Quote and Renewal News, Alerts and Notations", "link");
	}

	public void verifySiteAdministration_Links_Set4(WebDriver driver) throws InterruptedException {
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkClear_Cache, "Clear Cache", "link");
		AdministrationPage.verifyLink_SiteAdministrationPage(driver, linkModify_Logging_Levels, "Modify Logging Levels",
				"link");
		AdministrationPage.verifyLink_SiteAdministrationPage(driver,
				linkView_Renewal_Package_Mailing_Preference_and_History,
				"View Renewal Package Mailing Preference and History", "link");
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

		Thread.sleep(7000);
		// utility.waitForVisibilityOfWebElement(linkPagePath, driver);
		String nameLinkPage = driver.findElement(linkPagePath).getText();
		// System.out.println("Link Page Text :: " + nameLinkPage);

		if (nameLinkPage.trim().contains(name)) {
			System.out.println(nameLinkPage + " :: " + " Page displayed successfully");
			Thread.sleep(2000);
			//By submitBack = By.xpath("//input[@name='button' and @value='CANCEL']");
			By submitBack = By.xpath("//input[@value='CANCEL' or @value='< BACK']");
			//utility.waitForVisibilityOfWebElement(submitBack, driver);
			element = driver.findElement(submitBack);
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(2000);
		} else {
			System.out.println(nameLinkPage + "  ::" + " Page not displayed");
			// Assert.assertEquals(nameHeading, name);
			By submitBack = By.xpath("//input[@name='submitBack']");
			utility.waitForVisibilityOfWebElement(submitBack, driver);
			element = driver.findElement(submitBack);
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(3000);
		}
	}

	public static void verifyLinkPage_1(WebDriver driver, By linkPath, String name, By linkPagePath)
			throws InterruptedException {
		String pwindow = driver.getWindowHandle();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);

		element = driver.findElement(linkPath);
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		Thread.sleep(5000);
		//utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			//System.out.println(driver.switchTo().window(winHandle).getTitle());
			//System.out.println(driver.switchTo().window(winHandle).getCurrentUrl());
			if (driver.switchTo().window(winHandle).getTitle().contains("Search")) {
				Thread.sleep(2000);
				driver.switchTo().window(winHandle).close();
				// break;
			}
		}

		driver.switchTo().window(pwindow);
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);
		// utility.waitForVisibilityOfWebElement(linkPagePath, driver);
		String nameLinkPage = driver.findElement(linkPagePath).getText();
		// System.out.println("Link Page Text :: " + nameLinkPage);

		if (nameLinkPage.trim().contains(name)) {
			System.out.println(nameLinkPage + " :: " + " Page displayed successfully");
			Thread.sleep(1000);
			By submitBack = By.xpath("//input[@alt='Back' or @value='< BACK']");
			//utility.waitForVisibilityOfWebElement(submitBack, driver);
			element = driver.findElement(submitBack);
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(2000);
		} else {
			System.out.println(nameLinkPage + "  ::" + " Page not displayed");
			// Assert.assertEquals(nameHeading, name);
			By submitBack = By.xpath("//input[@name='submitBack']");
			utility.waitForVisibilityOfWebElement(submitBack, driver);
			element = driver.findElement(submitBack);
			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			Thread.sleep(3000);
		}
	}

	public void verifyLinkPages_Set1(WebDriver driver) throws InterruptedException {
		AdministrationPage.verifyLinkPage(driver, linkCreate_and_Register_a_New_User, "Create and Register a New User",
				pageCreate_and_Register_a_New_User);
		AdministrationPage.verifyLinkPage(driver, linkManage_Existing_Users, "User Search - Manage Existing Users",
				pageManage_Existing_Users);
		AdministrationPage.verifyLinkPage(driver, linkManage_B2B_Account, "B2B Partner System Accounts",
				pageManage_B2B_Account);
	}

	public void verifyLinkPages_Set2(WebDriver driver) throws InterruptedException {
		AdministrationPage.verifyLinkPage(driver, linkManage_Organization, "Manage Organization",
				pageManage_Organization);
		AdministrationPage.verifyLinkPage_1(driver, linkManage_Organization_Users, "Data",
				pageManage_Organization_Users);
		AdministrationPage.verifyLinkPage_1(driver, linkManage_Broker_Delegates, "My Delegates",
				pageManage_Broker_Delegates);
	}

	public void verifyLinkPages_Set3(WebDriver driver) throws InterruptedException {
		AdministrationPage.verifyLinkPage_1(driver, linkManage_United_Advantage_Report_Access, "Data",
				pageManage_United_Advantage_Report_Access);
		AdministrationPage.verifyLinkPage(driver, linkManage_Quote_and_Renewal_News_and_Alerts_and_Notations,
				"Manage Quote and Renewal News, Alerts and Notations",
				pageManage_Quote_and_Renewal_News_and_Alerts_and_Notations);
	}

	public void verifyLinkPages_Set4(WebDriver driver) throws InterruptedException {

		By pageClear_Cache = By.xpath("//td[contains(text(),'Refresh Cache')]");
		By pageModify_Logging_Levels = By.xpath("//td[contains(text(),'Modify Logging Levels')]");
		By pageView_Renewal_Package_Mailing_Preference_and_History = By
				.xpath("//*[contains(text(),'View Renewal Package Mailing Preference and History')]");

		By linkClear_Cache = By.linkText("Clear Cache");
		By linkModify_Logging_Levels = By.linkText("Modify Logging Levels");
		By linkView_Renewal_Package_Mailing_Preference_and_History = By
				.linkText("View Renewal Package Mailing Preference and History");

		AdministrationPage.verifyLinkPage(driver, linkClear_Cache, "Refresh Cache", pageClear_Cache);
		AdministrationPage.verifyLinkPage(driver, linkModify_Logging_Levels, "Modify Logging Levels",
				pageModify_Logging_Levels);
		AdministrationPage.verifyLinkPage_1(driver, linkView_Renewal_Package_Mailing_Preference_and_History,
				"View Renewal Package Mailing Preference and History",
				pageView_Renewal_Package_Mailing_Preference_and_History);

	}

}
