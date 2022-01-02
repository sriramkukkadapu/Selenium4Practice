package Selenium4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOfASection {

	public static void main(String args[]) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("http://omayo.blogspot.com/");
		
		WebElement ele=driver.findElement(By.id("LinkList1"));
		
		File srcFile=ele.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, new File("./screenshots/section.png"));
		
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
		
		ele=driver.findElement(By.cssSelector("form[action$='login']"));
		
		srcFile=ele.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile,new File("./screenshots/section2.png"));
		
		driver.close();
		
		
	}
}
