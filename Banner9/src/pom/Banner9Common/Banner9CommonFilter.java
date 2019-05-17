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

public class Banner9CommonFilter {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9CommonFilter(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Filter')]")
	@CacheLookup
	WebElement clickFilter;


	public void clickFilter() throws Exception{

		// Click Filter
		WebElement sourcecode0 = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@class='hidden-xs'][contains(text(),'Filter')]")));
		//clickFilter.click();
		Thread.sleep(2000);
		
		browserShake shake = PageFactory.initElements(driver, browserShake.class);
		shake.browserShake(driver, 1230, 732);
		
		Thread.sleep(500);
		
		driver.manage().window().maximize();
		
		Actions delete = new Actions(driver);
		delete.moveToElement(driver.findElement(By.xpath(".//*[@class='hidden-xs'][contains(text(),'Filter')]")));
		WebElement sourcecode1 = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@class='hidden-xs'][contains(text(),'Filter')]")));
		Thread.sleep(2000);
		WebElement sourcecode2 = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@class='hidden-xs'][contains(text(),'Filter')]")));
		delete.click();
		Thread.sleep(2000);
		WebElement sourcecode3 = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@class='hidden-xs'][contains(text(),'Filter')]")));
		delete.build().perform();
		
		
	}

}
