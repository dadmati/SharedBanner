package pom.Banner9Common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;



public class WaitForPageToFullyLoad {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;
	//String value1;
	//String value2;
	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public WaitForPageToFullyLoad(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;
	
	public boolean check1(String value1) 
	 {
		
		boolean a = driver.findElements(By.xpath(value1)).size() != 0;
		return a;
		 
	 }
	
	public boolean check2(String value1, String value2) 
	 {
		
		boolean a = driver.findElements(By.xpath(value1)).size() != 0 || driver.findElements(By.xpath(value2)).size() != 0;
		return a;
		 
	 }


	 public void waitForPageLoaded2(String value1, String value2) throws InterruptedException {
			for(int i=0; i<24; i++)
			{
				boolean b = check2(value1, value2);
				if(b)
				{
					System.out.println("Page loaded = "+b);
					System.out.println("true");
					break;
	     	     }
				else
				{
					System.out.println("Page loaded = "+b);
					System.out.println("false" + "Wait 5 seconds");
					Thread.sleep(5000);
				}
			}
	    }
	 
	 public void waitForPageLoaded1(String value1) throws InterruptedException {
			for(int i=0; i<24; i++)
			{
				boolean b = check1(value1);
				if(b)
				{
					System.out.println("Page loaded = "+b);
					System.out.println("true");
					break;
	     	     }
				else
				{
					System.out.println("Page loaded = "+b);
					System.out.println("false" + "Wait 5 seconds");
					Thread.sleep(5000);
				}
			}
	    }

}
