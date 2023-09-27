package Year2023;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DisableImagesInChromeFirefox {

    public static void main(String args[]) throws InterruptedException {
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        disableImagesChrome(options);
        
        
        WebDriver driver = new ChromeDriver(options);                
        driver.get("https://www.amazon.in");
        Thread.sleep(3000);        
        driver.quit();
        
        
        FirefoxOptions foptions = new FirefoxOptions();
        disableImagesFirefox(foptions);
        
        
        driver = new FirefoxDriver(foptions);                
        driver.get("https://www.amazon.in");
        Thread.sleep(3000);        
        driver.quit();
        
    }
    
    public static void disableImagesChrome(ChromeOptions options) {
        HashMap<String,Object> imagesMap = new HashMap<String,Object>();
        imagesMap.put("images",2);
        
        HashMap<String,Object> prefsMap = new HashMap<String,Object>();
        prefsMap.put("profile.default_content_setting_values", imagesMap);
        
        options.setExperimentalOption("prefs", prefsMap);        
    }
    
    
    public static void disableImagesFirefox(FirefoxOptions options) {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.image", 2);
        
        options.setProfile(profile);
    }    
    
}
