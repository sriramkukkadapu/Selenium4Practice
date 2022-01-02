package qaeaglefiles_old_deprecated;
//package Selenium4;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.Log;
//
//import com.qeagle.devtools.protocol.types.log.LogEntry;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class ChromeConsoleLogs {
//
//	public static void main(String args[]) throws IOException, InterruptedException {
//		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
//		
//		try {
//		
//			DevTools devTools=((ChromeDriver )driver).getDevTools();
//			
//			devTools.createSession();
//			
//			devTools.send(Log.enable());
//			
//			devTools.addListener(Log.entryAdded(), entry -> System.out.println(entry.asSeleniumLogEntry()));
//		
//			driver.get("https://www.amazon.in");
//			
//			driver.close();
//		}
//		catch(Exception e) {
//			System.out.println(e.toString());
//		driver.close();
//		}
//	}
//}
