package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

//import org.testng.Assert;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class WebElementMethods {
  WebDriver driver;
//  @Test
  public void learningWebElementCommands() {
	  	driver.get("http://selenium-examples.nichethyself.com");
		WebElement myElement = driver.findElement(By.id("loginname"));
		myElement.sendKeys("stc123");//method chaining.
		
		//How to clear the content of a text box
		myElement.clear();
		
		myElement.click();
		myElement.getText();
		myElement.getAttribute("name");
		
		//How to check if the element is visible?
		myElement.isDisplayed();
		//How to check if the element is enabled or disabled
		myElement.isEnabled();
		//Radio buttons and you checkboxes
		myElement.isSelected();
	  
		//How to get a tag name of an element
		myElement.getTagName();
		
		//You can also get the size and position of elements
		
		myElement.getSize();
		
		myElement.getCssValue("color");
		
		myElement.submit(); //is same as click but works inside form tag
		
		driver.findElement(By.name("password")).sendKeys("ABC");
		driver.findElement(By.name("password")).submit();	  
  }
  
 // @Test
  public void handlingCheckBox() {
	  driver.get("http://selenium-examples.nichethyself.com/");
	  driver.findElement(By.linkText("Customized tours")).click();
	  WebElement englandCheckBox = driver.findElement(By.xpath("//label[text()='England']/input"));
	  if (!englandCheckBox.isSelected())
		  englandCheckBox.click();
  }
  
  //@Test
  public void handlingRadioButton() {
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  driver.findElement(By.xpath("//input[@value='Petrol']")).click();	
  }
  
 // @Test
  public void handlingDropDowns() throws InterruptedException {
	  //Select class
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  WebElement dropDown = driver.findElement(By.name("make"));
	  Select myDropDown = new Select(dropDown);
	  assertFalse(myDropDown.isMultiple());
	  Select myDropDown2 = new Select(driver.findElement(By.name("make")));
	  myDropDown.selectByValue("audi");
	//  Thread.sleep(3000);
	  myDropDown.selectByVisibleText("Honda");
	//  Thread.sleep(3000);
	  myDropDown.selectByIndex(1);
	//  Thread.sleep(3000);
	  List<WebElement> allOptions = myDropDown.getOptions();
	  System.out.println("No. Of options in dropdown are - " + myDropDown.getOptions().size());
	 
	  String actualSelectedOption = myDropDown.getFirstSelectedOption().getText();
	  String expectedSelectedOption = "Mercedes1";
	  
	  /*if (actualSelectedOption.equals(expectedSelectedOption))
		  System.out.println("Test Case Pass");
	  else
		  System.out.println("Test Case Fail"); 
	  */
	  assertEquals(actualSelectedOption,expectedSelectedOption);	  
  }
  
  
  @Test
  public void handlingMultiSelect() throws InterruptedException {
	  //Select class
	  driver.get("http://cookbook.seleniumacademy.com/Config.html");
	  WebElement dropDown = driver.findElement(By.name("color"));
	  Select myDropDown = new Select(dropDown);
	  assertTrue(myDropDown.isMultiple());
	  myDropDown.selectByValue("wt");
	  Thread.sleep(3000);
	
	  myDropDown.selectByVisibleText("Brown");
	  Thread.sleep(3000);
	  myDropDown.selectByIndex(4);
	  Thread.sleep(3000);
	  List<WebElement> allOptions = myDropDown.getOptions();
	  System.out.println("No. Of options in MultiSelct are - " + myDropDown.getOptions().size());
	  myDropDown.deselectByValue("wt");
	  Thread.sleep(2000);
	  myDropDown.deselectByVisibleText("Silver");
	  Thread.sleep(2000);
	  myDropDown.deselectByIndex(3);
	  myDropDown.deselectAll();
	  
	  myDropDown.isMultiple();//verifies whether this element is multiselect or dropdown
	  //if it returns true, it is multiselect, if it returns false it is dropdown.
	  List<WebElement> allSelectedColors = myDropDown.getAllSelectedOptions();
	  String expectedSelectedOption = "Mercedes1";
	  
	  }
  
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		
		driver = new ChromeDriver();//Opens the browser - represents one browser window		
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
