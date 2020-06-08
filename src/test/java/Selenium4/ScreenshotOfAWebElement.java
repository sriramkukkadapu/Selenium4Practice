package Selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOfAWebElement {

	public static void main (String args[]) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in");
		
		WebElement textField = driver.findElement(By.id("twotabsearchtextbox"));
		
		textField.sendKeys("Oneplus 7T");
		
		Thread.sleep(1000);
		
		File srcFile = textField.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File("./screenshots/webelement_screenshot.png"));
		
		driver.quit();
	}
}
