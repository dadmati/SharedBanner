package pom.HR;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
//import Utility.MKTConfigReader;
import commonfunctions.QueryDB;
import pom.Banner9Common.Banner9CommonGo;
import pom.Banner9Common.Banner9CommonSave;
import pom.Banner9Common.login;
import pom.Banner9Common.sendKeySlower;

public class SPAIDENPOM {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	 * @FindBy(id="username") WebElement username;
	 */

	// Standard way

	/*
	 * @FindBy(how=How.ID,using="username") WebElement username1;
	 */
	public SPAIDENPOM(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='KEY_BLOCK_CANVAS_generateBtn']/span[1]")
	@CacheLookup
	WebElement plusButton;

	@FindBy(how = How.XPATH, using = ".//*[@name='keyblockSourceCode']")
	@CacheLookup
	WebElement matchingSource;

	@FindBy(how = How.XPATH, using = ".//*[@id='username']")
	WebElement usrnme;

	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	WebElement paswrd;

	@FindBy(how = How.XPATH, using = " .//*[@id='submitform']")
	WebElement submit_btn;

	public void newRecord(String matchSource) throws Exception {
     //Add comments on who created the method and what it does.
	 	
		
		//// test.info("Enter in NSUID");
		WebElement clickplusbutton = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='KEY_BLOCK_CANVAS_generateBtn']/span[1]")));
		plusButton.click();
		
		Thread.sleep(3000);
		
		//<h2 class="workspace-title" title="Common Matching Entry  GOAMTCH  9.3.7  (CAMP0228)" style="left: 44px; right: 176px;">Common Matching Entry  GOAMTCH  9.3.7  (CAMP0228)</h2>
		//.//*[@title='Common Matching Entry  GOAMTCH  9.3.7  (CAMP0228)'])]
		
