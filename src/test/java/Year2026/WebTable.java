package Year2026;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
    public static void main(String args[]) {
        
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
        
        int rows = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr")).size();
        int cols = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr[1]/td")).size();
        
        for(int i=1;i<=rows;i++) {
            String row_wise_data="";
            for(int j=1; j<cols; j++) {
                String xpath = "//table[@class='table table-striped mt-3']/tbody/tr["+i+"]/td["+j+"]";
                row_wise_data = row_wise_data + driver.findElement(By.xpath(xpath)).getText()+" | ";
            }
            System.out.println(row_wise_data);
        }
        
        driver.quit();
        
    }

}
