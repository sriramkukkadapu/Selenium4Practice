package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Amazon {
public static void main(String args[]) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.amazon.in");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus Mobiles");
	driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']")).click();
	
	
	
	Thread.sleep(3000);
	
	driver.quit();
	
}
}
