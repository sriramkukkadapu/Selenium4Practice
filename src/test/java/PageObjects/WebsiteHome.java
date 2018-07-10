package PageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebsiteHome {

//login button
	@FindBy(xpath="//button[@type='submit']/span[text()='Login']/..")
	private WebElement loginButton;
	public WebElement getLoginButton()
	{
		return loginButton;
	}
	

//email textbox
@FindBy(xpath="//span[text()='Enter Email/Mobile number']/../../input")
private WebElement emailTextbox;
public WebElement getEmailTextbox()
{
	return emailTextbox;
}

//password textbox
@FindBy(xpath="//input[@type='password']")
private WebElement passwordTextbox;
public WebElement getPasswordTextbox()
{
	return passwordTextbox;
}

//login & sign up link
@FindBy(xpath="//a[@href='/account/login?ret=/']")
private WebElement loginSignupLink;
public WebElement getLoginSignupLink()
{
	return loginSignupLink;
}
public boolean loginSignUpLinkIsDisplayed() {
    try {
        this.loginSignupLink.getTagName();
        return true;
    } catch (NoSuchElementException e) {
        //e.printStackTrace();
        return false;
    }
}
	
//close button for login & sign up pop-up
@FindBy(xpath="//button[text()='✕']")
private WebElement loginPopupCloseBtn;
public WebElement getLoginPopupCloseBtn()
{
	return loginPopupCloseBtn;
}


}
