package Year2024;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.bidi.LogInspector;
import org.openqa.selenium.bidi.log.JavascriptLogEntry;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConsoleLogCapture {
    
    public static void main(String args[]) {
        
        WebDriver driver = new ChromeDriver();
        
        driver.get("");

//            try (LogInspector logInspector = new LogInspector(driver)) {
//                CompletableFuture<JavascriptLogEntry> future = new CompletableFuture<>();
//                logInspector.onJavaScriptLog(future::complete);
//
////                driver.get("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html");
//                driver.get("https://www.selenium.dev/selenium/web/bidi/logEntryAdded.html");
//                driver.findElement(By.id("jsException")).click();


                
                
                

                
                
            
//        }
    }

}



//                JavascriptLogEntry logEntry = future.get(5, TimeUnit.SECONDS);

//Assert.assertEquals("Error: Not working", logEntry.getText());
//Assertions.assertEquals("javascript", logEntry.getType());
//Assertions.assertEquals(LogLevel.ERROR, logEntry.getLevel());