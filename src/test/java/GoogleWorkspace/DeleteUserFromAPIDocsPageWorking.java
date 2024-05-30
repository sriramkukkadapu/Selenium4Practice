package GoogleWorkspace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class DeleteUserFromAPIDocsPageWorking {

	public static void main(String args[]) throws Exception {
		
//		WebDriverManager.chromedriver().setup();
		
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
		
		helper.setValue(By.xpath("//input[@type='password']"), "Sr!r@mk1");
		
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sriramk1");
//		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		helper.click(By.xpath("//span[text()='Next']"));
		
		Thread.sleep(3000);
		
		driver.get("https://developers.google.com/admin-sdk/directory/reference/rest/v1/members/delete");
		
		WebElement frameEle = driver.findElement(By.xpath("//iframe[contains(@src,'methodId=directory.members.delete')]"));
	
		
		driver.switchTo().frame(frameEle);
		
		File file = new File("DeleteMembersFromGroup.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		
		int count=1;
		String email;
		while((email=br.readLine())!=null) {	
		    System.out.println("Deleting id: ["+count + "] - " + email);
		
		helper.setValue(By.id("groupKey"),"testingexpopeningssubscribed1@jobcurator.in");
		helper.setValue(By.id("memberKey"),email);
		helper.click(By.id("execute"));
		
//		Thread.sleep(5000);
		
		
//        Object[] windows =  driver.getWindowHandles().toArray();
//
//        String mainWindowHandle = windows[0].toString();        
//        String loginWindowHandle = windows[1].toString();
//        
//        System.out.println(driver.getTitle());
//        driver.switchTo().window(loginWindowHandle);
//        System.out.println(driver.getTitle());
		
//        System.exit(0);
        
        
		Thread.sleep(300);
		
		helper.setValue(By.id("groupKey"),"testingexpopeningssubscribed2@jobcurator.in");
		helper.setValue(By.id("memberKey"),email);
		helper.click(By.id("execute"));
	   
		Thread.sleep(300);
	        
		helper.setValue(By.id("groupKey"),"testingexpopeningssubscribed3@jobcurator.in");
		helper.setValue(By.id("memberKey"),email);
		helper.click(By.id("execute"));
		
		Thread.sleep(300);
		
		count++;
		
		}
//		
		System.out.println("Completed");
		
//		Thread.sleep(10000);
		
		driver.quit();
	}
}
