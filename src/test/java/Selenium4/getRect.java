package Selenium4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getRect {

	public static void main(String args[]) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

//		System.out.println("New setup");
//		//WebDriverManager.chromedriver().setup();
//		//WebDriverManager.chromedriver().browserVersion("96.0").arch64().setup();
//		DriverSetup ds=new DriverSetup();
//		WebDriver driver=ds.setup();
		driver.get("http://omayo.blogspot.com/");
		
		//selenium 3
		// Dimension d= ele.getSize();
		// d.getHeight(); d.getWidth();
		// Point p=ele.getLocation();
		// p.getX(); p.getY();
		
		/*----------Selenium 3-----------*/
		WebElement ele=driver.findElement(By.xpath("//h3[@class='post-title entry-title']"));
//		Dimension d=ele.getSize();
//		System.out.println(d.getHeight()+" "+d.getWidth());
//		Point p=ele.getLocation();
//		System.out.println(p.getX()+" "+p.getY());
		
		/*----------Selenium 4-----------*/
		System.out.println("---------Selenium 4---------");
		Rectangle r=ele.getRect();
		System.out.println(r.getHeight()+" "+r.getWidth()+" "+r.getX()+" "+r.getY());
		
		driver.close();
		
		
	}
}
