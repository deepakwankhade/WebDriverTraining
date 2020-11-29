package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class MyFirstTestNGTestUsingPO {
	NTHomePage myPage;
	
  @Test
  public void nicheThyselfLogin() {
	  myPage.login("stc123","12345");
	  String expectedTitle = "My account";
	  String actualTitle = myPage.getNextPageTitle();
	  assertEquals(actualTitle,expectedTitle);
  }
   
  @AfterMethod
  public void afterMethod() {
	  //post test activities happens here.
	 myPage.quitBrowser();
  }
  @BeforeMethod
  public void beforeMethod() {
		 myPage = new NTHomePage();
  } 
}
