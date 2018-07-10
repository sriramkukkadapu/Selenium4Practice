package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserHome {


//Username link
public WebElement getUsernameLink(WebDriver driver,String username)
{
	String locator="//div[text()='"+username+"']";
	WebElement ele=driver.findElement(By.xpath(locator));
	return ele;
}
public boolean isUsernameLinkDisplayed(WebDriver driver,String username)
{
	try {
		String locator="//div[text()='"+username+"']";
		WebElement ele=driver.findElement(By.xpath(locator));
	return true;
	}
	catch(Exception e) {
	return false; }
}

@FindBy(xpath="//div[text()='Logout']")
private WebElement logoutBtn;
public WebElement getLogoutBtn()
{
	return logoutBtn;
}

}
