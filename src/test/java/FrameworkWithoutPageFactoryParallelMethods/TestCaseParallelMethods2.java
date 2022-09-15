package FrameworkWithoutPageFactoryParallelMethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCaseParallelMethods2 extends TestBaseDriverSafe {

	@Test
	public void test3() throws Exception {
		System.out.println("Test3 Thread Id is: "+Thread.currentThread().getId());
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test3");
		Thread.sleep(2000);
	}

	@Test
	public void test4() throws Exception {
		System.out.println("Test4 Thread Id is: "+Thread.currentThread().getId());
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test4");
		Thread.sleep(2000);
	}

}
