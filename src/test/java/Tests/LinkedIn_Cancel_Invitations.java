package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedIn_Cancel_Invitations {
public static void main(String args[]) throws InterruptedException
{
	WebDriverManager.chromedriver().setup();
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
	  driver.findElement(By.id("username")).sendKeys("priyashadec1989@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("sriramk1");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  //driver.get("https://www.linkedin.com/mynetwork/invitation-manager/sent/");
	  driver.get("https://www.linkedin.com/mynetwork/invitation-manager/sent/?invitationType=&page=24");
	  
	  for(int i=1;i<500;i++) {
	 try {
		 cancelInvitations(driver);
	 }
	 catch(Exception e)
	 {
		 System.out.println(e.toString());
		 driver.get("https://www.linkedin.com/mynetwork/invitation-manager/sent/?invitationType=&page=24");
		 System.out.println(driver.getCurrentUrl());
		 if(!driver.getCurrentUrl().equalsIgnoreCase("https://www.linkedin.com/mynetwork/invitation-manager/sent/?invitationType=&page=24"))
			 driver.quit();

	 }
	  }
	  
	  driver.quit();
	  
}

public static void cancelInvitations(WebDriver driver) throws InterruptedException
{
	 
	 
	 driver.findElement(By.xpath("//button[@data-control-name='withdraw_single']")).click();
	  WebDriverWait wait=new WebDriverWait(driver, 5);
	  Thread.sleep(1500);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='alertdialog']//span[@class='artdeco-button__text' and text()='Withdraw']")));
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='alertdialog']//span[@class='artdeco-button__text' and text()='Withdraw']")));
	  driver.findElement(By.xpath("//div[@role='alertdialog']//span[@class='artdeco-button__text' and text()='Withdraw']")).click();
}
}
