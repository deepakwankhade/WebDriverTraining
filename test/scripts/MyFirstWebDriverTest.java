package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import net.bytebuddy.implementation.EqualsMethod;

public class MyFirstWebDriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "test\\resources\\geckodriver-64bits.exe");
		//System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
		driver= new ChromeDriver();
		//driver =new FirefoxDriver();
		//driver =new InternetExplorerDriver();
		driver.manage().window().maximize();
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
		
		driver.quit();

	}

}
