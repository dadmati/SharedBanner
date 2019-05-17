package pom.Banner9Common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
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

public class Banner9SSBEditInfo {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	 * Enter information about class: This class will click on the go button for
	 * every Banner 9 page.
	 * 
	 */
	public Banner9SSBEditInfo(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;

	public void editPersonalDetails(String MarStatus, String prefFirst, String click) throws Exception {

	/*	String mod = driver.findElement(By.className("pi-modal-title")).getText();
		System.out.println("mod = " + mod);

		boolean modtest = driver.findElements(By.xpath(".//*[@id='firstName']")).size() != 0;
		System.out.println("modtest = " + modtest);*/

		/*
		 * WebDriverWait block = new WebDriverWait(driver,10);
		 * block.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * className("ute-pay-now-modalContent")));
		 * driver.switchTo().frame("sema"); WebElement pan; pan =
		 * modal.findElement(By.id("pan"));
		 */

		//
		/*
		 * test.info("Enter firstname"); WebElement clickSend1 = (new
		 * WebDriverWait(driver, 10))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ".//*[@id='firstName']")));
		 * driver.findElement(By.xpath(".//*[@id='firstName']")).click();
		 * Thread.sleep(500); test.pass("Enter firstname");
		 * 
		 * test.info("Enter middlename"); WebElement clickSend2 = (new
		 * WebDriverWait(driver, 120))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ".//*[@id='middleName']")));
		 * driver.findElement(By.xpath(".//*[@id='middleName']")).click();
		 * Thread.sleep(500); test.pass("Enter middlename");
		 * 
		 * test.info("Enter lastname"); WebElement clickSend3 = (new
		 * WebDriverWait(driver, 120))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ".//*[@id='lastName']")));
		 * driver.findElement(By.xpath(".//*[@id='lastName']")).click();
		 * Thread.sleep(500); test.pass("Enter lastname");
		 * 
		 * test.info("Enter dob"); WebElement clickSend4 = (new
		 * WebDriverWait(driver, 120))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ".//*[@id='dateOfBirth']")));
		 * driver.findElement(By.xpath(".//*[@id='dateOfBirth']")).click();
		 * Thread.sleep(500); test.pass("Enter dob");
		 * 
		 * test.info("Enter Gender"); WebElement clickSend5 = (new
		 * WebDriverWait(driver, 120))
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ".//*[@id='legalSex']")));
		 * driver.findElement(By.xpath(".//*[@id='legalSex']")).click();
		 * Thread.sleep(500); test.pass("Enter Gender");
		 */

		// Marital status
		// (.//*[@class='select2-arrow'])[1]
		WebElement clickSend6 = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@class='select2-arrow'])[1]")));
		driver.findElement(By.xpath("(.//*[@class='select2-arrow'])[1]")).click();
		Thread.sleep(500);
		
