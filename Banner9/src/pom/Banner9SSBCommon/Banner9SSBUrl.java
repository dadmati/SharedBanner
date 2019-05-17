package pom.Banner9SSBCommon;

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

public class Banner9SSBUrl {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9SSBUrl(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;


	@Parameters({ "Environment", "Browser", "OS" })
	@Test

	// Make sure to name your test below
	public void ChooseURL(String Environment, String Browser, String OS, String SSBMod) throws Exception {

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

			if(SSBMod=="General")
			{
			driver.get(config.getSSBGenTest());
			}
			else if(SSBMod=="Faculty")
			{
			driver.get(config.getSSBFacTest());
			}
			else if(SSBMod=="Student")
			{
			driver.get(config.getSSBStuTest());
			}
			else if(SSBMod=="Employee")
			{
			driver.get(config.getSSBEmpTest());
			}
			else if(SSBMod=="Finance")
			{
			driver.get(config.getSSBFinTest());
			}
			else if(SSBMod=="StudentReg")
			{
			driver.get(config.getSSBStuRegTest());
			}
		} else if (Environment.equalsIgnoreCase("Stage")) {

			if(SSBMod=="General")
			{
			driver.get(config.getSSBGenStage());
			}
			else if(SSBMod=="Faculty")
			{
			driver.get(config.getSSBFacStage());
			}
			else if(SSBMod=="Student")
			{
			driver.get(config.getSSBStuStage());
			}
			else if(SSBMod=="Employee")
			{
			driver.get(config.getSSBEmpStage());
			}
			else if(SSBMod=="Finance")
			{
			driver.get(config.getSSBFinStage());
			}
			else if(SSBMod=="StudentReg")
			{
			driver.get(config.getSSBStuRegStage());
			}

		} else if (Environment.equalsIgnoreCase("Prod")) {

			//Need prod URLs

		} else {

		}

}}
