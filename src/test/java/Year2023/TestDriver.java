package Year2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestDriver {

    public static void main(String args[]) {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        
        driver.close();
    }
}
