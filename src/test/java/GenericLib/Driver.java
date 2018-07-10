package GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public WebDriver driver;
	
	public WebDriver openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "testdata/chromedriver");
		driver=new ChromeDriver();
		return driver;
	}
	
	public void closeBrowser(WebDriver driver)
	{
		driver.close();
		driver.quit();
	}
}
