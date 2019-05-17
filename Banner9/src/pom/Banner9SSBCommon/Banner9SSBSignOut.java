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

public class Banner9SSBSignOut {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	 * Enter information about class: This class will click on the go button for
	 * every Banner 9 page.
	 * 
	 */
	public Banner9SSBSignOut(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;

	//***EDIT METHODS
	
	public void signOut() throws Exception {

		//Click icon
		//<a id="user" aria-expanded="false" class="menu-icon" href="javascript:void(0);" aria-label="Profile. Short cut is Alt+P"></a>
		WebElement clickSend5 = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user']")));
		//driver.findElement(By.xpath(".//*[@id='user']")).click();
		Thread.sleep(500);
		
		WebElement icon1 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='user']")));

		Actions icon = new Actions(driver);
		icon.moveToElement(driver.findElement(By.xpath(".//*[@id='user']")));
		Thread.sleep(2000);
		icon.click();
		Thread.sleep(2000);
		icon.build().perform();
	
		//Click sign out
		//<div class="canvas-item pointer" role="menuitem" id="signOut" xe-field="signOut" tabindex="0"><span>Sign Out</span></div>
		
		WebElement clickSend6 = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='signOut']")));
		//driver.findElement(By.xpath(".//*[@id='signOut']")).click();
		Thread.sleep(500);
		
		WebElement signout1 = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='signOut']")));

		Actions signout = new Actions(driver);
		signout.moveToElement(driver.findElement(By.xpath(".//*[@id='signOut']")));
		Thread.sleep(2000);
		signout.click();
		Thread.sleep(2000);
		signout.build().perform();
		
			 

	}

}
