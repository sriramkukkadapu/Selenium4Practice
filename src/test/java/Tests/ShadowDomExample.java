package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomExample {
public static void main(String args[]) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://books-pwakit.appspot.com/");
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    WebElement booktextbox =  (WebElement) jse.executeScript("return document.querySelector(\"book-app\").shadowRoot.querySelector(\"app-header\").querySelector(\"app-toolbar > book-input-decorator\").querySelector(\"input\")");            
    booktextbox.sendKeys("testing");
      
   Thread.sleep(5000);
   
}
}
