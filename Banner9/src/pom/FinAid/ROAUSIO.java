package pom.FinAid;

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
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Banner9Utility.B9ConfigReader;
import pom.Banner9Common.Banner9CommonGo;
import pom.Banner9Common.login;

public class ROAUSIO {
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
	public ROAUSIO(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='inp:keyblckAidyCode']")
	@CacheLookup
	WebElement aidYear;

	@FindBy(how = How.XPATH, using = ".//*[@id='content']//div/ul/li/a[contains(text(),'CAMP Instance')]")
	@CacheLookup
	WebElement camp;
	@FindBy(how = How.XPATH, using = ".//*[@id='username']")
	WebElement usrnme;

	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	WebElement paswrd;

	@FindBy(how = How.XPATH, using = " .//*[@id='submitform']")
	WebElement submit_btn;

	public void enterAid(String aidYearValue) throws Exception{

	//driver.switchTo().window('')
	WebElement sourcecode = (new WebDriverWait(driver, 60))
	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:keyblckAidyCode']")));
		// Click data source code
		aidYear.click();
		Thread.sleep(3000);
		aidYear.clear();
		Thread.sleep(3000);
		aidYear.sendKeys(aidYearValue);

		// Click go
		WebDriverWait waitemptab3 = new WebDriverWait(driver, 30);
		waitemptab3.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='ui-button-text'][contains(text(),'Go')]")));

		Banner9CommonGo go = PageFactory.initElements(driver, Banner9CommonGo.class);
		go.clickGo();
	
	}
	
	public void institutionalDefaults() throws Exception{

		WebElement robinstEntityId = (new WebDriverWait(driver, 180))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:robinstEntityId']")));
		driver.findElement(By.xpath("//*[@id='inp:robinstEntityId']")).click();
		
		
		WebElement robinstPellFundCode = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:robinstPellFundCode']")));
		driver.findElement(By.xpath("//*[@id='inp:robinstPellFundCode']")).click();
		
		
		WebElement robinstFedSchoolCode = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:robinstFedSchoolCode']")));
		driver.findElement(By.xpath("//*[@id='inp:robinstFedSchoolCode']")).click();
		
		
		WebElement robinstDestNumber = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:robinstDestNumber']")));
		driver.findElement(By.xpath("//*[@id='inp:robinstDestNumber']")).click();
		
		
		WebElement robinstServAgentCde = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:robinstServAgentCde']")));
		driver.findElement(By.xpath("//*[@id='inp:robinstServAgentCde']")).click();
		
		
		WebElement robinstInasNonCust = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:robinstInasNonCust']")));
		driver.findElement(By.xpath("//*[@id='inp:robinstInasNonCust']")).click();
		
		Thread.sleep(3000);
		
		//Grant and EDE Options tab
		WebElement GrantandEDE = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tabRoausio1TabCanvas_tab1']")));
		driver.findElement(By.xpath("//*[@id='tabRoausio1TabCanvas_tab1']")).click();
		
		Thread.sleep(3000);
		
		//Loan Options
		WebElement LoanOptions = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tabRoausio1TabCanvas_tab2']")));
		driver.findElement(By.xpath("//*[@id='tabRoausio1TabCanvas_tab2']")).click();
		
		Thread.sleep(3000);
		
		//Direct Loan MPN Rules
		WebElement DirectLoanMPN = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tabRoausio1TabCanvas_tab3']")));
		driver.findElement(By.xpath("//*[@id='tabRoausio1TabCanvas_tab3']")).click();
		
		Thread.sleep(3000);

		//Campus Defaults
		WebElement CampusDefaults = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tabRoausio1TabCanvas_tab4']")));
		driver.findElement(By.xpath("//*[@id='tabRoausio1TabCanvas_tab4']")).click();
		
		Thread.sleep(3000);
	
	}

}
