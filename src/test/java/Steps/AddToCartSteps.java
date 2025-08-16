package Steps;

import java.time.Duration;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {
	WebDriver driver;

	@Given("User navigate to the Bookcart application login")
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
		System.out.println("      -----------------userNavigateToTheBookcartApplication login----------------------");
	}

	@Given("user login into the application with {string} and {string}")
	public void userLoginIntoTheApplicationWithAnd(String uname, String password) {
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("ortoni");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Pass1234");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		System.out.println("      -----------------user login into the application---------------------");
	}

	@Given("click on login option")
	public void clickOnLoginOption() {
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
	}

	@Given("user search for a {string}")
	public void userSearchForA(String bookname) {
		/*
		driver.findElement(By.xpath("//input[@placeholder='Search books or authors']")).sendKeys(bookname);
		 */
		driver.findElement(By.cssSelector("input[placeholder='Search books or authors']")).sendKeys(bookname);

		System.out.println("Book has been searched");
	}
	@When("user add the book to the cart")
	public void userAddTheBookToTheCart() throws InterruptedException {

		driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
		Thread.sleep(1000);
		/*
		driver.findElement(By.cssSelector("button:nth-child(2) span:nth-child(3)")).click();
	button[class='mdc-button mdc-button--raised mat-mdc-raised-button mat-primary mat-mdc-button-base'] span[class='mdc-button__label']

		driver.findElement(By.cssSelector("button[class='mdc-button mdc-button--raised mat-mdc-raised-button mat-primary mat-mdc-button-base'] span[class='mdc-button__label']")).click();
driver.findElement(By.cssSelector("button[class='mdc-button mdc-button--raised mat-mdc-raised-button mat-primary mat-mdc-button-base'] span[class='mdc-button__label']")).click();
		 */
	}
	@Then("the cart badge should get updated")
	public void theCartBadgeShouldGetUpdated() throws InterruptedException {
		String text=driver.findElement(By.xpath("//span[@class='mat-mdc-button-touch-target'])[3]")).getText();
		Thread.sleep(1000);

		Assert.assertEquals(Integer.parseInt(text)>0,true);
		driver.close();
	}



}
