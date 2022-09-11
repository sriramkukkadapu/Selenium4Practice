package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v94.log.Log;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConsoleLogs {
public static void main(String args[]) throws InterruptedException
{
	/*
	 
	 
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	DevTools devTools = ((ChromeDriver) driver).getDevTools();
	devTools.createSession();
	devTools.send(Log.enable());
	devTools.addListener(Log.entryAdded(), 
			logEntry -> {
				System.out.println("Log: "+logEntry.getText());
				System.out.println("Level: "+logEntry.getLevel());
				
			});
	
	driver.get("https://the-internet.herokuapp.com/broken_images");
	
	driver.close();
	
	*/
}
}
