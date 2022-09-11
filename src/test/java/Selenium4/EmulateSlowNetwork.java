package Selenium4;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.devtools.v104.network.model.ConnectionType;
//import org.openqa.selenium.devtools.v96.network.Network;
//import org.openqa.selenium.devtools.v96.network.model.ConnectionType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulateSlowNetwork {

	ChromeDriver driver;
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test(priority=1)
	public void normalNetwork() {
		driver.get("https://www.amazon.in");
	}
	
	@Test(priority=2)
	public void slowNetwork() {

		
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		devTools.send(Network.emulateNetworkConditions(
				false,150, 2500, 2000, 
				Optional.of(ConnectionType.CELLULAR2G)));
		
		driver.get("https://www.amazon.in");
		
		
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
