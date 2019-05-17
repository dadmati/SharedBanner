package pom.Banner9Common;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
import commonfunctions.BrowserManagement;

public class signout {
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
	public signout(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='btn btn-inb btn-lg dropdown-toggle']")
	@CacheLookup
	WebElement banner9;

	@FindBy(how = How.XPATH, using = ".//*[@id='content']//div/ul/li/a[contains(text(),'CAMP Instance')]")
	@CacheLookup
	WebElement camp;
	@FindBy(how = How.XPATH, using = ".//*[@id='username']")
	WebElement usrnme;

	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	WebElement paswrd;

	@FindBy(how = How.XPATH, using = " .//*[@id='submitform']")
	WebElement submit_btn;

	public void signOut() throws Exception

	{
		
		Thread.sleep(3000);
		
	  	//Switch back to main iframe
	  	driver.switchTo().defaultContent(); 
	  	
	  	Thread.sleep(3000);
		
		WebElement signOut = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='signout']")));
		driver.findElement(By.xpath("//*[@id='signout']")).click();
		
		
		//Confirm save message
		
		Banner9CommonWaitForLoader loader = PageFactory.initElements(driver, Banner9CommonWaitForLoader.class);
		loader.waitForLoader();
		
		//////
		Thread.sleep(3000);
		
	/*	//<div class="logout-info logoutDirtyCheck ng-binding" id="logoutDirtyCheck">One or more applications have unsaved data.</div>
		if(driver.findElement(By.xpath(".//*[@id='logoutDirtyCheck'][contains(text(),'One or more applications have unsaved data.')]")).isDisplayed())
		{
			//Click signout
			WebElement confirmMessage = (new WebDriverWait(driver, 120)).until(
					ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='continue-logout-buttons btn ng-binding'][contains(text(),'Yes, continue Logout')]")));
			driver.findElement(By.xpath(".//*[@class='continue-logout-buttons btn ng-binding'][contains(text(),'Yes, continue Logout')]")).click();
			// 
					
		}
		else
		{
			WebElement confirmMessage = (new WebDriverWait(driver, 120)).until(
					ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='text-center'][contains(text(),'You have successfully logged out from an NSU application.')]")));
			driver.findElement(By.xpath(".//*[@class='text-center'][contains(text(),'You have successfully logged out from an NSU application.')]")).click();		
		}*/
		//////
		
		 if (driver.findElements(By.xpath(".//*[@id='logoutDirtyCheck'][contains(text(),'One or more applications have unsaved data.')]")).size() != 0) {
             //test.pass("Create Undergraduate Account link present passed");
				WebElement confirmMessage = (new WebDriverWait(driver, 120)).until(
						ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='continue-logout-buttons btn ng-binding'][contains(text(),'Yes, continue Logout')]")));
				driver.findElement(By.xpath(".//*[@class='continue-logout-buttons btn ng-binding'][contains(text(),'Yes, continue Logout')]")).click();
         } else {
        	 WebElement confirmMessage = (new WebDriverWait(driver, 120)).until(
 					ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='text-center'][contains(text(),'You have successfully logged out from an NSU application.')]")));
 			driver.findElement(By.xpath(".//*[@class='text-center'][contains(text(),'You have successfully logged out from an NSU application.')]")).click();		
 	
             //Assert.fail("Create Undergraduate Account not present");
             
          // Confirm my accounts link is present
           

         }

		
		
	}
	
	
	public void signOutNoMessage() throws Exception

	{
		
		Thread.sleep(3000);
		
	  	//Switch back to main iframe
	  	driver.switchTo().defaultContent(); 
	  	
	  	Thread.sleep(3000);
		
		WebElement signOut = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='signout']")));
		driver.findElement(By.xpath("//*[@id='signout']")).click();
		
		
		/*WebElement confirmMessage = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='text-center'][contains(text(),'You have successfully logged out from an NSU application.')]")));
		driver.findElement(By.xpath(".//*[@class='text-center'][contains(text(),'You have successfully logged out from an NSU application.')]")).click();*/
		
	}

}
