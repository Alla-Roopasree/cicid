package rahulshetty.Framework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulsheetyacademy.testcomponents.Retry;
import rahulsheetyacademy.testcomponents.base;
 

public class Errorvalidationtest extends base{
	@Test(groups="errorHandling" ,retryAnalyzer=Retry.class)
	public void errorValidation() throws IOException{
	//launchApplication();
	landing.signup("rooparee@gmail.com","Roopasree@00");
	Assert.assertEquals("wrong",landing.geterrorMsg());
}
	@Test
	public void ProductCatalougeCheck()
	{
		Productcatalogue prod=landing.signup("roopasree@gmail.com", "Roopasree@00");
		List<WebElement> products=prod.getProducts();
		//prod.getItems("ZARA CODE 3");
		prod.SelectProd("ZARA CODE 3");
		prod.goToCart();
		//WebDriver driver=null;
		Cartpage cp=new Cartpage(driver);
		Boolean result=cp.getProducts("ZARA CODE 3");
		Assert.assertTrue(result);
	}
	
}
