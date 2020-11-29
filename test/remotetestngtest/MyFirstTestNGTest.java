package remotetestngtest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

public class MyFirstTestNGTest {
	RemoteWebDriver driver;
	@Test
	public void testGoogleSearch() {
		
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("WebDriver Learning");
	}
  //@Test
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
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	 /* DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setBrowserName("chrome");*/
		//System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bits.exe");
		//System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
	  	//driver= new RemoteWebDriver(new URL("192.168.1.20/wd/hub"),caps);
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setBrowserName("chrome");
	  	driver = new RemoteWebDriver(new URL("http://192.168.1.20:4444/wd/hub"),caps);
		//driver =new FirefoxDriver();
		//driver =new InternetExplorerDriver();
		driver.manage().window().maximize();
		
  }

 

}
