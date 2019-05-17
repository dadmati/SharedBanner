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

public class Banner9CommonBypassApprovals {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will bypass any approvals by clicking x.

	 */
	public Banner9CommonBypassApprovals(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;


	public void byPassApprovals() throws Exception{
		
		
		//test.info("Wait for loader to complete");
		Banner9CommonWaitForLoader waitForLoader = PageFactory.initElements(driver, Banner9CommonWaitForLoader.class);
		waitForLoader.waitForLoader();
		//test.pass("Wait for loader to complete passed");
		
		Thread.sleep(5000);
		
		//Use this method to bypass the approval screen when bringing up a page in the 
		//finance module
		if (driver.findElements(By.xpath(".//*[@tabindex='0'][contains(text(),'Approvals Notification')]")).size() != 0) 
		{
			//Approval present, click x to bypass
			System.out.println("Approval present, click x");
			WebDriverWait click1 = new WebDriverWait(driver, 30);
			click1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ba ba-close']")));
			driver.findElement(By.xpath(".//*[@class='ba ba-close']")).click();		
			} else {
			System.out.println("Approval NOT present, all clear");
			//Approval not present, all clear, no steps necessary.
			}
			Thread.sleep(3000);
			
			browserShake shake = PageFactory.initElements(driver, browserShake.class);
			shake.browserShake(driver, 1230, 732);
			
			Thread.sleep(500);
			
			driver.manage().window().maximize();
		}
	
	public void byPassESS() throws Exception
	{
		//Check
				if (driver.findElements(By.xpath(".//*[@class='ui-collapsiblepanel-header ui-helper-reset ui-state-default ui-state-active ui-corner-top'][contains(text(),'Distribution Parameters')]")).size() != 0) 
				{
					//If present, click x to bypass
					System.out.println("Approval present, click x");
					WebDriverWait click1 = new WebDriverWait(driver, 30);
					click1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ba ba-close']")));
					driver.findElement(By.xpath(".//*[@class='ba ba-close']")).click();
					
					} else {
						
					System.out.println("Approval NOT present, all clear");
					//Not present, all clear, no steps necessary.
				}	
		
		
	}	
	
	
}
