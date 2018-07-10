package Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import GenericLib.TestInitializer;

public class LoginTest extends TestInitializer {
	
  @Test
  public void loginTest_ValidCase() throws InterruptedException {
	  Reporter.log("Clicking Login&SignUp link",true);
	  websiteHome.getLoginSignupLink().click();
	  utils.waitForElementClickable(driver, websiteHome.getEmailTextbox());
	  Reporter.log("Entering email",true);
	  websiteHome.getEmailTextbox().sendKeys("sriramkukkadapu@gmail.com");
	  Reporter.log("Entering password",true);
	  
	  websiteHome.getPasswordTextbox().sendKeys("sriramk1");
	  Reporter.log("Clicking Login button",true);
	  websiteHome.getLoginButton().click();
	  Reporter.log("Verifying Login Successful or not",true);
	  
	  utils.waitForPageToLoad(driver);
	  driver.navigate().refresh();
	  if(websiteHome.loginSignUpLinkIsDisplayed() == false) //means login is succesful
		  Reporter.log("Login Success",true);
	  
	  
  }
  
  @Test
  public void loginTest_InValidCase() throws InterruptedException {
	  Reporter.log("Clicking Login&SignUp link",true);
	  websiteHome.getLoginSignupLink().click();
	  utils.waitForElementClickable(driver, websiteHome.getEmailTextbox());
	  Reporter.log("Entering email",true);
	  websiteHome.getEmailTextbox().sendKeys("invalid@gmail.com");
	  Reporter.log("Entering password",true);
	  websiteHome.getPasswordTextbox().sendKeys("invalid");
	  Reporter.log("Clicking Login button",true);
	  websiteHome.getLoginButton().click();
	  Reporter.log("Verifying Login Successful or not",true);
	  
	  utils.waitForPageToLoad(driver);
	  //driver.navigate().refresh();
	  if(websiteHome.getLoginButton().isDisplayed() ) //means login failed(for invalid details)
		  Reporter.log("Login Failed - Invalid login details - Test Passed",true);
	  Thread.sleep(2000);
	  driver.navigate().refresh();
	  
  }
}
