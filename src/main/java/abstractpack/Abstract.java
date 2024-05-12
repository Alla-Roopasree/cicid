package abstractpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshetty.Framework.Cartpage;
import rahulshetty.Framework.Orders;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class Abstract {

	//private static final Order Order = null;
	WebDriver driver;
	public Abstract(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
	@FindBy(css="[routerlink*='myorders']")
	WebElement orders;
	public void waitForElements(By findBy)
	{
		
			//By findBy;
		//	wait.until(ExpectedConditions)
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitfortoaster(By element)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		
	}
	public void waitfortoaster(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitforspinnerdisapear(WebElement spinner)
	{
		wait.until(ExpectedConditions.invisibilityOf(spinner));
	}
	public Cartpage goToCart()
	{
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		cart.click();
		
		return  new Cartpage(driver);
		
	}
	public Orders goToOrders()
	{
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		orders.click();
		
		return new Orders(driver);	
	}
}
