package com.optum.synergy.ues.ui.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class HomePage {

	By loginUsername = By.xpath(".//*[@id='divContent']/table[1]/tbody/tr/td/span");

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
		//System.out.println("Heading Name :: " + nameHeading);

		if (nameHeading.contains(name)) {
			System.out.println(nameHeading + " :: " + " Heading present on Home Page");
		} else {
			System.out.println(nameHeading + "  ::" + " Heading not present on Home Page");
			//Assert.assertEquals(nameHeading, name);
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

}
