package Year2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Windowhandles {

    public static void main(String args[]) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        
        driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(Keys.chord(Keys.CONTROL, "n"));
        
        
        WebElement dropdownEle = driver.findElement(By.xpath("sample"));
        Select select = new Select(dropdownEle);
        
        
        Thread.sleep(3000);
        driver.close();
    }
}

