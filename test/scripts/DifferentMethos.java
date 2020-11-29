package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DifferentMethos {
	WebDriver driver;
  @Test
  
  public void methodsPractice() {
	  
	  driver.get("http://selenium-examples.nichethyself.com");
	  /*driver.getPageSource();
	  driver.getCurrentUrl();
	  driver.manage().window().maximize();
	  driver.manage().getCookies();
	  driver.manage().deleteAllCookies();
	  driver.navigate().back();
	  driver.navigate().forward();*/
	  
	 // driver.get("http://selenium-examples.nichethyself.com");
	  driver.findElement(By.linkText("Customized tours")).click();
	  WebElement element= driver.findElement(By.xpath("//label[text()='England']"));
	  element.click();
	  element.getText();
	  element.isDisplayed();
	  element.isDisplayed();
	  //Different ways of refresh method
	  driver.get("http://demo.guru99.com/selenium/guru99home/");
	  driver.navigate().refresh();
	  driver. findElement(By.id("username")).sendKeys(Keys.F5);  	// using F5 Key	
	  driver. findElement(By.id("username")).sendKeys("\\uE035"); //using ASCII  q
	  
	   
  }
  
  @BeforeMethod
  public void beforeMethod(){
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
  }
  
  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
	  
  }

}
