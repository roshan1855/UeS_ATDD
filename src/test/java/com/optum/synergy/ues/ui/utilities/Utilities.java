package com.optum.synergy.ues.ui.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.base.Function;
import com.optum.synergy.ues.ui.stepDefinitions.CommonLibrary;
import com.optum.synergy.ues.ui.stepDefinitions.Hooks;

public class Utilities  {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent1;
	public static ExtentTest featureLog;
	public static ExtentTest scenario;
	public static ExtentTest test;
	public static String resourceName;
	public static ClassLoader loader;
	//public static Properties obj;
	public static Properties autoProperties;
	public static WebDriver driver;
	public static String reportPath;
	public static WebDriverWait wait;
	
	 public static final String SAUCE_USERNAME = "a4mesdet";
	 public static final String SAUCE_ACCESS_KEY = "d0c27b03-24cc-4c20-8228-fc9a196e33a6";
     
     public static final String SAUCE_URL = "http://" + SAUCE_USERNAME + ":" + SAUCE_ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	public Utilities() throws IOException {
		
		resourceName = "UeS.properties";
		autoProperties = Hooks.autoProperties;
		loader = Thread.currentThread().getContextClassLoader();
		/*obj = new Properties();
		//try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
		try ( InputStream resourceStream  = getClass().getResourceAsStream("/config/UeS.properties")){
			obj.load(resourceStream);
		}*/
		

	}

	
	
