package pom.Banner9Common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Banner9Utility.B9ConfigReader;
import Banner9Utility.B9ExtentManager;
import Banner9Utility.B9ExtentManagerNoDashboard;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Banner9ExtentReport {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	//public WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	String sRandStr = RandomStringUtils.randomAlphabetic(5);
	String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(Calendar.getInstance().getTime());
	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9ExtentReport(ExtentReports extent, ExtentTest test) {
		this.extent = extent;
		this.test = test;
	}
	
	public ExtentReports getExtent() {
	
		return this.extent = extent;
	}
	
	public ExtentTest getTest() {
		
		return this.test = test;
	}

	//@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	//@CacheLookup
	//WebElement clickGo;

	@BeforeClass
	@Parameters({ "Environment", "Browser", "OS" })
	@Test

	// Make sure to name your test below
	public void ExtentReport(String Environment, String OS, String Browser, String testCaseName) throws Exception {
		
		extent = B9ExtentManager.GetExtent();

		String Browsertype = Browser;
		String OStyoe = OS;

		// Configuration reader to pull variables and objects
		B9ConfigReader config = new B9ConfigReader();

		if (Environment.equalsIgnoreCase("Dev")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Dev Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Test")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Test Environment: " + timeStamp);

		} else if (Environment.equalsIgnoreCase("Stage")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Stage Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Prod")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Prod Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Yoda")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Yoda Environment: " + timeStamp);

		} else if (Environment.equalsIgnoreCase("MNTH")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "MNTH Environment: " + timeStamp);
		 } else {
		}
	}
	
public void ExtentReportNoDashboard(String Environment, String OS, String Browser, String testCaseName) throws Exception {
		
		extent = B9ExtentManagerNoDashboard.GetExtent();

		String Browsertype = Browser;
		String OStyoe = OS;

		// Configuration reader to pull variables and objects
		B9ConfigReader config = new B9ConfigReader();

		if (Environment.equalsIgnoreCase("Dev")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Dev Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Test")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Test Environment: " + timeStamp);

		} else if (Environment.equalsIgnoreCase("Stage")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Stage Environment: " + timeStamp);
		} else if (Environment.equalsIgnoreCase("Prod")) {

			test = extent.createTest(testCaseName + Browsertype + "-" + OStyoe + " - "
					+ "Prod Environment: " + timeStamp);

		} else {
		}
	}
	
	 	

	 
	}	

