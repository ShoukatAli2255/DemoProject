package stepDefnitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	WebDriver driver;
	
	@Given("user has navigated to login page")
	public void user_has_navigated_to_login_page() {
		driver = DriverFactory.getdriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();

	}

	@When("user entered valid email address {string}")
	public void user_entered_valid_email_address(String EmailAddress) {
		driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']")).sendKeys(EmailAddress);
	}

	@When("user entered valid password {string}")
	public void user_entered_valid_password(String Password) {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Password);

	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

	}

	@Then("user should logged in successfully")
	public void user_should_logged_in_successfully() {
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Qafox.com']")).isDisplayed());

	}

	@When("user entered INvalid email address")
	public void user_entered_iNvalid_email_address() {
		driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']")).sendKeys(getEmailTimeStamp());
	}

	@When("user entered INvalid password {string}")
	public void user_entered_i_nvalid_password(String InvalidPassword) {
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(InvalidPassword);
	}
	

	@Then("user should  get Warning message")
	public void user_should_get_warning_message() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert alert-danger alert-dismissible')]"))
				.getText().contains("Warning: No match for E-Mail Address and/or Password."));

	}
	
	public String getEmailTimeStamp() {
		
		Date dates = new Date();
		return   "shoukatali"+dates.toString() .replace("  " , " _ ") .replace(" : " , " _ ")+"@gmail.com";
	}
	
	

}
