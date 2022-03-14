package stepDefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginMultipleData {
	WebDriver driver;
	String Url="http://orangehrm.qedgetech.com/";
	@Given("^user navigates to orangeHrm \"([^\"]*)\"$")
	public void user_navigates_to_orangeHrm(String brw) throws Throwable {
	    if(brw.equalsIgnoreCase("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "D:\\Automation_Selenium\\Automation_FrameWorks\\CommonDrivers\\chromedriver.exe");
	    	driver= new ChromeDriver();
	    	driver.manage().deleteAllCookies();
	    	driver.manage().window().maximize();
	    	driver.get(Url);
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    }
	    else if(brw.equalsIgnoreCase("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver", "D:\\Automation_Selenium\\Automation_FrameWorks\\CommonDrivers\\geckodriver.exe");
	    	driver= new FirefoxDriver();
	    	driver.manage().deleteAllCookies();
	    	driver.manage().window().maximize();
	    	driver.get("url");
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	    }
	    else
	    {
	    	Reporter.log("Browser value is not matching",true);
	    }
	}

	@When("^users enter \"([^\"]*)\" in username$")
	public void users_enter_in_username(String username) throws Throwable {
	   driver.findElement(By.name("txtUsername")).sendKeys(username); 
	}

	@When("^users enter \"([^\"]*)\" in password$")
	public void users_enter_in_password(String password) throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys(password); 
		
	}

	@When("^users click login$")
	public void users_click_login() throws Throwable {
	    driver.findElement(By.name("Submit")).click();
	}

	@Then("^user should validate url$")
	public void user_should_validate_url() throws Throwable {
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
		
	@Then("^i close browser$")
	public void i_close_browser() throws Throwable {
	   driver.close();
	}
}