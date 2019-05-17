package pom.Banner9Common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
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
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
import commonfunctions.QueryDBOracle;

public class Banner9CommonWaitForLoader {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will wait for the loader to finish.

	 */
	public Banner9CommonWaitForLoader(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@class='ui-loader']")
	@CacheLookup
	WebElement clickGo;

	//Checks until the number of tries expires
	public void waitForLoader() throws Exception{
		
			
		//Wait 5 seconds, then check.
		Thread.sleep(5000);
		
		int row = Integer.parseInt("1");
		
		boolean check = false;
		for(int i=0; i<36; i++)
		{
	     	 if (driver.findElements(By.xpath("//*[@class='ui-loader']")).size() != 0)
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
	  			  
	  			  //Wait an additional 5 seconds to be safe and then proceed...
	  			  Thread.sleep(5000);  
	  			  
  			 break;
			 }
				  
				  
				  
	  			  
		}
		
		
		
	}
	
}
