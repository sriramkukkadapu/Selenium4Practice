package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_WithAsserts {
public static void main(String args[]) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	try {
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		String title=driver.getTitle();
		String expTitle="1Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		//Verify browser title
		Assert.assertEquals(title, expTitle,"Title mismatch - Test failed");	
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus Mobiles");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']")).click();
		Thread.sleep(2000);
		
		//Select one plus brand form the list
		driver.findElement(By.xpath("//span[@class='a-list-item']/a/span[text()='OnePlus']")).click();
		Thread.sleep(5000);
		
		System.out.println(driver.findElement
		(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'][1]")).getText());
				
		//To see if the search result has text oneplus
		Assert.assertEquals(true,driver.findElement
				(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'][1]")).
				getText().toLowerCase().contains("oneplus"));
		
		
//		Thread.sleep(5000);
		
		driver.quit();
	}
	catch(Exception e)
	{
		System.out.println(e.toString());
		driver.quit();
	}
}
}




































////clicking option for 128 gb
//driver.findElement(By.xpath("//li[@aria-label='128 GB']")).click();
//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'][1]")));
//
//Thread.sleep(10000);		
