package Tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericLib.Driver;

public class Sample {

	public static void main(String args[]) throws InterruptedException
	{
		Driver driverClassObj=new Driver();
		WebDriver driver=driverClassObj.openBrowser();
		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		Actions actions=new Actions(driver);
		
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("sriramkukkadapuofficial@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("sriramk1");
		driver.findElement(By.id("pass")).sendKeys(Keys.RETURN);
		
		//driver.findElement(By.id("u_0_b")).click();
		//Thread.sleep(6000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-gt='{\"chrome_nav_item\":\"home_chrome\"}']")));
		driver.get("https://www.facebook.com/groups/Aashu.BJS/permalink/2541350245906618/");
		Thread.sleep(3000);
		
		//actions.moveToElement(driver.findElement(By.xpath("//span[text()='View previous comments']")));
		//driver.findElement(By.xpath("//div[@data-testid='UFI2CommentsList/root_depth_0']")).click();
		actions.moveToElement(driver.findElement(By.xpath("//div[@data-testid='UFI2CommentsList/root_depth_0']")));
		driver.findElement(By.xpath("//span[text()='50 of 378']")).click();
		//driver.findElement(arg0)
		Thread.sleep(1000);
		for(int i=1;i<=7;i++) {			
			//driver.findElement(By.xpath("//span[text()='View previous comments']")).click();
			driver.findElement(By.xpath("//a[@data-testid='UFI2CommentsPagerRenderer/pager_depth_0']")).click();
			Thread.sleep(3000);
		}
		
		// $x("//div[@data-testid='UFI2CommentsList/root_depth_0']/ul/li//a[text()='See more']")[0].click();
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		
//		for(int i=0;i<=256;i++)
//		{
//			driver.findElement(By.xpath("//div[@data-testid='UFI2CommentsList/root_depth_0']/ul/li["+i+"]//div[@data-testid='UFI2Comment/body']//a[text()='See more']")).click();
//		}
//		List seeMoreList=driver.findElements(By.xpath("//div[@data-testid='UFI2CommentsList/root_depth_0']/ul/li//div[@data-testid='UFI2Comment/body']//a[text()='See more']"));
//		System.out.println("Length(See more): "+seeMoreList.size());
//				//driver.findElements(By.xpath("//a[text()='See more']"));
//		Iterator itr=seeMoreList.iterator();
//		while(itr.hasNext())
//		{
//			WebElement ele=(WebElement)itr.next();
//			actions.moveToElement(ele);
//			ele.click();	
//		}		
//		Thread.sleep(20000);
		Thread.sleep(5000);
		driverClassObj.closeBrowser(driver);
	}
}
