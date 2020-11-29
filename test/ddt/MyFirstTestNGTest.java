package ddt;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class MyFirstTestNGTest {
	RemoteWebDriver driver;

  @Test
  public void nicheThyselfLogin() {
	  	driver.get("http://selenium-examples.nichethyself.com");
		driver.findElement(By.id("loginname")).sendKeys("stc123");//method chaining.
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		driver.findElement(By.id("loginbutton")).click();
  }
  
 
  @AfterMethod
  public void afterMethod() {
	  //post test activities happens here.
	  driver.quit();
  }
	 @BeforeMethod
	 public void beforeMethod() throws MalformedURLException {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setBrowserName("chrome");
		 	driver = new RemoteWebDriver(new URL("http://192.168.0.181:4445/wd/hub"), caps);//Opens the browser - represents one browser window
	  }
	 
//If you are going to use TestNG, no main method needed. 
}
