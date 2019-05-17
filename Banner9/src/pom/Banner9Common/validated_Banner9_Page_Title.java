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
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
//import junit.framework.Assert;
//import common.Assert;

public class validated_Banner9_Page_Title {
	//@Test

		WebDriver driver;
		
		public validated_Banner9_Page_Title(WebDriver driver)
		{
			this.driver=driver;
		}
		@FindBy(how=How.XPATH,using=".//*[@class='navbar-brand wrap-brand-name ng-binding']")
		WebElement pageTitle;
		
		public void validate_Page_Title_After_Login() 
		{
			String page= pageTitle.getText();
			System.out.println("Current page title: " + page);
			Assert.assertEquals(page, "Nova Southeastern University");
		}
		
		public void switchToIframe(String pageName) 
		{
		// SWITCH TO IFRAME
				WebDriverWait wait_iframe = new WebDriverWait(driver, 20000);
				driver.switchTo().frame(driver.findElement(By.name("bannerHS")));

				// Thread.sleep(20000);

				// VERIFY TITLE IN IFRAME
				WebDriverWait waitpost = new WebDriverWait(driver, 30);
				waitpost.until(ExpectedConditions.titleContains("PEAEMPL"));
		}
}
