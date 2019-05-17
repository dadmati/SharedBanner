package pom.Banner9Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.opera.core.systems.OperaDriver;

/**
 * @author Seed
 *
 */
public class BrowserFactory {
	
	public static WebDriver GetBrowser(String browserName) {
		browserName = browserName.toLowerCase();
		
		if(browserName.equals("chrome"))
			return getChromeInstance();
		if(browserName.equals("safari"))
			return getSafariInstance();
		if(browserName.equals("htmlunit"))
			return getHtmlUnitInstance();
		if(browserName.equals("opera"))
			return getOperaInstance();
		if(browserName.equals("phantomjs"))
			return getPhantomJSInstance();
		else
			return getFFInstance();
	}

    public static RemoteWebDriver GetRemoteBrowser(String browserName) {
        DesiredCapabilities capabillities = null;
        RemoteWebDriver driver = null;
        
        switch (browserName) {
        	case "firefox":
        		capabillities = DesiredCapabilities.firefox();
        		break;
        	default:
        }
        
        capabillities.setJavascriptEnabled(true);
        driver = new RemoteWebDriver(capabillities);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    
	private static FirefoxDriver getFFInstance() {
		return new FirefoxDriver();
	}
	
	private static ChromeDriver getChromeInstance() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\webdrivers\\chromedriver.exe");
		return new ChromeDriver();
	}
	
	private static SafariDriver getSafariInstance() {
		return new SafariDriver();
	}
	
	private static HtmlUnitDriver getHtmlUnitInstance() {
		return new HtmlUnitDriver();
	}
	
	private static OperaDriver getOperaInstance() {
		return new OperaDriver();
	}
	
	private static PhantomJSDriver getPhantomJSInstance() {
		System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "resources//phantomjs");
		return new PhantomJSDriver();
	}
}