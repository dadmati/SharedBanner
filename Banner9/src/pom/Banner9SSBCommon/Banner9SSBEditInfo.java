package pom.Banner9SSBCommon;

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
import pom.Banner9Common.Banner9CommonClickDeleteSend;

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

	//***EDIT METHODS
	
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
		add10.clickDelSend(".//*[@placeholder='Enter Zip Code']", zip);
		
		//Country
		//<span class="select2-arrow" role="presentation"><b role="presentation"></b></span>
		//Banner9CommonClickDeleteSend add11 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		//add11.clickDropDown("(.//*[@class='select2-arrow'])[4]", "//*[contains(@id, 'select2-chosen-')][contains(text(),'"+country+"')]");	

	}

	public void editEmergencyContact(String first, String middle, String last, String areaCode, String phoneNum, String ext, String add1, String add2, String add3, String add4, String city, String zip) throws Exception {
		
		//firstname
		Banner9CommonClickDeleteSend add10 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
		add10.clickDelSend(".//*[@placeholder='Enter First Name']", first);
		//<input ng-model="emergencyContact.firstName" ng-blur="firstNameFocused=false; removeContactFieldErrors()" ng-focus="firstNameFocused=true" ng-class="[(!!firstNameErrMsg &amp;&amp; !firstNameFocused ? 'input-field-error' : null)]" class="text-input-field semi-bold form-spacing ng-pristine ng-valid ng-not-empty ng-valid-maxlength ng-touched" type="text" placeholder="Enter First Name" maxlength="60" id="firstName">
		
		//middle name
		add10.clickDelSend(".//*[@placeholder='Enter Middle Name']", middle);
		//<input ng-model="emergencyContact.middleInitial" class="text-input-field semi-bold form-spacing ng-pristine ng-valid ng-not-empty ng-valid-maxlength ng-touched" type="text" placeholder="Enter Middle Name" maxlength="60" id="middleName">
		
		//last name
		add10.clickDelSend(".//*[@placeholder='Enter Last Name']", last);
		//<input ng-model="emergencyContact.lastName" ng-blur="lastNameFocused=false; removeContactFieldErrors()" ng-focus="lastNameFocused=true" ng-class="[(!!lastNameErrMsg &amp;&amp; !lastNameFocused ? 'input-field-error' : null)]" class="text-input-field semi-bold form-spacing ng-pristine ng-valid ng-not-empty ng-valid-maxlength ng-touched" type="text" placeholder="Enter Last Name" maxlength="60" id="lastName">
		
		//relationship
		//<span class="select2-arrow" role="presentation"><b role="presentation"></b></span>		
		
		//phone area code
		add10.clickDelSend(".//*[@placeholder='Area Code']", areaCode);
		//<input ng-model="emergencyContact.phoneArea" class="text-input-field semi-bold form-spacing pi-emer-phone-field ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" placeholder="Area Code" maxlength="6" id="phoneArea">
		
		//Phone number
		add10.clickDelSend(".//*[@placeholder='Phone Number']", phoneNum);
		//<input ng-model="emergencyContact.phoneNumber" class="text-input-field semi-bold form-spacing pi-emer-phone-field ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" id="phoneNumber" placeholder="Phone Number" maxlength="12">
		
		//Extension
		add10.clickDelSend(".//*[@placeholder='Extension']", ext);
		//<input ng-model="emergencyContact.phoneExtension" class="text-input-field semi-bold form-spacing pi-emer-phone-field ng-pristine ng-untouched ng-valid ng-empty ng-valid-maxlength" type="text" placeholder="Extension" maxlength="10" id="phoneExtension">
		
		//Add1
		add10.clickDelSend(".//*[@placeholder='Enter Address Line 1']", add1);
		//<input ng-model="emergencyContact.streetLine1" ng-blur="streetLine1Focused=false; removeContactFieldErrors()" ng-focus="streetLine1Focused=true" ng-class="[(!!streetLine1ErrMsg &amp;&amp; !streetLine1Focused ? 'input-field-error' : null)]" class="text-input-field semi-bold form-spacing ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" placeholder="Enter Address Line 1" maxlength="75" id="addrLine1">
		
		//Add2
		add10.clickDelSend(".//*[@placeholder='Enter Address Line 2']", add2);
		//<input ng-model="emergencyContact.streetLine2" class="text-input-field semi-bold form-spacing ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" placeholder="Enter Address Line 2" maxlength="75" id="addrLine2">
		
		//Add3
		add10.clickDelSend(".//*[@placeholder='Enter Address Line 3']", add3);
		//<input ng-model="emergencyContact.streetLine3" class="text-input-field semi-bold form-spacing ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" placeholder="Enter Address Line 3" maxlength="75" id="addrLine3">
		
		//Add4
		add10.clickDelSend(".//*[@placeholder='Enter Address Line 4']", add4);
		//<input ng-model="emergencyContact.streetLine4" class="text-input-field semi-bold form-spacing ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" placeholder="Enter Address Line 4" maxlength="75" id="addrLine4">
		
		//City
		add10.clickDelSend(".//*[@placeholder='Enter City']", city);
		//<input ng-model="emergencyContact.city" ng-blur="cityFocused=false; removeContactFieldErrors()" ng-focus="cityFocused=true" ng-class="[(!!cityErrMsg &amp;&amp; !cityFocused ? 'input-field-error' : null)]" class="text-input-field semi-bold form-spacing ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" placeholder="Enter City" maxlength="50" id="city">
		
		//State
		//<span class="select2-arrow" role="presentation"><b role="presentation"></b></span>
		
		//Zip
		add10.clickDelSend(".//*[@placeholder='Enter Zip Code']", zip);
		//<input ng-model="emergencyContact.zip" ng-blur="zipFocused=false; removeContactFieldErrors()" ng-focus="zipFocused=true" ng-class="[(!!zipErrMsg &amp;&amp; !zipFocused ? 'input-field-error' : null)]" class="text-input-field semi-bold form-spacing ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-maxlength" type="text" placeholder="Enter Zip Code" maxlength="30" id="zip">
		
		//Country
		//<span class="select2-arrow" role="presentation"><b role="presentation"></b></span>
	}

	public void editAdditionalDetailsRaceEthnicity(String click, String click2) throws Exception 
	{
		
     //Click not hispanic or latino
		//.//*[@id='chkEthn_1'][contains(text(),'Go')]
		//<input id="chkEthn_1" name="ethnicity" role="checkbox" value="1" type="checkbox">
		WebElement a = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chkEthn_1']")));

		Actions aa = new Actions(driver);
		aa.moveToElement(driver.findElement(By.xpath(".//*[@id='chkEthn_1']")));
		Thread.sleep(2000);
		aa.click();
		
		//Click hispanic or latino
		//<input id="chkEthn_2" name="ethnicity" role="checkbox" value="2" type="checkbox" checked="true">
		WebElement b = (new WebDriverWait(driver, 60))
				//.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chkEthn_2']")));
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chkEthn_2'][@checked='true']")));
		

		Actions bb = new Actions(driver);
		bb.moveToElement(driver.findElement(By.xpath(".//*[@id='chkEthn_2'][@checked='true']")));
		Thread.sleep(2000);
		bb.click();
		
		//Click American Indian or Alaska Native
		//<input id="chkRace_10" class="raceCheckbox" role="checkbox" name="race" value="10" type="checkbox">
		WebElement cb = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chkRace_10']")));

		Actions cc = new Actions(driver);
		cc.moveToElement(driver.findElement(By.xpath(".//*[@id='chkRace_10']")));
		Thread.sleep(2000);
		cc.click();
		
		//Click Asian India
		//<input id="chkRace_25" class="raceCheckbox" role="checkbox" name="race" value="25" type="checkbox">
		
		//Click black or african american
		//<input id="chkRace_30" class="raceCheckbox" role="checkbox" name="race" value="30" type="checkbox">
		
		//Click Native Hawaiian or other pacific islander
		//<input id="chkRace_30" class="raceCheckbox" role="checkbox" name="race" value="30" type="checkbox">
		
		//Click white
		//<input id="chkRace_40" class="raceCheckbox" role="checkbox" name="race" value="40" type="checkbox" checked="true">
		
		
		//Ask me later
		//<input type="button" id="ask-me-later-btn" value="Ask Me Later" class="secondary-button" data-endpoint="/BannerGeneralSsb/ssb/survey/done">
		
		
		//Continue
		//<input type="button" id="save-btn" value="Continue" class="primary-button">
				
				
				
				if (click.equalsIgnoreCase("asklater")) 
				{			
					Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
					can.clickAddInfoAskMeLater();			
				} 
				
				else if (click.equalsIgnoreCase("continue")) 
				{
					Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
					can.clickUpdateAddInfoContinue();
					
					if(click2.equalsIgnoreCase("cancel"))
					{
						
						//<input type="button" id="ask-me-later-btn" value="Cancel" class="secondary-button" data-endpoint="/BannerGeneralSsb/ssb/survey/done">
						
						WebElement editPersonalInfo = (new WebDriverWait(driver, 60)).until(ExpectedConditions
								.elementToBeClickable(By.xpath(".//*[@value='Cancel']")));
						 
				     Actions actions = new Actions(driver);
				     actions.moveToElement(driver.findElement(By.xpath(".//*[@value='Cancel']")));
				     Thread.sleep(500);
				     actions.click();
				     Thread.sleep(500);
				     actions.build().perform();
						
					}
					else if(click2.equalsIgnoreCase("save"))
					{
						//<input type="button" id="save-btn" value="Save" class="primary-button">
						
						
						WebElement editPersonalInfo = (new WebDriverWait(driver, 60)).until(ExpectedConditions
								.elementToBeClickable(By.xpath(".//*[@value='Save']")));
						 
				     Actions actions = new Actions(driver);
				     actions.moveToElement(driver.findElement(By.xpath(".//*[@value='Save']")));
				     Thread.sleep(500);
				     actions.click();
				     Thread.sleep(500);
				     actions.build().perform();
						
					}
					
					
				}

	}

	public void editOther() throws Exception 
	{

	}
	
	public void editAdditionalDetailsVeteranStatus(String click) throws Exception 
	{
	
		//I identify as one or more of the classifications of protected veteran listed 
		//<input ng-model="veteranClassInfo.choice" class="edit-radio ng-pristine ng-valid ng-not-empty ng-touched" type="radio" name="veteran-category" value="1" id="o-radio-lbl">
		
		
		//Date of Discharge
		//<input date-picker="" ng-model="veteranClassInfo.activeDutySeprDate" pi-input-watcher="" on-select="setSeprDate" ng-blur="seprDateFocused=false; removeVeteranErrors()" ng-focus="seprDateFocused=true" ng-class="[(seprDateErrMsg &amp;&amp; !seprDateFocused ? 'input-error' : null)]" class="pi-date-input input-colors ng-pristine ng-untouched ng-valid hasMultiCalendarPicker ng-empty" placeholder="MM/DD/YYYY" id="seprDate" aria-label="Date of Discharge" title="Press F9 to open the calendar">
		
		
		//Disabled Veteran 
		//<label class="lbl radio-list pi-fix" for="dis-checkbx-lbl">Disabled Veteran</label>
		
		//Active Wartime or campaign Badge Veteran 
		//<label class="lbl radio-list pi-fix" for="act-checkbx-lbl">Active Wartime or campaign Badge Veteran</label>
		
		
		//Armed Forces Service Medal Veteran 
		//<label class="lbl radio-list pi-fix" for="med-checkbx-lbl">Armed Forces Service Medal Veteran</label>
		
		
		//I am a protected veteran, but I choose not to self-identify the classification to which I belong
		//<input ng-model="veteranClassInfo.choice" class="edit-radio ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" name="veteran-category" value="2" id="b-radio-lbl">
		
		//I am not a protected veteran 
		//<input ng-model="veteranClassInfo.choice" class="edit-radio ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" name="veteran-category" value="3" id="v-radio-lbl">
		
		//I am not a veteran 
		//<input ng-model="veteranClassInfo.choice" class="edit-radio ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" name="veteran-category" value="4" id="na-radio-lbl">
		WebElement a = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chkEthn_1']")));

		Actions aa = new Actions(driver);
		aa.moveToElement(driver.findElement(By.xpath(".//*[@id='chkEthn_1']")));
		Thread.sleep(2000);
		aa.click();
		
		//Click hispanic or latino
		//<input id="chkEthn_2" name="ethnicity" role="checkbox" value="2" type="checkbox" checked="true">
		WebElement b = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chkEthn_2']")));

		Actions bb = new Actions(driver);
		bb.moveToElement(driver.findElement(By.xpath(".//*[@id='chkEthn_2']")));
		Thread.sleep(2000);
		bb.click();
		
		//Click American Indian or Alaska Native
		//<input id="chkRace_10" class="raceCheckbox" role="checkbox" name="race" value="10" type="checkbox">
		WebElement cb = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='chkRace_10']")));

		Actions cc = new Actions(driver);
		cc.moveToElement(driver.findElement(By.xpath(".//*[@id='chkRace_10']")));
		Thread.sleep(2000);
		cc.click();
				
				
				if (click.equalsIgnoreCase("cancel")) 
				{			
					Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
					can.clickCancel();			
				} 
				
				else if (click.equalsIgnoreCase("update")) 
				{
					Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
					can.clickUpdateAddInfoContinue();
				}

	}
		
	public void editAdditionalDetailsDisability(String click) throws Exception 
	{
	
		//YES, I HAVE A DISABILITY (or previously had a disability) 
		//<input ng-model="disabilityStatus" class="edit-radio ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" name="disability-status" value="DY" id="dy-radio-lbl">
		WebElement a = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='dy-radio-lbl1']")));

		Actions aa = new Actions(driver);
		aa.moveToElement(driver.findElement(By.xpath(".//*[@id='dy-radio-lbl']")));
		Thread.sleep(2000);
		aa.click();
		
		//NO, I DON'T HAVE A DISABILITY 
		//<input ng-model="disabilityStatus" class="edit-radio ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" name="disability-status" value="DN" id="dn-radio-lbl">
		WebElement b = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='dn-radio-lbl']")));

		Actions bb = new Actions(driver);
		bb.moveToElement(driver.findElement(By.xpath(".//*[@id='dn-radio-lbl']")));
		Thread.sleep(2000);
		bb.click();

		
		//I DON'T WISH TO ANSWER 
		//<input ng-model="disabilityStatus" class="edit-radio ng-valid ng-not-empty ng-dirty ng-valid-parse ng-touched" type="radio" name="disability-status" value="NA" id="na-radio-lbl">

		WebElement cb = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='na-radio-lbl']")));

		Actions cc = new Actions(driver);
		cc.moveToElement(driver.findElement(By.xpath(".//*[@id='na-radio-lbl']")));
		Thread.sleep(2000);
		cc.click();
				
				
				if (click.equalsIgnoreCase("cancel")) 
				{			
					Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
					can.clickCancel();			
				} 
				
				else if (click.equalsIgnoreCase("update")) 
				{
					Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
					can.clickUpdateAddInfoContinue();
				}

	}
	
	public void verifySaveMessage() throws Exception 
	{		
	
	WebElement verifySaved = (new WebDriverWait(driver, 60)).until(ExpectedConditions
			.presenceOfElementLocated(By.xpath(".//*[@id='ariaNotificationCountText'][contains(text(),'Flash notification')]")));
	
	//<li class="notification-item notification-center-message-success"><span class="notification-icon"></span><div class="notification-item-message vertical-align"><span class="notification-flyout-item" tabindex="0"><b class="offscreen" id="ariaNotificationCountText">Flash notification</b>Saved Successfully</span></div></li>

	// .//*[@id='ariaNotificationCountText'][contains(text(),'Saved')]
	}
	//***ADD NEW METHODS
	
	//***DELETE METHODS
	
	//***CLICK METHODS
	
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
				.elementToBeClickable(By.xpath("(.//*[@title='Edit email address'])[1]")));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(driver.findElement(By.xpath("(.//*[@title='Edit email address'])[1]")));
	 Thread.sleep(500);
	 actions.click();
	 Thread.sleep(500);
	 actions.build().perform();

	}
	
	public void clickEditPhone() throws Exception 
	{
		
		 WebElement editPhone = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@title='Edit Phone Number'])[1]")));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("(.//*[@title='Edit Phone Number'])[1]")));
		 Thread.sleep(500);
		 actions.click();
		 Thread.sleep(500);
		 actions.build().perform();
		 
		 

	}
	
	public void clickEditAddress() throws Exception 
	{
		
				
		 WebElement editPhone = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@aria-label='Edit address'])[1]")));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("(.//*[@aria-label='Edit address'])[1]")));
		 Thread.sleep(500);
		 actions.click();
		 Thread.sleep(500);
		 actions.build().perform();

	}
	
	public void clickEditEmergencyContact() throws Exception 
	{
		
				
		 WebElement editPhone = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@title='Edit Emergency Contact'])[1]")));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("(.//*[@title='Edit Emergency Contact'])[1]")));
		 Thread.sleep(500);
		 actions.click();
		 Thread.sleep(500);
		 actions.build().perform();

	}
	
	public void clickEditAddDetailsRaceEthnicity() throws Exception 
	{
		
				
		 WebElement editPhone = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@title='Edit Race and Ethnicity'])[1]")));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("(.//*[@title='Edit Race and Ethnicity'])[1]")));
		 Thread.sleep(500);
		 actions.click();
		 Thread.sleep(500);
		 actions.build().perform();

	}
	
	public void clickEditAdditionalDetailVet() throws Exception 
	{
		/*title="Edit Race and Ethnicity" tabindex="0" */
		
		/*<title="Edit Veteran Classification" tabindex="0*/
		
		/*title="Edit Disability Status" tabindex="0"*/
				
		 WebElement editPhone = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@title='Edit Veteran Classification'])[1]")));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("(.//*[@title='Edit Veteran Classification'])[1]")));
		 Thread.sleep(500);
		 actions.click();
		 Thread.sleep(500);
		 actions.build().perform();

	}
	
	public void clickEditAdditionalDetailDisability() throws Exception 
	{
		/*title="Edit Race and Ethnicity" tabindex="0" */
		
		/*<title="Edit Veteran Classification" tabindex="0*/
		
		/*title="Edit Disability Status" tabindex="0"*/
				
		 WebElement editPhone = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@title='Edit Disability Status'])[1]")));
		 Actions actions = new Actions(driver);
		 actions.moveToElement(driver.findElement(By.xpath("(.//*[@title='Edit Disability Status'])[1]")));
		 Thread.sleep(500);
		 actions.click();
		 Thread.sleep(500);
		 actions.build().perform();

	}
	
	public void clickAddEmail() throws Exception
	{ 	
	    
	    WebElement clickEmail = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@ng-click='openEditEmailModal()']")));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(driver.findElement(By.xpath(".//*[@ng-click='openEditEmailModal()']")));
	 Thread.sleep(500);
	 actions.click();
	 Thread.sleep(500);
	 actions.build().perform();
	    
	}

	public void AddEmail(String searchMessageResult, String emailType, String email, String comment, String preferred, String click) throws Exception 
	{
		
		//Email type
		//<span class="select2-chosen" id="select2-chosen-16">Select Email Type</span>
		Banner9CommonClickDeleteSend c0 = PageFactory.initElements(driver, Banner9CommonClickDeleteSend.class);
        c0.clickDropDownandType("//*[contains(@id, 'select2-chosen-')][contains(text(),'Select Email Type')]", "//*[@id='s2id_autogen2_search']", "//*[@id='s2id_autogen2_search']", emailType);

        Thread.sleep(3000);
        
    	if(searchMessageResult.equalsIgnoreCase("No Matches Found"))
		{
			
    		Banner9SSBVerifyPersonalInfo c1 = PageFactory.initElements(driver, Banner9SSBVerifyPersonalInfo.class);
    		c1.verifyEmailInfo(searchMessageResult);
			
		}
		else
		{
			System.out.println("Do not search message");
		}
        
        Thread.sleep(3000);

      //*[@id="email-preferred"]
		if(preferred.equalsIgnoreCase("Yes"))
		{
			System.out.println("Click preffered");
			
			 WebElement clickEmail = (new WebDriverWait(driver, 60)).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[@id='email-preferred']")));
			 Actions actions = new Actions(driver);
			 actions.moveToElement(driver.findElement(By.xpath("//*[@id='email-preferred']")));
			 Thread.sleep(500);
			 actions.click();
			 Thread.sleep(500);
			 actions.build().perform();
			
		}
		else
		{
			System.out.println("Do not click preffered");
		}
		
        Thread.sleep(3000);

		
		if (click.equalsIgnoreCase("add")) 
		{			
			
			System.out.println("Click add");
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickAddinEmail();	
		} 
		
		else if (click.equalsIgnoreCase("close")) 
		{
			
			System.out.println("Click close");
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickX();
		}
		
		Thread.sleep(5000);
		
		if (click.equalsIgnoreCase("add")) 
		{			
			
			//Confirm that the message appears of "enter email address"
			 WebElement clickEmail = (new WebDriverWait(driver, 60)).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(".//*[@aria-live='assertive'][contains(text(),'Email Address is a required field')]")));
			
			 WebElement enterEmail = (new WebDriverWait(driver, 60)).until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//*[@id='emailAddr']")));
			 Actions actions = new Actions(driver);
			 actions.moveToElement(driver.findElement(By.xpath("//*[@id='emailAddr']")));
			 Thread.sleep(500);
			 actions.click();
			 Thread.sleep(500);
			 actions.build().perform();
			 Thread.sleep(500);
			 actions.sendKeys(email);
			 Thread.sleep(500);
			 actions.build().perform();		 
			 
		} 
		
		else if (click.equalsIgnoreCase("close")) 
		{
			
		
		}
		
		Thread.sleep(3000);
		
		
		if (click.equalsIgnoreCase("add")) 
		{			
			
			System.out.println("Click add");
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickAddinEmail();	
			Thread.sleep(3000);
			can.clickAddinEmail();
		} 
		
		else if (click.equalsIgnoreCase("close")) 
		{
			
			System.out.println("Click close");
			Banner9SSBCommonUpdateCancel can = PageFactory.initElements(driver, Banner9SSBCommonUpdateCancel.class);
			can.clickX();
		}
	
				
		
		
		
	}

	
	
	
	

}
