package GoogleWorkspace;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameworkWithoutPageFactory.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String args[]) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		driver.get("https://admin.google.com/");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		Helper helper = new Helper();
		helper.setupWait(driver);
		
		helper.setValue(By.xpath("//input[@type='email']"), "info@jobcurator.in");
		
		helper.click(By.xpath("//span[text()='Next']"));
		
		helper.setValue(By.xpath("//input[@type='password']"), "Sriramk1");
		
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sriramk1");
//		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		helper.click(By.xpath("//span[text()='Next']"));
		
		Thread.sleep(3000);
		
		driver.get("https://groups.google.com/a/jobcurator.in/g/testingexpopeningssubscribed/members");
		
		helper.setValue(By.xpath("//input[@aria-label='Search members']"), "sriram.kukkadapu@gmail.com");
		
		helper.hitEnter(By.xpath("//input[@aria-label='Search members']"));
		
		//helper.click(By.xpath("//div[@aria-selected='false']//div[@role=\"columnheader']//div[@Role='checkbox']"));
//		helper.click(By.xpath("//div[@title='Select all']//div[@class='uHMk6b fsHoPb']"));
//		helper.click(By.xpath("//div[@title='Select all']"));
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
		
//		js.executeScript("document.querySelectorAll(\"div[title='Select all']\")[0].click();");
		
		driver.findElement(By.xpath("//div[@aria-label=\"Favourite group\"]")).click();
		driver.findElement(By.xpath("//div[@aria-label=\"Favourite group\"]")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//div[@aria-label=\"Favourite group\"]")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//div[@aria-label=\"Favourite group\"]")).sendKeys(Keys.TAB);
		
		WebElement selectAllBox = driver.switchTo().activeElement();
		
		selectAllBox.click();
		
		helper.waitForElementDisplayed(By.xpath("//div[text()='1 selected']"));
		
		//check if "1-Selected" message present
		
//		if(driver.findElements(By.xpath("//div[text()=\"1 selected\"]")).size()==0)
//			throw new Exception("Issue ");
//		
		
		Thread.sleep(10000);
		
		driver.quit();
	}
}
