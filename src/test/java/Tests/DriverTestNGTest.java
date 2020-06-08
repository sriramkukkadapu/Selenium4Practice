package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericLib.Driver;

public class DriverTestNGTest {
  @Test
  public void f() {
	  
	  Driver driverClassObj=new Driver();
		WebDriver driver=driverClassObj.openBrowser();
		driver.get("https://www.google.com");
		driverClassObj.closeBrowser(driver);
  }
}
