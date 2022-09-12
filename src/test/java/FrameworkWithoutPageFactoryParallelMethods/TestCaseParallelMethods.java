package FrameworkWithoutPageFactoryParallelMethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestCaseParallelMethods extends TestBaseDriverSafe {

	@Test
	public void test() throws Exception {
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test1");
		Thread.sleep(2000);
	}

	@Test
	public void test1() throws Exception {
		getDriver().get("https://www.google.com/?hl=en");
		getDriver().findElement(By.name("q")).sendKeys("test2");
		Thread.sleep(2000);
	}

}