		WebElement a = (new WebDriverWait(driver, 300))
	    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@title, 'Common Matching Entry  GOAMTCH  9.3.7')]")));
													
		Thread.sleep(3000);
		
		WebDriverWait matchingsource = new WebDriverWait(driver, 300);
		matchingsource.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='keyblockSourceCode']")));
		matchingSource.click();
		Thread.sleep(3000);
		
		
		WebDriverWait matchingsource2 = new WebDriverWait(driver, 300);
		matchingsource2.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='keyblockSourceCode']")));
		matchingSource.clear();
		Thread.sleep(3000);
		// HR
		
		WebDriverWait matchingsource3 = new WebDriverWait(driver, 300);
		matchingsource3.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='keyblockSourceCode']")));
		//matchingSource.sendKeys(matchSource);
		sendKeySlower type = PageFactory.initElements(driver, sendKeySlower.class);
		type.TypeInField(".//*[@name='keyblockSourceCode']", matchSource);
		Thread.sleep(3000);
		
		

		WebDriverWait matchingsource4 = new WebDriverWait(driver, 300);
		matchingsource4.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='keyblockSourceCode']")));
		matchingSource.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		
		
		
		
		boolean check1 = false;
		for(int i=0; i<36; i++)
		{
			  //rs.beforeFirst();
			 if (driver.findElements(By.xpath("//*[@class='ui-loader']")).size() == 1) {
					//if present, do this
					System.out.println("Still loading...");
				    check1 = false;
					Thread.sleep(5000);
				} else {
					// CONFIRM NO MATCHES FOUND
					WebElement ab = (new WebDriverWait(driver, 120))
						    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@name='keyblockSourceCode']")));
					Thread.sleep(5000);
					WebDriverWait matchingsource5 = new WebDriverWait(driver, 120);
					matchingsource5.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='keyblockSourceCode']")));
					//Thread.sleep(5000);
					break;
			     		}
		}
		
		
		
		
		boolean check = false;
		for(int i=0; i<36; i++)
		{
			  //rs.beforeFirst();

			 if (driver.findElements(By.xpath("//*[@title='HUMAN RESOURCES']")).size() == 0) {
					//if present, do this
					//System.out.println("Still loading...");
				    check = false;
					Thread.sleep(5000);
				} else {
					// CONFIRM NO MATCHES FOUND
					//System.out.println("Finished loading.");
					matchingSource.click();
					check = true;
					break;
			     		}
		}
		//<span id="#keyblockSourceDesc" style="height: 23px; " class="ui-widget-content ui-corner-all" maxlength="60" dir="ltr" title="HUMAN RESOURCES" readonly="readonly">HUMAN RESOURCES</span>
		
		
		
		WebDriverWait matchingsource6 = new WebDriverWait(driver, 120);
		matchingsource6.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='keyblockSourceCode']")));
		matchingSource.sendKeys(Keys.TAB);
		Thread.sleep(5000);
		
		boolean check3 = false;
		for(int i=0; i<36; i++)
		{
			  //rs.beforeFirst();
			 if (driver.findElements(By.xpath("//*[@class='ui-loader']")).size() == 1) {
					//if present, do this
					System.out.println("Still loading...");
				    check1 = false;
					Thread.sleep(5000);
				} else {
					// CONFIRM NO MATCHES FOUND
					
					
					check3 = true;
					break;
			     		}
		}
		
		Thread.sleep(5000);
		
		WebDriverWait matchingsource7 = new WebDriverWait(driver, 300);
		matchingsource7.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='keyblockSourceCode']")));
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//Wait one minute
		Thread.sleep(60000);
		
		
		boolean check4 = false;
		for(int i=0; i<36; i++)
		{
			  //rs.beforeFirst();
			 if (driver.findElements(By.xpath("//*[@class='ui-loader']")).size() == 1) {
					//if present, do this
					System.out.println("Still loading...");
				    check4 = false;
					Thread.sleep(5000);
				} else {
					// CONFIRM NO MATCHES FOUND
					
					break;
			     		}
		}
		/*WebElement sourcecode = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@class='ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit']")));
		driver.findElement(By.xpath(".//*[@class='ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit']")).click();*/
		
		
		
		/*Banner9CommonGo click = PageFactory.initElements(driver, Banner9CommonGo.class);
		click.clickGo();*/
		
		//matchingSource.sendKeys(Keys.chord(Keys.ALT, Keys.PAGE_DOWN));
		
		
		//Actions action = new Actions(driver);
		//action.sendKeys(Keys.chord(Keys.ALT, Keys.PAGE_DOWN));

		/*
		 * WebElement rightafterloginpositive5 = (new WebDriverWait(driver, 30))
		 * .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//*[@id='btok']/span")));
		 * driver.findElement(By.xpath("//*[@id='btok']/span")).click();
		 */
		// <span class="ui-button-text">Go</span>
	}
	
	public void newRecordCitizen(String NSUID, String citizen) throws Exception {

		//// test.info("Enter in NSUID");
		WebElement rightafterloginpositive2 = (new WebDriverWait(driver, 300))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#id']")));
		driver.findElement(By.xpath("//*[@id='#id']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#id']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#id']")).sendKeys(NSUID);
		sendKeySlower type2 = PageFactory.initElements(driver, sendKeySlower.class);
		type2.TypeInField("//*[@id='#id']", NSUID);
		
		Thread.sleep(3000);
		
		String getNSU = driver.findElement(By.xpath("//*[@id='#id']")).getAttribute("value");

		//Uncomment if the below for statement does not work
        if (getNSU==NSUID) {
			//if present, do this
		    System.out.println("NSUID is present.");
		} else {
			// CONFIRM NO MATCHES FOUND
			WebElement rightafterloginpositive3 = (new WebDriverWait(driver, 300))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#id']")));
			driver.findElement(By.xpath("//*[@id='#id']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='#id']")).clear();
			Thread.sleep(10000);
			//driver.findElement(By.xpath("//*[@id='#id']")).sendKeys(NSUID);
			sendKeySlower type3 = PageFactory.initElements(driver, sendKeySlower.class);
			type3.TypeInField("//*[@id='#id']", NSUID);
	     		}

		
		
		//driver.findElement(By.xpath("//*[@id='#id']")).sendKeys(String.valueOf(NSUID));
		//// test.pass("Enter in NSUID passed");
		
		//userInputBox.sendKeys(String.valueOf(User.username));
		

		Thread.sleep(5000);

		WebDriverWait waitemptab3 = new WebDriverWait(driver, 120);
		waitemptab3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/button[1]")));
		driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/button[1]")).click();
		
		
		WebDriverWait waitemptab4 = new WebDriverWait(driver, 120);
		waitemptab4.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='tabGIdenTabCanvas_tab4']")));
		driver.findElement(By.xpath("//*[@id='tabGIdenTabCanvas_tab4']")).click();
		
		
		  //CY
		WebDriverWait citizens = new WebDriverWait(driver, 120);
		citizens.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='#spbpersCitzCode']")));
		driver.findElement(By.xpath("//*[@id='#spbpersCitzCode']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#spbpersCitzCode']")).clear();
		Thread.sleep(3000);
