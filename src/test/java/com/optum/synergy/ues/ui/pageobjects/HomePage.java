package com.optum.synergy.ues.ui.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.optum.synergy.ues.ui.utilities.Utilities;

import junit.framework.Assert;

public class HomePage {
	public static Utilities utility;
	By loginUsername = By.xpath(".//*[@id='divContent']/table[1]/tbody/tr/td/span");
	public static WebElement element;
	public static JavascriptExecutor executor;
	DesiredCapabilities ieCapabilities;
	By uesUserName = By.xpath(".//*[@id='U']");
	By uesPwd = By.xpath(".//*[@id='P']");
	By uesLoginBtn = By.xpath("//a[contains(text(),'Log In')]");
	By uesForms = By.xpath(".//*[@id='M7']");
	By uesHelp_Training = By.xpath(".//*[@id='M6']");
	By uesBenefits_Administration = By.xpath(".//*[@id='M8']");
	By uesRecognition = By.xpath(".//*[@id='M10']");
	By contentFormsTab = By.xpath("//span[contains(text(),'Forms Home')]");
	By contentBenefitsAdministrationTab = By.xpath("//span[contains(text(),'Benefits Administration Home')]");
	By contentRecognitionTab = By.xpath(".//*[@id='divContent']/table/tbody/tr[1]/td/div");
	By contentHelpTraining = By.xpath(".//*[contains(text(),'United eServices Help & Training')]");
	// By contentHelpTraining=By.xpath("//h1[contains(.,'United eServices Help
	// & Training')]");

	public HomePage() throws IOException {

		utility = new Utilities();

	}

	public void verifyUserName_Header_Footer(WebDriver driver) throws InterruptedException, IOException {
		Thread.sleep(5000);
		// System.out.println("Page Title ::"+driver.getTitle());
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		// utility.waitforSwitchtoFrame(By.name("navbar"), driver);
		driver.switchTo().frame("navbar");
		// System.out.println("Frame Title : :"+
		// driver.switchTo().frame("navbar").getTitle());
		// Thread.sleep(2000);

		String unitedHealthcareLogo = "//img[@title='UnitedHealthcare Logo']";
		QuotePage.verifyPageDisplay_logo(driver, unitedHealthcareLogo, "UnitedHealthcare Logo");

		String unitedeServicesLogo = "//img[@title='United eServices Logo']";
		QuotePage.verifyPageDisplay_logo(driver, unitedeServicesLogo, "United eServices Logo");

		Thread.sleep(2000);
		// System.out.println("Page Title ::"+driver.getTitle());
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("content");
		// System.out.println("Frame Title : :"+
		// driver.switchTo().frame("content").getTitle());

		String uesHome;
		uesHome = driver.findElement(loginUsername).getText();
		System.out.println("UeS Home Text ::" + uesHome);

		if (uesHome.equalsIgnoreCase(uesHome)) {
			System.out.println("User Name :: " + uesHome + " displayed successfully");
		} else {
			System.out.println("User Name :: " + uesHome + " not displayed");
		}
		QuotePage.verifyFooterLinks(driver);
	}

	public static void verifyHeadings_HomePage(WebDriver driver, By path, String name) {

		String nameHeading = driver.findElement(path).getText();
		// System.out.println("Heading Name :: " + nameHeading);

		if (nameHeading.contains(name)) {
			System.out.println(nameHeading + " :: " + " Heading present on Home Page");
		} else {
			System.out.println(nameHeading + "  ::" + " Heading not present on Home Page");
			// Assert.assertEquals(nameHeading, name);
		}
	}

	public void verifyHomePageHeadings(WebDriver driver) {
		By nameNewsInformation = By.xpath("//p[contains(.,'News & Information')]");
		By nameNewsRatesAlerts = By.xpath("//p[contains(.,'News & Rate Alerts')]");
		By nameQuickLinks = By.xpath("//p[contains(.,'Quick Links')]");
		By nameWhatsNew = By.xpath(".//*[@id='divContent']/table[2]/tbody/tr[2]/td[5]/table/tbody/tr[1]/td[2]/p");

		HomePage.verifyHeadings_HomePage(driver, nameNewsInformation, "News & Information");
		HomePage.verifyHeadings_HomePage(driver, nameNewsRatesAlerts, "News & Rate Alerts");
		HomePage.verifyHeadings_HomePage(driver, nameQuickLinks, "Quick Links");
		HomePage.verifyHeadings_HomePage(driver, nameWhatsNew, "What's New?");
	}

