package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import factory.DriverFactory;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
public class MyHooks {
	
	 static WebDriver driver;
	 
	@Before
	public void setup() {
		
	  DriverFactory.IntializeBrowser("chrome");
	  driver=DriverFactory.getdriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
	}
	@After
	 public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	}

	 }
	 }
