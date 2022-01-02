package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

	public WebDriver setup() {
	System.out.print("Driver");
	System.setProperty("webdriver.chrome.driver", "/Users/thw5795/projects/Selenium4Practice/chromedriver 2");
	ChromeDriver driver=new ChromeDriver();
//	driver.get("https://www.google.co.in");
	return driver;
	}
	
//	public static void main(String ar[]) {
//	System.out.print("Driver");
//	System.setProperty("webdriver.chrome.driver", "/Users/thw5795/projects/Selenium4Practice/chromedriver 2");
//	ChromeDriver driver=new ChromeDriver();
//	driver.get("https://www.google.co.in");
//	
//	//driver.quit();
//}
}
