package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AzureTest1 {

	@Test
	public void test1() {
		try {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		System.out.println("============> Title is: "+driver.getTitle());
		
		driver.quit();
		}
		catch(Exception e) {
			
		}
	}
}
