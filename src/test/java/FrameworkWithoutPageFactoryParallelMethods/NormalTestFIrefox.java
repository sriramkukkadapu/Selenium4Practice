package FrameworkWithoutPageFactoryParallelMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalTestFIrefox {
    
    public static void main(String args[]) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        
        driver.get("https://www.google.co.in");
        Thread.sleep(10000);
        driver.quit();
    }

}
