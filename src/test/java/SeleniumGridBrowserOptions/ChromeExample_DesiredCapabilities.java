package SeleniumGridBrowserOptions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeExample_DesiredCapabilities {
	
	//java -jar selenium-server-4.1.2.jar standalone

	public static void main(String args[]) throws MalformedURLException {
		
		DesiredCapabilities dc=new DesiredCapabilities();
		
		dc.setCapability("browserName", "chrome" );
		
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com");
		
		System.out.println("=========> "+driver.getTitle());
		
		driver.quit();
		
		
		
	}
}