/*		driver.findElement(By.xpath("//*[@id='#spbpersCitzCode']")).sendKeys(citizen);
*/		sendKeySlower type3 = PageFactory.initElements(driver, sendKeySlower.class);
		type3.TypeInField("//*[@id='#spbpersCitzCode']", citizen);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#spbpersCitzCode']")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		
		Banner9CommonSave save = PageFactory.initElements(driver, Banner9CommonSave.class);
		save.clickSave();
	}

	public void existingRecord(String NSUID) throws Exception {

		//// test.info("Enter in NSUID");
		WebElement rightafterloginpositive2 = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#id']")));
		//driver.findElement(By.xpath("//*[@id='#id']")).sendKeys(NSUID);
		sendKeySlower type4 = PageFactory.initElements(driver, sendKeySlower.class);
		type4.TypeInField("//*[@id='#id']", NSUID);
		//// test.pass("Enter in NSUID passed");

		Thread.sleep(5000);

		WebDriverWait waitemptab3 = new WebDriverWait(driver, 120);
		waitemptab3.until(ExpectedConditions
				.elementToBeClickable(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/button[1]")));
		driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/button[1]")).click();
	}

	public void createNewUser(String lname, String fname, String mname, String street1, String street2, String city,
			String state, String zip, String county, String nation, String ssn, String bdday, String bdmonth,
			String bdyear, String gender, String pcode, String phonearea, String phonenum, String emailtype, String emailadd)
			throws Exception {
		Thread.sleep(5000);
		
		MKTConfigReader configM = new MKTConfigReader();
		FileInputStream file = new FileInputStream(new File(configM.getExcelPathfromscript()));
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		 //Get first sheet from the workbook as 0 equals 1st sheet in workbook
	    HSSFSheet worksheet = workbook.getSheetAt(0);

		// Record type

		WebElement type = (new WebDriverWait(driver, 300))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#spridenCreateUser']")));
		driver.findElement(By.xpath("//*[@id='#spridenCreateUser']"));
		String Atype = driver.findElement(By.xpath("//*[@id='#spridenCreateUser']")).getAttribute("value");

		// Lastname

		// test.info("Check lastname");
		WebElement checklname = (new WebDriverWait(driver, 300))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#persLastName']")));
		driver.findElement(By.xpath("//*[@id='#lastName']")).click();
		driver.findElement(By.xpath("//*[@id='#lastName']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#lastName']")).sendKeys(lname);
		sendKeySlower type5 = PageFactory.initElements(driver, sendKeySlower.class);
		type5.TypeInField("//*[@id='#lastName']", lname);

		// test.info("Store lastname");
		String lnamestore = driver.findElement(By.xpath("//*[@id='#lastName']")).getAttribute("value");
        worksheet.getRow(1).createCell(2).setCellValue(lnamestore);
		// test.pass("Store email passed");

		// Firstname

		// test.info("Check firstname");
		WebElement checkfname = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeFirstName']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeFirstName']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeFirstName']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeFirstName']")).sendKeys(fname);
		sendKeySlower type6 = PageFactory.initElements(driver, sendKeySlower.class);
		type6.TypeInField("//*[@id='#gotcmmeFirstName']", fname);
		// test.pass("Check firstname passed");

		// test.info("Store firstname");
		String fnamestore = driver.findElement(By.xpath("//*[@id='#gotcmmeFirstName']")).getAttribute("value");
        worksheet.getRow(1).createCell(0).setCellValue(fnamestore);
		
		// test.pass("Store firstname passed");

		// Middlename

		// test.info("Check middlename");
		WebElement checkmname = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeMi']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeMi']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeMi']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#gotcmmeMi']")).sendKeys(mname);
		// test.pass("Check middlename passed");

		// test.info("Store middlename");
		String mnamestore = driver.findElement(By.xpath("//*[@id='#gotcmmeMi']")).getAttribute("value");
		// test.pass("Store middlename passed");

		// Street1

		// test.info("Check Street1 field");
		WebElement add1 = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeStreetLine1']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeStreetLine1']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeStreetLine1']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeStreetLine1']")).sendKeys(street1);
		sendKeySlower type7 = PageFactory.initElements(driver, sendKeySlower.class);
		type7.TypeInField("//*[@id='#gotcmmeStreetLine1']", street1);
		// test.pass("Check Street1 field passed")

		// test.info("Store Street1");
		String street1store = driver.findElement(By.xpath("//*[@id='#gotcmmeStreetLine1']")).getAttribute("value");
          worksheet.getRow(1).createCell(4).setCellValue(street1store);

		// test.pass("Store Street1 passed");

		WebElement add2 = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeStreetLine2']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeStreetLine2']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeStreetLine2']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeStreetLine2']")).sendKeys(street2);
		sendKeySlower type8 = PageFactory.initElements(driver, sendKeySlower.class);
		type8.TypeInField("//*[@id='#gotcmmeStreetLine2']", street2);
		// test.pass("Check Street1 field passed")

		// test.info("Store Street1");
		String street2store = driver.findElement(By.xpath("//*[@id='#gotcmmeStreetLine2']")).getAttribute("value");
		// test.pass("Store Street1 passed");

		// City

		// test.info("Check city field");
		WebElement citycheck = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeCity']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeCity']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeCity']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeCity']")).sendKeys(city);
		sendKeySlower type9 = PageFactory.initElements(driver, sendKeySlower.class);
		type9.TypeInField("//*[@id='#gotcmmeCity']", city);
        // test.pass("Check city field passed");

		// test.info("Store city");
		String citystore = driver.findElement(By.xpath("//*[@id='#gotcmmeCity']")).getAttribute("value");
		  worksheet.getRow(1).createCell(6).setCellValue(citystore);
		// test.pass("Store city passed");

		// Zip

		WebElement statefind = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeStatCode']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeStatCode']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeStatCode']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#gotcmmeStatCode']")).sendKeys(state);
		// test.pass("Check zip field passed");

		// test.info("Store zip");
		String statestore = driver.findElement(By.xpath("//*[@id='#gotcmmeStatCode']")).getAttribute("value");
		// test.pass("Store city passed");

		WebElement zipcode = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeZip']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeZip']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeZip']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#gotcmmeZip']")).sendKeys(zip);

		String zipstore = driver.findElement(By.xpath("//*[@id='#gotcmmeZip']")).getAttribute("value");
        worksheet.getRow(1).createCell(8).setCellValue(zipstore);

		// NEED COUNTY
		WebElement countycode = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeCntyCode']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeCntyCode']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeCntyCode']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeCntyCode']")).sendKeys(county);
		sendKeySlower type10 = PageFactory.initElements(driver, sendKeySlower.class);
		type10.TypeInField("//*[@id='#gotcmmeCntyCode']", county);

		// test.info("Store zip");
		String countystore = driver.findElement(By.xpath("//*[@id='#gotcmmeCntyCode']")).getAttribute("value");
		// test.pass("Store city passed");

		// NEED NATION
		WebElement nationcode = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeNatnCode']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeNatnCode']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeNatnCode']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeNatnCode']")).sendKeys(nation);
		sendKeySlower type11 = PageFactory.initElements(driver, sendKeySlower.class);
		type11.TypeInField("//*[@id='#gotcmmeNatnCode']", nation);

		// test.info("Store zip");
		String nationstore = driver.findElement(By.xpath("//*[@id='#gotcmmeNatnCode']")).getAttribute("value");
		// test.pass("Store city passed");

		// test.info("Check SSN field");
		WebElement SSNcode = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeSsn']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).sendKeys(ssn);
		sendKeySlower type12 = PageFactory.initElements(driver, sendKeySlower.class);
		type12.TypeInField("//*[@id='#gotcmmeSsn']", ssn);
		// test.pass("Check Birthdate field passed");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
		if (driver.findElements(By.xpath("//*[@class='notifications-item-text'][contains(text(),'*WARNING* SSN/SIN/TIN already assigned to another record.')]")).size() != 0||driver.findElements(By.xpath("//*[@aria-selected='aria-selected']")).size() != 0) {
			WebElement clickOK = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='btn btn-primary']")));
			        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
			        
			        String ssrand3 = RandomStringUtils.randomNumeric(9);
			        
			     // test.info("Check SSN field");
					WebElement SSNcode2 = (new WebDriverWait(driver, 120))
							.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeSsn']")));
					driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).click();
					driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).clear();
					Thread.sleep(3000);
					//driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).sendKeys(ssn);
					sendKeySlower type122 = PageFactory.initElements(driver, sendKeySlower.class);
					type12.TypeInField("//*[@id='#gotcmmeSsn']", ssrand3);
					// test.pass("Check Birthdate field passed");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).sendKeys(Keys.TAB);
					Thread.sleep(1000);
		} else {
			
		}

		// test.info("Store SSN");
		String ssnstore = driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).getAttribute("value");
		// test.pass("Store SSN passed");

		// NEED BIRTDATE

		WebElement bdayday = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeBirthDay']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeBirthDay']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeBirthDay']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeBirthDay']")).sendKeys(bdday);
		sendKeySlower type13 = PageFactory.initElements(driver, sendKeySlower.class);
		type13.TypeInField("//*[@id='#gotcmmeBirthDay']", bdday);
		
		String bddaystore = driver.findElement(By.xpath("//*[@id='#gotcmmeBirthDay']")).getAttribute("value");


		WebElement bdaymonth = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeBirthMon']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeBirthMon']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeBirthMon']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeBirthMon']")).sendKeys(bdmonth);
		sendKeySlower type14 = PageFactory.initElements(driver, sendKeySlower.class);
		type14.TypeInField("//*[@id='#gotcmmeBirthMon']", bdmonth);
		
		String baymonstore = driver.findElement(By.xpath("//*[@id='#gotcmmeBirthMon']")).getAttribute("value");


		WebElement bdayyear = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeBirthYear']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeBirthYear']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeBirthYear']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeBirthYear']")).sendKeys(bdyear);
		sendKeySlower type15 = PageFactory.initElements(driver, sendKeySlower.class);
		type15.TypeInField("//*[@id='#gotcmmeBirthYear']", bdyear);
		
		String bayyearstore = driver.findElement(By.xpath("//*[@id='#gotcmmeBirthYear']")).getAttribute("value");
		
		String bdayfinal = bdday+"/"+bdmonth+"/"+bdyear;
		
		 worksheet.getRow(1).createCell(11).setCellValue(bdayfinal);
		//12/12/1977



		// NEED GENDER

		WebElement genderfind = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='gotcmmeSex_ac']")));
		driver.findElement(By.xpath("//*[@id='gotcmmeSex_ac']")).click();
		driver.findElement(By.xpath("//*[@id='gotcmmeSex_ac']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='gotcmmeSex_ac']")).sendKeys(gender);
		sendKeySlower type16 = PageFactory.initElements(driver, sendKeySlower.class);
		type16.TypeInField("//*[@id='gotcmmeSex_ac']", gender);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='gotcmmeSex_ac']")).sendKeys(Keys.TAB);
		Thread.sleep(3000);
		
		System.out.println("gender = "+gender);
		if(gender == "Female"){
			worksheet.getRow(1).createCell(10).setCellValue("F");
		}
		else if(gender=="Male"){
			worksheet.getRow(1).createCell(10).setCellValue("M");

		}
				 
		
		WebElement phonecode = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeTeleCode']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeTeleCode']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeTeleCode']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeTeleCode']")).sendKeys(pcode);
		sendKeySlower type17 = PageFactory.initElements(driver, sendKeySlower.class);
		type17.TypeInField("//*[@id='#gotcmmeTeleCode']", pcode);
		

		// NEED TELEPHONE
		WebElement areacode = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmePhoneArea']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmePhoneArea']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmePhoneArea']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmePhoneArea']")).sendKeys(phonearea);
		sendKeySlower type18 = PageFactory.initElements(driver, sendKeySlower.class);
		type18.TypeInField("//*[@id='#gotcmmePhoneArea']", phonearea);
		
		String areacodestore = driver.findElement(By.xpath("//*[@id='#gotcmmePhoneArea']")).getAttribute("value");


		WebElement phonenumber = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmePhoneNumber']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmePhoneNumber']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmePhoneNumber']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmePhoneNumber']")).sendKeys(phonenum);
		sendKeySlower type19 = PageFactory.initElements(driver, sendKeySlower.class);
		type19.TypeInField("//*[@id='#gotcmmePhoneNumber']", phonenum);
		
		String phonenumstore = driver.findElement(By.xpath("//*[@id='#gotcmmePhoneNumber']")).getAttribute("value");
		
		String phonefinal = phonearea+phonenum;
		System.out.println(phonefinal);
		  worksheet.getRow(1).createCell(9).setCellValue(phonefinal);

		// NEED EMAIL
		// email type
		WebElement emailtypefind = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeEmalCode']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeEmalCode']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeEmalCode']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#gotcmmeEmalCode']")).sendKeys(emailtype);

		// email address
		WebElement emailaddress = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeEmailAddress']")));
		driver.findElement(By.xpath("//*[@id='#gotcmmeEmailAddress']")).click();
		driver.findElement(By.xpath("//*[@id='#gotcmmeEmailAddress']")).clear();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='#gotcmmeEmailAddress']")).sendKeys(emailadd);
		sendKeySlower type20 = PageFactory.initElements(driver, sendKeySlower.class);
		type20.TypeInField("//*[@id='#gotcmmeEmailAddress']", emailadd);
		
		String emailstore = driver.findElement(By.xpath("//*[@id='#gotcmmeEmailAddress']")).getAttribute("value");
		  worksheet.getRow(1).createCell(3).setCellValue(emailstore);

		// Click save
		Banner9CommonSave go = PageFactory.initElements(driver, Banner9CommonSave.class);
		go.clickSave();
		
		Thread.sleep(5000);
		//Check message
			//test.info("Confirm Apply online link is present");
		
		//<a href="#tabGoamtchTabCanvas-page_govcmid" role="tab" id="tabGoamtchTabCanvas_tab1" tabindex="-1" aria-controls="tabGoamtchTabCanvas-page_govcmid" aria-selected="true">Potential Matches 1</a>
		
		

		
		if (driver.findElements(By.xpath("//*[@class='notifications-item-text'][contains(text(),'*WARNING* SSN/SIN/TIN already assigned to another record.')]")).size() != 0||driver.findElements(By.xpath("//*[@aria-selected='aria-selected']")).size() != 0) {
			//if present, do this
			String ssrand2 = RandomStringUtils.randomNumeric(9);
			
			//<button class="btn btn-primary" id="frames85">OK</button>
			WebElement clickOK = (new WebDriverWait(driver, 120))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='btn btn-primary']")));
	        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

	        Thread.sleep(3000);
			
			WebElement SSNcodeclick = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='l:clearSuspenseBtn']")));
			driver.findElement(By.xpath("//*[@id='l:clearSuspenseBtn']")).click();
			
			Thread.sleep(5000);
			
			WebElement SSNcode2 = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#gotcmmeSsn']")));
			driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).click();
			driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).clear();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).sendKeys(ssrand2);
			sendKeySlower type21 = PageFactory.initElements(driver, sendKeySlower.class);
			type21.TypeInField("//*[@id='#gotcmmeSsn']", ssrand2);
			
			String ssnstore2 = driver.findElement(By.xpath("//*[@id='#gotcmmeSsn']")).getAttribute("value");
			
			// Click save
			Banner9CommonSave go2 = PageFactory.initElements(driver, Banner9CommonSave.class);
			go2.clickSave();
			
			WebElement nomatch = (new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//*[@class='notifications-item-text'][contains(text(),'No matches found, create as new?')]")));
			driver.findElement(
					By.xpath("//*[@class='notifications-item-text'][contains(text(),'No matches found, create as new?')]"));
			
			// CLICK YES
			WebElement clickYes = (new WebDriverWait(driver, 120)).until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@class='btn btn-primary'][contains(text(),'Yes')]")));
			driver.findElement(By.xpath("//*[@class='btn btn-primary'][contains(text(),'Yes')]")).click();
			
			// CONFIRM NEW ID CREATE MESSAGE AND GET NSUID
			WebElement confirmMessage = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='notifications-item-text']")));
			driver.findElement(By.xpath("//*[@class='notifications-item-text']"));
			String ID = driver.findElement(By.xpath("//*[@class='notifications-item-text']")).getText();
			
			System.out.print("Value = " + ID);
			//<p class="notifications-item-text">Generated ID: N01922003.  Identification record created.  Biographical record created;Address record create failed.Telephone record not created.  E-mail record not created.  Additional ID not created.  </p>
			String NSUID = ID.substring(14, 23);
			worksheet.getRow(1).createCell(15).setCellValue(NSUID);
			
			// CLICK OK
			WebDriverWait clickOk = new WebDriverWait(driver, 120);
			clickOk.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@class='btn btn-primary'][contains(text(),'OK')]")));
			driver.findElement(By.xpath("//*[@class='btn btn-primary'][contains(text(),'OK')]")).click();
		} else {
			// CONFIRM NO MATCHES FOUND
			WebElement nomatch = (new WebDriverWait(driver, 120)).until(ExpectedConditions.presenceOfElementLocated(By
					.xpath("//*[@class='notifications-item-text'][contains(text(),'No matches found, create as new?')]")));
			driver.findElement(
					By.xpath("//*[@class='notifications-item-text'][contains(text(),'No matches found, create as new?')]"));
			
			// CLICK YES
			WebElement clickYes = (new WebDriverWait(driver, 30)).until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@class='btn btn-primary'][contains(text(),'Yes')]")));
			driver.findElement(By.xpath("//*[@class='btn btn-primary'][contains(text(),'Yes')]")).click();
			
			// CONFIRM NEW ID CREATE MESSAGE AND GET NSUID
			WebElement confirmMessage = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='notifications-item-text']")));
			driver.findElement(By.xpath("//*[@class='notifications-item-text']"));
			String ID = driver.findElement(By.xpath("//*[@class='notifications-item-text']")).getText();
			
			System.out.print("Value = " + ID);
			//<p class="notifications-item-text">Generated ID: N01922003.  Identification record created.  Biographical record created;Address record create failed.Telephone record not created.  E-mail record not created.  Additional ID not created.  </p>
			String NSUID = ID.substring(14, 23);
			worksheet.getRow(1).createCell(15).setCellValue(NSUID);
			
			// CLICK OK
			WebDriverWait clickOk = new WebDriverWait(driver, 120);
			clickOk.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@class='btn btn-primary'][contains(text(),'OK')]")));
			driver.findElement(By.xpath("//*[@class='btn btn-primary'][contains(text(),'OK')]")).click();
		}

		/*// CONFIRM NO MATCHES FOUND
		WebElement nomatch = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//*[@class='notifications-item-text'][contains(text(),'No matches found, create as new?')]")));
		driver.findElement(
				By.xpath("//*[@class='notifications-item-text'][contains(text(),'No matches found, create as new?')]"));*/
		
		//By.xpath("//*[@class='notifications-item-text'][contains(text(),'*WARNING* SSN/SIN/TIN already assigned to another record.')]"));

		

		/*// CLICK YES
		WebElement clickYes = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class='btn btn-primary'][contains(text(),'Yes')]")));
		driver.findElement(By.xpath("//*[@class='btn btn-primary'][contains(text(),'Yes')]")).click();*/

		/*// CONFIRM NEW ID CREATE MESSAGE AND GET NSUID
		WebElement confirmMessage = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='notifications-item-text']")));
		driver.findElement(By.xpath("//*[@class='notifications-item-text']"));
		String ID = driver.findElement(By.xpath("//*[@class='notifications-item-text']")).getText();*/
		
		/*WebElement confirmMessage = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='notifications']/ul/li[1]/div/div[2]/p/text()")));
		driver.findElement(By.xpath("//*[@id='notifications']/ul/li[1]/div/div[2]/p/text()"));
		String ID = driver.findElement(By.xpath("//*[@id='notifications']/ul/li[1]/div/div[2]/p/text()")).getAttribute("value");*/
		
		/*System.out.print("Value = " + ID);
		//<p class="notifications-item-text">Generated ID: N01922003.  Identification record created.  Biographical record created;Address record create failed.Telephone record not created.  E-mail record not created.  Additional ID not created.  </p>
		String NSUID = ID.substring(14, 23);
		worksheet.getRow(1).createCell(15).setCellValue(NSUID);
		
		// CLICK OK
		WebDriverWait clickOk = new WebDriverWait(driver, 30);
		clickOk.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@class='btn btn-primary'][contains(text(),'OK')]")));
		driver.findElement(By.xpath("//*[@class='btn btn-primary'][contains(text(),'OK')]")).click();*/

		
		FileOutputStream fileout = new FileOutputStream(new File(configM.getExcelPathfromscript()));
		workbook.write(fileout);
		fileout.close();
	
	}

}