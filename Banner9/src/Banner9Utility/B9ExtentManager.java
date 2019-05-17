package Banner9Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.*;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class B9ExtentManager {

	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	
	//Enter path where the report should write to
	//private static String filePath = "C:\\Users\\dadmati\\Desktop\\Webstar_Touchnet_Nightly_QA_Automation_Report.html";
	private static String filePath = "./Banner9_Nightly_QA_Automation_Report.html";
	
	public static ExtentReports GetExtent() {
		
		
		if (extent != null)
			return extent; // avoid creating new instance of html file
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());
		return extent;
	}

	private static ExtentHtmlReporter getHtmlReporter() {

		htmlReporter = new ExtentHtmlReporter(filePath);
		//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\dadmati\\Desktop\\Webstar_Touchnet_Nightly_QA_Automation_Report.html");
		//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./Webstar_Touchnet_Nightly_QA_Automation_Report.html");

		// Use this to append to the report. The default will be overwrite
		// report.
		// htmlReporter.setAppendExisting(true);

		htmlReporter.loadXMLConfig(new File("C:\\Selenium\\Banner9\\extent-config.xml"));
		// make the charts visible on report open
		htmlReporter.config().setChartVisibilityOnOpen(true);

		//Name the report
		
		//Appears as the title of the report when hovering over the tab
		htmlReporter.config().setDocumentTitle("Banner 9 QA Automation");
		
		//Appears to the right of the extent word in the report
		htmlReporter.config().setReportName("Banner 9");
		// new
		 //test.assignAuthor("QA Automation");
		 //test.assignCategory("Touchnet");
		
		//This configuration will connect extentx to mongodb
		//ExtentXReporter extentxReporter = new ExtentXReporter("localhost", 27017);
		//extentxReporter.config().setServerUrl("http://localhost:1337");
		//This command will title the suite in extentx
		//extentxReporter.config().setProjectName("Banner9");
		//extentxReporter.config().setReportName("Regression");
		
		//extentxReporter.config().setReportObjectId("tagtest1");
		//extentxReporter.config().setReportObjectId("tagtest2");
		
		//extentxReporter.setAuthorContextInfo("");
		//extentxReporter.setCategoryContextInfo("");
		//extentxReporter.setSystemAttributeContext("");
	
		
		// then add extentx
		//extent.attachReporter(htmlReporter, extentxReporter);
		// new

		return htmlReporter;
	}

	public static ExtentTest createTest(String name, String description) {
		test = extent.createTest(name, description);
		return test;
	}

	public static String CaptureScreen(WebDriver driver, String ImagesPath) {
		TakesScreenshot oScn = (TakesScreenshot) driver;
		File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		File oDest = new File(ImagesPath + ".png");
		try {
			FileUtils.copyFile(oScnShot, oDest);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return ImagesPath + ".png";
	}
}

