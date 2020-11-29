package testnggroups;

import org.testng.annotations.Test;
@Test (groups = "CommonGroup")
public class TestNGGroups {
	  
	@Test (groups = { "Car","make" })//,enabled = false)	  
	  public void Car1() {
	 
	  System.out.println("Batch Car - Test car 1");
	 
	  }
	
	@Test (groups = { "Car.audi","make","Ketan" },alwaysRun= true)	  
	  public void openBrowserInGroups() {
	 
	  System.out.println("Batch Car - Test openBrowserInGroups File");
	 
	  }
	 
	  @Test (groups = { "Car", "take","Regression","high" })	 
	  public void Car2() {
	 
	  System.out.println("Batch Car - Test car 2");
	 
	  }
	 
	  @Test (groups = { "Scooter","cake" })	 
	  public void Scooter1() {
	 
	  System.out.println("Batch Scooter - Test scooter 1");
	 
	  }
	 
	  @Test (groups = { "Scooter" ,"sake"})	 
	  public void Scooter2() {
	 
	  System.out.println("Batch Scooter - Test scooter 2");
	 
	  }
	 
	  @Test (groups = { "Car", "Sedan Car","take" })
	 
	  public void Sedan1() {
	 
	  System.out.println("Batch Sedan Car - Test sedan 1");
	 
	  }
	  
	  public void getName() {
		  
	  }
	 }
