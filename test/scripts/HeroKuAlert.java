package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HeroKuAlert {
WebDriver driver;
Alert alert;
	
	String Url  			  = "https://the-internet.herokuapp.com/javascript_alerts";
	String chromeKey		  = "webdriver.chrome.driver";
	String chromeDriverPath   = "test\\resources\\chromedriver.exe";
	//String fireFoxKey		  = "webdriver.gecko.driver";
	//String fireFoxDriverPath  = "test/resources/geckodriver";
	String browserName 		  = "Chrome";
	
	@BeforeClass
	public void beforeClass() 
	{
	
		if(browserName.equals("Chrome"))
			{
				System.setProperty(chromeKey,chromeDriverPath );
				driver = new ChromeDriver();
			}
		else if(browserName.equals("Firefox"))
			{
				//System.setProperty(fireFoxKey,fireFoxDriverPath );
				driver = new FirefoxDriver();
			}
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		driver.get(Url);
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}		
	
	@Test(priority = 1)
	public void heroKuAppAlertsOnlyAccept() throws InterruptedException 
	{	
		clickAlertButton("Click for JS Alert");
		driver.switchTo().alert();
		System.out.println("Switched to "+ driver.switchTo().alert());
		Thread.sleep(3000);
		driver.switchTo().alert().getText().equals("I am a JS Alert");
		driver.switchTo().alert().accept();
		alertStatusConfirmation("You successfuly clicked an alert");
		
	}
	
	@Test(priority = 2)
	public void heroKuAppAlertsAcceptAndDismiss() throws InterruptedException 
	{	
		clickAlertButton("Click for JS Confirm");
		driver.switchTo().alert();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		alertStatusConfirmation("Ok");
		
	}
	
	@Test(priority = 3)
	public void heroKuAppAlertsDismiss() throws InterruptedException 
	{	
		clickAlertButton("Click for JS Confirm");
		driver.switchTo().alert();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		alertStatusConfirmation("Cancel");
	}
	
	@Test(priority = 4)
	public void heroKuAppAlertsKeysAccept() throws InterruptedException 
	{	
		clickAlertButton("Click for JS Prompt");
		driver.switchTo().alert();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Thank You");
		driver.switchTo().alert().accept();
		alertStatusConfirmation("Thank You");
	}
	
	@Test(priority = 5)
	public void heroKuAppAlertsKeysDismiss() throws InterruptedException 
	{	
		clickAlertButton("Click for JS Prompt");
		driver.switchTo().alert();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Thank You");
		driver.switchTo().alert().dismiss();
		alertStatusConfirmation("null");
	}
	
	public void clickAlertButton(String button_name) throws InterruptedException
	{
		WebElement clickButton = driver.findElement(By.xpath("//li/button[contains(text(),'"+button_name+"')]"));
		System.out.println("Button ready for Click is --> " + clickButton.getText());
		if(clickButton.getText().equals(button_name));				
			clickButton.click();
			Thread.sleep(5000);
	}
	
	//h4/following-sibling::p
	public void alertStatusConfirmation(String expectedResult)
	{
		String actualResult;
		WebElement visibleResult = driver.findElement(By.xpath("//h4/following-sibling::p"));
		actualResult = visibleResult.getAttribute("innerHTML");
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.manage().getCookies().clear();
	}

	@AfterClass
	public void afterClass() 
	{
		driver.quit();
	}
	

	

}
