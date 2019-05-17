package pom.HR;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
import pom.Banner9Common.Banner9CommonGo;
import pom.Banner9Common.Banner9CommonSave;
import pom.Banner9Common.login;

public class PEAEMPLPOM {
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
	public PEAEMPLPOM(WebDriver driver) {
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

	public void lookUpRecord(String NSUID) throws Exception {
     //Add comments on who created the method and what it does.
		WebElement NSUIDFIELD = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#id']")));
		driver.findElement(By.xpath("//*[@id='#id']")).clear();

		WebElement NSUIDFIELD2 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#id']")));
		driver.findElement(By.xpath("//*[@id='#id']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#id']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#id']")).sendKeys(NSUID);

		// click process
		WebDriverWait waitemptab3 = new WebDriverWait(driver, 30);
		waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='ui-button-text'][contains(text(),'Go')]")));
		driver.findElement(By.xpath("//*[@class='ui-button-text'][contains(text(),'Go')]")).click();

		Thread.sleep(3000);
	}
	public void enterPeaemplInfo(String assertEmpGroup,String assertEmpvalue, String assertPartfull, String assertBencat, String EmplStatus_ac, String emplCode, String CoasCodeHome, String OrgnCodeHome, String OrgnCodeDist, String CoasCodeDist, String JblnCode, String CollCode, String CampCode, String role, int numDaysFromToday) throws Exception {

		// Employee status field
		MKTConfigReader configM = new MKTConfigReader();
		FileInputStream file = new FileInputStream(new File(configM.getExcelPathfromscript()));
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		 //Get first sheet from the workbook as 0 equals 1st sheet in workbook
	    HSSFSheet worksheet = workbook.getSheetAt(0);

		// Employee class
		WebElement empStatus = (new WebDriverWait(driver, 180)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='page_pebempl_pebemplEmplStatus_ac']")));
		driver.findElement(By.xpath("//*[@id='page_pebempl_pebemplEmplStatus_ac']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_pebempl_pebemplEmplStatus_ac']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='page_pebempl_pebemplEmplStatus_ac']")).sendKeys(EmplStatus_ac);
		driver.findElement(By.xpath("//*[@id='page_pebempl_pebemplEmplStatus_ac']")).sendKeys(Keys.TAB);

		

		// Employee class
		WebElement empclass = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplEclsCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplEclsCode']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplEclsCode']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplEclsCode']")).sendKeys(emplCode);
		// *[@id="#pebemplEclsCode"]

		// Confirm value
		// Employee group
		// *[@id="#pebemplEgrpCode"]
		WebElement a = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplEgrpCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplEgrpCode']")).click();
		
		Thread.sleep(3000);

		//test.info("Store Group Code");
		String empgroup = driver.findElement(By.xpath("//*[@id='#pebemplEgrpCode']")).getAttribute("value");
		//test.pass("Store Group Code passed");

		Thread.sleep(3000);
		
		//test.info("Confirm Group Code matches in Banner 9 PEAEMPL from what was submitted");
		Assert.assertEquals(assertEmpGroup, empgroup);
		//test.pass("Confirm Group Code matches in Banner 9 PEAEMPL from what was submitted passed");
		//test.pass("Store lastname passed");

		// Confirm value
		// Leave category
		// *[@id="#pebemplLcatCode"]
		WebElement b = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplLcatCode']")));

		//test.info("Store lastname");
		String empvalue = driver.findElement(By.xpath("//*[@id='#pebemplLcatCode']")).getAttribute("value");
		//test.pass("Store email passed");

		//test.info("Confirm email matches in Banner 9 SPAIDEN from what was submitted");
		Assert.assertEquals(assertEmpvalue, empvalue);
		//test.pass("Confirm email matches in Banner 9 SPAIDEN from what was submitted passed");
		//test.pass("Store lastname passed");

