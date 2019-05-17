package Banner9Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.relevantcodes.extentreports.DisplayOrder;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.IExtentTestClass;
//import com.relevantcodes.extentreports.LogStatus;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.ini4j.Config;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.thoughtworks.selenium.webdriven.commands.Click;

import Banner9Utility.B9ConfigReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import commonfunctions.GetDateinJava;


public class B9ExtentManagerBackUp {
 
//@SuppressWarnings("deprecation")
//public static ExtentReports Instance()
       {

	/*
	 // Create object of SimpleDateFormat class and decide the format
	 DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
	 
	 //get current date time with Date()
	 Date date = new Date();
	 
	 // Now format the date
	 String date1= dateFormat.format(date);

	 // Print the Date
	 System.out.println("Current date and time is " +date1);
	 */
	
	
 //ExtentReports extent;
  String Path = "./Banner9_Nightly_QA_Automation_Report.html";
  //String Path = "C:\\Users\\dadmati\\Desktop\\test.html";
 System.out.println(Path);
 //extent = new ExtentReports(Path, false);
 

 /*
 extent.config()
              .documentTitle("Nova Automation Report")
              .reportName("Regression");
 */




//extent.loadConfig(new File("./extent-config.xml"));
 //return extent;
    }
public static String CaptureScreen(WebDriver driver, String ImagesPath)
{
    TakesScreenshot oScn = (TakesScreenshot) driver;
    File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
 File oDest = new File(ImagesPath+".png");
 try {
      FileUtils.copyFile(oScnShot, oDest);
 } catch (IOException e) {System.out.println(e.getMessage());}
 return ImagesPath+".png";
        }
}



