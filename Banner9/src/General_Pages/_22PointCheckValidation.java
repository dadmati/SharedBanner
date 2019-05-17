package General_Pages ;

import java.io.FileInputStream;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pom.Banner9Common.Banner9AppNavUrl;
import pom.Banner9Common.Banner9Browser;
import pom.Banner9Common.Banner9CommonCloseOutOfPage;
import pom.Banner9Common.Banner9CommonHelp;
import pom.Banner9Common.Banner9ExtentReport;
import pom.Banner9Common.Banner9SwitchbackFromiFrame;
import pom.Banner9Common.NavigateToPage;
import pom.Banner9Common.login;

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

public class _22PointCheckValidation {

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
	public void HelpPage(String Environment, String Browser, String OS) throws Exception {
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
		extentR.ExtentReport(Environment, OStyoe, Browsertype, "Banner 9 22 Point Check Validation - ");
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
		
		Thread.sleep(500);
		// adding 2 seconds wait to avoid Sync issue
		
		//CHECK 1
		//Click dropdown on left
		WebDriverWait clickDropDown1 = new WebDriverWait(driver, 120);
		clickDropDown1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='fa fa-bars']")));
		driver.findElement(By.xpath(".//*[@class='fa fa-bars']")).click();
		
		Thread.sleep(500);
		
