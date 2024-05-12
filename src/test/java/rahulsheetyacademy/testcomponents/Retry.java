package rahulsheetyacademy.testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
int c=0;
int maxcount=1;
	@Override
	public boolean retry(ITestResult result) {
		if(c<maxcount)
		{
			c++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
