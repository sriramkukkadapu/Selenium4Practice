package Year2026;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {
    public static void main(String args[]) {
        
                
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        String parent_window = driver.getWindowHandle();
        
        System.out.println("Parent window: "+ driver.getTitle());
        
        driver.findElement(By.cssSelector("#a-link-that-opens-a-new-window")).click();
        
        Object[] windowHandles = (Object[]) driver.getWindowHandles().toArray();
        
        String child_window = windowHandles[1].toString();
        
        driver.switchTo().window(child_window);
        
        System.out.println("Child window: "+ driver.getTitle());
        
        driver.switchTo().window(parent_window);
        
        System.out.println("Parent window: "+ driver.getTitle());
        
        driver.quit();
        
    }

}
