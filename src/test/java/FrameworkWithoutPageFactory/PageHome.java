package FrameworkWithoutPageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageHome  {
	
	WebDriver driver;
	WebDriverWait wait;
	Helper helper;
	
	public PageHome(WebDriver driverArg) {
		this.driver = driverArg;
		helper = new Helper();
		wait = helper.setupWait(this.driver);
	}
	
	By practiteTitle = By.xpath("//p[text()=\"Automation Practice\"]");
	
	
	public void verifyHomePageLaunched() {
		Assert.assertEquals(helper.isDisplayed(practiteTitle), true);
	}
	
	public void verifyHomePageNotLaunched() {
		Assert.assertEquals(helper.isDisplayed(practiteTitle), false);
	}

	
}
