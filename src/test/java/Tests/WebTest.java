package Tests;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WebTest {

    @SneakyThrows
    @Test
    public void testGoogleSearchUsingSelenoid() throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("enableVNC", false);
//        capabilities.setCapability("enableVideo", false);
//        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.co.in");
        System.out.println("=========> Asserting the title of the page");
        System.out.println("Title of the page is: "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }
}