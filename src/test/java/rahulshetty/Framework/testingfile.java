package rahulshetty.Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulsheetyacademy.testcomponents.base;

public class testingfile extends base {
@Test
	public void submitOrder()
	{
	landing.signup("roopasree@gmil.com", "Roopasree@00");
    String error=landing.geterrorMsg();
    Assert.assertEquals("Incorrect email or password",error);
	}
}
