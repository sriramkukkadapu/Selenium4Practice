package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
public static void main(String args[]) {
	WebDriverManager.chromedriver().setup();
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

// -------------- Implicit Wait --------------	
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

//---------------Explicit Wait---------------
//	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
//	driver.findElement(By.xpath("//button[@id='display-other-button']")).click();
//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='hidden']")));
//	driver.findElement(By.xpath("//button[@id='hidden']")).click();

//--------------Fluent Wait--------------
	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
	wait.withTimeout( Duration.ofSeconds(20));
	wait.pollingEvery(Duration.ofSeconds(5));
	wait.ignoring(NoSuchElementException.class);	
	
	driver.findElement(By.xpath("//button[@id='display-other-button']")).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='hidden']")));
	driver.findElement(By.xpath("//button[@id='hidden']")).click();
	
	
	driver.quit();
}
}
