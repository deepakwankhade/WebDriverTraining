package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TrihoboTest {
	
	WebDriver driver;
	WebDriverWait wait;
  @Test
  public void tripPlan() throws InterruptedException {
	  	driver.findElement(By.id("plan-my-trip")).click();
	  	Thread.sleep(4000);
	  	driver.findElement(By.xpath("//input[@class='input-control js_city_search']")).sendKeys("Houston");
	  	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='input-control js_city_search']"))).sendKeys("Houston");
	  	driver.findElement(By.xpath("//li[@data-id='594d77e37f8b9ad2c20001bd']")).click();
	  	//driver.findElement(By.xpath("//input[@class='input-control js_city_search']")).sendKeys("Houston, United States");
	  	//driver.findElement(By.xpath("//span[text()='Houston, United States']")).click();
	  	Thread.sleep(6000);
	  	WebElement calender = driver.findElement(By.xpath("//i[@class='c-icon js_calendar_icon']"));
	  	Thread.sleep(8000);
	  	Actions builder = new Actions(driver);
	  	WebElement fromDate = driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active'][text()='20']"));
	  	//Thread.sleep(6000);
	  	WebElement toDate =driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active'][text()='28']"));
	  	//Thread.sleep(6000);
	  	builder.moveToElement(calender).click().moveToElement(fromDate).click().moveToElement(toDate).click().build().perform();
	  	Thread.sleep(6000);
	  	driver.findElement(By.xpath("//span[@class='button p-color full-width continue-planning']")).click();
	  	Thread.sleep(4000);
	  	driver.findElement(By.xpath("//span[@class='p-color p-size button next-btn-dsk']")).click();
	  	Thread.sleep(4000);
	  	driver.findElement(By.xpath("//span[text()='Skip to']")).click();
	  	Thread.sleep(6000);
	  	driver.findElement(By.xpath("//div[text()='Trip Overview']")).click();
	  	Thread.sleep(6000);
	  	
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver= new ChromeDriver();
	  wait =new WebDriverWait(driver,10,250);
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.triphobo.com/");
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
