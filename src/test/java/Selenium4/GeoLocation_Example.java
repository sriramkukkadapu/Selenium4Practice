package Selenium4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation_Example {

	public static void main(String args[]) throws FileNotFoundException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		Map<String,Object> coordinatesMap = new HashMap<String,Object>();
		
		coordinatesMap.put("latitude", 34.0522);
		coordinatesMap.put("longitude", -118.2437);
		coordinatesMap.put("accuracy", 100);
		
		((ChromeDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinatesMap);
		
		driver.get("https://oldnavy.gap.com/stores");
		
		Map<String,Object> screenshotParameters = new HashMap<String,Object>();
		screenshotParameters.put("format", ".png");
		
		driver.get("https://www.google.com");
		Map<String,Object> resultMap=driver.executeCdpCommand("Page.captureScreenshot", screenshotParameters);
		System.out.println(resultMap.get("data").toString());
		byte[] data = Base64.decodeBase64(resultMap.get("data").toString());
		try (OutputStream stream = new FileOutputStream(System.getProperty("user.dir")+"/fullpage.png")) {
		    stream.write(data);
		}
		
		
	}
}