	public WebDriver OpenBrowser(String browserName) throws IOException, InterruptedException {
		
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
			capabilities.setCapability("tunnelIdentifier", "OptumSharedTunnel-Stg");
			capabilities.setCapability("prerun", prerunParams);

			// capabilities.setCapability("name", scenarioName);
			capabilities.setCapability("time-zone", "Pacific");
			driver = new RemoteWebDriver(new URL(SAUCE_URL), capabilities);
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.ADD));

			break;

		}

		// **********************************Under Test**********************
		return driver;

	}

	public String generateUniqueFileName() {
		String filename = "";
		long millis = System.currentTimeMillis();
		String datetime = new Date().toGMTString();
		datetime = datetime.replace(" ", "");
		datetime = datetime.replace(":", "");
		String rndchars = RandomStringUtils.randomAlphanumeric(16);
		filename = rndchars + "_" + datetime + "_" + millis;
		return filename;
	}

	
	 public WebElement fluentWait(final By locator, WebDriver driver) { Wait<WebDriver> wait =
	 new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS)
	 .pollingEvery(1,
	  TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
	  
	  WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	  public WebElement apply(WebDriver driver) { return
	  driver.findElement(locator); } });
	  
	  return foo; };
	 

	public void takeScreenShot(WebDriver driver, String fileName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir")+autoProperties.getProperty("ScreenshotsPath");
		System.out.println("Debug Point - Inside Screenshot function"+screenShotPath);
		FileUtils.copyFile(scrFile, new File(screenShotPath+ "/"+fileName + ".png"));
		//FileUtils.copyFile(scrFile, new File("target/screenshots/"+"actualTest"+".png"));
		// C:\\Users\\hkaur115\\Desktop\\Auto\\
	}

	public void CreateReport(String reportName, String testName) {
		reportPath =  System.getProperty("user.dir")+autoProperties.getProperty("ScreenshotsPath");
		System.out.println("Debug Point - Inside CreateReport function"+reportPath);

		htmlReporter = new ExtentHtmlReporter(reportPath + "/"+reportName + ".html");// modify
		// with
		// path
		htmlReporter.setAppendExisting(true);
		extent1 = new ExtentReports();

		extent1.attachReporter(htmlReporter);
		extent1.setSystemInfo("Developer", "Suribabu");
		extent1.setSystemInfo("OS", "WINDOWS");
		extent1.setSystemInfo("Title", "UeS Automation ");

		featureLog = extent1.createTest(testName);/// add one more param
		// extent1.removeTest(featureLog);
		extent1.flush();

	}

	public void GenerateReport(String testName, String scenarioMessage, String status, String statusMessage,
			String screenshotName) throws IOException {
		System.out.println( "Logging Test Result: "+ status + "-" + scenarioMessage + "  " + statusMessage     );

		// scenario = feature.createNode(scenarioMessage);
		resourceName = "UeS.properties";
		loader = Thread.currentThread().getContextClassLoader();
		//Properties obj = new Properties();
		//try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
		/*try ( InputStream resourceStream  = getClass().getResourceAsStream("/config/UeS.properties")){
			obj.load(resourceStream);
		}*/
		String screenShotPath = System.getProperty("user.dir") + "/" + autoProperties.getProperty("ScreenshotsPath"+"/");
		if (status.contains("pass")) { // featureLog.pass(statusMessage);
			featureLog.assignCategory(testName);
			// takeScreenShot(driver,
			// obj.getProperty("ScreenshotsPath")+screenshotName);
			System.out.println("Screeshots Path = " + reportPath);
			featureLog.log(Status.PASS, statusMessage,
					MediaEntityBuilder.createScreenCaptureFromPath(reportPath + screenshotName + ".png").build());
		}
		if (status.contains("fail"))
			// featureLog.fail(statusMessage);
			// takeScreenShot(driver,
			// obj.getProperty("ScreenshotsPath")+screenshotName);
			featureLog.log(Status.FAIL, statusMessage,
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath + screenshotName + ".png").build());
		if (status.contains("info"))
			// takeScreenShot(driver,
			// obj.getProperty("ScreenshotsPath")+screenshotName);
			featureLog.log(Status.INFO, statusMessage,
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath + screenshotName + ".png").build());

		if (status.contains("warning"))
			// takeScreenShot(driver,
			// obj.getProperty("ScreenshotsPath")+screenshotName);
			featureLog.log(Status.WARNING, statusMessage,
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath + screenshotName + ".png").build());

		extent1.flush();

	}

	public void GenerateReportWithoutScreenShot(String testName, String scenarioMessage, String status, String statusMessage) throws IOException {
		System.out.println( "Logging Test Result: "+ status + "-" + scenarioMessage + "  " + statusMessage     );

		// scenario = feature.createNode(scenarioMessage);
		resourceName = "UeS.properties";
		loader = Thread.currentThread().getContextClassLoader();
		//Properties obj = new Properties();
		//try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
		/*try ( InputStream resourceStream  = getClass().getResourceAsStream("/config/UeS.properties")){
			obj.load(resourceStream);
		}*/
		String screenShotPath = System.getProperty("user.dir") + "/" + autoProperties.getProperty("ScreenshotsPath"+"/");
		if (status.contains("pass")) { // featureLog.pass(statusMessage);
			featureLog.assignCategory(testName);
			featureLog.log(Status.PASS, statusMessage);
		
		
		}
		if (status.contains("fail"))
			// featureLog.fail(statusMessage);
			// takeScreenShot(driver,
			// obj.getProperty("ScreenshotsPath")+screenshotName);
			featureLog.log(Status.FAIL, statusMessage);
	
		if (status.contains("info"))
			// takeScreenShot(driver,
			// obj.getProperty("ScreenshotsPath")+screenshotName);
			featureLog.log(Status.INFO, statusMessage);
	

		if (status.contains("warning"))
			// takeScreenShot(driver,
			// obj.getProperty("ScreenshotsPath")+screenshotName);
			featureLog.log(Status.WARNING, statusMessage);

		extent1.flush();

	}

	public void GenerateReport(String testName, Exception e, String status, String statusMessage) throws IOException {
		// scenario = feature.createNode(scenarioMessage);
		/*Properties obj = new Properties();
		try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			obj.load(resourceStream);
		}*/
		String screenShotPath = System.getProperty("user.dir") + "/" + autoProperties.getProperty("ScreenshotsPath");
		if (status.contains("exception")) { // featureLog.pass(statusMessage);
			featureLog.assignCategory(testName);
			// takeScreenShot(driver,
			// obj.getProperty("ScreenshotsPath")+screenshotName);
			System.out.println("Screeshots Path = " + reportPath);
		featureLog.fail(e);
		}
		
		extent1.flush();

	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception Ex) {
			return false;
		}
	}
	public boolean isAlertPresent2(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception Ex) {
			return false;
		}
	}
	
	public int fetchDataFromDB(String query) throws ClassNotFoundException, SQLException, IOException{
		List<String> val1 = new ArrayList<String>();
		int val = 0;

		/*queries.add(query1);
		queries.add(query2);
		queries.add(query3);
		queries.add(query4);
		queries.add(query5);
		queries.add(query6);*/
		CommonLibrary c = new CommonLibrary();
		Connection con = null;
		Statement stmt = null;
		String hostName = autoProperties.getProperty("HostName");
		String serviceName = autoProperties.getProperty("ServiceName");
		String dbUserName = autoProperties.getProperty("DBUserName");
		String dbPwd = autoProperties.getProperty("DBPwd");
		Class.forName(autoProperties.getProperty("JDBCDriver"));
		con = DriverManager.getConnection("jdbc:oracle:thin:@" + hostName + ":1521/" + serviceName, dbUserName, dbPwd);
		// step3 create the statement object
		stmt = con.createStatement();
		

			ResultSet rs = stmt.executeQuery(query);

			
				while (rs.next()) {
					
					System.out.println("Entered in while condition");
					
					System.out.println("rs : "+rs.getInt("count"));
					val = rs.getInt("count");
				}
					
		return val;

	}

	public final void prepareToPressEnterKey(int seconds, final int tabs) {
	    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
	    ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Runnable() {

	        public void run() {

	            try { 
	                Robot robot = new Robot();

	                for (int i=0; i<tabs; i++)
	                {
	                    robot.keyPress(KeyEvent.VK_TAB);
	                    TimeUnit.SECONDS.sleep(1);
	                    robot.keyRelease(KeyEvent.VK_TAB);		
	                    
	                }

	                robot.keyPress(KeyEvent.VK_ENTER);
	                TimeUnit.SECONDS.sleep(1); //press for 1 sec
	                robot.keyRelease(KeyEvent.VK_ENTER);
	            } catch (AWTException | InterruptedException e) {
	                System.out.println("Prepare to Press Enter Exception");
	            }
	        }
	    },
	            seconds,
	            TimeUnit.SECONDS);
	    scheduledExecutorService.shutdown();
	}
	public boolean isElementPresent(WebDriver driver, String xpath) {
		try {
			driver.findElement(By.xpath(xpath));

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/*@AfterClass
	public void teardown() {
		driver.quit();
	}*/
	public void waitForVisibilityOfWebElement(String locator, WebDriver driver){
		
		WebElement webElement=driver.findElement(By.xpath(locator));
		wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(webElement));

	}

}
