package FrameworkRahulshetty.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkRahulshetty.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;	
	
	public void loginToTheApp(String emailId,String password) {
		userEmail.sendKeys(emailId);
		userPassword.sendKeys(password);
		submit.click();
	}
	
	public void goTo(String url) {
		driver.get(url);
	}


}
