package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class WikipediaTest {
	WebDriver driver;
  @Test
  public void wikiPedia() throws InterruptedException   {
	  
	  driver.get("https://www.wikipedia.org/");
	  Thread.sleep(3000);
	  driver.findElement(By.id("js-link-box-en")).click();
	  Thread.sleep(4000);
	  WebElement searchWiki= driver.findElement(By.name("search"));
	  searchWiki.sendKeys("Selenium");
	  searchWiki.click();
	  driver.findElement(By.id("firstHeading")).getText();
	  
	   String expectedTitle = "Wikipedia, the free encyclopedia";
	   String acutalTitle = driver.getTitle();
	   
	   if (driver.getTitle().equalsIgnoreCase(expectedTitle)) {
		  System.out.println(" Test Case is passed .Actual Title is " + acutalTitle);
		   
	   }else {
		   
		   System.out.println("Test Case is Failed. Actual Title does not match with Expected title"
		   + expectedTitle +" Acutal Title displayed is " +acutalTitle );
		   
	   }
	   
	  
	  	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver= new ChromeDriver();
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
	  
  }

}
