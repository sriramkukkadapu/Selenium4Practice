package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v94.log.Log;

public class FullScreenMethod {
public static void main(String args[]) throws InterruptedException
{
	
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/broken_images");
	driver.manage().window().fullscreen();	
	driver.close();
}
}
