package SeleniumGridBrowserOptions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

public class Base {

	public WebDriver initializeBrowser(String browser) throws MalformedURLException {
		
		WebDriver driver;
		
		@SuppressWarnings("rawtypes")
		AbstractDriverOptions options=null;
		
		if(browser.equals("chrome")) {
			options=new ChromeOptions();
			options.setCapability("browserName","chrome");
		}
		else if(browser.equals("firefox")) {
			options=new FirefoxOptions();
			options.setCapability("browserName","firefox");
		} 
		else if(browser.equals("edge")) {
			options=new EdgeOptions();
			options.setCapability("browserName","MicrosoftEdge");
		} 
		
		else if(browser.equals("safari")) {
			options=new SafariOptions();
			options.setCapability("browserName","safari");
		}
		
//		else if(browser.equals("ie")) {
//			dc.setBrowserName("internet explorer");
//		} 
//		else if(browser.equals("opera")) {
//			dc.setBrowserName("opera");
//		}
		
		
		driver= new RemoteWebDriver(new URL("http://localhost:4444"),options);
		
		return driver;
	}
}