		//Verify that you see Banner 
		WebDriverWait clickDropDown2 = new WebDriverWait(driver, 120);
		clickDropDown2.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@data-name='Banner'])[1]")));
		driver.findElement(By.xpath("(.//*[@data-name='Banner'])[1]"));
		
		Thread.sleep(500);
		
		//*Verify that you see My Banner 
		WebDriverWait clickDropDown3 = new WebDriverWait(driver, 120);
		clickDropDown3.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ng-binding'][contains(text(),'My Banner')]")));
		driver.findElement(By.xpath(".//*[@class='ng-binding'][contains(text(),'My Banner')]"));
		
		//CHECK 2 Open multiple instances of Banner through additional tabs
		
		
		//CHECK 2	I can open multiple instances of Banner through additional Internet Explorer tabs
		
		
		//CHECK 3	I can view the envelope (folder) icon at the top left after the first form has been opened
		//CHECK 4	I can select the envelope icon and a list of the recently opened forms are displayed
		// open Site 1
		String homeWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
				
		Thread.sleep(500);
		
		test.info("Navigate to page");
		NavigateToPage nav = PageFactory.initElements(driver, NavigateToPage.class);
		nav.navigateToPage("GJAJOBS");
		test.pass("Navigate to page passed");

		Thread.sleep(500);
		// VERIFY TITLE IN IFRAME
		WebDriverWait waitpost = new WebDriverWait(driver, 120);
		waitpost.until(ExpectedConditions.titleContains("GJAJOBS"));
	
		Thread.sleep(500);
		// SWITCH TO IFRAME
		WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
		driver.switchTo().frame(driver.findElement(By.name("bannerHS")));
		
		Thread.sleep(500);
		//Interact with inner frame
		
		//Switch back to outer frame
		test.info("Switch back to outer frame");
		Banner9SwitchbackFromiFrame switchBack = PageFactory.initElements(driver, Banner9SwitchbackFromiFrame.class);
		switchBack.switchIframe();
		test.pass("Switch back to outer frame passed");
		
		Thread.sleep(500);
		
		//Confirm help menu
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SHIFT,"L"));
		
		// open Site 1
				String site_1_Window= driver.getWindowHandle();
				System.out.println(site_1_Window);
				
				Thread.sleep(500);
				
				// open Site 2
				Set site_Windows= driver.getWindowHandles();
				System.out.println(site_Windows);
				for (String site_2_Window: driver.getWindowHandles())
				{
				  System.out.println(site_2_Window);
				    driver.switchTo().window(site_2_Window);
				 } 
				
				Thread.sleep(3000);
				//<iframe id="frm" name="frm" src="https://bannerdev.nova.edu/bannerHelp/help/en/Baseline_General/webhelp/r_gjajobs_process_maintenance_form.html" frameborder="0" align="center" style=""></iframe>
				WebDriverWait wait_iframe2 = new WebDriverWait(driver, 20000);
				driver.switchTo().frame(driver.findElement(By.id("frm")));
				System.out.println("Switch to iFrame to communicate with Banner 9 pages");
			
				Thread.sleep(500);
					
				WebElement checkHelpPage = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='ariaid-title1'][contains(text(),'Process Maintenance (GJAJOBS) page')]")));
				driver.findElement(By.xpath(".//*[@id='ariaid-title1'][contains(text(),'Process Maintenance (GJAJOBS) page')]")).click();
				
				Thread.sleep(500);
				
				driver.close();
				
				Thread.sleep(500);
				
				driver.switchTo().window(site_1_Window);						
		
		Thread.sleep(500);
	
		test.info("Open recently opened");
		WebDriverWait openRecent0 = new WebDriverWait(driver, 120);
		openRecent0.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='badge items-count ng-binding'][contains(text(),'1')]")));
		driver.findElement(By.xpath(".//*[@class='badge items-count ng-binding'][contains(text(),'1')]"));
		
		Thread.sleep(500);
		
		WebDriverWait openRecent = new WebDriverWait(driver, 120);
		openRecent.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='fa fa-folder-open']")));
		driver.findElement(By.xpath(".//*[@class='fa fa-folder-open']")).click();
		
		Thread.sleep(500);
		
		WebDriverWait openRecent2 = new WebDriverWait(driver, 120);
		openRecent2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ng-binding'][contains(text(),'Process Maintenance (GJAJOBS)')]")));
		driver.findElement(By.xpath(".//*[@class='ng-binding'][contains(text(),'Process Maintenance (GJAJOBS)')]"));
		test.pass("Open recently opened passed");
	
		Thread.sleep(500);
		//CHECK 5	I can view the number of recently opened forms in a circle attached to the envelope icon
		
		
		//CHECK 6	I can see a triangle icon with an exclamation point next to a form type that has unsaved changes.

		
		//Note: You will also see the Banner 8 message all Active INB forms will close.
		//CHECK 7	I can enter a form name using key words in the search icon (magnifying glass) on the top left to find pages
		test.info("Click search");
		WebDriverWait search = new WebDriverWait(driver, 120);
		search.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='fa fa-search']")));
		driver.findElement(By.xpath(".//*[@class='fa fa-search']")).click();
		test.pass("Click search passed");	
		
		Thread.sleep(500);
		
		test.info("Type in search field");
		WebDriverWait search2 = new WebDriverWait(driver, 120);
		search2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@ng-placeholder='Search']")));
		driver.findElement(By.xpath(".//*[@ng-placeholder='Search']")).sendKeys("SPAIDEN");
		test.pass("Type in search field passed");
		
		Thread.sleep(500);
		
		
		test.info("Confirm that value appears after typing in field");
		WebDriverWait search3 = new WebDriverWait(driver, 120);
		search3.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ng-binding'][contains(text(),'General Person Identification (SPAIDEN)')]")));
		driver.findElement(By.xpath(".//*[@class='ng-binding'][contains(text(),'General Person Identification (SPAIDEN)')]"));
		test.pass("Confirm that value appears after typing in field passed");
		
		Thread.sleep(500);		
		
		//CHECK 8	I can view the disabled online help icon (question mark) for the Banner 8 pages
		
		
		//CHECK 9	I can view and click on the online help icon (question mark in a circle) on the Banner 8 tollbar to open online help for a Banner 8.x form.
		
		
		//CHECK 10	The home button (represented by the Nova Southeastern University title) in the navigation bar to return to the landing page
				test.info("The home button (represented by the Nova Southeastern University title) in the navigation bar to return to the landing page");
		WebDriverWait search4 = new WebDriverWait(driver, 120);
		search4.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@data-keyboardshortcut='Nova Southeastern University']")));
		driver.findElement(By.xpath(".//*[@data-keyboardshortcut='Nova Southeastern University']"));
		driver.findElement(By.xpath(".//*[@data-keyboardshortcut='Nova Southeastern University']")).click();
		test.pass("The home button (represented by the Nova Southeastern University title) in the navigation bar to return to the landing page passed");
		
		Thread.sleep(500);
		
		//CHECK 11	I can enter and open a form, job, menu, or quick flow from the open search field on the landing page 
		//(Note:  It is a known bug, at this time Jobs and Quick flows must be opened within Banner 8 Go to Menu)
		
		
		//CHECK 12	I am notified when my session is about to expire and have the option to continue working by clicking Extend. 

		//Note: After 30 minutes of inactivity a 5 minute warning to Extend the session will appear.  If your session has expired you will get the expired session message //with the option to Reload.
		
		
		//CHECK 13	I can access the Banner Application Systems through the side panel (Student, Accounts Receivable, Financial Aid, Human Resources, Advancement, Finance, //General)
		
		
		//CHECK 14	I can customize My Banner application to add or remove saved forms 

		//(Note: Sign-out and close/reopen browser to see update)
		
		
		//CHECK 15	I can view and access My Links via Banner 8 go to Menu
		
		
		//CHECK 16	I can view current open forms via Banner 8 File Menu or the recently opened folder icon.

		//(Note: You will no longer see the breadcrumb trail in the Title page of Banner8) 
		
		
		//CHECK 17	I can resize the Banner 8 oracle form view to eliminate scrolling by pressing F11  
		
		
		//CHECK 18	I can access my Banner 8 forms without any unforeseen errors (Java script)


		//CHECK 19	I can view the errors on a form after processing in the Banner 8 window
		
		
		//CHECK 20	I can access more than one Banner 8 form from the list of all Banner 8 forms using the Navigator search options
		//(Note: You should be able to enter up to 40 forms in all search options and the # of items opened should increase)
		
		
		//CHECK 21	I can use the Application Navigator short keys for Banner 9 commands
		//(Note: all commands work within the Navigator window but not necessarily when inside the Banner 8)
		//Control+M should popup the side menu
		test.info("Confirm shortcut keys Control M side popup");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL, "M"));
		clickDropDown1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='fa fa-bars']")));
		driver.findElement(By.xpath(".//*[@class='fa fa-bars']"));
		test.pass("Confirm shortcut keys Control M side popup passed");
		
		Thread.sleep(500);
		
		//Control+Y should open the recently opened folder
		test.info("Confirm shortcut keys Control Y recently opened folder");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL,"Y"));
		openRecent0.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='badge items-count ng-binding'][contains(text(),'1')]")));
		driver.findElement(By.xpath(".//*[@class='badge items-count ng-binding']"));
		test.pass("Confirm shortcut keys Control Y recently opened folder passed");
		
		Thread.sleep(500);
		
		//Control_Shift+Y should open the search menu
		test.info("Confirm shortcut keys Control Shift Y search menu");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SHIFT,"Y"));
		search.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='fa fa-search']")));
		driver.findElement(By.xpath(".//*[@class='fa fa-search']"));
		test.pass("Confirm shortcut keys Control Shift Y search menu passed");
		
		Thread.sleep(500);
		
		//Control shift+L should open the help folder - need to be in a page to verify though
		//Control shift+F should sign out
		test.info("Confirm shortcut keys Control Shift Control F sign out");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.chord(Keys.CONTROL,"F"));
		
		Thread.sleep(500);
				
		WebDriverWait signOutConfirmation = new WebDriverWait(driver, 30);
		signOutConfirmation.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='text-center'][contains(text(),'You have successfully logged out from an NSU application.')]")));
		driver.findElement(By.xpath(".//*[@class='text-center'][contains(text(),'You have successfully logged out from an NSU application.')]"));
		test.pass("Confirm shortcut keys Control Shift Control F sign out passed");
		
		//CHECK 22	I can reset by Banner password via the SSO manager credential management utility with at least one digit/special character Enter New Password and click //Save Log back in via webstartest.nova.edu and the Navigator Landing Page should open
		

		//Thread.sleep(2000);

		// SWITCH TO IFRAME
		//WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
		//driver.switchTo().frame(driver.findElement(By.name("bannerHS")));

	
		
		
		
		
		
		
		//Thread.sleep(3000);

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
