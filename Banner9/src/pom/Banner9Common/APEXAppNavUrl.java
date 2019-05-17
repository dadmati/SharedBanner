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

public class APEXAppNavUrl {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public APEXAppNavUrl(WebDriver driver) {
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


		if (Environment.equalsIgnoreCase("Dev")) {

			driver.get("https://apextest.nova.edu/bandevl3/f?p=108");

		} else if (Environment.equalsIgnoreCase("Test")) {

			driver.get("https://apextest.nova.edu/bandevl3/f?p=108");

		} else if (Environment.equalsIgnoreCase("Stage")) {

			driver.get("https://apexstage.nova.edu/camp/f?p=108");

		} else if (Environment.equalsIgnoreCase("Prod")) {

			//TBD

		} else {

		}

}
	}
