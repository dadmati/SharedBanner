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

public class Banner9CommonSave {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9CommonSave(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='save-bt']/a/span")
	@CacheLookup
	WebElement clickSave;


	public void clickSave() throws Exception{

		// Click save
	/*	WebElement sourcecode = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='save-bt']/a/span")));
		Thread.sleep(3000);
		clickSave.click();*/

		WebDriverWait ClickNotification = new WebDriverWait(driver, 30);
		ClickNotification.until(
		ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='save-bt']/a/span")));
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='save-bt']/a/span")));
		Thread.sleep(3000);
		actions.click();
		Thread.sleep(3000);
		actions.build().perform();
		//Thread.sleep(5000);
		
		//Thread.sleep(5000);
		
		/*WebElement confirmsave = (new WebDriverWait(driver, 120)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p")));
		driver.findElement(By.xpath("/html/body/nav[5]/div/div[2]/ul/li[7]/ul/li/div/div[2]/p"));*/
		
		/*WebDriverWait savemessage = new WebDriverWait(driver, 30);
		savemessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='notifications-item-text']")));
		driver.findElement(By.xpath(".//*[@class='notifications-item-text']"));*/
		
		//Thread.sleep(5000);
	}

}
