package po;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooLoginPage extends LoadableComponent<YahooLoginPage> {
	@FindBy(name="username")
	private WebElement userid;
	//@CacheLookup
	
	@FindBy(id="login-signin")
	private WebElement nextBtn;
	//@CacheLookup
	
	@FindBy(id="login-passwd")
	private WebElement password;
	//@CacheLookup
	
	@FindBy(xpath="//a[text()='Mail")
	private WebElement mailLink;
	@CacheLookup
	
		
	private WebDriver driver;
	
	private String actualTitle;
	private String expectedTitle= "Yahoo India News ";
	
	WebDriverWait wait;
	
	public YahooLoginPage() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		
		driver= new ChromeDriver();
		PageFactory.initElements(driver, this);
		
		
	}
	
	public void login() {
		driver.get("https://login.yahoo.com/");
		userid.clear();
		userid.sendKeys("deepakwankhade706");
		nextBtn.click();
		//wait.until(ExpectedConditions.visibilityOf(password));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		password.sendKeys("Dhairya@2006");
		//wait.until(ExpectedConditions.visibilityOf(nextBtn));
		
		nextBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.visibilityOf(mailLink)
		mailLink.click();
		
				
	}
	
	public String nextPageTitle() {
		return driver.getTitle();
	}
	
	public void quitBrowser() {
		driver.quit();
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		//driver.get("https://login.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		wait= new WebDriverWait(driver,10,250);
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle, "expected and actualtile does not match");
		
	}

	
	
}
