package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentFrame {
public static void main(String args[]) throws InterruptedException
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.co.in");
	//selenium 3 you cannot switch to parent frame directly you need to switch to defaultConent and then switch to parent frame
	// https://www.qhmit.com/html/tags/html_iframe_tag.cfm
	
	Thread.sleep(2000);
	driver.close();
}
}
