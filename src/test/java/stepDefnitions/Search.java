package stepDefnitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;

public class Search {
static	WebDriver driver;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		 driver = DriverFactory.getdriver();
	
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String string) {
	   driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Hp");
	   
	}

	@When("clicks on search button")
	public void clicks_on_search_button() {
	 driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	}

	@Then("User should get valid product on the displayed in the search details")
	public void user_should_get_valid_product_on_the_displayed_in_the_search_details() {
	 Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'HP LP3065')]")).isDisplayed());
	}

	/*
	 * @Given("user opens the application") public void user_opens_the_application()
	 * { // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 */
	@When("user enter invalid product {string} into search box")
	public void user_enter_invalid_product_into_search_box(String string) {
		   driver.findElement(By.xpath("//input[@name='search']")).sendKeys("HONDA");
	}

	@Then("user should get a proper message  about no products found")
	public void user_should_get_a_proper_message_about_no_products_found() {
	Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[contains(@id,'button-search')]/following-sibling::p")).getText());
	
	}

	@When("user dont enter any product name into searcbox field")
	public void user_dont_enter_any_product_name_into_searcbox_field() {
		
		//intentionally 
	   
	}
}
	
