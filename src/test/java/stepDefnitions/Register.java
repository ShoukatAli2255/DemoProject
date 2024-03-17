package stepDefnitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Register {
	
	static WebDriver driver;
	
	@Given("User navigated to register account page")
	public void user_navigated_to_register_account_page() {
		driver = DriverFactory.getdriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	
	}

	@When("User enters the details with below fileds")
	public void user_enters_the_details_with_below_fileds(DataTable dataTable) {
	   Map<String, String> datamap = dataTable.asMap(String.class,String.class);
	   driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("First name"));
	   driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("Last name"));
	   driver.findElement(By.id("input-email")).sendKeys(getEmailTimeStamp());
	   driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("Telephone"));
	   driver.findElement(By.id("input-password")).sendKeys(datamap.get("Password"));
	   driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("Password"));	
	}
	
	@When("user creates the duplicate account")
	public void user_creates_the_duplicate_account(DataTable dataTable) {
		   Map<String, String> datamap = dataTable.asMap(String.class,String.class);
		   driver.findElement(By.id("input-firstname")).sendKeys(datamap.get("First name"));
		   driver.findElement(By.id("input-lastname")).sendKeys(datamap.get("Last name"));
		   driver.findElement(By.id("input-email")).sendKeys(datamap.get("Email"));
		   driver.findElement(By.id("input-telephone")).sendKeys(datamap.get("Telephone"));
		   driver.findElement(By.id("input-password")).sendKeys(datamap.get("Password"));
		   driver.findElement(By.id("input-confirm")).sendKeys(datamap.get("Password"));	
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
	  driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("user account should be get created successsfully")
	public void user_account_should_be_get_created_successsfully() {
	    WebElement actual = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
	    Assert.assertEquals("Your Account Has Been Created!", actual);
	}

	@When("User selects No for newsletter")
	public void user_selects_no_for_newsletter() {
	  driver.findElement(By.xpath("//input[@value='0']")).click();
	}
	
	@Then("user should gets warning message")
	public void user_should_gets_warning_message() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'account-register')]/div[contains(text(),'Warning: E-Mail Address is already registered!')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	    Assert assert1 = new Assert();
		assert1.equals(driver.findElement(By.xpath("//div[contains(@id,'account-register')]/div[contains(text(),'Warning: E-Mail Address is already registered!')]")).isDisplayed());
	}
	
	

	@When("User dont enter the details in th fields")
	public void user_dont_enter_the_details_in_th_fields() {
	   //intentionally blank
	}

	
	@Then("user get proper warning messages for each and every field")
	public void user_get_proper_warning_messages_for_each_and_every_field() {
	  Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
	  WebElement FirtsnameErrorActual = driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div"));
	  WebElement LastnameErrorActual = driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div"));
	  WebElement EmailActual = driver.findElement(By.xpath("//input[@placeholder='E-Mail']/following-sibling::div"));
	  WebElement TelephoneActual=driver.findElement(By.xpath("//input[@placeholder='Telephone']/following-sibling::div"));
	  WebElement PasswordActual = driver.findElement(By.xpath("//input[@placeholder='Password']/following-sibling::div"));
	  
	   Assert.assertEquals("First Name must be between 1 and 32 characters!",FirtsnameErrorActual.getText());
	   Assert.assertEquals("Last Name must be between 1 and 32 characters!",LastnameErrorActual.getText());
	   Assert.assertEquals("E-Mail Address does not appear to be valid!",EmailActual.getText());
	   Assert.assertEquals("Telephone must be between 3 and 32 characters!", TelephoneActual.getText());
	   Assert.assertEquals("Password must be between 4 and 20 characters!",PasswordActual.getText());
	   
	   
	}
	
public String getEmailTimeStamp() {
		
		Date dates = new Date();
		return   "shoukatali"+dates.toString().replace(" ", "_").replace(":" ,  "_")+"@gmail.com";
	}
	
}
