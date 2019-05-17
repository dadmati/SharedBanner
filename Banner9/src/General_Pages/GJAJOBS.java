package General_Pages ;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pom.Banner9Common.Banner9AppNavUrl;
import pom.Banner9Common.Banner9Browser;
import pom.Banner9Common.Banner9ExtentReport;
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

public class GJAJOBS {

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
	public void GJAJOBS(String Environment, String Browser, String OS) throws Exception {
		/*Banner9ExtentReport extentReport = PageFactory.initElements(driver, Banner9ExtentReport.class);
		extentReport.ExtentReport(Environment, OS, Browser);*/
		// Start QA reporting
		
		String Browsertype = Browser;
		String OStyoe = OS;

		// Configuration reader to pull variables and objects
		B9ConfigReader config = new B9ConfigReader();
	

		// Insert test steps here
		// Instantiates and creates test case name for report - need to enter in the name at the end
		Banner9ExtentReport extentR = new Banner9ExtentReport(extent, test);
		extentR.ExtentReport(Environment, OStyoe, Browsertype, "Banner 9 GJAJOBS Validation - ");
		extent=extentR.getExtent();
		test=extentR.getTest();		
		
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
		nav.navigateToPage("GJAJOBS");
		test.pass("Navigate to page passed");

		// adding 2 seconds wait to avoid Sync issue

		Thread.sleep(2000);

		// SWITCH TO IFRAME
		WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
		driver.switchTo().frame(driver.findElement(By.name("bannerHS")));

		// Thread.sleep(20000);

		// VERIFY TITLE IN IFRAME
		WebDriverWait waitpost = new WebDriverWait(driver, 120);
		waitpost.until(ExpectedConditions.titleContains("GJAJOBS"));

		//WebElement rightafterloginpositive = (new WebDriverWait(driver, 120)).until(
		//		ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/nav[5]/div/div[1]/ul/li[2]/h2")));
		//driver.findElement(By.xpath("html/body/nav[5]/div/div[1]/ul/li[2]/h2"));
				
		/*if (driver.findElements(By.xpath("//*[@class='ui-basic-mode'][contains(text(),'Basic Filter')]")).size() != 0) {
			//if present, do this
		    System.out.println("Banner Upgrade");
		} else {
			System.out.println("Old Banner");
		}*/
		
		//   <input type="text" id="frames9" class="ui-widget-content ui-corner-all selectInformation" autocomplete="off" aria-labelledby="l:frames9" dir="ltr" style="text-transform: uppercase;">
		//*[contains(@id, 'l:frames')][contains(text(),'Process')]/preceding-sibling::text[@class='ui-widget-content ui-corner-all selectInformation']
		
		//  
		//*[contains(@id, 'l:frames')][contains(text(),'Process')]//*[@class='ui-widget-content ui-corner-all selectInformation']
	
		//   .//*[@class='middleDivRow cloned'].//*[@class='ui-widget ui-textinput ui-hidelabel']//*[@class='ui-widget-content ui-corner-all selectInformation']
		
		//   <input type="text" id="frames9" class="ui-widget-content ui-corner-all selectInformation" autocomplete="off" aria-labelledby="l:frames9" dir="ltr" style="text-transform: uppercase;">
	

		//<input type="text" id="frames10" class="ui-widget-content ui-corner-all selectInformation" autocomplete="off" aria-labelledby="l:frames10" dir="ltr" style="text-transform: uppercase;">
		
		if (driver.findElements(By.xpath("//*[@class='ui-basic-mode'][contains(text(),'Basic Filter')]")).size() != 0) {
			//if present, do this
		    System.out.println("Banner Upgrade");
						WebDriverWait PROCESS = new WebDriverWait(driver, 180);
			PROCESS.until(ExpectedConditions.elementToBeClickable(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")));
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).click();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).clear();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("TEST");
			
			//TITLE
			//<input type="text" id="#frames73" class="ui-widget-content ui-corner-all selectInformation valid" aria-label="Text Entry Field" autocomplete="off" aria-labelledby="l:#frames73" dir="ltr" aria-invalid="false">
				WebDriverWait TITLE = new WebDriverWait(driver, 180);
			TITLE.until(ExpectedConditions.elementToBeClickable(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/input")));
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/input")).click();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/input")).clear();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/input")).sendKeys("TEST");
			
			//SYSTEM
			//<input type="text" id="#frames74" class="ui-widget-content selectInformation ui-buttoninput ui-corner-left valid" aria-label="Text Entry Field" autocomplete="off" aria-labelledby="l:#frames74" dir="ltr" style="text-transform: uppercase;" aria-invalid="false">
				WebDriverWait SYSTEM = new WebDriverWait(driver, 180);
			SYSTEM.until(ExpectedConditions.elementToBeClickable(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/input")));
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/input")).click();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/input")).clear();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[2]/div/input")).sendKeys("TEST");
			
			//DESCRIPTION
			//<input type="text" id="#frames75" class="ui-widget-content ui-corner-all selectInformation valid" aria-label="Text Entry Field" autocomplete="off" aria-labelledby="l:#frames75" dir="ltr" aria-invalid="false">
				WebDriverWait DESCRIPTION = new WebDriverWait(driver, 180);
			DESCRIPTION.until(ExpectedConditions.elementToBeClickable(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]/div/input")));
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]/div/input")).click();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]/div/input")).clear();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[4]/div/input")).sendKeys("TEST");
			
