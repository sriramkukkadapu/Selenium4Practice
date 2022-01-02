//package qaeaglefiles_old_deprecated;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.qeagle.devtools.launch.ChromeLauncher;
//import com.qeagle.devtools.services.ChromeDevToolsService;
//import com.qeagle.devtools.services.ChromeService;
//import com.qeagle.devtools.services.types.ChromeTab;
//import com.qeagle.devtools.utils.FullScreenshot;
//
//public class DevTools_Launch {
//
//	
//	@Test
//	public void chromeExtension() throws InterruptedException {
//		
//		ChromeLauncher launcher = new ChromeLauncher();
//		ChromeService chromeService = launcher.launch(false);
//		ChromeTab tab = chromeService.createTab();
//		ChromeDevToolsService devToolsService = chromeService.createDevToolsService(tab);
//		//ChromeDevToolsService devToolsService = chromeService.createDevToolsService(chromeService.getTabs().get(0));
//		//ChromeDevToolsService devToolsService = chromeService.createDevToolsService();
//		
//		devToolsService.getPage().navigate("https://www.google.in");
//		
//		Thread.sleep(2000);
//		
//		// Take full screen (Integrated with Selenium using Remote Debugger Address
//				FullScreenshot.captureFullPageScreenshot(devToolsService, "screenshot.png");
//				
//		launcher.close();
//		
//	}
//	
//
//}
