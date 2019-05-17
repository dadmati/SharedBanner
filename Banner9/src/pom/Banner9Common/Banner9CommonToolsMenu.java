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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;

public class Banner9CommonToolsMenu {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9CommonToolsMenu(WebDriver driver) {
		this.driver = driver;
	}
	
	//<i class="ba ba-tools"></i>
	// .//*[@class='fa fa-question ']
	@FindBy(how = How.XPATH, using = ".//*[@class='ba ba-tools']")
	@CacheLookup
	WebElement clickGo;


	public void clickCopy() throws Exception{

		// Click go
		WebElement sourcecode = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@class='ba ba-tools']")));
			
		 Actions actions = new Actions(driver);
	     actions.moveToElement(driver.findElement(By.xpath(".//*[@class='ba ba-tools']")));
	     Thread.sleep(3000);
	     actions.click();
	     Thread.sleep(3000);
	     actions.build().perform();
		
		//<span class="hidden-xs">Copy</span>
	}

}
