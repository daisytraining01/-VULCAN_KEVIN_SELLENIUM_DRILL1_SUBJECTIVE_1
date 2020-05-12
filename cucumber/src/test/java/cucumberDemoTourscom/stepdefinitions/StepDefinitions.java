package cucumberDemoTourscom.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	
	WebDriver driver;
	
	@Given("Application is opened in the browser")
	public void application_is_opened_in_the_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/register.php");
	}

	@When("All the Data fields has been filled")
	public void all_the_Data_fields_has_been_filled() {
		driver.findElement(By.name("firstName")).sendKeys("Mohan");
		driver.findElement(By.name("lastName")).sendKeys("Murugesan");
		driver.findElement(By.name("phone")).sendKeys("9786986811");
		driver.findElement(By.id("userName")).sendKeys("mohan@maveric-systems.com");
		driver.findElement(By.name("address1")).sendKeys("Kiodumui");
		driver.findElement(By.name("city")).sendKeys("Erode");
		driver.findElement(By.name("state")).sendKeys("Tamilnadu");
		driver.findElement(By.name("postalCode")).sendKeys("638151");
		
		Select ctry = new Select(driver.findElement(By.name("country"))) ;
		ctry.selectByVisibleText("INDIA");
		
		driver.findElement(By.id("email")).sendKeys("mohan");
		driver.findElement(By.name("password")).sendKeys("9876541230");
		driver.findElement(By.name("confirmPassword")).sendKeys("9876541230");
		
	}

	@Then("Submit button is pressed to register")
	public void submit_button_is_pressed_to_register() {
		driver.findElement(By.name("submit")).click();
		driver.quit();
	}
	
	
	

}
