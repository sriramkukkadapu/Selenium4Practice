package Year2024;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class HighlightElementInSelenium { 
    
    public static void main(String args[]) throws InterruptedException, IOException {
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.google.com");
        WebElement ele = driver.findElement(By.xpath("//textarea[@name='q']"));
        JavascriptExecutor js = (JavascriptExecutor) driver; 
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);

    
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("screenshots/highlight_field.png"));
    
    driver.quit();
    
    }

}

