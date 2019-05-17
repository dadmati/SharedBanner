package pom.Banner9Common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
import Banner9Utility.B9ExtentManager;

public class Banner9SwitchbackFromiFrame {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9SwitchbackFromiFrame(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;


	@Parameters({ "Environment", "Browser", "OS" })
	@Test

	// Make sure to name your test below
	public void switchIframe() throws Exception 
	{
		WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
		driver.switchTo().defaultContent();
		System.out.println("Switch out of iFrame to communicate with Banner 9 pages");
		//Thread.sleep(3000);
		//Banner9CommonWaitForLoader waitForLoader = PageFactory.initElements(driver, Banner9CommonWaitForLoader.class);
		//waitForLoader.waitForLoader();
		
	}
}
