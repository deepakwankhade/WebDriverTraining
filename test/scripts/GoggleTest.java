package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class GoggleTest {
	WebDriver driver;
  @Test
  public void myGoogleLogin() {
	  
	  driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
	  driver.findElement(By.id("identifierId")).sendKeys("deepakwankhade");
	  driver.findElement(By.id("passwordNext")).sendKeys("Sanika@0103");
	  driver.findElement(By.id(":13a")).click();
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
	  
	  
  }

}
