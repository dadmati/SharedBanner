package General_Pages;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pom.Banner9Common.Banner9AppNavUrl;
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

public class GTVEMPH {

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

			test = extent.createTest("Banner 9 GTVEMPH Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Dev Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Test")) {

			test = extent.createTest("Banner 9 GTVEMPH Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Test Environment: " + timeStamp);

		} else if (Environment.equalsIgnoreCase("Stage")) {

			test = extent.createTest("Banner 9 GTVEMPH Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Stage Environment: " + timeStamp);

		} else {
		}

		// Insert test steps here

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
		nav.navigateToPage("GTVEMPH");
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
				waitpost.until(ExpectedConditions.titleContains("GTVEMPH"));
				
				Thread.sleep(5000);
				
				//driver.findElement(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p")
					
					if (driver.findElements(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p")).size() != 0) {
						org.junit.Assert.fail("Error invalid form name entered");
						} else {
						
					}
				
				
				
				/*WebElement rightafterloginpositive = (new WebDriverWait(driver, 30)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav[5]/div/div[1]/ul/li[2]/h2")));
				driver.findElement(By.xpath("/html/body/nav[5]/div/div[1]/ul/li[2]/h2"));*/
				
				
				//Click filter
				WebDriverWait filter = new WebDriverWait(driver, 180);
				filter.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='hidden-xs'][contains(text(),'Filter')]")));
				driver.findElement(By.xpath(".//*[@class='hidden-xs'][contains(text(),'Filter')]")).click();
				
				Thread.sleep(5000);
				
				if (driver.findElements(By.xpath("//*[@class='ui-basic-mode'][contains(text(),'Basic Filter')]")).size() != 0) {
					//if present, do this
				    System.out.println("Banner Upgrade");
				} else {
					System.out.println("Old Banner");
					Thread.sleep(3000);

					//Click ADD FIELD
					WebDriverWait adfield = new WebDriverWait(driver, 180);
					adfield.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ui-corner-all selectFilter fieldSelect']")));
					driver.findElement(By.xpath(".//*[@class='ui-corner-all selectFilter fieldSelect']")).click();
					
					Thread.sleep(3000);
					
					//Click code 
					//Changed from class to value
					WebDriverWait code = new WebDriverWait(driver, 180);
					code.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@value='GTVEMPH_CODE']")));
					driver.findElement(By.xpath(".//*[@value='GTVEMPH_CODE']")).click();
					//*[@id="grdGtvemph_content"]/div[1]/div/div[2]/div/select/option[2]
					//<option value="GTVEMPH_CODE" data-order="0" data-editor="textinput" data-type="String" data-eventdoubleclick="WHEN-MOUSE-DOUBLECLICK" data-required="true" data-case="upper" data-maxlength="10" data-headertooltip="" data-autoskip="true">Code</option>
					Thread.sleep(3000);
					/*//NEW CODE
						WebDriverWait addtab = new WebDriverWait(driver, 180);
						addtab.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grdGtvemph']/div/div[2]/ul/li[7]/a/span")));
						driver.findElement(By.xpath("//div[@id='grdGtvemph']/div/div[2]/ul/li[7]/a/span")).click();
						
						WebDriverWait addtab2 = new WebDriverWait(driver, 180);
						addtab2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grdGtvemph_content']/div/div/div[2]/div/select")));
					    driver.findElement(By.xpath("//div[@id='grdGtvemph_content']/div/div/div[2]/div/select")).click();
					    
					    //new Select(driver.findElement(By.xpath("//div[@id='grdGtvemph_content']/div/div/div[2]/div[2]/select"))).selectByVisibleText("Add Another Field ...");
					    
					    WebDriverWait addtab2b = new WebDriverWait(driver, 180);
						addtab2b.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='grdGtvemph_content']/div[1]/div/div[2]/div/select/option[2]")));
					    driver.findElement(By.xpath("//*[@id='grdGtvemph_content']/div[1]/div/div[2]/div/select/option[2]")).click();*/
					  
					    
					   
					    WebDriverWait addtab3a = new WebDriverWait(driver, 180);
						addtab3a.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")));
					    driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).click();
					    
					    
					    driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).clear();
					    driver.findElement(By.xpath("//html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/div/div[1]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("STAFF");
					    
						WebDriverWait addtab3 = new WebDriverWait(driver, 180);
						addtab3.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='grdGtvemph_content']/div/div/div[3]/span/button[2]")));
					    driver.findElement(By.xpath("//div[@id='grdGtvemph_content']/div/div/div[3]/span/button[2]")).click();
					    
						WebDriverWait addtab4 = new WebDriverWait(driver, 180);
						addtab4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='STAFF']")));
					    driver.findElement(By.xpath("//input[@value='STAFF']")).click();
					    driver.findElement(By.xpath("//input[@value='STAFF']")).sendKeys(Keys.TAB);
					    
					    
					    
					    
						/*WebDriverWait addtab5 = new WebDriverWait(driver, 180);
						addtab5.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='frames42']/div[4]/div[3]/div/div/div[2]/div")));
					    driver.findElement(By.xpath("//div[@id='frames42']/div[4]/div[3]/div/div/div[2]/div")).click();
					    */
						WebDriverWait addtab6 = new WebDriverWait(driver, 180);
						addtab6.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Staff Training']")));
					    driver.findElement(By.xpath("//input[@value='Staff Training']")).click();
					//NEW CODE
					
			
			Thread.sleep(5000);
			
			test.info("Click signout");
			 signout signout = PageFactory.initElements(driver, signout.class);
			 signout.signOut();
			 test.pass("Click signout passed");	
			// driver.close();
				}
				
				

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
