package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MySecondTestNGTest {
	WebDriver driver;
	@Test
	public void testGoogleSearch() {
		
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("WebDriver Learning");
	}
  @Test
  public void myFirstTest() {
	  driver.get("http://selenium-examples.nichethyself.com");
	  driver.findElement(By.id("loginname")).sendKeys("stc123");
		
		/*WebElement userName =driver.findElement(By.id("loginname"));
		userName.sendKeys("stc123");*/
		driver.findElement(By.id("loginpassword")).sendKeys("12345");
		/*WebElement userPassword = driver.findElement(By.id("loginpassword"));
		userPassword.sendKeys("12345");*/
		driver.findElement(By.id("loginbutton")).click();
		//Test
		String expectedTitle = "My Account";
		String actualTitle =  driver.getTitle();
		
		if (driver.getTitle().equalsIgnoreCase(expectedTitle)) {
			System.out.println("Test Case is passed actual title is " + actualTitle);
		}else {
			
			System.out.println("Expected and acutal title does not match. Expected Title is" + expectedTitle + " but Actaul Title displayed is "+ actualTitle);
		}
  }
  @BeforeClass
  public void beforeClass() {
	  
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bits.exe");
		//System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
		driver= new ChromeDriver();
		//driver =new FirefoxDriver();
		//driver =new InternetExplorerDriver();
		driver.manage().window().maximize();
		
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
