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

public class Banner9SSBWaitForLoading {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9SSBWaitForLoading(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;


	@Parameters({ "Environment", "Browser", "OS" })
	@Test

	public void waitForLoading(int waitTime) throws Exception
	{
		
		Thread.sleep(5000);
		
		boolean check = false;
		for(int i=0; i<waitTime; i++)
		{
	     	 if (driver.findElements(By.xpath(".//*[@class='body-overlay loading']")).size() != 0)
			 {
				System.out.println("Loader NOT complete. Wait 5 seconds and try again"); 
	     		check = false;
	     		
	     	
    			//Wait 5 seconds and try again
				Thread.sleep(5000);
	     		 
			 }
			 else
			 {
				  System.out.println("Loader complete. Test case can proceed");
	  			  check = true;
	  			  
	  			  //Wait an additional 1 second to be safe and then proceed...
	  			  Thread.sleep(1000);  
	  			  
  			 break;
			 }
		}
	}

}
