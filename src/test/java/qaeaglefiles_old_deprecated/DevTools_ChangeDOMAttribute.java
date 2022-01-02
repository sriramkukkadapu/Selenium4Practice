//package qaeaglefiles_old_deprecated;
//
//import java.util.List;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.qeagle.devtools.launch.ChromeLauncher;
//import com.qeagle.devtools.protocol.commands.DOM;
//import com.qeagle.devtools.protocol.commands.Page;
//import com.qeagle.devtools.protocol.commands.Performance;
//import com.qeagle.devtools.services.ChromeDevToolsService;
//import com.qeagle.devtools.services.ChromeService;
//import com.qeagle.devtools.services.types.ChromeTab;
//import com.qeagle.devtools.utils.FullScreenshot;
//
//public class DevTools_ChangeDOMAttribute {
//	
//	ChromeDevToolsService devToolsService;
//	ChromeLauncher launcher;
//	
//	@BeforeMethod
//	public void chromeExtension() throws InterruptedException {
//		
//		launcher = new ChromeLauncher();
//		ChromeService chromeService = launcher.launch(false);
//		ChromeTab tab = chromeService.createTab();
//		devToolsService = chromeService.createDevToolsService(tab);
//		
//		Page page=devToolsService.getPage();
//		page.navigate("http://leafground.com/pages/Edit.html");		
//	}
//	
//	@Test
//	public void changeDOM() throws InterruptedException {
//		DOM dom=devToolsService.getDOM();
//		
//		//gets 1st input tag in dom
//		Integer nodeId = dom.querySelector(devToolsService.getDOM().getDocument().getNodeId(), "input");
//		System.out.println(nodeId);
//		
//		//Thread.sleep(3000);
//		dom.setAttributeValue(nodeId, "value", "Sriram");
//		
//		Thread.sleep(3000);
//		
//		//get all input boxes
//		List<Integer> nodes = dom.querySelectorAll(devToolsService.getDOM().getDocument().getNodeId(), "input");
//		
//		dom.setAttributeValue(nodes.get(nodes.size()-2), "value", "");
//		
//		//get all attributes
//		List<String> attributes = dom.getAttributes(nodes.get(2));
//		
//		for(String attr:attributes) {
//			System.out.println(attr);
//		}		
//	}
//
//
//	
//	@AfterMethod
//	public void tearDown() {
//		launcher.close();
//	}
//}
