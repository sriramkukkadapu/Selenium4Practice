package java8_examples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksWithStreams {
public static void main(String args[])
{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("http://freshworks.com/");
	
	List<WebElement> footerlist = driver.findElementsByCssSelector("ul.footer-nav li");
	System.out.println(footerlist.size());
	
	List<String> newFooterList = new ArrayList<String>();	
	driver.findElementsByCssSelector("ul.footer-nav li").stream().forEach(ele -> newFooterList.add(ele.getText()));
	newFooterList.forEach(System.out::println);
	
	driver.quit();
	
}
}
