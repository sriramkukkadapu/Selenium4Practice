package Selenium4;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qeagle.devtools.webdriver.DevToolsService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qeagle.devtools.protocol.commands.Performance;
import com.qeagle.devtools.protocol.types.performance.Metric;
import com.qeagle.devtools.services.ChromeDevToolsService;

public class DevTools_AttachDriver_CheckPerformance {
	WebDriver driver;
	ChromeDevToolsService devToolsService;
	
	@BeforeMethod
	public void launch() {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/testdata/chromedriver");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		
		driver=new ChromeDriver();
		
		devToolsService = DevToolsService.getDevToolsService(driver);
		
	}
	
	@Test
	public void getPerformanceMetrics() {
		
		Performance perf= devToolsService.getPerformance();
		perf.enable();
		
		driver.get("https://www.google.com");
		
		System.out.println(devToolsService);
		

		
		List<Metric> metrics = perf.getMetrics();
		
		for(Metric metric:metrics) {
			System.out.println(metric.getName()+"="+metric.getValue());
		}
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	

}
