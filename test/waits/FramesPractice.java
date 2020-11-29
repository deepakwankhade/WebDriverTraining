package waits;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class FramesPractice {
	WebDriver driver;
  @Test(priority =1)
  public void frameIdorName() {
	  
	  //driver.get("http://www.cookbook.seleniumacademy.com/Frames.html");
	  try{
		  driver.switchTo().frame("left");
	  }catch(NoSuchFrameException e){
		  fail("Frame was expectec but not found");
		  
	  }
	  
	  WebElement leftMessage = driver.findElement(By.tagName("p"));
	  assertEquals(leftMessage.getText(), "This is Left Frame");
	  driver.switchTo().defaultContent();
	  driver.switchTo().frame("right");
	  WebElement rightMessage =driver.findElement(By.tagName("p"));
	  assertEquals(rightMessage.getText(), "This is Right Frame");
	  driver.switchTo().defaultContent();
  }
  
  @Test(priority =2)
  
  public void frameWithIndex() {
	  
	  driver.switchTo().frame(1);
	  WebElement middleMessage =driver.findElement(By.tagName("p"));
	  assertEquals(middleMessage.getText(), "This Frame doesn't have id or name", "NoMiddel Window Message Found");
	  driver.switchTo().defaultContent();
  }
  
  @Test(priority =3)
  public void testFrameByContent() {
	  
	  List<WebElement> frames  = driver.findElements(By.tagName("p"));
	  
	  for(WebElement frame : frames) {
		  driver.switchTo().frame(frame);
		  if(driver.getPageSource().contains("This Frame doesn't have id or name")){
			  
			  assertTrue(true);
			 break;
			  
			  
		  }else {
			  driver.switchTo().defaultContent();
		  }
		  
	  }
  }
  
  @Test(priority =4)
  public void testIframe() {
	  
	  String currentWindow = driver.getWindowHandle();
	  driver.switchTo().frame("right");
	  WebElement twitterFrame= driver.findElement(By.tagName("iframe"));
	  driver.switchTo().frame(twitterFrame);
	  WebElement button = driver.findElement(By.id("follow-button"));
	  button.click();
	  
	  Set<String> allWindows = driver.getWindowHandles();
	  for(String windowId : allWindows) {
		  if(driver.getTitle().equalsIgnoreCase("Unmesh Gundecha (@upgundecha) on Twitter")) {
			  assertTrue(true, "Twitter Login Popup Window Found");
			  driver.close();
			  break;
			  
		  }
		  
	  }
	  driver.switchTo().window(currentWindow);
	  driver.switchTo().parentFrame();
	  driver.switchTo().defaultContent();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://www.cookbook.seleniumacademy.com/Frames.html");
  }

  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
