package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class YahooTest {
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void yahooLogin() throws InterruptedException {
	  
	  driver.get("https://login.yahoo.com/");
	  Thread.sleep(6000);
	  driver.findElement(By.name("username")).sendKeys("deepakwankhade706");
	  Thread.sleep(4000);
	  driver.findElement(By.id("login-signin")).click();
	  Thread.sleep(4000);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("login-passwd")))).sendKeys("Dhairya@2006");
	  driver.findElement(By.id("login-passwd")).sendKeys("Dhairya@2006");
	  Thread.sleep(4000);
	 // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("login-signin")))).click();
	  driver.findElement(By.id("login-signin")).click();
	  Thread.sleep(2000);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Mail']")))).click();
	  driver.findElement(By.xpath("//a[text()='Mail']")).click();
	  Thread.sleep(4000);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[text()='Compose']")))).click();
	  driver.findElement(By.xpath("//a[text()='Compose']")).click();
	  Thread.sleep(4000);
	  //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("message-to-field")))).sendKeys("ketan@paratussystems.com");
	  driver.findElement(By.id("message-to-field")).sendKeys("deepakwankhade@gmail.com");
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//input[@data-test-id ='compose-subject']")).sendKeys("Yahoo Assignment:Deepak");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//div[@data-test-id='rte']")).sendKeys("Hi Ketan,I've successfully completed my assignments.Thanks,Deepak");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//button[@data-test-id='compose-send-button']")).click();
	  Thread.sleep(4000);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  wait= new WebDriverWait(driver,10,250);
	  driver.manage().window().maximize();
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	  
	  	  	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
