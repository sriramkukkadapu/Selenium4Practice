package Selenium4;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.security.Security;
//
//import com.qeagle.devtools.protocol.types.log.LogEntry;
//import org.openqa.selenium.devtools.v96.security.Security;
import org.openqa.selenium.devtools.v103.security.Security;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InsecureWebsitesLoading {

	public static void main(String args[]) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		try {
		
			DevTools devTools=driver.getDevTools();
			
			devTools.createSession();
			
			devTools.send(Security.enable());
			
			//ignore certificates
			devTools.send(Security.setIgnoreCertificateErrors(true));
			
			driver.get("https://expired.badssl.com/");
			
			Thread.sleep(2000);
			
			driver.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		driver.close();
		}
	}
}
