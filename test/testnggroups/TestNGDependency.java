package testnggroups;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TestNGDependency {
  @Test ( groups = {"take"}, dependsOnMethods = "openBrowser")
  public void signIn() {
	  System.out.println("SignIn executed");
  }      
  @Test (groups = {"take","cake","make"})
  public void openBrowser(){
	  System.out.println("openBrowser Executed");	
	 // assertTrue(false);
  }  
  @Test (dependsOnGroups = {"take"},groups={"make"})
  public void signOut(){
	  System.out.println("SignOut Executed");	
  }  
  @Test (dependsOnGroups = {"make"},groups={"cake"})
  public void MignIn(){
	  System.out.println("MignIn got executed");	  
  }  
  @Test (groups = {"sake"})
  public void aotDependentOnAnything(){
	  System.out.println("notDependentOnAnything Executed");
	  
  }  
  
  
  
  
}
