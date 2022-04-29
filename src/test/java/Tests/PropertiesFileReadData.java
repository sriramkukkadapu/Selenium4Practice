package Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertiesFileReadData {
public static void main(String args[]) throws IOException {
	
	FileInputStream fis = new FileInputStream("config.properties");
	Properties p=new Properties();
	p.load(fis);
	String url = p.get("url").toString();
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.get(url);
	driver.quit();
	
}
}
