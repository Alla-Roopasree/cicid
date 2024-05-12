package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulsheetyacademy.testcomponents.base;
import rahulshetty.Framework.Cartpage;
import rahulshetty.Framework.Checkout;
import rahulshetty.Framework.Landingpage;
import rahulshetty.Framework.Productcatalogue;
import rahulshetty.Framework.conformationPage;

public class Stepdefimpl extends base {
	public Productcatalogue prod;
	public List<WebElement> products;
	public conformationPage conpage;
	@Given("landed on ecomerce page")
	public Landingpage landeed_on_ecommerce_page() throws IOException
	{
		launchApplication();
		return landing; 
	}
	@Given("^enter username <.+> and password <.+>$")
	public void enter_username_and_password(String username,String Password)
	{
		prod=landing.signup(username,Password);
	}
	@When("^add the product <.+> to cart$")
	public void add_the_product_to_cart(String productName) {
		products=prod.getProducts();
		//prod.getItems("ZARA CODE 3");
		prod.SelectProd(productName);
		//prod.SelectProd("ProductName");

	}
	@And("^check out <.+> and submit the product$")
	public void checkout_and_submit_the_product(String ProductName)
	{
		Cartpage cp=prod.goToCart();
		//WebDriver driver=null;
		//=new Cartpage(driver);
		//Boolean result=cp.getProducts("ProductName");
		Boolean result=cp.getProducts(ProductName);
		Assert.assertTrue(result);
		//Assert.assertTrue(result);
		Checkout ckout=cp.checkout1();
		ckout.getCountry("india");
		conpage=ckout.placeorder();

	}
	@Then("{string} verify the message is displayed")
	public void verify_the_message_is_displayed(String string)
	{
		String text=conpage.getConformation();
		Assert.assertEquals("Thankyou for the order",text);	
	}
	//use tidy gerkin for generating the stepdefinations
	@Then("{string} verify this message")
	public void verify_this_message(String string)
	{
		//landing.signup("rooparee@gmail.com","Roopasree@00");
		Assert.assertEquals("invalid username or password",landing.geterrorMsg());
		driver.close();
}
}
