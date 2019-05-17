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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;

public class Banner9SSBCommonUpdateCancel {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9SSBCommonUpdateCancel(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='save-bt']/a/span")
	@CacheLookup
	WebElement clickSave;


	public void clickCancel() throws Exception{

	
			WebElement cancel = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.elementToBeClickable(By.xpath("(.//*[@ng-click='cancelModal()'])[2]")));

			Actions actions2 = new Actions(driver);
			actions2.moveToElement(driver.findElement(By.xpath("(.//*[@ng-click='cancelModal()'])[2]")));
			Thread.sleep(2000);
			actions2.click();
			Thread.sleep(2000);
			actions2.build().perform();
			
		
	
	}
	
	public void clickUpdate() throws Exception{

		
		//<button ng-click="savePhone()"
				
			WebElement update = (new WebDriverWait(driver, 60)).until(
					ExpectedConditions.elementToBeClickable(By.xpath(".//*[@ng-click='savePersonalDetails()']")));

			Actions actions3 = new Actions(driver);
			actions3.moveToElement(driver.findElement(By.xpath(".//*[@ng-click='savePersonalDetails()']")));
			Thread.sleep(2000);
			actions3.click();
			Thread.sleep(2000);
			actions3.build().perform();
	
	
	}
	
	public void clickAddInfoAskMeLater() throws Exception{

		
		WebElement cancel = (new WebDriverWait(driver, 60))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ask-me-later-btn']")));

		Actions actions2 = new Actions(driver);
		actions2.moveToElement(driver.findElement(By.xpath(".//*[@id='ask-me-later-btn']")));
		Thread.sleep(2000);
		actions2.click();
		Thread.sleep(2000);
		actions2.build().perform();
		
		//Ask me later
				//<input type="button" id="ask-me-later-btn" value="Ask Me Later" class="secondary-button" data-endpoint="/BannerGeneralSsb/ssb/survey/done">
				
				
				
		
	

}

public void clickUpdateAddInfoContinue() throws Exception{

	
	//<input type="button" id="save-btn" value="Continue" class="primary-button">
			
		WebElement update = (new WebDriverWait(driver, 60)).until(
				ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='save-btn']")));

		Actions actions3 = new Actions(driver);
		actions3.moveToElement(driver.findElement(By.xpath(".//*[@id='save-btn']")));
		Thread.sleep(2000);
		actions3.click();
		Thread.sleep(2000);
		actions3.build().perform();
		
		//Continue
		//<input type="button" id="save-btn" value="Continue" class="primary-button">


}
	
public void clickUpdatePhone() throws Exception{

		
		//<button ng-click="savePhone()"
				
			WebElement update = (new WebDriverWait(driver, 60)).until(
					ExpectedConditions.elementToBeClickable(By.xpath(".//*[@ng-click='savePhone()']")));

			Actions actions3 = new Actions(driver);
			actions3.moveToElement(driver.findElement(By.xpath(".//*[@ng-click='savePhone()']")));
			Thread.sleep(2000);
			actions3.click();
			Thread.sleep(2000);
			actions3.build().perform();
	
	
	}


public void clickAddinEmail() throws Exception{

	
	WebElement cancel = (new WebDriverWait(driver, 60))
			.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@ng-click='saveEmail()']")));

	Actions actions2 = new Actions(driver);
	actions2.moveToElement(driver.findElement(By.xpath(".//*[@ng-click='saveEmail()']")));
	Thread.sleep(2000);
	actions2.click();
	Thread.sleep(2000);
	actions2.build().perform();


}

public void clickX() throws Exception{

	
	WebElement cancel = (new WebDriverWait(driver, 60))
			.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='close closebtn']")));

	Actions actions2 = new Actions(driver);
	actions2.moveToElement(driver.findElement(By.xpath(".//*[@class='close closebtn']")));
	Thread.sleep(2000);
	actions2.click();
	Thread.sleep(2000);
	actions2.build().perform();
	
	


}

}
