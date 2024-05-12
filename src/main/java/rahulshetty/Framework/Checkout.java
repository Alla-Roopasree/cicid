package rahulshetty.Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractpack.Abstract;

public class Checkout extends Abstract {
WebDriver driver;
	public Checkout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".form-group input")
	WebElement country;
	@FindBy(xpath="//button[contains(@class,'ta-items')][2]")
	WebElement button;
	@FindBy(css=".action__submit")
	WebElement submit;
	By find=By.cssSelector("ta-results");
	//@FindBy()
	
public void getCountry(String count)
{
	country.sendKeys(count);
	//ta-results 
	waitfortoaster(find);
	button.click();
	
}
//public conformationPage  placeorder()
//{
//	submit.click();
//	return new conformationPage(driver);
//}
public conformationPage placeorder() {
	// TODO Auto-generated method stub
	submit.click();
	return new conformationPage(driver);
}
}
//.form-group input
//input txt text-validated