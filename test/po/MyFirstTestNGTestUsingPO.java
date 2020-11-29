package po;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class MyFirstTestNGTestUsingPO {
	NTHomePage myPage;
  @Test
  
  public void nicheThyselfLogin() {
	  myPage.login("stc123","12345");
	  String expectedTitle="My Account";
	  String actualTitle= myPage.nextPageTitle();
	  assertEquals(actualTitle, expectedTitle);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  myPage= new NTHomePage();
	  
  }

  @AfterMethod
  public void afterMethod() {
	  
	 myPage.quitBrowser();
  }

}