		// Confirm value
		// Benefit category
		// *[@id='#pebemplBcatCo']
		// *[@id="#pebemplBcatCode"]
		WebElement c = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplBcatCode']")));

		//test.info("Store lastname");
		String bencat = driver.findElement(By.xpath("//*[@id='#pebemplBcatCode']")).getAttribute("value");
		//test.pass("Store email passed");

		//test.info("Confirm email matches in Banner 9 SPAIDEN from what was submitted");
		Assert.assertEquals(assertBencat, bencat);
		//test.pass("Confirm email matches in Banner 9 SPAIDEN from what was submitted passed");
		//test.pass("Store lastname passed");

		// Confirm value
		// Part time or full time
		// *[@id='page_pebempl_pebemplInternalFtPtInd_ac']
		WebElement d = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='page_pebempl_pebemplInternalFtPtInd_ac']")));

		//test.info("Store lastname");
		String partfull = driver.findElement(By.xpath("//*[@id='page_pebempl_pebemplInternalFtPtInd_ac']"))
				.getAttribute("value");
		//test.pass("Store email passed");

		//test.info("Confirm email matches in Banner 9 SPAIDEN from what was submitted");
		Assert.assertEquals(assertPartfull, partfull);
		//test.pass("Confirm email matches in Banner 9 SPAIDEN from what was submitted passed");
		//test.pass("Store lastname passed");

		// Allow new hire checkbox
		// *[@id="#pebemplNewHireInd_btn"]

		// Home department
		// *[@id='#pebemplCoasCodeHome']
		WebElement home = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplCoasCodeHome']")));
		driver.findElement(By.xpath("//*[@id='#pebemplCoasCodeHome']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplCoasCodeHome']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplCoasCodeHome']")).sendKeys(CoasCodeHome);

		// Check disbursement
		// *[@id='#pebemplCoasCodeDist']
		WebElement check = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplCoasCodeDist']")));
		driver.findElement(By.xpath("//*[@id='#pebemplCoasCodeDist']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplCoasCodeDist']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplCoasCodeDist']")).sendKeys(CoasCodeDist);

		// Employee district
		// *[@id="#pebemplDicdCode"]

		// Organization1
		// *[@id="#pebemplOrgnCodeHome"]
		WebElement org1 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplOrgnCodeHome']")));
		driver.findElement(By.xpath("//*[@id='#pebemplOrgnCodeHome']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplOrgnCodeHome']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplOrgnCodeHome']")).sendKeys(OrgnCodeHome);

		// Organization2
		// *[@id='#pebemplOrgnCodeDist']
		WebElement org2 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplOrgnCodeDist']")));
		driver.findElement(By.xpath("//*[@id='#pebemplOrgnCodeDist']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplOrgnCodeDist']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplOrgnCodeDist']")).sendKeys(OrgnCodeDist);

		// Service dates current hire
		// *[@id="page_pebempl_pebemplCurrentHireDate1527291182032"]

		/*WebElement currenthiredate = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(@id, 'page_pebempl_pebemplCurrentHireDate')]")));
		// driver.findElement(By.xpath("//*[contains(@id,
		// 'page_pebempl_pebemplCurrentHireDate')]")).clear();
		driver.findElement(By.xpath("//*[contains(@id, 'page_pebempl_pebemplCurrentHireDate')]"));
		// driver.findElement(By.xpath("//*[contains(@id,
		// 'page_pebempl_pebemplCurrentHireDate')]")).sendKeys("05/30/2018");

		// Service dates orgiginal hire
		// *[@id="page_pebempl_pebemplFirstHireDate1527291182071"]
*/
		
		//
		   Calendar cal = Calendar.getInstance();
		   DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		   //System.out.println("Today's date is "+dateFormat.format(cal.getTime()));

		   cal.add(Calendar.DATE, numDaysFromToday);
		   System.out.println("Yesterday's date was "+dateFormat.format(cal.getTime()));  
		//

		WebElement currenthiredate = (new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'page_pebempl_pebemplCurrentHireDate')]")));
		driver.findElement(By.xpath("//*[contains(@id, 'page_pebempl_pebemplCurrentHireDate')]"));
		
		
		Actions actions = new Actions(driver);
     actions.moveToElement(driver.findElement(By.xpath("//*[contains(@id, 'page_pebempl_pebemplCurrentHireDate')]")));
     actions.click();
     Thread.sleep(3000);
     actions.sendKeys(Keys.DELETE);     
     Thread.sleep(3000);
     
     Actions actions2 = new Actions(driver);
     actions2.moveToElement(driver.findElement(By.xpath("//*[contains(@id, 'page_pebempl_pebemplCurrentHireDate')]")));
     actions2.click();
     Thread.sleep(3000);
     actions2.sendKeys(dateFormat.format(cal.getTime()));
     Thread.sleep(3000);
     actions2.build().perform();
     
     
		WebElement orgiginalhiredate = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(@id, 'page_pebempl_pebemplFirstHireDate')]")));
		// driver.findElement(By.xpath("//*[contains(@id,
		// 'page_pebempl_pebemplFirstHireDate')]")).clear();
		driver.findElement(By.xpath("//*[contains(@id, 'page_pebempl_pebemplFirstHireDate')]"));

		// Seervice dates original service
		// *[@id="page_pebempl_pebemplAdjServiceDate1527291182111"]
		WebElement orgiginalservicedate = (new WebDriverWait(driver, 30)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(@id, 'page_pebempl_pebemplAdjServiceDate')]")));
		// driver.findElement(By.xpath("//*[contains(@id,
		// 'page_pebempl_pebemplAdjServiceDate')]")).clear();
		driver.findElement(By.xpath("//*[contains(@id, 'page_pebempl_pebemplAdjServiceDate')]"));

		// Service dates seniority
		// *[@id="page_pebempl_pebemplSeniorityDate1527291182054"]

		// Service dates first date worked
		// *[@id="page_pebempl_pebemplFirstWorkDate1527291182094"]

		// Service dates last worked
		// *[@id="page_pebempl_pebemplLastWorkDate1527291182131"]

		// lEAVE OF ABSENSE REASON
		// *[@id="#pebemplTreaCode"]

		// Termiknation date
		// *[@id="page_pebempl_pebemplTermDate1527291182248"]

		// Leave of absense reason
		// *[@id="#pebemplLreaCode"]

		// Leave of absense begin date
		// *[@id="page_pebempl_pebemplLoaBegDate1527291182347"]

		// leave of absense end date
		// *[@id="page_pebempl_pebemplLoaEndDate1527291182325"]

		// Hiring location
		// *[@id='#pebemplJblnCode']
		WebElement empclass2 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplJblnCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplJblnCode']")).clear();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='#pebemplJblnCode']")).sendKeys(JblnCode);

		// HIring location college
		// *[@id='#pebemplCollCode']
		WebElement empclass3 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplCollCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplCollCode']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplCollCode']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplCollCode']")).sendKeys(CollCode);

		// Hiring location campus
		// *[@id="#pebemplCampCode"]
		WebElement empclass4 = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='#pebemplCampCode']")));
		driver.findElement(By.xpath("//*[@id='#pebemplCampCode']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplCampCode']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='#pebemplCampCode']")).sendKeys(CampCode);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id='save-bt']/a/span")).click();

		Thread.sleep(3000);

		WebElement confirmsave = (new WebDriverWait(driver, 120)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p")));
		driver.findElement(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p"));

		Thread.sleep(3000);

		worksheet.getRow(1).createCell(17).setCellValue(role);

		Thread.sleep(5000);

		FileOutputStream fileout = new FileOutputStream(new File(configM.getExcelPathfromscript()));
		workbook.write(fileout);
		fileout.close();
		
	}

}
