package com.optum.synergy.ues.ui.stepDefinitions;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;

	public static Properties autoProperties;

	public String FeatureFileName;
	public static String profile;

	public static int longTimeout = 10;
	protected static String fileSeperator = System.getProperty("file.separator");

	public static String isetUser;
	public static String isetPassword;
	public static String browserName;
	public static String resourceName;
	public static ClassLoader loader;

	//public static final String SAUCE_USERNAME = "a4mesdet";
	public static final String SAUCE_USERNAME = "hkaur115";
	//public static final String SAUCE_ACCESS_KEY = "d0c27b03-24cc-4c20-8228-fc9a196e33a6"; 
	public static final String SAUCE_ACCESS_KEY ="b16e4496-8ff4-473c-bdae-21929162d1a9"; 
	//public static final String SAUCE_ACCESS_KEY ="09e9ec1f-f289-419b-918c-8543952db633";
	public static final String SAUCE_URL = "http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY
			+ "@ondemand.saucelabs.com:80/wd/hub";

	@Before
	public void setupTestsuite(Scenario scenario) throws InvocationTargetException, Exception {
		System.out.println(" ");
		System.out.println("**** Begin Hooks.java ***** ");
		String scenarioName = scenario.getName();
		System.out.println("scenarioName: " + scenarioName);
		// Launch browser code moved to utilities.java, will be called from each
		// respective feature file as needed.
		/*
		 * Code under test
		 */
		// ***********************************************************************//
		resourceName = "UeS.properties";
		loader = Thread.currentThread().getContextClassLoader();
		autoProperties = new Properties();
		try (InputStream resourceStream = getClass().getResourceAsStream("/config/UeS.properties")) {
			autoProperties.load(resourceStream);
		}
		browserName = autoProperties.getProperty("BrowserType");
		System.out.println("Test Environment is " + browserName);
		String workingDir = System.getProperty("user.dir");
		System.out.println("Current working directory : " + workingDir);

		switch (browserName.toUpperCase()) {
		case "FIREFOX":

			System.setProperty("webdriver.gecko.driver", workingDir + autoProperties.getProperty("FirefoxDriver"));
			driver = new FirefoxDriver();

			break;
		case "IE":

			System.setProperty("webdriver.ie.driver", workingDir + autoProperties.getProperty("IEDriver"));
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			ieCapabilities.setCapability("ignoreZoomSetting", true); //
			// ieCapabilities.setCapability("requireWindowFocus", true);
			// ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
			/*
			 * Due to below line , not able to add site in compatibility view
			 * settings ieCapabilities.setCapability(InternetExplorerDriver.
			 * IE_ENSURE_CLEAN_SESSION, true);
			 */
			ieCapabilities.setCapability(InternetExplorerDriver.SILENT, true);

			driver = new InternetExplorerDriver(ieCapabilities);
			/*
			 * Due to below line , not able to add site in compatibility view
			 * settings driver.manage().deleteAllCookies();
			 */
			// driver.get("https://www.optum.com/");
			// temp remove below full code except break

			System.out.println("Launched INTERNET EXPLORER: " + workingDir + autoProperties.getProperty("IEDriver"));

			// browser=BrowserFactory.attach(new
			// BrowserDescription.Builder().type(BrowserType.INTERNET_EXPLORER).build());
			// browser.sync();

			break;
		case "SAUCELAB":
			HashMap<String, String> prerunParams = new HashMap<String, String>();
			prerunParams.put("executable",
					"https://raw.githubusercontent.com/MincedCutlet/Dependecy/master/compat.bat");
			prerunParams.put("background", "false");

			DesiredCapabilities capabilities = null;
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("platform", "Windows 7");
			capabilities.setCapability("version", "11.0");
			capabilities.setCapability("parent-tunnel", "sauce_admin");
			//capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Stg");
			capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Prd");
			capabilities.setCapability("prerun", prerunParams);

			// capabilities.setCapability("name", scenarioName);
			capabilities.setCapability("time-zone", "Pacific");
			driver = new RemoteWebDriver(new URL(SAUCE_URL), capabilities);
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));

			break;

		}

		// **********************************Under Test**********************

	}

	 @After

	public void cleanupTestSuite(Scenario scenario) throws Exception {
		System.out.println(" ");
		System.out.println("**** cleanup test suite - Teardown Section ***** ");

		/*
		 * need to debug this screenshot code, crashing. try { if
		 * (scenario.isFailed()) { String screenShotName = scenario.getName() +
		 * " " + getTimeStamp() + ".png"; System.out.println("NAME IS :" +
		 * screenShotName); String TotalFileName =
		 * scenario.getId().split(";")[0]; String FeatureName =
		 * TotalFileName.split("-")[0].toUpperCase();
		 * System.out.println(FeatureName);
		 * 
		 * //String imagePath = ".." + fileSeperator + "Screenshots" +
		 * fileSeperator + "Results" + fileSeperator // + FeatureName +
		 * fileSeperator + takeScreenShot(screenShotName, FeatureName);
		 * System.out.
		 * println("*To Do* - add code to capture Screenshot on failure."); } }
		 * catch (Exception e) { e.printStackTrace(); }
		 */
	/*if (driver==null){
		System.out.println("Driver is already closed");
	}
	else
		driver.quit();
*/
	}

	// Let's move this code to commonlibrary. Generic wait timesr
	public boolean waitForElement(WebElement elem, int seconds) {

		System.out.println("...called wait for element.");

		boolean displayedElement = false;
		WebDriverWait wait = new WebDriverWait(driver, seconds);

		try {
			wait.until(ExpectedConditions.visibilityOf(elem));
			displayedElement = true;
		} catch (TimeoutException e) {
			System.out.println("Failed to find a visible element with [" + elem.toString() + "]");
			displayedElement = false;
		} catch (Exception e) {
			System.out.println("Generic exception e [" + e.getMessage() + "]");
			displayedElement = false;
		}
		return displayedElement;
	}

	// Let's move this code to commonlibrary. Generic get timestamp

	public String getTimeStamp() {
		String today;
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Calendar calendar = Calendar.getInstance();
		today = dateFormat.format(calendar.getTime());
		return today;
	}

	// Let's move this code to commonlibrary. Generic takescreenshot

	/*public String takeScreenShot(String screenShotName, String FeatureName) {

		System.out.println("**** hooks.java - take a screenshot (don't think this code works  ***** ");

		try {
			File file = new File("Screenshots" + fileSeperator + "Results");
			if (!file.exists()) {
				System.out.println("File created " + file);
				file.mkdir();
			}
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File targetFile = new File("Screenshots" + fileSeperator + "Results" + fileSeperator + FeatureName,
					screenShotName);
			FileUtils.copyFile(screenshotFile, targetFile);
			System.out.println(" created screenshot:  " + "Results" + fileSeperator + FeatureName + fileSeperator
					+ screenShotName);

			return screenShotName;
		} catch (Exception e) {
			System.out.println(
					"Yep was right code does not work - An exception occured while taking screenshot " + e.getCause());
			return null;
		}*/

	//}

}