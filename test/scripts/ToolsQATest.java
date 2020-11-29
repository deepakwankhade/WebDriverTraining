package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class ToolsQATest {
	 WebDriver driver;
	 WebDriverWait wait;
  @Test
  public void toolQAPractice() throws InterruptedException {
	  
	  driver.get("https://demoqa.com/automation-practice-form");
	  WebElement name = driver.findElement(By.id("firstName"));
	  name.sendKeys("testdeepak");
	  
	  //System.out.println(name.getText());
	  System.out.println(name.getAttribute("id"));
	 
	  WebElement lastname = driver.findElement(By.id("lastName"));
	  lastname.sendKeys("Wankhade");
	   System.out.println(lastname.getAttribute("id"));
	     
	  driver.findElement(By.id("userEmail")).sendKeys("deep@gmail.com");
	  //Thread.sleep(8000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("gender-radio-1'"))).click();
	  //driver.findElement(By.xpath("//input[@value='Male' ][@value='Male']")).click();
	  //driver.findElement(By.id("gender-radio-1")).click();
	  //Thread.sleep(8000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='subjects-auto-complete__control css-yk16xz-control']"))).sendKeys("testHistory");
	 // driver.findElement(By.xpath("//div[@class='subjects-auto-complete__control css-yk16xz-control']")).sendKeys("test");
	   //Thread.sleep(4000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
	  //driver.findElement(By.id("submit")).submit();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	 
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	  wait=new WebDriverWait(driver,10);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
