package General_Pages;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pom.Banner9Common.Banner9AppNavUrl;
import pom.Banner9Common.signout;

import java.util.concurrent.TimeUnit;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.ini4j.Config;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.lang.String;
import java.net.URL;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import com.thoughtworks.selenium.webdriven.commands.Click;

import Banner9Utility.B9ConfigReader;
import Banner9Utility.B9ExtentManager;
import Banner9Utility.ReadExcelFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.seleniumhq.jetty7.util.log.Log;
import java.util.UUID;
import commonfunctions.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/*
*    Test case name: AppCentralTerramarkLoopTest
*    Description: Validates the urls from a spreadsheet are loading properly
*    Data Input: Excel data inputs and hard coded data inputs
* 
 */

public class PEAEMPL {

	// ExtentReports extent;
	// ExtentTest test;

	ExtentReports extent;
	ExtentTest test;
	String sRandStr = RandomStringUtils.randomAlphabetic(5);
	String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(Calendar.getInstance().getTime());
	// private RemoteWebDriver driver;
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	/*
	 * public static void main(String args[]) throws BiffException, IOException
	 * { ReadExcelFile DT = new ReadExcelFile(); DT.readExcel(); }
	 */
	@Parameters({ "Browser", "OS" })
	@BeforeClass

	public void setUp(String Browser, String OS) throws Exception {
		// extent = B9ExtentManager.Instance();
		extent = B9ExtentManager.GetExtent();
		B9ConfigReader config = new B9ConfigReader();

		String Browsertype = Browser;

		if (Browser.equalsIgnoreCase("Chrome")) {

			DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
			Capabilities.setCapability("acceptSslCerts", "true");

			if (OS.equalsIgnoreCase("Win7")) {
				Capabilities.setPlatform(Platform.VISTA);
			} else if (OS.equalsIgnoreCase("Win81")) {
				Capabilities.setPlatform(Platform.WIN8_1);
			} else if (OS.equalsIgnoreCase("Win10")) {
				Capabilities.setPlatform(Platform.WIN10);
			} else {
			}

			driver = new RemoteWebDriver(new URL(config.getHUBURL()), Capabilities);

		} else if (Browser.equalsIgnoreCase("IE")) {

			// Internet Explorer
			DesiredCapabilities Capabilities = DesiredCapabilities.internetExplorer();
			Capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			Capabilities.setCapability("ensureCleanSession", true);
			Capabilities.setCapability("ignoreZoomSetting", true);
			Capabilities.setCapability("ignoreProtectedModeSettings", true);
			Capabilities.setCapability("ignore-certificate-error", true);
			Capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			if (OS.equalsIgnoreCase("Win7")) {
				Capabilities.setPlatform(Platform.VISTA);
			} else if (OS.equalsIgnoreCase("Win81")) {
				Capabilities.setPlatform(Platform.WIN8_1);
			} else if (OS.equalsIgnoreCase("Win10")) {
				Capabilities.setPlatform(Platform.WIN10);
			} else {
			}

			driver = new RemoteWebDriver(new URL(config.getHUBURL()), Capabilities);

		} else if (Browser.equalsIgnoreCase("FF")) {

			// Firefox
			DesiredCapabilities Capabilities = DesiredCapabilities.firefox();
			Capabilities.setCapability("marionette", true);

			if (OS.equalsIgnoreCase("Win7")) {
				Capabilities.setPlatform(Platform.VISTA);
			} else if (OS.equalsIgnoreCase("Win81")) {
				Capabilities.setPlatform(Platform.WIN8_1);
			} else if (OS.equalsIgnoreCase("Win10")) {
				Capabilities.setPlatform(Platform.WIN10);
			} else {
			}
			driver = new RemoteWebDriver(new URL(config.getHUBURL()), Capabilities);

			// System.setProperty("webdriver.gecko.driver",
			// config.getFFDriver());
			// driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("Local")) {
			// Chrome
			System.setProperty("webdriver.chrome.driver", config.getChromeDriver());
			driver = new ChromeDriver();

		} else {
		}

	}

	@Parameters({ "Environment", "Browser", "OS" })
	@Test

