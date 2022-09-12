package FrameworkWithoutPageFactory;

import org.testng.annotations.Test;

public class Testcase2continued extends TestBase {

	@Test
	public void testFacebook() throws InterruptedException  {
			
		driver.get("https://www.facebook.com");		
		
	}
	
	
	@Test
	public void testLinkedin() throws InterruptedException  {
		driver.get("https://www.linkedin.com");
	}
	
}
