package General_Pages;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pom.Banner9Common.Banner9AppNavUrl;
import pom.Banner9Common.Banner9CommonEnterNSUID;
import pom.Banner9Common.Banner9CommonGo;
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

public class GOAMEDI {

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

			test = extent.createTest("Banner 9 GOAMEDI Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Dev Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Test")) {

			test = extent.createTest("Banner 9 GOAMEDI Validation - " + Browsertype + "-" + OStyoe + " - "
					+ "Test Environment: " + timeStamp);

		} else if (Environment.equalsIgnoreCase("Stage")) {

			test = extent.createTest("Banner 9 GOAMEDI Validation - " + Browsertype + "-" + OStyoe + " - "
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
		nav.navigateToPage("GOAMEDI");
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
				waitpost.until(ExpectedConditions.titleContains("GOAMEDI"));
				
				Thread.sleep(5000);
				
			/*	WebElement rightafterloginpositive = (new WebDriverWait(driver, 30)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav[5]/div/div[1]/ul/li[2]/h2")));
				driver.findElement(By.xpath("/html/body/nav[5]/div/div[1]/ul/li[2]/h2"));
				
				
				WebElement rightafterloginpositive2 = (new WebDriverWait(driver, 30)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:id']")));
				driver.findElement(By.xpath("//*[@id='inp:id']")).sendKeys("N01855654");
				
				Thread.sleep(5000);
				
				//*[@id="frames7"]
				WebDriverWait waitemptab3 = new WebDriverWait(driver, 30);
				waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/button[1]")));
				driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/button[1]")).click();*/
				
				test.info("Search by NSUID");
		        Banner9CommonEnterNSUID enterNSUID = PageFactory.initElements(driver, Banner9CommonEnterNSUID.class);
		        enterNSUID.enterNSUID("N01855654");
		        test.pass("Search by NSUID passed");
			
			
	
			
			
			Thread.sleep(5000);
			
			
			//*[@id="frames7"]
		/*	WebDriverWait waitemptab3 = new WebDriverWait(driver, 30);
			waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/button[1]")));
			driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/button[1]")).click();
			*/
			 // Click go
	        test.info("Click go");
	        Banner9CommonGo clickGo = PageFactory.initElements(driver, Banner9CommonGo.class);
	        clickGo.clickGo();
	        test.pass("Click go passed");
			test.pass("Search by NSUID passed");
				
				
				Thread.sleep(5000);
				
				
				
				/*WebElement rightafterloginpositiveZ = (new WebDriverWait(driver, 30)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p")));
				driver.findElement(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p"));
		
		Thread.sleep(5000);*/
	

		//MEDICAL CODE
		WebDriverWait medcode = new WebDriverWait(driver, 30);
		medcode.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inp:sprmediMediCode_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediMediCode_0']")).click();
		
		
		WebElement medcode2 = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='inp:sprmediMediCode_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediMediCode_0']")).sendKeys("HC");

		//MEDICAL DATE SET TO TODAY
		WebDriverWait meddate = new WebDriverWait(driver, 30);
		meddate.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[starts-with(@id,'sprmediMediCodeDate_')]")));
		driver.findElement(By.xpath("//input[starts-with(@id,'sprmediMediCodeDate_')]")).click();
		
		Thread.sleep(5000);
		
		WebElement meddate2 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//input[starts-with(@id,'sprmediMediCodeDate_')]")));
		driver.findElement(By.xpath("//input[starts-with(@id,'sprmediMediCodeDate_')]")).sendKeys("06/02/2018");
	

		/*//CLICK CALENDAR BUTTON
		.//*[@id='sprmediMediCodeDate_0']/button


		//TODAY'S DATE
		.//*[@id='multiCalendar1']/div/div[1]/a[2]
*/

		
		WebDriverWait distype = new WebDriverWait(driver, 30);
		distype.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inp:sprmediDisaCode_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediDisaCode_0']")).click();
		
		WebElement distype2 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='inp:sprmediDisaCode_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediDisaCode_0']")).sendKeys("08");
		//DISABILIUTY TYPE
		

		WebDriverWait disage = new WebDriverWait(driver, 30);
		disage.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inp:sprmediOnsetAge_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediOnsetAge_0']")).click();
		
		WebElement disage2 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='inp:sprmediOnsetAge_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediOnsetAge_0']")).sendKeys("50");
		//DISABILITY ONSET AGE
		

		WebDriverWait disprim = new WebDriverWait(driver, 30);
		disprim.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inp:sprmediDisbInd_0_btn']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediDisbInd_0_btn']")).click();
		//CLICK PRIMARY DISABILITY
		

		WebDriverWait equipcode = new WebDriverWait(driver, 30);
		equipcode.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inp:sprmediMdeqCode_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediMdeqCode_0']")).click();
		
		WebElement equipcode2 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='inp:sprmediMdeqCode_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediMdeqCode_0']")).sendKeys("WHE");
		//EQUIPMENT CODE
		
		WebDriverWait disservice = new WebDriverWait(driver, 30);
		disservice.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inp:sprmediSpsrCode_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediSpsrCode_0']")).click();
		
		WebElement disservice2 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='inp:sprmediSpsrCode_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediSpsrCode_0']")).sendKeys("DR");
		//DISABILITY SERVICE
		

		WebDriverWait comment = new WebDriverWait(driver, 30);
		comment.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inp:sprmediComment_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediComment_0']")).click();
		
		WebElement comment2 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='inp:sprmediComment_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediComment_0']")).sendKeys("This is a test.");
		//WRITE A COMMENT
		

		WebDriverWait click = new WebDriverWait(driver, 30);
		click.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/div[3]/div/div/div[2]/div/div/div[2]/ul/li[1]/a/span")));
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/div[3]/div/div/div[2]/div/div/div[2]/ul/li[1]/a/span")).click();
		
		//CLICK INSERT
		

		WebDriverWait back = new WebDriverWait(driver, 30);
		back.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/div[3]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/span[1]/span/span[2]/span")));
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/div[3]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/span[1]/span/span[2]/span")).click();
		
		//CLICK LEFT ARROW TO GO BACK
		
		WebDriverWait del = new WebDriverWait(driver, 30);
		del.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/div[3]/div/div/div[2]/div/div/div[2]/ul/li[2]/a/span")));
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/form/div[3]/div/div/div[2]/div/div/div[2]/ul/li[2]/a/span")).click();
		
		//CLICK DELETE BUTTON
		

		//CONFIRM THAT ALL FIELDS ARE NOW BLANK

		/*WebDriverWait contrlq = new WebDriverWait(driver, 60);
		contrlq.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='inp:sprmediComment_0']")));
		driver.findElement(By.xpath(".//*[@id='inp:sprmediComment_0']")).sendKeys(Keys.chord(Keys.CONTROL, "Q"));
		*/
		//PRESS CONTROL+Q TO CLOSE OUT THE FORM AND CONFIRM YOU ARE BACK AT APPLICATION NAVIGATOR SEARCH


		// driver.close();
		
		test.info("Click signout");
		 signout signout = PageFactory.initElements(driver, signout.class);
		 signout.signOut();
		 test.pass("Click signout passed");			
	

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
