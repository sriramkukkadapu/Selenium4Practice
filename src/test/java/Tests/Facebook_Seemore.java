package Tests;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericLib.Driver;

public class Facebook_Seemore {

	public static void main(String args[]) throws InterruptedException
	{
		Driver driverClassObj=new Driver();
		WebDriver driver=driverClassObj.openBrowser();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		try {
		WebDriverWait wait=new WebDriverWait(driver,20);
		driverClassObj.closeBrowser(driver);
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("sriramkukkadapuofficial@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("sriramk1");
		driver.findElement(By.id("u_0_b")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("creation_hub_entrypoint")));
		driver.get("https://www.facebook.com/groups/Aashu.BJS/permalink/2541350245906618/");
		for(int i=1;i<=7;i++)			
		driver.findElement(By.xpath("//span[text()='View previous comments']")).click();
		List seeMoreList=driver.findElements(By.xpath("//a[text()='See more']"));
		Iterator itr=seeMoreList.iterator();
		while(itr.hasNext())
		{
			WebElement ele=(WebElement)itr.next();
			ele.click();	
		}		
		Thread.sleep(20000);
		//https://www.facebook.com/groups/shashikantsingh.MRA/permalink/1571021846285535/
		}
		catch(Exception e)
		{
			driver.quit();
		}
	}
}
