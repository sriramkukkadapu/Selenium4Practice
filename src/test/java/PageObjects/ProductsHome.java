package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsHome {

	public ProductsHome(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@placeholder='Search for Vegetables and Fruits']")
	public WebElement  searchBox;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement  searchButton;
	
	
	
	public void enterTextInSearchBox(String text) {
		searchBox.sendKeys(text);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	
	
	
}
