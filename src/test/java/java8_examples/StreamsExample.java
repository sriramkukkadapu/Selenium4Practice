package java8_examples;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamsExample {
public static void main(String args[])
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.amazon.in");
	
	List<WebElement> linkslist=driver.findElements(By.tagName("a"));
//========1
//	for(WebElement ele: linkslist)
//	{ 	System.out.println(ele.getText()); }
	
//========2	 : filter non empty links(as text)  using streams
	List<String> nonemptylinks = 
			linkslist.stream().
			filter(ele -> !ele.getText().equals("")).
			map(ele -> ele.getText()).
			collect(Collectors.toList());  // we are collecting elements as strings directly 
	nonemptylinks.forEach(ele ->  System.out.println(ele));
	
//=========3 : filter 1st text which is non empty		
	String firstText = linkslist.stream().filter(ele -> !ele.getText().equals("")).findFirst().get().getText();
	System.out.println("=========\nFirst text: "+firstText);
	
//=========4 : filter any text which is non empty
	String findAny = linkslist.stream().filter(ele -> !ele.getText().equals("")).findAny().get().getText();
	System.out.println("=========\nFindAny: "+findAny);
	
//=========5 : multiple conditions in filter, ex non empty and starts with amazon
	System.out.println("=========\nStreams Multiple conditions in filter ex");
	List<String> amazon_links =  linkslist.stream().
	filter(ele -> !ele.getText().equals("") && ele.getText().startsWith("Amazon")).
	map(ele -> ele.getText()).
	collect(Collectors.toList());
	amazon_links.forEach(link -> System.out.println(link));
	
	//=========6 : multiple filters example
	System.out.println("=========\nMultiple filters example -> trimmed links");
	List<String> trimmedlinks = linkslist.stream().
	filter(ele -> !ele.getText().isEmpty()).
	filter(ele -> !ele.getText().equals(" ")).
	map(ele -> ele.getText().trim()).
	collect(Collectors.toList());
	trimmedlinks.forEach(ele -> System.out.println(ele));
	
	driver.quit();
}
}
