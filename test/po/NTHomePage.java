package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NTHomePage {
	
	private WebElement user;
	private WebElement pass;
	private WebElement submit;
	
	private WebDriver driver;
	
	public NTHomePage() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://selenium-examples.nichethyself.com");
		
	}
	
	public void login(String username, String password) {
		user=driver.findElement(By.id("loginname"));
		pass=driver.findElement(By.id("loginpassword"));
		submit=driver.findElement(By.id("loginbutton"));
		user.sendKeys("username");
		pass.sendKeys("password");
		submit.click();
		
		
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public String nextPageTitle() {
		return driver.getTitle();
	}
	
	
	

}
