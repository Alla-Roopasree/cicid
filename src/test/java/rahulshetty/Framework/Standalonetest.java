package rahulshetty.Framework;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Standalonetest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("roopasree@gmail.com");
		
		driver.findElement(By.id("userPassword")).sendKeys("Roopasree@00");
		
		driver.findElement(By.id("login")).click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		//list.stream().System.out.println();
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		//wait until the toster willdisaper and enable
		//toast-container
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		//System.out.println(prod);
		//Thread.sleep(5);
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		Thread.sleep(5);

List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
Boolean flag=cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase("ZARA COAT 3"));
Assert.assertTrue(flag);
driver.findElement(By.cssSelector(".totalRow button")).click();
	}

}