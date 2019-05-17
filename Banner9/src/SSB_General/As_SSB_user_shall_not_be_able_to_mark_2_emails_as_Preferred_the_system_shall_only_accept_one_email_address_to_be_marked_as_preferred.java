package SSB_General;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pom.Banner9Common.Banner9AppNavUrl;
import pom.Banner9Common.Banner9Browser;
import pom.Banner9Common.Banner9CommonBypassApprovals;
import pom.Banner9Common.Banner9CommonCopy;
import pom.Banner9Common.Banner9CommonFilter;
import pom.Banner9Common.Banner9CommonGo;
import pom.Banner9Common.Banner9CommonRelated;
import pom.Banner9Common.Banner9CommonSave;
import pom.Banner9Common.Banner9ExtentReport;
import pom.Banner9Common.NavigateToPage;
import pom.Banner9Common.login;
import pom.Banner9Common.signout;
import pom.Banner9SSBCommon.Banner9SSBEditInfo;
import pom.Banner9SSBCommon.Banner9SSBSignOut;
import pom.Banner9SSBCommon.Banner9SSBUrl;
import pom.Banner9SSBCommon.Banner9SSBVerifyPersonalInfo;
import pom.Banner9SSBCommon.Banner9SSBWaitForLoading;

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
import org.testng.Assert;
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
//import Utility.MKTConfigReader;

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
     Test case name: Banner General SSB Smoke test
     
     Description: Initial smoketest for Banner General SSB
     
     Data Input: Excel data inputs and hard coded data inputs
     
     Author: Darin Admati
      
*/

public class As_SSB_user_shall_not_be_able_to_mark_2_emails_as_Preferred_the_system_shall_only_accept_one_email_address_to_be_marked_as_preferred {

	// Declare variable
	ExtentReports extent;
	ExtentTest test;
	String sRandStr = RandomStringUtils.randomAlphabetic(5);
	String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(Calendar.getInstance().getTime());
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();

	// set parameters to be called from XML suite to pass through into script
	@Parameters({ "Environment", "Browser", "OS" })
	@Test

