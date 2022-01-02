package Selenium4;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.network.Network;
import org.openqa.selenium.devtools.v96.network.model.ConnectionType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulateOfflineNetwork {

	
	public static void main(String ar[]){
		ChromeDriver driver;
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Network.emulateNetworkConditions(
				true,150, 2500, 2000, 
				Optional.of(ConnectionType.WIFI)));
		
		
		driver.get("https://www.amazon.in");
		
		driver.close();
	}
}
