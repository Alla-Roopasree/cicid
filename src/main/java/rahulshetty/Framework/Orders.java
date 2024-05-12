package rahulshetty.Framework;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractpack.Abstract;

public class Orders extends Abstract {
	WebDriver driver;
	public Orders(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
@FindBy(css="tr td:nth-child(3)")
	List<WebElement> products;
@FindBy(css="totalRow button")
WebElement checkOutEle;

public Boolean veriyOrderDisplay(String ProductName)
{
	Boolean match=products.stream().anyMatch(prod->prod.getText().equalsIgnoreCase(ProductName));
	return match;
}

//	public Orders(WebDriver driver) {
//		// TODO Auto-generated constructor stub
//	}

}
