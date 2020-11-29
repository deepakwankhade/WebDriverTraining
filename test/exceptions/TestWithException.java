package exceptions;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class TestWithException {
	
	@Test(expectedExceptions={IOException.class})
	public void exceptionTestOne() throws Exception{
		throw new IOException();
	}
	
	@Test(expectedExceptions={IOException.class,
		NullPointerException.class})
	public void exceptionTestTwo() throws Exception{
	//	throw new NullPointerException();
		throw new ArrayIndexOutOfBoundsException();
		}
	
/*	
	@Test(expectedExceptions = NoSuchElementException.class) 
	public void checkForInvalidLogin() {
		//After writing code for Login
		WebElement compose = driver.findElement(By.linkText("Compose"));
	}*/

}
