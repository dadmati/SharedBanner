package pom.Banner9SSBCommon;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
import org.testng.Reporter;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
import commonfunctions.GetScreenshot;

public class Banner9SSBGeneralDirectDeposit {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	 * Enter information about class: This class will click on the go button for
	 * every Banner 9 page.
	 * 
	 */
	public Banner9SSBGeneralDirectDeposit(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;

	public void DirectDepositAddNew() throws Exception 
	{

		Thread.sleep(5000);
		//**************ADD NEW
		
			WebElement addElement = driver.findElement(By.xpath("(//*[@class='icon-add-CO'])[1]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addElement);
			Thread.sleep(500); 
			
			////test.info("Click add new");
			WebElement addNew = (new WebDriverWait(driver, 120)).until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='icon-add-CO'])[1]")));
			driver.findElement(By.xpath("(//*[@class='icon-add-CO'])[1]")).click();
			////test.pass("Click add new passed");

	}
	
	public void DirectDepositCreateFromExistingAccount() throws Exception 
	{

		Thread.sleep(5000);
		////test.info("Click Create from existing account information ");
		WebElement create1 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-labelledby='create-opt-existing']")));
		driver.findElement(By.xpath("//*[@aria-labelledby='create-opt-existing']")).click();
		////test.pass("Click Create from existing account information  passed");
		
		//Check box
		////test.info("Check box");
		WebElement clickBox = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='existing-disclaimer']")));
		driver.findElement(By.xpath("//*[@id='existing-disclaimer']")).click();
		////test.pass("Check box passed");
		
		
		////test.info("Click save new deposit");
		WebElement saveNew = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ng-click='saveAccount()']")));
		driver.findElement(By.xpath("//*[@ng-click='saveAccount()']")).click();
		////test.pass("Click save new deposit passed");

	}
	
	public void DirectDepositCreateFromNew(String routNum, String accountNum, String acctType) throws Exception 
	{

		//test.info("Click Create new");
		WebElement create2 = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-labelledby='create-opt-new']")));
		driver.findElement(By.xpath("//*[@aria-labelledby='create-opt-new']")).click();
		//test.pass("Click Create new passed");

		// BANK ROUTING NUMBER
		/*
		 * <input ng-model="account.bankRoutingInfo.bankRoutingNum"
		 * ng-blur="routNumFocused=false; validateRoutingNum()"
		 * ng-focus="routNumFocused=true" ng-disabled="!creatingNewAccount" ng-
		 * class="[(routingNumErr &amp;&amp; !routNumFocused ? 'input-field-error' : null)]"
		 * class="text-input-field semi-bold form-spacing ng-pristine ng-valid ng-empty ng-touched input-field-error"
		 * id="routing-number" type="text" placeholder="Bank Routing Number">
		 */ //test.info("Enter routing number");
		WebElement routingNum = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ng-model='account.bankRoutingInfo.bankRoutingNum']")));
		driver.findElement(By.xpath("//*[@ng-model='account.bankRoutingInfo.bankRoutingNum']")).click();
		driver.findElement(By.xpath("//*[@ng-model='account.bankRoutingInfo.bankRoutingNum']")).clear();
		driver.findElement(By.xpath("//*[@ng-model='account.bankRoutingInfo.bankRoutingNum']")).sendKeys(routNum);
		//test.pass("Enter routing number passed");

		// ACCOUNT NUMBER
		/*
		 * <input data-ng-model="account.bankAccountNum"
		 * ng-blur="acctNumFocused=false; validateAccountNum()"
		 * ng-focus="acctNumFocused=true" ng-disabled="!creatingNewAccount" ng-
		 * class="['text-input-field', 'semi-bold', 'form-spacing', (accountNumErr &amp;&amp; !acctNumFocused ? 'input-field-error' : null)]"
		 * id="account-number" title="" type="text" placeholder="Account Number"
		 * class="ng-pristine ng-untouched ng-valid ng-empty text-input-field semi-bold form-spacing input-field-error"
		 * >
		 */ //test.info("Enter account number");
		WebElement acctNum = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-ng-model='account.bankAccountNum']")));
		driver.findElement(By.xpath("//*[@data-ng-model='account.bankAccountNum']")).click();
		driver.findElement(By.xpath("//*[@data-ng-model='account.bankAccountNum']")).clear();
		driver.findElement(By.xpath("//*[@data-ng-model='account.bankAccountNum']")).sendKeys(accountNum);
		//test.pass("Enter account number passed");

		// ACCOUNT TYPE
		/*
		 * <button dropdown-helper="begin" ng-focus="acctTypeFocused=true"
		 * ng-blur="acctTypeFocused=false" ng-
		 * class="(accountTypeErr ? 'dropdown-btn input-field-error' : 'dropdown-btn')"
		 * data-toggle="dropdown" aria-haspopup="true"
		 * aria-labelledby="select-acct-type account-type"
		 * class="dropdown-btn input-field-error"> <span
		 * class="float-l semi-bold form-spacing"> <choose-account
		 * account="account">Select a Type</choose-account></span> <span
		 * class="float-r form-spacing down-caret caret-color"></span> </button>
		 */
		//test.info("Choose account type");
		WebElement dropDown = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@data-toggle='dropdown'])[4]")));
		driver.findElement(By.xpath("(//*[@data-toggle='dropdown'])[4]")).click();
		
		if(acctType.equalsIgnoreCase("Checking"))
		{
		 driver.findElement(By.xpath("//*[@tabindex='0'][contains(text(),'Checking')]")).click();

		}
		else if(acctType.equalsIgnoreCase("Savings"))
		{
			driver.findElement(By.xpath("//*[@tabindex='0'][contains(text(),'Savings')]")).click();
		}
		else
		{
			
		}
		//driver.findElement(By.xpath("//*[@tabindex='0'][contains(text(),'Checking')]")).click();
		//driver.findElement(By.xpath("//*[@tabindex='0'][contains(text(),'Savings')]")).click();
		//test.pass("Choose account type passed");
		
		
		
		//tabindex="0">Checking</a>
		//tabindex="0">Savings</a>
		
		
		//Check box
				//test.info("Check box");
				WebElement clickBox2 = (new WebDriverWait(driver, 120)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='existing-disclaimer']")));
				driver.findElement(By.xpath("//*[@id='existing-disclaimer']")).click();
				//test.pass("Check box passed");
				
				
				//test.info("Click save new deposit");
				WebElement saveNew2 = (new WebDriverWait(driver, 120)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ng-click='saveAccount()']")));
				driver.findElement(By.xpath("//*[@ng-click='saveAccount()']")).click();
				//test.pass("Click save new deposit passed");

	}
	
	public void DirectDepositConfirmPrenote() throws Exception 
	{

		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("(//*[@ng-class='statusClass'][contains(text(),'Prenote')])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		//Confirm prenote 
		////test.info("Confirm prenote");
		WebElement prenote = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@ng-class='statusClass'][contains(text(),'Prenote')])[1]")));
		//driver.findElement(By.xpath("(//*[@ng-class='statusClass'][contains(text(),'Prenote')])[1]")).click();
		////test.pass("Confirm prenote passed");

	}
	
	public void DirectDepositDeleteEntry() throws Exception 
	{

		////test.info("Delete entry");
		WebElement delete1 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@type='checkbox'])[1]")));
		driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
		
		WebElement delete2 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='delete-account-link']")));
		driver.findElement(By.xpath("//*[@class='delete-account-link']")).click();
		
		WebElement delete3 = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='notification-flyout-item'][contains(text(),'Delete')]")));
		driver.findElement(By.xpath("//*[@class='notification-flyout-item'][contains(text(),'Delete')]")).click();
    	////test.pass("Delete entry passed");

	}
	
	
	
	
	

}
