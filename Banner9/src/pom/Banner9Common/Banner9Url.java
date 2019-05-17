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

import Banner9Utility.B9ConfigReader;

import static org.testng.Assert.assertTrue;
//import junit.framework.Assert;
//import common.Assert;

public class Banner9Url {
	//@Test

		WebDriver driver;
		
		public Banner9Url(WebDriver driver)
		{
			this.driver=driver;
		}
		@FindBy(how=How.XPATH,using=".//*[@class='navbar-brand wrap-brand-name ng-binding']")
		WebElement pageTitle;
		
		@Parameters({"Environment"})
		public void chooseEnvUrl(String Environment) 
		{
			
			B9ConfigReader config = new B9ConfigReader();

			if (Environment.equalsIgnoreCase("Dev")) {

				driver.get(config.getBanner9Dev());

			} else if (Environment.equalsIgnoreCase("Test")) {

				driver.get(config.getBanner9Test());

			} else if (Environment.equalsIgnoreCase("Stage")) {

				// driver.get(config.getBanner9Stage());
				driver.get("https://bannerdev.nova.edu/applicationNavigator/seamless");

			} else if (Environment.equalsIgnoreCase("Prod")) {

				driver.get(config.getBanner9Prod());

			} else {

			}
		}
		
		
}
