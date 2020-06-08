package Selenium4;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String args[]) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		
		try {
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("sriramkukkadapu@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("sriramk1");
		
		driver.findElement(RelativeLocator.withTagName("input").below(By.id("input-password"))).click();
		
		driver.get("http://omayo.blogspot.com/");
		WebElement element = driver.findElement(By.xpath("//input[@name='lname']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		WebElement ele=driver.findElement(RelativeLocator.withTagName("button").toLeftOf(By.xpath("//button[text()='Login']")));
		System.out.println("Submit button text: "+ele.getText());
		
		ele=driver.findElement(RelativeLocator.withTagName("button").below(By.xpath("//h2[text()='Buttons with same name attribute values']")).toLeftOf(By.xpath("//button[text()='Login']")));
		System.out.println("Submit button text: "+ele.getText());

		ele=driver.findElement(RelativeLocator.withTagName("button").toRightOf(By.xpath("//button[text()='Submit']")).toLeftOf(By.xpath("//button[text()='Register']")));
		System.out.println("Login button text: "+ele.getText());
		
		//print linkes below a heading
		System.out.println("-------Links-------");
		List<WebElement> links= driver.findElements(RelativeLocator.withTagName("a").
				below(By.xpath("//h2[text()='Buttons with same name attribute values']")) );
		for(WebElement link:links) {
			System.out.println(link.getText());
		}
		
		System.out.println("-------Links above and below-------");
		links= driver.findElements(RelativeLocator.withTagName("a").
				below(By.xpath("//a[text()='compendiumdev']")).
				above(By.xpath("//a[text()='theautomatedtester']")));
		for(WebElement link:links) {
			System.out.println(link.getText());
		}

//     -------amazon-------		
//		driver.get("https://www.amazon.in");
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 7T");
//		driver.findElement(RelativeLocator.withTagName("input").toRightOf(By.id("twotabsearchtextbox"))).click();

		Thread.sleep(2000);
		
		driver.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		driver.close();
		}
	}
}
