package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerCheck {

	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver  driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		driver.close();
	}
}
