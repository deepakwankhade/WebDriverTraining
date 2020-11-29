package waits;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class LearingWaits {
	WebDriver driver;
	WebDriverWait wait; //Explicit wait
  @Test
  public void herokuappLogin() throws InterruptedException {
	  driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
	  driver.findElement(By.xpath("//div[@id='start']/button")).click();
	  //WebElement finish = driver.findElement(By.xpath("//div[@id='finish']/h4"));
//	  wait.until(ExpectedConditions.visibilityOf(finish));
	  WebElement finish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
	  String expectedText = "Hello World!";
	 // Thread.sleep(6000);
	  String actualText = finish.getText();//Hello World!
	  wait.until(ExpectedConditions.visibilityOf(finish));
	  assertEquals(actualText,expectedText,"Comparison Failed.");
	  wait.until(ExpectedConditions.visibilityOf(finish));	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver_64bits.exe");

	//	driver = new ChromeDriver();//Opens the browser - represents one browser window		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,10);//500 ms defualt polling interval
		wait = new WebDriverWait(driver,10,250);//polling interval is set to 250 ms
		//Implicit Wait in Selenium
	//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	//	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
  }

}
