package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowserWithoutDriverExecOrWDM {
public static void main(String args[]) throws InterruptedException
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.co.in");
	Thread.sleep(2000);
	driver.close();
}
}
