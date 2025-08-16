package Steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {
	WebDriver driver;

	@Given("User navigate to the Bookcart application")
	public void userNavigateToTheBookcartApplication() {
		//launch Browser
		driver =new ChromeDriver();
		//open url
		driver.get("https://bookcart.azurewebsites.net/");
		Options manage=	driver.manage();
		manage.timeouts().implicitlyWait(Duration.ofSeconds(15));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		manage.window().maximize();
		//print titile
		System.out.println(driver.getTitle());
		//print Method name
		System.out.println("      -----------------userNavigateToTheBookcartApplication----------------------");
	}
	
	
	
@Given("User clicks on the login button")
	public void userClicksOnTheLoginButton() throws InterruptedException {
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		Thread.sleep(2000);
//	WebElement loginBtn=driver.findElement(By.xpath("//button[@mattooltip='Login']")).click();
//		driver.findElement(By.xpath("button[class='mat-mdc-tooltip-trigger mdc-button mdc-button--unelevated mat-mdc-unelevated-button mat-primary mat-mdc-button-base ng-star-inserted'] span[class='mdc-button__label']")).click();
	}
//
//	@Given("user enter the username as ortoni")
//	public void userEnterTheUsernameAsOrtoni() {
//		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("ortoni");
//
//	}
//	@Given("user enter the password as Pass1234")
//	public void userEnterThePasswordAsPass1234() {   
//
//		driver.findElement(By.xpath("//input[@placeholder='Password']"))
//		.sendKeys("Pass1234");
//
//	}
	@When("user click on the login button")
	public void userClickOnTheLoginButton() {
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}
//
	@Then("Login should be success")
	public void loginShouldBeSuccess() {
		WebElement text =driver.findElement(By.xpath("//a[@class='mat-mdc-menu-trigger mdc-button mdc-button--unelevated mat-mdc-unelevated-button mat-primary mat-mdc-button-base ng-star-inserted']//span[@class='mat-mdc-button-touch-target']"));
		System.out.println(text);
		driver.quit();
	}
//	/*
//	 * Second scenario Starts From Here
//	 */
//	@Given("user enter the username as taslim")
//	public void userEnterTheUsernameAsTaslim() {
//		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("taslim");
//
//	}
//	@Given("user enter the password as wrongpassword")
//	public void userEnterThePasswordAsWrongpassword() {
//		driver.findElement(By.xpath("//input[@placeholder='Password']"))
//		.sendKeys("wrongpassword");
//
//	}
	@When("Login should fail")
	public void loginShouldFail() {
		String text =driver.findElement(By.xpath("//mat-error[@id='mat-mdc-error-0']")).getText();
		System.out.println(text);
		Assert.assertEquals(text.trim(), "Username or Password is incorrect.");
		driver.quit();

	}
	@Given("user enter the username as {string}")
	public void userEnterTheUsernameAs(String username) {
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);

	}
	@Given("user enter the password as {string}")
	public void userEnterThePasswordAs(String password) {
		driver.findElement(By.xpath("//input[@placeholder='Password']"))
		.sendKeys(password);
	}
}
