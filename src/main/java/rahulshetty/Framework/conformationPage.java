package rahulshetty.Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractpack.Abstract;

public class conformationPage extends Abstract {
	WebDriver driver;
	public conformationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(css="hero-primary")
	WebElement text;
	//hero-primary
	public String getConformation()
	{
		return text.getText();
	}
}
