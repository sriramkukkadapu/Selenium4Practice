package FrameworkWithoutPageFactoryParallelMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLogin  {
	
	WebDriver driver;
	WebDriverWait wait;
	Helper helper;
	
	public PageLogin(WebDriver driverArg) {
		this.driver = driverArg;
		helper = new Helper();
		wait = helper.setupWait(this.driver);
	}
	
	By userEmail = By.id("userEmail");
	By userPassword = By.id("userPassword");
	By loginBtn = By.id("login");
	
	
	public void loginToApp(String email, String password) {
		helper.waitForElementDisplayed(loginBtn);
		helper.setValue(userEmail, email);
		helper.setValue(userPassword, password);
		helper.click(loginBtn);
	}

	
}
