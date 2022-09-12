package FrameworkWithoutPageFactory;

import org.testng.annotations.Test;

public class Testcase2 extends TestBase {

	@Test
	public void testGoogle() throws InterruptedException  {
			
		driver.get("https://www.google.co.in");		
		
	}
	
	
	@Test
	public void testAmazon() throws InterruptedException  {
		driver.get("https://www.amazon.in");
	}
	
}
