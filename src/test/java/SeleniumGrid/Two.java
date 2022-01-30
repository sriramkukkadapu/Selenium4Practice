package SeleniumGrid;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Two extends  Base {
	WebDriver driver;
	
@Test
public void testTwo() {
	driver.get("https://the-internet.herokuapp.com");
	System.out.println("=====> Title: "+driver.getTitle() + " from firefox");

}

@BeforeMethod
public void setup() throws MalformedURLException {
	driver = initializeBrowser("firefox");
}

@AfterMethod
public void teardown() {
	driver.quit();
}


}
