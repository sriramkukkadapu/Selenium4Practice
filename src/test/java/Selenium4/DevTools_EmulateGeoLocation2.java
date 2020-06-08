package Selenium4;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qeagle.devtools.launch.ChromeLauncher;
import com.qeagle.devtools.protocol.commands.DOM;
import com.qeagle.devtools.protocol.commands.Emulation;
import com.qeagle.devtools.protocol.commands.Page;
import com.qeagle.devtools.protocol.commands.Performance;
import com.qeagle.devtools.services.ChromeDevToolsService;
import com.qeagle.devtools.services.ChromeService;
import com.qeagle.devtools.services.types.ChromeTab;
import com.qeagle.devtools.utils.FullScreenshot;

public class DevTools_EmulateGeoLocation2 {
	
	ChromeDevToolsService devToolsService;
	ChromeLauncher launcher;
	Page page;
	
	@BeforeMethod
	public void chromeExtension() throws InterruptedException {
		
		launcher = new ChromeLauncher();
		ChromeService chromeService = launcher.launch(false);
		ChromeTab tab = chromeService.createTab();
		devToolsService = chromeService.createDevToolsService(tab);
		
		page=devToolsService.getPage();
		//page.navigate("http://leafground.com/pages/Edit.html");		
	}
	
	@Test
	public void emulateGeoLocation() throws InterruptedException {
		Emulation emulation = devToolsService.getEmulation();
		emulation.setGeolocationOverride(37.354107,-121.955238,1.00);
		page.navigate("https://oldnavy.gap.com/stores");	
		
		emulation.setGeolocationOverride(37.354107,-121.955238,1.00);
		
		Thread.sleep(5000);
		
		DOM dom=devToolsService.getDOM();
		
		List<Integer> nodes = dom.querySelectorAll(devToolsService.getDOM().getDocument().getNodeId(), "div .address");
		System.out.println("Addresses: "+nodes.size());
		
	}


	
	@AfterMethod
	public void tearDown() {
		launcher.close();
	}
}
