package Selenium4;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v94.log.Log;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtensionsFireFoxBrowser {
public static void main(String args[]) throws InterruptedException
{
	
	WebDriverManager.firefoxdriver().setup();
	FirefoxDriver driver=new FirefoxDriver();
	driver.manage().window().maximize();
	Thread.sleep(5000);
	Path path=Paths.get("/Users/thw5795/Downloads/applitools_for_selenium_ide-1.13.5-fx.xpi");
	String extnId = driver.installExtension(path);
	Thread.sleep(5000);
	System.out.println("===========> "+extnId);
	driver.uninstallExtension(extnId);
	Thread.sleep(5000);
	
	driver.quit();
}
}
