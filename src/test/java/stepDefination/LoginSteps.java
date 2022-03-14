package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	WebDriver driver;
	@Given("^user launches orange url$")
	public void user_launches_orange_url() throws Throwable {
	   System.setProperty("webdriver.chrome.driver", "D:\\Automation_Selenium\\Automation_FrameWorks\\CommonDrivers\\chromedriver.exe");
	   driver= new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.navigate().to("http://orangehrm.qedgetech.com/");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user enter username And user enter password$")
	public void user_enter_username_And_user_enter_password() throws Throwable {
	 driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	 driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#"); 
	}

	@When("^user clicks login button$")
	public void user_clicks_login_button() throws Throwable {
		driver.findElement(By.name("Submit")).click();; 
	}

	@Then("^user validate url$")
	public void user_validate_url() throws Throwable {
	   String expected="dashboard";
	   String actual=driver.getCurrentUrl();
	   if(actual.contains(expected))
	   {
		   System.out.println("Login success");
	   }
	   else
	   {
		   System.out.println("Login fail");
	   }
	}
	@Then("^user close browser$")
	public void user_close_browser() throws Throwable {
	    driver.close();
	}

}
