package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LearningWebElementCommands {
	
	WebDriver driver;
  @Test

  public void googleLinks() {
	  
	  driver.get("https://www.google.com/");
	  
	
	  
	  List<WebElement> allGoogleLinks = driver.findElements(By.tagName("a"));
	  
	  for (int i=0;i< allGoogleLinks.size();i++) {
		  
		  System.out.println(allGoogleLinks.get(i).getText() + " - " + allGoogleLinks.get(i).getAttribute("href"));
		  
	  }
	  
	/*for(WebElement onelink: allGoogleLinks ) {
		  
		  System.out.println(onelink.getText() + " - " + onelink.getAttribute("href"));
	  }*/
	  
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
				driver= new ChromeDriver();
				driver.manage().window().maximize();
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

 
}
