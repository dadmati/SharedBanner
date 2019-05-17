package pom.Banner9Common;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;

public class Banner9Related_GJIREVO {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	 * @FindBy(id="username") WebElement username;
	 */

	// Standard way

	/*
	 * @FindBy(how=How.ID,using="username") WebElement username1;
	 */
	public Banner9Related_GJIREVO(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@id='related-toggle']/a/span")
	@CacheLookup
	WebElement related;

	@FindBy(how = How.XPATH, using = ".//*[@id='menu-related']/ul/li/a[contains(text(),'Review Output [GJIREVO]')]")
	@CacheLookup
	WebElement GJIREVO;
	@FindBy(how = How.XPATH, using = ".//*[@id='#keyblckFileName'] ")
	WebElement fileName;

	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	WebElement paswrd;

	@FindBy(how = How.XPATH, using = " .//*[@id='submitform']")
	WebElement submit_btn;

	public void relatedNav(String seqNum) throws Exception

	{
		Thread.sleep(5000);
		
		related.click();
	
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//*[@id='menu-related']/ul/li/a[contains(text(),'Review Output [GJIREVO]')]")).click();
		GJIREVO.click();
		Thread.sleep(5000);
		
		WebDriverWait waitProc = new WebDriverWait(driver, 30);
		waitProc.until(ExpectedConditions.titleContains("GJIREVO"));
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='#keyblckOneUpNo']")).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='#keyblckOneUpNo']")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='#keyblckOneUpNo']")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='#keyblckOneUpNo']")).sendKeys(Keys.BACK_SPACE);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='#keyblckOneUpNo']")).sendKeys(seqNum + Keys.TAB);
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//*[@id='#keyblckFileName']")).clear();
		fileName.clear();
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//*[@id='#keyblckFileName']")).sendKeys("gjrrpts_15256711.lis" + Keys.TAB);
		fileName.sendKeys("pzptime_"+seqNum+".lis");
		Thread.sleep(5000);
		
		fileName.sendKeys(Keys.chord(Keys.ALT, Keys.PAGE_DOWN));
		
		//driver.findElement(By.xpath(".//*[@id='frames7']/span[contains(text(),'Go')]")).click();
		
		Thread.sleep(5000);
		
		WebElement notifications = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='editor-text ui-state-readonly mode-edit']")));
		driver.findElement(By.xpath(".//*[@class='editor-text ui-state-readonly mode-edit']"));
		
		String outputValue = driver.findElement(By.xpath(".//*[@class='editor-text ui-state-readonly mode-edit']")).getAttribute("value");
		//String outputValueTitle = driver.findElement(By.xpath(".//*[@class='editor-text ui-state-readonly mode-edit']")).getAttribute("title");
		//String outputValuetText = driver.findElement(By.xpath(".//*[@class='editor-text ui-state-readonly mode-edit']")).getText();

		System.out.println("Output value is outputValue"+outputValue);
		//System.out.println("Output value is outputValueTitle"+outputValueTitle);
		//System.out.println("Output value is outputValuetText"+outputValuetText);
		
		Thread.sleep(5000);
		
		
		
		Assert.assertEquals("Start Processing ....GOPayroll.csv", outputValue);
		
		//<input title="Start Processing ....GOPayroll.csv" type="text" class="editor-text ui-state-readonly mode-edit" readonly="readonly" row="0" maxlength="2000" style="height: 22px; z-index: 20;" dir="ltr" value="Start Processing ....GOPayroll.csv" aria-labelledby="slickgrid_515094frames58_col0_lbl">

	}
}
