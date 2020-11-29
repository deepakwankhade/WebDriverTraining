package testngparameters;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	@BeforeSuite
	public void suite()
	{
		System.out.println("Before suite");
	}
	
	@Parameters({"Browser","OS","TestEnv"})
	@BeforeClass (alwaysRun = true)
	//public void setUp(String browser, String os, String testEnv)
	public void setUp(@Optional("FF") String browser , @Optional("Windows") String os,@Optional("http://www.googledefault.com") String testEnv){	    
	System.out.println("Value of Browser parameter-" + browser);
		Browser.setBrowser(browser);
		Browser.driver().get(testEnv);
		//homePage.get();
	 }
	
	@Test
	public void test()
	{
		System.out.println("Inside Test");
	}
}
