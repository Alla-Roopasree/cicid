package rahulshetty.Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import abstractpack.Abstract;

//import abstractpack.Abstract;

public class Productcatalogue extends Abstract {

WebDriver driver;
	public Productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
	By find=By.cssSelector(".mb-3");
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By element=By.cssSelector("#toast-container");
	public  List<WebElement> getProducts()
	{
		waitForElements(find);
		return products;
	}
	public WebElement getItems(String product1)
	{
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(product)).findFirst().orElse(null);
	return prod;
	}
	public void SelectProd(String product)
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		WebElement prod=getItems(product);
		prod.findElement(By.cssSelector(".cart-body button:last-of-type")).click();
		waitfortoaster(element);
		waitforspinnerdisapear(spinner);	
	}
}
