package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//SingleTon class for driver initialization
public class DriverInit {
	public static DriverInit driverObj=null;
	private WebDriver driver=null;
	
	private DriverInit()
	{ }
	
	public static DriverInit getInstance()
	{
		if(driverObj==null)
		{
			driverObj= new DriverInit();
			return driverObj;
		}
		else
			return driverObj;
	}
	
	public WebDriver openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/sriramku/eclipse-workspace/SeleniumPractice/testdata/chromedriver");
		driver=new ChromeDriver();
		return driver;
	}
	
}
