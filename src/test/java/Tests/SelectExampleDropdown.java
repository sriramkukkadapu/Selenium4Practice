package Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectExampleDropdown {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://courses.letskodeit.com/practice");
		Select dropDown = new Select(driver.findElement(By.cssSelector("#carselect")));
		List<WebElement> options = dropDown.getOptions();
		for(WebElement e:options) {
			System.out.println(e.getText());
		}
		//driver.findElement(By.cssSelector("#carselect")).click();
		dropDown.selectByIndex(1);
		Thread.sleep(2000);
		driver.quit();
	}
}
