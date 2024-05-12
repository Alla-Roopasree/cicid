package rahulshetty.Framework;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import abstractpack.Orders;
import rahulsheetyacademy.testcomponents.base;

//import dev.failsafe.internal.util.Assert;

public class Submitordertest extends base {
    @Test(dataProvider="getData", groups="purchase")
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
	//public void submitOrder(String email, String password, String ProductName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//WebDriver driver=new ChromeDriver();
		//WebDriver driver=new ChromeDriver();
		//Landingpage landing= launchApplication();	
//Landingpage landing=launchApplication();
//Landingpage landing;
    	launchApplication() ;
    	Productcatalogue prod=landing.signup(input.get("email"),input.get("password"));
    	
//Productcatalogue prod=landing.signup(email,password);

List<WebElement> products=prod.getProducts();
//prod.getItems("ZARA CODE 3");
prod.SelectProd(input.get("ProductName"));
//prod.SelectProd("ProductName");

Cartpage cp=prod.goToCart();
//WebDriver driver=null;
//=new Cartpage(driver);
//Boolean result=cp.getProducts("ProductName");
Boolean result=cp.getProducts(input.get("ProductName"));
Assert.assertTrue(result);
//Assert.assertTrue(result);
Checkout ckout=cp.checkout1();
ckout.getCountry("india");
conformationPage conpage=ckout.placeorder();
String text=conpage.getConformation();
Assert.assertEquals("Thankyou for the order",text);
	}
   // @DependsOnMethod()
 @Test(dependsOnMethods= {"submitOrder()"})
public void orderTest()
{
	 //Boolean value=
	Productcatalogue prod=(Productcatalogue) landing.signup("roopasree@gmail.com", "Roopasree@00");
	 Orders order=prod.goToOrders();
	 Boolean match=order.veriyOrderDisplay("ZARA COAT 3");
	Assert.assertTrue(match);
}
	@DataProvider
	public Object[][] getData() throws IOException
	{
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "roopasree@gmail.com");
//		map.put("password", "Roopasree@00");
//		map.put("product", "ZARA COAT 3");
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "sam@gmail.com");
//		map1.put("password", "sam");
//		map1.put("product", "ADIDAS ORGINAL");
//		return new Object[][] {{map},{map1}};
		String filepath=System.getProperty("user.dir")+"//src//test//java//rahulheetyacademyJson//data";
		List<HashMap<String,String>> list=getDatafromJson(filepath);
		return new Object[][] {{list.get(0)},{list.get(1)}};
		//return new Object[][] {{"roopasree@gmail.com","Roopasree@00","ZARA COAT 3"},{"sam@gmail.com","sam","ADIDAS ORGINAL"}};
	}
//	public File getScreenshot(String testcaseName) throws IOException
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File Source=ts.getScreenshotAs(OutputType.FILE);
//		File des=new File(System.getProperty("user.dir")+"//reports"+testcaseName+".png");
//		FileUtils.copyFile(Source,des);
//		return des;
//	}
}
