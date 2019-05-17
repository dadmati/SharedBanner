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

public class Banner9CommonClickDeleteSend {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9CommonClickDeleteSend(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;


	public void clickDelSend(String xpath, String value) throws Exception{
		WebElement inter = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

				Actions actions5 = new Actions(driver);
				actions5.moveToElement(driver.findElement(By.xpath(xpath)));
				Thread.sleep(100);
				actions5.click();
				Thread.sleep(100);				
				actions5.build().perform();
				actions5.sendKeys(Keys.END);
			    actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);			 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.END);
				 
				actions5.build().perform();
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
			 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
		 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
			 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
			 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(value);
				Thread.sleep(100);
				actions5.build().perform();
	}
	
	public void saveQuery(String xpath, String xpath2, String value) throws Exception{
		WebElement inter = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

				Actions actions5 = new Actions(driver);
				actions5.moveToElement(driver.findElement(By.xpath(xpath)));
				Thread.sleep(100);
				actions5.click();
				Thread.sleep(100);				
				actions5.build().perform();
				actions5.sendKeys(Keys.END);
			    actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);			 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();
				actions5.sendKeys(Keys.DELETE);				 
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.DELETE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.END);
				 
				actions5.build().perform();
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
			 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
		 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
			 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
			 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
			 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				 
				actions5.sendKeys(Keys.BACK_SPACE);
				 
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(Keys.BACK_SPACE);
				actions5.build().perform();	
				actions5.sendKeys(value);
				Thread.sleep(100);
				actions5.build().perform();
				
				Thread.sleep(3000);
				
				Actions actions6 = new Actions(driver);
				actions6.moveToElement(driver.findElement(By.xpath(xpath2)));
				Thread.sleep(100);
				actions6.click();
				Thread.sleep(100);				
				actions6.build().perform();
				
			
              
	}
	
	public void clickDropDown(String xpath1, String xpath2) throws Exception{
		WebElement inter = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));

				Actions actions5 = new Actions(driver);
				actions5.moveToElement(driver.findElement(By.xpath(xpath1)));
				Thread.sleep(2000);
				actions5.click();
				Thread.sleep(2000);
				actions5.build().perform();		
				
				
		WebElement dropValue = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath2)));
		
				Actions actions6 = new Actions(driver);
				actions6.moveToElement(driver.findElement(By.xpath(xpath2)));
				Thread.sleep(2000);
				actions6.click();
				Thread.sleep(2000);
				actions5.build().perform();
	
	}
	
	public void clickDropDownandType(String xpath1, String xpath2, String xpath3, String value) throws Exception{
		
		//Click dropdown
		WebElement inter = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));

		
		Actions actions5 = new Actions(driver);
		actions5.moveToElement(driver.findElement(By.xpath(xpath1)));
		Thread.sleep(1000);
		actions5.click();
		Thread.sleep(1000);
		actions5.build().perform();

		
		//Click search
		WebElement ClickSearch = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath2)));

		Actions actions6 = new Actions(driver);
		actions6.moveToElement(driver.findElement(By.xpath(xpath2)));
		Thread.sleep(1000);
		actions6.click();
		Thread.sleep(1000);
		actions6.build().perform();

		
		//Type in field
		WebElement typeAndEnter = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath3)));

		Actions actions7 = new Actions(driver);
		actions7.moveToElement(driver.findElement(By.xpath(xpath3)));
		Thread.sleep(500);
		actions7.click();
		Thread.sleep(500);
		actions7.build().perform();
		Thread.sleep(500);
		actions7.sendKeys(value);
		Thread.sleep(500);
		actions7.build().perform();
		Thread.sleep(500);
		actions7.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		actions7.build().perform();
	
	}
	
/*public void clickDropDownandTypeThenClickEnter(String xpath1, String xpath2, String xpath3, String value) throws Exception{
		
		//Click dropdown
		WebElement inter = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath1)));

		
		Actions actions5 = new Actions(driver);
		actions5.moveToElement(driver.findElement(By.xpath(xpath1)));
		Thread.sleep(2000);
		actions5.click();
		Thread.sleep(2000);
		actions5.build().perform();

		
		//Click search
		WebElement ClickSearch = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath2)));

		Actions actions6 = new Actions(driver);
		actions6.moveToElement(driver.findElement(By.xpath(xpath2)));
		Thread.sleep(2000);
		actions6.click();
		Thread.sleep(2000);
		actions6.build().perform();

		
		//Type in field
		WebElement typeAndEnter = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath3)));

		Actions actions7 = new Actions(driver);
		actions7.moveToElement(driver.findElement(By.xpath(xpath3)));
		Thread.sleep(2000);
		actions7.click();
		Thread.sleep(2000);
		actions7.build().perform();
		Thread.sleep(2000);
		actions7.sendKeys(value);
		Thread.sleep(2000);
		actions7.build().perform();
		Thread.sleep(2000);
		actions7.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		actions7.build().perform();
	
	}*/
	
}
