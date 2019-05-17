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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
import Banner9Utility.B9ExtentManager;

public class Banner9AppNavUrl {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9AppNavUrl(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;


	@Parameters({ "Environment", "Browser", "OS" })
	@Test

	// Make sure to name your test below
	public void ChooseURL(String Environment, String Browser, String OS) throws Exception {

		// Start QA reporting
		//extent = B9ExtentManager.GetExtent();

		String Browsertype = Browser;
		String OStyoe = OS;

		// Configuration reader to pull variables and objects
		B9ConfigReader config = new B9ConfigReader();

		//test.info("Step 1 Open Banner 9 URL");

		if (Environment.equalsIgnoreCase("Dev")) {

			driver.get(config.getAppNavDev());

		} else if (Environment.equalsIgnoreCase("Test")) {

			driver.get(config.getAppNavTest());

		} else if (Environment.equalsIgnoreCase("Stage")) {

			//driver.get(config.getAppNavStage());
			driver.get(config.getAppNavProd());
			//driver.get("https://bannerdev.nova.edu/applicationNavigator/seamless");

		} else if (Environment.equalsIgnoreCase("Prod")) {

			driver.get(config.getAppNavProd());
			
		} else if (Environment.equalsIgnoreCase("Yoda")) {

			driver.get(config.getAppNavYoda());
			//driver.get("https://bannerdev.nova.edu/applicationNavigator/seamless");

		} else if (Environment.equalsIgnoreCase("Month")) {

			driver.get(config.getAppNavMNTH());
			//driver.get("https://bannerdev.nova.edu/applicationNavigator/seamless");

		} else {

		}

}}
