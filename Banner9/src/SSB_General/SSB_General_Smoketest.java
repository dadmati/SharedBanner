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

public class SSB_General_Smoketest {

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
		extentR.ExtentReport(Environment, OStyoe, Browsertype, "SSB General Smoketest - ");
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

		test.info("Verify Icon personal info");
		Banner9SSBVerifyPersonalInfo pers = PageFactory.initElements(driver, Banner9SSBVerifyPersonalInfo.class);
		pers.verifyIconPersonalInfo(first, middle, last, NSUID);
		test.pass("Verify Icon personal info passed");

		test.info("Verify personal info");
		Banner9SSBVerifyPersonalInfo persInfo = PageFactory.initElements(driver, Banner9SSBVerifyPersonalInfo.class);
		persInfo.verifyPersonalDetailsInfo(first, last, marital, preferredEmail, dob, gender);
		test.pass("Verify personal info passed");

		test.info("Verify Phone info");
		Banner9SSBVerifyPersonalInfo persInfoPhone = PageFactory.initElements(driver,
				Banner9SSBVerifyPersonalInfo.class);
		persInfoPhone.verifyPhoneInfo(phone);
		test.pass("Verify Phone info passed");

		//
		test.info("Click Edit personal info");
		Banner9SSBEditInfo edit1 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit1.clickEditPersonalDetails();
		test.pass("Click Edit personal info passed");

		Thread.sleep(3000);

		// Put pom for personal info here
		test.info("Edit personal info");
		Banner9SSBEditInfo persinfo = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		persinfo.editPersonalDetails("Single", "TestQA", "Update");
		test.pass("Edit personal info passed");

		test.info("Verify Saved Message");
		Banner9SSBEditInfo verify = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		verify.verifySaveMessage();
		test.pass("Verify Saved Message passed");

		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);
		test.info("Click email info");
		Banner9SSBEditInfo edit2 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit2.clickEditEmail();
		test.pass("Click email info passed");
		Thread.sleep(3000);

		// Put pom for email here
		test.info("Edit email info");
		persinfo.editEmail("test@test.com", "tester", "Cancel");
		test.pass("Edit email info passed");

		Thread.sleep(3000);

		driver.navigate().refresh();

		Thread.sleep(3000);
		test.info("Click phone");
		Banner9SSBEditInfo edit3 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit3.clickEditPhone();
		test.pass("Click phone passed");

		// Put pom for address here
		test.info("Edit phone info");
		persinfo.editPhoneNumber("954", "2984806", "", "Update");
		test.pass("Edit phone info passed");

		test.info("Verify Saved Message");
		verify.verifySaveMessage();
		test.pass("Verify Saved Message passed");

		driver.navigate().refresh();

		Thread.sleep(3000);
		test.info("Click address");
		Banner9SSBEditInfo edit4 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit4.clickEditAddress();
		test.pass("Click address passed");

		// Put pom for address here
		test.info("Edit address info");
		persinfo.editAddress("05/03/2017", "05/03/2020", "QATEST1", "QATEST1", "QATEST1", "QATEST1", "Fort Lauderdale",
				"Florida", "Broward", "33304", "United States");
		test.pass("Edit address info passed");

		driver.navigate().refresh();

		Thread.sleep(3000);
		test.info("Click Emergency Contact");
		Banner9SSBEditInfo edit5 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit5.clickEditEmergencyContact();
		test.pass("Click Emergency Contact passed");

		test.info("Edit Emergency Contact");
		persinfo.editEmergencyContact("TESTQA", "TESTQA", "TESTQA", "954", "5551234", "123", "TEST QA ADDRESS",
				"TEST QA ADDRESS", "TEST QA ADDRESS", "TEST QA ADDRESS", "DAVIE", "33301");
		test.pass("Edit Emergency Contact passed");

		driver.navigate().refresh();

		Thread.sleep(3000);
		test.info("Click Additional details ethnicity and race");
		Banner9SSBEditInfo edit6 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit6.clickEditAddDetailsRaceEthnicity();
		test.pass("Click Additional details ethnicity and race passed");

		test.info("Edit Race and Ethnicity");
		persinfo.editAdditionalDetailsRaceEthnicity("Continue", "Save");
		test.pass("Edit Race and Ethnicity passed");

		driver.navigate().refresh();

		Thread.sleep(3000);
		test.info("Click Additional details disability");
		Banner9SSBEditInfo edit7 = PageFactory.initElements(driver, Banner9SSBEditInfo.class);
		edit7.clickEditAdditionalDetailDisability();
		test.pass("Click Additional details disability passed");

		test.info("Edit disability");
		persinfo.clickEditAdditionalDetailDisability();
		test.pass("Edit disability passed");

		driver.navigate().refresh();

		Thread.sleep(3000);
		test.info("Click Signout");
		Banner9SSBSignOut edit8 = PageFactory.initElements(driver, Banner9SSBSignOut.class);
		edit8.signOut();
		test.pass("Click Signout passed");

	
		// ADD
		// Add Email
		// (.//*[@class='icon-add-CO'])[1]

		// Add Phone Number
		// (.//*[@class='icon-add-CO'])[2]

		// Add Address
		// (.//*[@class='icon-add-CO'])[3]

		// Add Emergency Contact
		// (.//*[@class='icon-add-CO'])[4]

		// EDIT
		// Edit email
		// (.//*[@class='icon-edit-CO'])[2]

		// Edit cell
		// (.//*[@class='icon-edit-CO'])[3]

		// Edit employee primary num
		// (.//*[@class='icon-edit-CO'])[4]

		// Edit home num
		// (.//*[@class='icon-edit-CO'])[5]

		// Edit perminent primary num
		// (.//*[@class='icon-edit-CO'])[6]

		// Edit business or work address
		// (.//*[@class='icon-edit-CO'])[7]

		// Edit perminent address
		// (.//*[@class='icon-edit-CO'])[8]

		// Edit perminent address
		// (.//*[@class='icon-edit-CO'])[8]

		// Edit emergency contact
		// (.//*[@class='icon-edit-CO'])[9]

		/*
		 * //Primary phone <div class="phone-type-view break-long-words">
		 * Employee (Primary)
		 * 
		 * </div>
		 * 
		 * //Home phone <div class="phone-type-view break-long-words"> Home
		 * 
		 * 
		 * </div>
		 * 
		 * //Home phone primary <div class="phone-type-view break-long-words">
		 * Home (Primary)
		 * 
		 * </div>
		 * 
		 * //Perminent phone primary Permanent (Primary) 786 539-7010
		 */

		/*
		 * WebElement verifyInfo7 = (new WebDriverWait(driver, 120))
		 * .until(ExpectedConditions.presenceOfElementLocated(By.
		 * xpath("(.//*[@class='overview-name break-long-words'][contains(text(),'"
		 * +first+" "+middle+" "+last+"')])[2]")));
		 */

		/*
		 * x-NSUID x-first x-last x-email x-marital x-dob x-gender
		 * x-preferredEmail x-phone x-address x-preferredAddress
		 * x-emergencyContact x-ethnicity x-veteran x-disabled
		 */

		/*
		 * test.info("Click direct deposit"); WebElement dd = (new
		 * WebDriverWait(driver, 120))
		 * .until(ExpectedConditions.presenceOfElementLocated(By.
		 * xpath("//button[contains(.,'Direct Deposit')]")));
		 * driver.findElement(By.xpath("//button[contains(.,'Direct Deposit')]")
		 * ).click(); test.pass("Enter direct deposit passed");
		 */

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
