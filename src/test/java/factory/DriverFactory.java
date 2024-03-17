package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	static WebDriver driver = null;
	
	public static void IntializeBrowser(String browser) {
		
		if(browser.equals("chrome")) {
//			   ChromeOptions chromeoption = new ChromeOptions();
//			  chromeoption.addArguments("--incognito");
//			  chromeoption.addArguments("--remote-allow-origins=*"); 
//			  DesiredCapabilities capabilities = new DesiredCapabilities();
//			  capabilities.setCapability(ChromeOptions.CAPABILITY, chromeoption);
//			  chromeoption.merge(capabilities); 
//			  WebDriverManager.chromedriver().setup();
//			  driver = new ChromeDriver();
			
			   ChromeOptions chromeOptions = new ChromeOptions();
	           chromeOptions.addArguments("--incognito");
	           chromeOptions.addArguments("--remote-allow-origins=*");
	           WebDriverManager.chromedriver().setup();
	           driver = new ChromeDriver(chromeOptions);
			
			
		}
		else if(browser.equals("firefox")) {
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver( );
			
		}
		
	}
	
	public  static WebDriver getdriver() {
		return driver;
	}
		
	}


