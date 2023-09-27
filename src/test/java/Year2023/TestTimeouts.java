package Year2023;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestTimeouts {

    public static void main(String args[]) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        
        //1. implicit wait 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
        driver.findElement(By.id("#sriramkukkadaou"));
        driver.findElement(By.id("#sriramkukkadapu"));
        }
        catch(Exception e) {
            System.out.println("Exception: "+e);
        }
        
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium dev");
        
        Thread.sleep(3000);
        
        //Explicit wait
        driver.get("https://www.google.com");
        
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search']")));
        
        
        //Fluent wait
        FluentWait fwait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(5));
        wait.ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.alertIsPresent());
        
        
        driver.close();
    }
}
