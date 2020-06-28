package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Seelnium3_StartBrowser {
public static void main(String args[]) throws InterruptedException {
	
	//System.setProperty("webdriver.chrome.driver", "/Users/sriramku/eclipse-workspace/Selenium4Practice/testdata/chromedriver");
	WebDriver driver=new ChromeDriver();
	//WebDriver driver=new FirefoxDriver();
	driver.get("https://www.google.co.in");
	
	Thread.sleep(3000);
	
	driver.quit();
}
}
