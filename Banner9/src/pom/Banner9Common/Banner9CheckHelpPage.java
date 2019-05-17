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

public class Banner9CheckHelpPage {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	 * Enter information about class: Match ad password length – example minimum
	 * 8 characters, max 32, etc.. (on me to get the current AD) Use the same
	 * criteria that Banner uses for the password(Done, must confirm) Same
	 * password complexity as Banner(Done, must confirm) Show asterisks when
	 * entering in password and ask twice just to make sure(Done, must confirm)
	 * Send email to nova email when password is reset only when successful •
	 * The email should reference the access username Audit each time a user
	 * attempts to log in and reset – include successful and failed attempts
	 * After 3 attempts lock out Lock out grace period is 5, 10 minutes, etc
	 * Change title and label to Microsoft access password Look and feel – Jimmy
	 * and Melisa Must pass security scan and security review
	 * 
	 * 
	 */
	public Banner9CheckHelpPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;
	
	public void ApexLogin(String un, String pw) throws Exception
	{
		
		WebElement confirmLogo = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 't-Login-logo ')]")));
		driver.findElement(By.xpath("//*[contains(@class, 't-Login-logo ')]")).click();
	
		
		WebElement confirmHeading = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, '_heading')][contains(text(),'Banner Password Reset')]")));
		driver.findElement(By.xpath("//*[contains(@id, '_heading')][contains(text(),'Banner Password Reset')]")).click();
		
		
		WebElement confirmLoginRegion = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@class, 't-Login-region t-Form--stretchInputs t-Form--labelsAbove ')]")));
		driver.findElement(By.xpath("//*[contains(@class, 't-Login-region t-Form--stretchInputs t-Form--labelsAbove ')]")).click();
		
		
		//Username field
		WebElement un1 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='P101_USERNAME']")));
		driver.findElement(By.xpath(".//*[@id='P101_USERNAME']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='P101_USERNAME']")).clear();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@id='P101_USERNAME']")).sendKeys(un);
		sendKeySlower sendKey = PageFactory.initElements(driver, sendKeySlower.class);
 		sendKey.TypeInField(".//*[@id='P101_USERNAME']", un);
	
		
		//Password field
		WebElement pw1 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='P101_PASSWORD']")));
		driver.findElement(By.xpath(".//*[@id='P101_PASSWORD']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='P101_PASSWORD']")).clear();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@id='P101_PASSWORD']")).sendKeys(pw);
		sendKey.TypeInField(".//*[@id='P101_PASSWORD']", pw);
		
		
		WebElement logIn = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='t-Button-label'][contains(text(),'LOG IN')]")));
		//driver.findElement(By.xpath(".//*[@class='t-Button-label'][contains(text(),'Log In')]")).click();
	     Actions actions = new Actions(driver);
	     actions.moveToElement(driver.findElement(By.xpath(".//*[@class='t-Button-label'][contains(text(),'LOG IN')]")));
	     Thread.sleep(1000);
	     actions.click();
	     Thread.sleep(1000);
	     actions.build().perform();
	
	}


	public void newPassword(String newPW1, String newPW2, String message) throws Exception
	{
			
		//after login
		
		WebElement confirmPageHeaderInfo = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(),'Microsoft Access Banner Password Reset')]")));
		
		
		//New Banner password
		// .//*[@name='BANNER_PASSWORD'][contains(text(),'Log In')]
		WebElement confirmPw1 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='BANNER_PASSWORD']")));
		driver.findElement(By.xpath(".//*[@name='BANNER_PASSWORD']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@name='BANNER_PASSWORD']")).clear();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@name='BANNER_PASSWORD']")).sendKeys(newPW1);
		sendKeySlower sendKey = PageFactory.initElements(driver, sendKeySlower.class);
 		sendKey.TypeInField(".//*[@name='BANNER_PASSWORD']", newPW1);
		
		//Confirm password
		// .//*[@name='CONFIRM_PASSWORD']
		WebElement confirmPw2 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@name='CONFIRM_PASSWORD']")));
		driver.findElement(By.xpath(".//*[@name='CONFIRM_PASSWORD']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@name='CONFIRM_PASSWORD']")).clear();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@name='CONFIRM_PASSWORD']")).sendKeys(newPW2);
		sendKey.TypeInField(".//*[@name='CONFIRM_PASSWORD']", newPW2);
		
		//Click confirm
		// .//*[@class='t-Button-label'][contains(text(),'Submit')]
		WebElement clickConfirm = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='t-Button-label'][contains(text(),'Submit')]")));
		//driver.findElement(By.xpath(".//*[@class='t-Button-label'][contains(text(),'Submit')]")).click();
		   Actions actions = new Actions(driver);
		     actions.moveToElement(driver.findElement(By.xpath(".//*[@class='t-Button-label'][contains(text(),'Submit')]")));
		     Thread.sleep(1000);
		     actions.click();
		     Thread.sleep(1000);
		     actions.build().perform();
		
		//Confirm message
		WebElement confirmMessage = (new WebDriverWait(driver, 60))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='display_only apex-item-display-only'][contains(text(),'"+message+"')]")));
		driver.findElement(By.xpath(".//*[@class='display_only apex-item-display-only'][contains(text(),'"+message+"')]"));

	}
	public void logOut() throws Exception
	{
		WebElement confirmLogout = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='t-Button-label'][contains(text(),'Log Out')]")));
				
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath(".//*[@class='t-Button-label'][contains(text(),'Log Out')]")));
		Thread.sleep(1000);
		actions.click();
		Thread.sleep(1000);
		actions.build().perform();
	}
	// 

}
