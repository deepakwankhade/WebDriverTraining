package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class AnnaUnivercity {
	
	WebDriver driver;
	WebDriverWait wait;
	
  @Test
  public void annaUniTest() throws InterruptedException {
	  
	  WebElement civilDept=driver.findElement(By.name("link13"));
	  WebElement oceanSubMenu= driver.findElement(By.id("menuItemText32"));
	 // WebElement reasearchThemeLink= driver.findElement(By.id("link3"));
	  //WebElement coastalSubMenu=driver.findElement(By.id("menuItemText13"));
	  WebElement reasearchThemeLink= driver.findElement(By.linkText("Research Themes"));
	  WebElement coastalSubMenu=driver.findElement(By.id("menuItemText12"));
	  
	  String expectedPageTitle="Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts";
	  String actualPageTitle=driver.getTitle();
	  Actions builder = new Actions(driver);
	  
	  builder.moveToElement(civilDept).moveToElement(oceanSubMenu).click().build().perform();
	  Thread.sleep(50000);
	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //wait.until(ExpectedConditions.elementToBeClickable(reasearchThemeLink));
	   
	  builder.moveToElement(reasearchThemeLink).moveToElement(coastalSubMenu).click().build().perform();
	  assertEquals(actualPageTitle, expectedPageTitle, "actualTitle and expected title does not match.ActualTitle is " +actualPageTitle);
	
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver= new ChromeDriver();
	  wait =new WebDriverWait(driver,10,250);
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.annauniv.edu/department/index.php");
	  //driver.get("https://www.annauniv.edu/iom/home.php#");
	  
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
