package pom.Banner9Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pom.Banner9Common.BrowserFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VerifyValidLogin {
	//@Test
	static WebDriver driver;
	public void CheckVliadLoginUser() throws Exception 

	{
		//WebDriver driver = BrowserFactory.StartBrowser("Chrome", "https://bannerdev.nova.edu/applicationNavigator/seamless");
		login loginPage=  PageFactory.initElements(driver, login.class);
		Thread.sleep(2000);

		//PageFactory.initElements(driver, page);

		//loginPage.login_Eis_Banner_Direct_link();
		Thread.sleep(2000);

		validated_Banner9_Page_Title pageTitle=PageFactory.initElements(driver, validated_Banner9_Page_Title.class); 
		pageTitle.validate_Page_Title_After_Login();

		Thread.sleep(10000);

		driver.quit();
	}


	/*public void CheckPageTitle()

	{

	}*/
}
