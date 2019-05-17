package pom.Banner9Common;

import org.openqa.selenium.By;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Banner9Utility.B9ConfigReader;
import Banner9Utility.B9ExtentManager;

import static org.testng.Assert.assertTrue;
//import junit.framework.Assert;
//import common.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BannerTestCaseName {
	//@Test

		ExtentReports extent;
		ExtentTest test;
		
		public BannerTestCaseName(ExtentReports extent, ExtentTest test)
		{
			this.extent=extent;
			this.test=test;
		}
		@FindBy(how=How.XPATH,using=".//*[@class='navbar-brand wrap-brand-name ng-binding']")
		WebElement pageTitle;
		
		@Parameters({"Environment", "Browser", "OS"})
		public void testCaseName(String Environment, String Browser, String OS, String testCaseName) 
		{
			
			B9ConfigReader config = new B9ConfigReader();
			ExtentReports extent;
			ExtentTest test;
			extent = B9ExtentManager.GetExtent();
			String Browsertype = Browser;
			String OStype = OS;
			String timeStamp = new SimpleDateFormat("MMddyyyy_HHmmss").format(Calendar.getInstance().getTime());

			
			if (Environment.equalsIgnoreCase("Dev")) {

				test = extent.createTest("Banner 9 PEAEMPL Employee Role Validation - " + Browsertype + "-" + OStype + " - "
						+ "Dev Environment: " + timeStamp);
			} else if (Environment.equalsIgnoreCase("Test")) {

				test = extent.createTest("Banner 9 PEAEMPL Employee Role Validation - " + Browsertype + "-" + OStype + " - "
						+ "Test Environment: " + timeStamp);

			} else if (Environment.equalsIgnoreCase("Stage")) {

				test = extent.createTest("Banner 9 PEAEMPL Employee Role Validation - " + Browsertype + "-" + OStype + " - "
						+ "Stage Environment: " + timeStamp);

			} else {
			}
		}
		
		public void testStepInfo(String stepNameInfo){
			test.info(stepNameInfo);
		}
		
		public void testStepPass(String stepNamePass){
			test.info(stepNamePass);
		}
		
		public void testStepFail(String stepNameFail){
			test.info(stepNameFail);
		}
		
		
}
