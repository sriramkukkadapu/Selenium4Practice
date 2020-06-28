package java8_examples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxWithStream {
public static void main(String args[])
{
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//driver.get("https://datatables.net/extensions/fixedcolumns/examples/integration/select-checkbox.html");
	driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
	
	List<WebElement> checkboxes=driver.findElements(By.cssSelector("td.select-checkbox"));
	checkboxes.stream().forEach(ele -> ele.click());
	//checkboxes.forEach(ele -> ele.click());
	
	driver.quit();
	
}
}
