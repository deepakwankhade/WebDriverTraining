package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class RadioCheckBoxTest {
	WebDriver driver;
  @Test
  public void radioButtonCheckBox() {
	  
	  driver.get("http://demoqa.com/automation-practice-form/");
	  WebElement name = driver.findElement(By.id("firstName"));
	  name.sendKeys("testdeepak");
	  WebElement lastname = driver.findElement(By.id("lastName"));
	  lastname.sendKeys("Wankhade");
	  driver.findElement(By.id("userEmail")).sendKeys("deep@gmail.com");
	  driver.findElement(By.xpath("//input[@value='Male' ][@value='Male']")).click();
	  //driver.findElement(By.xpath("//input[@value='Male']")).click();
	  //driver.findElement(By.id("dateOfBirthInput")).sendKeys("09252013");
	  
	 // driver.findElement(By.className("subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3")).sendKeys("Cricket");
	  //driver.findElement(By.xpath("//div[@class='subjects-auto-complete__control css-yk16xz-control']")).sendKeys("test");
	  /*WebElement hobbyCheckbox =driver.findElement(By.id("hobbies-checkbox-1"));
	  if(!hobbyCheckbox.isSelected())
		  hobbyCheckbox.click();*/
	  
	  WebElement stateAndCity = driver.findElement(By.id("state"));
	  
	  Select dropDown1= new Select(stateAndCity);
	  dropDown1.selectByIndex(1);
	  dropDown1.selectByVisibleText("Uttar Pradesh");
	  
	  WebElement citySelect=driver.findElement(By.id("city"));
	  Select dropDown2 =  new Select(citySelect);
	  dropDown2.selectByVisibleText("Lucknow");
	  driver.findElement(By.id("submit")).submit();
  }
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
