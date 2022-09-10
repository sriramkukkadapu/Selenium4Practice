package FrameworkRahulshetty.TestClasses;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import FrameworkRahulshetty.PageObjects.LoginPage;
import FrameworkRahulshetty.PageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserJourney {
	
	public static void main(String args[] ) throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String url = "https://rahulshettyacademy.com/client/";
		
		//sriramkukkadapu@gmail.com/Test1234!
		
		//driver.get(url);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo(url);
		loginPage.loginToTheApp("sriramkukkadapu@gmail.com", "Test1234!");
		
		
		ProductCatalogue prodCat = new ProductCatalogue(driver);
		List<WebElement> products = prodCat.getProductsList();
		prodCat.addProductToCart("ZARA COAT 3");
		
//		
//		
////		driver.findElement(By.xpath("//b[text()='adidas original']/../..//button[2]")).click();
////		
////		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
////		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
//		
//		//.ng-animating
//		
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement()));
//		
//		//goto cart
//		driver.findElement(By.cssSelector("button[routerLink=\"/dashboard/cart\"]")).click();
//		
//		
//		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//		
//		Boolean check = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase("adidas original"));
//		
//		Assert.assertTrue(check);
//		
//		driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
//		
////		Thread.sleep(10000);
//		
//		Actions actions = new Actions(driver);
//		
//		actions.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "India").build().perform();
//		
//		driver.findElement(By.xpath("//span[normalize-space()='India']")).click();
//		
//		driver.findElement(By.cssSelector(".action__submit")).click();
//		
//		String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		
//		Assert.assertEquals(confirmMsg, "THANKYOU FOR THE ORDER.");
//		
		
		driver.quit();
	}

}