	// Make sure to name your test below
	public void FRAGRNT(String Environment, String Browser, String OS) throws Exception {

		String Browsertype = Browser;
		String OStyoe = OS;

		// Configuration reader to pull variables and objects
		B9ConfigReader config = new B9ConfigReader();

		// Read data from excel file
		FileInputStream file = new FileInputStream(new File(config.getSSB()));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet worksheet = workbook.getSheetAt(0);


		String NSUID = ExcelReader.ReadCellValue(worksheet, 1, 0);
		String first = ExcelReader.ReadCellValue(worksheet, 1, 1);
		String middle = ExcelReader.ReadCellValue(worksheet, 1, 2);
		String last = ExcelReader.ReadCellValue(worksheet, 1, 3);
		String email = ExcelReader.ReadCellValue(worksheet, 1, 4);
		String dob = ExcelReader.ReadCellValue(worksheet, 1, 5);
		String marital = ExcelReader.ReadCellValue(worksheet, 1, 6);
		String gender = ExcelReader.ReadCellValue(worksheet, 1, 7);
		String preferredEmail = ExcelReader.ReadCellValue(worksheet, 1, 8);
		String phone = ExcelReader.ReadCellValue(worksheet, 1, 9);
		String address = ExcelReader.ReadCellValue(worksheet, 1, 10);
		String preferredAddress = ExcelReader.ReadCellValue(worksheet, 1, 11);
		String emergencyContact = ExcelReader.ReadCellValue(worksheet, 1, 12);
		String ethnicity = ExcelReader.ReadCellValue(worksheet, 1, 13);
		String veteran = ExcelReader.ReadCellValue(worksheet, 1, 14);
		String disabled = ExcelReader.ReadCellValue(worksheet, 1, 15);

		// Instantiates and creates test case name for report - need to enter in
		// the name at the end
		Banner9ExtentReport extentR = new Banner9ExtentReport(extent, test);
		extentR.ExtentReport(Environment, OStyoe, Browsertype, "SSB General Smoketest - As SSB user shall not be able to mark 2 emails as Preferred, the system shall only accept one email address to be marked as preferred. ");
		extent = extentR.getExtent();
		test = extentR.getTest();

		// Instantiates Webdriver and Browser for rest of script to use
		BrowserManagement browser = PageFactory.initElements(driver, BrowserManagement.class);
		browser.ChooseBrowser(Browsertype, OS);
		driver = browser.driver;

		// ---START TEST

		// Open URL - Make sure to specify the module(General, Faculty, Student,
		// Employee, Finance,StudentReg)
		test.info("Step 1 Open Banner 9 URL");
		Banner9SSBUrl url = PageFactory.initElements(driver, Banner9SSBUrl.class);
		url.ChooseURL(Environment, Browsertype, OStyoe, "General");
		test.pass("Step 1 Open Banner 9 URL passed");

		// Log into Banner 9
		test.info("Log into Banner 9 SBB");
		login log = PageFactory.initElements(driver, login.class);
		// log.login_Eis_Banner_Direct_link(config.getQAUSERNAME(),
		// config.getQAPASSWORD());
		log.login_Eis_Banner_Direct_link("cfernande1", "Sharks2020");
		test.pass("Log into Banner 9 SSB passed");

		Thread.sleep(2000);

		test.info("Click personal information");
		WebElement pi = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Personal Information')]")));
		driver.findElement(By.xpath("//button[contains(.,'Personal Information')]")).click();
		test.pass("Click personal information passed");

		int fail = 0;

		Thread.sleep(5000);

		test.info("Wait for loading");
		Banner9SSBWaitForLoading waitForLoading = PageFactory.initElements(driver, Banner9SSBWaitForLoading.class);
		waitForLoading.waitForLoading(12);
		test.pass("Wait for loading passed");

		// ***Verify the fields

		Thread.sleep(3000);
		test.info("Click Add New Email");
		Banner9SSBEditInfo edit6 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit6.clickAddEmail();
		test.pass("Click Add New Email passed");
		
		
		//Select preferred email
		Thread.sleep(3000);
		test.info("Enter email info");
		Banner9SSBEditInfo edit7 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit7.AddEmail("ignore", "Employee Email Address", "QAAUTOMATION@NOVA.EDU", "TEST", "Yes", "add");
		test.pass("Enter email info passed");
		
		Thread.sleep(5000);
		
		driver.navigate().refresh();

		
		Thread.sleep(3000);
		test.info("Click Add New Email");
		edit6.clickAddEmail();
		test.pass("Click Add New Email passed");
		
		//Select preferred email
		Thread.sleep(3000);
		test.info("Enter email info");
		edit7.AddEmail("ignore", "Employee Email Address", "QAAUTOMATION@NOVA.EDU", "TEST", "Yes", "add");
		test.pass("Enter email info passed");

		
		//Need to understand the flow to make the next series of steps
		
		
		if (fail > 0) {
			Assert.fail("More than 1 failure occurred. Total failures = " + fail);
		} else {
			System.out.println("No failures, great job, all clear!. Total failures = " + fail);
		}

		System.out.println("Close Banner SSB browser window");

		test.info("Close Browser");
		driver.close();
		driver.quit();
		test.pass("Close Browser passed");

	}

	@AfterMethod
	// Captures test execution information to pass through in next step
	public void getResult(ITestResult result) throws IOException {
		// Captures screenshot from failed test case and inserts into test
		// result report
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshotPath = GetScreenshot.capture(driver, result.getMethod().getMethodName() + "_" + "failure");
			test.fail(result.getThrowable());
			test.fail("screenshot below: " + test.addScreenCaptureFromPath(screenshotPath));
		}

	}

	@AfterClass

	public void tearDown() throws Exception {

		{
			extent.flush();
			driver.quit();
		}

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
