package FrameworkWithoutPageFactory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	WebDriver driver=null;
	WebDriverWait wait=null;

	@SuppressWarnings("finally")
	public WebDriverWait setupWait(WebDriver driver)  {
		
		this.driver = driver;
		
		try {
		
		 wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		}

		finally {
		return wait;
		}
		
	}
	
	
	public void waitForElementDisplayed(By by) {
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitForElementToBeClickable(By by) {
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	public void setValue(By by, String text) {
		waitForElementDisplayed(by);
		waitForElementToBeClickable(by);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(text);
	}
	
	public void click(By by) {
		waitForElementDisplayed(by);
		waitForElementToBeClickable(by);
		driver.findElement(by).click();
	}
	
	public boolean isDisplayed(By by) {
		boolean result = false; 
	
		try {
			result = driver.findElement(by).isDisplayed();
		}
		
		catch(NoSuchElementException nse) {
			result = false;
		}
		
		return result;
	}
	
	public void hitEnter(By by) {
		waitForElementDisplayed(by);
		waitForElementToBeClickable(by);
		driver.findElement(by).sendKeys(Keys.RETURN);
	}
	
	   public void clear(By by) {
	        waitForElementDisplayed(by);
	        waitForElementToBeClickable(by);
	        driver.findElement(by).clear();
	    }
	
	
}
