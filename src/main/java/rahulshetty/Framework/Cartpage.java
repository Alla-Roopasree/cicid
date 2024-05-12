package rahulshetty.Framework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage {
	WebDriver driver;
public Cartpage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(css=".cartSection h3")
List<WebElement> products;
@FindBy(id=".totalRow button")
WebElement checkoutButton;
public Boolean getProducts(String prod)
{
	
	Boolean match=products.stream().anyMatch(product->product.getText().equalsIgnoreCase(prod));
return match;
}
public Checkout  checkout1()
{
	checkoutButton.click();
	return new Checkout(driver);
}
}
