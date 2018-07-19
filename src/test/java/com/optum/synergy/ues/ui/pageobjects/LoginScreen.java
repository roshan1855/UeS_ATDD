package com.optum.synergy.ues.ui.pageobjects;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScreen {
	private Map<String, String> data;
	int timeout = 10;
	private final String pageUrl = "URL";
	private final String pageLoadedText = "Text";

	@FindBy(xpath = "//input[@id='j_username']")
	@CacheLookup
	private WebElement username;
	
	@FindBy(xpath ="//input[@id='j_password']")
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Submit'")
	@CacheLookup
	private WebElement enter;

	public LoginScreen setUserName(WebDriver driver, String Username) {
		username.sendKeys(Username);
		return this;
	}
	
	public LoginScreen setPassword(WebDriver driver , String pwd){
		password.clear();
		password.sendKeys(pwd);
		return this;
	}

	public LoginScreen clickSubmit(WebDriver driver){
		enter.sendKeys(Keys.ENTER);
		return this;
	}
	public LoginScreen verifyPageUrl(WebDriver driver) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}

	public LoginScreen verifyPageLoaded(WebDriver driver) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}
}
