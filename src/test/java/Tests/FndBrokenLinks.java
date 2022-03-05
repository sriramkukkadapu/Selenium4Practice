package Tests;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FndBrokenLinks {
public static void main(String args[]) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.zlti.com");
	List<WebElement> links = driver.findElements(By.tagName("a"));
	System.out.println("Total links: "+links.size());
	
	for(WebElement e:links) {
		String url=e.getAttribute("href");  
		System.out.println("Checking link: "+url);
		if(url == null || url.isEmpty()){
			//System.out.println("URL is either not configured for anchor tag or it is empty");
			continue;
			}
		
		try {
			HttpURLConnection huc = ((HttpURLConnection) new URL(url).openConnection());
			huc.setRequestMethod("HEAD");
			huc.connect();
			if(huc.getResponseCode() > 400) {
				System.out.println("Invalid link: "+ url);
			}
			else
				continue;
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		
	}
	
	
	
	driver.quit();

}
}
