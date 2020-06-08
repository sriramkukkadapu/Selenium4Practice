package Selenium4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getRect {

	public static void main(String args[]) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
		
		//selenium 3
		// Dimension d= ele.getSize();
		// d.getHeight(); d.getWidth();
		// Point p=ele.getLocation();
		// p.getX(); p.getY();
		
		/*----------Selenium 3-----------*/
		WebElement ele=driver.findElement(By.xpath("//h3[@class='post-title entry-title']"));
		Dimension d=ele.getSize();
		System.out.println(d.getHeight()+" "+d.getWidth());
		Point p=ele.getLocation();
		System.out.println(p.getX()+" "+p.getY());
		
		/*----------Selenium 4-----------*/
		System.out.println("---------Selenium 4---------");
		Rectangle r=ele.getRect();
		System.out.println(r.getHeight()+" "+r.getWidth()+" "+r.getX()+" "+r.getY());
		
		driver.close();
		
		
	}
}
