package General_Pages;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pom.Banner9Common.Banner9AppNavUrl;
import pom.Banner9Common.Banner9Browser;
import pom.Banner9Common.NavigateToPage;
import pom.Banner9Common.login;
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

public class GTVFSTA {

	// ExtentReports extent;
	// ExtentTest test;

	ExtentReports extent;
	ExtentTest test;
	String sRandStr = RandomStringUtils.randomAlphabetic(5);
	String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(Calendar.getInstance().getTime());
	// private RemoteWebDriver driver;
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	
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

			test = extent.createTest("Banner 9 GTVFSTA Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Dev Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Test")) {

			test = extent.createTest("Banner 9 GTVFSTA Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Test Environment: " + timeStamp);

		} else if (Environment.equalsIgnoreCase("Stage")) {

			test = extent.createTest("Banner 9 GTVFSTA Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Stage Environment: " + timeStamp);

		} else {
		}

		// Insert test steps here
		
			
		//Instantiates Webdriver and Browser
		BrowserManagement browser = PageFactory.initElements(driver, BrowserManagement.class);
		browser.ChooseBrowser(Browsertype, OS);
		driver = browser.driver;	

		test.info("Step 1 Open Banner 9 URL");
		Banner9AppNavUrl url = PageFactory.initElements(driver, Banner9AppNavUrl.class);
		url.ChooseURL(Environment, Browsertype, OStyoe);
		test.pass("Step 1 Open Banner 9 URL passed");

		// ---START TEST
		test.info("Log into Banner 9");
		login log = PageFactory.initElements(driver, login.class);
		log.login_Eis_Banner_Direct_link(config.getQAUSERNAME(), config.getQAPASSWORD());
		test.pass("Log into Banner 9 passed");
		
		test.info("Navigate to page");
		NavigateToPage nav = PageFactory.initElements(driver, NavigateToPage.class);
		nav.navigateToPage("GTVFSTA");
		test.pass("Navigate to page passed");

		// adding 2 seconds wait to avoid Sync issue

		Thread.sleep(2000);

		// Dropdown items are coming in <a> tag so below xpath will get all

		// elements and findElements will return list of WebElements

		// SWITCH TO IFRAME
				WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
				driver.switchTo().frame(driver.findElement(By.name("bannerHS")));

				// driver.switchTo().frame(driver.findElement(By.name("frames4")));

				// Thread.sleep(20000);

				// VERIFY TITLE IN IFRAME
				WebDriverWait waitpost = new WebDriverWait(driver, 30);
				waitpost.until(ExpectedConditions.titleContains("GTVFSTA"));
				
				Thread.sleep(5000);
				
				//driver.findElement(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p")
					
		/*			if (driver.findElements(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p")).size() != 0) {
						org.junit.Assert.fail("Error invalid form name entered");
						} else {
						
					}
				
				
				
				WebElement rightafterloginpositive = (new WebDriverWait(driver, 30)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav[5]/div/div[1]/ul/li[2]/h2")));
				driver.findElement(By.xpath("/html/body/nav[5]/div/div[1]/ul/li[2]/h2"));*/
				
				//Click filter
			    WebDriverWait clickfilter = new WebDriverWait(driver, 30);
			    clickfilter.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grdGtvfsta']/div/div[2]/ul/li[7]/a/span")));
				driver.findElement(By.xpath("//*[@id='grdGtvfsta']/div/div[2]/ul/li[7]/a/span")).click();
				
				Thread.sleep(5000);
				
				if (driver.findElements(By.xpath("//*[@class='ui-basic-mode'][contains(text(),'Basic Filter')]")).size() != 0) {
					//if present, do this
				    System.out.println("Banner Upgrade");
				  //Type web in field
					   WebDriverWait typeweb = new WebDriverWait(driver, 30);
					    typeweb.until(ExpectedConditions.elementToBeClickable(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")));
						driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).clear();
						Thread.sleep(3000);
						driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("C");
					
					//Click go
					WebDriverWait waitemptab3 = new WebDriverWait(driver, 30);
					//waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frames65']")));
					waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='primary-button ui-buttonGo'][contains(text(),'Go')]")));
					driver.findElement(By.xpath(".//*[@class='primary-button ui-buttonGo'][contains(text(),'Go')]")).click();				
					
					//Confirm WEB in field 1
					WebDriverWait f1 = new WebDriverWait(driver, 30);
				
					//waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frames65']")));
					//f1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='editor-text ui-state-readonly mode-edit'][contains(text(),'DON')]")));
					f1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='editor-text mode-edit']")));
					driver.findElement(By.xpath(".//*[@class='editor-text mode-edit']")).click();
					driver.findElement(By.xpath(".//*[@class='editor-text mode-edit']")).sendKeys(Keys.TAB);
					
					
					
					//Confirm Web Application Email Address in field 1
					WebDriverWait f2 = new WebDriverWait(driver, 30);
					//waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frames65']")));
					//f2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='editor-text mode-edit'][contains(text(),'Donations')]")));
					f2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='editor-text mode-edit']")));
					driver.findElement(By.xpath(".//*[@class='editor-text mode-edit']")).click();
			
			Thread.sleep(5000);
				} else {
					System.out.println("Old Banner");
					//Click add another field
				    WebDriverWait clickaddanotherfield = new WebDriverWait(driver, 30);
				    clickaddanotherfield.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grdGtvfsta_content']/div[1]/div/div[2]/div/select")));
					driver.findElement(By.xpath("//*[@id='grdGtvfsta_content']/div[1]/div/div[2]/div/select")).click();
					
					//Click code
				    WebDriverWait clickweb = new WebDriverWait(driver, 30);
				    clickweb.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grdGtvfsta_content']/div[1]/div/div[2]/div/select/option[2]")));
					driver.findElement(By.xpath("//*[@id='grdGtvfsta_content']/div[1]/div/div[2]/div/select/option[2]")).click();
					
					//Type web in field
					   WebDriverWait typeweb = new WebDriverWait(driver, 30);
					    typeweb.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ui-widget-content ui-corner-all selectInformation']")));
						driver.findElement(By.xpath(".//*[@class='ui-widget-content ui-corner-all selectInformation']")).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath(".//*[@class='ui-widget-content ui-corner-all selectInformation']")).clear();
						Thread.sleep(3000);
						driver.findElement(By.xpath(".//*[@class='ui-widget-content ui-corner-all selectInformation']")).sendKeys("C");
					
					//Click go
					WebDriverWait waitemptab3 = new WebDriverWait(driver, 30);
					//waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frames65']")));
					waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='primary-button ui-buttonGo'][contains(text(),'Go')]")));
					driver.findElement(By.xpath(".//*[@class='primary-button ui-buttonGo'][contains(text(),'Go')]")).click();				
					
					//Confirm WEB in field 1
					WebDriverWait f1 = new WebDriverWait(driver, 30);
				
					//waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frames65']")));
					//f1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='editor-text ui-state-readonly mode-edit'][contains(text(),'DON')]")));
					f1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='editor-text mode-edit']")));
					driver.findElement(By.xpath(".//*[@class='editor-text mode-edit']")).click();
					driver.findElement(By.xpath(".//*[@class='editor-text mode-edit']")).sendKeys(Keys.TAB);
					
					
					
					//Confirm Web Application Email Address in field 1
					WebDriverWait f2 = new WebDriverWait(driver, 30);
					//waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='frames65']")));
					//f2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='editor-text mode-edit'][contains(text(),'Donations')]")));
					f2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='editor-text mode-edit']")));
					driver.findElement(By.xpath(".//*[@class='editor-text mode-edit']")).click();
			
			Thread.sleep(5000);
			
			test.info("Click signout");
			 signout signout = PageFactory.initElements(driver, signout.class);
			 signout.signOut();
			 test.pass("Click signout passed");	
				}
				
				
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
