package Selenium4;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v104.emulation.Emulation;
// import org.openqa.selenium.devtools.v94.emulation.Emulation;
// import org.openqa.selenium.devtools.v103.emulation.Emulation;
// import org.openqa.selenium.devtools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GeoLocation_Example2 {

	public static void main(String args[]) throws FileNotFoundException, IOException, InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		DevTools devTools=driver.getDevTools();
		devTools.createSession();

//		devTools.send(Emulation.setGeolocationOverride(Optional.of(52.5043),
//                Optional.of(13.4501),
//                Optional.of(1)));

		driver.get("https://my-location.org/");
		Thread.sleep(2000);
		driver.close();
		
		
	}
}
