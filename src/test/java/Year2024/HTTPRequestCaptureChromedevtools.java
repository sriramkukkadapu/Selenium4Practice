package Year2024;

import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.network.model.ResponseReceived;
import org.openqa.selenium.devtools.v119.network.Network;

public class HTTPRequestCaptureChromedevtools {
    
    public static void main(String args[]) {
        
        // Reference: https://www.linkedin.com/feed/update/urn:li:activity:7174777730650050560/
        
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        
        devTools.addListener(Network.responseReceived(), response -> {
            ResponseReceived responseReceived = (ResponseReceived) response;
            
            String requestId=responseReceived.getRequestId().toString();
            String url=responseReceived.getResponse().getUrl();
            int status = responseReceived.getResponse().getStatus();
            Map<String,Object> headers = responseReceived.getResponse().getHeaders();
            
            if( (!url.endsWith(".css")) && (!url.endsWith(".png")) && (!url.endsWith(".jpg")) && (!url.endsWith(".min.js"))){
            
                System.out.println("XHR response captured: ");
                System.out.println("Request ID: "+requestId);
                System.out.println("URL: "+url);
                System.out.println("Status: "+status);
                System.out.println("Headers: "+headers);
                System.out.println("===============================");
                
            }
                    
        });
        

        
        driver.get("https://naveenautomationlabs.com/opencart/");
        driver.findElement(By.cssSelector("img[title='MacBook']")).click();
        driver.findElement(By.cssSelector("img[title='naveenopencart']")).click();
    }

}