	public void verifyTabs(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("navbar");
		String textForms = driver.findElement(uesForms).getAttribute("value");
		String textHelpTraining = driver.findElement(uesHelp_Training).getAttribute("value");
		String textBenifitsAdministration = driver.findElement(uesBenefits_Administration).getAttribute("value");
		String textRecognition = driver.findElement(uesRecognition).getAttribute("value");

		/*
		 * System.out.println("textForms ::" + textForms.trim());
		 * System.out.println("textHelpTraining ::" + textHelpTraining.trim());
		 * System.out.println("textBenifitsAdministration ::" +
		 * textBenifitsAdministration.trim());
		 * System.out.println("textRecognition ::" + textRecognition.trim());
		 */

		if ((textForms.trim().contains("Forms")) && (textHelpTraining.trim().contains("Help"))
				&& (textBenifitsAdministration.trim().contains("Benefits"))
				&& (textRecognition.trim().contains("Recognition"))) {
			System.out.println("Tabs are ::" + textForms.trim() + " ," + textHelpTraining.trim() + " ,"
					+ textBenifitsAdministration + " and " + textRecognition.trim() + " Present on Home Page");
		} else {
			System.out.println("Tabs are ::" + textForms + " , " + textHelpTraining + " , " + textBenifitsAdministration
					+ " and " + textRecognition + " not present on Home Page");
		}

	}

	public void verifySAMLink(WebDriver driver) throws InterruptedException {
		element = driver.findElement(By.xpath(
				"//img[@src='/mc/Broker/UHG/en-US/AllContent/Unassigned Content/Static Files/Images/SAM SSO Image.jpg']"));
		//System.out.println("SAM text ::" + element.getAttribute("src"));
		if (element.getAttribute("src").contains("SAM")) {
			System.out.println("SAM link present on Home Page");

			executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);

			Thread.sleep(20000);
		} else {
			System.out.println("SAM link not present on Home Page");
		}
		// img[@src='/mc/Broker/UHG/en-US/AllContent/Unassigned Content/Static
		// Files/Images/SAM.png'] BFX
		// img[@src='/mc/Broker/UHG/en-US/AllContent/Unassigned Content/Static
		// Files/Images/SAM SSO Image.jpg'] STG
	}

	public void verifySAMPage(WebDriver driver) {
		// utility.waitForNumberOfWindowsToEqual(2);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains("healthinsurance")) {
				System.out.println("SAM page URL :: " + driver.switchTo().window(winHandle).getCurrentUrl()
						+ " displayed successfully");

				element = driver.findElement(By.id("samlogo"));
				if (element.getAttribute("src").contains("sam-logo")) {
					System.out.println("SAM page displayed successfully");
					driver.switchTo().window(winHandle).close();
					break;
				}
			}
		}
	}

	

	public static void clickTab_verifyContentOnEachTab(WebDriver driver, By tabPath, By contentPath, String content)
			throws InterruptedException {

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("navbar");
		element = driver.findElement(tabPath);
		String uesTabValue = element.getAttribute("value");
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");
		Thread.sleep(1000);
		utility.waitForVisibilityOfWebElement(contentPath, driver);
		String contentTab = driver.findElement(contentPath).getText();

		if (contentTab.trim().contains(content)) {
			System.out.println(
					contentTab + " text present on Home page when user clicked on " + uesTabValue.trim() + " Tab");
		} else {
			System.out.println(
					contentTab + " text not present on Home page when user clicked on " + uesTabValue.trim() + " Tab");
		}
	}

	public void verifyContentOnEachTab(WebDriver driver) throws InterruptedException {
		HomePage.clickTab_verifyContentOnEachTab(driver, uesForms, contentFormsTab, "Forms Home");
		HomePage.clickTab_verifyContentOnEachTab(driver, uesBenefits_Administration, contentBenefitsAdministrationTab,
				"Benefits Administration Home");
		HomePage.clickTab_verifyContentOnEachTab(driver, uesRecognition, contentRecognitionTab,
				"UnitedHealthcare Relationship Manager");
		// HomePage.clickTab_verifyContentOnEachTab(driver, uesHelp_Training,
		// contentHelpTraining, "United eServices Help & Training");

	}

	public void clickTab_verifyHelpTraining(WebDriver driver) throws InterruptedException {

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("navbar");
		element = driver.findElement(uesHelp_Training);
		String uesTabValue = element.getAttribute("value");
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		driver.switchTo().frame("content");

		// String contentTab =
		// driver.findElement(contentHelpTraining).getText();
		By iframeName = By.xpath("//iframe[@name='test']");
		utility.waitForVisibilityOfWebElement(iframeName, driver);
		String contentTab = driver.findElement(iframeName).getAttribute("src");
		// System.out.println("iframe text :: " + contentTab);

		if (contentTab.trim().contains("UnitedeServicesHelpandTraining")) {
			System.out.println("United eServices Help and Training text present on Home page when user clicked on "
					+ uesTabValue.trim() + " Tab");
		} else {
			System.out.println("United eServices Help and Training text not present on Home page when user clicked on "
					+ uesTabValue.trim() + " Tab");
		}
	}
}