		WebElement mar = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id, 'select2-chosen-')][contains(text(),'" + MarStatus + "')]")));

		Actions actionsMar = new Actions(driver);
		actionsMar.moveToElement(driver.findElement(By.xpath("//*[contains(@id, 'select2-chosen-')][contains(text(),'" + MarStatus + "')]")));
		Thread.sleep(2000);
		actionsMar.click();
		Thread.sleep(2000);
		actionsMar.build().perform();
		
		//driver.findElement(By.xpath("//*[contains(@id, 'select2-chosen-')][contains(text(),'" + MarStatus + "')]"))
		//		.click();

		// *[contains(@id, 'select2-chosen-')][contains(text(),'Single')]
		// *[contains(@id, 'select2-chosen-')][contains(text(),'Married')]
		// *[contains(@id, 'select2-chosen-')][contains(text(),'Not Provided')]
		// *[contains(@id, 'select2-chosen-')][contains(text(),'Separated')]
		// *[contains(@id, 'select2-chosen-')][contains(text(),'I Decline to
		// Respond')]
		// *[contains(@id, 'select2-chosen-')][contains(text(),'Divorced')]

		// <div class="select2-container" id="s2id_autogen1" title="Select
		// Marital Status" style="width: 100%;"><a href="javascript:void(0)"
		// class="select2-choice" tabindex="-1"> <span class="select2-chosen"
		// id="select2-chosen-2">I Decline to Respond</span><abbr
		// class="select2-search-choice-close"></abbr> <span
		// class="select2-arrow" role="presentation"><b
		// role="presentation"></b></span></a><label for="s2id_autogen2"
		// class="select2-offscreen"></label><input class="select2-focusser
		// select2-offscreen" type="text" aria-haspopup="true" role="button"
		// aria-describedby="screen-reader-label-2"
		// aria-labelledby="select2-chosen-2" id="s2id_autogen2"
		// tabindex="0"></div>

		// test.info("Enter preferredFirstName");
		WebElement preferFirst = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='preferredFirstName']")));
		driver.findElement(By.xpath(".//*[@id='preferredFirstName']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='preferredFirstName']")).clear();
		Thread.sleep(500);
		driver.findElement(By.xpath(".//*[@id='preferredFirstName']")).sendKeys(prefFirst);
		// test.pass("Enter preferredFirstName");

		// Personal pronoun
		// (.//*[@class='select2-arrow'])[2]
		WebElement persPronoun = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@class='select2-arrow'])[2]")));
		//driver.findElement(By.xpath("(.//*[@class='select2-arrow'])[2]")).click();
		WebElement perPronoun = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@class='select2-arrow'])[2]")));

		Actions actionsperPronoun = new Actions(driver);
		actionsperPronoun.moveToElement(driver.findElement(By.xpath("(.//*[@class='select2-arrow'])[2]")));
		Thread.sleep(2000);
		actionsperPronoun.click();
		Thread.sleep(2000);
		actionsperPronoun.build().perform();
		Thread.sleep(500);

		// Gender Identification
		// (.//*[@class='select2-arrow'])[3]
		WebElement genID = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@class='select2-arrow'])[3]")));
		//driver.findElement(By.xpath("(.//*[@class='select2-arrow'])[3]")).click();
		
		WebElement geID = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@class='select2-arrow'])[3]")));

		Actions actionsgeID = new Actions(driver);
		actionsgeID.moveToElement(driver.findElement(By.xpath("(.//*[@class='select2-arrow'])[3]")));
		Thread.sleep(2000);
		actionsgeID.click();
		Thread.sleep(2000);
		actionsgeID.build().perform();
		Thread.sleep(500);

		// Click cancel
		
	
		if (click.equalsIgnoreCase("cancel")) 
		{			
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickCancel();			
		} 
		
		else if (click.equalsIgnoreCase("update")) 
		{
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickUpdate();
		}



		// Add Click update

		

		 

	}

	public void editEmail(String email, String comment, String click) throws Exception 
	{
		
		//Edit email address
	  	Banner9CommonClickDeleteSend c1 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		c1.clickDelSend(".//*[@id='emailAddr']", email);		
	
        //Comment
		Banner9CommonClickDeleteSend c2 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		c2.clickDelSend(".//*[@id='email-cmnt']", comment);
		
		
		if (click.equalsIgnoreCase("cancel")) 
		{			
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickCancel();			
		} 
		
		else if (click.equalsIgnoreCase("update")) 
		{
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickUpdate();
		}
		
		
		
	}

	public void editPhoneNumber(String area, String phone, String internat, String click) throws Exception {
		
		//Area code
		Banner9CommonClickDeleteSend c1 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		c1.clickDelSend(".//*[@placeholder='Area Code']", area);
		
		
		//Phone
		Banner9CommonClickDeleteSend c2 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		c2.clickDelSend(".//*[@placeholder='Phone Number']", phone);
		
		
		//International number
		Banner9CommonClickDeleteSend c3 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		c3.clickDelSend(".//*[@placeholder='International Phone Number']", internat);
		
		
		if (click.equalsIgnoreCase("Cancel")) 
		{			
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickCancel();			
		} 
		
		else if (click.equalsIgnoreCase("Update")) 
		{
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickUpdatePhone();
		}
		
	}

	public void editAddress(String from, String until, String ad1, String ad2, String ad3, String ad4, String city, String state, String county, String zip, String country) throws Exception {
		
		//Valid from
		Banner9CommonClickDeleteSend add1 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add1.clickDelSend(".//*[@id='addrFromDate']", from);
		
		//Valid until
		Banner9CommonClickDeleteSend add2 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add2.clickDelSend(".//*[@aria-label='Valid Until']", until);	
		
		//Add1
		Banner9CommonClickDeleteSend add3 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add3.clickDelSend(".//*[@id='addrLine1']", ad1);
		
		//Add2
		Banner9CommonClickDeleteSend add4 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add4.clickDelSend(".//*[@id='addrLine2']", ad2);
		
		//Add3
		Banner9CommonClickDeleteSend add5 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add5.clickDelSend(".//*[@id='addrLine3']", ad3);
		
		//Add4
		Banner9CommonClickDeleteSend add6 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add6.clickDelSend(".//*[@id='addrLine4']", ad4);	
		
		//City
		Banner9CommonClickDeleteSend add7 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add7.clickDelSend(".//*[@id='city']", city);	
		
		//State
		//<span class="select2-chosen" id="select2-chosen-22">Florida</span>
		
		//Banner9CommonClickDeleteSend add8 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		//add8.clickDropDown("(.//*[@class='select2-arrow'])[2]", "//*[contains(@id, 'select2-chosen-')][contains(text(),'"+state+"')]");	
		    //.//*[@class='select2-arrow']
		   //*[contains(@id, 'select2-chosen-')][contains(text(),'Florida')]
		
		//a[contains(text(),'Broward')]
		//*[contains(@class, 'select2-match')][contains(text(),'Broward')]
		//County
		//<span class="select2-arrow" role="presentation"><b role="presentation"></b></span>
		//Banner9CommonClickDeleteSend add9 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		//add9.clickDropDown("(.//*[@class='select2-arrow'])[3]", "//*[contains(@id, 'select2-chosen-')][contains(text(),'"+county+"')]");	

		
		//Zip
		//<input ng-model="address.zip" ng-blur="zipFocused=false; removeAddressFieldErrors()" ng-focus="zipFocused=true" ng-class="[(!!zipErrMsg &amp;&amp; !zipFocused ? 'input-field-error' : null)]" class="text-input-field semi-bold form-spacing ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" placeholder="Enter Zip Code" maxlength="30" id="zip">
		Banner9CommonClickDeleteSend add10 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add10.clickDelSend(".//*[@placeholder='Phone Number']", zip);
		
		//Country
		//<span class="select2-arrow" role="presentation"><b role="presentation"></b></span>
		//Banner9CommonClickDeleteSend add11 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		//add11.clickDropDown("(.//*[@class='select2-arrow'])[4]", "//*[contains(@id, 'select2-chosen-')][contains(text(),'"+country+"')]");	

	}

	public void editEmergencyContact() throws Exception {

	}

	public void editAdditionalDetails() throws Exception {

	}

	public void editOther() throws Exception 
	{

	}
	
	public void clickEditPersonalDetails() throws Exception 
	{
		
		WebElement editPersonalInfo = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("(.//*[@class='icon-edit-CO'])[1]")));
		 
     Actions actions = new Actions(driver);
     actions.moveToElement(driver.findElement(By.xpath("(.//*[@class='icon-edit-CO'])[1]")));
     Thread.sleep(500);
     actions.click();
     Thread.sleep(500);
     actions.build().perform();

	}
	
	public void clickEditEmail() throws Exception 
	{
		
		WebElement editEmail = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("(.//*[@class='icon-edit-CO'])[2]")));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(driver.findElement(By.xpath("(.//*[@class='icon-edit-CO'])[2]")));
	 Thread.sleep(500);
	 actions.click();
	 Thread.sleep(500);
	 actions.build().perform();

	}
	
	public void clickEditPhone() throws Exception 
	{
		
		 WebElement editPhone = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@class='icon-edit-CO'])[3]")));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("(.//*[@class='icon-edit-CO'])[3]")));
		 Thread.sleep(500);
		 actions.click();
		 Thread.sleep(500);
		 actions.build().perform();

	}
	
	public void clickEditAddress() throws Exception 
	{
		
		 WebElement editPhone = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@class='icon-edit-CO'])[9]")));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("(.//*[@class='icon-edit-CO'])[9]")));
		 Thread.sleep(500);
		 actions.click();
		 Thread.sleep(500);
		 actions.build().perform();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
