package Tests;

import org.openqa.selenium.WebDriver;

import GenericLib.Driver;

public class DriverCheck {

	public static void main(String args[])
	{
		Driver driverClassObj=new Driver();
		WebDriver driver=driverClassObj.openBrowser();
		
		driverClassObj.closeBrowser(driver);
		//dummy comment
	}
}
