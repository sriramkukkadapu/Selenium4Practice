package Accessibility_AXECore;

import java.io.IOException;

import javax.naming.OperationNotSupportedException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.deque.html.axecore.extensions.WebDriverExtensions;
import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.selenium.AxeBuilder;


// https://www.linkedin.com/pulse/automated-tests-accessibility-axe-core-selenium-java-yesica-acha/?trk=public_profile_article_view
// https://www.youtube.com/watch?v=jz2DO2cLbj4

public class ChromeTestAccessibility {
    
    public static void main(String args[]) throws OperationNotSupportedException, IOException {
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.google.co.in");
        
//        Results results = WebDriverExtensions.analyze(driver);
        
        Results results = new AxeBuilder().analyze(driver);
        
        
        System.out.println(results.toString());
        
        
        driver.quit();
        

    }

}
