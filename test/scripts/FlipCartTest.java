package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class FlipCartTest {
	 WebDriver driver;
  @Test
  public void allLinksFlipCart() {
	  driver.get("https://www.flipkart.com/");
		  
	  List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	  /*for(int i=0;i<allLinks.size();i++) {
		  
		  System.out.println(allLinks.get(i).getText() + " " +allLinks.get(i).getAttribute("href"));
	  }*/
	  
	  for (WebElement links: allLinks) {
		  System.out.println(links.getText() + " " + links.getAttribute("href"));
		  
	  }
	  
	  
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  
	 
	  driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
