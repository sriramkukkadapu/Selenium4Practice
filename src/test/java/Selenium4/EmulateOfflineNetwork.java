package Selenium4;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v109.network.Network;
//import org.openqa.selenium.devtools.v109.network.model.ConnectionType;
//import org.openqa.selenium.devtools.v109.network.Network;
//import org.openqa.selenium.devtools.v109.network.model.ConnectionType;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.idealized.Network;
//import org.openqa.selenium.devtools.v109.network.model.ConnectionType;
//import org.openqa.selenium.devtools.v96.network.Network;
//import org.openqa.selenium.devtools.v96.network.model.ConnectionType;
//import org.openqa.selenium.devtools.v104.network.Network;
//import org.openqa.selenium.devtools.v104.network.model.ConnectionType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class EmulateOfflineNetwork {

	
	public static void main(String ar[]){
		
//		ChromeDriver driver;
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		
//		System.out.println("Normal Network: ");
//		
//		long startTime = System.currentTimeMillis();
//		driver.get("https://www.amazon.in");
//		long endTime = System.currentTimeMillis();
//		System.out.println(endTime - startTime);
//		
//		DevTools devTools = driver.getDevTools();
//		devTools.createSession();
//		
//		//clearing all existing network settings making empty
//		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty())); 
//		devTools.addListener(Network.loadingFailed(), loadingFailed-> {
//		 System.out.println(loadingFailed.getErrorText());
//		 System.out.println(loadingFailed.getTimestamp());
//		});
//		
//		devTools.send(Network.emulateNetworkConditions(
//				false,1500, 5500, 3000, 
//				Optional.of(ConnectionType.WIFI)));
//		
//
//		System.out.println("============\nSlow Network: ");
//		startTime = System.currentTimeMillis();
//		driver.get("https://www.amazon.in");
//		endTime = System.currentTimeMillis();
//		
//		System.out.println(endTime - startTime);
//		
//		driver.close();
		
	}
}
