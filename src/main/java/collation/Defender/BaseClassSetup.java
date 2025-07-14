package collation.Defender;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * BaseClassSetup is a reusable base class that initializes the WebDriver,
 * loads configuration properties, and sets up browser session parameters.
 */

public class BaseClassSetup {

	public static WebDriver driver;
	public static Properties prop;
	public static String path=System.getProperty("user.dir");
	
	// Constructor to load configuration properties
	
public BaseClassSetup() {
		
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\collation\\def\\prop\\conf.property");
			prop.load(ip);
		}
		catch(Exception io) {
			System.out.println("Syntax Error");
		}
		}


// Launches the browser and sets up initial driver configuration

public void lunch() {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
    // Browser setup	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
    // Timeouts
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	
    // Navigate to the configured URL
	driver.get(prop.getProperty("url")); 
}
}
