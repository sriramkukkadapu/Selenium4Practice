package java8_examples;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementWithJava8 {
public static void main(String args[])
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.amazon.in");
	
	List<WebElement> linkslist = driver.findElements(By.tagName("a"));
	System.out.println(linkslist.size());
	
	//filter non empty links
	List<String> nonEmptyLinks=linkslist.stream().filter(ele -> !ele.getText().equals(""))
	.map(ele -> ele.getText())
	.collect(Collectors.toList());
	nonEmptyLinks.forEach(System.out::println);
	
	//find first non empty link
	String firstText = linkslist.stream().filter(ele -> !ele.getText().equals("")).findFirst().get().getText();
	System.out.println("========\nFirst link: "+firstText);
	
	//findAny
	String findAny = linkslist.stream().filter(ele -> !ele.getText().equals("")).findAny().get().getText();
	System.out.println("========\nFind Any: "+findAny);
	
	//exclude blank texts 
	System.out.println("========");
	List<String> amazonLinks = linkslist.stream().filter(ele -> !ele.getText().equals("") && ele.getText().startsWith("Amazon"))
		.map(ele -> ele.getText())
		.collect(Collectors.toList());
	amazonLinks.forEach(System.out::println);
	
	
	
	
	driver.quit();
	
}
}
