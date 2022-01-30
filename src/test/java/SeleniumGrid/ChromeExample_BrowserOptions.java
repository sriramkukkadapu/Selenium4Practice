package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeExample_BrowserOptions {
	
	//java -jar selenium-server-4.1.2.jar standalone

	public static void main(String args[]) throws MalformedURLException {
		
		ChromeOptions co=new ChromeOptions();
		
		co.setCapability("browserName", "chrome" );
		
		//co.setCapability("platformName", "Catalina" );
		
		
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"),co);
		
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com");
		
		System.out.println("=========> "+driver.getTitle());
		
		driver.quit();
		
		
		
	}
}
