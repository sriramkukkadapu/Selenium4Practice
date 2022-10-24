package FrameworkWithoutPageFactoryParallelMethodsGridExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCaseParallelMethods extends TestBaseDriverSafe {

	@Test
	public void test1() throws Exception {
		System.out.println("Test1 Thread Id is: "+Thread.currentThread().getId());
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test1");
		Thread.sleep(2000);
	}

	@Test
	public void test2() throws Exception {
		System.out.println("Test2 Thread Id is: "+Thread.currentThread().getId());
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test2");
		Thread.sleep(2000);
	}

}
