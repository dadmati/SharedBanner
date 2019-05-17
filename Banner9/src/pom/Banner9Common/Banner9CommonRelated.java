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

public class Banner9CommonRelated {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the related tab.

	 */
	public Banner9CommonRelated(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='hidden-sm hidden-xs'][contains(text(),'Related')]")
	@CacheLookup
	WebElement relatedTab;


	public void clickRelatedTab(String relatedMenu) throws Exception
	{
		
		Thread.sleep(500);
		
		browserShake shake = PageFactory.initElements(driver, browserShake.class);
		shake.browserShake(driver, 1230, 732);
		
		Thread.sleep(500);
		
		driver.manage().window().maximize();
		
		Thread.sleep(500);
		
	    //test.info("Click related");
		WebElement menu = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='hidden-sm hidden-xs'][contains(text(),'Related')]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(".//*[@class='hidden-sm hidden-xs'][contains(text(),'Related')]")));
        Thread.sleep(2000);
        actions.click();
        Thread.sleep(2000);
        actions.build().perform();
        //test.pass("Click related passed");
        
        //<a role="menuitem" data-action="DUPLICATE_ITEM" href="javascript:;" title="Transaction Detail Information [FGITRND]" dir="ltr" class="menu-label" data-uuid="FGITRND#L">Transaction Detail Information [FGITRND]<span class="label label-shortcut">F3</span></a>
        //test.info("Click Transaction Detail Information [FGITRND]");
        WebElement menu2 = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@title='"+relatedMenu+"']")));    
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(driver.findElement(By.xpath(".//*[@title='"+relatedMenu+"']")));
        								
        Thread.sleep(2000);
        actions2.click();
        Thread.sleep(2000);
        actions2.build().perform();
        //test.pass("Click Transaction Detail Information [FGITRND] passed");
		
	}
}
