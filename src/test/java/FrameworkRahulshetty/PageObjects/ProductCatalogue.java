package FrameworkRahulshetty.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkRahulshetty.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductsList() {
		waitForElementToBeVisible(productsBy);
		return products;
	}
	
	
	public WebElement getProductByName(String prodName) {
		WebElement prodEle = getProductsList().stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst().orElse(null);
		
		return prodEle;
	}

	public void addProductToCart(String prodName) {
		WebElement product = getProductByName(prodName);
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		waitForElementToBeVisible(toastMessage);
		waitForElementToBeInVisible(spinner);
	}
}
