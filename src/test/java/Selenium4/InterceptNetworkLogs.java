package Selenium4;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
//import org.openqa.selenium.devtools.v94.log.Log;
//import org.openqa.selenium.devtools.v94.network.Network;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterceptNetworkLogs {
public static void main(String args[]) throws InterruptedException
{
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	//driver.manage().window().maximize();
	DevTools devTools = driver.getDevTools();
	devTools.createSession();
	
	devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	devTools.addListener(Network.requestWillBeSent(), request -> {
		System.out.println("Request URL: "+request.getRequest().getUrl());
		System.out.println("Request URL: "+request.getRequest().getMethod());
	});
	
	driver.get("http://the-internet.herokuapp.com/broken_images");
	
	driver.quit();
	
}
}
