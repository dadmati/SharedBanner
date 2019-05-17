package pom.Banner9Common;
 


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import IDMSUtility.IDMSConfigReader;

public class sendKeySlower {
	// @Test

		//IDMSConfigReader config = new IDMSConfigReader();
		WebDriver driver;

		/* @FindBy(id="username") 
	  WebElement username;*/

		// Standard way

		/* @FindBy(how=How.ID,using="username")
	  WebElement username1;
		 */
		public sendKeySlower(WebDriver driver)
		{
			this.driver=driver;
		}

		@FindBy(how=How.XPATH,using=".//*[@class='btn btn-inb btn-lg dropdown-toggle']")
		@CacheLookup
		WebElement banner9;
		
		@FindBy(how=How.XPATH,using=".//*[@id='content']//div/ul/li/a[contains(text(),'CAMP Instance')]")
		@CacheLookup
		WebElement camp;
		@FindBy(how=How.XPATH,using=".//*[@id='username']")
		WebElement usrnme;

		@FindBy(how=How.XPATH,using=".//*[@id='password']")
		WebElement paswrd;


		@FindBy(how=How.XPATH,using=" .//*[@id='submitform']")
		WebElement submit_btn;


		public void TypeInField(String xpath, String value) throws InterruptedException{
		     String val = value; 
		     //WebElement element = driver.findElement(By.xpath(xpath));
		     //element.sendKeys(Keys.DELETE);
		     
		     //Wait for field to be clickable before access field
		     WebDriverWait Location = new WebDriverWait(driver, 60);
				Location.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			 
			 //Click on the field	
		     Actions actions = new Actions(driver);
		     actions.moveToElement(driver.findElement(By.xpath(xpath)));
		     actions.click();
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     actions.build().perform();
		     actions.sendKeys(Keys.DELETE);
		     
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     actions.build().perform();
		     actions.sendKeys(Keys.BACK_SPACE);
		     
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		     actions.build().perform();
		     actions.sendKeys(Keys.CLEAR);
		    
		     //System.out.println("Length of value = "+val.length());
		     
		     WebElement element = driver.findElement(By.xpath(xpath));


		    for (int i = 0; i < val.length(); i++){
		        char c = val.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        //actions.sendKeys(s);
			    //System.out.println("character = "+s);
                Thread.sleep(5);
		        element.sendKeys(s);

		    }     
		    }   
		    
		    public void TypeInDateField(String xpath, String value){
			     String val = value; 
			     //WebElement element = driver.findElement(By.xpath(xpath));
			     //element.sendKeys(Keys.DELETE);  
			    
			     Actions actions = new Actions(driver);
			     //actions.moveToElement(driver.findElement(By.xpath(xpath)));
			     actions.click(driver.findElement(By.xpath(xpath)));
			     System.out.println("Length of value = "+val.length());
			     actions.click(driver.findElement(By.xpath(xpath)));
			     
			     
			     WebElement element = driver.findElement(By.xpath(xpath));


			    for (int i = 0; i < val.length(); i++){
			        char c = val.charAt(i);
			        String s = new StringBuilder().append(c).toString();
			        actions.moveToElement(driver.findElement(By.xpath(xpath)));
      			    actions.click(driver.findElement(By.xpath(xpath)));
			        actions.sendKeys(s);
			        actions.build().perform();

				    System.out.println("character = "+s);

			        //element.sendKeys(s);

			    } 
		}
		
		
}
