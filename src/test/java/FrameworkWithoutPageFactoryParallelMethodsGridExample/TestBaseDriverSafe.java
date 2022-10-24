package FrameworkWithoutPageFactoryParallelMethodsGridExample;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

// Referred: https://github.com/cbeust/testng/issues/2188

public class TestBaseDriverSafe {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Parameters({ "browser" })
    @BeforeMethod(alwaysRun = true)
    public void startDriver(Method method, String browser) throws MalformedURLException {

        String host = "localhost";
        
        //=========== Method 1 Using Desired Capabilities ===========

/*        DesiredCapabilities dc = new DesiredCapabilities();
        
        WebDriverManager.chromedriver().setup();
        dc.setCapability("browserName", "chrome"); // by default set to chrome

        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            dc.setCapability("browserName", "firefox"); // set firefox if it is passed from property
        }
        
        if(System.getProperty("HUB_HOST")!=null)
        {
            host = System.getProperty("HUB_HOST");
        }
        
        String completeUrl = "http://" + host + ":4444/wd/hub";
        driver.set(new RemoteWebDriver(new URL(completeUrl),dc));
        
*/      
        
      //=========== Method 1 Using Mutable Capabilities + Chrome Options ===========
        
        MutableCapabilities dc;
        
        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = new FirefoxOptions();
            System.out.println("Running Test with Firefox");
        }else{
            dc = new ChromeOptions();
            System.out.println("Running Test with Chrome");
        }
     
        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
     
     
        String completeUrl = "http://" + host + ":4444/wd/hub";
        driver.set(new RemoteWebDriver(new URL(completeUrl),dc));

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