package java8_examples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlerStream {
public static void main(String args[]) throws Exception
{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("http://popuptest.com/goodpopups.html");
	
	driver.findElement(By.linkText("Good PopUp #2")).click(); //click the popup link - This opens pop-up
	driver.findElement(By.linkText("Good PopUp #3")).click(); //click the popup link - This opens pop-up
	
	//Now call function to switch to popup window with some title
	
//	switchToWindowTest(driver, "PopupTest Sunday");
	
	//driver.quit();
	
}

//public static String switchToWindowTest(WebDriver driver, String title) throws Exception {
//	return driver.getWindowHandles()
//	.stream()
//		.map(handler -> driver.switchTo().window(handler).getTitle()) //get all titles in a map
//			.filter(ele -> ele.contains(title)) //apply filter on a map
//				.findFirst() //find first with above filter condition
//					.orElseThrow(() -> {throw new RuntimeException("No such handler"); }); //if not found throw exception
//	}
}
