package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import GenericLib.Driver;

public class Indigo {

	public static void main(String args[]) throws InterruptedException
	{
		Driver driverClassObj=new Driver();
		WebDriver driver=driverClassObj.openBrowser();
		
		
		driver.get("https://www.goindigo.in/");
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-acc-cookie']")).click();
		//driver.findElement(By.xpath("//input[@name='or-src']")).sendKeys("Bengaluru (BLR)");
		//driver.findElement(By.xpath("//input[@name='or-dest']")).sendKeys("Mumbai (BOM)");
		driver.findElement(By.xpath("//input[@name='passenger']")).click();
		driver.findElement(By.xpath("//div[@class='passenger-dropdown pax-selection-row']/ul[@class='passengers-list clearfix list-unstyled']//li[@class='adult-pax-list']//button[@class='pax-plus btn btn-info' and @title='Up']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-primary pax-done btn-pad-y']")).click();
		
		Thread.sleep(3000);
		
		driverClassObj.closeBrowser(driver);
	}
}
