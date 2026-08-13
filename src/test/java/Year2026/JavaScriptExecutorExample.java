package Year2026;

import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorExample {
    public static void main(String args[]) throws InterruptedException {
        
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in");
        String parent_window = driver.getWindowHandle();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.alert('javascript executor example')");
        
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
        driver.quit();
        
    }

}
