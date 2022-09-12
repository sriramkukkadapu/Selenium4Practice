package FrameworkWithoutPageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSafe {

	WebDriver driver;
	WebDriver rawdriver;
	ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	// if no browser name paused this method will default return chrome
	public WebDriver getDriver(String executeLocation) {

		WebDriverManager.chromedriver().setup();

		rawdriver = new ChromeDriver();

		System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());

		threadLocalDriver.set(rawdriver); // this assigns a new thread id to the object, to prevent sync issues

		driver = threadLocalDriver.get(); // this driver is thread safe

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		return driver;

	}

	public WebDriver getDriver(String executeLocation, String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();

			rawdriver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")){

			WebDriverManager.firefoxdriver().setup();

			rawdriver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("safari")){

			WebDriverManager.safaridriver().setup();

			rawdriver = new SafariDriver();
		}
		

		System.out.println("Before Test Thread ID: " + Thread.currentThread().getId());

		threadLocalDriver.set(rawdriver); // this assigns a new thread id to the object, to prevent sync issues

		driver = threadLocalDriver.get(); // this driver is thread safe

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		return driver;

	}

	public void closeDriver() {

		WebDriver threadValue = threadLocalDriver.get(); // get current thread id

		driver.quit();

		threadLocalDriver.remove();

	}

}
