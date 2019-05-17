package pom.Finance;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
//import Utility.MKTConfigReader;
import commonfunctions.QueryDB;
import pom.Banner9Common.Banner9CommonGo;
import pom.Banner9Common.Banner9CommonSave;
import pom.Banner9Common.login;
import pom.Banner9Common.sendKeySlower;

public class FGAJVCQ_Journal_Entry_pom {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	
	public FGAJVCQ_Journal_Entry_pom(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='inp:keyblckJob']")
	@CacheLookup
	WebElement process;


	@FindBy(how = How.XPATH, using = "//*[@class'ba ba-close']")
	WebElement close;
	

	public void journalEntry(String seqNum, String journalTyp, String desc, String BankCode, String budPer, String chart, String index, String fund, String org, String account, String program, String amount, String debtcred) throws Exception {
		
		Thread.sleep(5000);
		
		// Enter in sequent number
		WebElement seqNumber = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='inp:fgbjvcdSeqNum']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdSeqNum']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdSeqNum']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdSeqNum']")).sendKeys(seqNum);

		// Enter in journal type
		WebElement journalType = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdRuclCode']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdRuclCode']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdRuclCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdRuclCode']")).sendKeys(journalTyp);

		// Enter in description
		WebElement description = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdTransDesc']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdTransDesc']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdTransDesc']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdTransDesc']")).sendKeys(desc);
		
		
		// Enter in description
				WebElement budgetPeriod = (new WebDriverWait(driver, 120))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdBudgetPeriod']")));
				driver.findElement(By.xpath("//*[@id='inp:fgbjvcdBudgetPeriod']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='inp:fgbjvcdBudgetPeriod']")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='inp:fgbjvcdBudgetPeriod']")).sendKeys(budPer);
				
				
					
		// Enter in bank code
		WebElement bankCode = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdBankCode']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdBankCode']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdBankCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdBankCode']")).sendKeys(BankCode);
		

		// Enter in chart
		WebElement charts = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdCoasCode']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdCoasCode']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdCoasCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdCoasCode']")).sendKeys(chart);

		// Index

		WebElement Index = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdAcciCode']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdAcciCode']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdAcciCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdAcciCode']")).sendKeys(index);

		// Fund

		WebElement Fund = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdFundCode']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdFundCode']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdFundCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdFundCode']")).sendKeys(fund);

		// Org

		WebElement Organization = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdOrgnCode']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdOrgnCode']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdOrgnCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdOrgnCode']")).sendKeys(org);

		// Account

		WebElement Account = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdAcctCode']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdAcctCode']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdAcctCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdAcctCode']")).sendKeys(account);

		// Program

		WebElement Program = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdProgCode']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdProgCode']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdProgCode']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdProgCode']")).sendKeys(program);

		// Enter in amount
		WebElement Amount = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='inp:fgbjvcdTransAmt']")));
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdTransAmt']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdTransAmt']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdTransAmt']")).sendKeys(amount);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='inp:fgbjvcdTransAmt']")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
		// Enter in debit/credit
		WebElement debitCredit = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='fgbjvcdDrCrInd_ac']")));
		driver.findElement(By.xpath("//*[@id='fgbjvcdDrCrInd_ac']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='fgbjvcdDrCrInd_ac']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='fgbjvcdDrCrInd_ac']")).sendKeys(debtcred);	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='fgbjvcdDrCrInd_ac']")).sendKeys(Keys.TAB);	
		Thread.sleep(1000);
		
		
	}
	
	
	public void clickNext() throws Exception {
		
		
		WebElement next = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='next-record-bt']")));
				Actions actions = new Actions(driver);
				actions.moveToElement(driver.findElement(By.xpath("//*[@id='next-record-bt']")));
				Thread.sleep(2000);
				actions.click();
				Thread.sleep(2000);
				actions.build().perform();
				Thread.sleep(2000);
	}
	
public void clickCopy() throws Exception {

		
				WebElement next = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='ba ba-copy'])[3]")));
				Actions actions = new Actions(driver);
				actions.moveToElement(driver.findElement(By.xpath("(//*[@class='ba ba-copy'])[3]")));
				Thread.sleep(2000);
				actions.click();
				Thread.sleep(2000);
				actions.build().perform();
				Thread.sleep(2000);
	}


public void clickRelated() throws Exception {
	
	
	WebElement next = (new WebDriverWait(driver, 120))
	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='hidden-sm hidden-xs'][contains(text(),'Related')]")));
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("//*[@class='hidden-sm hidden-xs'][contains(text(),'Related')]")));
	Thread.sleep(2000);
	actions.click();
	Thread.sleep(2000);
	actions.build().perform();
	Thread.sleep(2000);
	
	
	WebElement next1 = (new WebDriverWait(driver, 120))
	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@title='Access Transaction Summary Info [FGIJSUM]']")));
	Actions actions2 = new Actions(driver);
	actions2.moveToElement(driver.findElement(By.xpath("//*[@title='Access Transaction Summary Info [FGIJSUM]']")));
	Thread.sleep(2000);
	actions2.click();
	Thread.sleep(2000);
	actions2.build().perform();
	Thread.sleep(2000);
	
	
	
	
}


public void close() throws Exception {

	
	
	WebElement next = (new WebDriverWait(driver, 120))
	.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='workspace-close icon']")));
	Actions actions = new Actions(driver);
	actions.moveToElement(driver.findElement(By.xpath("//*[@class='workspace-close icon']")));
	Thread.sleep(2000);
	actions.click();
	Thread.sleep(2000);
	actions.build().perform();
	Thread.sleep(2000);
	

	
	
	
	
}

public void complete() throws Exception {

	
	
	WebElement next = (new WebDriverWait(driver, 120))
			.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='ui-button-text'][contains(text(),'Complete')]")));
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath("//*[@class='ui-button-text'][contains(text(),'Complete')]")));
			Thread.sleep(2000);
			actions.click();
			Thread.sleep(2000);
			actions.build().perform();
			Thread.sleep(2000);
	
}

}
