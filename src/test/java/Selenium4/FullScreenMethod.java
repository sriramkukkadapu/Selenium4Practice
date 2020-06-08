package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullScreenMethod {
public static void main(String args[]) throws InterruptedException
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.co.in");
	driver.manage().window().fullscreen();
	Thread.sleep(2000);
	driver.close();
}
}
