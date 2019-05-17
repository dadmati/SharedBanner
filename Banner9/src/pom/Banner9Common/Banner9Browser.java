package pom.Banner9Common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Driver;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
import Banner9Utility.B9ExtentManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Banner9Browser {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	public WebDriver driver;
	

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9Browser(WebDriver driver) {
		this.driver = driver;
	}

	//@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	//@CacheLookup
	//WebElement clickGo;

	@BeforeClass
	@Parameters({ "Environment", "Browser", "OS" })
	@Test

	// Make sure to name your test below
	public void ChooseBrowser(String Browser, String OS) throws Exception {
		// extent = B9ExtentManager.Instance();
		
		//B9ConfigReader config = new B9ConfigReader();

		//String Browsertype = Browser;
		System.out.print("Browser passed through is" + Browser);

		if (Browser.equalsIgnoreCase("Chrome")) {

			DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
			Capabilities.setCapability("acceptSslCerts", "true");

			if (OS.equalsIgnoreCase("Win7")) {
				Capabilities.setPlatform(Platform.VISTA);
			} else if (OS.equalsIgnoreCase("Win81")) {
				Capabilities.setPlatform(Platform.WIN8_1);
			} else if (OS.equalsIgnoreCase("Win10")) {
				Capabilities.setPlatform(Platform.WIN10);
			} else {
			}

			driver = new RemoteWebDriver(new URL(config.getHUBURL()), Capabilities);

		} else if (Browser.equalsIgnoreCase("IE")) {

			// Internet Explorer
			DesiredCapabilities Capabilities = DesiredCapabilities.internetExplorer();
			Capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			Capabilities.setCapability("ensureCleanSession", true);
			Capabilities.setCapability("ignoreZoomSetting", true);
			Capabilities.setCapability("ignoreProtectedModeSettings", true);
			Capabilities.setCapability("ignore-certificate-error", true);
			Capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			if (OS.equalsIgnoreCase("Win7")) {
				Capabilities.setPlatform(Platform.VISTA);
			} else if (OS.equalsIgnoreCase("Win81")) {
				Capabilities.setPlatform(Platform.WIN8_1);
			} else if (OS.equalsIgnoreCase("Win10")) {
				Capabilities.setPlatform(Platform.WIN10);
			} else {
			}

			driver = new RemoteWebDriver(new URL(config.getHUBURL()), Capabilities);

		} else if (Browser.equalsIgnoreCase("FF")) {

			// Firefox
			DesiredCapabilities Capabilities = DesiredCapabilities.firefox();
			Capabilities.setCapability("marionette", true);

			if (OS.equalsIgnoreCase("Win7")) {
				Capabilities.setPlatform(Platform.VISTA);
			} else if (OS.equalsIgnoreCase("Win81")) {
				Capabilities.setPlatform(Platform.WIN8_1);
			} else if (OS.equalsIgnoreCase("Win10")) {
				Capabilities.setPlatform(Platform.WIN10);
			} else {
			}
			driver = new RemoteWebDriver(new URL(config.getHUBURL()), Capabilities);

			// System.setProperty("webdriver.gecko.driver",
			// config.getFFDriver());
			// driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("Local")) {
			// Chrome
			System.setProperty("webdriver.chrome.driver", config.getChromeDriver());
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			
			ChromeOptions opts = new ChromeOptions();
			opts.addArguments("start-maximized");
			capabilities.setCapability(ChromeOptions.CAPABILITY, opts);
			driver = new ChromeDriver(capabilities);
			driver.manage().deleteAllCookies();
			
		} else {
		}
		
		//Open browser
		driver.get("http://www.google.com");
		
		
	}
	
	 	

	 
	}	

