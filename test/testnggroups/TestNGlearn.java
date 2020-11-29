package testnggroups;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import static org.testng.Assert.*;

public class TestNGlearn {
  @Test
  public void testA() {
	  System.out.println("This is test case A");
	//  fail("Test A failed");
  }
  @Test
  public void testB() {
	  System.out.println("This is test case B");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before1 Method Executed");
  }
  
  @BeforeMethod
  public void beforeMethod1() {
	  System.out.println("Before2 Method Executed");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After1 Method Executed");
  }

  @AfterMethod
  public void afterMethod1() {
	  System.out.println("After2 Method Executed");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class Executed");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class Executed");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before Test Executed");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After Test Executed");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite Executed");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite Executed");
  }

}
