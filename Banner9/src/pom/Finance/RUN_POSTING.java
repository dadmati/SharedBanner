package pom.Finance;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
//import Utility.MKTConfigReader;
import commonfunctions.QueryDB;
import pom.Banner9Common.Banner9CommonGo;
import pom.Banner9Common.Banner9CommonSave;
import pom.Banner9Common.login;
import pom.Banner9Common.sendKeySlower;

public class RUN_POSTING {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	
	public RUN_POSTING(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='inp:keyblckJob']")
	@CacheLookup
	WebElement process;


	@FindBy(how = How.XPATH, using = "//*[@class'ba ba-close']")
	WebElement close;
	

	public void runPosting(String processsName, String messageValue, String printName) throws Exception {
     
		//test.info("Choose Process");
        WebElement un = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:keyblckJob']")));
		driver.findElement(By.xpath("//*[@id='inp:keyblckJob']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='inp:keyblckJob']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='inp:keyblckJob']")).sendKeys(processsName);
		//test.pass("Choose Process passed");
		
		
	
		 // Click go
        //test.info("Click go");
        Banner9CommonGo clickGo = PageFactory.initElements(driver, Banner9CommonGo.class);
        clickGo.clickGo();
        //test.pass("Click go passed");
        
        
        
      
        Actions actionsPrintCode = new Actions(driver);
        actionsPrintCode.moveToElement(driver.findElement(By.xpath("//*[@id='inp:displayPrntCode']")));
		//Thread.sleep(3000);
		actionsPrintCode.click();
		Thread.sleep(3000);
		actionsPrintCode.build().perform();
		//Thread.sleep(3000);
	    actionsPrintCode.sendKeys(Keys.DELETE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.DELETE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.DELETE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.DELETE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.DELETE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.CLEAR);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
	    actionsPrintCode.sendKeys(Keys.BACK_SPACE);
	    actionsPrintCode.build().perform();
		Thread.sleep(3000);
		actionsPrintCode.sendKeys(printName);
		Thread.sleep(3000);
		actionsPrintCode.build().perform();
		Thread.sleep(3000);
       
        
        //Click within the submission block
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id='inp:submitJprmCode']")));
		Thread.sleep(3000);
		actions.click();
		Thread.sleep(3000);
		actions.build().perform();
		Thread.sleep(3000);
		
		
		//test.info("Click save");
		Banner9CommonSave clickSave = PageFactory.initElements(driver, Banner9CommonSave.class);
		clickSave.clickSave();
		//test.pass("Click save passed");			
		
		
		//test.info("Confirm message appears");
		WebElement confirmMessage1 = (new WebDriverWait(driver, 300))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='notifications-item-text'][contains(text(),'Log file: "+messageValue+"')]")));
		//test.pass("Confirm message appears passed");		
		
		Thread.sleep(3000);
		Actions actionsClose = new Actions(driver);
		actionsClose.moveToElement(driver.findElement(By.xpath("//*[@class='notification-counter']")));
		Thread.sleep(3000);
		actionsClose.click();
		Thread.sleep(3000);
		actionsClose.build().perform();
		
		Thread.sleep(3000);
		
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(driver.findElement(By.xpath("//*[@class='ba ba-close']")));
		Thread.sleep(3000);
		actions2.click();
		Thread.sleep(3000);
		actions2.build().perform();
		
		
	}

}
