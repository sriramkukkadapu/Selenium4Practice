package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import GenericLib.DriverManager;
import PageObjects.ProductsHome;

public class FrameWorkTestWithBaseClass extends TestBase {

	
	
	@Test
	public void test() throws InterruptedException {
		ProductsHome homePage=new ProductsHome(driver);
		homePage.enterTextInSearchBox("broco");
		homePage.clickOnSearchButton();
	}
	
	

}
