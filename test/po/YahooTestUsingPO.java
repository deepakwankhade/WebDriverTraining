package po;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;

public class YahooTestUsingPO {
  YahooLoginPage myPage;
	
  @Test
  public void myYahooLogin() {
	  myPage.login();
	  String expectedPageTitle="Yahoo Mail";
	  String actualPageTitle=myPage.nextPageTitle();
	  assertEquals(actualPageTitle, expectedPageTitle);
  }
  @BeforeMethod
  public void beforeMethod() {
	  myPage= new YahooLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
