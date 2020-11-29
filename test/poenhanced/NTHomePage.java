package poenhanced;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class NTHomePage extends LoadableComponent<NTHomePage> {
	
	@FindBy (id = "loginname")
	private WebElement user;

	@FindBy (id = "loginpassword")	
	@CacheLookup
	private WebElement pass;
	
	@FindBy (id = "loginbutton")
	@CacheLookup
	private WebElement submit;
	
	@FindBy (tagName = "a")
	@CacheLookup
	private List<WebElement> allLinks;
	
	private WebDriver driver;
	private String expectedTitle = "STC Tourism";
	private String actualTitle;
	public NTHomePage() {
		
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();//Opens the browser - represents one browser window
		PageFactory.initElements(driver, this);//this represents object of page object
		
		
	}
	
	public NTHomePage(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver, this);//this represents object of page object
		
		
	}
	
	@Override
	public void isLoaded() {
		actualTitle = driver.getTitle();
		assertEquals(actualTitle,expectedTitle);
	}
	
	public MyAccountPage login(String username, String password) {	
		user.clear();
		user.sendKeys(username); //does not reuse the reference.
		user.getAttribute("value");
		user.getCssValue("color");
		pass.sendKeys(password);
		submit.click();	
		MyAccountPage myAccoPage= new MyAccountPage(driver);
		return myAccoPage;
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public String getNextPageTitle() {
		return driver.getTitle();
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("http://selenium-examples.nichethyself.com");
	}
	
}
