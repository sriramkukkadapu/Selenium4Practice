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
		
		driver.get("https://developers.google.com/admin-sdk/directory/reference/rest/v1/members/delete");
		
		WebElement frameEle = driver.findElement(By.xpath("//iframe[contains(@src,'methodId=directory.members.delete')]"));
	
		driver.switchTo().frame(frameEle);
		
		File file = new File("DeleteMembersFromGroup.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		  
		String email;
		while((email=br.readLine())!=null) {		
		
		helper.setValue(By.id("groupKey"),"testingexpopeningssubscribed@jobcurator.in");
		
		helper.setValue(By.id("memberKey"),email);
		
		helper.click(By.id("execute"));
		
		Thread.sleep(5000);
		
		}
//		
		
		Thread.sleep(10000);
		
		driver.quit();
	}
}
