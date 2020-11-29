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

public class MyFirstTestNGTestUsingTwoPageObjects {
	NTHomePage myPage;
	MyAccountPage myAccPage;
	
  @Test
  public void nicheThyselfLogin() {
	/* myAccPage = myPage.login("stc123", "12345");
	  myAccPage.goToContactUsWindow();
	  myAccPage.signOut();*/
	  
	  myPage.login("stc123", "12345")
	  .goToContactUsWindow()
	  .signOut();
	  		
	 
	  
	  
	 
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
  
  

}
