package pom.Banner9SSBCommon;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
import commonfunctions.GetScreenshot;

public class Banner9SSBGeneralMainPage {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	 * Enter information about class: This class will click on the go button for
	 * every Banner 9 page.
	 * 
	 */
	public Banner9SSBGeneralMainPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;

	public void mainPage(String first, String middle, String last, String NSUID, String marital, String email, String dob, String gender, String phone) throws Exception 
	{

Thread.sleep(5000);
		
		//test.info("Wait for loading");
		Banner9SSBWaitForLoading waitForLoading = PageFactory.initElements(driver, Banner9SSBWaitForLoading.class);
		waitForLoading.waitForLoading(12);
		//test.pass("Wait for loading passed");
		
		//   ***Verify the fields
		
		//Verify full name
		//test.info("Validate full name");
		//System.out.println("Full Name before= "+first+" "+middle+" "+last);
		
		if(middle== null){		
			System.out.println("Found a NULL in middle name");
		if(driver.findElements(By.xpath("(.//*[@class='overview-name break-long-words'][contains(text(),'"+first+" "+last+"')])[2]")).size() != 0) {
			 WebElement verifyInfo1 = (new WebDriverWait(driver, 120))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//*[@class='overview-name break-long-words'][contains(text(),'"+first+" "+last+"')])[2]")));
			//test.pass("Validate full name passed");
				
			} else {					
				//fail++;	   			
	   			Reporter.log("Take screenshot of completed", true);
	   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
	   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
	   			//test.fail("Validate full name failed" + test.addScreenCaptureFromPath(screenshotFail));
			}
		}
		else
		{
			System.out.println("Did NOT find a NULL in middle name");
			if(driver.findElements(By.xpath("(.//*[@class='overview-name break-long-words'][contains(text(),'"+first+" "+middle+" "+last+"')])[2]")).size() != 0) {
				 WebElement verifyInfo1 = (new WebDriverWait(driver, 120))
							.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//*[@class='overview-name break-long-words'][contains(text(),'"+first+" "+middle+" "+last+"')])[2]")));
				//test.pass("Validate full name passed");
					
				} else {					
					//fail++;	   			
		   			Reporter.log("Take screenshot of completed", true);
		   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
		   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
		   			//test.fail("Validate full name failed" + test.addScreenCaptureFromPath(screenshotFail));
				}
		}
		
		 //Verify NSUID
		//test.info("Validate NSUID");
		if(driver.findElements(By.xpath("(//div[contains(.,'ID Number:"+NSUID+"')])[10]")).size() != 0) {
			WebElement verifyInfo2 = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(.,'ID Number:"+NSUID+"')])[10]")));
			//test.pass("Validate NSUID passed");
				
			} else {					
				//fail++;	   			
	   			Reporter.log("Take screenshot of completed", true);
	   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
	   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
	   			//test.fail("Validate NSUID failed" + test.addScreenCaptureFromPath(screenshotFail));
			}
		 
		 
		 
		 
		//Verify First
		//test.info("Validate Firstname");
		if(driver.findElements(By.xpath("(//div[contains(.,'"+first+"')])[25]")).size() != 0) {
			WebElement verifyInfo3 = (new WebDriverWait(driver, 120))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(.,'"+first+"')])[25]")));
			//test.pass("Validate Firstname passed");
				
			} else {					
				//fail++;	   			
	   			Reporter.log("Take screenshot of completed", true);
	   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
	   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
	   			//test.fail("Validate Firstname failed" + test.addScreenCaptureFromPath(screenshotFail));
			}
		 
		
		//Verify Last 
		 //test.info("Validate Lastname");
			if(driver.findElements(By.xpath("(//div[contains(.,'"+last+"')])[25]")).size() != 0) 
			{
				WebElement verifyInfo4 = (new WebDriverWait(driver, 120))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(.,'"+last+"')])[25]")));
			 //test.pass("Validate Lastname passed");
					
			} else {					
					//fail++;	   			
		   			Reporter.log("Take screenshot of completed", true);
		   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
		   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
		   			//test.fail("Validate Lastname failed" + test.addScreenCaptureFromPath(screenshotFail));
			}
		 
		//Verify Marital
			
		String a = driver.findElement(By.xpath("(//div[contains(.,'"+marital+"')])[12]")).getText();
		String b = driver.findElement(By.xpath("(//div[contains(.,'"+marital+"')])[12]")).getAttribute("value");
		System.out.println("A = "+a);	
		System.out.println("B = "+b);	
		System.out.println("From excel = "+marital);	
		boolean maritaltest = driver.findElements(By.xpath("(//div[contains(.,'"+marital+"')])[12]")).size() != 0;
		boolean lastnametest = driver.findElements(By.xpath("(//div[contains(.,'"+last+"')])[25]")).size() != 0;
		System.out.println("maritaltest = "+maritaltest);	
		System.out.println("lastnametest = "+lastnametest);
		
		
		
		 //driver.findElements(By.xpath("(//div[contains(.,'"+marital+"')])[12]"));
		 //test.info("Validate Marital status");
		 									
			if(driver.findElements(By.xpath("(//div[contains(.,'"+marital+"')])[12]")).size() != 0) 
			{
				 //WebElement verifyInfo5 = (new WebDriverWait(driver, 120))
				 //			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(.,'"+marital+"')])[12]")));
			 //test.pass("Validate Marital status passed");
					
			} else {					
					//fail++;	   			
		   			Reporter.log("Take screenshot of completed", true);
		   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
		   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
		   			//test.fail("Validate Marital status failed" + test.addScreenCaptureFromPath(screenshotFail));
			}
		 
		//Verify email 
		 //test.info("Validate Email");
			if(driver.findElements(By.xpath("(//div[contains(.,'"+email+"')])[10]")).size() != 0) {
				 WebElement verifyInfo6 = (new WebDriverWait(driver, 120))
							.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(.,'"+email+"')])[10]")));
			 //test.pass("Validate Email passed");
					
				} else {					
					//fail++;	   			
		   			Reporter.log("Take screenshot of completed", true);
		   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
		   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
		   			//test.fail("Validate email failed" + test.addScreenCaptureFromPath(screenshotFail));
				}
			
			
			String c = driver.findElement(By.xpath("(//div[contains(.,'"+dob+"')])[12]")).getText();
			String d = driver.findElement(By.xpath("(//div[contains(.,'"+dob+"')])[12]")).getAttribute("value");
			System.out.println("c = "+c);	
			System.out.println("d = "+d);	
			System.out.println("From excel = "+dob);	
			boolean dobtest = driver.findElements(By.xpath("(//div[contains(.,'"+dob+"')])[12]")).size() != 0;
			System.out.println("dobtest = "+dobtest);			
        
						
			//Verify dob 
			 //test.info("Validate dob");
			 									  
				if(driver.findElements(By.xpath("(//div[contains(.,'"+dob+"')])[12]")).size() != 0) {
					 WebElement verifyInfo6 = (new WebDriverWait(driver, 120))
								.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(.,'"+dob+"')])[12]")));
				 //test.pass("Validate dob passed");
						
					} else {					
						//fail++;	   			
			   			Reporter.log("Take screenshot of completed", true);
			   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
			   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
			   			//test.fail("Validate dob failed" + test.addScreenCaptureFromPath(screenshotFail));
					}
				
				
				//Verify gender 
				 //test.info("Validate gender");
					if(driver.findElements(By.xpath("(//div[contains(.,'"+gender+"')])[13]")).size() != 0) {
						 WebElement verifyInfo6 = (new WebDriverWait(driver, 120))
									.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(.,'"+gender+"')])[13]")));
					 //test.pass("Validate gender passed");
							
						} else {					
							//fail++;	   			
				   			Reporter.log("Take screenshot of completed", true);
				   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
				   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
				   			//test.fail("Validate Marital status failed" + test.addScreenCaptureFromPath(screenshotFail));
						}
					
					//cell
			
			        
			        
			        
			    	//Verify phone 
					 //test.info("Validate phone number");
						if(driver.findElements(By.xpath(".//*[@class='phone-number-view'][contains(text(),'"+phone+"')]")).size() != 0) {
							 WebElement verifyInfo6 = (new WebDriverWait(driver, 120))
										.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(.,'"+gender+"')])[13]")));
						 //test.pass("Validate phone number passed");
								
							} else {					
								//fail++;	   			
					   			Reporter.log("Take screenshot of completed", true);
					   			//System.out.println("Failure, take screenshot: # of failures = " +fail);
					   			String screenshotFail = GetScreenshot.capture(driver, "_" + "completeScreenshot");
					   			//test.fail("Validate phone number failed" + test.addScreenCaptureFromPath(screenshotFail));
							}
		
	}

}
