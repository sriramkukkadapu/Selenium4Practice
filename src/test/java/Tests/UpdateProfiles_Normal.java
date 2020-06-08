package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateProfiles_Normal {
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		
	}
  @Test
  public void f() throws InterruptedException {
	  String data[][]={{"sriramkukkadapu5c0@gmail.com","Sriramk1"},
				{"ramyasha1989@gmail.com","Sriramk1"},
				{"priyashadec1989@gmail.com","Sriramk1"},
				{"sriramkukkadapu@gmail.com","Sriramk1"}
	  };
	  System.setProperty("webdriver.chrome.driver", "testdata/chromedriver");
		WebDriver driver=new ChromeDriver();
		try{
		int i;
		for(i=0;i<data.length;i++)
		{
			//driver.get("https://my.naukri.com/Profile/updateSuccess?id=&altresid=&src=");
			driver.get("https://my.naukri.com/Profile/updateSuccess?id=&altresid=&src=");
			
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			Thread.sleep(10*1000);
			
			String ui=findUiOldOrNew(driver);
			System.out.println("UI Type: "+ui);
			
			System.out.println(data[i][0]+","+data[i][1]);
			
			if(ui.equals("old"))
				old_flow(driver,data[i][0],data[i][1]);
			else
				new_flow(driver,data[i][0],data[i][1]);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='Resume Headline' and @class='widgetTitle']/../span[text()='Edit']")).click();
			Thread.sleep(10*1000);
			driver.findElement(By.xpath("//button[@type='submit' and text()='Save']")).click();
			Thread.sleep(3*1000);
			
			Actions actions=new Actions(driver);
			WebElement ele=driver.findElement(By.xpath("//div[@class='mTxt' and text()='My Naukri']"));
			actions.moveToElement(ele).build().perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			
			Thread.sleep(5000);
		}
		} finally{
		driver.quit();
		}
  }
  
  public void old_flow(WebDriver driver,String username,String password) throws InterruptedException
  {
		
		driver.findElement(By.id("emailTxt")).clear();
		driver.findElement(By.id("emailTxt")).sendKeys(username);
		driver.findElement(By.id("pwd1")).clear();
		driver.findElement(By.id("pwd1")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit' and @name='Login']")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
  }
  
  public void new_flow(WebDriver driver, String username,String password) throws InterruptedException
  {
		
		driver.findElement(By.id("usernameField")).clear();
		driver.findElement(By.id("usernameField")).sendKeys(username);
		driver.findElement(By.id("passwordField")).clear();
		driver.findElement(By.id("passwordField")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit' and text()='Login']")).click();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		Thread.sleep(10*1000);
		
		
		
  }
  
  public String findUiOldOrNew(WebDriver driver)
  {
	  String ui=null;
	  
	  if(driver.findElements(By.id("emailTxt")).size()>0)
		  return "old";
	  else
		  return "new";
			  
  }
}