	// Make sure to name your test below
	public void TEST_NAME(String Environment, String Browser, String OS) throws Exception {

		// Start QA reporting
		extent = B9ExtentManager.GetExtent();

		String Browsertype = Browser;
		String OStyoe = OS;

		// Configuration reader to pull variables and objects
		B9ConfigReader config = new B9ConfigReader();

		if (Environment.equalsIgnoreCase("Dev")) {

			test = extent.createTest("Banner 9 PEAEMPL Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Dev Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Test")) {

			test = extent.createTest("Banner 9 PEAEMPL Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Test Environment: " + timeStamp);

		} else if (Environment.equalsIgnoreCase("Stage")) {

			test = extent.createTest("Banner 9 PEAEMPL Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Stage Environment: " + timeStamp);

		} else {
		}

		// Insert test steps here

		test.info("Step 1 Open Banner 9 URL");
		Banner9AppNavUrl url = PageFactory.initElements(driver, Banner9AppNavUrl.class);
		url.ChooseURL(Environment, Browsertype, OStyoe);
		test.pass("Step 1 Open Banner 9 URL passed");

		// ---START TEST

		// driver.get("https://banner.nova.edu/applicationNavigator");
		// driver.get("https://bannerdev.nova.edu/applicationNavigator/seamless");
		test.info("Enter username");
		WebElement username1 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'username')]")));
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).clear();
		test.pass("Enter username passed");

		test.info("Enter username");
		WebElement username2 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@name,'username')]")));
		//driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys(config.getB9QAUSERNAME());
		driver.findElement(By.xpath("//input[contains(@name,'username')]")).sendKeys("dadmati");
		test.pass("Enter username passed");

		test.info("Enter username");
		WebElement password1 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'password')]")));
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).clear();
		test.pass("Enter username passed");

		test.info("Enter username");
		WebElement password2 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'password')]")));
		// driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Nova_1234");
		//driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys(config.getB9QAPASSWORD());
		driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Sharks2020");
		test.pass("Enter username passed");
		WebDriverWait login = new WebDriverWait(driver, 60);
		login.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='submitform']")));
		driver.findElement(By.xpath(".//*[@id='submitform']")).click();

		test.info("Confirm title");
		WebElement welcome = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'welcome ng-binding')]")));
		driver.findElement(By.xpath("//div[contains(@class,'welcome ng-binding')]"));
		test.pass("Confirm title passed");

		test.info("Confirm title");
		WebElement title = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[contains(.,'Nova Southeastern UniversityReturn Home')]")));
		// driver.findElement(By.xpath("//a[contains(@title,'Nova Southeastern
		// University')]"));
		driver.findElement(By.xpath("//a[contains(.,'Nova Southeastern UniversityReturn Home')]"));
		test.pass("Confirm title passed");



		test.info("Search for PEAEMPL");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search...')]")).clear();

		driver.findElement(By.xpath("//input[contains(@placeholder,'Search...')]")).sendKeys("PEAEMPL");
		test.pass("Search for PEAEMPL passed");
		Thread.sleep(5000);

		test.info("Click PEAEMPL");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search...')]")).sendKeys(Keys.ENTER);
		test.pass("Click PEAEMPL passed");
		// adding 2 seconds wait to avoid Sync issue

		Thread.sleep(2000);



		// SWITCH TO IFRAME
		WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
		driver.switchTo().frame(driver.findElement(By.name("bannerHS")));



		// Thread.sleep(20000);

		// VERIFY TITLE IN IFRAME
		WebDriverWait waitpost = new WebDriverWait(driver, 30);
		waitpost.until(ExpectedConditions.titleContains("PEAEMPL"));

		WebElement NSUIDFIELD = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#id']")));
		driver.findElement(By.xpath("//*[@id='#id']")).clear();
		
		WebElement NSUIDFIELD2 = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#id']")));
		driver.findElement(By.xpath("//*[@id='#id']")).sendKeys("N01855655");

		// click process
		WebDriverWait waitemptab3 = new WebDriverWait(driver, 30);
		waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//*[@id='frames6']")));
		driver.findElement(By
				.xpath("//*[@id='frames6']"))
				.click();

		Thread.sleep(3000);
		
		//Employee status field
		//*[@id="page_pebempl_pebemplEmplStatus_ac"]
		
		//Employee class
		WebElement empclass = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplEclsCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplEclsCode']")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='#pebemplEclsCode']")).sendKeys("30");
		//*[@id="#pebemplEclsCode"]
		
		
		//Confirm value
	    //Employee group
		//*[@id="#pebemplEgrpCode"]
		WebElement a = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplEgrpCode']")));
		
		test.info("Store lastname");
		String empgroup=driver.findElement(By.xpath("//*[@id='#pebemplEgrpCode']")).getAttribute("value"); 
		test.pass("Store email passed");
		
		test.info("Confirm email matches in Banner 9 SPAIDEN from what was submitted");
		Assert.assertEquals("1010", empgroup);
		test.pass("Confirm email matches in Banner 9 SPAIDEN from what was submitted passed");
		test.pass("Store lastname passed");
		
		//Confirm value
		//Leave category
		//*[@id="#pebemplLcatCode"]
		WebElement b = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplLcatCode']")));
		
		test.info("Store lastname");
		String empvalue=driver.findElement(By.xpath("//*[@id='#pebemplLcatCode']")).getAttribute("value"); 
		test.pass("Store email passed");
		
		test.info("Confirm email matches in Banner 9 SPAIDEN from what was submitted");
		Assert.assertEquals("02", empvalue);
		test.pass("Confirm email matches in Banner 9 SPAIDEN from what was submitted passed");
		test.pass("Store lastname passed");
		
		//Confirm value
		//Benefit category
		//*[@id='#pebemplBcatCo']
		//*[@id="#pebemplBcatCode"]
		WebElement c = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplBcatCode']")));
		
		test.info("Store lastname");
		String bencat=driver.findElement(By.xpath("//*[@id='#pebemplBcatCode']")).getAttribute("value"); 
		test.pass("Store email passed");
		
		test.info("Confirm email matches in Banner 9 SPAIDEN from what was submitted");
		Assert.assertEquals("01", bencat);
		test.pass("Confirm email matches in Banner 9 SPAIDEN from what was submitted passed");
		test.pass("Store lastname passed");
		
		
		//Confirm value
		//Part time or full time
		//*[@id='page_pebempl_pebemplInternalFtPtInd_ac']
		WebElement d = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='page_pebempl_pebemplInternalFtPtInd_ac']")));
		
		test.info("Store lastname");
		String partfull=driver.findElement(By.xpath("//*[@id='page_pebempl_pebemplInternalFtPtInd_ac']")).getAttribute("value"); 
		test.pass("Store email passed");
		
		test.info("Confirm email matches in Banner 9 SPAIDEN from what was submitted");
		Assert.assertEquals("Full Time", partfull);
		test.pass("Confirm email matches in Banner 9 SPAIDEN from what was submitted passed");
		test.pass("Store lastname passed");
		
		//Allow new hire checkbox
		//*[@id="#pebemplNewHireInd_btn"]
		
		//Home department
		//*[@id="#pebemplCoasCodeHome"]
		
		//Check disbursement
		//*[@id="#pebemplCoasCodeDist"]
		
		//Employee district
		//*[@id="#pebemplDicdCode"]
		
		//Organization1
		//*[@id="#pebemplOrgnCodeHome"]
		
		//Organization2
		//*[@id="#pebemplOrgnCodeDist"]
		
		//Service dates current hire
		//*[@id="page_pebempl_pebemplCurrentHireDate1527291182032"]
		
		//Service dates orgiginal hire
		//*[@id="page_pebempl_pebemplFirstHireDate1527291182071"]
		
		//Seervice dates original service
		//*[@id="page_pebempl_pebemplAdjServiceDate1527291182111"]
		
		//Service dates seniority
		//*[@id="page_pebempl_pebemplSeniorityDate1527291182054"]
		
		//Service dates first date worked
		//*[@id="page_pebempl_pebemplFirstWorkDate1527291182094"]
		
		//Service dates last worked
		//*[@id="page_pebempl_pebemplLastWorkDate1527291182131"]
		
		//lEAVE OF ABSENSE REASON
		//*[@id="#pebemplTreaCode"]
		
		//Termiknation date
		//*[@id="page_pebempl_pebemplTermDate1527291182248"]
		
		//Leave of absense reason
		//*[@id="#pebemplLreaCode"]
		
		//Leave of absense begin date
		//*[@id="page_pebempl_pebemplLoaBegDate1527291182347"]
		
		// leave of absense end date
		//*[@id="page_pebempl_pebemplLoaEndDate1527291182325"]
		
		//Hiring location
		//*[@id='#pebemplJblnCode']
		WebElement empclass2 = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplJblnCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplJblnCode']")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='#pebemplJblnCode']")).sendKeys("01ADMS");
		
		
		//HIring location college
		//*[@id='#pebemplCollCode']
		WebElement empclass3 = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplCollCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplCollCode']")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='#pebemplCollCode']")).sendKeys("99");
		
		//Hiring location campus
		//*[@id="#pebemplCampCode"]
		WebElement empclass4 = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplCampCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplCampCode']")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='#pebemplCampCode']")).sendKeys("101");
		

		Thread.sleep(5000);

		test.info("Click signout");
		 signout signout = PageFactory.initElements(driver, signout.class);
		 signout.signOut();
		 test.pass("Click signout passed");	
		// driver.close();

		// --END TEST

	}

	@AfterMethod
	// Captures test execution information to pass through in next step
	public void getResult(ITestResult result) throws IOException {
		// Captures screenshot from failed test case and inserts into test
		// result report
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshotPath = GetScreenshot.capture(driver, result.getMethod().getMethodName() + "_" + "failure");
			test.fail(result.getThrowable());
			test.fail("screenshot below: " + test.addScreenCaptureFromPath(screenshotPath));
		}

	}
	@AfterClass

	public void tearDown() throws Exception {

		{
			// Closes out QA test execution reporting for test case
			// extent.endTest(test);
			extent.flush();
			// extent.close();
			// driver.manage().deleteAllCookies();
			driver.quit();
		}

		// Closes browser
		// driver.quit();

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
