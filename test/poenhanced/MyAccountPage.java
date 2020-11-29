package poenhanced;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends LoadableComponent<MyAccountPage> {
	@FindBy(xpath="//button[text()='Contact us!']")
	private WebElement contactUs;
	@FindBy(xpath="//a[@href='home.html']")
	private WebElement signOut;
	
	private WebDriver driver;
	
	WebDriverWait wait;
	
	String ExpectedPageTitle  ="My account";
	
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
		
	}
	
	
	public MyAccountPage goToContactUsWindow() {
		contactUs.click();
		return this;
	}
	
	public NTHomePage signOut() {
		signOut.click();
		NTHomePage myNTHomePage = new NTHomePage(driver);
		return myNTHomePage;
		
		
		
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		//nothing
		
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains("account"));
		assertEquals(driver.getTitle(), ExpectedPageTitle);
		
	}

}
