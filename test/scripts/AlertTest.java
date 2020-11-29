package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class AlertTest {
	
	 WebDriver driver;
  @Test(priority=1)
  public void alertsHandling1() {
	  
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
	  Alert myAlert;//need to ask query we have not created object and 
	 // accessing methods of the Alert class by only object referecne.Is this due to Alert is static ????
	  
	  String expectedMessage="I am a JS Alert";
	  
	  try {
		  myAlert= driver.switchTo().alert();
		  String actualMessage = myAlert.getText();
		  assertEquals(actualMessage, expectedMessage, "Actual message does not match");
		  myAlert.accept();
		  
	  }catch(NoAlertPresentException e){
		  fail("Seems Developer has forgotten to add alert message");
		  
	  }
	  
	  WebElement actualMessageColor =driver.findElement(By.id("result"));
	 	  
	  actualMessageColor.getCssValue("color:green");
	  System.out.println(actualMessageColor);
	   
	  
  }
  @Test(priority =2)
  public void alertHandlin2() {
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	  Alert myalert2;
	  String expectedMessageAlert2= "I am a JS Confirm";
	  try{
		  myalert2 = driver.switchTo().alert();
		  String actualMessageAlert2=myalert2.getText();
		  assertEquals(actualMessageAlert2, expectedMessageAlert2, "No Alert Found for this action2");
		  myalert2.accept();
		 // myalert2.dismiss();
	  }catch(NoAlertPresentException e) {
		  fail("Seems Developer has forgotten to add alert message2");
	  }
	  
	 
	  
  }
  
  @Test(priority =3)
  public void alertHandlin3() {
	  
	  driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
	  Alert myAlert3;
	  String expectedMessage3= "I am a JS prompt";
	  
	  try{
		  myAlert3= driver.switchTo().alert();
		  String actualMessage3= myAlert3.getText();
		  assertEquals(actualMessage3, expectedMessage3, "No Alert Found for this action3");
		  myAlert3.sendKeys("Harry Potter");
	  }catch(NoAlertPresentException e) {
		  fail("Seems Developer has forgotten to add alert message3");
		  
	  }
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	 
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
