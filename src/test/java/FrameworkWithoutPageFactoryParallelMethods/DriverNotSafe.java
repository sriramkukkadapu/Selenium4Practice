package FrameworkWithoutPageFactoryParallelMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverNotSafe {
	
	WebDriver driver;
	
	public WebDriver getDriver(String executeLocation) {{
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(); 				
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		return driver;
	}
		
	}
	
	
	
	public void closeDriver() {
			
		driver.quit();		
	
	}
	


}
