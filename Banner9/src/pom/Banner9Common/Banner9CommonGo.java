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

public class Banner9CommonGo {
	// @Test

	B9ConfigReader config = new B9ConfigReader();
	WebDriver driver;

	/*
	Enter information about class:
	This class will click on the go button for every Banner 9 page.

	 */
	public Banner9CommonGo(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ".//*[@class='ui-button-text'][contains(text(),'Go')]")
	@CacheLookup
	WebElement clickGo;


	public void clickGo() throws Exception{
		//<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button>
		// Click go
		/*WebElement sourcecode = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@class='ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit']")));
		clickGo.click();*/
		
		//<div data-widget="panel" class="ui-layout-horizontal keyblock-button-container ui-panel ui-widget" id="frames36">
        //<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button><button type="button" data-widget="button" data-member="KEY-CLRFRM_BTN" data-block="KEY_BLOCK" data-action="CLEAR-FORM" data-tooltip="Start Over" class="ui-widget ui-button" style="display: none; " dir="ltr">Start Over</button>
        //</div>
      
      //<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button>
	
      //<span class="ui-button-text">Go</span>
	 WebElement sourcecode0 = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@class='ui-button-text'][contains(text(),'Go')]")));
		 
     Actions actions = new Actions(driver);
     actions.moveToElement(driver.findElement(By.xpath(".//*[@class='ui-button-text'][contains(text(),'Go')]")));
     Thread.sleep(2000);
     actions.click();
     Thread.sleep(2000);
     actions.build().perform();
	}
	
	
	public void clickGoSub() throws Exception{
		//<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button>
		// Click go
		/*WebElement sourcecode = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@class='ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit']")));
		clickGo.click();*/
		
		//<div data-widget="panel" class="ui-layout-horizontal keyblock-button-container ui-panel ui-widget" id="frames36">
        //<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button><button type="button" data-widget="button" data-member="KEY-CLRFRM_BTN" data-block="KEY_BLOCK" data-action="CLEAR-FORM" data-tooltip="Start Over" class="ui-widget ui-button" style="display: none; " dir="ltr">Start Over</button>
        //</div>
      
      //<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button>
	
      //<span class="ui-button-text">Go</span>
		
		
		/*<div data-widget="panel" class="ui-layout-horizontal keyblock-button-container ui-panel ui-widget" id="frames65">
        <button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames66" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button><button type="button" data-widget="button" data-member="KEY-CLRFRM_BTN" data-block="KEY_BLOCK" data-action="CLEAR-FORM" data-tooltip="Start Over" class="ui-widget ui-button" style="display: none; " dir="ltr">Start Over</button>
      </div>*/
		
        //.//*[@class='ui-layout-horizontal keyblock-button-container ui-panel ui-widget']//*[@data-widget='button']//*[@class='ui-button-text'][contains(text(),'Go')]
		//.//*[@data-widget='button']
		//.//*[@class='ui-button-text'][contains(text(),'Go')]
	WebElement sourcecode0 = (new WebDriverWait(driver, 60)).until(ExpectedConditions
					.elementToBeClickable(By.xpath("(.//*[@class='ui-layout-horizontal keyblock-button-container ui-panel ui-widget']//*[@data-widget='button']//*[@class='ui-button-text'][contains(text(),'Go')])[3]")));	
     Actions actions = new Actions(driver);
     actions.moveToElement(driver.findElement(By.xpath("(.//*[@class='ui-layout-horizontal keyblock-button-container ui-panel ui-widget']//*[@data-widget='button']//*[@class='ui-button-text'][contains(text(),'Go')])[3]")));
     Thread.sleep(2000);
     actions.click();
     Thread.sleep(2000);
     actions.build().perform();
	}
	
	
	
	
	public void clickGoInFilter() throws Exception{
		//<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button>
		// Click go
		/*WebElement sourcecode = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(".//*[@class='ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit']")));
		clickGo.click();*/
		
		//<div data-widget="panel" class="ui-layout-horizontal keyblock-button-container ui-panel ui-widget" id="frames36">
        //<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button><button type="button" data-widget="button" data-member="KEY-CLRFRM_BTN" data-block="KEY_BLOCK" data-action="CLEAR-FORM" data-tooltip="Start Over" class="ui-widget ui-button" style="display: none; " dir="ltr">Start Over</button>
        //</div>
      
      //<button type="button" data-widget="button" data-member="EXECUTE_BTN" data-block="KEY_BLOCK" data-action="NEXT_BLOCK" data-tooltip="Go" class="ui-widget ui-button ui-state-default ui-corner-all ui-button-text-only mode-edit" id="frames37" role="button" aria-disabled="false" title="Go (Alt+PageDown)"><span class="ui-button-text">Go</span></button>
	
      //<span class="ui-button-text">Go</span>
		WebElement sourcecode0 = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath(".//*[@class='primary-button ui-buttonGo'][contains(text(),'Go')]")));	
  
     Actions actions = new Actions(driver);
     actions.moveToElement(driver.findElement(By.xpath(".//*[@class='primary-button ui-buttonGo'][contains(text(),'Go')]")));
     Thread.sleep(3000);
     actions.click();
     Thread.sleep(3000);
     actions.build().perform();
	}
	
	
	public void clickGoInFilter2() throws Exception{
			WebElement sourcecode0 = (new WebDriverWait(driver, 60)).until(ExpectedConditions
				.elementToBeClickable(By.xpath("(.//*[@class='primary-button ui-buttonGo'][contains(text(),'Go')])[2]")));	
  
     Actions actions = new Actions(driver);
     actions.moveToElement(driver.findElement(By.xpath("(.//*[@class='primary-button ui-buttonGo'][contains(text(),'Go')])[2]")));
     Thread.sleep(3000);
     actions.click();
     Thread.sleep(3000);
     actions.build().perform();
	}
	
	
	
	
	
	//<button class="primary-button ui-buttonGo">Go</button>

}
