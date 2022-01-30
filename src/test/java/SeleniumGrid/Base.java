package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {

	public WebDriver initializeBrowser(String browser) throws MalformedURLException {
		
		WebDriver driver;
		
		DesiredCapabilities dc=new DesiredCapabilities();
		
		if(browser.equals("chrome")) {
			dc.setBrowserName("chrome");
		}
		else if(browser.equals("firefox")) {
			dc.setBrowserName("firefox");
		} 
		else if(browser.equals("edge")) {
			dc.setBrowserName("MicrosoftEdge");
		} 
		else if(browser.equals("ie")) {
			dc.setBrowserName("internet explorer");
		} 
		else if(browser.equals("opera")) {
			dc.setBrowserName("opera");
		}
		else if(browser.equals("safari")) {
			dc.setBrowserName("safari");
		}
		
		driver= new RemoteWebDriver(new URL("http://localhost:4444"),dc);
		
		return driver;
	}
}
