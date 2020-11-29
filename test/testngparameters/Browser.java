package testngparameters;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
	
	private static WebDriver driver;
	
	public static void setBrowser(String browser) {
		System.out.println("Inside setBrowser value = " + browser);
		if (browser.equals("CH")) {
			System.out.println("Test will run on Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	    	driver = new ChromeDriver();			
		}
		else if (browser.equals("FF")) {
			System.out.println("Test will run on Firefox Browser");
		//	FirefoxProfile profile = new FirefoxProfile();
		//	profile.setEnableNativeEvents(false);
			driver = new FirefoxDriver();
			
		} else if (browser.equals("SF")) {
			DesiredCapabilities capabilities = DesiredCapabilities.safari();
		//	capabilities.setJavascriptEnabled(true);
			capabilities.setCapability("nativeEvents", false);
		// capability.setBrowserName("firefox");
	       // capability.setPlatform(Platform.WIN8_1);
			driver = new SafariDriver(capabilities);
			
			
		}
		else if (browser.equals("IE")) {
			System.out.println("Test will run on Internet Explorer Browser");
			System.setProperty("webdriver.ie.driver", "src\\test\\java\\resources\\IEDriverServer.exe");
	    	driver = new InternetExplorerDriver();
	    	
		}	
		else 
		{
			System.out.println("Test will run on Firefox Browser as Default Browser");
			driver = new FirefoxDriver();
		}
    	
	}
  
    public static WebDriver driver() {
    	return driver;
    }  
        
    public static void open(String url) {
    	driver.manage().window().maximize();
    	driver.get(url); 
       
     }

    public static void close() {
       driver.quit();
    }
}
