package FrameworkWithoutPageFactoryParallelMethodsGridExample;

import org.testng.annotations.Test;

public class Testcase2 extends TestBase {

	@Test(threadPoolSize=4)
	public void testGoogle() throws InterruptedException  {
			
		driver.get("https://www.google.co.in");		
		
	}
	
	
	@Test(threadPoolSize=4)
	public void testAmazon() throws InterruptedException  {
		driver.get("https://www.amazon.in");
	}
	
}
