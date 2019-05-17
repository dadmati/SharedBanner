package pom.Banner9Common;

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

public class NavigateToPage {
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
	public NavigateToPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='btn btn-inb btn-lg dropdown-toggle']")
	@CacheLookup
	WebElement banner9;

	@FindBy(how = How.XPATH, using = ".//*[@id='content']//div/ul/li/a[contains(text(),'CAMP Instance')]")
	@CacheLookup
	WebElement camp;
	@FindBy(how = How.XPATH, using = ".//*[@id='username']")
	WebElement usrnme;

	@FindBy(how = How.XPATH, using = ".//*[@id='password']")
	WebElement paswrd;

	@FindBy(how = How.XPATH, using = " .//*[@id='submitform']")
	WebElement submit_btn;

	public void navigateToPage(String page) throws Exception

	{
		
		String handle_finCls = driver.getWindowHandle();
		for(String handle : driver.getWindowHandles()) {
			if (!handle.equals(handle_finCls)) {
				driver.switchTo().window(handle);
				Thread.sleep(1500);
				driver.get("https://banner.nova.edu/applicationNavigator/seamless");
				Thread.sleep(2500);
				String an_pTitle = driver.getTitle();
				System.out.println( "Current Page Title: " + an_pTitle);
			
			}
		} 

		
		Thread.sleep(3000);

		//test.info("Step 11: Validating page title");
		WebElement ptitle = (new WebDriverWait(driver, 30))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,'Nova Southeastern UniversityReturn Home')]")));
		//driver.findElement(By.xpath("//a[contains(@title,'Nova Southeastern University')]"));
		driver.findElement(By.xpath("//a[contains(.,'Nova Southeastern UniversityReturn Home')]"));
		System.out.println(ptitle.getText());
		//test.info("Step 11: Validating page title passed successfully");

		//test.info( "Step 12: Opening form by magnafying search ");
		WebElement search = driver.findElement(By.xpath("//button[contains(@value,'CTRL+SHIFT+Y - Search')]"));
		WebDriverWait CLICK = new WebDriverWait(driver, 120);
		CLICK.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@value,'CTRL+SHIFT+Y - Search')]")));
		driver.findElement(By.xpath("//button[contains(@value,'CTRL+SHIFT+Y - Search')]"));
	

		WebElement recentlyOpened = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@title,'Recently Opened (CTRL+Y)')]")));
		driver.findElement(By.xpath("//button[contains(@title,'Recently Opened (CTRL+Y)')]"));
		
	
		

		/*WebElement wHelp = (new WebDriverWait(driver, 120))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("html/body/div[5]/div[2]/ul[3]/li[3]/a/i")));*/
		
		//Updated the help menu to be more specific
		//WebElement wHelp = (new WebDriverWait(driver, 120))
		//.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@class='fa fa-question ']")));
		
		
		
		
		WebElement keyboardShortcut = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-toggle='modal']")));
		driver.findElement(By.xpath("//button[@data-toggle='modal']"));
		
		WebElement backgroun = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='main']")));
		driver.findElement(By.xpath("//div[@role='main']"));
		
		WebElement faQuestionTop = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//i[contains(@class,'fa fa-question ')]")));
		driver.findElement(By.xpath("//i[contains(@class,'fa fa-question ')]"));
		
		//"//*[contains(@id, 'page_pebempl_pebemplCurrentHireDate')]
		//<div class="welcome ng-binding">Welcome To Banner Application Navigator (NON-PROD)</div>
		
		WebElement user = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='fa fa-user fa-stack-1x fa-inverse']")));
		driver.findElement(By.xpath(".//*[@class='fa fa-user fa-stack-1x fa-inverse']"));
        
    
		//Confirm data theme is appearing
				
				WebElement theme = (new WebDriverWait(driver, 120)).until(
						ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@data-theme='institution']")));
				driver.findElement(By.xpath(".//*[@data-theme='institution']"));
    
		
		
		//WebElement welcomeMessgae = (new WebDriverWait(driver, 120)).until(
		//		ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@class='welcome ng-binding'][contains(text(),'Welcome To Banner Application Navigator')]")));
		//driver.findElement(By.xpath(".//*[@class='welcome ng-binding'][contains(text(),'Welcome To Banner Application Navigator')]"));
		
		
		WebElement welcome = (new WebDriverWait(driver, 120)).until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'welcome ng-binding')]")));
		driver.findElement(By.xpath("//div[contains(@class,'welcome ng-binding')]"));

		WebElement signOutTop = (new WebDriverWait(driver, 120)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[@id='signout']")));
			driver.findElement(By.xpath("//a[@id='signout']"));
		
		WebElement title = (new WebDriverWait(driver, 120)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[contains(.,'Nova Southeastern UniversityReturn Home')]")));
		driver.findElement(By.xpath("//a[contains(.,'Nova Southeastern UniversityReturn Home')]"));

		// First we have to click on menu item then only dropdown items will display
		Thread.sleep(1000);
		WebElement waitSearch = (new WebDriverWait(driver, 120)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//input[contains(@placeholder,'Search...')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search...')]")).click();
		Thread.sleep(500);	
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search...')]")).clear();
		Thread.sleep(1000);		
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search...')]")).sendKeys(page);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search...')]")).sendKeys(Keys.ENTER);
		
		
		//Find out what the screensize is for the automation run. This can help greatly with troubleshooting.
		System.out.println("Browser screensize = "+driver.manage().window().getSize());

	}

}
