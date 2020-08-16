package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverEventing_Example {
public static void main(String args[]) {
	
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	
	EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
	WebEventListener eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 8T");
	
	driver.quit();
	
}
}
