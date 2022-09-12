package FrameworkWithoutPageFactoryParallelMethods;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


// Referred: https://github.com/cbeust/testng/issues/2188

public class TestBaseDriverSafe {
	
  private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
  
  
  @Parameters ({"browser"})
  @BeforeMethod(alwaysRun = true)
  public void startDriver(Method method,String browser) {
	if(browser.equalsIgnoreCase("chrome")) {  
		WebDriverManager.chromedriver().setup();
	    driver.set(new ChromeDriver());
	}
	else if(browser.equalsIgnoreCase("firefox")){
		WebDriverManager.firefoxdriver().setup();
	    driver.set(new FirefoxDriver());
	}

    System.err.println(method.getName() + "() will use WebDriver instance " + driver.get().hashCode());
  }

  @AfterMethod(alwaysRun = true)
  public void stopDriver() {
    driver.get().quit();
  }

  public static WebDriver getDriver() {
    return driver.get();
  }
}