package poenhanced;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class MyFirstTestNGTestUsingPO {
	NTHomePage myPage;
	
  @Test
  public void nicheThyselfLogin() {
	  myPage.login("stc123", "12345");
	  String expectedTitle = "My account";
	  String actualTitle = myPage.getNextPageTitle();
	  assertEquals(actualTitle,expectedTitle);
	  System.out.println("Inside first test of MyFirstTestNGTestUsingPO");
  }
  @Test
  public void nicheThyselfLogin1() {
	System.out.println("Inside second test of MyFirstTestNGTestUsingPO");
  }
   
   
  @AfterMethod
  public void afterMethod() {
	  //post test activities happens here.
	 myPage.quitBrowser();
  }
  @BeforeMethod
  public void beforeMethod() {
		 myPage = new NTHomePage();
		 myPage.get();
  } 
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside beforeClass of MyFirstTestNGTestUsingPO Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside afterClass of MyFirstTestNGTestUsingPO Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest of MyFirstTestNGTestUsingPO Class");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest of MyFirstTestNGTestUsingPO Class");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside beforeSuite of MyFirstTestNGTestUsingPO Class");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside AfterSuite of MyFirstTestNGTestUsingPO Class");
  }
}