			//TYPE
			//<input type="text" id="frames76_ac" class="ui-autocomplete-input ui-widget-content ui-corner-left selectInformation valid" aria-haspopup="true" role="combobox" autocomplete="off" aria-autocomplete="list" aria-owns="autocomplete_frames76_ac" aria-invalid="false" style="">
				WebDriverWait TYPE = new WebDriverWait(driver, 180);
			TYPE.until(ExpectedConditions.elementToBeClickable(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[5]/div/input")));
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[5]/div/input")).click();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[5]/div/input")).clear();
			driver.findElement(By.xpath(".//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[5]/div/input")).sendKeys("TEST");
						
		} else {
			System.out.println("Old Banner");
			WebDriverWait filter = new WebDriverWait(driver, 180);
			filter.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ui-corner-all selectFilter fieldSelect']")));
			driver.findElement(By.xpath(".//*[@class='ui-corner-all selectFilter fieldSelect']")).click();
			
			// click other dropdown
			WebDriverWait waitemptabz = new WebDriverWait(driver, 120);
			waitemptabz.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"/html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div/select/option[2]")));
			driver.findElement(By
					.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div/select/option[2]"))
					.click();


			Thread.sleep(3000);
		

			// enter in text
			WebElement rightafterloginpositive2 = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
							"html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")));
			driver.findElement(By
					.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input"))
					.sendKeys("TEST");

			Thread.sleep(3000);
			// click process
			WebDriverWait waitemptab23 = new WebDriverWait(driver, 120);
			waitemptab23.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[3]/span/button[2]")));
			driver.findElement(By
					.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[3]/span/button[2]"))
					.click();

			// STORE RANDOM LASTNAME VALUE ENTERED IN LASTNAME FIELD FOR LATER
			// VERIFICATION
			// test.info( "Store random lastname value entered in lastname field for
			// later verification");
			WebDriverWait waitemptab239 = new WebDriverWait(driver, 120);
			waitemptab239.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[2]/div/div[1]/div[4]/div[3]/div/div/div[1]/input")));

			String processfield = driver
					.findElement(By
							.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[2]/div/div[1]/div[4]/div[3]/div/div/div[1]/input"))
					.getAttribute("value");
			// test.info( "lastname = " + lastnamevar);
			System.out.println("processfield = " + processfield);

			Thread.sleep(3000);
			assertEquals(processfield, "TEST");

			Thread.sleep(5000);

			test.info("Click signout");
			 signout signout = PageFactory.initElements(driver, signout.class);
			 signout.signOut();
			 test.pass("Click signout passed");			
		
		}

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
