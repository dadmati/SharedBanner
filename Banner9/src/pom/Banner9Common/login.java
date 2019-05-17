package pom.Banner9Common;
 


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;

public class login {
	// @Test

		B9ConfigReader config = new B9ConfigReader();
		WebDriver driver;

		/* @FindBy(id="username") 
	  WebElement username;*/

		// Standard way

		/* @FindBy(how=How.ID,using="username")
	  WebElement username1;
		 */
		public login(WebDriver driver)
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


		public void login_EIS_WebStar() throws Exception 

		{
			banner9.click();
			camp.click();
			Thread.sleep(2000);
			//driver.switchTo().window('')
			
			//switchToAnotherTab
			ArrayList<String>tab = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tab.get(1));
			
			
			//driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(uname);
			usrnme.sendKeys(config.getQAUSERNAME());
			Thread.sleep(2000);
			paswrd.sendKeys(config.getQAPASSWORD());
			//driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(pass);
			Thread.sleep(2000);
			//driver.findElement(By.xpath(".//*[@id='submitform']")).click();
			submit_btn.click();
		}
		
		public void login_Eis_Banner_Direct_link(String UN, String PW) throws Exception
		{
			//banner9.click();
			//camp.click();
			
			//Thread.sleep(1000);
			driver.manage().window().maximize();
			//Thread.sleep(1000);

			
			//Check for logo
			WebElement waitNovaLogo = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='/authenticationendpoint/nsu/nsu-logo.png']")));
			driver.findElement(By.xpath("//img[@src='/authenticationendpoint/nsu/nsu-logo.png']"));
			
			//Check for ishark message
			/*WebElement waitIshark = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(.,'Check out our mobile app, iShark.')]")));
			driver.findElement(By.xpath("//p[contains(.,'Check out our mobile app, iShark.')]"));*/
			
			//Check for forgot username message
			WebElement waitForgotUN = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Forgot Username')]")));
			driver.findElement(By.xpath("//a[contains(.,'Forgot Username')]"));
			
			//Check for forgot password message
/*			WebElement waitForgotPW = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Forgot Password / Change')]")));
			driver.findElement(By.xpath("//a[contains(.,'Forgot Password / Change')]"));*/
			
			//Check for wait message
		/*	WebElement waitMessage = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(.,'When finished in application, remember to logout and close your Web browser.')]")));			
			driver.findElement(By.xpath("//p[contains(.,'When finished in application, remember to logout and close your Web browser.')]"));
		*/				
		/*	WebElement waitMessage = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(.,'Upon logging out of an application, please be sure to close your browser.')]")));			
			driver.findElement(By.xpath("//p[contains(.,'Upon logging out of an application, please be sure to close your browser.')]"));*/
			
			
			//Enter in username
			WebElement waitUnme = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='username']")));
			usrnme.clear();
			Thread.sleep(1000);
			usrnme.sendKeys(UN);
			
			//Enter in password
			WebElement waitpaswrd = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='password']")));
			paswrd.clear();
			Thread.sleep(1000);
			paswrd.sendKeys(PW);
			
			//Click submit button
			WebElement waitsubmi = (new WebDriverWait(driver, 60))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='submitform']")));
			submit_btn.click();
		}
		
}
