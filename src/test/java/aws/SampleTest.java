package aws;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	
	WebDriver driver=null;
  
@Parameters("browser")	
 @Test
  public void setup(String browser) {
	
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("browserName", "chrome");
		try {
			driver=new RemoteWebDriver(new URL("http://3.109.55.170:4444/wd/hub"),dc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
//		driver=new FirefoxDriver();
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("browserName", "firefox");
		try {
			driver=new RemoteWebDriver(new URL("http://3.109.55.170:4444/wd/hub"),dc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.google.co.in");
	
	driver.quit();
  }
}
