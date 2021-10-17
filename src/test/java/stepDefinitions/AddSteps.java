package stepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddSteps {
	
	public AppiumDriver driver;
	
	@When("the user opens up the calculator application")
	public void the_user_opens_up_the_calculator_application() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9.0.0");
		cap.setCapability("deviceName", "604b184d");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AndroidDriver(url,cap);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	    
	}

	@When("clicks on number {int}")
	public void clicks_on_number(Integer int1) {
		
		driver.findElement(By.id("com.miui.calculator:id/btn_"+int1+"_s")).click();
	    
	}

	@When("clicks on the add button")
	public void clicks_on_the_add_button() {
		
		driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
	    
	}

	@When("clicks on equal to sign")
	public void clicks_on_equal_to_sign() {
		
		driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();
	   
	}

	@Then("the application should display the sum of the {int} numbers")
	public void the_application_should_display_the_sum_of_the_numbers(Integer int1) {
		
		String result = driver.findElement(By.id("com.miui.calculator:id/result")).getAttribute("text");
		
		System.out.println("The value of result is"+result);
	    
	}

}
