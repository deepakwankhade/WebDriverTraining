package waits;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.*;

//import org.testng.Assert;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class HandlingAlertsWindowsFrames {
  WebDriver driver;
  Alert myAlert;
  WebDriverWait wait;
 // @Test
  public void handlingAlerts() throws InterruptedException {
	  	driver.get("http://selenium-examples.nichethyself.com");
		WebElement myElement = driver.findElement(By.id("loginname"));
		myElement.sendKeys("stc123");//method chaining.
		wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).submit();
		//driver.findElement(By.name("password")).submit();	  
		//Thread.sleep(3000);
		
		String expectedMessage = "Please enter Password";		
		try {
			myAlert = driver.switchTo().alert();
			String actualMessage = myAlert.getText();
				
			assertEquals(actualMessage,expectedMessage,"Actual and expected Message does not match");
			
			myAlert.accept();
		}catch(NoAlertPresentException e) {
			fail("Seems Developer has forgotten to put alert box. Ha Ha Ha");//Assert
		}
		//For cancel
	/*	myAlert.dismiss();
	 *  //For typing text inside alert
		myAlert.sendKeys("ABC");*/
  }
  
  //@Test
  public void handlingWindowsPoupups() throws InterruptedException {
	  	driver.get("http://selenium-examples.nichethyself.com");
	  	String parentWindowHandle = driver.getWindowHandle();
	  	driver.findElement(By.xpath("//button[text()='Contact us!']")).click();
	  	try { 
	  		driver.switchTo().window("Contact"); //Name of the window given by developer
	  		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("glyphicon-search"))).click();
	  		
	  		  		//Thread.sleep(5000);
	  		//driver.findElement(By.className("glyphicon-search")).click();
	  //driver.findElement(By.ByCssSelector.className("glyphicon-search")).click();
	  		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("glyphicon-search"))).click();
	  		//Thread.sleep(5000);
	  		wait.until(ExpectedConditions.alertIsPresent());
	  		Alert myAlert;
	  		try {
	  			
	  			
	  			myAlert = driver.switchTo().alert();
	  			myAlert.sendKeys("London");
	  			
	  			//Thread.sleep(3000);
	  			wait.until(ExpectedConditions.alertIsPresent());
	  			myAlert.accept();	  			
	  		}catch (NoAlertPresentException e) {
	  			fail("No alert");
	  		}
	  	}catch (NoSuchWindowException e) {
	  		fail("There was a contact us Window Expected");
	  	}
	  	driver.close();
		driver.switchTo().window(parentWindowHandle);
	  	
  }
  
  @Test
  public void windowHandleTest() {
	  
	  driver.get("http://selenium-examples.nichethyself.com");
	  String ParentWindowHandle= driver.getWindowHandle();
	  driver.findElement(By.xpath("//button[text()='Contact us!']")).click();
	  Set<String> allWindows= driver.getWindowHandles();
	 for(String oneWindow:allWindows) {
		 if( !oneWindow.equals(ParentWindowHandle)) {
			 driver.switchTo().window(oneWindow);
			 
		 }
	 }
	  
	  try{
		  driver.switchTo().window("Contact");
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("glyphicon-search"))).click();
		  Alert myAlert;
		  try {
			wait.until(ExpectedConditions.alertIsPresent());
			  myAlert= driver.switchTo().alert();
			  myAlert.sendKeys("Paris");
			  myAlert.accept();
		  }catch(NoAlertPresentException e){
			  fail("No Alert found");
			  
		  }
		  driver.close();
		  driver.switchTo().window(ParentWindowHandle);
		  
	  }catch(NoSuchWindowException e) {
		  fail("There was a contact us window expected");
		  
	  }
  }
  
 // @Test
  
  public void multipleWindows() {
	  driver.get("http://selenium-examples.nichethyself.com/");
	  
  }
  @BeforeClass
  public void beforeClass() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bits.exe");

		//driver = new ChromeDriver();//Opens the browser - represents one browser window		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		wait =new WebDriverWait(driver,10);
		//Implicit Wait in Selenium
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		//Whenever you are calling findElement method and if the element is not found
		//Selenium will NOT throw NoSuchElementException
		//It will wait for the element to appear.
		//How much time? 500 ms (polling 
		//After 500ms it will again check if the element is found, if not 
		//wait again 500ms
		// till it reaches total of 10 second
		//if element is not found even after 10 seconds then NoSuchElementException will be thrown
		
		
		
		
		
		
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
  }

}
