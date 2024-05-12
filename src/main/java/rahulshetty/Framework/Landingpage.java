package rahulshetty.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractpack.Abstract;

public class Landingpage extends Abstract {
	WebDriver driver;
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement LoginButton;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public Productcatalogue signup(String user,String password1)
	{
		username.sendKeys(user);
		password.sendKeys(password1);
		LoginButton.click();
		Productcatalogue productcatalogue = new Productcatalogue(driver);
		return productcatalogue;
	}
	public void goTO()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String geterrorMsg()
	{
		waitfortoaster(errorMessage);
		return errorMessage.getText();	
	}
}
