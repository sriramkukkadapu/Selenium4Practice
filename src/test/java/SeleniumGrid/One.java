package SeleniumGrid;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class One extends  Base {
	WebDriver driver;
	
@Test
public void testOne() {
	driver.get("https://the-internet.herokuapp.com");
	System.out.println("=====> Title: "+driver.getTitle() + " from chrome");

}

@BeforeMethod
public void setup() throws MalformedURLException {
	driver = initializeBrowser("chrome");
}

@AfterMethod
public void teardown() {
	driver.quit();
}


}
