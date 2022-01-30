package SeleniumGrid;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Four extends  Base {
	WebDriver driver;
	
@Test
public void testFour() {
	driver.get("https://the-internet.herokuapp.com");
	System.out.println("=====> Title: "+driver.getTitle() + " from opera");

}

@BeforeMethod
public void setup() throws MalformedURLException {
	driver = initializeBrowser("opera");
}

@AfterMethod
public void teardown() {
	driver.quit();
}


}
