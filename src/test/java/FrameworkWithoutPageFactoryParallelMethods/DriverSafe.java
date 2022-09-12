package FrameworkWithoutPageFactoryParallelMethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSafe {
	
	WebDriver driver;
	WebDriver rawdriver;
	static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	
	public WebDriver getDriver(String executeLocation) {{
		
		WebDriverManager.chromedriver().setup();
		
		rawdriver = new ChromeDriver(); 
		
		System.out.println("Before Test Thread ID: "+Thread.currentThread().getId());
		
		threadLocalDriver.set(rawdriver); //this assigns a new thread id to the object, to prevent sync issues
		
		driver = threadLocalDriver.get(); //this driver is thread safe		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		return driver;
	}
		
	}
	
	
	
	public void closeDriver() {
		
		WebDriver threadValue = threadLocalDriver.get(); //get current thread id
	
		driver.quit();
		
		threadLocalDriver.remove();
	
	}
	


}
