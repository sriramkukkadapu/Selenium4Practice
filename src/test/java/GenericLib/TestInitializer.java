package GenericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import PageObjects.UserHome;
import PageObjects.WebsiteHome;

public class TestInitializer {

	protected WebDriver driver;
	protected Utils utils=new Utils();
	Driver driverCLassObj=new Driver();
	
	//Page Factory Objects
	protected WebsiteHome websiteHome;
	protected UserHome userHome;
	
	public void initializePageFactories(WebDriver driver){
	
	//Initializing all Page factory related objects
	websiteHome=PageFactory.initElements(driver, WebsiteHome.class);
	userHome=PageFactory.initElements(driver, UserHome.class);
	}
	
@BeforeClass
public void beforeClass()
{
	driver=driverCLassObj.openBrowser();
	initializePageFactories(driver);
	
	
	String currentWindow = driver.getWindowHandle();
	driver.switchTo().window(currentWindow);
	
	initializePageFactories(driver);
	driver.navigate().to("https://www.flipkart.com");
	utils.waitForPageToLoad(driver);
	websiteHome.getLoginPopupCloseBtn().click();
}

@AfterClass(alwaysRun=true)
public void afterClass() throws InterruptedException

{
	Thread.sleep(2000);
	driverCLassObj.closeBrowser(driver);
}


@AfterMethod(alwaysRun=true)
public void afterTest() throws InterruptedException {
	//logout only if user link is displayed(means if user is loggedin)
	if(userHome.isUsernameLinkDisplayed(driver, "Sriram")) {
	Actions actions=new Actions(driver);
	actions.moveToElement(userHome.getUsernameLink(driver, "Sriram")).build().perform();
	
	utils.waitForElementPresent(driver, userHome.getLogoutBtn());
	userHome.getLogoutBtn().click();
	utils.waitForPageToLoad(driver);
	Thread.sleep(2000);
	}
}
}
