package pom.Banner9Common;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;

public class Banner9CommonEnterNSUID {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9CommonEnterNSUID(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='hidden-xs'][contains(text(),'Copy')]")
	@CacheLookup
	WebElement clickGo;

	//*[@id="inp:id"]
	public void enterNSUID(String NSUID) throws Exception{

		//test.info("Search by NSUID");
		WebElement rightafterloginpositive = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:id']")));
		driver.findElement(By.xpath("//*[@id='inp:id']"));
		
		
		WebElement rightafterloginpositive2 = (new WebDriverWait(driver, 30)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:id']")));
		//driver.findElement(By.xpath("//*[@id='inp:id']")).sendKeys("N01855656");
		driver.findElement(By.xpath("//*[@id='inp:id']")).sendKeys(NSUID);
	}

}
