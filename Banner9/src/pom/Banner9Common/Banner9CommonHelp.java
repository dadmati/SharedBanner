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

public class Banner9CommonHelp {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9CommonHelp(WebDriver driver) {
		this.driver = driver;
	}
	
	
	// .//*[@class='fa fa-question ']
	@FindBy(how = How.XPATH, using = ".//*[@class='fa fa-question ']")
	@CacheLookup
	WebElement clickGo;


	public void clickHelp() throws Exception{

	//	<a href="#" data-ng-click="showHelp( $event )" rel="tooltip" title="Help (CTRL+SHIFT+L)" data-placement="bottom" data-toggle="tooltip" data-animation="true" class="help-icon">
    //    <i class="fa fa-question "></i>
    //</a>
		
		// Click go
		WebElement sourcecode = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@class='help-icon']")));
			
		 Actions actions = new Actions(driver);
	     actions.moveToElement(driver.findElement(By.xpath(".//*[@class='help-icon']")));
	     Thread.sleep(3000);
	     actions.click();
	     Thread.sleep(3000);
	     actions.build().perform();
		
		//<span class="hidden-xs">Copy</span>
	}

}
